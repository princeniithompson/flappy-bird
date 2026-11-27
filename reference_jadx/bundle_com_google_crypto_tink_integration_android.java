
// ===== FILE: com/google/crypto/tink/integration/android/AndroidKeysetManager.java =====
package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* loaded from: classes.dex */
public final class AndroidKeysetManager {
    private static final String TAG = "AndroidKeysetManager";
    private KeysetManager keysetManager;
    private final Aead masterKey;
    private final KeysetWriter writer;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    /* synthetic */ AndroidKeysetManager(Builder builder, C05611 c05611) throws GeneralSecurityException, IOException {
        this(builder);
    }

    private AndroidKeysetManager(Builder builder) throws GeneralSecurityException, IOException {
        this.writer = builder.writer;
        this.masterKey = builder.masterKey;
        this.keysetManager = builder.keysetManager;
    }

    public static final class Builder {
        private KeysetManager keysetManager;
        private KeysetReader reader = null;
        private KeysetWriter writer = null;
        private String masterKeyUri = null;
        private Aead masterKey = null;
        private boolean useKeystore = true;
        private KeyTemplate keyTemplate = null;
        private KeyStore keyStore = null;

        public Builder withSharedPref(Context context, String keysetName, String prefFileName) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (keysetName == null) {
                throw new IllegalArgumentException("need a keyset name");
            }
            this.reader = new SharedPrefKeysetReader(context, keysetName, prefFileName);
            this.writer = new SharedPrefKeysetWriter(context, keysetName, prefFileName);
            return this;
        }

        public Builder withMasterKeyUri(String val) {
            if (!val.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.useKeystore) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.masterKeyUri = val;
            return this;
        }

        @Deprecated
        public Builder withKeyTemplate(com.google.crypto.tink.proto.KeyTemplate val) {
            this.keyTemplate = KeyTemplate.create(val.getTypeUrl(), val.getValue().toByteArray(), AndroidKeysetManager.fromProto(val.getOutputPrefixType()));
            return this;
        }

        public Builder withKeyTemplate(KeyTemplate val) {
            this.keyTemplate = val;
            return this;
        }

        @Deprecated
        public Builder doNotUseKeystore() {
            this.masterKeyUri = null;
            this.useKeystore = false;
            return this;
        }

        Builder withKeyStore(KeyStore val) {
            this.keyStore = val;
            return this;
        }

        public synchronized AndroidKeysetManager build() throws GeneralSecurityException, IOException {
            if (this.masterKeyUri != null) {
                this.masterKey = readOrGenerateNewMasterKey();
            }
            this.keysetManager = readOrGenerateNewKeyset();
            return new AndroidKeysetManager(this, null);
        }

        private Aead readOrGenerateNewMasterKey() throws GeneralSecurityException {
            AndroidKeystoreKmsClient androidKeystoreKmsClient;
            if (!AndroidKeysetManager.isAtLeastM()) {
                Log.w(AndroidKeysetManager.TAG, "Android Keystore requires at least Android M");
                return null;
            }
            if (this.keyStore != null) {
                androidKeystoreKmsClient = new AndroidKeystoreKmsClient.Builder().setKeyStore(this.keyStore).build();
            } else {
                androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            }
            boolean hasKey = androidKeystoreKmsClient.hasKey(this.masterKeyUri);
            if (!hasKey) {
                try {
                    AndroidKeystoreKmsClient.generateNewAeadKey(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException e) {
                    Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            }
            try {
                return androidKeystoreKmsClient.getAead(this.masterKeyUri);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (!hasKey) {
                    Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e2);
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.masterKeyUri), e2);
            }
        }

