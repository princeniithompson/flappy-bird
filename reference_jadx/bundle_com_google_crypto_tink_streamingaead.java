
// ===== FILE: com/google/crypto/tink/streamingaead/AesCtrHmacStreamingKeyManager.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKey;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesCtrHmacStreaming;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class AesCtrHmacStreamingKeyManager extends KeyTypeManager<AesCtrHmacStreamingKey> {
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private static final int NONCE_PREFIX_IN_BYTES = 7;

    @Override // com.google.crypto.tink.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    AesCtrHmacStreamingKeyManager() {
        super(AesCtrHmacStreamingKey.class, new KeyTypeManager.PrimitiveFactory<StreamingAead, AesCtrHmacStreamingKey>(StreamingAead.class) { // from class: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public StreamingAead getPrimitive(AesCtrHmacStreamingKey key) throws GeneralSecurityException {
                return new AesCtrHmacStreaming(key.getKeyValue().toByteArray(), StreamingAeadUtil.toHmacAlgo(key.getParams().getHkdfHashType()), key.getParams().getDerivedKeySize(), StreamingAeadUtil.toHmacAlgo(key.getParams().getHmacParams().getHash()), key.getParams().getHmacParams().getTagSize(), key.getParams().getCiphertextSegmentSize(), 0);
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public void validateKey(AesCtrHmacStreamingKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion(), getVersion());
        if (key.getKeyValue().size() < 16) {
            throw new GeneralSecurityException("key_value must have at least 16 bytes");
        }
        if (key.getKeyValue().size() < key.getParams().getDerivedKeySize()) {
            throw new GeneralSecurityException("key_value must have at least as many bits as derived keys");
        }
        validateParams(key.getParams());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.KeyTypeManager
    public AesCtrHmacStreamingKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrHmacStreamingKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesCtrHmacStreamingKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacStreamingKeyFormat, AesCtrHmacStreamingKey>(AesCtrHmacStreamingKeyFormat.class) { // from class: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesCtrHmacStreamingKeyFormat format) throws GeneralSecurityException {
                if (format.getKeySize() >= 16) {
                    AesCtrHmacStreamingKeyManager.validateParams(format.getParams());
                    return;
                }
                throw new GeneralSecurityException("key_size must be at least 16 bytes");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public AesCtrHmacStreamingKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrHmacStreamingKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public AesCtrHmacStreamingKey createKey(AesCtrHmacStreamingKeyFormat format) throws GeneralSecurityException {
                return AesCtrHmacStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(format.getKeySize()))).setParams(format.getParams()).setVersion(AesCtrHmacStreamingKeyManager.this.getVersion()).build();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(AesCtrHmacStreamingParams params) throws GeneralSecurityException {
        Validators.validateAesKeySize(params.getDerivedKeySize());
        if (params.getHkdfHashType() == HashType.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        }
        if (params.getHmacParams().getHash() == HashType.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HMAC hash type");
        }
        validateHmacParams(params.getHmacParams());
        if (params.getCiphertextSegmentSize() < params.getDerivedKeySize() + params.getHmacParams().getTagSize() + 2 + 7) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + tag_size + NONCE_PREFIX_IN_BYTES + 2)");
        }
    }

    private static void validateHmacParams(HmacParams params) throws GeneralSecurityException {
        if (params.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = C07143.$SwitchMap$com$google$crypto$tink$proto$HashType[params.getHash().ordinal()];
        if (i == 1) {
            if (params.getTagSize() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 2) {
            if (params.getTagSize() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i == 3) {
                if (params.getTagSize() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            }
            throw new GeneralSecurityException("unknown hash type");
        }
    }

    /* renamed from: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager$3 */
    static /* synthetic */ class C07143 {
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

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCtrHmacStreamingKeyManager(), newKeyAllowed);
    }

    public static final KeyTemplate aes128CtrHmacSha2564KBTemplate() {
        return createKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 4096);
    }

    public static final KeyTemplate aes128CtrHmacSha2561MBTemplate() {
        return createKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 1048576);
    }

    public static final KeyTemplate aes256CtrHmacSha2564KBTemplate() {
        return createKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 4096);
    }

    public static final KeyTemplate aes256CtrHmacSha2561MBTemplate() {
        return createKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 1048576);
    }

    private static KeyTemplate createKeyTemplate(int mainKeySize, HashType hkdfHashType, int derivedKeySize, HashType macHashType, int tagSize, int ciphertextSegmentSize) {
        return KeyTemplate.create(new AesCtrHmacStreamingKeyManager().getKeyType(), AesCtrHmacStreamingKeyFormat.newBuilder().setParams(AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(ciphertextSegmentSize).setDerivedKeySize(derivedKeySize).setHkdfHashType(hkdfHashType).setHmacParams(HmacParams.newBuilder().setHash(macHashType).setTagSize(tagSize).build()).build()).setKeySize(mainKeySize).build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/AesGcmHkdfStreamingKeyManager.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesGcmHkdfStreaming;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class AesGcmHkdfStreamingKeyManager extends KeyTypeManager<AesGcmHkdfStreamingKey> {
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int TAG_SIZE_IN_BYTES = 16;

    @Override // com.google.crypto.tink.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    AesGcmHkdfStreamingKeyManager() {
        super(AesGcmHkdfStreamingKey.class, new KeyTypeManager.PrimitiveFactory<StreamingAead, AesGcmHkdfStreamingKey>(StreamingAead.class) { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public StreamingAead getPrimitive(AesGcmHkdfStreamingKey key) throws GeneralSecurityException {
                return new AesGcmHkdfStreaming(key.getKeyValue().toByteArray(), StreamingAeadUtil.toHmacAlgo(key.getParams().getHkdfHashType()), key.getParams().getDerivedKeySize(), key.getParams().getCiphertextSegmentSize(), 0);
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public void validateKey(AesGcmHkdfStreamingKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion(), getVersion());
        validateParams(key.getParams());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.KeyTypeManager
    public AesGcmHkdfStreamingKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesGcmHkdfStreamingKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesGcmHkdfStreamingKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesGcmHkdfStreamingKeyFormat, AesGcmHkdfStreamingKey>(AesGcmHkdfStreamingKeyFormat.class) { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesGcmHkdfStreamingKeyFormat format) throws GeneralSecurityException {
                if (format.getKeySize() >= 16) {
                    AesGcmHkdfStreamingKeyManager.validateParams(format.getParams());
                    return;
                }
                throw new GeneralSecurityException("key_size must be at least 16 bytes");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public AesGcmHkdfStreamingKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesGcmHkdfStreamingKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public AesGcmHkdfStreamingKey createKey(AesGcmHkdfStreamingKeyFormat format) throws GeneralSecurityException {
                return AesGcmHkdfStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(format.getKeySize()))).setParams(format.getParams()).setVersion(AesGcmHkdfStreamingKeyManager.this.getVersion()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public AesGcmHkdfStreamingKey deriveKey(AesGcmHkdfStreamingKeyFormat format, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(format.getVersion(), AesGcmHkdfStreamingKeyManager.this.getVersion());
                byte[] bArr = new byte[format.getKeySize()];
                try {
                    if (inputStream.read(bArr) != format.getKeySize()) {
                        throw new GeneralSecurityException("Not enough pseudorandomness given");
                    }
                    return AesGcmHkdfStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(bArr)).setParams(format.getParams()).setVersion(AesGcmHkdfStreamingKeyManager.this.getVersion()).build();
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(AesGcmHkdfStreamingParams params) throws GeneralSecurityException {
        Validators.validateAesKeySize(params.getDerivedKeySize());
        if (params.getHkdfHashType() == HashType.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        }
        if (params.getCiphertextSegmentSize() < params.getDerivedKeySize() + 7 + 16 + 2) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + NONCE_PREFIX_IN_BYTES + TAG_SIZE_IN_BYTES + 2)");
        }
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesGcmHkdfStreamingKeyManager(), newKeyAllowed);
    }

    public static final KeyTemplate aes128GcmHkdf4KBTemplate() {
        return createKeyTemplate(16, HashType.SHA256, 16, 4096);
    }

    public static final KeyTemplate aes128GcmHkdf1MBTemplate() {
        return createKeyTemplate(16, HashType.SHA256, 16, 1048576);
    }

    public static final KeyTemplate aes256GcmHkdf4KBTemplate() {
        return createKeyTemplate(32, HashType.SHA256, 32, 4096);
    }

    public static final KeyTemplate aes256GcmHkdf1MBTemplate() {
        return createKeyTemplate(32, HashType.SHA256, 32, 1048576);
    }

    private static KeyTemplate createKeyTemplate(int mainKeySize, HashType hkdfHashType, int derivedKeySize, int ciphertextSegmentSize) {
        return KeyTemplate.create(new AesGcmHkdfStreamingKeyManager().getKeyType(), AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(mainKeySize).setParams(AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(ciphertextSegmentSize).setDerivedKeySize(derivedKeySize).setHkdfHashType(hkdfHashType).build()).build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/InputStreamDecrypter.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: classes.dex */
final class InputStreamDecrypter extends InputStream {
    byte[] associatedData;
    InputStream ciphertextStream;
    PrimitiveSet<StreamingAead> primitives;
    boolean attemptedMatching = false;
    InputStream matchingStream = null;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public InputStreamDecrypter(PrimitiveSet<StreamingAead> primitives, InputStream ciphertextStream, final byte[] associatedData) {
        this.primitives = primitives;
        if (ciphertextStream.markSupported()) {
            this.ciphertextStream = ciphertextStream;
        } else {
            this.ciphertextStream = new BufferedInputStream(ciphertextStream);
        }
        this.ciphertextStream.mark(Integer.MAX_VALUE);
        this.associatedData = (byte[]) associatedData.clone();
    }

    private void rewind() throws IOException {
        this.ciphertextStream.reset();
    }

    private void disableRewinding() throws IOException {
        this.ciphertextStream.mark(0);
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream = this.matchingStream;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) != 1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b, int offset, int len) throws IOException {
        if (len == 0) {
            return 0;
        }
        InputStream inputStream = this.matchingStream;
        if (inputStream != null) {
            return inputStream.read(b, offset, len);
        }
        if (this.attemptedMatching) {
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
        this.attemptedMatching = true;
        Iterator<PrimitiveSet.Entry<StreamingAead>> it = this.primitives.getRawPrimitives().iterator();
        while (it.hasNext()) {
            try {
                InputStream newDecryptingStream = it.next().getPrimitive().newDecryptingStream(this.ciphertextStream, this.associatedData);
                int read = newDecryptingStream.read(b, offset, len);
                if (read == 0) {
                    throw new IOException("Could not read bytes from the ciphertext stream");
                }
                this.matchingStream = newDecryptingStream;
                disableRewinding();
                return read;
            } catch (IOException unused) {
                rewind();
            } catch (GeneralSecurityException unused2) {
                rewind();
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextStream.close();
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/ReadableByteChannelDecrypter.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: classes.dex */
final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;
    RewindableReadableByteChannel ciphertextChannel;
    ReadableByteChannel attemptingChannel = null;
    ReadableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public ReadableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitives, ReadableByteChannel ciphertextChannel, final byte[] associatedData) {
        Iterator<PrimitiveSet.Entry<StreamingAead>> it = primitives.getRawPrimitives().iterator();
        while (it.hasNext()) {
            this.remainingPrimitives.add(it.next().getPrimitive());
        }
        this.ciphertextChannel = new RewindableReadableByteChannel(ciphertextChannel);
        this.associatedData = (byte[]) associatedData.clone();
    }

    private synchronized ReadableByteChannel nextAttemptingChannel() throws IOException {
        while (!this.remainingPrimitives.isEmpty()) {
            try {
            } catch (GeneralSecurityException unused) {
                this.ciphertextChannel.rewind();
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return this.remainingPrimitives.removeFirst().newDecryptingChannel(this.ciphertextChannel, this.associatedData);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        if (dst.remaining() == 0) {
            return 0;
        }
        ReadableByteChannel readableByteChannel = this.matchingChannel;
        if (readableByteChannel != null) {
            return readableByteChannel.read(dst);
        }
        if (this.attemptingChannel == null) {
            this.attemptingChannel = nextAttemptingChannel();
        }
        while (true) {
            try {
                int read = this.attemptingChannel.read(dst);
                if (read == 0) {
                    return 0;
                }
                this.matchingChannel = this.attemptingChannel;
                this.attemptingChannel = null;
                this.ciphertextChannel.disableRewinding();
                return read;
            } catch (IOException unused) {
                this.ciphertextChannel.rewind();
                this.attemptingChannel = nextAttemptingChannel();
            }
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/SeekableByteChannelDecrypter.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SeekableByteChannelDecrypter implements SeekableByteChannel {
    byte[] associatedData;
    long cachedPosition;
    SeekableByteChannel ciphertextChannel;
    long startingPosition;
    SeekableByteChannel attemptingChannel = null;
    SeekableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public SeekableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitives, SeekableByteChannel ciphertextChannel, final byte[] associatedData) throws IOException {
        Iterator<PrimitiveSet.Entry<StreamingAead>> it = primitives.getRawPrimitives().iterator();
        while (it.hasNext()) {
            this.remainingPrimitives.add(it.next().getPrimitive());
        }
        this.ciphertextChannel = ciphertextChannel;
        this.cachedPosition = -1L;
        this.startingPosition = ciphertextChannel.position();
        this.associatedData = (byte[]) associatedData.clone();
    }

    private synchronized SeekableByteChannel nextAttemptingChannel() throws IOException {
        SeekableByteChannel newSeekableDecryptingChannel;
        while (!this.remainingPrimitives.isEmpty()) {
            this.ciphertextChannel.position(this.startingPosition);
            try {
                newSeekableDecryptingChannel = this.remainingPrimitives.removeFirst().newSeekableDecryptingChannel(this.ciphertextChannel, this.associatedData);
                long j = this.cachedPosition;
                if (j >= 0) {
                    newSeekableDecryptingChannel.position(j);
                }
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return newSeekableDecryptingChannel;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        if (dst.remaining() == 0) {
            return 0;
        }
        SeekableByteChannel seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
            return seekableByteChannel.read(dst);
        }
        if (this.attemptingChannel == null) {
            this.attemptingChannel = nextAttemptingChannel();
        }
        while (true) {
            try {
                int read = this.attemptingChannel.read(dst);
                if (read == 0) {
                    return 0;
                }
                this.matchingChannel = this.attemptingChannel;
                this.attemptingChannel = null;
                return read;
            } catch (IOException unused) {
                this.attemptingChannel = nextAttemptingChannel();
            }
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long newPosition) throws IOException {
        SeekableByteChannel seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
            seekableByteChannel.position(newPosition);
        } else {
            if (newPosition < 0) {
                throw new IllegalArgumentException("Position must be non-negative");
            }
            this.cachedPosition = newPosition;
            SeekableByteChannel seekableByteChannel2 = this.attemptingChannel;
            if (seekableByteChannel2 != null) {
                seekableByteChannel2.position(newPosition);
            }
        }
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() throws IOException {
        SeekableByteChannel seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
            return seekableByteChannel.position();
        }
        return this.cachedPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long size() throws IOException {
        SeekableByteChannel seekableByteChannel;
        seekableByteChannel = this.matchingChannel;
        if (seekableByteChannel != null) {
        } else {
            throw new IOException("Cannot determine size before first read()-call.");
        }
        return seekableByteChannel.size();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long size) throws IOException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws IOException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/StreamingAeadConfig.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class StreamingAeadConfig {
    public static final String AES_CTR_HMAC_STREAMINGAEAD_TYPE_URL = new AesCtrHmacStreamingKeyManager().getKeyType();
    public static final String AES_GCM_HKDF_STREAMINGAEAD_TYPE_URL = new AesGcmHkdfStreamingKeyManager().getKeyType();

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();
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
        AesCtrHmacStreamingKeyManager.register(true);
        AesGcmHkdfStreamingKeyManager.register(true);
        StreamingAeadWrapper.register();
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/StreamingAeadFactory.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public final class StreamingAeadFactory {
    public static StreamingAead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, null);
    }

    public static StreamingAead getPrimitive(KeysetHandle keysetHandle, final KeyManager<StreamingAead> keyManager) throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new StreamingAeadWrapper());
        return (StreamingAead) Registry.wrap(Registry.getPrimitives(keysetHandle, keyManager, StreamingAead.class));
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/StreamingAeadHelper.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class StreamingAeadHelper implements StreamingAead {
    PrimitiveSet<StreamingAead> primitives;

    public StreamingAeadHelper(PrimitiveSet<StreamingAead> primitives) throws GeneralSecurityException {
        if (primitives.getPrimary() == null) {
            throw new GeneralSecurityException("Missing primary primitive.");
        }
        this.primitives = primitives;
    }

    @Override // com.google.crypto.tink.StreamingAead
    public WritableByteChannel newEncryptingChannel(WritableByteChannel ciphertextDestination, byte[] associatedData) throws GeneralSecurityException, IOException {
        return this.primitives.getPrimary().getPrimitive().newEncryptingChannel(ciphertextDestination, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public ReadableByteChannel newDecryptingChannel(ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new ReadableByteChannelDecrypter(this.primitives, ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new SeekableByteChannelDecrypter(this.primitives, ciphertextChannel, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public InputStream newDecryptingStream(InputStream ciphertextStream, byte[] associatedData) throws GeneralSecurityException, IOException {
        return new InputStreamDecrypter(this.primitives, ciphertextStream, associatedData);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public OutputStream newEncryptingStream(OutputStream ciphertext, byte[] associatedData) throws GeneralSecurityException, IOException {
        return this.primitives.getPrimary().getPrimitive().newEncryptingStream(ciphertext, associatedData);
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/StreamingAeadKeyTemplates.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

@Deprecated
/* loaded from: classes.dex */
public final class StreamingAeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 4096);
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 4096);
    public static final KeyTemplate AES128_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(16, HashType.SHA256, 16, 4096);
    public static final KeyTemplate AES256_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(32, HashType.SHA256, 32, 4096);
    public static final KeyTemplate AES256_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(32, HashType.SHA256, 32, 1048576);

    public static KeyTemplate createAesCtrHmacStreamingKeyTemplate(int mainKeySize, HashType hkdfHashType, int derivedKeySize, HashType macHashType, int tagSize, int ciphertextSegmentSize) {
        return KeyTemplate.newBuilder().setValue(AesCtrHmacStreamingKeyFormat.newBuilder().setParams(AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(ciphertextSegmentSize).setDerivedKeySize(derivedKeySize).setHkdfHashType(hkdfHashType).setHmacParams(HmacParams.newBuilder().setHash(macHashType).setTagSize(tagSize).build()).build()).setKeySize(mainKeySize).build().toByteString()).setTypeUrl(new AesCtrHmacStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    public static KeyTemplate createAesGcmHkdfStreamingKeyTemplate(int mainKeySize, HashType hkdfHashType, int derivedKeySize, int ciphertextSegmentSize) {
        return KeyTemplate.newBuilder().setValue(AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(mainKeySize).setParams(AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(ciphertextSegmentSize).setDerivedKeySize(derivedKeySize).setHkdfHashType(hkdfHashType).build()).build().toByteString()).setTypeUrl(new AesGcmHkdfStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }
}

// ===== FILE: com/google/crypto/tink/streamingaead/StreamingAeadUtil.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.HashType;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
class StreamingAeadUtil {
    StreamingAeadUtil() {
    }

    /* renamed from: com.google.crypto.tink.streamingaead.StreamingAeadUtil$1 */
    static /* synthetic */ class C07171 {
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

    public static String toHmacAlgo(HashType hash) throws NoSuchAlgorithmException {
        int i = C07171.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
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
}

// ===== FILE: com/google/crypto/tink/streamingaead/StreamingAeadWrapper.java =====
package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class StreamingAeadWrapper implements PrimitiveWrapper<StreamingAead, StreamingAead> {
    StreamingAeadWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public StreamingAead wrap(final PrimitiveSet<StreamingAead> primitives) throws GeneralSecurityException {
        return new StreamingAeadHelper(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<StreamingAead> getPrimitiveClass() {
        return StreamingAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<StreamingAead> getInputPrimitiveClass() {
        return StreamingAead.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new StreamingAeadWrapper());
    }
}
