
// ===== FILE: com/google/crypto/tink/subtle/AesCtrHmacStreaming.java =====
package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesCtrHmacStreaming extends NonceBasedStreamingAead {
    private static final int HMAC_KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlgo;
    private final byte[] ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;
    private final String tagAlgo;
    private final int tagSizeInBytes;

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ ReadableByteChannel newDecryptingChannel(ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newDecryptingChannel(ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ InputStream newDecryptingStream(InputStream ciphertextStream, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newDecryptingStream(ciphertextStream, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ WritableByteChannel newEncryptingChannel(WritableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newEncryptingChannel(ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ OutputStream newEncryptingStream(OutputStream ciphertext, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newEncryptingStream(ciphertext, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel ciphertextSource, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newSeekableDecryptingChannel(ciphertextSource, associatedData);
    }

    public AesCtrHmacStreaming(byte[] ikm, String hkdfAlgo, int keySizeInBytes, String tagAlgo, int tagSizeInBytes, int ciphertextSegmentSize, int firstSegmentOffset) throws InvalidAlgorithmParameterException {
        validateParameters(ikm.length, keySizeInBytes, tagAlgo, tagSizeInBytes, ciphertextSegmentSize, firstSegmentOffset);
        this.ikm = Arrays.copyOf(ikm, ikm.length);
        this.hkdfAlgo = hkdfAlgo;
        this.keySizeInBytes = keySizeInBytes;
        this.tagAlgo = tagAlgo;
        this.tagSizeInBytes = tagSizeInBytes;
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.firstSegmentOffset = firstSegmentOffset;
        this.plaintextSegmentSize = ciphertextSegmentSize - tagSizeInBytes;
    }

    private static void validateParameters(int ikmSize, int keySizeInBytes, String tagAlgo, int tagSizeInBytes, int ciphertextSegmentSize, int firstSegmentOffset) throws InvalidAlgorithmParameterException {
        if (ikmSize < 16 || ikmSize < keySizeInBytes) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, keySizeInBytes));
        }
        Validators.validateAesKeySize(keySizeInBytes);
        if (tagSizeInBytes < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small " + tagSizeInBytes);
        }
        if ((tagAlgo.equals("HmacSha1") && tagSizeInBytes > 20) || ((tagAlgo.equals("HmacSha256") && tagSizeInBytes > 32) || (tagAlgo.equals("HmacSha512") && tagSizeInBytes > 64))) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        if (((((ciphertextSegmentSize - firstSegmentOffset) - tagSizeInBytes) - keySizeInBytes) - 7) - 1 <= 0) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamEncrypter newStreamSegmentEncrypter(byte[] aad) throws GeneralSecurityException {
        return new AesCtrHmacStreamEncrypter(aad);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return new AesCtrHmacStreamDecrypter();
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return this.keySizeInBytes + 1 + 7;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return this.tagSizeInBytes;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    public long expectedCiphertextSize(long plaintextSize) {
        long ciphertextOffset = plaintextSize + getCiphertextOffset();
        int i = this.plaintextSegmentSize;
        long j = (ciphertextOffset / i) * this.ciphertextSegmentSize;
        long j2 = ciphertextOffset % i;
        return j2 > 0 ? j + j2 + this.tagSizeInBytes : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherInstance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mac macInstance() throws GeneralSecurityException {
        return EngineFactory.MAC.getInstance(this.tagAlgo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] nonceForSegment(byte[] bArr, long j, boolean z) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(bArr);
        SubtleUtil.putAsUnsigedInt(allocate, j);
        allocate.put(z ? (byte) 1 : (byte) 0);
        allocate.putInt(0);
        return allocate.array();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomNonce() {
        return Random.randBytes(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] deriveKeyMaterial(byte[] salt, byte[] aad) throws GeneralSecurityException {
        return Hkdf.computeHkdf(this.hkdfAlgo, this.ikm, salt, aad, this.keySizeInBytes + 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] keyMaterial) throws GeneralSecurityException {
        return new SecretKeySpec(keyMaterial, 0, this.keySizeInBytes, "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveHmacKeySpec(byte[] keyMaterial) throws GeneralSecurityException {
        return new SecretKeySpec(keyMaterial, this.keySizeInBytes, 32, this.tagAlgo);
    }

    class AesCtrHmacStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher = AesCtrHmacStreaming.cipherInstance();
        private long encryptedSegments;
        private ByteBuffer header;
        private final SecretKeySpec hmacKeySpec;
        private final SecretKeySpec keySpec;
        private final Mac mac;
        private final byte[] noncePrefix;

        public AesCtrHmacStreamEncrypter(byte[] aad) throws GeneralSecurityException {
            this.encryptedSegments = 0L;
            this.mac = AesCtrHmacStreaming.this.macInstance();
            this.encryptedSegments = 0L;
            byte[] randomSalt = AesCtrHmacStreaming.this.randomSalt();
            byte[] randomNonce = AesCtrHmacStreaming.this.randomNonce();
            this.noncePrefix = randomNonce;
            ByteBuffer allocate = ByteBuffer.allocate(AesCtrHmacStreaming.this.getHeaderLength());
            this.header = allocate;
            allocate.put((byte) AesCtrHmacStreaming.this.getHeaderLength());
            this.header.put(randomSalt);
            this.header.put(randomNonce);
            this.header.flip();
            byte[] deriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(randomSalt, aad);
            this.keySpec = AesCtrHmacStreaming.this.deriveKeySpec(deriveKeyMaterial);
            this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(deriveKeyMaterial);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer plaintext, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            int position = ciphertext.position();
            byte[] nonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, isLastSegment);
            this.cipher.init(1, this.keySpec, new IvParameterSpec(nonceForSegment));
            this.encryptedSegments++;
            this.cipher.doFinal(plaintext, ciphertext);
            ByteBuffer duplicate = ciphertext.duplicate();
            duplicate.flip();
            duplicate.position(position);
            this.mac.init(this.hmacKeySpec);
            this.mac.update(nonceForSegment);
            this.mac.update(duplicate);
            ciphertext.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer part1, ByteBuffer part2, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            int position = ciphertext.position();
            byte[] nonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, isLastSegment);
            this.cipher.init(1, this.keySpec, new IvParameterSpec(nonceForSegment));
            this.encryptedSegments++;
            this.cipher.update(part1, ciphertext);
            this.cipher.doFinal(part2, ciphertext);
            ByteBuffer duplicate = ciphertext.duplicate();
            duplicate.flip();
            duplicate.position(position);
            this.mac.init(this.hmacKeySpec);
            this.mac.update(nonceForSegment);
            this.mac.update(duplicate);
            ciphertext.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
        }
    }

    class AesCtrHmacStreamDecrypter implements StreamSegmentDecrypter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cipher cipher;
        private SecretKeySpec hmacKeySpec;
        private SecretKeySpec keySpec;
        private Mac mac;
        private byte[] noncePrefix;

        AesCtrHmacStreamDecrypter() {
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void init(ByteBuffer header, byte[] aad) throws GeneralSecurityException {
            if (header.remaining() != AesCtrHmacStreaming.this.getHeaderLength()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            }
            if (header.get() != AesCtrHmacStreaming.this.getHeaderLength()) {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
            this.noncePrefix = new byte[7];
            byte[] bArr = new byte[AesCtrHmacStreaming.this.keySizeInBytes];
            header.get(bArr);
            header.get(this.noncePrefix);
            byte[] deriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(bArr, aad);
            this.keySpec = AesCtrHmacStreaming.this.deriveKeySpec(deriveKeyMaterial);
            this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(deriveKeyMaterial);
            this.cipher = AesCtrHmacStreaming.cipherInstance();
            this.mac = AesCtrHmacStreaming.this.macInstance();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void decryptSegment(ByteBuffer ciphertext, int segmentNr, boolean isLastSegment, ByteBuffer plaintext) throws GeneralSecurityException {
            int position = ciphertext.position();
            byte[] nonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, segmentNr, isLastSegment);
            int remaining = ciphertext.remaining();
            if (remaining >= AesCtrHmacStreaming.this.tagSizeInBytes) {
                int i = position + (remaining - AesCtrHmacStreaming.this.tagSizeInBytes);
                ByteBuffer duplicate = ciphertext.duplicate();
                duplicate.limit(i);
                ByteBuffer duplicate2 = ciphertext.duplicate();
                duplicate2.position(i);
                this.mac.init(this.hmacKeySpec);
                this.mac.update(nonceForSegment);
                this.mac.update(duplicate);
                byte[] copyOf = Arrays.copyOf(this.mac.doFinal(), AesCtrHmacStreaming.this.tagSizeInBytes);
                byte[] bArr = new byte[AesCtrHmacStreaming.this.tagSizeInBytes];
                duplicate2.get(bArr);
                if (!Bytes.equal(bArr, copyOf)) {
                    throw new GeneralSecurityException("Tag mismatch");
                }
                ciphertext.limit(i);
                this.cipher.init(1, this.keySpec, new IvParameterSpec(nonceForSegment));
                this.cipher.doFinal(ciphertext, plaintext);
            } else {
                throw new GeneralSecurityException("Ciphertext too short");
            }
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/AesCtrJceCipher.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesCtrJceCipher implements IndCpaCipher {
    private static final String CIPHER_ALGORITHM = "AES/CTR/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesCtrJceCipher.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance(AesCtrJceCipher.CIPHER_ALGORITHM);
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private final int blockSize;
    private final int ivSize;
    private final SecretKeySpec keySpec;

    public AesCtrJceCipher(final byte[] key, int ivSize) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        int blockSize = localCipher.get().getBlockSize();
        this.blockSize = blockSize;
        if (ivSize < 12 || ivSize > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.ivSize = ivSize;
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        int length = plaintext.length;
        int i = this.ivSize;
        if (length > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.ivSize));
        }
        byte[] bArr = new byte[plaintext.length + i];
        byte[] randBytes = Random.randBytes(i);
        System.arraycopy(randBytes, 0, bArr, 0, this.ivSize);
        doCtr(plaintext, 0, plaintext.length, bArr, this.ivSize, randBytes, true);
        return bArr;
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        int length = ciphertext.length;
        int i = this.ivSize;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(ciphertext, 0, bArr, 0, i);
        int length2 = ciphertext.length;
        int i2 = this.ivSize;
        byte[] bArr2 = new byte[length2 - i2];
        doCtr(ciphertext, i2, ciphertext.length - i2, bArr2, 0, bArr, false);
        return bArr2;
    }

    private void doCtr(final byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset, final byte[] iv, boolean encrypt) throws GeneralSecurityException {
        Cipher cipher = localCipher.get();
        byte[] bArr = new byte[this.blockSize];
        System.arraycopy(iv, 0, bArr, 0, this.ivSize);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        if (encrypt) {
            cipher.init(1, this.keySpec, ivParameterSpec);
        } else {
            cipher.init(2, this.keySpec, ivParameterSpec);
        }
        if (cipher.doFinal(input, inputOffset, inputLen, output, outputOffset) != inputLen) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/AesEaxJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class AesEaxJce implements Aead {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BLOCK_SIZE_IN_BYTES = 16;
    static final int TAG_SIZE_IN_BYTES = 16;

    /* renamed from: b */
    private final byte[] f197b;
    private final int ivSizeInBytes;
    private final SecretKeySpec keySpec;

    /* renamed from: p */
    private final byte[] f198p;
    private static final ThreadLocal<Cipher> localEcbCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    public AesEaxJce(final byte[] key, int ivSizeInBytes) throws GeneralSecurityException {
        if (ivSizeInBytes != 12 && ivSizeInBytes != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.ivSizeInBytes = ivSizeInBytes;
        Validators.validateAesKeySize(key.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        this.keySpec = secretKeySpec;
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, secretKeySpec);
        byte[] multiplyByX = multiplyByX(cipher.doFinal(new byte[16]));
        this.f197b = multiplyByX;
        this.f198p = multiplyByX(multiplyByX);
    }

    private static byte[] xor(final byte[] x, final byte[] y) {
        int length = x.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (x[i] ^ y[i]);
        }
        return bArr;
    }

    private static byte[] multiplyByX(final byte[] block) {
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr[i] = (byte) (((block[i] << 1) ^ ((block[i2] & UByte.MAX_VALUE) >>> 7)) & 255);
            i = i2;
        }
        bArr[15] = (byte) ((block[15] << 1) ^ ((block[0] & ByteCompanionObject.MIN_VALUE) != 0 ? 135 : 0));
        return bArr;
    }

    private byte[] pad(final byte[] data) {
        if (data.length == 16) {
            return xor(data, this.f197b);
        }
        byte[] copyOf = Arrays.copyOf(this.f198p, 16);
        for (int i = 0; i < data.length; i++) {
            copyOf[i] = (byte) (copyOf[i] ^ data[i]);
        }
        copyOf[data.length] = (byte) (copyOf[data.length] ^ ByteCompanionObject.MIN_VALUE);
        return copyOf;
    }

    private byte[] omac(Cipher ecb, int tag, final byte[] data, int offset, int length) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr = new byte[16];
        bArr[15] = (byte) tag;
        if (length == 0) {
            return ecb.doFinal(xor(bArr, this.f197b));
        }
        byte[] doFinal = ecb.doFinal(bArr);
        int i = 0;
        while (length - i > 16) {
            for (int i2 = 0; i2 < 16; i2++) {
                doFinal[i2] = (byte) (doFinal[i2] ^ data[(offset + i) + i2]);
            }
            doFinal = ecb.doFinal(doFinal);
            i += 16;
        }
        return ecb.doFinal(xor(doFinal, pad(Arrays.copyOfRange(data, i + offset, offset + length))));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        int length = plaintext.length;
        int i = this.ivSizeInBytes;
        if (length > (Integer.MAX_VALUE - i) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr = new byte[plaintext.length + i + 16];
        byte[] randBytes = Random.randBytes(i);
        System.arraycopy(randBytes, 0, bArr, 0, this.ivSizeInBytes);
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, this.keySpec);
        byte[] omac = omac(cipher, 0, randBytes, 0, randBytes.length);
        byte[] bArr2 = associatedData == null ? new byte[0] : associatedData;
        byte[] omac2 = omac(cipher, 1, bArr2, 0, bArr2.length);
        Cipher cipher2 = localCtrCipher.get();
        cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
        cipher2.doFinal(plaintext, 0, plaintext.length, bArr, this.ivSizeInBytes);
        byte[] omac3 = omac(cipher, 2, bArr, this.ivSizeInBytes, plaintext.length);
        int length2 = plaintext.length + this.ivSizeInBytes;
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[length2 + i2] = (byte) ((omac2[i2] ^ omac[i2]) ^ omac3[i2]);
        }
        return bArr;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        int length = (ciphertext.length - this.ivSizeInBytes) - 16;
        if (length < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, this.keySpec);
        byte[] omac = omac(cipher, 0, ciphertext, 0, this.ivSizeInBytes);
        if (associatedData == null) {
            associatedData = new byte[0];
        }
        byte[] bArr = associatedData;
        byte[] omac2 = omac(cipher, 1, bArr, 0, bArr.length);
        byte[] omac3 = omac(cipher, 2, ciphertext, this.ivSizeInBytes, length);
        int length2 = ciphertext.length - 16;
        byte b = 0;
        for (int i = 0; i < 16; i++) {
            b = (byte) (b | (((ciphertext[length2 + i] ^ omac2[i]) ^ omac[i]) ^ omac3[i]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = localCtrCipher.get();
        cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
        return cipher2.doFinal(ciphertext, this.ivSizeInBytes, length);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/AesGcmHkdfStreaming.java =====
package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesGcmHkdfStreaming extends NonceBasedStreamingAead {
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlg;
    private final byte[] ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return 16;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ ReadableByteChannel newDecryptingChannel(ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newDecryptingChannel(ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ InputStream newDecryptingStream(InputStream ciphertextStream, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newDecryptingStream(ciphertextStream, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ WritableByteChannel newEncryptingChannel(WritableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newEncryptingChannel(ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ OutputStream newEncryptingStream(OutputStream ciphertext, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newEncryptingStream(ciphertext, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel ciphertextSource, byte[] associatedData) throws GeneralSecurityException, IOException {
        return super.newSeekableDecryptingChannel(ciphertextSource, associatedData);
    }

    public AesGcmHkdfStreaming(byte[] ikm, String hkdfAlg, int keySizeInBytes, int ciphertextSegmentSize, int firstSegmentOffset) throws InvalidAlgorithmParameterException {
        if (ikm.length < 16 || ikm.length < keySizeInBytes) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, keySizeInBytes));
        }
        Validators.validateAesKeySize(keySizeInBytes);
        if (ciphertextSegmentSize <= getHeaderLength() + firstSegmentOffset + 16) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        this.ikm = Arrays.copyOf(ikm, ikm.length);
        this.hkdfAlg = hkdfAlg;
        this.keySizeInBytes = keySizeInBytes;
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.firstSegmentOffset = firstSegmentOffset;
        this.plaintextSegmentSize = ciphertextSegmentSize - 16;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamEncrypter newStreamSegmentEncrypter(byte[] aad) throws GeneralSecurityException {
        return new AesGcmHkdfStreamEncrypter(aad);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return new AesGcmHkdfStreamDecrypter();
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return this.keySizeInBytes + 1 + 7;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    public long expectedCiphertextSize(long plaintextSize) {
        long ciphertextOffset = plaintextSize + getCiphertextOffset();
        int i = this.plaintextSegmentSize;
        long j = (ciphertextOffset / i) * this.ciphertextSegmentSize;
        long j2 = ciphertextOffset % i;
        return j2 > 0 ? j + j2 + 16 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherInstance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GCMParameterSpec paramsForSegment(byte[] bArr, long j, boolean z) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(bArr);
        SubtleUtil.putAsUnsigedInt(allocate, j);
        allocate.put(z ? (byte) 1 : (byte) 0);
        return new GCMParameterSpec(128, allocate.array());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] randomNonce() {
        return Random.randBytes(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] salt, byte[] aad) throws GeneralSecurityException {
        return new SecretKeySpec(Hkdf.computeHkdf(this.hkdfAlg, this.ikm, salt, aad, this.keySizeInBytes), "AES");
    }

    class AesGcmHkdfStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher = AesGcmHkdfStreaming.cipherInstance();
        private long encryptedSegments;
        private final ByteBuffer header;
        private final SecretKeySpec keySpec;
        private final byte[] noncePrefix;

        public AesGcmHkdfStreamEncrypter(byte[] aad) throws GeneralSecurityException {
            this.encryptedSegments = 0L;
            this.encryptedSegments = 0L;
            byte[] randomSalt = AesGcmHkdfStreaming.this.randomSalt();
            byte[] randomNonce = AesGcmHkdfStreaming.randomNonce();
            this.noncePrefix = randomNonce;
            ByteBuffer allocate = ByteBuffer.allocate(AesGcmHkdfStreaming.this.getHeaderLength());
            this.header = allocate;
            allocate.put((byte) AesGcmHkdfStreaming.this.getHeaderLength());
            allocate.put(randomSalt);
            allocate.put(randomNonce);
            allocate.flip();
            this.keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(randomSalt, aad);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer plaintext, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, this.encryptedSegments, isLastSegment));
            this.encryptedSegments++;
            this.cipher.doFinal(plaintext, ciphertext);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer part1, ByteBuffer part2, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException {
            this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, this.encryptedSegments, isLastSegment));
            this.encryptedSegments++;
            if (part2.hasRemaining()) {
                this.cipher.update(part1, ciphertext);
                this.cipher.doFinal(part2, ciphertext);
            } else {
                this.cipher.doFinal(part1, ciphertext);
            }
        }
    }

    class AesGcmHkdfStreamDecrypter implements StreamSegmentDecrypter {
        private Cipher cipher;
        private SecretKeySpec keySpec;
        private byte[] noncePrefix;

        AesGcmHkdfStreamDecrypter() {
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void init(ByteBuffer header, byte[] aad) throws GeneralSecurityException {
            if (header.remaining() != AesGcmHkdfStreaming.this.getHeaderLength()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            }
            if (header.get() != AesGcmHkdfStreaming.this.getHeaderLength()) {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
            this.noncePrefix = new byte[7];
            byte[] bArr = new byte[AesGcmHkdfStreaming.this.keySizeInBytes];
            header.get(bArr);
            header.get(this.noncePrefix);
            this.keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(bArr, aad);
            this.cipher = AesGcmHkdfStreaming.cipherInstance();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void decryptSegment(ByteBuffer ciphertext, int segmentNr, boolean isLastSegment, ByteBuffer plaintext) throws GeneralSecurityException {
            this.cipher.init(2, this.keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, segmentNr, isLastSegment));
            this.cipher.doFinal(ciphertext, plaintext);
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/AesGcmJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesGcmJce implements Aead {
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesGcmJce.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private final SecretKey keySpec;

    public AesGcmJce(final byte[] key) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr = new byte[plaintext.length + 12 + 16];
        byte[] randBytes = Random.randBytes(12);
        System.arraycopy(randBytes, 0, bArr, 0, 12);
        AlgorithmParameterSpec params = getParams(randBytes);
        ThreadLocal<Cipher> threadLocal = localCipher;
        threadLocal.get().init(1, this.keySpec, params);
        if (associatedData != null && associatedData.length != 0) {
            threadLocal.get().updateAAD(associatedData);
        }
        int doFinal = threadLocal.get().doFinal(plaintext, 0, plaintext.length, bArr, 12);
        if (doFinal == plaintext.length + 16) {
            return bArr;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - plaintext.length)));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec params = getParams(ciphertext, 0, 12);
        ThreadLocal<Cipher> threadLocal = localCipher;
        threadLocal.get().init(2, this.keySpec, params);
        if (associatedData != null && associatedData.length != 0) {
            threadLocal.get().updateAAD(associatedData);
        }
        return threadLocal.get().doFinal(ciphertext, 12, ciphertext.length - 12);
    }

    private static AlgorithmParameterSpec getParams(final byte[] iv) throws GeneralSecurityException {
        return getParams(iv, 0, iv.length);
    }

    private static AlgorithmParameterSpec getParams(final byte[] buf, int offset, int len) throws GeneralSecurityException {
        if (SubtleUtil.isAndroid() && SubtleUtil.androidApiLevel() <= 19) {
            return new IvParameterSpec(buf, offset, len);
        }
        return new GCMParameterSpec(128, buf, offset, len);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/AesSiv.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class AesSiv implements DeterministicAead {
    private final byte[] aesCtrKey;
    private final PrfAesCmac cmacForS2V;
    private static final Collection<Integer> KEY_SIZES = Arrays.asList(64);
    private static final byte[] BLOCK_ZERO = new byte[16];
    private static final byte[] BLOCK_ONE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    public AesSiv(final byte[] key) throws GeneralSecurityException {
        if (!KEY_SIZES.contains(Integer.valueOf(key.length))) {
            throw new InvalidKeyException("invalid key size: " + key.length + " bytes; key must have 64 bytes");
        }
        byte[] copyOfRange = Arrays.copyOfRange(key, 0, key.length / 2);
        this.aesCtrKey = Arrays.copyOfRange(key, key.length / 2, key.length);
        this.cmacForS2V = new PrfAesCmac(copyOfRange);
    }

    private byte[] s2v(final byte[]... s) throws GeneralSecurityException {
        byte[] xor;
        if (s.length == 0) {
            return this.cmacForS2V.compute(BLOCK_ONE, 16);
        }
        byte[] compute = this.cmacForS2V.compute(BLOCK_ZERO, 16);
        for (int i = 0; i < s.length - 1; i++) {
            byte[] bArr = s[i];
            if (bArr == null) {
                bArr = new byte[0];
            }
            compute = Bytes.xor(AesUtil.dbl(compute), this.cmacForS2V.compute(bArr, 16));
        }
        byte[] bArr2 = s[s.length - 1];
        if (bArr2.length >= 16) {
            xor = Bytes.xorEnd(bArr2, compute);
        } else {
            xor = Bytes.xor(AesUtil.cmacPad(bArr2), AesUtil.dbl(compute));
        }
        return this.cmacForS2V.compute(xor, 16);
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] s2v = s2v(associatedData, plaintext);
        byte[] bArr = (byte[]) s2v.clone();
        bArr[8] = (byte) (bArr[8] & ByteCompanionObject.MAX_VALUE);
        bArr[12] = (byte) (bArr[12] & ByteCompanionObject.MAX_VALUE);
        engineFactory.init(1, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr));
        return Bytes.concat(s2v, engineFactory.doFinal(plaintext));
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] copyOfRange = Arrays.copyOfRange(ciphertext, 0, 16);
        byte[] bArr = (byte[]) copyOfRange.clone();
        bArr[8] = (byte) (bArr[8] & ByteCompanionObject.MAX_VALUE);
        bArr[12] = (byte) (bArr[12] & ByteCompanionObject.MAX_VALUE);
        engineFactory.init(2, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr));
        byte[] copyOfRange2 = Arrays.copyOfRange(ciphertext, 16, ciphertext.length);
        byte[] doFinal = engineFactory.doFinal(copyOfRange2);
        if (copyOfRange2.length == 0 && doFinal == null && SubtleUtil.isAndroid()) {
            doFinal = new byte[0];
        }
        if (Bytes.equal(copyOfRange, s2v(associatedData, doFinal))) {
            return doFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}

// ===== FILE: com/google/crypto/tink/subtle/AesUtil.java =====
package com.google.crypto.tink.subtle;

import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
class AesUtil {
    public static final int BLOCK_SIZE = 16;

    AesUtil() {
    }

    static byte[] dbl(final byte[] value) {
        if (value.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = (byte) ((value[i] << 1) & 254);
            bArr[i] = b;
            if (i < 15) {
                bArr[i] = (byte) (((byte) ((value[i + 1] >> 7) & 1)) | b);
            }
        }
        bArr[15] = (byte) (((byte) ((value[0] >> 7) & 135)) ^ bArr[15]);
        return bArr;
    }

    static byte[] cmacPad(final byte[] x) {
        if (x.length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] copyOf = Arrays.copyOf(x, 16);
        copyOf[x.length] = ByteCompanionObject.MIN_VALUE;
        return copyOf;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Base64.java =====
package com.google.crypto.tink.subtle;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    static abstract class Coder {

        /* renamed from: op */
        public int f199op;
        public byte[] output;

        public abstract int maxOutputSize(int len);

        public abstract boolean process(byte[] input, int offset, int len, boolean finish);

        Coder() {
        }
    }

    public static byte[] decode(String input) {
        return decode(input, 2);
    }

    public static byte[] urlSafeDecode(String input) {
        return decode(input, 11);
    }

    public static byte[] decode(String str, int flags) {
        return decode(str.getBytes(UTF_8), flags);
    }

    public static byte[] decode(byte[] input, int flags) {
        return decode(input, 0, input.length, flags);
    }

    public static byte[] decode(byte[] input, int offset, int len, int flags) {
        Decoder decoder = new Decoder(flags, new byte[(len * 3) / 4]);
        if (!decoder.process(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.f199op == decoder.output.length) {
            return decoder.output;
        }
        byte[] bArr = new byte[decoder.f199op];
        System.arraycopy(decoder.output, 0, bArr, 0, decoder.f199op);
        return bArr;
    }

    static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int flags, byte[] output) {
            this.output = output;
            this.alphabet = (flags & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int len) {
            return ((len * 3) / 4) + 10;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            int i = this.state;
            if (i == 6) {
                return false;
            }
            int i2 = len + offset;
            int i3 = this.value;
            byte[] bArr = this.output;
            int[] iArr = this.alphabet;
            int i4 = 0;
            int i5 = i3;
            int i6 = i;
            int i7 = offset;
            while (i7 < i2) {
                if (i6 == 0) {
                    while (true) {
                        int i8 = i7 + 4;
                        if (i8 > i2 || (i5 = (iArr[input[i7] & UByte.MAX_VALUE] << 18) | (iArr[input[i7 + 1] & UByte.MAX_VALUE] << 12) | (iArr[input[i7 + 2] & UByte.MAX_VALUE] << 6) | iArr[input[i7 + 3] & UByte.MAX_VALUE]) < 0) {
                            break;
                        }
                        bArr[i4 + 2] = (byte) i5;
                        bArr[i4 + 1] = (byte) (i5 >> 8);
                        bArr[i4] = (byte) (i5 >> 16);
                        i4 += 3;
                        i7 = i8;
                    }
                    if (i7 >= i2) {
                        break;
                    }
                }
                int i9 = i7 + 1;
                int i10 = iArr[input[i7] & UByte.MAX_VALUE];
                if (i6 != 0) {
                    if (i6 == 1) {
                        if (i10 < 0) {
                            if (i10 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i10 |= i5 << 6;
                    } else if (i6 == 2) {
                        if (i10 < 0) {
                            if (i10 == -2) {
                                bArr[i4] = (byte) (i5 >> 4);
                                i4++;
                                i6 = 4;
                            } else if (i10 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i10 |= i5 << 6;
                    } else if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 == 5 && i10 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i10 == -2) {
                            i6++;
                        } else if (i10 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i10 >= 0) {
                        int i11 = i10 | (i5 << 6);
                        bArr[i4 + 2] = (byte) i11;
                        bArr[i4 + 1] = (byte) (i11 >> 8);
                        bArr[i4] = (byte) (i11 >> 16);
                        i4 += 3;
                        i5 = i11;
                        i6 = 0;
                    } else if (i10 == -2) {
                        bArr[i4 + 1] = (byte) (i5 >> 2);
                        bArr[i4] = (byte) (i5 >> 10);
                        i4 += 2;
                        i6 = 5;
                    } else if (i10 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i6++;
                    i5 = i10;
                } else {
                    if (i10 < 0) {
                        if (i10 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i6++;
                    i5 = i10;
                }
                i7 = i9;
            }
            if (!finish) {
                this.state = i6;
                this.value = i5;
                this.f199op = i4;
                return true;
            }
            if (i6 == 1) {
                this.state = 6;
                return false;
            }
            if (i6 == 2) {
                bArr[i4] = (byte) (i5 >> 4);
                i4++;
            } else if (i6 == 3) {
                int i12 = i4 + 1;
                bArr[i4] = (byte) (i5 >> 10);
                i4 = i12 + 1;
                bArr[i12] = (byte) (i5 >> 2);
            } else if (i6 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i6;
            this.f199op = i4;
            return true;
        }
    }

    public static String encode(final byte[] input) {
        return encodeToString(input, 2);
    }

    public static String urlSafeEncode(final byte[] input) {
        return encodeToString(input, 11);
    }

    public static String encodeToString(byte[] input, int flags) {
        try {
            return new String(encode(input, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] input, int offset, int len, int flags) {
        try {
            return new String(encode(input, offset, len, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] input, int flags) {
        return encode(input, 0, input.length, flags);
    }

    public static byte[] encode(byte[] input, int offset, int len, int flags) {
        Encoder encoder = new Encoder(flags, null);
        int i = (len / 3) * 4;
        if (encoder.doPadding) {
            if (len % 3 > 0) {
                i += 4;
            }
        } else {
            int i2 = len % 3;
            if (i2 == 1) {
                i += 2;
            } else if (i2 == 2) {
                i += 3;
            }
        }
        if (encoder.doNewline && len > 0) {
            i += (((len - 1) / 57) + 1) * (encoder.doCr ? 2 : 1);
        }
        encoder.output = new byte[i];
        encoder.process(input, offset, len, true);
        return encoder.output;
    }

    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean doCr;
        public final boolean doNewline;
        public final boolean doPadding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int flags, byte[] output) {
            this.output = output;
            this.doPadding = (flags & 1) == 0;
            boolean z = (flags & 2) == 0;
            this.doNewline = z;
            this.doCr = (flags & 4) != 0;
            this.alphabet = (flags & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z ? 19 : -1;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int len) {
            return ((len * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        @Override // com.google.crypto.tink.subtle.Base64.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 478
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Bytes.java =====
package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Bytes {
    public static final boolean equal(final byte[] x, final byte[] y) {
        if (x == null || y == null || x.length != y.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < x.length; i2++) {
            i |= x[i2] ^ y[i2];
        }
        return i == 0;
    }

    public static byte[] concat(byte[]... chunks) throws GeneralSecurityException {
        int i = 0;
        for (byte[] bArr : chunks) {
            if (i > Integer.MAX_VALUE - bArr.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i += bArr.length;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (byte[] bArr3 : chunks) {
            System.arraycopy(bArr3, 0, bArr2, i2, bArr3.length);
            i2 += bArr3.length;
        }
        return bArr2;
    }

    public static final byte[] xor(final byte[] x, int offsetX, final byte[] y, int offsetY, int len) {
        if (len < 0 || x.length - len < offsetX || y.length - len < offsetY) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr = new byte[len];
        for (int i = 0; i < len; i++) {
            bArr[i] = (byte) (x[i + offsetX] ^ y[i + offsetY]);
        }
        return bArr;
    }

    public static final void xor(ByteBuffer output, ByteBuffer x, ByteBuffer y, int len) {
        if (len < 0 || x.remaining() < len || y.remaining() < len || output.remaining() < len) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i = 0; i < len; i++) {
            output.put((byte) (x.get() ^ y.get()));
        }
    }

    public static final byte[] xor(final byte[] x, final byte[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("The lengths of x and y should match.");
        }
        return xor(x, 0, y, 0, x.length);
    }

    public static final byte[] xorEnd(final byte[] a, final byte[] b) {
        if (a.length < b.length) {
            throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
        }
        int length = a.length - b.length;
        byte[] copyOf = Arrays.copyOf(a, a.length);
        for (int i = 0; i < b.length; i++) {
            int i2 = length + i;
            copyOf[i2] = (byte) (copyOf[i2] ^ b[i]);
        }
        return copyOf;
    }

    public static byte[] intToByteArray(int capacity, int value) {
        byte[] bArr = new byte[capacity];
        for (int i = 0; i < capacity; i++) {
            bArr[i] = (byte) ((value >> (i * 8)) & 255);
        }
        return bArr;
    }

    public static int byteArrayToInt(byte[] bytes) {
        return byteArrayToInt(bytes, bytes.length);
    }

    public static int byteArrayToInt(byte[] bytes, int length) {
        return byteArrayToInt(bytes, 0, length);
    }

    public static int byteArrayToInt(byte[] bytes, int offset, int length) {
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (bytes[i2 + offset] & 255) << (i2 * 8);
        }
        return i;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/ChaCha20.java =====
package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;

/* loaded from: classes.dex */
class ChaCha20 extends ChaCha20Base {
    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    int nonceSizeInBytes() {
        return 12;
    }

    ChaCha20(final byte[] key, int initialCounter) throws InvalidKeyException {
        super(key, initialCounter);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    int[] createInitialState(final int[] nonce, int counter) {
        if (nonce.length != nonceSizeInBytes() / 4) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(nonce.length * 32)));
        }
        int[] iArr = new int[16];
        ChaCha20Base.setSigmaAndKey(iArr, this.key);
        iArr[12] = counter;
        System.arraycopy(nonce, 0, iArr, 13, nonce.length);
        return iArr;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/ChaCha20Base.java =====
package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
abstract class ChaCha20Base implements IndCpaCipher {
    public static final int BLOCK_SIZE_IN_BYTES = 64;
    public static final int BLOCK_SIZE_IN_INTS = 16;
    public static final int KEY_SIZE_IN_BYTES = 32;
    public static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    private final int initialCounter;
    int[] key;

    private static int rotateLeft(int x, int y) {
        return (x >>> (-y)) | (x << y);
    }

    abstract int[] createInitialState(final int[] nonce, int counter);

    abstract int nonceSizeInBytes();

    ChaCha20Base(final byte[] key, int initialCounter) throws InvalidKeyException {
        if (key.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.key = toIntArray(key);
        this.initialCounter = initialCounter;
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        if (plaintext.length > Integer.MAX_VALUE - nonceSizeInBytes()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate(nonceSizeInBytes() + plaintext.length);
        encrypt(allocate, plaintext);
        return allocate.array();
    }

    void encrypt(ByteBuffer output, final byte[] plaintext) throws GeneralSecurityException {
        if (output.remaining() - nonceSizeInBytes() < plaintext.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] randBytes = Random.randBytes(nonceSizeInBytes());
        output.put(randBytes);
        process(randBytes, output, ByteBuffer.wrap(plaintext));
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(ciphertext));
    }

    byte[] decrypt(ByteBuffer ciphertext) throws GeneralSecurityException {
        if (ciphertext.remaining() < nonceSizeInBytes()) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr = new byte[nonceSizeInBytes()];
        ciphertext.get(bArr);
        ByteBuffer allocate = ByteBuffer.allocate(ciphertext.remaining());
        process(bArr, allocate, ciphertext);
        return allocate.array();
    }

    private void process(final byte[] nonce, ByteBuffer output, ByteBuffer input) throws GeneralSecurityException {
        int remaining = input.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer chacha20Block = chacha20Block(nonce, this.initialCounter + i2);
            if (i2 == i - 1) {
                Bytes.xor(output, input, chacha20Block, remaining % 64);
            } else {
                Bytes.xor(output, input, chacha20Block, 64);
            }
        }
    }

    ByteBuffer chacha20Block(final byte[] nonce, int counter) {
        int[] createInitialState = createInitialState(toIntArray(nonce), counter);
        int[] iArr = (int[]) createInitialState.clone();
        shuffleState(iArr);
        for (int i = 0; i < createInitialState.length; i++) {
            createInitialState[i] = createInitialState[i] + iArr[i];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(createInitialState, 0, 16);
        return order;
    }

    static void setSigmaAndKey(int[] state, final int[] key) {
        int[] iArr = SIGMA;
        System.arraycopy(iArr, 0, state, 0, iArr.length);
        System.arraycopy(key, 0, state, iArr.length, 8);
    }

    static void shuffleState(final int[] state) {
        for (int i = 0; i < 10; i++) {
            quarterRound(state, 0, 4, 8, 12);
            quarterRound(state, 1, 5, 9, 13);
            quarterRound(state, 2, 6, 10, 14);
            quarterRound(state, 3, 7, 11, 15);
            quarterRound(state, 0, 5, 10, 15);
            quarterRound(state, 1, 6, 11, 12);
            quarterRound(state, 2, 7, 8, 13);
            quarterRound(state, 3, 4, 9, 14);
        }
    }

    static void quarterRound(int[] x, int a, int b, int c, int d) {
        int i = x[a] + x[b];
        x[a] = i;
        int rotateLeft = rotateLeft(i ^ x[d], 16);
        x[d] = rotateLeft;
        int i2 = x[c] + rotateLeft;
        x[c] = i2;
        int rotateLeft2 = rotateLeft(x[b] ^ i2, 12);
        x[b] = rotateLeft2;
        int i3 = x[a] + rotateLeft2;
        x[a] = i3;
        int rotateLeft3 = rotateLeft(x[d] ^ i3, 8);
        x[d] = rotateLeft3;
        int i4 = x[c] + rotateLeft3;
        x[c] = i4;
        x[b] = rotateLeft(x[b] ^ i4, 7);
    }

    static int[] toIntArray(final byte[] input) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/ChaCha20Poly1305.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
public final class ChaCha20Poly1305 extends ChaCha20Poly1305Base {
    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] decrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        return super.decrypt(ciphertext, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] encrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        return super.encrypt(plaintext, associatedData);
    }

    public ChaCha20Poly1305(final byte[] key) throws InvalidKeyException {
        super(key);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base
    ChaCha20Base newChaCha20Instance(final byte[] key, int initialCounter) throws InvalidKeyException {
        return new ChaCha20(key, initialCounter);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/ChaCha20Poly1305Base.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

/* loaded from: classes.dex */
abstract class ChaCha20Poly1305Base implements Aead {
    private final ChaCha20Base chacha20;
    private final ChaCha20Base macKeyChaCha20;

    abstract ChaCha20Base newChaCha20Instance(final byte[] key, int initialCounter) throws InvalidKeyException;

    public ChaCha20Poly1305Base(final byte[] key) throws InvalidKeyException {
        this.chacha20 = newChaCha20Instance(key, 1);
        this.macKeyChaCha20 = newChaCha20Instance(key, 0);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > (Integer.MAX_VALUE - this.chacha20.nonceSizeInBytes()) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate(plaintext.length + this.chacha20.nonceSizeInBytes() + 16);
        encrypt(allocate, plaintext, associatedData);
        return allocate.array();
    }

    private void encrypt(ByteBuffer output, final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (output.remaining() < plaintext.length + this.chacha20.nonceSizeInBytes() + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int position = output.position();
        this.chacha20.encrypt(output, plaintext);
        output.position(position);
        byte[] bArr = new byte[this.chacha20.nonceSizeInBytes()];
        output.get(bArr);
        output.limit(output.limit() - 16);
        if (associatedData == null) {
            associatedData = new byte[0];
        }
        byte[] computeMac = Poly1305.computeMac(getMacKey(bArr), macDataRfc8439(associatedData, output));
        output.limit(output.limit() + 16);
        output.put(computeMac);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(ciphertext), associatedData);
    }

    private byte[] decrypt(ByteBuffer ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.remaining() < this.chacha20.nonceSizeInBytes() + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int position = ciphertext.position();
        byte[] bArr = new byte[16];
        ciphertext.position(ciphertext.limit() - 16);
        ciphertext.get(bArr);
        ciphertext.position(position);
        ciphertext.limit(ciphertext.limit() - 16);
        byte[] bArr2 = new byte[this.chacha20.nonceSizeInBytes()];
        ciphertext.get(bArr2);
        if (associatedData == null) {
            associatedData = new byte[0];
        }
        try {
            Poly1305.verifyMac(getMacKey(bArr2), macDataRfc8439(associatedData, ciphertext), bArr);
            ciphertext.position(position);
            return this.chacha20.decrypt(ciphertext);
        } catch (GeneralSecurityException e) {
            throw new AEADBadTagException(e.toString());
        }
    }

    private byte[] getMacKey(final byte[] nonce) throws GeneralSecurityException {
        byte[] bArr = new byte[32];
        this.macKeyChaCha20.chacha20Block(nonce, 0).get(bArr);
        return bArr;
    }

    private static byte[] macDataRfc8439(final byte[] aad, ByteBuffer ciphertext) {
        int length = aad.length % 16 == 0 ? aad.length : (aad.length + 16) - (aad.length % 16);
        int remaining = ciphertext.remaining();
        int i = remaining % 16;
        int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
        ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(aad);
        order.position(length);
        order.put(ciphertext);
        order.position(i2);
        order.putLong(aad.length);
        order.putLong(remaining);
        return order.array();
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Curve25519.java =====
package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
final class Curve25519 {
    static final byte[][] BANNED_PUBLIC_KEYS = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, 50, -79, -3, -122, 98, 5, 22, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, 28, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ByteCompanionObject.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ByteCompanionObject.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, ByteCompanionObject.MAX_VALUE}};

    Curve25519() {
    }

    private static void monty(long[] x2, long[] z2, long[] x3, long[] z3, long[] x, long[] z, long[] xprime, long[] zprime, long[] qmqp) {
        long[] copyOf = Arrays.copyOf(x, 10);
        long[] jArr = new long[19];
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        long[] jArr4 = new long[19];
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        Field25519.sum(x, z);
        Field25519.sub(z, copyOf);
        long[] copyOf2 = Arrays.copyOf(xprime, 10);
        Field25519.sum(xprime, zprime);
        Field25519.sub(zprime, copyOf2);
        Field25519.product(jArr4, xprime, z);
        Field25519.product(jArr5, x, zprime);
        Field25519.reduceSizeByModularReduction(jArr4);
        Field25519.reduceCoefficients(jArr4);
        Field25519.reduceSizeByModularReduction(jArr5);
        Field25519.reduceCoefficients(jArr5);
        System.arraycopy(jArr4, 0, copyOf2, 0, 10);
        Field25519.sum(jArr4, jArr5);
        Field25519.sub(jArr5, copyOf2);
        Field25519.square(jArr7, jArr4);
        Field25519.square(jArr6, jArr5);
        Field25519.product(jArr5, jArr6, qmqp);
        Field25519.reduceSizeByModularReduction(jArr5);
        Field25519.reduceCoefficients(jArr5);
        System.arraycopy(jArr7, 0, x3, 0, 10);
        System.arraycopy(jArr5, 0, z3, 0, 10);
        Field25519.square(jArr2, x);
        Field25519.square(jArr3, z);
        Field25519.product(x2, jArr2, jArr3);
        Field25519.reduceSizeByModularReduction(x2);
        Field25519.reduceCoefficients(x2);
        Field25519.sub(jArr3, jArr2);
        Arrays.fill(jArr, 10, 18, 0L);
        Field25519.scalarProduct(jArr, jArr3, 121665L);
        Field25519.reduceCoefficients(jArr);
        Field25519.sum(jArr, jArr2);
        Field25519.product(z2, jArr3, jArr);
        Field25519.reduceSizeByModularReduction(z2);
        Field25519.reduceCoefficients(z2);
    }

    static void swapConditional(long[] a, long[] b, int iswap) {
        int i = -iswap;
        for (int i2 = 0; i2 < 10; i2++) {
            int i3 = (((int) a[i2]) ^ ((int) b[i2])) & i;
            a[i2] = ((int) r1) ^ i3;
            b[i2] = ((int) b[i2]) ^ i3;
        }
    }

    static void copyConditional(long[] a, long[] b, int icopy) {
        int i = -icopy;
        for (int i2 = 0; i2 < 10; i2++) {
            long j = a[i2];
            a[i2] = ((int) j) ^ ((((int) j) ^ ((int) b[i2])) & i);
        }
    }

    static void curveMult(long[] resultx, byte[] n, byte[] qBytes) throws InvalidKeyException {
        validatePubKeyAndClearMsb(qBytes);
        long[] expand = Field25519.expand(qBytes);
        long[] jArr = new long[19];
        long[] jArr2 = new long[19];
        int i = 0;
        jArr2[0] = 1;
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        jArr6[0] = 1;
        long[] jArr7 = new long[19];
        long[] jArr8 = new long[19];
        jArr8[0] = 1;
        int i2 = 10;
        System.arraycopy(expand, 0, jArr, 0, 10);
        int i3 = 0;
        while (i3 < 32) {
            int i4 = n[(32 - i3) - 1] & UByte.MAX_VALUE;
            long[] jArr9 = jArr5;
            long[] jArr10 = jArr7;
            long[] jArr11 = jArr8;
            long[] jArr12 = jArr2;
            long[] jArr13 = jArr6;
            long[] jArr14 = jArr;
            int i5 = i;
            long[] jArr15 = jArr4;
            long[] jArr16 = jArr3;
            long[] jArr17 = jArr15;
            while (i5 < 8) {
                int i6 = (i4 >> (7 - i5)) & 1;
                swapConditional(jArr16, jArr14, i6);
                swapConditional(jArr17, jArr12, i6);
                long[] jArr18 = jArr13;
                long[] jArr19 = jArr10;
                int i7 = i4;
                long[] jArr20 = jArr9;
                long[] jArr21 = jArr17;
                long[] jArr22 = jArr16;
                long[] jArr23 = jArr12;
                long[] jArr24 = jArr14;
                monty(jArr10, jArr11, jArr9, jArr18, jArr16, jArr17, jArr14, jArr12, expand);
                swapConditional(jArr19, jArr20, i6);
                swapConditional(jArr11, jArr18, i6);
                i5++;
                jArr12 = jArr18;
                jArr17 = jArr11;
                jArr16 = jArr19;
                jArr14 = jArr20;
                i4 = i7;
                jArr11 = jArr21;
                jArr10 = jArr22;
                jArr13 = jArr23;
                jArr9 = jArr24;
            }
            long[] jArr25 = jArr16;
            long[] jArr26 = jArr12;
            long[] jArr27 = jArr14;
            jArr6 = jArr13;
            i3++;
            jArr8 = jArr11;
            jArr7 = jArr10;
            jArr5 = jArr9;
            jArr4 = jArr17;
            jArr3 = jArr25;
            jArr2 = jArr26;
            jArr = jArr27;
            i = 0;
            i2 = 10;
        }
        long[] jArr28 = new long[i2];
        Field25519.inverse(jArr28, jArr4);
        Field25519.mult(resultx, jArr3, jArr28);
        if (isCollinear(expand, resultx, jArr, jArr2)) {
            return;
        }
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + Hex.encode(qBytes));
    }

    private static void validatePubKeyAndClearMsb(byte[] pubKey) throws InvalidKeyException {
        if (pubKey.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        pubKey[31] = (byte) (pubKey[31] & ByteCompanionObject.MAX_VALUE);
        int i = 0;
        while (true) {
            byte[][] bArr = BANNED_PUBLIC_KEYS;
            if (i >= bArr.length) {
                return;
            }
            if (Bytes.equal(bArr[i], pubKey)) {
                throw new InvalidKeyException("Banned public key: " + Hex.encode(bArr[i]));
            }
            i++;
        }
    }

    private static boolean isCollinear(long[] x1, long[] x2, long[] x3, long[] z3) {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[11];
        long[] jArr4 = new long[11];
        long[] jArr5 = new long[11];
        Field25519.mult(jArr, x1, x2);
        Field25519.sum(jArr2, x1, x2);
        long[] jArr6 = new long[10];
        jArr6[0] = 486662;
        Field25519.sum(jArr4, jArr2, jArr6);
        Field25519.mult(jArr4, jArr4, z3);
        Field25519.sum(jArr4, x3);
        Field25519.mult(jArr4, jArr4, jArr);
        Field25519.mult(jArr4, jArr4, x3);
        Field25519.scalarProduct(jArr3, jArr4, 4L);
        Field25519.reduceCoefficients(jArr3);
        Field25519.mult(jArr4, jArr, z3);
        Field25519.sub(jArr4, jArr4, z3);
        Field25519.mult(jArr5, jArr2, x3);
        Field25519.sum(jArr4, jArr4, jArr5);
        Field25519.square(jArr4, jArr4);
        return Bytes.equal(Field25519.contract(jArr3), Field25519.contract(jArr4));
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EcdsaSignJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Enums;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public final class EcdsaSignJce implements PublicKeySign {
    private final EllipticCurves.EcdsaEncoding encoding;
    private final ECPrivateKey privateKey;
    private final String signatureAlgorithm;

    public EcdsaSignJce(final ECPrivateKey priv, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding) throws GeneralSecurityException {
        this.privateKey = priv;
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hash);
        this.encoding = encoding;
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        Signature engineFactory = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        engineFactory.initSign(this.privateKey);
        engineFactory.update(data);
        byte[] sign = engineFactory.sign();
        return this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363 ? EllipticCurves.ecdsaDer2Ieee(sign, EllipticCurves.fieldSizeInBytes(this.privateKey.getParams().getCurve()) * 2) : sign;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EcdsaVerifyJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Enums;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
public final class EcdsaVerifyJce implements PublicKeyVerify {
    private final EllipticCurves.EcdsaEncoding encoding;
    private final ECPublicKey publicKey;
    private final String signatureAlgorithm;

    public EcdsaVerifyJce(final ECPublicKey pubKey, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(pubKey);
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hash);
        this.publicKey = pubKey;
        this.encoding = encoding;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        boolean z;
        if (this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363) {
            if (signature.length != EllipticCurves.fieldSizeInBytes(this.publicKey.getParams().getCurve()) * 2) {
                throw new GeneralSecurityException("Invalid signature");
            }
            signature = EllipticCurves.ecdsaIeee2Der(signature);
        }
        if (!EllipticCurves.isValidDerEncoding(signature)) {
            throw new GeneralSecurityException("Invalid signature");
        }
        Signature engineFactory = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        engineFactory.initVerify(this.publicKey);
        engineFactory.update(data);
        try {
            z = engineFactory.verify(signature);
        } catch (RuntimeException unused) {
            z = false;
        }
        if (!z) {
            throw new GeneralSecurityException("Invalid signature");
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EciesAeadHkdfDemHelper.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface EciesAeadHkdfDemHelper {
    Aead getAead(final byte[] symmetricKeyValue) throws GeneralSecurityException;

    int getSymmetricKeySizeInBytes();
}

// ===== FILE: com/google/crypto/tink/subtle/EciesAeadHkdfHybridDecrypt.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EciesAeadHkdfHybridDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_AAD = new byte[0];
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final EciesHkdfRecipientKem recipientKem;
    private final ECPrivateKey recipientPrivateKey;

    public EciesAeadHkdfHybridDecrypt(final ECPrivateKey recipientPrivateKey, final byte[] hkdfSalt, String hkdfHmacAlgo, EllipticCurves.PointFormatType ecPointFormat, EciesAeadHkdfDemHelper demHelper) throws GeneralSecurityException {
        this.recipientPrivateKey = recipientPrivateKey;
        this.recipientKem = new EciesHkdfRecipientKem(recipientPrivateKey);
        this.hkdfSalt = hkdfSalt;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.ecPointFormat = ecPointFormat;
        this.demHelper = demHelper;
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
        int encodingSizeInBytes = EllipticCurves.encodingSizeInBytes(this.recipientPrivateKey.getParams().getCurve(), this.ecPointFormat);
        if (ciphertext.length < encodingSizeInBytes) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.demHelper.getAead(this.recipientKem.generateKey(Arrays.copyOfRange(ciphertext, 0, encodingSizeInBytes), this.hkdfHmacAlgo, this.hkdfSalt, contextInfo, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat)).decrypt(Arrays.copyOfRange(ciphertext, encodingSizeInBytes, ciphertext.length), EMPTY_AAD);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EciesAeadHkdfHybridEncrypt.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.subtle.EciesHkdfSenderKem;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
public final class EciesAeadHkdfHybridEncrypt implements HybridEncrypt {
    private static final byte[] EMPTY_AAD = new byte[0];
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final EciesHkdfSenderKem senderKem;

    public EciesAeadHkdfHybridEncrypt(final ECPublicKey recipientPublicKey, final byte[] hkdfSalt, String hkdfHmacAlgo, EllipticCurves.PointFormatType ecPointFormat, EciesAeadHkdfDemHelper demHelper) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(recipientPublicKey);
        this.senderKem = new EciesHkdfSenderKem(recipientPublicKey);
        this.hkdfSalt = hkdfSalt;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.ecPointFormat = ecPointFormat;
        this.demHelper = demHelper;
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        EciesHkdfSenderKem.KemKey generateKey = this.senderKem.generateKey(this.hkdfHmacAlgo, this.hkdfSalt, contextInfo, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat);
        byte[] encrypt = this.demHelper.getAead(generateKey.getSymmetricKey()).encrypt(plaintext, EMPTY_AAD);
        byte[] kemBytes = generateKey.getKemBytes();
        return ByteBuffer.allocate(kemBytes.length + encrypt.length).put(kemBytes).put(encrypt).array();
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EciesHkdfRecipientKem.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public final class EciesHkdfRecipientKem {
    private ECPrivateKey recipientPrivateKey;

    public EciesHkdfRecipientKem(final ECPrivateKey recipientPrivateKey) {
        this.recipientPrivateKey = recipientPrivateKey;
    }

    public byte[] generateKey(byte[] kemBytes, String hmacAlgo, final byte[] hkdfSalt, final byte[] hkdfInfo, int keySizeInBytes, EllipticCurves.PointFormatType pointFormat) throws GeneralSecurityException {
        return Hkdf.computeEciesHkdfSymmetricKey(kemBytes, EllipticCurves.computeSharedSecret(this.recipientPrivateKey, EllipticCurves.getEcPublicKey(this.recipientPrivateKey.getParams(), pointFormat, kemBytes)), hmacAlgo, hkdfSalt, hkdfInfo, keySizeInBytes);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EciesHkdfSenderKem.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
public final class EciesHkdfSenderKem {
    private ECPublicKey recipientPublicKey;

    public static final class KemKey {
        private final ImmutableByteArray kemBytes;
        private final ImmutableByteArray symmetricKey;

        public KemKey(final byte[] kemBytes, final byte[] symmetricKey) {
            this.kemBytes = ImmutableByteArray.m82of(kemBytes);
            this.symmetricKey = ImmutableByteArray.m82of(symmetricKey);
        }

        public byte[] getKemBytes() {
            ImmutableByteArray immutableByteArray = this.kemBytes;
            if (immutableByteArray == null) {
                return null;
            }
            return immutableByteArray.getBytes();
        }

        public byte[] getSymmetricKey() {
            ImmutableByteArray immutableByteArray = this.symmetricKey;
            if (immutableByteArray == null) {
                return null;
            }
            return immutableByteArray.getBytes();
        }
    }

    public EciesHkdfSenderKem(final ECPublicKey recipientPublicKey) {
        this.recipientPublicKey = recipientPublicKey;
    }

    public KemKey generateKey(String hmacAlgo, final byte[] hkdfSalt, final byte[] hkdfInfo, int keySizeInBytes, EllipticCurves.PointFormatType pointFormat) throws GeneralSecurityException {
        KeyPair generateKeyPair = EllipticCurves.generateKeyPair(this.recipientPublicKey.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
        byte[] computeSharedSecret = EllipticCurves.computeSharedSecret((ECPrivateKey) generateKeyPair.getPrivate(), this.recipientPublicKey);
        byte[] pointEncode = EllipticCurves.pointEncode(eCPublicKey.getParams().getCurve(), pointFormat, eCPublicKey.getW());
        return new KemKey(pointEncode, Hkdf.computeEciesHkdfSymmetricKey(pointEncode, computeSharedSecret, hmacAlgo, hkdfSalt, hkdfInfo, keySizeInBytes));
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Ed25519.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
final class Ed25519 {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    /* renamed from: eq */
    private static int m80eq(int a, int b) {
        int i = (~(a ^ b)) & 255;
        int i2 = i & (i << 4);
        int i3 = i2 & (i2 << 2);
        return ((i3 & (i3 << 1)) >> 7) & 1;
    }

    Ed25519() {
    }

    private static class XYZ {

        /* renamed from: x */
        final long[] f202x;

        /* renamed from: y */
        final long[] f203y;

        /* renamed from: z */
        final long[] f204z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(long[] x, long[] y, long[] z) {
            this.f202x = x;
            this.f203y = y;
            this.f204z = z;
        }

        XYZ(XYZ xyz) {
            this.f202x = Arrays.copyOf(xyz.f202x, 10);
            this.f203y = Arrays.copyOf(xyz.f203y, 10);
            this.f204z = Arrays.copyOf(xyz.f204z, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        static XYZ fromPartialXYZT(XYZ out, PartialXYZT in) {
            Field25519.mult(out.f202x, in.xyz.f202x, in.f201t);
            Field25519.mult(out.f203y, in.xyz.f203y, in.xyz.f204z);
            Field25519.mult(out.f204z, in.xyz.f204z, in.f201t);
            return out;
        }

        byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.f204z);
            Field25519.mult(jArr2, this.f202x, jArr);
            Field25519.mult(jArr3, this.f203y, jArr);
            byte[] contract = Field25519.contract(jArr3);
            contract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ contract[31]);
            return contract;
        }

        boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.f202x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.f203y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.f204z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.f207D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }
    }

    private static class XYZT {

        /* renamed from: t */
        final long[] f205t;
        final XYZ xyz;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.f205t = t;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT out, PartialXYZT in) {
            Field25519.mult(out.xyz.f202x, in.xyz.f202x, in.f201t);
            Field25519.mult(out.xyz.f203y, in.xyz.f203y, in.xyz.f204z);
            Field25519.mult(out.xyz.f204z, in.xyz.f204z, in.f201t);
            Field25519.mult(out.f205t, in.xyz.f202x, in.xyz.f203y);
            return out;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] s) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] expand = Field25519.expand(s);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, expand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.f207D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (Ed25519.isNonZeroVarTime(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((s[31] & UByte.MAX_VALUE) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((s[31] & UByte.MAX_VALUE) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, expand);
                return new XYZT(new XYZ(jArr, expand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }
    }

    private static class PartialXYZT {

        /* renamed from: t */
        final long[] f201t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.f201t = t;
        }

        PartialXYZT(PartialXYZT other) {
            this.xyz = new XYZ(other.xyz);
            this.f201t = Arrays.copyOf(other.f201t, 10);
        }
    }

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        CachedXYT(long[] yPlusX, long[] yMinusX, long[] t2d) {
            this.yPlusX = yPlusX;
            this.yMinusX = yMinusX;
            this.t2d = t2d;
        }

        CachedXYT(CachedXYT other) {
            this.yPlusX = Arrays.copyOf(other.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(other.yMinusX, 10);
            this.t2d = Arrays.copyOf(other.t2d, 10);
        }

        void multByZ(long[] output, long[] in) {
            System.arraycopy(in, 0, output, 0, 10);
        }

        void copyConditional(CachedXYT other, int icopy) {
            Curve25519.copyConditional(this.yPlusX, other.yPlusX, icopy);
            Curve25519.copyConditional(this.yMinusX, other.yMinusX, icopy);
            Curve25519.copyConditional(this.t2d, other.t2d, icopy);
        }
    }

    private static class CachedXYZT extends CachedXYT {

        /* renamed from: z */
        private final long[] f200z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            Field25519.sum(this.yPlusX, xyzt.xyz.f203y, xyzt.xyz.f202x);
            Field25519.sub(this.yMinusX, xyzt.xyz.f203y, xyzt.xyz.f202x);
            System.arraycopy(xyzt.xyz.f204z, 0, this.f200z, 0, 10);
            Field25519.mult(this.t2d, xyzt.f205t, Ed25519Constants.f208D2);
        }

        CachedXYZT(long[] yPlusX, long[] yMinusX, long[] z, long[] t2d) {
            super(yPlusX, yMinusX, t2d);
            this.f200z = z;
        }

        @Override // com.google.crypto.tink.subtle.Ed25519.CachedXYT
        public void multByZ(long[] output, long[] in) {
            Field25519.mult(output, in, this.f200z);
        }
    }

    private static void add(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.f202x, extended.xyz.f203y, extended.xyz.f202x);
        Field25519.sub(partialXYZT.xyz.f203y, extended.xyz.f203y, extended.xyz.f202x);
        Field25519.mult(partialXYZT.xyz.f203y, partialXYZT.xyz.f203y, cached.yMinusX);
        Field25519.mult(partialXYZT.xyz.f204z, partialXYZT.xyz.f202x, cached.yPlusX);
        Field25519.mult(partialXYZT.f201t, extended.f205t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.f202x, extended.xyz.f204z);
        Field25519.sum(jArr, partialXYZT.xyz.f202x, partialXYZT.xyz.f202x);
        Field25519.sub(partialXYZT.xyz.f202x, partialXYZT.xyz.f204z, partialXYZT.xyz.f203y);
        Field25519.sum(partialXYZT.xyz.f203y, partialXYZT.xyz.f204z, partialXYZT.xyz.f203y);
        Field25519.sum(partialXYZT.xyz.f204z, jArr, partialXYZT.f201t);
        Field25519.sub(partialXYZT.f201t, jArr, partialXYZT.f201t);
    }

    private static void sub(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.f202x, extended.xyz.f203y, extended.xyz.f202x);
        Field25519.sub(partialXYZT.xyz.f203y, extended.xyz.f203y, extended.xyz.f202x);
        Field25519.mult(partialXYZT.xyz.f203y, partialXYZT.xyz.f203y, cached.yPlusX);
        Field25519.mult(partialXYZT.xyz.f204z, partialXYZT.xyz.f202x, cached.yMinusX);
        Field25519.mult(partialXYZT.f201t, extended.f205t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.f202x, extended.xyz.f204z);
        Field25519.sum(jArr, partialXYZT.xyz.f202x, partialXYZT.xyz.f202x);
        Field25519.sub(partialXYZT.xyz.f202x, partialXYZT.xyz.f204z, partialXYZT.xyz.f203y);
        Field25519.sum(partialXYZT.xyz.f203y, partialXYZT.xyz.f204z, partialXYZT.xyz.f203y);
        Field25519.sub(partialXYZT.xyz.f204z, jArr, partialXYZT.f201t);
        Field25519.sum(partialXYZT.f201t, jArr, partialXYZT.f201t);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ p) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.f202x, p.f202x);
        Field25519.square(partialXYZT.xyz.f204z, p.f203y);
        Field25519.square(partialXYZT.f201t, p.f204z);
        Field25519.sum(partialXYZT.f201t, partialXYZT.f201t, partialXYZT.f201t);
        Field25519.sum(partialXYZT.xyz.f203y, p.f202x, p.f203y);
        Field25519.square(jArr, partialXYZT.xyz.f203y);
        Field25519.sum(partialXYZT.xyz.f203y, partialXYZT.xyz.f204z, partialXYZT.xyz.f202x);
        Field25519.sub(partialXYZT.xyz.f204z, partialXYZT.xyz.f204z, partialXYZT.xyz.f202x);
        Field25519.sub(partialXYZT.xyz.f202x, jArr, partialXYZT.xyz.f203y);
        Field25519.sub(partialXYZT.f201t, partialXYZT.f201t, partialXYZT.xyz.f204z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT p) {
        doubleXYZ(partialXYZT, p.xyz);
    }

    private static void select(CachedXYT t, int pos, byte b) {
        int i = (b & UByte.MAX_VALUE) >> 7;
        int i2 = b - (((-i) & b) << 1);
        t.copyConditional(Ed25519Constants.B_TABLE[pos][0], m80eq(i2, 1));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][1], m80eq(i2, 2));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][2], m80eq(i2, 3));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][3], m80eq(i2, 4));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][4], m80eq(i2, 5));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][5], m80eq(i2, 6));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][6], m80eq(i2, 7));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][7], m80eq(i2, 8));
        long[] copyOf = Arrays.copyOf(t.yMinusX, 10);
        long[] copyOf2 = Arrays.copyOf(t.yPlusX, 10);
        long[] copyOf3 = Arrays.copyOf(t.t2d, 10);
        neg(copyOf3, copyOf3);
        t.copyConditional(new CachedXYT(copyOf, copyOf2, copyOf3), i);
    }

    private static XYZ scalarMultWithBase(byte[] a) {
        int i;
        byte[] bArr = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr[i3 + 0] = (byte) (((a[i2] & UByte.MAX_VALUE) >> 0) & 15);
            bArr[i3 + 1] = (byte) (((a[i2] & UByte.MAX_VALUE) >> 4) & 15);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr[i4] + i5);
            bArr[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr[63] = (byte) (bArr[63] + i5);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i = 1; i < 64; i += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i / 2, bArr[i]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i7 = 0; i7 < 64; i7 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i7 / 2, bArr[i7]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    static byte[] scalarMultWithBaseToBytes(byte[] a) {
        return scalarMultWithBase(a).toBytes();
    }

    private static byte[] slide(byte[] a) {
        int i;
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) (1 & ((a[i2 >> 3] & UByte.MAX_VALUE) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr[i];
                    if (b != 0) {
                        byte b2 = bArr[i3];
                        if ((b << i4) + b2 <= 15) {
                            bArr[i3] = (byte) (b2 + (b << i4));
                            bArr[i] = 0;
                        } else if (b2 - (b << i4) >= -15) {
                            bArr[i3] = (byte) (b2 - (b << i4));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                }
                                if (bArr[i] == 0) {
                                    bArr[i] = 1;
                                    break;
                                }
                                bArr[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr;
    }

    private static XYZ doubleScalarMultVarTime(byte[] a, XYZT pointA, byte[] b) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(pointA);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, pointA);
        XYZT xyzt = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] slide = slide(a);
        byte[] slide2 = slide(b);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt2 = new XYZT();
        int i2 = 255;
        while (i2 >= 0 && slide[i2] == 0 && slide2[i2] == 0) {
            i2--;
        }
        while (i2 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b2 = slide[i2];
            if (b2 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), cachedXYZTArr[slide[i2] / 2]);
            } else if (b2 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), cachedXYZTArr[(-slide[i2]) / 2]);
            }
            byte b3 = slide2[i2];
            if (b3 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), Ed25519Constants.f206B2[slide2[i2] / 2]);
            } else if (b3 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), Ed25519Constants.f206B2[(-slide2[i2]) / 2]);
            }
            i2--;
        }
        return new XYZ(partialXYZT2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] in) {
        long[] jArr = new long[in.length + 1];
        System.arraycopy(in, 0, jArr, 0, in.length);
        Field25519.reduceCoefficients(jArr);
        for (byte b : Field25519.contract(jArr)) {
            if (b != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLsb(long[] in) {
        return Field25519.contract(in)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void neg(long[] out, long[] in) {
        for (int i = 0; i < in.length; i++) {
            out[i] = -in[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pow2252m3(long[] out, long[] in) {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        Field25519.square(jArr, in);
        Field25519.square(jArr2, jArr);
        Field25519.square(jArr2, jArr2);
        Field25519.mult(jArr2, in, jArr2);
        Field25519.mult(jArr, jArr, jArr2);
        Field25519.square(jArr, jArr);
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i = 1; i < 5; i++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i2 = 1; i2 < 10; i2++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr2, jArr2, jArr);
        Field25519.square(jArr3, jArr2);
        for (int i3 = 1; i3 < 20; i3++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr2, jArr3, jArr2);
        Field25519.square(jArr2, jArr2);
        for (int i4 = 1; i4 < 10; i4++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i5 = 1; i5 < 50; i5++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr2, jArr2, jArr);
        Field25519.square(jArr3, jArr2);
        for (int i6 = 1; i6 < 100; i6++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr2, jArr3, jArr2);
        Field25519.square(jArr2, jArr2);
        for (int i7 = 1; i7 < 50; i7++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr, jArr);
        Field25519.square(jArr, jArr);
        Field25519.mult(out, jArr, in);
    }

    private static long load3(byte[] in, int idx) {
        return ((in[idx + 2] & UByte.MAX_VALUE) << 16) | (in[idx] & 255) | ((in[idx + 1] & UByte.MAX_VALUE) << 8);
    }

    private static long load4(byte[] in, int idx) {
        return ((in[idx + 3] & UByte.MAX_VALUE) << 24) | load3(in, idx);
    }

    private static void reduce(byte[] s) {
        long load3 = load3(s, 0) & 2097151;
        long load4 = (load4(s, 2) >> 5) & 2097151;
        long load32 = (load3(s, 5) >> 2) & 2097151;
        long load42 = (load4(s, 7) >> 7) & 2097151;
        long load43 = (load4(s, 10) >> 4) & 2097151;
        long load33 = (load3(s, 13) >> 1) & 2097151;
        long load44 = (load4(s, 15) >> 6) & 2097151;
        long load34 = (load3(s, 18) >> 3) & 2097151;
        long load35 = load3(s, 21) & 2097151;
        long load45 = (load4(s, 23) >> 5) & 2097151;
        long load36 = (load3(s, 26) >> 2) & 2097151;
        long load46 = (load4(s, 28) >> 7) & 2097151;
        long load47 = (load4(s, 31) >> 4) & 2097151;
        long load37 = (load3(s, 34) >> 1) & 2097151;
        long load48 = (load4(s, 36) >> 6) & 2097151;
        long load38 = (load3(s, 39) >> 3) & 2097151;
        long load39 = load3(s, 42) & 2097151;
        long load49 = (load4(s, 44) >> 5) & 2097151;
        long load310 = (load3(s, 47) >> 2) & 2097151;
        long load410 = (load4(s, 49) >> 7) & 2097151;
        long load411 = (load4(s, 52) >> 4) & 2097151;
        long load311 = (load3(s, 55) >> 1) & 2097151;
        long load412 = (load4(s, 57) >> 6) & 2097151;
        long load413 = load4(s, 60) >> 3;
        long j = load39 - (load413 * 683901);
        long j2 = ((load48 - (load413 * 997805)) + (load412 * 136657)) - (load311 * 683901);
        long j3 = ((((load47 + (load413 * 470296)) + (load412 * 654183)) - (load311 * 997805)) + (load411 * 136657)) - (load410 * 683901);
        long j4 = load44 + (load310 * 666643);
        long j5 = load34 + (load410 * 666643) + (load310 * 470296);
        long j6 = load35 + (load411 * 666643) + (load410 * 470296) + (load310 * 654183);
        long j7 = (((load45 + (load311 * 666643)) + (load411 * 470296)) + (load410 * 654183)) - (load310 * 997805);
        long j8 = ((((load36 + (load412 * 666643)) + (load311 * 470296)) + (load411 * 654183)) - (load410 * 997805)) + (load310 * 136657);
        long j9 = (((((load46 + (load413 * 666643)) + (load412 * 470296)) + (load311 * 654183)) - (load411 * 997805)) + (load410 * 136657)) - (load310 * 683901);
        long j10 = (j4 + 1048576) >> 21;
        long j11 = j5 + j10;
        long j12 = j4 - (j10 << 21);
        long j13 = (j6 + 1048576) >> 21;
        long j14 = j7 + j13;
        long j15 = j6 - (j13 << 21);
        long j16 = (j8 + 1048576) >> 21;
        long j17 = j9 + j16;
        long j18 = j8 - (j16 << 21);
        long j19 = (j3 + 1048576) >> 21;
        long j20 = ((((load37 + (load413 * 654183)) - (load412 * 997805)) + (load311 * 136657)) - (load411 * 683901)) + j19;
        long j21 = j3 - (j19 << 21);
        long j22 = (j2 + 1048576) >> 21;
        long j23 = ((load38 + (load413 * 136657)) - (load412 * 683901)) + j22;
        long j24 = j2 - (j22 << 21);
        long j25 = (j + 1048576) >> 21;
        long j26 = load49 + j25;
        long j27 = j - (j25 << 21);
        long j28 = (j11 + 1048576) >> 21;
        long j29 = j15 + j28;
        long j30 = j11 - (j28 << 21);
        long j31 = (j14 + 1048576) >> 21;
        long j32 = j18 + j31;
        long j33 = j14 - (j31 << 21);
        long j34 = (j17 + 1048576) >> 21;
        long j35 = j21 + j34;
        long j36 = j17 - (j34 << 21);
        long j37 = (j20 + 1048576) >> 21;
        long j38 = j24 + j37;
        long j39 = j20 - (j37 << 21);
        long j40 = (j23 + 1048576) >> 21;
        long j41 = j27 + j40;
        long j42 = j23 - (j40 << 21);
        long j43 = j32 - (j26 * 683901);
        long j44 = ((j29 - (j26 * 997805)) + (j41 * 136657)) - (j42 * 683901);
        long j45 = ((((j12 + (j26 * 470296)) + (j41 * 654183)) - (j42 * 997805)) + (j38 * 136657)) - (j39 * 683901);
        long j46 = load3 + (j35 * 666643);
        long j47 = load4 + (j39 * 666643) + (j35 * 470296);
        long j48 = load32 + (j38 * 666643) + (j39 * 470296) + (j35 * 654183);
        long j49 = (((load42 + (j42 * 666643)) + (j38 * 470296)) + (j39 * 654183)) - (j35 * 997805);
        long j50 = ((((load43 + (j41 * 666643)) + (j42 * 470296)) + (j38 * 654183)) - (j39 * 997805)) + (j35 * 136657);
        long j51 = (((((load33 + (j26 * 666643)) + (j41 * 470296)) + (j42 * 654183)) - (j38 * 997805)) + (j39 * 136657)) - (j35 * 683901);
        long j52 = (j46 + 1048576) >> 21;
        long j53 = j47 + j52;
        long j54 = j46 - (j52 << 21);
        long j55 = (j48 + 1048576) >> 21;
        long j56 = j49 + j55;
        long j57 = j48 - (j55 << 21);
        long j58 = (j50 + 1048576) >> 21;
        long j59 = j51 + j58;
        long j60 = j50 - (j58 << 21);
        long j61 = (j45 + 1048576) >> 21;
        long j62 = ((((j30 + (j26 * 654183)) - (j41 * 997805)) + (j42 * 136657)) - (j38 * 683901)) + j61;
        long j63 = j45 - (j61 << 21);
        long j64 = (j44 + 1048576) >> 21;
        long j65 = ((j33 + (j26 * 136657)) - (j41 * 683901)) + j64;
        long j66 = j44 - (j64 << 21);
        long j67 = (j43 + 1048576) >> 21;
        long j68 = j36 + j67;
        long j69 = j43 - (j67 << 21);
        long j70 = (j53 + 1048576) >> 21;
        long j71 = j57 + j70;
        long j72 = j53 - (j70 << 21);
        long j73 = (j56 + 1048576) >> 21;
        long j74 = j60 + j73;
        long j75 = j56 - (j73 << 21);
        long j76 = (j59 + 1048576) >> 21;
        long j77 = j63 + j76;
        long j78 = j59 - (j76 << 21);
        long j79 = (j62 + 1048576) >> 21;
        long j80 = j66 + j79;
        long j81 = j62 - (j79 << 21);
        long j82 = (j65 + 1048576) >> 21;
        long j83 = j69 + j82;
        long j84 = j65 - (j82 << 21);
        long j85 = (j68 + 1048576) >> 21;
        long j86 = j85 + 0;
        long j87 = j54 + (j86 * 666643);
        long j88 = j72 + (j86 * 470296);
        long j89 = j71 + (j86 * 654183);
        long j90 = j75 - (j86 * 997805);
        long j91 = j74 + (j86 * 136657);
        long j92 = j78 - (j86 * 683901);
        long j93 = j87 >> 21;
        long j94 = j88 + j93;
        long j95 = j87 - (j93 << 21);
        long j96 = j94 >> 21;
        long j97 = j89 + j96;
        long j98 = j94 - (j96 << 21);
        long j99 = j97 >> 21;
        long j100 = j90 + j99;
        long j101 = j97 - (j99 << 21);
        long j102 = j100 >> 21;
        long j103 = j91 + j102;
        long j104 = j100 - (j102 << 21);
        long j105 = j103 >> 21;
        long j106 = j92 + j105;
        long j107 = j103 - (j105 << 21);
        long j108 = j106 >> 21;
        long j109 = j77 + j108;
        long j110 = j106 - (j108 << 21);
        long j111 = j109 >> 21;
        long j112 = j81 + j111;
        long j113 = j109 - (j111 << 21);
        long j114 = j112 >> 21;
        long j115 = j80 + j114;
        long j116 = j112 - (j114 << 21);
        long j117 = j115 >> 21;
        long j118 = j84 + j117;
        long j119 = j115 - (j117 << 21);
        long j120 = j118 >> 21;
        long j121 = j83 + j120;
        long j122 = j118 - (j120 << 21);
        long j123 = j121 >> 21;
        long j124 = (j68 - (j85 << 21)) + j123;
        long j125 = j121 - (j123 << 21);
        long j126 = j124 >> 21;
        long j127 = j126 + 0;
        long j128 = j124 - (j126 << 21);
        long j129 = j95 + (666643 * j127);
        long j130 = j129 >> 21;
        long j131 = j98 + (470296 * j127) + j130;
        long j132 = j129 - (j130 << 21);
        long j133 = j131 >> 21;
        long j134 = j101 + (654183 * j127) + j133;
        long j135 = j131 - (j133 << 21);
        long j136 = j134 >> 21;
        long j137 = (j104 - (997805 * j127)) + j136;
        long j138 = j134 - (j136 << 21);
        long j139 = j137 >> 21;
        long j140 = j107 + (136657 * j127) + j139;
        long j141 = j137 - (j139 << 21);
        long j142 = j140 >> 21;
        long j143 = (j110 - (j127 * 683901)) + j142;
        long j144 = j140 - (j142 << 21);
        long j145 = j143 >> 21;
        long j146 = j113 + j145;
        long j147 = j143 - (j145 << 21);
        long j148 = j146 >> 21;
        long j149 = j116 + j148;
        long j150 = j146 - (j148 << 21);
        long j151 = j149 >> 21;
        long j152 = j119 + j151;
        long j153 = j149 - (j151 << 21);
        long j154 = j152 >> 21;
        long j155 = j122 + j154;
        long j156 = j155 >> 21;
        long j157 = j125 + j156;
        long j158 = j155 - (j156 << 21);
        long j159 = j157 >> 21;
        long j160 = j128 + j159;
        long j161 = j157 - (j159 << 21);
        s[0] = (byte) j132;
        s[1] = (byte) (j132 >> 8);
        s[2] = (byte) ((j132 >> 16) | (j135 << 5));
        s[3] = (byte) (j135 >> 3);
        s[4] = (byte) (j135 >> 11);
        s[5] = (byte) ((j135 >> 19) | (j138 << 2));
        s[6] = (byte) (j138 >> 6);
        s[7] = (byte) ((j138 >> 14) | (j141 << 7));
        s[8] = (byte) (j141 >> 1);
        s[9] = (byte) (j141 >> 9);
        s[10] = (byte) ((j141 >> 17) | (j144 << 4));
        s[11] = (byte) (j144 >> 4);
        s[12] = (byte) (j144 >> 12);
        s[13] = (byte) ((j144 >> 20) | (j147 << 1));
        s[14] = (byte) (j147 >> 7);
        s[15] = (byte) ((j147 >> 15) | (j150 << 6));
        s[16] = (byte) (j150 >> 2);
        s[17] = (byte) (j150 >> 10);
        s[18] = (byte) ((j150 >> 18) | (j153 << 3));
        s[19] = (byte) (j153 >> 5);
        s[20] = (byte) (j153 >> 13);
        s[21] = (byte) (j152 - (j154 << 21));
        s[22] = (byte) (r11 >> 8);
        s[23] = (byte) ((r11 >> 16) | (j158 << 5));
        s[24] = (byte) (j158 >> 3);
        s[25] = (byte) (j158 >> 11);
        s[26] = (byte) ((j158 >> 19) | (j161 << 2));
        s[27] = (byte) (j161 >> 6);
        s[28] = (byte) ((j161 >> 14) | (j160 << 7));
        s[29] = (byte) (j160 >> 1);
        s[30] = (byte) (j160 >> 9);
        s[31] = (byte) (j160 >> 17);
    }

    private static void mulAdd(byte[] s, byte[] a, byte[] b, byte[] c) {
        long load3 = load3(a, 0) & 2097151;
        long load4 = (load4(a, 2) >> 5) & 2097151;
        long load32 = (load3(a, 5) >> 2) & 2097151;
        long load42 = (load4(a, 7) >> 7) & 2097151;
        long load43 = (load4(a, 10) >> 4) & 2097151;
        long load33 = (load3(a, 13) >> 1) & 2097151;
        long load44 = (load4(a, 15) >> 6) & 2097151;
        long load34 = (load3(a, 18) >> 3) & 2097151;
        long load35 = load3(a, 21) & 2097151;
        long load45 = (load4(a, 23) >> 5) & 2097151;
        long load36 = (load3(a, 26) >> 2) & 2097151;
        long load46 = load4(a, 28) >> 7;
        long load37 = load3(b, 0) & 2097151;
        long load47 = (load4(b, 2) >> 5) & 2097151;
        long load38 = (load3(b, 5) >> 2) & 2097151;
        long load48 = (load4(b, 7) >> 7) & 2097151;
        long load49 = (load4(b, 10) >> 4) & 2097151;
        long load39 = (load3(b, 13) >> 1) & 2097151;
        long load410 = (load4(b, 15) >> 6) & 2097151;
        long load310 = (load3(b, 18) >> 3) & 2097151;
        long load311 = load3(b, 21) & 2097151;
        long load411 = (load4(b, 23) >> 5) & 2097151;
        long load312 = (load3(b, 26) >> 2) & 2097151;
        long load412 = load4(b, 28) >> 7;
        long load313 = load3(c, 0) & 2097151;
        long load413 = (load4(c, 2) >> 5) & 2097151;
        long load314 = (load3(c, 5) >> 2) & 2097151;
        long load414 = (load4(c, 7) >> 7) & 2097151;
        long load415 = (load4(c, 10) >> 4) & 2097151;
        long load315 = (load3(c, 13) >> 1) & 2097151;
        long load416 = (load4(c, 15) >> 6) & 2097151;
        long load316 = (load3(c, 18) >> 3) & 2097151;
        long load317 = load3(c, 21) & 2097151;
        long j = load313 + (load3 * load37);
        long j2 = load413 + (load3 * load47) + (load4 * load37);
        long j3 = load314 + (load3 * load38) + (load4 * load47) + (load32 * load37);
        long j4 = load414 + (load3 * load48) + (load4 * load38) + (load32 * load47) + (load42 * load37);
        long j5 = load415 + (load3 * load49) + (load4 * load48) + (load32 * load38) + (load42 * load47) + (load43 * load37);
        long j6 = load315 + (load3 * load39) + (load4 * load49) + (load32 * load48) + (load42 * load38) + (load43 * load47) + (load33 * load37);
        long j7 = load416 + (load3 * load410) + (load4 * load39) + (load32 * load49) + (load42 * load48) + (load43 * load38) + (load33 * load47) + (load44 * load37);
        long j8 = load316 + (load3 * load310) + (load4 * load410) + (load32 * load39) + (load42 * load49) + (load43 * load48) + (load33 * load38) + (load44 * load47) + (load34 * load37);
        long j9 = load317 + (load3 * load311) + (load4 * load310) + (load32 * load410) + (load42 * load39) + (load43 * load49) + (load33 * load48) + (load44 * load38) + (load34 * load47) + (load35 * load37);
        long load417 = ((load4(c, 23) >> 5) & 2097151) + (load3 * load411) + (load4 * load311) + (load32 * load310) + (load42 * load410) + (load43 * load39) + (load33 * load49) + (load44 * load48) + (load34 * load38) + (load35 * load47) + (load45 * load37);
        long load318 = ((load3(c, 26) >> 2) & 2097151) + (load3 * load312) + (load4 * load411) + (load32 * load311) + (load42 * load310) + (load43 * load410) + (load33 * load39) + (load44 * load49) + (load34 * load48) + (load35 * load38) + (load45 * load47) + (load36 * load37);
        long load418 = (load4(c, 28) >> 7) + (load3 * load412) + (load4 * load312) + (load32 * load411) + (load42 * load311) + (load43 * load310) + (load33 * load410) + (load44 * load39) + (load34 * load49) + (load35 * load48) + (load45 * load38) + (load36 * load47) + (load37 * load46);
        long j10 = (load4 * load412) + (load32 * load312) + (load42 * load411) + (load43 * load311) + (load33 * load310) + (load44 * load410) + (load34 * load39) + (load35 * load49) + (load45 * load48) + (load36 * load38) + (load47 * load46);
        long j11 = (load32 * load412) + (load42 * load312) + (load43 * load411) + (load33 * load311) + (load44 * load310) + (load34 * load410) + (load35 * load39) + (load45 * load49) + (load36 * load48) + (load38 * load46);
        long j12 = (load42 * load412) + (load43 * load312) + (load33 * load411) + (load44 * load311) + (load34 * load310) + (load35 * load410) + (load45 * load39) + (load36 * load49) + (load48 * load46);
        long j13 = (load43 * load412) + (load33 * load312) + (load44 * load411) + (load34 * load311) + (load35 * load310) + (load45 * load410) + (load36 * load39) + (load49 * load46);
        long j14 = (load33 * load412) + (load44 * load312) + (load34 * load411) + (load35 * load311) + (load45 * load310) + (load36 * load410) + (load39 * load46);
        long j15 = (load44 * load412) + (load34 * load312) + (load35 * load411) + (load45 * load311) + (load36 * load310) + (load410 * load46);
        long j16 = (load34 * load412) + (load35 * load312) + (load45 * load411) + (load36 * load311) + (load310 * load46);
        long j17 = (load35 * load412) + (load45 * load312) + (load36 * load411) + (load311 * load46);
        long j18 = (load45 * load412) + (load36 * load312) + (load411 * load46);
        long j19 = (load36 * load412) + (load312 * load46);
        long j20 = load46 * load412;
        long j21 = (j + 1048576) >> 21;
        long j22 = j2 + j21;
        long j23 = j - (j21 << 21);
        long j24 = (j3 + 1048576) >> 21;
        long j25 = j4 + j24;
        long j26 = j3 - (j24 << 21);
        long j27 = (j5 + 1048576) >> 21;
        long j28 = j6 + j27;
        long j29 = j5 - (j27 << 21);
        long j30 = (j7 + 1048576) >> 21;
        long j31 = j8 + j30;
        long j32 = j7 - (j30 << 21);
        long j33 = (j9 + 1048576) >> 21;
        long j34 = load417 + j33;
        long j35 = j9 - (j33 << 21);
        long j36 = (load318 + 1048576) >> 21;
        long j37 = load418 + j36;
        long j38 = load318 - (j36 << 21);
        long j39 = (j10 + 1048576) >> 21;
        long j40 = j11 + j39;
        long j41 = j10 - (j39 << 21);
        long j42 = (j12 + 1048576) >> 21;
        long j43 = j13 + j42;
        long j44 = j12 - (j42 << 21);
        long j45 = (j14 + 1048576) >> 21;
        long j46 = j15 + j45;
        long j47 = j14 - (j45 << 21);
        long j48 = (j16 + 1048576) >> 21;
        long j49 = j17 + j48;
        long j50 = j16 - (j48 << 21);
        long j51 = (j18 + 1048576) >> 21;
        long j52 = j19 + j51;
        long j53 = j18 - (j51 << 21);
        long j54 = (j20 + 1048576) >> 21;
        long j55 = j54 + 0;
        long j56 = j20 - (j54 << 21);
        long j57 = (j22 + 1048576) >> 21;
        long j58 = j26 + j57;
        long j59 = j22 - (j57 << 21);
        long j60 = (j25 + 1048576) >> 21;
        long j61 = j29 + j60;
        long j62 = j25 - (j60 << 21);
        long j63 = (j28 + 1048576) >> 21;
        long j64 = j32 + j63;
        long j65 = j28 - (j63 << 21);
        long j66 = (j31 + 1048576) >> 21;
        long j67 = j35 + j66;
        long j68 = j31 - (j66 << 21);
        long j69 = (j34 + 1048576) >> 21;
        long j70 = j38 + j69;
        long j71 = j34 - (j69 << 21);
        long j72 = (j37 + 1048576) >> 21;
        long j73 = j41 + j72;
        long j74 = j37 - (j72 << 21);
        long j75 = (j40 + 1048576) >> 21;
        long j76 = j44 + j75;
        long j77 = j40 - (j75 << 21);
        long j78 = (j43 + 1048576) >> 21;
        long j79 = j47 + j78;
        long j80 = j43 - (j78 << 21);
        long j81 = (j46 + 1048576) >> 21;
        long j82 = j50 + j81;
        long j83 = j46 - (j81 << 21);
        long j84 = (j49 + 1048576) >> 21;
        long j85 = j53 + j84;
        long j86 = j49 - (j84 << 21);
        long j87 = (j52 + 1048576) >> 21;
        long j88 = j56 + j87;
        long j89 = j52 - (j87 << 21);
        long j90 = j79 - (j55 * 683901);
        long j91 = ((j76 - (j55 * 997805)) + (j88 * 136657)) - (j89 * 683901);
        long j92 = ((((j73 + (j55 * 470296)) + (j88 * 654183)) - (j89 * 997805)) + (j85 * 136657)) - (j86 * 683901);
        long j93 = j64 + (j82 * 666643);
        long j94 = j68 + (j86 * 666643) + (j82 * 470296);
        long j95 = j67 + (j85 * 666643) + (j86 * 470296) + (j82 * 654183);
        long j96 = (((j71 + (j89 * 666643)) + (j85 * 470296)) + (j86 * 654183)) - (j82 * 997805);
        long j97 = ((((j70 + (j88 * 666643)) + (j89 * 470296)) + (j85 * 654183)) - (j86 * 997805)) + (j82 * 136657);
        long j98 = (((((j74 + (j55 * 666643)) + (j88 * 470296)) + (j89 * 654183)) - (j85 * 997805)) + (j86 * 136657)) - (j82 * 683901);
        long j99 = (j93 + 1048576) >> 21;
        long j100 = j94 + j99;
        long j101 = j93 - (j99 << 21);
        long j102 = (j95 + 1048576) >> 21;
        long j103 = j96 + j102;
        long j104 = j95 - (j102 << 21);
        long j105 = (j97 + 1048576) >> 21;
        long j106 = j98 + j105;
        long j107 = j97 - (j105 << 21);
        long j108 = (j92 + 1048576) >> 21;
        long j109 = ((((j77 + (j55 * 654183)) - (j88 * 997805)) + (j89 * 136657)) - (j85 * 683901)) + j108;
        long j110 = j92 - (j108 << 21);
        long j111 = (j91 + 1048576) >> 21;
        long j112 = ((j80 + (j55 * 136657)) - (j88 * 683901)) + j111;
        long j113 = j91 - (j111 << 21);
        long j114 = (j90 + 1048576) >> 21;
        long j115 = j83 + j114;
        long j116 = j90 - (j114 << 21);
        long j117 = (j100 + 1048576) >> 21;
        long j118 = j104 + j117;
        long j119 = j100 - (j117 << 21);
        long j120 = (j103 + 1048576) >> 21;
        long j121 = j107 + j120;
        long j122 = j103 - (j120 << 21);
        long j123 = (j106 + 1048576) >> 21;
        long j124 = j110 + j123;
        long j125 = j106 - (j123 << 21);
        long j126 = (j109 + 1048576) >> 21;
        long j127 = j113 + j126;
        long j128 = j109 - (j126 << 21);
        long j129 = (j112 + 1048576) >> 21;
        long j130 = j116 + j129;
        long j131 = j112 - (j129 << 21);
        long j132 = j121 - (j115 * 683901);
        long j133 = ((j118 - (j115 * 997805)) + (j130 * 136657)) - (j131 * 683901);
        long j134 = ((((j101 + (j115 * 470296)) + (j130 * 654183)) - (j131 * 997805)) + (j127 * 136657)) - (j128 * 683901);
        long j135 = j23 + (j124 * 666643);
        long j136 = j59 + (j128 * 666643) + (j124 * 470296);
        long j137 = j58 + (j127 * 666643) + (j128 * 470296) + (j124 * 654183);
        long j138 = (((j62 + (j131 * 666643)) + (j127 * 470296)) + (j128 * 654183)) - (j124 * 997805);
        long j139 = ((((j61 + (j130 * 666643)) + (j131 * 470296)) + (j127 * 654183)) - (j128 * 997805)) + (j124 * 136657);
        long j140 = (((((j65 + (j115 * 666643)) + (j130 * 470296)) + (j131 * 654183)) - (j127 * 997805)) + (j128 * 136657)) - (j124 * 683901);
        long j141 = (j135 + 1048576) >> 21;
        long j142 = j136 + j141;
        long j143 = j135 - (j141 << 21);
        long j144 = (j137 + 1048576) >> 21;
        long j145 = j138 + j144;
        long j146 = j137 - (j144 << 21);
        long j147 = (j139 + 1048576) >> 21;
        long j148 = j140 + j147;
        long j149 = j139 - (j147 << 21);
        long j150 = (j134 + 1048576) >> 21;
        long j151 = ((((j119 + (j115 * 654183)) - (j130 * 997805)) + (j131 * 136657)) - (j127 * 683901)) + j150;
        long j152 = j134 - (j150 << 21);
        long j153 = (j133 + 1048576) >> 21;
        long j154 = ((j122 + (j115 * 136657)) - (j130 * 683901)) + j153;
        long j155 = j133 - (j153 << 21);
        long j156 = (j132 + 1048576) >> 21;
        long j157 = j125 + j156;
        long j158 = j132 - (j156 << 21);
        long j159 = (j142 + 1048576) >> 21;
        long j160 = j146 + j159;
        long j161 = j142 - (j159 << 21);
        long j162 = (j145 + 1048576) >> 21;
        long j163 = j149 + j162;
        long j164 = j145 - (j162 << 21);
        long j165 = (j148 + 1048576) >> 21;
        long j166 = j152 + j165;
        long j167 = j148 - (j165 << 21);
        long j168 = (j151 + 1048576) >> 21;
        long j169 = j155 + j168;
        long j170 = j151 - (j168 << 21);
        long j171 = (j154 + 1048576) >> 21;
        long j172 = j158 + j171;
        long j173 = j154 - (j171 << 21);
        long j174 = (1048576 + j157) >> 21;
        long j175 = 0 + j174;
        long j176 = j143 + (j175 * 666643);
        long j177 = j161 + (j175 * 470296);
        long j178 = j160 + (j175 * 654183);
        long j179 = j164 - (j175 * 997805);
        long j180 = j163 + (j175 * 136657);
        long j181 = j167 - (j175 * 683901);
        long j182 = j176 >> 21;
        long j183 = j177 + j182;
        long j184 = j176 - (j182 << 21);
        long j185 = j183 >> 21;
        long j186 = j178 + j185;
        long j187 = j183 - (j185 << 21);
        long j188 = j186 >> 21;
        long j189 = j179 + j188;
        long j190 = j186 - (j188 << 21);
        long j191 = j189 >> 21;
        long j192 = j180 + j191;
        long j193 = j189 - (j191 << 21);
        long j194 = j192 >> 21;
        long j195 = j181 + j194;
        long j196 = j192 - (j194 << 21);
        long j197 = j195 >> 21;
        long j198 = j166 + j197;
        long j199 = j195 - (j197 << 21);
        long j200 = j198 >> 21;
        long j201 = j170 + j200;
        long j202 = j198 - (j200 << 21);
        long j203 = j201 >> 21;
        long j204 = j169 + j203;
        long j205 = j201 - (j203 << 21);
        long j206 = j204 >> 21;
        long j207 = j173 + j206;
        long j208 = j204 - (j206 << 21);
        long j209 = j207 >> 21;
        long j210 = j172 + j209;
        long j211 = j207 - (j209 << 21);
        long j212 = j210 >> 21;
        long j213 = (j157 - (j174 << 21)) + j212;
        long j214 = j210 - (j212 << 21);
        long j215 = j213 >> 21;
        long j216 = 0 + j215;
        long j217 = j213 - (j215 << 21);
        long j218 = j184 + (666643 * j216);
        long j219 = j218 >> 21;
        long j220 = j187 + (470296 * j216) + j219;
        long j221 = j220 >> 21;
        long j222 = j190 + (654183 * j216) + j221;
        long j223 = j220 - (j221 << 21);
        long j224 = j222 >> 21;
        long j225 = (j193 - (997805 * j216)) + j224;
        long j226 = j222 - (j224 << 21);
        long j227 = j225 >> 21;
        long j228 = j196 + (136657 * j216) + j227;
        long j229 = j225 - (j227 << 21);
        long j230 = j228 >> 21;
        long j231 = (j199 - (j216 * 683901)) + j230;
        long j232 = j228 - (j230 << 21);
        long j233 = j231 >> 21;
        long j234 = j202 + j233;
        long j235 = j231 - (j233 << 21);
        long j236 = j234 >> 21;
        long j237 = j205 + j236;
        long j238 = j234 - (j236 << 21);
        long j239 = j237 >> 21;
        long j240 = j208 + j239;
        long j241 = j237 - (j239 << 21);
        long j242 = j240 >> 21;
        long j243 = j211 + j242;
        long j244 = j243 >> 21;
        long j245 = j214 + j244;
        long j246 = j243 - (j244 << 21);
        long j247 = j245 >> 21;
        long j248 = j217 + j247;
        long j249 = j245 - (j247 << 21);
        s[0] = (byte) (j218 - (j219 << 21));
        s[1] = (byte) (r4 >> 8);
        s[2] = (byte) ((r4 >> 16) | (j223 << 5));
        s[3] = (byte) (j223 >> 3);
        s[4] = (byte) (j223 >> 11);
        s[5] = (byte) ((j223 >> 19) | (j226 << 2));
        s[6] = (byte) (j226 >> 6);
        s[7] = (byte) ((j226 >> 14) | (j229 << 7));
        s[8] = (byte) (j229 >> 1);
        s[9] = (byte) (j229 >> 9);
        s[10] = (byte) ((j229 >> 17) | (j232 << 4));
        s[11] = (byte) (j232 >> 4);
        s[12] = (byte) (j232 >> 12);
        s[13] = (byte) ((j232 >> 20) | (j235 << 1));
        s[14] = (byte) (j235 >> 7);
        s[15] = (byte) ((j235 >> 15) | (j238 << 6));
        s[16] = (byte) (j238 >> 2);
        s[17] = (byte) (j238 >> 10);
        s[18] = (byte) ((j238 >> 18) | (j241 << 3));
        s[19] = (byte) (j241 >> 5);
        s[20] = (byte) (j241 >> 13);
        s[21] = (byte) (j240 - (j242 << 21));
        s[22] = (byte) (r9 >> 8);
        s[23] = (byte) ((r9 >> 16) | (j246 << 5));
        s[24] = (byte) (j246 >> 3);
        s[25] = (byte) (j246 >> 11);
        s[26] = (byte) ((j246 >> 19) | (j249 << 2));
        s[27] = (byte) (j249 >> 6);
        s[28] = (byte) ((j249 >> 14) | (j248 << 7));
        s[29] = (byte) (j248 >> 1);
        s[30] = (byte) (j248 >> 9);
        s[31] = (byte) (j248 >> 17);
    }

    static byte[] getHashedScalar(final byte[] privateKey) throws GeneralSecurityException {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(privateKey, 0, 32);
        byte[] digest = engineFactory.digest();
        digest[0] = (byte) (digest[0] & 248);
        byte b = (byte) (digest[31] & ByteCompanionObject.MAX_VALUE);
        digest[31] = b;
        digest[31] = (byte) (b | 64);
        return digest;
    }

    static byte[] sign(final byte[] message, final byte[] publicKey, final byte[] hashedPrivateKey) throws GeneralSecurityException {
        byte[] copyOfRange = Arrays.copyOfRange(message, 0, message.length);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(hashedPrivateKey, 32, 32);
        engineFactory.update(copyOfRange);
        byte[] digest = engineFactory.digest();
        reduce(digest);
        byte[] copyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(digest).toBytes(), 0, 32);
        engineFactory.reset();
        engineFactory.update(copyOfRange2);
        engineFactory.update(publicKey);
        engineFactory.update(copyOfRange);
        byte[] digest2 = engineFactory.digest();
        reduce(digest2);
        byte[] bArr = new byte[32];
        mulAdd(bArr, digest2, hashedPrivateKey, digest);
        return Bytes.concat(copyOfRange2, bArr);
    }

    private static boolean isSmallerThanGroupOrder(byte[] s) {
        for (int i = 31; i >= 0; i--) {
            int i2 = s[i] & UByte.MAX_VALUE;
            int i3 = GROUP_ORDER[i] & UByte.MAX_VALUE;
            if (i2 != i3) {
                return i2 < i3;
            }
        }
        return false;
    }

    static boolean verify(final byte[] message, final byte[] signature, final byte[] publicKey) throws GeneralSecurityException {
        if (signature.length != 64) {
            return false;
        }
        byte[] copyOfRange = Arrays.copyOfRange(signature, 32, 64);
        if (!isSmallerThanGroupOrder(copyOfRange)) {
            return false;
        }
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(signature, 0, 32);
        engineFactory.update(publicKey);
        engineFactory.update(message);
        byte[] digest = engineFactory.digest();
        reduce(digest);
        byte[] bytes = doubleScalarMultVarTime(digest, XYZT.fromBytesNegateVarTime(publicKey), copyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != signature[i]) {
                return false;
            }
        }
        return true;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Ed25519Constants.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* loaded from: classes.dex */
final class Ed25519Constants {

    /* renamed from: B2 */
    static final Ed25519.CachedXYT[] f206B2;
    static final Ed25519.CachedXYT[][] B_TABLE;

    /* renamed from: D */
    static final long[] f207D;

    /* renamed from: D2 */
    static final long[] f208D2;
    private static final BigInteger D2_BI;
    private static final BigInteger D_BI;
    private static final BigInteger P_BI;
    static final long[] SQRTM1;
    private static final BigInteger SQRTM1_BI;

    Ed25519Constants() {
    }

    static {
        BigInteger subtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        P_BI = subtract;
        BigInteger mod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(subtract)).mod(subtract);
        D_BI = mod;
        BigInteger mod2 = BigInteger.valueOf(2L).multiply(mod).mod(subtract);
        D2_BI = mod2;
        BigInteger modPow = BigInteger.valueOf(2L).modPow(subtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), subtract);
        SQRTM1_BI = modPow;
        Point point = new Point();
        point.f210y = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(subtract)).mod(subtract);
        point.f209x = recoverX(point.f210y);
        f207D = Field25519.expand(toLittleEndian(mod));
        f208D2 = Field25519.expand(toLittleEndian(mod2));
        SQRTM1 = Field25519.expand(toLittleEndian(modPow));
        B_TABLE = (Ed25519.CachedXYT[][]) Array.newInstance((Class<?>) Ed25519.CachedXYT.class, 32, 8);
        Point point2 = point;
        for (int i = 0; i < 32; i++) {
            Point point3 = point2;
            for (int i2 = 0; i2 < 8; i2++) {
                B_TABLE[i][i2] = getCachedXYT(point3);
                point3 = edwards(point3, point2);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                point2 = edwards(point2, point2);
            }
        }
        Point edwards = edwards(point, point);
        f206B2 = new Ed25519.CachedXYT[8];
        for (int i4 = 0; i4 < 8; i4++) {
            f206B2[i4] = getCachedXYT(point);
            point = edwards(point, edwards);
        }
    }

    private static class Point {

        /* renamed from: x */
        private BigInteger f209x;

        /* renamed from: y */
        private BigInteger f210y;

        private Point() {
        }
    }

    private static BigInteger recoverX(BigInteger y) {
        BigInteger subtract = y.pow(2).subtract(BigInteger.ONE);
        BigInteger add = D_BI.multiply(y.pow(2)).add(BigInteger.ONE);
        BigInteger bigInteger = P_BI;
        BigInteger multiply = subtract.multiply(add.modInverse(bigInteger));
        BigInteger modPow = multiply.modPow(bigInteger.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger);
        if (!modPow.pow(2).subtract(multiply).mod(bigInteger).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(SQRTM1_BI).mod(bigInteger);
        }
        return modPow.testBit(0) ? bigInteger.subtract(modPow) : modPow;
    }

    private static Point edwards(Point a, Point b) {
        Point point = new Point();
        BigInteger multiply = D_BI.multiply(a.f209x.multiply(b.f209x).multiply(a.f210y).multiply(b.f210y));
        BigInteger bigInteger = P_BI;
        BigInteger mod = multiply.mod(bigInteger);
        point.f209x = a.f209x.multiply(b.f210y).add(b.f209x.multiply(a.f210y)).multiply(BigInteger.ONE.add(mod).modInverse(bigInteger)).mod(bigInteger);
        point.f210y = a.f210y.multiply(b.f210y).add(a.f209x.multiply(b.f209x)).multiply(BigInteger.ONE.subtract(mod).modInverse(bigInteger)).mod(bigInteger);
        return point;
    }

    private static byte[] toLittleEndian(BigInteger n) {
        byte[] bArr = new byte[32];
        byte[] byteArray = n.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = (32 - i) - 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point p) {
        BigInteger add = p.f210y.add(p.f209x);
        BigInteger bigInteger = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(add.mod(bigInteger))), Field25519.expand(toLittleEndian(p.f210y.subtract(p.f209x).mod(bigInteger))), Field25519.expand(toLittleEndian(D2_BI.multiply(p.f209x).multiply(p.f210y).mod(bigInteger))));
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Ed25519Sign.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Ed25519Sign implements PublicKeySign {
    public static final int SECRET_KEY_LEN = 32;
    private final byte[] hashedPrivateKey;
    private final byte[] publicKey;

    public Ed25519Sign(final byte[] privateKey) throws GeneralSecurityException {
        if (privateKey.length != 32) {
            throw new IllegalArgumentException(String.format("Given private key's length is not %s", 32));
        }
        byte[] hashedScalar = Ed25519.getHashedScalar(privateKey);
        this.hashedPrivateKey = hashedScalar;
        this.publicKey = Ed25519.scalarMultWithBaseToBytes(hashedScalar);
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        return Ed25519.sign(data, this.publicKey, this.hashedPrivateKey);
    }

    public static final class KeyPair {
        private final byte[] privateKey;
        private final byte[] publicKey;

        private KeyPair(final byte[] publicKey, final byte[] privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public byte[] getPublicKey() {
            byte[] bArr = this.publicKey;
            return Arrays.copyOf(bArr, bArr.length);
        }

        public byte[] getPrivateKey() {
            byte[] bArr = this.privateKey;
            return Arrays.copyOf(bArr, bArr.length);
        }

        public static KeyPair newKeyPair() throws GeneralSecurityException {
            byte[] randBytes = Random.randBytes(32);
            return new KeyPair(Ed25519.scalarMultWithBaseToBytes(Ed25519.getHashedScalar(randBytes)), randBytes);
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Ed25519Verify.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class Ed25519Verify implements PublicKeyVerify {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private final ImmutableByteArray publicKey;

    public Ed25519Verify(final byte[] publicKey) {
        if (publicKey.length != 32) {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
        }
        this.publicKey = ImmutableByteArray.m82of(publicKey);
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] signature, byte[] data) throws GeneralSecurityException {
        if (signature.length != 64) {
            throw new GeneralSecurityException(String.format("The length of the signature is not %s.", 64));
        }
        if (!Ed25519.verify(data, signature, this.publicKey.getBytes())) {
            throw new GeneralSecurityException("Signature check failed.");
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EllipticCurves.java =====
package com.google.crypto.tink.subtle;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class EllipticCurves {

    public enum CurveType {
        NIST_P256,
        NIST_P384,
        NIST_P521
    }

    public enum EcdsaEncoding {
        IEEE_P1363,
        DER
    }

    public enum PointFormatType {
        UNCOMPRESSED,
        COMPRESSED,
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED
    }

    public static ECParameterSpec getNistP256Params() {
        return getNistCurveSpec("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }

    public static ECParameterSpec getNistP384Params() {
        return getNistCurveSpec("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }

    public static ECParameterSpec getNistP521Params() {
        return getNistCurveSpec("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }

    static void checkPointOnCurve(ECPoint point, EllipticCurve ec) throws GeneralSecurityException {
        BigInteger modulus = getModulus(ec);
        BigInteger affineX = point.getAffineX();
        BigInteger affineY = point.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        }
        if (affineX.signum() == -1 || affineX.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        if (affineY.signum() == -1 || affineY.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("y is out of range");
        }
        if (!affineY.multiply(affineY).mod(modulus).equals(affineX.multiply(affineX).add(ec.getA()).multiply(affineX).add(ec.getB()).mod(modulus))) {
            throw new GeneralSecurityException("Point is not on curve");
        }
    }

    static void checkPublicKey(ECPublicKey key) throws GeneralSecurityException {
        checkPointOnCurve(key.getW(), key.getParams().getCurve());
    }

    public static boolean isNistEcParameterSpec(ECParameterSpec spec) {
        return isSameEcParameterSpec(spec, getNistP256Params()) || isSameEcParameterSpec(spec, getNistP384Params()) || isSameEcParameterSpec(spec, getNistP521Params());
    }

    public static boolean isSameEcParameterSpec(ECParameterSpec one, ECParameterSpec two) {
        return one.getCurve().equals(two.getCurve()) && one.getGenerator().equals(two.getGenerator()) && one.getOrder().equals(two.getOrder()) && one.getCofactor() == two.getCofactor();
    }

    public static void validatePublicKey(ECPublicKey publicKey, ECPrivateKey privateKey) throws GeneralSecurityException {
        validatePublicKeySpec(publicKey, privateKey);
        checkPointOnCurve(publicKey.getW(), privateKey.getParams().getCurve());
    }

    static void validatePublicKeySpec(ECPublicKey publicKey, ECPrivateKey privateKey) throws GeneralSecurityException {
        try {
            if (isSameEcParameterSpec(publicKey.getParams(), privateKey.getParams())) {
            } else {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }

    public static BigInteger getModulus(EllipticCurve curve) throws GeneralSecurityException {
        ECField field = curve.getField();
        if (field instanceof ECFieldFp) {
            return ((ECFieldFp) field).getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    static int fieldSizeInBits(EllipticCurve curve) throws GeneralSecurityException {
        return getModulus(curve).subtract(BigInteger.ONE).bitLength();
    }

    public static int fieldSizeInBytes(EllipticCurve curve) throws GeneralSecurityException {
        return (fieldSizeInBits(curve) + 7) / 8;
    }

    private static ECParameterSpec getNistCurveSpec(String decimalP, String decimalN, String hexB, String hexGX, String hexGY) {
        BigInteger bigInteger = new BigInteger(decimalP);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(hexB, 16)), new ECPoint(new BigInteger(hexGX, 16), new BigInteger(hexGY, 16)), new BigInteger(decimalN), 1);
    }

    protected static BigInteger modSqrt(BigInteger x, BigInteger p) throws GeneralSecurityException {
        BigInteger bigInteger;
        if (p.signum() != 1) {
            throw new InvalidAlgorithmParameterException("p must be positive");
        }
        BigInteger mod = x.mod(p);
        if (mod.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        int i = 0;
        if (p.testBit(0) && p.testBit(1)) {
            bigInteger = mod.modPow(p.add(BigInteger.ONE).shiftRight(2), p);
        } else if (!p.testBit(0) || p.testBit(1)) {
            bigInteger = null;
        } else {
            BigInteger bigInteger2 = BigInteger.ONE;
            BigInteger shiftRight = p.subtract(BigInteger.ONE).shiftRight(1);
            while (true) {
                BigInteger mod2 = bigInteger2.multiply(bigInteger2).subtract(mod).mod(p);
                if (mod2.equals(BigInteger.ZERO)) {
                    return bigInteger2;
                }
                BigInteger modPow = mod2.modPow(shiftRight, p);
                if (!modPow.add(BigInteger.ONE).equals(p)) {
                    if (!modPow.equals(BigInteger.ONE)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                    bigInteger2 = bigInteger2.add(BigInteger.ONE);
                    i++;
                    if (i == 128 && !p.isProbablePrime(80)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                } else {
                    BigInteger shiftRight2 = p.add(BigInteger.ONE).shiftRight(1);
                    BigInteger bigInteger3 = BigInteger.ONE;
                    BigInteger bigInteger4 = bigInteger3;
                    BigInteger bigInteger5 = bigInteger2;
                    for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                        BigInteger multiply = bigInteger5.multiply(bigInteger4);
                        bigInteger5 = bigInteger5.multiply(bigInteger5).add(bigInteger4.multiply(bigInteger4).mod(p).multiply(mod2)).mod(p);
                        bigInteger4 = multiply.add(multiply).mod(p);
                        if (shiftRight2.testBit(bitLength)) {
                            BigInteger mod3 = bigInteger5.multiply(bigInteger2).add(bigInteger4.multiply(mod2)).mod(p);
                            bigInteger4 = bigInteger2.multiply(bigInteger4).add(bigInteger5).mod(p);
                            bigInteger5 = mod3;
                        }
                    }
                    bigInteger = bigInteger5;
                }
            }
        }
        if (bigInteger == null || bigInteger.multiply(bigInteger).mod(p).compareTo(mod) == 0) {
            return bigInteger;
        }
        throw new GeneralSecurityException("Could not find a modular square root");
    }

    public static BigInteger getY(BigInteger x, boolean lsb, EllipticCurve curve) throws GeneralSecurityException {
        BigInteger modulus = getModulus(curve);
        BigInteger modSqrt = modSqrt(x.multiply(x).add(curve.getA()).multiply(x).add(curve.getB()).mod(modulus), modulus);
        return lsb != modSqrt.testBit(0) ? modulus.subtract(modSqrt).mod(modulus) : modSqrt;
    }

    private static byte[] toMinimalSignedNumber(byte[] bs) {
        int i = 0;
        while (i < bs.length && bs[i] == 0) {
            i++;
        }
        if (i == bs.length) {
            i = bs.length - 1;
        }
        int i2 = (bs[i] & ByteCompanionObject.MIN_VALUE) == 128 ? 1 : 0;
        byte[] bArr = new byte[(bs.length - i) + i2];
        System.arraycopy(bs, i, bArr, i2, bs.length - i);
        return bArr;
    }

    public static byte[] ecdsaIeee2Der(byte[] ieee) throws GeneralSecurityException {
        byte[] bArr;
        int i;
        if (ieee.length % 2 != 0 || ieee.length == 0 || ieee.length > 132) {
            throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
        }
        byte[] minimalSignedNumber = toMinimalSignedNumber(Arrays.copyOf(ieee, ieee.length / 2));
        byte[] minimalSignedNumber2 = toMinimalSignedNumber(Arrays.copyOfRange(ieee, ieee.length / 2, ieee.length));
        int length = minimalSignedNumber.length + 2 + 1 + 1 + minimalSignedNumber2.length;
        if (length >= 128) {
            bArr = new byte[length + 3];
            bArr[0] = 48;
            bArr[1] = -127;
            bArr[2] = (byte) length;
            i = 3;
        } else {
            bArr = new byte[length + 2];
            bArr[0] = 48;
            bArr[1] = (byte) length;
            i = 2;
        }
        int i2 = i + 1;
        bArr[i] = 2;
        int i3 = i2 + 1;
        bArr[i2] = (byte) minimalSignedNumber.length;
        System.arraycopy(minimalSignedNumber, 0, bArr, i3, minimalSignedNumber.length);
        int length2 = i3 + minimalSignedNumber.length;
        int i4 = length2 + 1;
        bArr[length2] = 2;
        bArr[i4] = (byte) minimalSignedNumber2.length;
        System.arraycopy(minimalSignedNumber2, 0, bArr, i4 + 1, minimalSignedNumber2.length);
        return bArr;
    }

    public static byte[] ecdsaDer2Ieee(byte[] der, int ieeeLength) throws GeneralSecurityException {
        if (!isValidDerEncoding(der)) {
            throw new GeneralSecurityException("Invalid DER encoding");
        }
        byte[] bArr = new byte[ieeeLength];
        int i = ((der[1] & UByte.MAX_VALUE) >= 128 ? 3 : 2) + 1;
        int i2 = i + 1;
        int i3 = der[i];
        int i4 = der[i2] == 0 ? 1 : 0;
        System.arraycopy(der, i2 + i4, bArr, ((ieeeLength / 2) - i3) + i4, i3 - i4);
        int i5 = i2 + i3 + 1;
        int i6 = i5 + 1;
        int i7 = der[i5];
        int i8 = der[i6] != 0 ? 0 : 1;
        System.arraycopy(der, i6 + i8, bArr, (ieeeLength - i7) + i8, i7 - i8);
        return bArr;
    }

    public static boolean isValidDerEncoding(final byte[] sig) {
        int i;
        if (sig.length < 8 || sig[0] != 48) {
            return false;
        }
        int i2 = sig[1] & UByte.MAX_VALUE;
        if (i2 == 129) {
            i2 = sig[2] & UByte.MAX_VALUE;
            if (i2 < 128) {
                return false;
            }
            i = 2;
        } else {
            if (i2 == 128 || i2 > 129) {
                return false;
            }
            i = 1;
        }
        if (i2 != (sig.length - 1) - i) {
            return false;
        }
        int i3 = i + 1;
        if (sig[i3] != 2) {
            return false;
        }
        int i4 = i3 + 1;
        int i5 = sig[i4] & UByte.MAX_VALUE;
        int i6 = i4 + 1 + i5 + 1;
        if (i6 >= sig.length || i5 == 0) {
            return false;
        }
        int i7 = i + 3;
        byte b = sig[i7];
        if ((b & UByte.MAX_VALUE) >= 128) {
            return false;
        }
        if ((i5 > 1 && b == 0 && (sig[i + 4] & UByte.MAX_VALUE) < 128) || sig[i7 + i5] != 2) {
            return false;
        }
        int i8 = sig[i6] & UByte.MAX_VALUE;
        if (i6 + 1 + i8 != sig.length || i8 == 0) {
            return false;
        }
        byte b2 = sig[i + 5 + i5];
        if ((b2 & UByte.MAX_VALUE) >= 128) {
            return false;
        }
        return i8 <= 1 || b2 != 0 || (sig[(i + 6) + i5] & UByte.MAX_VALUE) >= 128;
    }

    public static int encodingSizeInBytes(EllipticCurve curve, PointFormatType format) throws GeneralSecurityException {
        int fieldSizeInBytes = fieldSizeInBytes(curve);
        int i = C07231.f212xc12280c3[format.ordinal()];
        if (i == 1) {
            return (fieldSizeInBytes * 2) + 1;
        }
        if (i == 2) {
            return fieldSizeInBytes * 2;
        }
        if (i == 3) {
            return fieldSizeInBytes + 1;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    @Deprecated
    public static ECPoint ecPointDecode(EllipticCurve curve, PointFormatType format, byte[] encoded) throws GeneralSecurityException {
        return pointDecode(curve, format, encoded);
    }

    public static ECPoint pointDecode(CurveType curveType, PointFormatType format, byte[] encoded) throws GeneralSecurityException {
        return pointDecode(getCurveSpec(curveType).getCurve(), format, encoded);
    }

    public static ECPoint pointDecode(EllipticCurve curve, PointFormatType format, byte[] encoded) throws GeneralSecurityException {
        int fieldSizeInBytes = fieldSizeInBytes(curve);
        int i = C07231.f212xc12280c3[format.ordinal()];
        boolean z = false;
        if (i == 1) {
            if (encoded.length != (fieldSizeInBytes * 2) + 1) {
                throw new GeneralSecurityException("invalid point size");
            }
            if (encoded[0] != 4) {
                throw new GeneralSecurityException("invalid point format");
            }
            int i2 = fieldSizeInBytes + 1;
            ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(encoded, 1, i2)), new BigInteger(1, Arrays.copyOfRange(encoded, i2, encoded.length)));
            checkPointOnCurve(eCPoint, curve);
            return eCPoint;
        }
        if (i == 2) {
            if (encoded.length != fieldSizeInBytes * 2) {
                throw new GeneralSecurityException("invalid point size");
            }
            ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(encoded, 0, fieldSizeInBytes)), new BigInteger(1, Arrays.copyOfRange(encoded, fieldSizeInBytes, encoded.length)));
            checkPointOnCurve(eCPoint2, curve);
            return eCPoint2;
        }
        if (i == 3) {
            BigInteger modulus = getModulus(curve);
            if (encoded.length != fieldSizeInBytes + 1) {
                throw new GeneralSecurityException("compressed point has wrong length");
            }
            byte b = encoded[0];
            if (b != 2) {
                if (b != 3) {
                    throw new GeneralSecurityException("invalid format");
                }
                z = true;
            }
            BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(encoded, 1, encoded.length));
            if (bigInteger.signum() == -1 || bigInteger.compareTo(modulus) >= 0) {
                throw new GeneralSecurityException("x is out of range");
            }
            return new ECPoint(bigInteger, getY(bigInteger, z, curve));
        }
        throw new GeneralSecurityException("invalid format:" + format);
    }

    public static byte[] pointEncode(CurveType curveType, PointFormatType format, ECPoint point) throws GeneralSecurityException {
        return pointEncode(getCurveSpec(curveType).getCurve(), format, point);
    }

    public static byte[] pointEncode(EllipticCurve curve, PointFormatType format, ECPoint point) throws GeneralSecurityException {
        checkPointOnCurve(point, curve);
        int fieldSizeInBytes = fieldSizeInBytes(curve);
        int i = C07231.f212xc12280c3[format.ordinal()];
        if (i == 1) {
            int i2 = (fieldSizeInBytes * 2) + 1;
            byte[] bArr = new byte[i2];
            byte[] byteArray = point.getAffineX().toByteArray();
            byte[] byteArray2 = point.getAffineY().toByteArray();
            System.arraycopy(byteArray2, 0, bArr, i2 - byteArray2.length, byteArray2.length);
            System.arraycopy(byteArray, 0, bArr, (fieldSizeInBytes + 1) - byteArray.length, byteArray.length);
            bArr[0] = 4;
            return bArr;
        }
        if (i != 2) {
            if (i == 3) {
                int i3 = fieldSizeInBytes + 1;
                byte[] bArr2 = new byte[i3];
                byte[] byteArray3 = point.getAffineX().toByteArray();
                System.arraycopy(byteArray3, 0, bArr2, i3 - byteArray3.length, byteArray3.length);
                bArr2[0] = (byte) (point.getAffineY().testBit(0) ? 3 : 2);
                return bArr2;
            }
            throw new GeneralSecurityException("invalid format:" + format);
        }
        int i4 = fieldSizeInBytes * 2;
        byte[] bArr3 = new byte[i4];
        byte[] byteArray4 = point.getAffineX().toByteArray();
        if (byteArray4.length > fieldSizeInBytes) {
            byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - fieldSizeInBytes, byteArray4.length);
        }
        byte[] byteArray5 = point.getAffineY().toByteArray();
        if (byteArray5.length > fieldSizeInBytes) {
            byteArray5 = Arrays.copyOfRange(byteArray5, byteArray5.length - fieldSizeInBytes, byteArray5.length);
        }
        System.arraycopy(byteArray5, 0, bArr3, i4 - byteArray5.length, byteArray5.length);
        System.arraycopy(byteArray4, 0, bArr3, fieldSizeInBytes - byteArray4.length, byteArray4.length);
        return bArr3;
    }

    /* renamed from: com.google.crypto.tink.subtle.EllipticCurves$1 */
    static /* synthetic */ class C07231 {

        /* renamed from: $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType */
        static final /* synthetic */ int[] f211x7c2ee98b;

        /* renamed from: $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType */
        static final /* synthetic */ int[] f212xc12280c3;

        static {
            int[] iArr = new int[CurveType.values().length];
            f211x7c2ee98b = iArr;
            try {
                iArr[CurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f211x7c2ee98b[CurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f211x7c2ee98b[CurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[PointFormatType.values().length];
            f212xc12280c3 = iArr2;
            try {
                iArr2[PointFormatType.UNCOMPRESSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f212xc12280c3[PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f212xc12280c3[PointFormatType.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static ECParameterSpec getCurveSpec(CurveType curve) throws NoSuchAlgorithmException {
        int i = C07231.f211x7c2ee98b[curve.ordinal()];
        if (i == 1) {
            return getNistP256Params();
        }
        if (i == 2) {
            return getNistP384Params();
        }
        if (i == 3) {
            return getNistP521Params();
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + curve);
    }

    public static ECPublicKey getEcPublicKey(final byte[] x509PublicKey) throws GeneralSecurityException {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new X509EncodedKeySpec(x509PublicKey));
    }

    public static ECPublicKey getEcPublicKey(CurveType curve, PointFormatType pointFormat, final byte[] publicKey) throws GeneralSecurityException {
        return getEcPublicKey(getCurveSpec(curve), pointFormat, publicKey);
    }

    public static ECPublicKey getEcPublicKey(ECParameterSpec spec, PointFormatType pointFormat, final byte[] publicKey) throws GeneralSecurityException {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(pointDecode(spec.getCurve(), pointFormat, publicKey), spec));
    }

    public static ECPublicKey getEcPublicKey(CurveType curve, final byte[] x, final byte[] y) throws GeneralSecurityException {
        ECParameterSpec curveSpec = getCurveSpec(curve);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, x), new BigInteger(1, y));
        checkPointOnCurve(eCPoint, curveSpec.getCurve());
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, curveSpec));
    }

    public static ECPrivateKey getEcPrivateKey(final byte[] pkcs8PrivateKey) throws GeneralSecurityException {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(pkcs8PrivateKey));
    }

    public static ECPrivateKey getEcPrivateKey(CurveType curve, final byte[] keyValue) throws GeneralSecurityException {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, keyValue), getCurveSpec(curve)));
    }

    public static KeyPair generateKeyPair(CurveType curve) throws GeneralSecurityException {
        return generateKeyPair(getCurveSpec(curve));
    }

    public static KeyPair generateKeyPair(ECParameterSpec spec) throws GeneralSecurityException {
        KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("EC");
        engineFactory.initialize(spec);
        return engineFactory.generateKeyPair();
    }

    private static void validateSharedSecret(byte[] secret, ECPrivateKey privateKey) throws GeneralSecurityException {
        EllipticCurve curve = privateKey.getParams().getCurve();
        BigInteger bigInteger = new BigInteger(1, secret);
        if (bigInteger.signum() == -1 || bigInteger.compareTo(getModulus(curve)) >= 0) {
            throw new GeneralSecurityException("shared secret is out of range");
        }
        getY(bigInteger, true, curve);
    }

    public static byte[] computeSharedSecret(ECPrivateKey myPrivateKey, ECPublicKey peerPublicKey) throws GeneralSecurityException {
        validatePublicKeySpec(peerPublicKey, myPrivateKey);
        return computeSharedSecret(myPrivateKey, peerPublicKey.getW());
    }

    public static byte[] computeSharedSecret(ECPrivateKey myPrivateKey, ECPoint publicPoint) throws GeneralSecurityException {
        checkPointOnCurve(publicPoint, myPrivateKey.getParams().getCurve());
        PublicKey generatePublic = EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(publicPoint, myPrivateKey.getParams()));
        KeyAgreement engineFactory = EngineFactory.KEY_AGREEMENT.getInstance("ECDH");
        engineFactory.init(myPrivateKey);
        try {
            engineFactory.doPhase(generatePublic, true);
            byte[] generateSecret = engineFactory.generateSecret();
            validateSharedSecret(generateSecret, myPrivateKey);
            return generateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EncryptThenAuthenticate.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Mac;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class EncryptThenAuthenticate implements Aead {
    private final IndCpaCipher cipher;
    private final Mac mac;
    private final int macLength;

    public EncryptThenAuthenticate(final IndCpaCipher cipher, final Mac mac, int macLength) {
        this.cipher = cipher;
        this.mac = mac;
        this.macLength = macLength;
    }

    public static Aead newAesCtrHmac(final byte[] aesCtrKey, int ivSize, String hmacAlgorithm, final byte[] hmacKey, int tagSize) throws GeneralSecurityException {
        return new EncryptThenAuthenticate(new AesCtrJceCipher(aesCtrKey, ivSize), new PrfMac(new PrfHmacJce(hmacAlgorithm, new SecretKeySpec(hmacKey, "HMAC")), tagSize), tagSize);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] encrypt = this.cipher.encrypt(plaintext);
        if (associatedData == null) {
            associatedData = new byte[0];
        }
        return Bytes.concat(encrypt, this.mac.computeMac(Bytes.concat(associatedData, encrypt, Arrays.copyOf(ByteBuffer.allocate(8).putLong(associatedData.length * 8).array(), 8))));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        int length = ciphertext.length;
        int i = this.macLength;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] copyOfRange = Arrays.copyOfRange(ciphertext, 0, ciphertext.length - i);
        byte[] copyOfRange2 = Arrays.copyOfRange(ciphertext, ciphertext.length - this.macLength, ciphertext.length);
        if (associatedData == null) {
            associatedData = new byte[0];
        }
        this.mac.verifyMac(copyOfRange2, Bytes.concat(associatedData, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(associatedData.length * 8).array(), 8)));
        return this.cipher.decrypt(copyOfRange);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EngineFactory.java =====
package com.google.crypto.tink.subtle;

import com.google.android.gms.security.ProviderInstaller;
import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class EngineFactory<T_WRAPPER extends EngineWrapper<T_ENGINE>, T_ENGINE> {
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> CIPHER;
    private static final boolean DEFAULT_LET_FALLBACK = true;
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> KEY_AGREEMENT;
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> KEY_FACTORY;
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR;
    public static final EngineFactory<EngineWrapper.TMac, Mac> MAC;
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> MESSAGE_DIGEST;
    public static final EngineFactory<EngineWrapper.TSignature, Signature> SIGNATURE;
    private static final List<Provider> defaultPolicy;
    private static final Logger logger = Logger.getLogger(EngineFactory.class.getName());
    private T_WRAPPER instanceBuilder;
    private boolean letFallback;
    private List<Provider> policy;

    static {
        if (SubtleUtil.isAndroid()) {
            defaultPolicy = toProviderList(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL");
        } else {
            defaultPolicy = new ArrayList();
        }
        CIPHER = new EngineFactory<>(new EngineWrapper.TCipher());
        MAC = new EngineFactory<>(new EngineWrapper.TMac());
        SIGNATURE = new EngineFactory<>(new EngineWrapper.TSignature());
        MESSAGE_DIGEST = new EngineFactory<>(new EngineWrapper.TMessageDigest());
        KEY_AGREEMENT = new EngineFactory<>(new EngineWrapper.TKeyAgreement());
        KEY_PAIR_GENERATOR = new EngineFactory<>(new EngineWrapper.TKeyPairGenerator());
        KEY_FACTORY = new EngineFactory<>(new EngineWrapper.TKeyFactory());
    }

    public static final EngineFactory<EngineWrapper.TCipher, Cipher> getCustomCipherProvider(boolean letFallbackToDefault, String... providerNames) {
        return new EngineFactory<>(new EngineWrapper.TCipher(), toProviderList(providerNames), letFallbackToDefault);
    }

    public static final EngineFactory<EngineWrapper.TMac, Mac> getCustomMacProvider(boolean letFallbackToDefault, String... providerNames) {
        return new EngineFactory<>(new EngineWrapper.TMac(), toProviderList(providerNames), letFallbackToDefault);
    }

    public static final EngineFactory<EngineWrapper.TSignature, Signature> getCustomSignatureProvider(boolean letFallbackToDefault, String... providerNames) {
        return new EngineFactory<>(new EngineWrapper.TSignature(), toProviderList(providerNames), letFallbackToDefault);
    }

    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> getCustomMessageDigestProvider(boolean letFallbackToDefault, String... providerNames) {
        return new EngineFactory<>(new EngineWrapper.TMessageDigest(), toProviderList(providerNames), letFallbackToDefault);
    }

    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> getCustomKeyAgreementProvider(boolean letFallbackToDefault, String... providerNames) {
        return new EngineFactory<>(new EngineWrapper.TKeyAgreement(), toProviderList(providerNames), letFallbackToDefault);
    }

    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> getCustomKeyPairGeneratorProvider(boolean letFallbackToDefault, String... providerNames) {
        return new EngineFactory<>(new EngineWrapper.TKeyPairGenerator(), toProviderList(providerNames), letFallbackToDefault);
    }

    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> getCustomKeyFactoryProvider(boolean letFallbackToDefault, String... providerNames) {
        return new EngineFactory<>(new EngineWrapper.TKeyFactory(), toProviderList(providerNames), letFallbackToDefault);
    }

    public static List<Provider> toProviderList(String... providerNames) {
        ArrayList arrayList = new ArrayList();
        for (String str : providerNames) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                logger.info(String.format("Provider %s not available", str));
            }
        }
        return arrayList;
    }

    public EngineFactory(T_WRAPPER instanceBuilder) {
        this.instanceBuilder = instanceBuilder;
        this.policy = defaultPolicy;
        this.letFallback = true;
    }

    public EngineFactory(T_WRAPPER instanceBuilder, List<Provider> policy) {
        this.instanceBuilder = instanceBuilder;
        this.policy = policy;
        this.letFallback = true;
    }

    public EngineFactory(T_WRAPPER instanceBuilder, List<Provider> policy, boolean letFallback) {
        this.instanceBuilder = instanceBuilder;
        this.policy = policy;
        this.letFallback = letFallback;
    }

    public T_ENGINE getInstance(String str) throws GeneralSecurityException {
        Iterator<Provider> it = this.policy.iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return (T_ENGINE) this.instanceBuilder.getInstance(str, it.next());
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.letFallback) {
            return (T_ENGINE) this.instanceBuilder.getInstance(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/EngineWrapper.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public interface EngineWrapper<T> {
    T getInstance(String algorithm, Provider provider) throws GeneralSecurityException;

    public static class TCipher implements EngineWrapper<Cipher> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public Cipher getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Cipher.getInstance(algorithm);
            }
            return Cipher.getInstance(algorithm, provider);
        }
    }

    public static class TMac implements EngineWrapper<Mac> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public Mac getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Mac.getInstance(algorithm);
            }
            return Mac.getInstance(algorithm, provider);
        }
    }

    public static class TKeyPairGenerator implements EngineWrapper<KeyPairGenerator> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public KeyPairGenerator getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return KeyPairGenerator.getInstance(algorithm);
            }
            return KeyPairGenerator.getInstance(algorithm, provider);
        }
    }

    public static class TMessageDigest implements EngineWrapper<MessageDigest> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public MessageDigest getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return MessageDigest.getInstance(algorithm);
            }
            return MessageDigest.getInstance(algorithm, provider);
        }
    }

    public static class TSignature implements EngineWrapper<Signature> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public Signature getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Signature.getInstance(algorithm);
            }
            return Signature.getInstance(algorithm, provider);
        }
    }

    public static class TKeyFactory implements EngineWrapper<KeyFactory> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public KeyFactory getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return KeyFactory.getInstance(algorithm);
            }
            return KeyFactory.getInstance(algorithm, provider);
        }
    }

    public static class TKeyAgreement implements EngineWrapper<KeyAgreement> {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public KeyAgreement getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return KeyAgreement.getInstance(algorithm);
            }
            return KeyAgreement.getInstance(algorithm, provider);
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Enums.java =====
package com.google.crypto.tink.subtle;

/* loaded from: classes.dex */
public final class Enums {

    public enum HashType {
        SHA1,
        SHA256,
        SHA384,
        SHA512
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Field25519.java =====
package com.google.crypto.tink.subtle;

import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes.dex */
final class Field25519 {
    static final int FIELD_LEN = 32;
    static final int LIMB_CNT = 10;
    private static final long TWO_TO_25 = 33554432;
    private static final long TWO_TO_26 = 67108864;
    private static final int[] EXPAND_START = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] EXPAND_SHIFT = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] MASK = {67108863, 33554431};
    private static final int[] SHIFT = {26, 25};

    /* renamed from: eq */
    private static int m81eq(int a, int b) {
        int i = ~(a ^ b);
        int i2 = i & (i << 16);
        int i3 = i2 & (i2 << 8);
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return (i5 & (i5 << 1)) >> 31;
    }

    private static int gte(int a, int b) {
        return ~((a - b) >> 31);
    }

    Field25519() {
    }

    static void sum(long[] output, long[] in1, long[] in2) {
        for (int i = 0; i < 10; i++) {
            output[i] = in1[i] + in2[i];
        }
    }

    static void sum(long[] output, long[] in) {
        sum(output, output, in);
    }

    static void sub(long[] output, long[] in1, long[] in2) {
        for (int i = 0; i < 10; i++) {
            output[i] = in1[i] - in2[i];
        }
    }

    static void sub(long[] output, long[] in) {
        sub(output, in, output);
    }

    static void scalarProduct(long[] output, long[] in, long scalar) {
        for (int i = 0; i < 10; i++) {
            output[i] = in[i] * scalar;
        }
    }

    static void product(long[] out, long[] in2, long[] in) {
        out[0] = in2[0] * in[0];
        long j = in2[0];
        long j2 = in[1] * j;
        long j3 = in2[1];
        long j4 = in[0];
        out[1] = j2 + (j3 * j4);
        long j5 = in2[1];
        long j6 = in[1];
        out[2] = (j5 * 2 * j6) + (in[2] * j) + (in2[2] * j4);
        long j7 = in[2];
        long j8 = in2[2];
        out[3] = (j5 * j7) + (j8 * j6) + (in[3] * j) + (in2[3] * j4);
        long j9 = in[3];
        long j10 = in2[3];
        out[4] = (j8 * j7) + (((j5 * j9) + (j10 * j6)) * 2) + (in[4] * j) + (in2[4] * j4);
        long j11 = in[4];
        long j12 = in2[4];
        out[5] = (j8 * j9) + (j10 * j7) + (j5 * j11) + (j12 * j6) + (in[5] * j) + (in2[5] * j4);
        long j13 = in[5];
        long j14 = in2[5];
        out[6] = (((j10 * j9) + (j5 * j13) + (j14 * j6)) * 2) + (j8 * j11) + (j12 * j7) + (in[6] * j) + (in2[6] * j4);
        long j15 = in[6];
        long j16 = in2[6];
        out[7] = (j10 * j11) + (j12 * j9) + (j8 * j13) + (j14 * j7) + (j5 * j15) + (j16 * j6) + (in[7] * j) + (in2[7] * j4);
        long j17 = in[7];
        long j18 = in2[7];
        out[8] = (j12 * j11) + (((j10 * j13) + (j14 * j9) + (j5 * j17) + (j18 * j6)) * 2) + (j8 * j15) + (j16 * j7) + (in[8] * j) + (in2[8] * j4);
        long j19 = in[8];
        long j20 = in2[8];
        out[9] = (j12 * j13) + (j14 * j11) + (j10 * j15) + (j16 * j9) + (j8 * j17) + (j18 * j7) + (j5 * j19) + (j20 * j6) + (j * in[9]) + (in2[9] * j4);
        long j21 = in[9];
        long j22 = in2[9];
        out[10] = (((j14 * j13) + (j10 * j17) + (j18 * j9) + (j5 * j21) + (j6 * j22)) * 2) + (j12 * j15) + (j16 * j11) + (j8 * j19) + (j20 * j7);
        out[11] = (j14 * j15) + (j16 * j13) + (j12 * j17) + (j18 * j11) + (j10 * j19) + (j20 * j9) + (j8 * j21) + (j7 * j22);
        out[12] = (j16 * j15) + (((j14 * j17) + (j18 * j13) + (j10 * j21) + (j9 * j22)) * 2) + (j12 * j19) + (j20 * j11);
        out[13] = (j16 * j17) + (j18 * j15) + (j14 * j19) + (j20 * j13) + (j12 * j21) + (j11 * j22);
        out[14] = (((j18 * j17) + (j14 * j21) + (j13 * j22)) * 2) + (j16 * j19) + (j20 * j15);
        out[15] = (j18 * j19) + (j20 * j17) + (j16 * j21) + (j15 * j22);
        out[16] = (j20 * j19) + (((j18 * j21) + (j17 * j22)) * 2);
        out[17] = (j20 * j21) + (j19 * j22);
        out[18] = j22 * 2 * j21;
    }

    static void reduce(long[] input, long[] output) {
        if (input.length != 19) {
            long[] jArr = new long[19];
            System.arraycopy(input, 0, jArr, 0, input.length);
            input = jArr;
        }
        reduceSizeByModularReduction(input);
        reduceCoefficients(input);
        System.arraycopy(input, 0, output, 0, 10);
    }

    static void reduceSizeByModularReduction(long[] output) {
        long j = output[8];
        long j2 = output[18];
        long j3 = j + (j2 << 4);
        output[8] = j3;
        long j4 = j3 + (j2 << 1);
        output[8] = j4;
        output[8] = j4 + j2;
        long j5 = output[7];
        long j6 = output[17];
        long j7 = j5 + (j6 << 4);
        output[7] = j7;
        long j8 = j7 + (j6 << 1);
        output[7] = j8;
        output[7] = j8 + j6;
        long j9 = output[6];
        long j10 = output[16];
        long j11 = j9 + (j10 << 4);
        output[6] = j11;
        long j12 = j11 + (j10 << 1);
        output[6] = j12;
        output[6] = j12 + j10;
        long j13 = output[5];
        long j14 = output[15];
        long j15 = j13 + (j14 << 4);
        output[5] = j15;
        long j16 = j15 + (j14 << 1);
        output[5] = j16;
        output[5] = j16 + j14;
        long j17 = output[4];
        long j18 = output[14];
        long j19 = j17 + (j18 << 4);
        output[4] = j19;
        long j20 = j19 + (j18 << 1);
        output[4] = j20;
        output[4] = j20 + j18;
        long j21 = output[3];
        long j22 = output[13];
        long j23 = j21 + (j22 << 4);
        output[3] = j23;
        long j24 = j23 + (j22 << 1);
        output[3] = j24;
        output[3] = j24 + j22;
        long j25 = output[2];
        long j26 = output[12];
        long j27 = j25 + (j26 << 4);
        output[2] = j27;
        long j28 = j27 + (j26 << 1);
        output[2] = j28;
        output[2] = j28 + j26;
        long j29 = output[1];
        long j30 = output[11];
        long j31 = j29 + (j30 << 4);
        output[1] = j31;
        long j32 = j31 + (j30 << 1);
        output[1] = j32;
        output[1] = j32 + j30;
        long j33 = output[0];
        long j34 = output[10];
        long j35 = j33 + (j34 << 4);
        output[0] = j35;
        long j36 = j35 + (j34 << 1);
        output[0] = j36;
        output[0] = j36 + j34;
    }

    static void reduceCoefficients(long[] output) {
        output[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = output[i];
            long j2 = j / TWO_TO_26;
            output[i] = j - (j2 << 26);
            int i2 = i + 1;
            long j3 = output[i2] + j2;
            output[i2] = j3;
            long j4 = j3 / TWO_TO_25;
            output[i2] = j3 - (j4 << 25);
            i += 2;
            output[i] = output[i] + j4;
        }
        long j5 = output[0];
        long j6 = output[10];
        long j7 = j5 + (j6 << 4);
        output[0] = j7;
        long j8 = j7 + (j6 << 1);
        output[0] = j8;
        long j9 = j8 + j6;
        output[0] = j9;
        output[10] = 0;
        long j10 = j9 / TWO_TO_26;
        output[0] = j9 - (j10 << 26);
        output[1] = output[1] + j10;
    }

    static void mult(long[] output, long[] in, long[] in2) {
        long[] jArr = new long[19];
        product(jArr, in, in2);
        reduce(jArr, output);
    }

    private static void squareInner(long[] out, long[] in) {
        long j = in[0];
        out[0] = j * j;
        long j2 = in[0];
        out[1] = j2 * 2 * in[1];
        long j3 = in[1];
        out[2] = ((j3 * j3) + (in[2] * j2)) * 2;
        long j4 = in[2];
        out[3] = ((j3 * j4) + (in[3] * j2)) * 2;
        long j5 = in[3];
        out[4] = (j4 * j4) + (j3 * 4 * j5) + (j2 * 2 * in[4]);
        long j6 = in[4];
        out[5] = ((j4 * j5) + (j3 * j6) + (in[5] * j2)) * 2;
        long j7 = (j5 * j5) + (j4 * j6) + (in[6] * j2);
        long j8 = in[5];
        out[6] = (j7 + (j3 * 2 * j8)) * 2;
        long j9 = in[6];
        out[7] = ((j5 * j6) + (j4 * j8) + (j3 * j9) + (in[7] * j2)) * 2;
        long j10 = (j4 * j9) + (in[8] * j2);
        long j11 = in[7];
        out[8] = (j6 * j6) + ((j10 + (((j3 * j11) + (j5 * j8)) * 2)) * 2);
        long j12 = in[8];
        out[9] = ((j6 * j8) + (j5 * j9) + (j4 * j11) + (j3 * j12) + (j2 * in[9])) * 2;
        long j13 = in[9];
        out[10] = ((j8 * j8) + (j6 * j9) + (j4 * j12) + (((j5 * j11) + (j3 * j13)) * 2)) * 2;
        out[11] = ((j8 * j9) + (j6 * j11) + (j5 * j12) + (j4 * j13)) * 2;
        out[12] = (j9 * j9) + (((j6 * j12) + (((j8 * j11) + (j5 * j13)) * 2)) * 2);
        out[13] = ((j9 * j11) + (j8 * j12) + (j6 * j13)) * 2;
        out[14] = ((j11 * j11) + (j9 * j12) + (j8 * 2 * j13)) * 2;
        out[15] = ((j11 * j12) + (j9 * j13)) * 2;
        out[16] = (j12 * j12) + (j11 * 4 * j13);
        out[17] = j12 * 2 * j13;
        out[18] = 2 * j13 * j13;
    }

    static void square(long[] output, long[] in) {
        long[] jArr = new long[19];
        squareInner(jArr, in);
        reduce(jArr, output);
    }

    static long[] expand(byte[] input) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i2 = EXPAND_START[i];
            jArr[i] = (((((input[i2] & UByte.MAX_VALUE) | ((input[i2 + 1] & UByte.MAX_VALUE) << 8)) | ((input[i2 + 2] & UByte.MAX_VALUE) << 16)) | ((input[i2 + 3] & UByte.MAX_VALUE) << 24)) >> EXPAND_SHIFT[i]) & MASK[i & 1];
        }
        return jArr;
    }

    static byte[] contract(long[] inputLimbs) {
        int i;
        long[] copyOf = Arrays.copyOf(inputLimbs, 10);
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            int i3 = 0;
            while (i3 < 9) {
                long j = copyOf[i3];
                int i4 = -((int) (((j >> 31) & j) >> SHIFT[i3 & 1]));
                copyOf[i3] = j + (i4 << r11);
                i3++;
                copyOf[i3] = copyOf[i3] - i4;
            }
            long j2 = copyOf[9];
            int i5 = -((int) (((j2 >> 31) & j2) >> 25));
            copyOf[9] = j2 + (i5 << 25);
            copyOf[0] = copyOf[0] - (i5 * 19);
            i2++;
        }
        long j3 = copyOf[0];
        copyOf[0] = j3 + (r2 << 26);
        copyOf[1] = copyOf[1] - (-((int) (((j3 >> 31) & j3) >> 26)));
        for (int i6 = 0; i6 < 2; i6++) {
            int i7 = 0;
            while (i7 < 9) {
                long j4 = copyOf[i7];
                int i8 = (int) (j4 >> SHIFT[i7 & 1]);
                copyOf[i7] = j4 & MASK[r11];
                i7++;
                copyOf[i7] = copyOf[i7] + i8;
            }
        }
        copyOf[9] = copyOf[9] & 33554431;
        long j5 = copyOf[0] + (((int) (r7 >> 25)) * 19);
        copyOf[0] = j5;
        int gte = gte((int) j5, 67108845);
        for (int i9 = 1; i9 < 10; i9++) {
            gte &= m81eq((int) copyOf[i9], MASK[i9 & 1]);
        }
        copyOf[0] = copyOf[0] - (67108845 & gte);
        long j6 = 33554431 & gte;
        copyOf[1] = copyOf[1] - j6;
        for (i = 2; i < 10; i += 2) {
            copyOf[i] = copyOf[i] - (67108863 & gte);
            int i10 = i + 1;
            copyOf[i10] = copyOf[i10] - j6;
        }
        for (int i11 = 0; i11 < 10; i11++) {
            copyOf[i11] = copyOf[i11] << EXPAND_SHIFT[i11];
        }
        byte[] bArr = new byte[32];
        for (int i12 = 0; i12 < 10; i12++) {
            int i13 = EXPAND_START[i12];
            long j7 = bArr[i13];
            long j8 = copyOf[i12];
            bArr[i13] = (byte) (j7 | (j8 & 255));
            bArr[i13 + 1] = (byte) (bArr[r4] | ((j8 >> 8) & 255));
            bArr[i13 + 2] = (byte) (bArr[r4] | ((j8 >> 16) & 255));
            bArr[i13 + 3] = (byte) (bArr[r3] | ((j8 >> 24) & 255));
        }
        return bArr;
    }

    static void inverse(long[] out, long[] z) {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        square(jArr, z);
        square(jArr10, jArr);
        square(jArr9, jArr10);
        mult(jArr2, jArr9, z);
        mult(jArr3, jArr2, jArr);
        square(jArr9, jArr3);
        mult(jArr4, jArr9, jArr2);
        square(jArr9, jArr4);
        square(jArr10, jArr9);
        square(jArr9, jArr10);
        square(jArr10, jArr9);
        square(jArr9, jArr10);
        mult(jArr5, jArr9, jArr4);
        square(jArr9, jArr5);
        square(jArr10, jArr9);
        for (int i = 2; i < 10; i += 2) {
            square(jArr9, jArr10);
            square(jArr10, jArr9);
        }
        mult(jArr6, jArr10, jArr5);
        square(jArr9, jArr6);
        square(jArr10, jArr9);
        for (int i2 = 2; i2 < 20; i2 += 2) {
            square(jArr9, jArr10);
            square(jArr10, jArr9);
        }
        mult(jArr9, jArr10, jArr6);
        square(jArr10, jArr9);
        square(jArr9, jArr10);
        for (int i3 = 2; i3 < 10; i3 += 2) {
            square(jArr10, jArr9);
            square(jArr9, jArr10);
        }
        mult(jArr7, jArr9, jArr5);
        square(jArr9, jArr7);
        square(jArr10, jArr9);
        for (int i4 = 2; i4 < 50; i4 += 2) {
            square(jArr9, jArr10);
            square(jArr10, jArr9);
        }
        mult(jArr8, jArr10, jArr7);
        square(jArr10, jArr8);
        square(jArr9, jArr10);
        for (int i5 = 2; i5 < 100; i5 += 2) {
            square(jArr10, jArr9);
            square(jArr9, jArr10);
        }
        mult(jArr10, jArr9, jArr8);
        square(jArr9, jArr10);
        square(jArr10, jArr9);
        for (int i6 = 2; i6 < 50; i6 += 2) {
            square(jArr9, jArr10);
            square(jArr10, jArr9);
        }
        mult(jArr9, jArr10, jArr7);
        square(jArr10, jArr9);
        square(jArr9, jArr10);
        square(jArr10, jArr9);
        square(jArr9, jArr10);
        square(jArr10, jArr9);
        mult(out, jArr10, jArr3);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Hex.java =====
package com.google.crypto.tink.subtle;

import kotlin.UByte;

/* loaded from: classes.dex */
public final class Hex {
    public static String encode(final byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            int i = b & UByte.MAX_VALUE;
            sb.append("0123456789abcdef".charAt(i / 16));
            sb.append("0123456789abcdef".charAt(i % 16));
        }
        return sb.toString();
    }

    public static byte[] decode(String hex) {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = hex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(hex.charAt(i2), 16);
            int digit2 = Character.digit(hex.charAt(i2 + 1), 16);
            if (digit == -1 || digit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i] = (byte) ((digit * 16) + digit2);
        }
        return bArr;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Hkdf.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class Hkdf {
    public static byte[] computeHkdf(String macAlgorithm, final byte[] ikm, final byte[] salt, final byte[] info, int size) throws GeneralSecurityException {
        Mac engineFactory = EngineFactory.MAC.getInstance(macAlgorithm);
        if (size > engineFactory.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (salt == null || salt.length == 0) {
            engineFactory.init(new SecretKeySpec(new byte[engineFactory.getMacLength()], macAlgorithm));
        } else {
            engineFactory.init(new SecretKeySpec(salt, macAlgorithm));
        }
        byte[] bArr = new byte[size];
        engineFactory.init(new SecretKeySpec(engineFactory.doFinal(ikm), macAlgorithm));
        byte[] bArr2 = new byte[0];
        int i = 1;
        int i2 = 0;
        while (true) {
            engineFactory.update(bArr2);
            engineFactory.update(info);
            engineFactory.update((byte) i);
            bArr2 = engineFactory.doFinal();
            if (bArr2.length + i2 < size) {
                System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                i2 += bArr2.length;
                i++;
            } else {
                System.arraycopy(bArr2, 0, bArr, i2, size - i2);
                return bArr;
            }
        }
    }

    public static byte[] computeEciesHkdfSymmetricKey(final byte[] ephemeralPublicKeyBytes, final byte[] sharedSecret, String hmacAlgo, final byte[] hkdfSalt, final byte[] hkdfInfo, int keySizeInBytes) throws GeneralSecurityException {
        return computeHkdf(hmacAlgo, Bytes.concat(ephemeralPublicKeyBytes, sharedSecret), hkdfSalt, hkdfInfo, keySizeInBytes);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/ImmutableByteArray.java =====
package com.google.crypto.tink.subtle;

/* loaded from: classes.dex */
public final class ImmutableByteArray {
    private final byte[] data;

    /* renamed from: of */
    public static ImmutableByteArray m82of(final byte[] data) {
        if (data == null) {
            return null;
        }
        return m83of(data, 0, data.length);
    }

    /* renamed from: of */
    public static ImmutableByteArray m83of(final byte[] data, final int start, final int len) {
        return new ImmutableByteArray(data, start, len);
    }

    public byte[] getBytes() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public int getLength() {
        return this.data.length;
    }

    private ImmutableByteArray(final byte[] buf, final int start, final int len) {
        byte[] bArr = new byte[len];
        this.data = bArr;
        System.arraycopy(buf, start, bArr, 0, len);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/IndCpaCipher.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface IndCpaCipher {
    byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException;

    byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/subtle/Kwp.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.KeyWrap;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* loaded from: classes.dex */
public class Kwp implements KeyWrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_WRAP_KEY_SIZE = 4096;
    static final int MIN_WRAP_KEY_SIZE = 16;
    static final byte[] PREFIX = {-90, 89, 89, -90};
    static final int ROUNDS = 6;
    private final SecretKey aesKey;

    public Kwp(final byte[] key) throws GeneralSecurityException {
        if (key.length != 16 && key.length != 32) {
            throw new GeneralSecurityException("Unsupported key length");
        }
        this.aesKey = new SecretKeySpec(key, "AES");
    }

    private int wrappingSize(int inputSize) {
        return inputSize + (7 - ((inputSize + 7) % 8)) + 8;
    }

    private byte[] computeW(final byte[] iv, final byte[] key) throws GeneralSecurityException {
        if (key.length <= 8 || key.length > 2147483631 || iv.length != 8) {
            throw new GeneralSecurityException("computeW called with invalid parameters");
        }
        int wrappingSize = wrappingSize(key.length);
        byte[] bArr = new byte[wrappingSize];
        System.arraycopy(iv, 0, bArr, 0, iv.length);
        System.arraycopy(key, 0, bArr, 8, key.length);
        int i = 1;
        int i2 = (wrappingSize / 8) - 1;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(1, this.aesKey);
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        int i3 = 0;
        while (i3 < 6) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 * 8;
                System.arraycopy(bArr, i6, bArr2, 8, 8);
                engineFactory.doFinal(bArr2, 0, 16, bArr2);
                int i7 = (i3 * i2) + i4 + i;
                for (int i8 = 0; i8 < 4; i8++) {
                    int i9 = 7 - i8;
                    bArr2[i9] = (byte) (((byte) (i7 & 255)) ^ bArr2[i9]);
                    i7 >>>= 8;
                }
                System.arraycopy(bArr2, 8, bArr, i6, 8);
                i4 = i5;
                i = 1;
            }
            i3++;
            i = 1;
        }
        System.arraycopy(bArr2, 0, bArr, 0, 8);
        return bArr;
    }

    private byte[] invertW(final byte[] wrapped) throws GeneralSecurityException {
        if (wrapped.length < 24 || wrapped.length % 8 != 0) {
            throw new GeneralSecurityException("Incorrect data size");
        }
        byte[] copyOf = Arrays.copyOf(wrapped, wrapped.length);
        int length = (copyOf.length / 8) - 1;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(2, this.aesKey);
        byte[] bArr = new byte[16];
        System.arraycopy(copyOf, 0, bArr, 0, 8);
        for (int i = 5; i >= 0; i--) {
            for (int i2 = length - 1; i2 >= 0; i2--) {
                int i3 = (i2 + 1) * 8;
                System.arraycopy(copyOf, i3, bArr, 8, 8);
                int i4 = (i * length) + i2 + 1;
                for (int i5 = 0; i5 < 4; i5++) {
                    int i6 = 7 - i5;
                    bArr[i6] = (byte) (bArr[i6] ^ ((byte) (i4 & 255)));
                    i4 >>>= 8;
                }
                engineFactory.doFinal(bArr, 0, 16, bArr);
                System.arraycopy(bArr, 8, copyOf, i3, 8);
            }
        }
        System.arraycopy(bArr, 0, copyOf, 0, 8);
        return copyOf;
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] wrap(final byte[] data) throws GeneralSecurityException {
        if (data.length < 16) {
            throw new GeneralSecurityException("Key size of key to wrap too small");
        }
        if (data.length > 4096) {
            throw new GeneralSecurityException("Key size of key to wrap too large");
        }
        byte[] bArr = new byte[8];
        byte[] bArr2 = PREFIX;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        for (int i = 0; i < 4; i++) {
            bArr[i + 4] = (byte) ((data.length >> ((3 - i) * 8)) & 255);
        }
        return computeW(bArr, data);
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] unwrap(final byte[] data) throws GeneralSecurityException {
        int i;
        if (data.length < wrappingSize(16)) {
            throw new GeneralSecurityException("Wrapped key size is too small");
        }
        if (data.length > wrappingSize(4096)) {
            throw new GeneralSecurityException("Wrapped key size is too large");
        }
        if (data.length % 8 != 0) {
            throw new GeneralSecurityException("Wrapped key size must be a multiple of 8 bytes");
        }
        byte[] invertW = invertW(data);
        boolean z = true;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= 4) {
                break;
            }
            if (PREFIX[i2] != invertW[i2]) {
                z = false;
            }
            i2++;
        }
        int i3 = 0;
        for (i = 4; i < 8; i++) {
            i3 = (i3 << 8) + (invertW[i] & UByte.MAX_VALUE);
        }
        if (wrappingSize(i3) == invertW.length) {
            for (int i4 = i3 + 8; i4 < invertW.length; i4++) {
                if (invertW[i4] != 0) {
                    z = false;
                }
            }
            z2 = z;
        }
        if (z2) {
            return Arrays.copyOfRange(invertW, 8, i3 + 8);
        }
        throw new BadPaddingException("Invalid padding");
    }
}

// ===== FILE: com/google/crypto/tink/subtle/NonceBasedStreamingAead.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
abstract class NonceBasedStreamingAead implements StreamingAead {
    public abstract int getCiphertextOffset();

    public abstract int getCiphertextOverhead();

    public abstract int getCiphertextSegmentSize();

    public abstract int getHeaderLength();

    public abstract int getPlaintextSegmentSize();

    public abstract StreamSegmentDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException;

    public abstract StreamSegmentEncrypter newStreamSegmentEncrypter(byte[] associatedData) throws GeneralSecurityException;

    NonceBasedStreamingAead() {
    }

    @Override // com.google.crypto.tink.StreamingAead
    public WritableByteChannel newEncryptingChannel(WritableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new StreamingAeadEncryptingChannel(this, ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public ReadableByteChannel newDecryptingChannel(ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new StreamingAeadDecryptingChannel(this, ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel ciphertextSource, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new StreamingAeadSeekableDecryptingChannel(this, ciphertextSource, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public OutputStream newEncryptingStream(OutputStream ciphertext, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new StreamingAeadEncryptingStream(this, ciphertext, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public InputStream newDecryptingStream(InputStream ciphertextStream, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new StreamingAeadDecryptingStream(this, ciphertextStream, associatedData);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/PemKeyType.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes.dex */
public enum PemKeyType {
    RSA_PSS_2048_SHA256("RSA", "RSASSA-PSS", 2048, Enums.HashType.SHA256),
    RSA_PSS_3072_SHA256("RSA", "RSASSA-PSS", 3072, Enums.HashType.SHA256),
    RSA_PSS_4096_SHA256("RSA", "RSASSA-PSS", 4096, Enums.HashType.SHA256),
    RSA_PSS_4096_SHA512("RSA", "RSASSA-PSS", 4096, Enums.HashType.SHA512),
    RSA_SIGN_PKCS1_2048_SHA256("RSA", "RSASSA-PKCS1-v1_5", 2048, Enums.HashType.SHA256),
    RSA_SIGN_PKCS1_3072_SHA256("RSA", "RSASSA-PKCS1-v1_5", 3072, Enums.HashType.SHA256),
    RSA_SIGN_PKCS1_4096_SHA256("RSA", "RSASSA-PKCS1-v1_5", 4096, Enums.HashType.SHA256),
    RSA_SIGN_PKCS1_4096_SHA512("RSA", "RSASSA-PKCS1-v1_5", 4096, Enums.HashType.SHA512),
    ECDSA_P256_SHA256("EC", "ECDSA", 256, Enums.HashType.SHA256),
    ECDSA_P384_SHA384("EC", "ECDSA", 384, Enums.HashType.SHA384),
    ECDSA_P521_SHA512("EC", "ECDSA", 521, Enums.HashType.SHA512);

    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";
    private static final String MARKER = "-----";
    private static final String PRIVATE_KEY = "PRIVATE KEY";
    private static final String PUBLIC_KEY = "PUBLIC KEY";
    public final String algorithm;
    public final Enums.HashType hash;
    public final int keySizeInBits;
    public final String keyType;

    PemKeyType(String keyType, String algorithm, int keySizeInBits, Enums.HashType hash) {
        this.keyType = keyType;
        this.algorithm = algorithm;
        this.keySizeInBits = keySizeInBits;
        this.hash = hash;
    }

    public Key readKey(BufferedReader reader) throws IOException {
        String substring;
        int indexOf;
        byte[] decode;
        String readLine = reader.readLine();
        while (readLine != null && !readLine.startsWith(BEGIN)) {
            readLine = reader.readLine();
        }
        if (readLine == null || (indexOf = (substring = readLine.trim().substring(11)).indexOf(MARKER)) < 0) {
            return null;
        }
        String substring2 = substring.substring(0, indexOf);
        String str = END + substring2 + MARKER;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine2 = reader.readLine();
            if (readLine2 != null) {
                if (readLine2.indexOf(":") <= 0) {
                    if (!readLine2.contains(str)) {
                        sb.append(readLine2);
                    }
                }
            }
            try {
                decode = Base64.decode(sb.toString(), 0);
            } catch (IllegalArgumentException | GeneralSecurityException unused) {
            }
            if (substring2.contains(PUBLIC_KEY)) {
                return getPublicKey(decode);
            }
            if (substring2.contains(PRIVATE_KEY)) {
                return getPrivateKey(decode);
            }
            return null;
        }
    }

    private Key getPublicKey(final byte[] key) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePublic(new X509EncodedKeySpec(key)));
    }

    private Key getPrivateKey(final byte[] key) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePrivate(new PKCS8EncodedKeySpec(key)));
    }

    private Key validate(Key key) throws GeneralSecurityException {
        if (this.keyType.equals("RSA")) {
            int bitLength = ((RSAKey) key).getModulus().bitLength();
            if (bitLength != this.keySizeInBits) {
                throw new GeneralSecurityException(String.format("invalid RSA key size, want %d got %d", Integer.valueOf(this.keySizeInBits), Integer.valueOf(bitLength)));
            }
        } else {
            ECParameterSpec params = ((ECKey) key).getParams();
            if (!EllipticCurves.isNistEcParameterSpec(params)) {
                throw new GeneralSecurityException("unsupport EC spec: " + params.toString());
            }
            int fieldSizeInBits = EllipticCurves.fieldSizeInBits(params.getCurve());
            if (fieldSizeInBits != this.keySizeInBits) {
                throw new GeneralSecurityException(String.format("invalid EC key size, want %d got %d", Integer.valueOf(this.keySizeInBits), Integer.valueOf(fieldSizeInBits)));
            }
        }
        return key;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Poly1305.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes.dex */
class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    private static long load32(byte[] in, int idx) {
        return (((in[idx + 3] & UByte.MAX_VALUE) << 24) | (in[idx] & UByte.MAX_VALUE) | ((in[idx + 1] & UByte.MAX_VALUE) << 8) | ((in[idx + 2] & UByte.MAX_VALUE) << 16)) & 4294967295L;
    }

    private static long load26(byte[] in, int idx, int shift) {
        return (load32(in, idx) >> shift) & 67108863;
    }

    private static void toByteArray(byte[] output, long num, int idx) {
        int i = 0;
        while (i < 4) {
            output[idx + i] = (byte) (255 & num);
            i++;
            num >>= 8;
        }
    }

    private static void copyBlockSize(byte[] output, byte[] in, int idx) {
        int min = Math.min(16, in.length - idx);
        System.arraycopy(in, idx, output, 0, min);
        output[min] = 1;
        if (min != 16) {
            Arrays.fill(output, min + 1, output.length, (byte) 0);
        }
    }

    static byte[] computeMac(final byte[] key, byte[] data) {
        if (key.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        int i = 0;
        long load26 = load26(key, 0, 0) & 67108863;
        int i2 = 3;
        long load262 = load26(key, 3, 2) & 67108611;
        long load263 = load26(key, 6, 4) & 67092735;
        long load264 = load26(key, 9, 6) & 66076671;
        long load265 = load26(key, 12, 8) & 1048575;
        long j = load262 * 5;
        long j2 = load263 * 5;
        long j3 = load264 * 5;
        long j4 = load265 * 5;
        byte[] bArr = new byte[17];
        long j5 = 0;
        int i3 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        while (i3 < data.length) {
            copyBlockSize(bArr, data, i3);
            long load266 = j9 + load26(bArr, i, i);
            long load267 = j5 + load26(bArr, i2, 2);
            long load268 = j6 + load26(bArr, 6, 4);
            long load269 = j7 + load26(bArr, 9, 6);
            long load2610 = j8 + (load26(bArr, 12, 8) | (bArr[16] << 24));
            long j10 = (load266 * load26) + (load267 * j4) + (load268 * j3) + (load269 * j2) + (load2610 * j);
            long j11 = (load266 * load262) + (load267 * load26) + (load268 * j4) + (load269 * j3) + (load2610 * j2);
            long j12 = (load266 * load263) + (load267 * load262) + (load268 * load26) + (load269 * j4) + (load2610 * j3);
            long j13 = (load266 * load264) + (load267 * load263) + (load268 * load262) + (load269 * load26) + (load2610 * j4);
            long j14 = j11 + (j10 >> 26);
            long j15 = j12 + (j14 >> 26);
            long j16 = j13 + (j15 >> 26);
            long j17 = (load266 * load265) + (load267 * load264) + (load268 * load263) + (load269 * load262) + (load2610 * load26) + (j16 >> 26);
            long j18 = (j10 & 67108863) + ((j17 >> 26) * 5);
            j5 = (j14 & 67108863) + (j18 >> 26);
            i3 += 16;
            j6 = j15 & 67108863;
            j7 = j16 & 67108863;
            j8 = j17 & 67108863;
            i2 = 3;
            j9 = j18 & 67108863;
            i = 0;
        }
        long j19 = j6 + (j5 >> 26);
        long j20 = j19 & 67108863;
        long j21 = j7 + (j19 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j8 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j9 + ((j23 >> 26) * 5);
        long j26 = j25 & 67108863;
        long j27 = (j5 & 67108863) + (j25 >> 26);
        long j28 = j26 + 5;
        long j29 = j28 & 67108863;
        long j30 = (j28 >> 26) + j27;
        long j31 = j20 + (j30 >> 26);
        long j32 = j22 + (j31 >> 26);
        long j33 = (j24 + (j32 >> 26)) - 67108864;
        long j34 = j33 >> 63;
        long j35 = j26 & j34;
        long j36 = j27 & j34;
        long j37 = j20 & j34;
        long j38 = j22 & j34;
        long j39 = j24 & j34;
        long j40 = ~j34;
        long j41 = (j30 & 67108863 & j40) | j36;
        long j42 = (j31 & 67108863 & j40) | j37;
        long j43 = (j32 & 67108863 & j40) | j38;
        long j44 = (j33 & j40) | j39;
        long j45 = (j35 | (j29 & j40) | (j41 << 26)) & 4294967295L;
        long j46 = ((j41 >> 6) | (j42 << 20)) & 4294967295L;
        long j47 = ((j42 >> 12) | (j43 << 14)) & 4294967295L;
        long j48 = ((j43 >> 18) | (j44 << 8)) & 4294967295L;
        long load32 = j45 + load32(key, 16);
        long j49 = load32 & 4294967295L;
        long load322 = j46 + load32(key, 20) + (load32 >> 32);
        long j50 = load322 & 4294967295L;
        long load323 = j47 + load32(key, 24) + (load322 >> 32);
        long j51 = load323 & 4294967295L;
        long load324 = (j48 + load32(key, 28) + (load323 >> 32)) & 4294967295L;
        byte[] bArr2 = new byte[16];
        toByteArray(bArr2, j49, 0);
        toByteArray(bArr2, j50, 4);
        toByteArray(bArr2, j51, 8);
        toByteArray(bArr2, load324, 12);
        return bArr2;
    }

    static void verifyMac(final byte[] key, byte[] data, byte[] mac) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(key, data), mac)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/PrfAesCmac.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Immutable
/* loaded from: classes.dex */
public final class PrfAesCmac implements Prf {
    private final SecretKey keySpec;
    private byte[] subKey1;
    private byte[] subKey2;

    private static Cipher instance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
    }

    public PrfAesCmac(final byte[] key) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
        generateSubKeys();
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(final byte[] data, int outputLength) throws GeneralSecurityException {
        byte[] xor;
        if (outputLength > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher instance = instance();
        instance.init(1, this.keySpec);
        int max = Math.max(1, (int) Math.ceil(data.length / 16.0d));
        if (max * 16 == data.length) {
            xor = Bytes.xor(data, (max - 1) * 16, this.subKey1, 0, 16);
        } else {
            xor = Bytes.xor(AesUtil.cmacPad(Arrays.copyOfRange(data, (max - 1) * 16, data.length)), this.subKey2);
        }
        byte[] bArr = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr = instance.doFinal(Bytes.xor(bArr, 0, data, i * 16, 16));
        }
        return Arrays.copyOf(instance.doFinal(Bytes.xor(xor, bArr)), outputLength);
    }

    private void generateSubKeys() throws GeneralSecurityException {
        Cipher instance = instance();
        instance.init(1, this.keySpec);
        byte[] dbl = AesUtil.dbl(instance.doFinal(new byte[16]));
        this.subKey1 = dbl;
        this.subKey2 = AesUtil.dbl(dbl);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/PrfHmacJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

@Immutable
/* loaded from: classes.dex */
public final class PrfHmacJce implements Prf {
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private final String algorithm;
    private final Key key;
    private final ThreadLocal<Mac> localMac;
    private final int maxOutputLength;

    public PrfHmacJce(String algorithm, Key key) throws GeneralSecurityException {
        ThreadLocal<Mac> threadLocal = new ThreadLocal<Mac>() { // from class: com.google.crypto.tink.subtle.PrfHmacJce.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public Mac initialValue() {
                try {
                    Mac engineFactory = EngineFactory.MAC.getInstance(PrfHmacJce.this.algorithm);
                    engineFactory.init(PrfHmacJce.this.key);
                    return engineFactory;
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
        this.localMac = threadLocal;
        this.algorithm = algorithm;
        this.key = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        algorithm.hashCode();
        switch (algorithm) {
            case "HMACSHA1":
                this.maxOutputLength = 20;
                break;
            case "HMACSHA256":
                this.maxOutputLength = 32;
                break;
            case "HMACSHA384":
                this.maxOutputLength = 48;
                break;
            case "HMACSHA512":
                this.maxOutputLength = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + algorithm);
        }
        threadLocal.get();
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] data, int outputLength) throws GeneralSecurityException {
        if (outputLength > this.maxOutputLength) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.localMac.get().update(data);
        return Arrays.copyOf(this.localMac.get().doFinal(), outputLength);
    }

    public int getMaxOutputLength() {
        return this.maxOutputLength;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/PrfMac.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

@Immutable
/* loaded from: classes.dex */
public class PrfMac implements Mac {
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private final int tagSize;
    private final Prf wrappedPrf;

    public PrfMac(Prf wrappedPrf, int tagSize) throws GeneralSecurityException {
        this.wrappedPrf = wrappedPrf;
        this.tagSize = tagSize;
        if (tagSize < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        wrappedPrf.compute(new byte[0], tagSize);
    }

    @Override // com.google.crypto.tink.Mac
    public byte[] computeMac(byte[] data) throws GeneralSecurityException {
        return this.wrappedPrf.compute(data, this.tagSize);
    }

    @Override // com.google.crypto.tink.Mac
    public void verifyMac(byte[] mac, byte[] data) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(data), mac)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Random.java =====
package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public final class Random {
    private static final ThreadLocal<SecureRandom> localRandom = new ThreadLocal<SecureRandom>() { // from class: com.google.crypto.tink.subtle.Random.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SecureRandom initialValue() {
            return Random.newDefaultSecureRandom();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom newDefaultSecureRandom() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] randBytes(int size) {
        byte[] bArr = new byte[size];
        localRandom.get().nextBytes(bArr);
        return bArr;
    }

    public static final int randInt(int max) {
        return localRandom.get().nextInt(max);
    }

    public static final int randInt() {
        return localRandom.get().nextInt();
    }
}

// ===== FILE: com/google/crypto/tink/subtle/RewindableReadableByteChannel.java =====
package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes.dex */
public final class RewindableReadableByteChannel implements ReadableByteChannel {
    final ReadableByteChannel baseChannel;
    ByteBuffer buffer = null;
    boolean canRewind = true;
    boolean directRead = false;

    public RewindableReadableByteChannel(ReadableByteChannel baseChannel) {
        this.baseChannel = baseChannel;
    }

    public synchronized void disableRewinding() {
        this.canRewind = false;
    }

    public synchronized void rewind() throws IOException {
        if (!this.canRewind) {
            throw new IOException("Cannot rewind anymore.");
        }
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }

    private synchronized void setBufferLimit(int newLimit) {
        if (this.buffer.capacity() < newLimit) {
            int position = this.buffer.position();
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.buffer.capacity() * 2, newLimit));
            this.buffer.rewind();
            allocate.put(this.buffer);
            allocate.position(position);
            this.buffer = allocate;
        }
        this.buffer.limit(newLimit);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        if (this.directRead) {
            return this.baseChannel.read(dst);
        }
        int remaining = dst.remaining();
        if (remaining == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            if (!this.canRewind) {
                this.directRead = true;
                return this.baseChannel.read(dst);
            }
            ByteBuffer allocate = ByteBuffer.allocate(remaining);
            this.buffer = allocate;
            int read = this.baseChannel.read(allocate);
            this.buffer.flip();
            if (read > 0) {
                dst.put(this.buffer);
            }
            return read;
        }
        if (byteBuffer.remaining() >= remaining) {
            int limit = this.buffer.limit();
            ByteBuffer byteBuffer2 = this.buffer;
            byteBuffer2.limit(byteBuffer2.position() + remaining);
            dst.put(this.buffer);
            this.buffer.limit(limit);
            if (!this.canRewind && !this.buffer.hasRemaining()) {
                this.buffer = null;
                this.directRead = true;
            }
            return remaining;
        }
        int remaining2 = this.buffer.remaining();
        int position = this.buffer.position();
        int limit2 = this.buffer.limit();
        setBufferLimit((remaining - remaining2) + limit2);
        this.buffer.position(limit2);
        int read2 = this.baseChannel.read(this.buffer);
        this.buffer.flip();
        this.buffer.position(position);
        dst.put(this.buffer);
        if (remaining2 == 0 && read2 < 0) {
            return -1;
        }
        int position2 = this.buffer.position() - position;
        if (!this.canRewind && !this.buffer.hasRemaining()) {
            this.buffer = null;
            this.directRead = true;
        }
        return position2;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.canRewind = false;
        this.directRead = true;
        this.baseChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.baseChannel.isOpen();
    }
}

// ===== FILE: com/google/crypto/tink/subtle/RsaSsaPkcs1SignJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.subtle.Enums;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* loaded from: classes.dex */
public final class RsaSsaPkcs1SignJce implements PublicKeySign {
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;

    public RsaSsaPkcs1SignJce(final RSAPrivateCrtKey priv, Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        Validators.validateRsaModulusSize(priv.getModulus().bitLength());
        Validators.validateRsaPublicExponent(priv.getPublicExponent());
        this.privateKey = priv;
        this.signatureAlgorithm = SubtleUtil.toRsaSsaPkcs1Algo(hash);
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(priv.getModulus(), priv.getPublicExponent()));
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        Signature engineFactory = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        engineFactory.initSign(this.privateKey);
        engineFactory.update(data);
        byte[] sign = engineFactory.sign();
        Signature engineFactory2 = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        engineFactory2.initVerify(this.publicKey);
        engineFactory2.update(data);
        if (engineFactory2.verify(sign)) {
            return sign;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }
}

// ===== FILE: com/google/crypto/tink/subtle/RsaSsaPkcs1VerifyJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;

/* loaded from: classes.dex */
public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private static final String ASN_PREFIX_SHA256 = "3031300d060960864801650304020105000420";
    private static final String ASN_PREFIX_SHA512 = "3051300d060960864801650304020305000440";
    private final Enums.HashType hash;
    private final RSAPublicKey publicKey;

    public RsaSsaPkcs1VerifyJce(final RSAPublicKey pubKey, Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        Validators.validateRsaModulusSize(pubKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(pubKey.getPublicExponent());
        this.publicKey = pubKey;
        this.hash = hash;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        if (bitLength != signature.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bytes2Integer = SubtleUtil.bytes2Integer(signature);
        if (bytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        if (!Bytes.equal(SubtleUtil.integer2Bytes(bytes2Integer.modPow(publicExponent, modulus), bitLength), emsaPkcs1(data, bitLength, this.hash))) {
            throw new GeneralSecurityException("invalid signature");
        }
    }

    private byte[] emsaPkcs1(byte[] m, int emLen, Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.hash));
        engineFactory.update(m);
        byte[] digest = engineFactory.digest();
        byte[] asnPrefix = toAsnPrefix(hash);
        if (emLen < asnPrefix.length + digest.length + 11) {
            throw new GeneralSecurityException("intended encoded message length too short");
        }
        byte[] bArr = new byte[emLen];
        bArr[0] = 0;
        bArr[1] = 1;
        int i = 2;
        int i2 = 0;
        while (i2 < (emLen - r0) - 3) {
            bArr[i] = -1;
            i2++;
            i++;
        }
        int i3 = i + 1;
        bArr[i] = 0;
        System.arraycopy(asnPrefix, 0, bArr, i3, asnPrefix.length);
        System.arraycopy(digest, 0, bArr, i3 + asnPrefix.length, digest.length);
        return bArr;
    }

    /* renamed from: com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce$1 */
    static /* synthetic */ class C07261 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private byte[] toAsnPrefix(Enums.HashType hash) throws GeneralSecurityException {
        int i = C07261.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hash.ordinal()];
        if (i == 1) {
            return Hex.decode(ASN_PREFIX_SHA256);
        }
        if (i == 2) {
            return Hex.decode(ASN_PREFIX_SHA512);
        }
        throw new GeneralSecurityException("Unsupported hash " + hash);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/RsaSsaPssSignJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class RsaSsaPssSignJce implements PublicKeySign {
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final Enums.HashType mgf1Hash;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssSignJce(final RSAPrivateCrtKey priv, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        Validators.validateSignatureHash(sigHash);
        Validators.validateRsaModulusSize(priv.getModulus().bitLength());
        Validators.validateRsaPublicExponent(priv.getPublicExponent());
        this.privateKey = priv;
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(priv.getModulus(), priv.getPublicExponent()));
        this.sigHash = sigHash;
        this.mgf1Hash = mgf1Hash;
        this.saltLength = saltLength;
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        return rsasp1(emsaPssEncode(data, this.publicKey.getModulus().bitLength() - 1));
    }

    private byte[] rsasp1(byte[] m) throws GeneralSecurityException {
        Cipher engineFactory = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        engineFactory.init(2, this.privateKey);
        byte[] doFinal = engineFactory.doFinal(m);
        Cipher engineFactory2 = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        engineFactory2.init(1, this.publicKey);
        if (new BigInteger(1, m).equals(new BigInteger(1, engineFactory2.doFinal(doFinal)))) {
            return doFinal;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    private byte[] emsaPssEncode(byte[] m, int emBits) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] digest = engineFactory.digest(m);
        int digestLength = engineFactory.getDigestLength();
        int i = ((emBits - 1) / 8) + 1;
        int i2 = this.saltLength;
        if (i < digestLength + i2 + 2) {
            throw new GeneralSecurityException("encoding error");
        }
        byte[] randBytes = Random.randBytes(i2);
        int i3 = digestLength + 8;
        byte[] bArr = new byte[this.saltLength + i3];
        System.arraycopy(digest, 0, bArr, 8, digestLength);
        System.arraycopy(randBytes, 0, bArr, i3, randBytes.length);
        byte[] digest2 = engineFactory.digest(bArr);
        int i4 = (i - digestLength) - 1;
        byte[] bArr2 = new byte[i4];
        int i5 = this.saltLength;
        bArr2[((i - i5) - digestLength) - 2] = 1;
        System.arraycopy(randBytes, 0, bArr2, ((i - i5) - digestLength) - 1, randBytes.length);
        byte[] mgf1 = SubtleUtil.mgf1(digest2, i4, this.mgf1Hash);
        byte[] bArr3 = new byte[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            bArr3[i6] = (byte) (bArr2[i6] ^ mgf1[i6]);
        }
        for (int i7 = 0; i7 < (i * 8) - emBits; i7++) {
            int i8 = i7 / 8;
            bArr3[i8] = (byte) ((~(1 << (7 - (i7 % 8)))) & bArr3[i8]);
        }
        int i9 = digestLength + i4;
        byte[] bArr4 = new byte[i9 + 1];
        System.arraycopy(bArr3, 0, bArr4, 0, i4);
        System.arraycopy(digest2, 0, bArr4, i4, digest2.length);
        bArr4[i9] = -68;
        return bArr4;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/RsaSsaPssVerifyJce.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    private final Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssVerifyJce(final RSAPublicKey pubKey, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        Validators.validateSignatureHash(sigHash);
        Validators.validateRsaModulusSize(pubKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(pubKey.getPublicExponent());
        this.publicKey = pubKey;
        this.sigHash = sigHash;
        this.mgf1Hash = mgf1Hash;
        this.saltLength = saltLength;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int bitLength = ((modulus.bitLength() - 1) + 7) / 8;
        if ((modulus.bitLength() + 7) / 8 != signature.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bytes2Integer = SubtleUtil.bytes2Integer(signature);
        if (bytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        emsaPssVerify(data, SubtleUtil.integer2Bytes(bytes2Integer.modPow(publicExponent, modulus), bitLength), modulus.bitLength() - 1);
    }

    private void emsaPssVerify(byte[] m, byte[] em, int emBits) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] digest = engineFactory.digest(m);
        int digestLength = engineFactory.getDigestLength();
        int length = em.length;
        if (length < this.saltLength + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (em[em.length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i = (length - digestLength) - 1;
        byte[] copyOf = Arrays.copyOf(em, i);
        byte[] copyOfRange = Arrays.copyOfRange(em, copyOf.length, copyOf.length + digestLength);
        int i2 = 0;
        while (true) {
            int i3 = i;
            MessageDigest messageDigest = engineFactory;
            byte[] bArr = digest;
            long j = (length * 8) - emBits;
            if (i2 < j) {
                if (((copyOf[i2 / 8] >> (7 - (i2 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i2++;
                i = i3;
                engineFactory = messageDigest;
                digest = bArr;
            } else {
                byte[] mgf1 = SubtleUtil.mgf1(copyOfRange, i3, this.mgf1Hash);
                int length2 = mgf1.length;
                byte[] bArr2 = new byte[length2];
                for (int i4 = 0; i4 < length2; i4++) {
                    bArr2[i4] = (byte) (mgf1[i4] ^ copyOf[i4]);
                }
                for (int i5 = 0; i5 <= j; i5++) {
                    int i6 = i5 / 8;
                    bArr2[i6] = (byte) ((~(1 << (7 - (i5 % 8)))) & bArr2[i6]);
                }
                int i7 = 0;
                while (true) {
                    int i8 = this.saltLength;
                    if (i7 < (r6 - i8) - 2) {
                        if (bArr2[i7] != 0) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        i7++;
                    } else {
                        if (bArr2[(r6 - i8) - 2] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] copyOfRange2 = Arrays.copyOfRange(bArr2, length2 - i8, length2);
                        int i9 = digestLength + 8;
                        byte[] bArr3 = new byte[this.saltLength + i9];
                        System.arraycopy(bArr, 0, bArr3, 8, bArr.length);
                        System.arraycopy(copyOfRange2, 0, bArr3, i9, copyOfRange2.length);
                        if (!Bytes.equal(messageDigest.digest(bArr3), copyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                }
            }
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/StreamSegmentDecrypter.java =====
package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface StreamSegmentDecrypter {
    void decryptSegment(ByteBuffer ciphertext, int segmentNr, boolean isLastSegment, ByteBuffer plaintext) throws GeneralSecurityException;

    void init(ByteBuffer header, byte[] aad) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/subtle/StreamSegmentEncrypter.java =====
package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface StreamSegmentEncrypter {
    void encryptSegment(ByteBuffer part1, ByteBuffer part2, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException;

    void encryptSegment(ByteBuffer plaintext, boolean isLastSegment, ByteBuffer ciphertext) throws GeneralSecurityException;

    ByteBuffer getHeader();
}

// ===== FILE: com/google/crypto/tink/subtle/StreamingAeadDecryptingChannel.java =====
package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
class StreamingAeadDecryptingChannel implements ReadableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private byte[] aad;
    private ReadableByteChannel ciphertextChannel;
    private ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean definedState;
    private boolean endOfCiphertext;
    private boolean endOfPlaintext;
    private final int firstCiphertextSegmentSize;
    private ByteBuffer header;
    private boolean headerRead;
    private ByteBuffer plaintextSegment;
    private int segmentNr;

    public StreamingAeadDecryptingChannel(NonceBasedStreamingAead streamAead, ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = ciphertextChannel;
        this.header = ByteBuffer.allocate(streamAead.getHeaderLength());
        this.aad = Arrays.copyOf(associatedData, associatedData.length);
        int ciphertextSegmentSize = streamAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        ByteBuffer allocate = ByteBuffer.allocate(ciphertextSegmentSize + 1);
        this.ciphertextSegment = allocate;
        allocate.limit(0);
        this.firstCiphertextSegmentSize = ciphertextSegmentSize - streamAead.getCiphertextOffset();
        ByteBuffer allocate2 = ByteBuffer.allocate(streamAead.getPlaintextSegmentSize() + 16);
        this.plaintextSegment = allocate2;
        allocate2.limit(0);
        this.headerRead = false;
        this.endOfCiphertext = false;
        this.endOfPlaintext = false;
        this.segmentNr = 0;
        this.definedState = true;
    }

    private void readSomeCiphertext(ByteBuffer buffer) throws IOException {
        int read;
        do {
            read = this.ciphertextChannel.read(buffer);
            if (read <= 0) {
                break;
            }
        } while (buffer.remaining() > 0);
        if (read == -1) {
            this.endOfCiphertext = true;
        }
    }

    private boolean tryReadHeader() throws IOException {
        if (this.endOfCiphertext) {
            throw new IOException("Ciphertext is too short");
        }
        readSomeCiphertext(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e) {
            setUndefinedState();
            throw new IOException(e);
        }
    }

    private void setUndefinedState() {
        this.definedState = false;
        this.plaintextSegment.limit(0);
    }

    private boolean tryLoadSegment() throws IOException {
        if (!this.endOfCiphertext) {
            readSomeCiphertext(this.ciphertextSegment);
        }
        byte b = 0;
        if (this.ciphertextSegment.remaining() > 0 && !this.endOfCiphertext) {
            return false;
        }
        if (!this.endOfCiphertext) {
            ByteBuffer byteBuffer = this.ciphertextSegment;
            b = byteBuffer.get(byteBuffer.position() - 1);
            ByteBuffer byteBuffer2 = this.ciphertextSegment;
            byteBuffer2.position(byteBuffer2.position() - 1);
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);
            this.segmentNr++;
            this.plaintextSegment.flip();
            this.ciphertextSegment.clear();
            if (!this.endOfCiphertext) {
                this.ciphertextSegment.clear();
                this.ciphertextSegment.limit(this.ciphertextSegmentSize + 1);
                this.ciphertextSegment.put(b);
            }
            return true;
        } catch (GeneralSecurityException e) {
            setUndefinedState();
            throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        if (!this.definedState) {
            throw new IOException("This StreamingAeadDecryptingChannel is in an undefined state");
        }
        if (!this.headerRead) {
            if (!tryReadHeader()) {
                return 0;
            }
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(this.firstCiphertextSegmentSize + 1);
        }
        if (this.endOfPlaintext) {
            return -1;
        }
        int position = dst.position();
        while (true) {
            if (dst.remaining() <= 0) {
                break;
            }
            if (this.plaintextSegment.remaining() == 0) {
                if (this.endOfCiphertext) {
                    this.endOfPlaintext = true;
                    break;
                }
                if (!tryLoadSegment()) {
                    break;
                }
            }
            if (this.plaintextSegment.remaining() <= dst.remaining()) {
                this.plaintextSegment.remaining();
                dst.put(this.plaintextSegment);
            } else {
                int remaining = dst.remaining();
                ByteBuffer duplicate = this.plaintextSegment.duplicate();
                duplicate.limit(duplicate.position() + remaining);
                dst.put(duplicate);
                ByteBuffer byteBuffer = this.plaintextSegment;
                byteBuffer.position(byteBuffer.position() + remaining);
            }
        }
        int position2 = dst.position() - position;
        if (position2 == 0 && this.endOfPlaintext) {
            return -1;
        }
        return position2;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }

    public synchronized String toString() {
        return "StreamingAeadDecryptingChannel\nsegmentNr:" + this.segmentNr + "\nciphertextSegmentSize:" + this.ciphertextSegmentSize + "\nheaderRead:" + this.headerRead + "\nendOfCiphertext:" + this.endOfCiphertext + "\nendOfPlaintext:" + this.endOfPlaintext + "\ndefinedState:" + this.definedState + "\nHeader position:" + this.header.position() + " limit:" + this.header.position() + "\nciphertextSgement position:" + this.ciphertextSegment.position() + " limit:" + this.ciphertextSegment.limit() + "\nplaintextSegment position:" + this.plaintextSegment.position() + " limit:" + this.plaintextSegment.limit();
    }
}

// ===== FILE: com/google/crypto/tink/subtle/StreamingAeadDecryptingStream.java =====
package com.google.crypto.tink.subtle;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes.dex */
class StreamingAeadDecryptingStream extends FilterInputStream {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private boolean decryptionErrorOccured;
    private boolean endOfCiphertext;
    private boolean endOfPlaintext;
    private final int firstCiphertextSegmentSize;
    private final int headerLength;
    private boolean headerRead;
    private final ByteBuffer plaintextSegment;
    private int segmentNr;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public StreamingAeadDecryptingStream(NonceBasedStreamingAead streamAead, InputStream ciphertextStream, byte[] associatedData) throws GeneralSecurityException, IOException {
        super(ciphertextStream);
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.headerLength = streamAead.getHeaderLength();
        this.aad = Arrays.copyOf(associatedData, associatedData.length);
        int ciphertextSegmentSize = streamAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        ByteBuffer allocate = ByteBuffer.allocate(ciphertextSegmentSize + 1);
        this.ciphertextSegment = allocate;
        allocate.limit(0);
        this.firstCiphertextSegmentSize = ciphertextSegmentSize - streamAead.getCiphertextOffset();
        ByteBuffer allocate2 = ByteBuffer.allocate(streamAead.getPlaintextSegmentSize() + 16);
        this.plaintextSegment = allocate2;
        allocate2.limit(0);
        this.headerRead = false;
        this.endOfCiphertext = false;
        this.endOfPlaintext = false;
        this.segmentNr = 0;
        this.decryptionErrorOccured = false;
    }

    private void readHeader() throws IOException {
        if (this.headerRead) {
            setDecryptionErrorOccured();
            throw new IOException("Decryption failed.");
        }
        ByteBuffer allocate = ByteBuffer.allocate(this.headerLength);
        while (allocate.remaining() > 0) {
            int read = this.in.read(allocate.array(), allocate.position(), allocate.remaining());
            if (read == -1) {
                setDecryptionErrorOccured();
                throw new IOException("Ciphertext is too short");
            }
            if (read == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
            allocate.position(allocate.position() + read);
        }
        allocate.flip();
        try {
            this.decrypter.init(allocate, this.aad);
            this.headerRead = true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    private void setDecryptionErrorOccured() {
        this.decryptionErrorOccured = true;
        this.plaintextSegment.limit(0);
    }

    private void loadSegment() throws IOException {
        byte b;
        while (!this.endOfCiphertext && this.ciphertextSegment.remaining() > 0) {
            int read = this.in.read(this.ciphertextSegment.array(), this.ciphertextSegment.position(), this.ciphertextSegment.remaining());
            if (read > 0) {
                ByteBuffer byteBuffer = this.ciphertextSegment;
                byteBuffer.position(byteBuffer.position() + read);
            } else if (read == -1) {
                this.endOfCiphertext = true;
            } else if (read == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
        }
        if (this.endOfCiphertext) {
            b = 0;
        } else {
            ByteBuffer byteBuffer2 = this.ciphertextSegment;
            b = byteBuffer2.get(byteBuffer2.position() - 1);
            ByteBuffer byteBuffer3 = this.ciphertextSegment;
            byteBuffer3.position(byteBuffer3.position() - 1);
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);
            this.segmentNr++;
            this.plaintextSegment.flip();
            this.ciphertextSegment.clear();
            if (this.endOfCiphertext) {
                return;
            }
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(this.ciphertextSegmentSize + 1);
            this.ciphertextSegment.put(b);
        } catch (GeneralSecurityException e) {
            setDecryptionErrorOccured();
            throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == 1) {
            return bArr[0] & UByte.MAX_VALUE;
        }
        if (read == -1) {
            return read;
        }
        throw new IOException("Reading failed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] dst) throws IOException {
        return read(dst, 0, dst.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] dst, int offset, int length) throws IOException {
        if (this.decryptionErrorOccured) {
            throw new IOException("Decryption failed.");
        }
        if (!this.headerRead) {
            readHeader();
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(this.firstCiphertextSegmentSize + 1);
        }
        if (this.endOfPlaintext) {
            return -1;
        }
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (this.plaintextSegment.remaining() == 0) {
                if (this.endOfCiphertext) {
                    this.endOfPlaintext = true;
                    break;
                }
                loadSegment();
            }
            int min = Math.min(this.plaintextSegment.remaining(), length - i);
            this.plaintextSegment.get(dst, i + offset, min);
            i += min;
        }
        if (i == 0 && this.endOfPlaintext) {
            return -1;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return this.plaintextSegment.remaining();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readlimit) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n) throws IOException {
        int read;
        long j = this.ciphertextSegmentSize;
        if (n <= 0) {
            return 0L;
        }
        int min = (int) Math.min(j, n);
        byte[] bArr = new byte[min];
        long j2 = n;
        while (j2 > 0 && (read = read(bArr, 0, (int) Math.min(min, j2))) > 0) {
            j2 -= read;
        }
        return n - j2;
    }

    public synchronized String toString() {
        return "StreamingAeadDecryptingStream\nsegmentNr:" + this.segmentNr + "\nciphertextSegmentSize:" + this.ciphertextSegmentSize + "\nheaderRead:" + this.headerRead + "\nendOfCiphertext:" + this.endOfCiphertext + "\nendOfPlaintext:" + this.endOfPlaintext + "\ndecryptionErrorOccured:" + this.decryptionErrorOccured + "\nciphertextSgement position:" + this.ciphertextSegment.position() + " limit:" + this.ciphertextSegment.limit() + "\nplaintextSegment position:" + this.plaintextSegment.position() + " limit:" + this.plaintextSegment.limit();
    }
}

// ===== FILE: com/google/crypto/tink/subtle/StreamingAeadEncryptingChannel.java =====
package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class StreamingAeadEncryptingChannel implements WritableByteChannel {
    private WritableByteChannel ciphertextChannel;
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open = true;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingChannel(NonceBasedStreamingAead streamAead, WritableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        this.ciphertextChannel = ciphertextChannel;
        this.encrypter = streamAead.newStreamSegmentEncrypter(associatedData);
        int plaintextSegmentSize = streamAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        ByteBuffer allocate = ByteBuffer.allocate(plaintextSegmentSize);
        this.ptBuffer = allocate;
        allocate.limit(this.plaintextSegmentSize - streamAead.getCiphertextOffset());
        ByteBuffer allocate2 = ByteBuffer.allocate(streamAead.getCiphertextSegmentSize());
        this.ctBuffer = allocate2;
        allocate2.put(this.encrypter.getHeader());
        this.ctBuffer.flip();
        ciphertextChannel.write(this.ctBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer pt) throws IOException {
        if (!this.open) {
            throw new ClosedChannelException();
        }
        if (this.ctBuffer.remaining() > 0) {
            this.ciphertextChannel.write(this.ctBuffer);
        }
        int position = pt.position();
        while (pt.remaining() > this.ptBuffer.remaining()) {
            if (this.ctBuffer.remaining() > 0) {
                return pt.position() - position;
            }
            int remaining = this.ptBuffer.remaining();
            ByteBuffer slice = pt.slice();
            slice.limit(remaining);
            pt.position(pt.position() + remaining);
            try {
                this.ptBuffer.flip();
                this.ctBuffer.clear();
                if (slice.remaining() != 0) {
                    this.encrypter.encryptSegment(this.ptBuffer, slice, false, this.ctBuffer);
                } else {
                    this.encrypter.encryptSegment(this.ptBuffer, false, this.ctBuffer);
                }
                this.ctBuffer.flip();
                this.ciphertextChannel.write(this.ctBuffer);
                this.ptBuffer.clear();
                this.ptBuffer.limit(this.plaintextSegmentSize);
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        }
        this.ptBuffer.put(pt);
        return pt.position() - position;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.open) {
            while (this.ctBuffer.remaining() > 0) {
                if (this.ciphertextChannel.write(this.ctBuffer) <= 0) {
                    throw new IOException("Failed to write ciphertext before closing");
                }
            }
            try {
                this.ctBuffer.clear();
                this.ptBuffer.flip();
                this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                this.ctBuffer.flip();
                while (this.ctBuffer.remaining() > 0) {
                    if (this.ciphertextChannel.write(this.ctBuffer) <= 0) {
                        throw new IOException("Failed to write ciphertext before closing");
                    }
                }
                this.ciphertextChannel.close();
                this.open = false;
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.open;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/StreamingAeadEncryptingStream.java =====
package com.google.crypto.tink.subtle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class StreamingAeadEncryptingStream extends FilterOutputStream {
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingStream(NonceBasedStreamingAead streamAead, OutputStream ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        super(ciphertextChannel);
        this.encrypter = streamAead.newStreamSegmentEncrypter(associatedData);
        int plaintextSegmentSize = streamAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.ptBuffer = ByteBuffer.allocate(plaintextSegmentSize);
        this.ctBuffer = ByteBuffer.allocate(streamAead.getCiphertextSegmentSize());
        this.ptBuffer.limit(this.plaintextSegmentSize - streamAead.getCiphertextOffset());
        ByteBuffer header = this.encrypter.getHeader();
        byte[] bArr = new byte[header.remaining()];
        header.get(bArr);
        this.out.write(bArr);
        this.open = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b});
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] pt, int offset, int length) throws IOException {
        if (!this.open) {
            throw new IOException("Trying to write to closed stream");
        }
        while (length > this.ptBuffer.remaining()) {
            int remaining = this.ptBuffer.remaining();
            ByteBuffer wrap = ByteBuffer.wrap(pt, offset, remaining);
            offset += remaining;
            length -= remaining;
            try {
                this.ptBuffer.flip();
                this.ctBuffer.clear();
                this.encrypter.encryptSegment(this.ptBuffer, wrap, false, this.ctBuffer);
                this.ctBuffer.flip();
                this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
                this.ptBuffer.clear();
                this.ptBuffer.limit(this.plaintextSegmentSize);
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        }
        this.ptBuffer.put(pt, offset, length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.open) {
            try {
                this.ptBuffer.flip();
                this.ctBuffer.clear();
                this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                this.ctBuffer.flip();
                this.out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
                this.open = false;
                super.close();
            } catch (GeneralSecurityException e) {
                throw new IOException("ptBuffer.remaining():" + this.ptBuffer.remaining() + " ctBuffer.remaining():" + this.ctBuffer.remaining(), e);
            }
        }
    }
}

// ===== FILE: com/google/crypto/tink/subtle/StreamingAeadSeekableDecryptingChannel.java =====
package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private int currentSegmentNr;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean headerRead;
    private boolean isCurrentSegmentDecrypted;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private long plaintextPosition;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead streamAead, SeekableByteChannel ciphertext, byte[] associatedData) throws IOException, GeneralSecurityException {
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = ciphertext;
        this.header = ByteBuffer.allocate(streamAead.getHeaderLength());
        int ciphertextSegmentSize = streamAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.ciphertextSegment = ByteBuffer.allocate(ciphertextSegmentSize);
        int plaintextSegmentSize = streamAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.plaintextSegment = ByteBuffer.allocate(plaintextSegmentSize + 16);
        this.plaintextPosition = 0L;
        this.headerRead = false;
        this.currentSegmentNr = -1;
        this.isCurrentSegmentDecrypted = false;
        long size = ciphertext.size();
        this.ciphertextChannelSize = size;
        this.aad = Arrays.copyOf(associatedData, associatedData.length);
        this.isopen = ciphertext.isOpen();
        int i = (int) (size / ciphertextSegmentSize);
        int i2 = (int) (size % ciphertextSegmentSize);
        int ciphertextOverhead = streamAead.getCiphertextOverhead();
        if (i2 > 0) {
            this.numberOfSegments = i + 1;
            if (i2 < ciphertextOverhead) {
                throw new IOException("Invalid ciphertext size");
            }
            this.lastCiphertextSegmentSize = i2;
        } else {
            this.numberOfSegments = i;
            this.lastCiphertextSegmentSize = ciphertextSegmentSize;
        }
        int ciphertextOffset = streamAead.getCiphertextOffset();
        this.ciphertextOffset = ciphertextOffset;
        int headerLength = ciphertextOffset - streamAead.getHeaderLength();
        this.firstSegmentOffset = headerLength;
        if (headerLength < 0) {
            throw new IOException("Invalid ciphertext offset or header length");
        }
        long j = (this.numberOfSegments * ciphertextOverhead) + ciphertextOffset;
        if (j > size) {
            throw new IOException("Ciphertext is too short");
        }
        this.plaintextSize = size - j;
    }

    public synchronized String toString() {
        StringBuilder sb;
        String str;
        sb = new StringBuilder("StreamingAeadSeekableDecryptingChannel\nciphertextChannel");
        try {
            str = "position:" + this.ciphertextChannel.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb.append(str);
        sb.append("\nciphertextChannelSize:");
        sb.append(this.ciphertextChannelSize);
        sb.append("\nplaintextSize:");
        sb.append(this.plaintextSize);
        sb.append("\nciphertextSegmentSize:");
        sb.append(this.ciphertextSegmentSize);
        sb.append("\nnumberOfSegments:");
        sb.append(this.numberOfSegments);
        sb.append("\nheaderRead:");
        sb.append(this.headerRead);
        sb.append("\nplaintextPosition:");
        sb.append(this.plaintextPosition);
        sb.append("\nHeader position:");
        sb.append(this.header.position());
        sb.append(" limit:");
        sb.append(this.header.position());
        sb.append("\ncurrentSegmentNr:");
        sb.append(this.currentSegmentNr);
        sb.append("\nciphertextSgement position:");
        sb.append(this.ciphertextSegment.position());
        sb.append(" limit:");
        sb.append(this.ciphertextSegment.limit());
        sb.append("\nisCurrentSegmentDecrypted:");
        sb.append(this.isCurrentSegmentDecrypted);
        sb.append("\nplaintextSegment position:");
        sb.append(this.plaintextSegment.position());
        sb.append(" limit:");
        sb.append(this.plaintextSegment.limit());
        return sb.toString();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        return this.plaintextPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long newPosition) {
        this.plaintextPosition = newPosition;
        return this;
    }

    private boolean tryReadHeader() throws IOException {
        this.ciphertextChannel.position(this.header.position() + this.firstSegmentOffset);
        this.ciphertextChannel.read(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    private int getSegmentNr(long plaintextPosition) {
        return (int) ((plaintextPosition + this.ciphertextOffset) / this.plaintextSegmentSize);
    }

    private boolean tryLoadSegment(int segmentNr) throws IOException {
        int i;
        if (segmentNr < 0 || segmentNr >= (i = this.numberOfSegments)) {
            throw new IOException("Invalid position");
        }
        boolean z = segmentNr == i - 1;
        if (segmentNr == this.currentSegmentNr) {
            if (this.isCurrentSegmentDecrypted) {
                return true;
            }
        } else {
            int i2 = this.ciphertextSegmentSize;
            long j = segmentNr * i2;
            if (z) {
                i2 = this.lastCiphertextSegmentSize;
            }
            if (segmentNr == 0) {
                int i3 = this.ciphertextOffset;
                i2 -= i3;
                j = i3;
            }
            this.ciphertextChannel.position(j);
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(i2);
            this.currentSegmentNr = segmentNr;
            this.isCurrentSegmentDecrypted = false;
        }
        if (this.ciphertextSegment.remaining() > 0) {
            this.ciphertextChannel.read(this.ciphertextSegment);
        }
        if (this.ciphertextSegment.remaining() > 0) {
            return false;
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, segmentNr, z, this.plaintextSegment);
            this.plaintextSegment.flip();
            this.isCurrentSegmentDecrypted = true;
            return true;
        } catch (GeneralSecurityException e) {
            this.currentSegmentNr = -1;
            throw new IOException("Failed to decrypt", e);
        }
    }

    private boolean reachedEnd() {
        return this.isCurrentSegmentDecrypted && this.currentSegmentNr == this.numberOfSegments - 1 && this.plaintextSegment.remaining() == 0;
    }

    public synchronized int read(ByteBuffer dst, long start) throws IOException {
        long position = position();
        try {
            position(start);
        } finally {
            position(position);
        }
        return read(dst);
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        long j;
        if (!this.isopen) {
            throw new ClosedChannelException();
        }
        if (!this.headerRead && !tryReadHeader()) {
            return 0;
        }
        int position = dst.position();
        while (dst.remaining() > 0) {
            long j2 = this.plaintextPosition;
            if (j2 < this.plaintextSize) {
                int segmentNr = getSegmentNr(j2);
                if (segmentNr == 0) {
                    j = this.plaintextPosition;
                } else {
                    j = (this.plaintextPosition + this.ciphertextOffset) % this.plaintextSegmentSize;
                }
                int i = (int) j;
                if (!tryLoadSegment(segmentNr)) {
                    break;
                }
                this.plaintextSegment.position(i);
                if (this.plaintextSegment.remaining() <= dst.remaining()) {
                    this.plaintextPosition += this.plaintextSegment.remaining();
                    dst.put(this.plaintextSegment);
                } else {
                    int remaining = dst.remaining();
                    ByteBuffer duplicate = this.plaintextSegment.duplicate();
                    duplicate.limit(duplicate.position() + remaining);
                    dst.put(duplicate);
                    this.plaintextPosition += remaining;
                    ByteBuffer byteBuffer = this.plaintextSegment;
                    byteBuffer.position(byteBuffer.position() + remaining);
                }
            } else {
                break;
            }
        }
        int position2 = dst.position() - position;
        if (position2 == 0 && reachedEnd()) {
            return -1;
        }
        return position2;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.plaintextSize;
    }

    public synchronized long verifiedSize() throws IOException {
        if (tryLoadSegment(this.numberOfSegments - 1)) {
        } else {
            throw new IOException("could not verify the size");
        }
        return this.plaintextSize;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long size) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
        this.isopen = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.isopen;
    }
}

// ===== FILE: com/google/crypto/tink/subtle/SubtleUtil.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SubtleUtil {
    public static String toEcdsaAlgo(Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        return hash + "withECDSA";
    }

    public static String toRsaSsaPkcs1Algo(Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        return hash + "withRSA";
    }

    /* renamed from: com.google.crypto.tink.subtle.SubtleUtil$1 */
    static /* synthetic */ class C07271 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String toDigestAlgo(Enums.HashType hash) throws GeneralSecurityException {
        int i = C07271.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hash.ordinal()];
        if (i == 1) {
            return AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1;
        }
        if (i == 2) {
            return "SHA-256";
        }
        if (i == 3) {
            return "SHA-384";
        }
        if (i == 4) {
            return "SHA-512";
        }
        throw new GeneralSecurityException("Unsupported hash " + hash);
    }

    public static boolean isAndroid() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int androidApiLevel() {
        try {
            return Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return -1;
        }
    }

    public static BigInteger bytes2Integer(byte[] bs) {
        return new BigInteger(1, bs);
    }

    public static byte[] integer2Bytes(BigInteger num, int intendedLength) throws GeneralSecurityException {
        byte[] byteArray = num.toByteArray();
        if (byteArray.length == intendedLength) {
            return byteArray;
        }
        int i = intendedLength + 1;
        if (byteArray.length > i) {
            throw new GeneralSecurityException("integer too large");
        }
        if (byteArray.length == i) {
            if (byteArray[0] == 0) {
                return Arrays.copyOfRange(byteArray, 1, byteArray.length);
            }
            throw new GeneralSecurityException("integer too large");
        }
        byte[] bArr = new byte[intendedLength];
        System.arraycopy(byteArray, 0, bArr, intendedLength - byteArray.length, byteArray.length);
        return bArr;
    }

    public static byte[] mgf1(byte[] mgfSeed, int maskLen, Enums.HashType mgfHash) throws GeneralSecurityException {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(toDigestAlgo(mgfHash));
        int digestLength = engineFactory.getDigestLength();
        byte[] bArr = new byte[maskLen];
        int i = 0;
        for (int i2 = 0; i2 <= (maskLen - 1) / digestLength; i2++) {
            engineFactory.reset();
            engineFactory.update(mgfSeed);
            engineFactory.update(integer2Bytes(BigInteger.valueOf(i2), 4));
            byte[] digest = engineFactory.digest();
            System.arraycopy(digest, 0, bArr, i, Math.min(digest.length, maskLen - i));
            i += digest.length;
        }
        return bArr;
    }

    public static void putAsUnsigedInt(ByteBuffer buffer, long value) throws GeneralSecurityException {
        if (0 > value || value >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        buffer.putInt((int) value);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/Validators.java =====
package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class Validators {
    private static final int MIN_RSA_MODULUS_SIZE = 2048;
    private static final String TYPE_URL_PREFIX = "type.googleapis.com/";
    private static final String URI_UNRESERVED_CHARS = "([0-9a-zA-Z\\-\\.\\_~])+";
    private static final Pattern GCP_KMS_CRYPTO_KEY_PATTERN = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS), 2);
    private static final Pattern GCP_KMS_CRYPTO_KEY_VERSION_PATTERN = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS), 2);

    private Validators() {
    }

    public static void validateTypeUrl(String typeUrl) throws GeneralSecurityException {
        if (!typeUrl.startsWith(TYPE_URL_PREFIX)) {
            throw new GeneralSecurityException(String.format("Error: type URL %s is invalid; it must start with %s.\n", typeUrl, TYPE_URL_PREFIX));
        }
        if (typeUrl.length() == 20) {
            throw new GeneralSecurityException(String.format("Error: type URL %s is invalid; it has no message name.\n", typeUrl));
        }
    }

    public static void validateAesKeySize(int sizeInBytes) throws InvalidAlgorithmParameterException {
        if (sizeInBytes != 16 && sizeInBytes != 32) {
            throw new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(sizeInBytes * 8)));
        }
    }

    public static void validateVersion(int candidate, int maxExpected) throws GeneralSecurityException {
        if (candidate < 0 || candidate > maxExpected) {
            throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", Integer.valueOf(candidate), Integer.valueOf(maxExpected)));
        }
    }

    /* renamed from: com.google.crypto.tink.subtle.Validators$1 */
    static /* synthetic */ class C07281 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void validateSignatureHash(Enums.HashType hash) throws GeneralSecurityException {
        int i = C07281.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hash.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        throw new GeneralSecurityException("Unsupported hash: " + hash.name());
    }

    public static void validateRsaModulusSize(int modulusSize) throws GeneralSecurityException {
        if (modulusSize < 2048) {
            throw new GeneralSecurityException(String.format("Modulus size is %d; only modulus size >= 2048-bit is supported", Integer.valueOf(modulusSize)));
        }
    }

    public static void validateRsaPublicExponent(BigInteger publicExponent) throws GeneralSecurityException {
        if (!publicExponent.testBit(0)) {
            throw new GeneralSecurityException("Public exponent must be odd.");
        }
        if (publicExponent.compareTo(BigInteger.valueOf(65536L)) <= 0) {
            throw new GeneralSecurityException("Public exponent must be greater than 65536.");
        }
    }

    public static void validateNotExists(File f) throws IOException {
        if (f.exists()) {
            throw new IOException(String.format("%s exists, please choose another file\n", f));
        }
    }

    public static void validateExists(File f) throws IOException {
        if (!f.exists()) {
            throw new IOException(String.format("Error: %s doesn't exist, please choose another file\n", f));
        }
    }

    public static String validateKmsKeyUriAndRemovePrefix(String expectedPrefix, String kmsKeyUri) {
        if (!kmsKeyUri.toLowerCase(Locale.US).startsWith(expectedPrefix)) {
            throw new IllegalArgumentException(String.format("key URI must start with %s", expectedPrefix));
        }
        return kmsKeyUri.substring(expectedPrefix.length());
    }

    public static void validateCryptoKeyUri(String kmsKeyUri) throws GeneralSecurityException {
        if (GCP_KMS_CRYPTO_KEY_PATTERN.matcher(kmsKeyUri).matches()) {
            return;
        }
        if (GCP_KMS_CRYPTO_KEY_VERSION_PATTERN.matcher(kmsKeyUri).matches()) {
            throw new GeneralSecurityException("Invalid Google Cloud KMS Key URI. The URI must point to a CryptoKey, not a CryptoKeyVersion");
        }
        throw new GeneralSecurityException("Invalid Google Cloud KMS Key URI. The URI must point to a CryptoKey in the format projects/*/locations/*/keyRings/*/cryptoKeys/*. See https://cloud.google.com/kms/docs/reference/rest/v1/projects.locations.keyRings.cryptoKeys#CryptoKey");
    }
}

// ===== FILE: com/google/crypto/tink/subtle/X25519.java =====
package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class X25519 {
    public static byte[] generatePrivateKey() {
        byte[] randBytes = Random.randBytes(32);
        randBytes[0] = (byte) (randBytes[0] | 7);
        byte b = (byte) (randBytes[31] & 63);
        randBytes[31] = b;
        randBytes[31] = (byte) (b | ByteCompanionObject.MIN_VALUE);
        return randBytes;
    }

    public static byte[] computeSharedSecret(byte[] privateKey, byte[] peersPublicValue) throws InvalidKeyException {
        if (privateKey.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] copyOf = Arrays.copyOf(privateKey, 32);
        copyOf[0] = (byte) (copyOf[0] & 248);
        byte b = (byte) (copyOf[31] & ByteCompanionObject.MAX_VALUE);
        copyOf[31] = b;
        copyOf[31] = (byte) (b | 64);
        Curve25519.curveMult(jArr, copyOf, peersPublicValue);
        return Field25519.contract(jArr);
    }

    public static byte[] publicFromPrivate(byte[] privateKey) throws InvalidKeyException {
        if (privateKey.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr = new byte[32];
        bArr[0] = 9;
        return computeSharedSecret(privateKey, bArr);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/XChaCha20.java =====
package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: classes.dex */
class XChaCha20 extends ChaCha20Base {
    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    int nonceSizeInBytes() {
        return 24;
    }

    XChaCha20(byte[] key, int initialCounter) throws InvalidKeyException {
        super(key, initialCounter);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    int[] createInitialState(final int[] nonce, int counter) {
        if (nonce.length != nonceSizeInBytes() / 4) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(nonce.length * 32)));
        }
        int[] iArr = new int[16];
        ChaCha20Base.setSigmaAndKey(iArr, hChaCha20(this.key, nonce));
        iArr[12] = counter;
        iArr[13] = 0;
        iArr[14] = nonce[4];
        iArr[15] = nonce[5];
        return iArr;
    }

    static int[] hChaCha20(final int[] key, final int[] nonce) {
        int[] iArr = new int[16];
        ChaCha20Base.setSigmaAndKey(iArr, key);
        iArr[12] = nonce[0];
        iArr[13] = nonce[1];
        iArr[14] = nonce[2];
        iArr[15] = nonce[3];
        ChaCha20Base.shuffleState(iArr);
        iArr[4] = iArr[12];
        iArr[5] = iArr[13];
        iArr[6] = iArr[14];
        iArr[7] = iArr[15];
        return Arrays.copyOf(iArr, 8);
    }
}

// ===== FILE: com/google/crypto/tink/subtle/XChaCha20Poly1305.java =====
package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
public final class XChaCha20Poly1305 extends ChaCha20Poly1305Base {
    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] decrypt(byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        return super.decrypt(ciphertext, associatedData);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] encrypt(byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        return super.encrypt(plaintext, associatedData);
    }

    public XChaCha20Poly1305(final byte[] key) throws InvalidKeyException {
        super(key);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base
    ChaCha20Base newChaCha20Instance(final byte[] key, int initialCounter) throws InvalidKeyException {
        return new XChaCha20(key, initialCounter);
    }
}