        private KeysetManager readOrGenerateNewKeyset() throws GeneralSecurityException, IOException {
            try {
                return read();
            } catch (FileNotFoundException e) {
                Log.w(AndroidKeysetManager.TAG, "keyset not found, will generate a new one", e);
                if (this.keyTemplate != null) {
                    KeysetManager add = KeysetManager.withEmptyKeyset().add(this.keyTemplate);
                    KeysetManager primary = add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
                    if (this.masterKey != null) {
                        primary.getKeysetHandle().write(this.writer, this.masterKey);
                    } else {
                        CleartextKeysetHandle.write(primary.getKeysetHandle(), this.writer);
                    }
                    return primary;
                }
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }

        private KeysetManager read() throws GeneralSecurityException, IOException {
            Aead aead = this.masterKey;
            if (aead != null) {
                try {
                    return KeysetManager.withKeysetHandle(KeysetHandle.read(this.reader, aead));
                } catch (InvalidProtocolBufferException | GeneralSecurityException e) {
                    Log.w(AndroidKeysetManager.TAG, "cannot decrypt keyset: ", e);
                }
            }
            return KeysetManager.withKeysetHandle(CleartextKeysetHandle.read(this.reader));
        }
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return this.keysetManager.getKeysetHandle();
    }

    @Deprecated
    public synchronized AndroidKeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager rotate = this.keysetManager.rotate(keyTemplate);
        this.keysetManager = rotate;
        write(rotate);
        return this;
    }

    @Deprecated
    public synchronized AndroidKeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }

    public synchronized AndroidKeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }

    public synchronized AndroidKeysetManager setPrimary(int keyId) throws GeneralSecurityException {
        KeysetManager primary = this.keysetManager.setPrimary(keyId);
        this.keysetManager = primary;
        write(primary);
        return this;
    }

    @Deprecated
    public synchronized AndroidKeysetManager promote(int keyId) throws GeneralSecurityException {
        return setPrimary(keyId);
    }

    public synchronized AndroidKeysetManager enable(int keyId) throws GeneralSecurityException {
        KeysetManager enable = this.keysetManager.enable(keyId);
        this.keysetManager = enable;
        write(enable);
        return this;
    }

    public synchronized AndroidKeysetManager disable(int keyId) throws GeneralSecurityException {
        KeysetManager disable = this.keysetManager.disable(keyId);
        this.keysetManager = disable;
        write(disable);
        return this;
    }

    public synchronized AndroidKeysetManager delete(int keyId) throws GeneralSecurityException {
        KeysetManager delete = this.keysetManager.delete(keyId);
        this.keysetManager = delete;
        write(delete);
        return this;
    }

    public synchronized AndroidKeysetManager destroy(int keyId) throws GeneralSecurityException {
        KeysetManager destroy = this.keysetManager.destroy(keyId);
        this.keysetManager = destroy;
        write(destroy);
        return this;
    }

    public synchronized boolean isUsingKeystore() {
        return shouldUseKeystore();
    }

    private void write(KeysetManager manager) throws GeneralSecurityException {
        try {
            if (shouldUseKeystore()) {
                manager.getKeysetHandle().write(this.writer, this.masterKey);
            } else {
                CleartextKeysetHandle.write(manager.getKeysetHandle(), this.writer);
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private boolean shouldUseKeystore() {
        return this.masterKey != null && isAtLeastM();
    }

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$1 */
    static /* synthetic */ class C05611 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTemplate.OutputPrefixType fromProto(OutputPrefixType outputPrefixType) {
        int i = C05611.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return KeyTemplate.OutputPrefixType.TINK;
        }
        if (i == 2) {
            return KeyTemplate.OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return KeyTemplate.OutputPrefixType.RAW;
        }
        if (i == 4) {
            return KeyTemplate.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }
}

// ===== FILE: com/google/crypto/tink/integration/android/AndroidKeystoreAesGcm.java =====
package com.google.crypto.tink.integration.android;

import android.util.Log;
import com.google.crypto.tink.Aead;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.ProviderException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes.dex */
public final class AndroidKeystoreAesGcm implements Aead {
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int MAX_WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 100;
    private static final String TAG = "AndroidKeystoreAesGcm";
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey key;

    public AndroidKeystoreAesGcm(String keyId) throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        SecretKey secretKey = (SecretKey) keyStore.getKey(keyId, null);
        this.key = secretKey;
        if (secretKey != null) {
            return;
        }
        throw new InvalidKeyException("Keystore cannot load the key with ID: " + keyId);
    }

    AndroidKeystoreAesGcm(String keyId, KeyStore keyStore) throws GeneralSecurityException {
        SecretKey secretKey = (SecretKey) keyStore.getKey(keyId, null);
        this.key = secretKey;
        if (secretKey != null) {
            return;
        }
        throw new InvalidKeyException("Keystore cannot load the key with ID: " + keyId);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] aad) throws GeneralSecurityException {
        try {
            return encryptInternal(plaintext, aad);
        } catch (GeneralSecurityException | ProviderException e) {
            Log.w(TAG, "encountered a potentially transient KeyStore error, will wait and retry", e);
            sleep();
            return encryptInternal(plaintext, aad);
        }
    }

    private byte[] encryptInternal(final byte[] plaintext, final byte[] aad) throws GeneralSecurityException {
        if (plaintext.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr = new byte[plaintext.length + 12 + 16];
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, this.key);
        cipher.updateAAD(aad);
        cipher.doFinal(plaintext, 0, plaintext.length, bArr, 12);
        System.arraycopy(cipher.getIV(), 0, bArr, 0, 12);
        return bArr;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] aad) throws GeneralSecurityException {
        try {
            return decryptInternal(ciphertext, aad);
        } catch (GeneralSecurityException | ProviderException e) {
            Log.w(TAG, "encountered a potentially transient KeyStore error, will wait and retry", e);
            sleep();
            return decryptInternal(ciphertext, aad);
        }
    }

    private byte[] decryptInternal(final byte[] ciphertext, final byte[] aad) throws GeneralSecurityException {
        if (ciphertext.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, ciphertext, 0, 12);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, this.key, gCMParameterSpec);
        cipher.updateAAD(aad);
        return cipher.doFinal(ciphertext, 12, ciphertext.length - 12);
    }

    private static void sleep() {
        try {
            Thread.sleep((int) (Math.random() * 100.0d));
        } catch (InterruptedException unused) {
        }
    }
}

// ===== FILE: com/google/crypto/tink/integration/android/AndroidKeystoreKmsClient.java =====
package com.google.crypto.tink.integration.android;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* loaded from: classes.dex */
public final class AndroidKeystoreKmsClient implements KmsClient {
    public static final String PREFIX = "android-keystore://";
    private static final String TAG = "AndroidKeystoreKmsClient";
    private static final int WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 20;
    private KeyStore keyStore;
    private final String keyUri;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    @Deprecated
    public AndroidKeystoreKmsClient(String uri) {
        this(new Builder().setKeyUri(uri));
    }

    private AndroidKeystoreKmsClient(Builder builder) {
        this.keyUri = builder.keyUri;
        this.keyStore = builder.keyStore;
    }

    public static final class Builder {
        KeyStore keyStore;
        String keyUri = null;

        public Builder() {
            this.keyStore = null;
            if (!AndroidKeystoreKmsClient.isAtLeastM()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }

        public Builder setKeyUri(String val) {
            if (val == null || !val.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("val must start with android-keystore://");
            }
            this.keyUri = val;
            return this;
        }

        public Builder setKeyStore(KeyStore val) {
            if (val == null) {
                throw new IllegalArgumentException("val cannot be null");
            }
            this.keyStore = val;
            return this;
        }

        public AndroidKeystoreKmsClient build() {
            return new AndroidKeystoreKmsClient(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r3.toLowerCase(java.util.Locale.US).startsWith(com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.PREFIX) != false) goto L15;
     */
    @Override // com.google.crypto.tink.KmsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean doesSupport(String uri) {
        String str = this.keyUri;
        boolean z = true;
        if (str != null && str.equals(uri)) {
            return true;
        }
        if (this.keyUri == null) {
        }
        z = false;
        return z;
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withCredentials(String unused) throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withDefaultCredentials() throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.google.crypto.tink.KmsClient
    public synchronized Aead getAead(String uri) throws GeneralSecurityException {
        String str = this.keyUri;
        if (str != null && !str.equals(uri)) {
            throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.keyUri, uri));
        }
        return validateAead(new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, uri), this.keyStore));
    }

    public synchronized void deleteKey(String keyUri) throws GeneralSecurityException {
        this.keyStore.deleteEntry(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, keyUri));
    }

    synchronized boolean hasKey(String keyUri) throws GeneralSecurityException {
        String validateKmsKeyUriAndRemovePrefix;
        validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, keyUri);
        try {
        } catch (NullPointerException unused) {
            Log.w(TAG, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            } catch (InterruptedException unused2) {
            }
            return this.keyStore.containsAlias(validateKmsKeyUriAndRemovePrefix);
        }
        return this.keyStore.containsAlias(validateKmsKeyUriAndRemovePrefix);
    }

    public static Aead getOrGenerateNewAeadKey(String keyUri) throws GeneralSecurityException, IOException {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        if (!androidKeystoreKmsClient.hasKey(keyUri)) {
            Log.w(TAG, String.format("key URI %s doesn't exist, generating a new one", keyUri));
            generateNewAeadKey(keyUri);
        }
        return androidKeystoreKmsClient.getAead(keyUri);
    }

    public static void generateNewAeadKey(String keyUri) throws GeneralSecurityException {
        if (new AndroidKeystoreKmsClient().hasKey(keyUri)) {
            throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", keyUri));
        }
        String validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, keyUri);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(validateKmsKeyUriAndRemovePrefix, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    private static Aead validateAead(Aead aead) throws GeneralSecurityException {
        byte[] randBytes = Random.randBytes(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(randBytes, aead.decrypt(aead.encrypt(randBytes, bArr), bArr))) {
            return aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }
}

// ===== FILE: com/google/crypto/tink/integration/android/SharedPrefKeysetReader.java =====
package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Hex;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public final class SharedPrefKeysetReader implements KeysetReader {
    private final String keysetName;
    private final SharedPreferences sharedPreferences;

    public SharedPrefKeysetReader(Context context, String keysetName, String prefFilename) throws IOException {
        if (keysetName == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.keysetName = keysetName;
        Context applicationContext = context.getApplicationContext();
        if (prefFilename == null) {
            this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        } else {
            this.sharedPreferences = applicationContext.getSharedPreferences(prefFilename, 0);
        }
    }

    private byte[] readPref() throws IOException {
        try {
            String string = this.sharedPreferences.getString(this.keysetName, null);
            if (string == null) {
                throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.keysetName));
            }
            return Hex.decode(string);
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.keysetName));
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        return Keyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        return EncryptedKeyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }
}

// ===== FILE: com/google/crypto/tink/integration/android/SharedPrefKeysetWriter.java =====
package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.subtle.Hex;
import java.io.IOException;

/* loaded from: classes.dex */
public final class SharedPrefKeysetWriter implements KeysetWriter {
    private final SharedPreferences.Editor editor;
    private final String keysetName;

    public SharedPrefKeysetWriter(Context context, String keysetName, String prefFileName) {
        if (keysetName == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.keysetName = keysetName;
        Context applicationContext = context.getApplicationContext();
        if (prefFileName == null) {
            this.editor = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.editor = applicationContext.getSharedPreferences(prefFileName, 0).edit();
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        if (!this.editor.putString(this.keysetName, Hex.encode(keyset.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset keyset) throws IOException {
        if (!this.editor.putString(this.keysetName, Hex.encode(keyset.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
