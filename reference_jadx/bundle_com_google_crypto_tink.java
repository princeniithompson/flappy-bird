
// ===== FILE: com/google/crypto/tink/Aead.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface Aead {
    byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException;

    byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/BinaryKeysetReader.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class BinaryKeysetReader implements KeysetReader {
    private final boolean closeStreamAfterReading;
    private final InputStream inputStream;

    public static KeysetReader withInputStream(InputStream stream) {
        return new BinaryKeysetReader(stream, false);
    }

    public static KeysetReader withBytes(final byte[] bytes) {
        return new BinaryKeysetReader(new ByteArrayInputStream(bytes), true);
    }

    public static KeysetReader withFile(File file) throws IOException {
        return new BinaryKeysetReader(new FileInputStream(file), true);
    }

    private BinaryKeysetReader(InputStream stream, boolean closeStreamAfterReading) {
        this.inputStream = stream;
        this.closeStreamAfterReading = closeStreamAfterReading;
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            return Keyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            if (this.closeStreamAfterReading) {
                this.inputStream.close();
            }
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            return EncryptedKeyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            if (this.closeStreamAfterReading) {
                this.inputStream.close();
            }
        }
    }
}

// ===== FILE: com/google/crypto/tink/BinaryKeysetWriter.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class BinaryKeysetWriter implements KeysetWriter {
    private final boolean closeStreamAfterReading;
    private final OutputStream outputStream;

    private BinaryKeysetWriter(OutputStream stream, boolean closeStreamAfterReading) {
        this.outputStream = stream;
        this.closeStreamAfterReading = closeStreamAfterReading;
    }

    public static KeysetWriter withOutputStream(OutputStream stream) {
        return new BinaryKeysetWriter(stream, false);
    }

    public static KeysetWriter withFile(File file) throws IOException {
        return new BinaryKeysetWriter(new FileOutputStream(file), true);
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        try {
            keyset.writeTo(this.outputStream);
        } finally {
            if (this.closeStreamAfterReading) {
                this.outputStream.close();
            }
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset keyset) throws IOException {
        try {
            keyset.writeTo(this.outputStream);
        } finally {
            if (this.closeStreamAfterReading) {
                this.outputStream.close();
            }
        }
    }
}

// ===== FILE: com/google/crypto/tink/Catalogue.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String typeUrl, String primitiveName, int minVersion) throws GeneralSecurityException;

    PrimitiveWrapper<?, P> getPrimitiveWrapper() throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/CleartextKeysetHandle.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class CleartextKeysetHandle {
    @Deprecated
    public static final KeysetHandle parseFrom(final byte[] serialized) throws GeneralSecurityException {
        try {
            return KeysetHandle.fromKeyset(Keyset.parseFrom(serialized, ExtensionRegistryLite.getEmptyRegistry()));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static KeysetHandle read(KeysetReader reader) throws GeneralSecurityException, IOException {
        return KeysetHandle.fromKeyset(reader.read());
    }

    public static Keyset getKeyset(KeysetHandle keysetHandle) {
        return keysetHandle.getKeyset();
    }

    public static KeysetHandle fromKeyset(Keyset keyset) throws GeneralSecurityException {
        return KeysetHandle.fromKeyset(keyset);
    }

    public static void write(KeysetHandle handle, KeysetWriter keysetWriter) throws IOException {
        keysetWriter.write(handle.getKeyset());
    }
}

// ===== FILE: com/google/crypto/tink/Config.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyTypeEntry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Config {
    public static KeyTypeEntry getTinkKeyTypeEntry(String catalogueName, String primitiveName, String keyProtoName, int keyManagerVersion, boolean newKeyAllowed) {
        return KeyTypeEntry.newBuilder().setPrimitiveName(primitiveName).setTypeUrl("type.googleapis.com/google.crypto.tink." + keyProtoName).setKeyManagerVersion(keyManagerVersion).setNewKeyAllowed(newKeyAllowed).setCatalogueName(catalogueName).build();
    }

    public static void register(RegistryConfig config) throws GeneralSecurityException {
        Iterator<KeyTypeEntry> it = config.getEntryList().iterator();
        while (it.hasNext()) {
            registerKeyType(it.next());
        }
    }

    public static void registerKeyType(KeyTypeEntry entry) throws GeneralSecurityException {
        validate(entry);
        if (entry.getCatalogueName().equals("TinkAead") || entry.getCatalogueName().equals("TinkMac") || entry.getCatalogueName().equals("TinkHybridDecrypt") || entry.getCatalogueName().equals("TinkHybridEncrypt") || entry.getCatalogueName().equals("TinkPublicKeySign") || entry.getCatalogueName().equals("TinkPublicKeyVerify") || entry.getCatalogueName().equals("TinkStreamingAead") || entry.getCatalogueName().equals("TinkDeterministicAead")) {
            return;
        }
        Catalogue<?> catalogue = Registry.getCatalogue(entry.getCatalogueName());
        Registry.registerPrimitiveWrapper(catalogue.getPrimitiveWrapper());
        Registry.registerKeyManager(catalogue.getKeyManager(entry.getTypeUrl(), entry.getPrimitiveName(), entry.getKeyManagerVersion()), entry.getNewKeyAllowed());
    }

    private static void validate(KeyTypeEntry entry) throws GeneralSecurityException {
        if (entry.getTypeUrl().isEmpty()) {
            throw new GeneralSecurityException("Missing type_url.");
        }
        if (entry.getPrimitiveName().isEmpty()) {
            throw new GeneralSecurityException("Missing primitive_name.");
        }
        if (entry.getCatalogueName().isEmpty()) {
            throw new GeneralSecurityException("Missing catalogue_name.");
        }
    }
}

// ===== FILE: com/google/crypto/tink/CryptoFormat.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class CryptoFormat {
    public static final int LEGACY_PREFIX_SIZE = 5;
    public static final byte LEGACY_START_BYTE = 0;
    public static final int NON_RAW_PREFIX_SIZE = 5;
    public static final byte[] RAW_PREFIX = new byte[0];
    public static final int RAW_PREFIX_SIZE = 0;
    public static final int TINK_PREFIX_SIZE = 5;
    public static final byte TINK_START_BYTE = 1;

    /* renamed from: com.google.crypto.tink.CryptoFormat$1 */
    static /* synthetic */ class C05271 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.TINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static byte[] getOutputPrefix(Keyset.Key key) throws GeneralSecurityException {
        int i = C05271.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[key.getOutputPrefixType().ordinal()];
        if (i == 1 || i == 2) {
            return ByteBuffer.allocate(5).put((byte) 0).putInt(key.getKeyId()).array();
        }
        if (i == 3) {
            return ByteBuffer.allocate(5).put((byte) 1).putInt(key.getKeyId()).array();
        }
        if (i == 4) {
            return RAW_PREFIX;
        }
        throw new GeneralSecurityException("unknown output prefix type");
    }
}

// ===== FILE: com/google/crypto/tink/DeterministicAead.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface DeterministicAead {
    byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException;

    byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/HybridDecrypt.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface HybridDecrypt {
    byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/HybridEncrypt.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface HybridEncrypt {
    byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/JsonKeysetReader.java =====
package com.google.crypto.tink;

import androidx.core.app.NotificationCompat;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final boolean closeStreamAfterReading;
    private final InputStream inputStream;
    private final JSONObject json;
    private boolean urlSafeBase64;

    private JsonKeysetReader(InputStream inputStream, boolean closeStreamAfterReading) {
        this.urlSafeBase64 = false;
        this.inputStream = inputStream;
        this.closeStreamAfterReading = closeStreamAfterReading;
        this.json = null;
    }

    private JsonKeysetReader(JSONObject json) {
        this.urlSafeBase64 = false;
        this.json = json;
        this.inputStream = null;
        this.closeStreamAfterReading = false;
    }

    public static KeysetReader withInputStream(InputStream input) throws IOException {
        return new JsonKeysetReader(input, false);
    }

    public static JsonKeysetReader withJsonObject(JSONObject input) {
        return new JsonKeysetReader(input);
    }

    public static JsonKeysetReader withString(String input) {
        return new JsonKeysetReader(new ByteArrayInputStream(input.getBytes(UTF_8)), true);
    }

    public static JsonKeysetReader withBytes(final byte[] bytes) {
        return new JsonKeysetReader(new ByteArrayInputStream(bytes), true);
    }

    public static JsonKeysetReader withFile(File file) throws IOException {
        return new JsonKeysetReader(new FileInputStream(file), true);
    }

    public static JsonKeysetReader withPath(String path) throws IOException {
        return withFile(new File(path));
    }

    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withFile(path.toFile());
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            try {
                JSONObject jSONObject = this.json;
                if (jSONObject != null) {
                    return keysetFromJson(jSONObject);
                }
                Keyset keysetFromJson = keysetFromJson(new JSONObject(new String(Util.readAll(this.inputStream), UTF_8)));
                InputStream inputStream = this.inputStream;
                if (inputStream != null && this.closeStreamAfterReading) {
                    inputStream.close();
                }
                return keysetFromJson;
            } catch (JSONException e) {
                throw new IOException(e);
            }
        } finally {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null && this.closeStreamAfterReading) {
                inputStream2.close();
            }
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            try {
                JSONObject jSONObject = this.json;
                if (jSONObject != null) {
                    return encryptedKeysetFromJson(jSONObject);
                }
                EncryptedKeyset encryptedKeysetFromJson = encryptedKeysetFromJson(new JSONObject(new String(Util.readAll(this.inputStream), UTF_8)));
                InputStream inputStream = this.inputStream;
                if (inputStream != null && this.closeStreamAfterReading) {
                    inputStream.close();
                }
                return encryptedKeysetFromJson;
            } catch (JSONException e) {
                throw new IOException(e);
            }
        } finally {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null && this.closeStreamAfterReading) {
                inputStream2.close();
            }
        }
    }

    private Keyset keysetFromJson(JSONObject json) throws JSONException {
        validateKeyset(json);
        Keyset.Builder newBuilder = Keyset.newBuilder();
        if (json.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(json.getInt("primaryKeyId"));
        }
        JSONArray jSONArray = json.getJSONArray("key");
        for (int i = 0; i < jSONArray.length(); i++) {
            newBuilder.addKey(keyFromJson(jSONArray.getJSONObject(i)));
        }
        return newBuilder.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JSONObject json) throws JSONException {
        byte[] decode;
        validateEncryptedKeyset(json);
        if (this.urlSafeBase64) {
            decode = Base64.urlSafeDecode(json.getString("encryptedKeyset"));
        } else {
            decode = Base64.decode(json.getString("encryptedKeyset"));
        }
        return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(decode)).setKeysetInfo(keysetInfoFromJson(json.getJSONObject("keysetInfo"))).build();
    }

    private Keyset.Key keyFromJson(JSONObject json) throws JSONException {
        validateKey(json);
        return Keyset.Key.newBuilder().setStatus(getStatus(json.getString(NotificationCompat.CATEGORY_STATUS))).setKeyId(json.getInt("keyId")).setOutputPrefixType(getOutputPrefixType(json.getString("outputPrefixType"))).setKeyData(keyDataFromJson(json.getJSONObject("keyData"))).build();
    }

    private static KeysetInfo keysetInfoFromJson(JSONObject json) throws JSONException {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        if (json.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(json.getInt("primaryKeyId"));
        }
        if (json.has("keyInfo")) {
            JSONArray jSONArray = json.getJSONArray("keyInfo");
            for (int i = 0; i < jSONArray.length(); i++) {
                newBuilder.addKeyInfo(keyInfoFromJson(jSONArray.getJSONObject(i)));
            }
        }
        return newBuilder.build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JSONObject json) throws JSONException {
        return KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(json.getString(NotificationCompat.CATEGORY_STATUS))).setKeyId(json.getInt("keyId")).setOutputPrefixType(getOutputPrefixType(json.getString("outputPrefixType"))).setTypeUrl(json.getString("typeUrl")).build();
    }

    private KeyData keyDataFromJson(JSONObject json) throws JSONException {
        byte[] decode;
        validateKeyData(json);
        if (this.urlSafeBase64) {
            decode = Base64.urlSafeDecode(json.getString("value"));
        } else {
            decode = Base64.decode(json.getString("value"));
        }
        return KeyData.newBuilder().setTypeUrl(json.getString("typeUrl")).setValue(ByteString.copyFrom(decode)).setKeyMaterialType(getKeyMaterialType(json.getString("keyMaterialType"))).build();
    }

    private static KeyStatusType getStatus(String status) throws JSONException {
        if (status.equals("ENABLED")) {
            return KeyStatusType.ENABLED;
        }
        if (status.equals("DISABLED")) {
            return KeyStatusType.DISABLED;
        }
        throw new JSONException("unknown status: " + status);
    }

    private static OutputPrefixType getOutputPrefixType(String type) throws JSONException {
        if (type.equals("TINK")) {
            return OutputPrefixType.TINK;
        }
        if (type.equals("RAW")) {
            return OutputPrefixType.RAW;
        }
        if (type.equals("LEGACY")) {
            return OutputPrefixType.LEGACY;
        }
        if (type.equals("CRUNCHY")) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new JSONException("unknown output prefix type: " + type);
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String type) throws JSONException {
        if (type.equals("SYMMETRIC")) {
            return KeyData.KeyMaterialType.SYMMETRIC;
        }
        if (type.equals("ASYMMETRIC_PRIVATE")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
        }
        if (type.equals("ASYMMETRIC_PUBLIC")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
        }
        if (type.equals("REMOTE")) {
            return KeyData.KeyMaterialType.REMOTE;
        }
        throw new JSONException("unknown key material type: " + type);
    }

    private static void validateKeyset(JSONObject json) throws JSONException {
        if (!json.has("key") || json.getJSONArray("key").length() == 0) {
            throw new JSONException("invalid keyset");
        }
    }

    private static void validateEncryptedKeyset(JSONObject json) throws JSONException {
        if (!json.has("encryptedKeyset")) {
            throw new JSONException("invalid encrypted keyset");
        }
    }

    private static void validateKey(JSONObject json) throws JSONException {
        if (!json.has("keyData") || !json.has(NotificationCompat.CATEGORY_STATUS) || !json.has("keyId") || !json.has("outputPrefixType")) {
            throw new JSONException("invalid key");
        }
    }

    private static void validateKeyData(JSONObject json) throws JSONException {
        if (!json.has("typeUrl") || !json.has("value") || !json.has("keyMaterialType")) {
            throw new JSONException("invalid keyData");
        }
    }
}

// ===== FILE: com/google/crypto/tink/JsonKeysetWriter.java =====
package com.google.crypto.tink;

import androidx.core.app.NotificationCompat;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.subtle.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class JsonKeysetWriter implements KeysetWriter {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final OutputStream outputStream;

    private long toUnsignedLong(int x) {
        return x & 4294967295L;
    }

    private JsonKeysetWriter(OutputStream stream) {
        this.outputStream = stream;
    }

    public static KeysetWriter withOutputStream(OutputStream stream) {
        return new JsonKeysetWriter(stream);
    }

    public static KeysetWriter withFile(File file) throws IOException {
        return new JsonKeysetWriter(new FileOutputStream(file));
    }

    public static KeysetWriter withPath(String path) throws IOException {
        return withFile(new File(path));
    }

    public static KeysetWriter withPath(Path path) throws IOException {
        return withFile(path.toFile());
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        try {
            try {
                OutputStream outputStream = this.outputStream;
                String jSONObject = toJson(keyset).toString(4);
                Charset charset = UTF_8;
                outputStream.write(jSONObject.getBytes(charset));
                this.outputStream.write(System.lineSeparator().getBytes(charset));
            } catch (JSONException e) {
                throw new IOException(e);
            }
        } finally {
            this.outputStream.close();
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset keyset) throws IOException {
        try {
            try {
                OutputStream outputStream = this.outputStream;
                String jSONObject = toJson(keyset).toString(4);
                Charset charset = UTF_8;
                outputStream.write(jSONObject.getBytes(charset));
                this.outputStream.write(System.lineSeparator().getBytes(charset));
            } catch (JSONException e) {
                throw new IOException(e);
            }
        } finally {
            this.outputStream.close();
        }
    }

    private JSONObject toJson(Keyset keyset) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("primaryKeyId", toUnsignedLong(keyset.getPrimaryKeyId()));
        JSONArray jSONArray = new JSONArray();
        Iterator<Keyset.Key> it = keyset.getKeyList().iterator();
        while (it.hasNext()) {
            jSONArray.put(toJson(it.next()));
        }
        jSONObject.put("key", jSONArray);
        return jSONObject;
    }

    private JSONObject toJson(Keyset.Key key) throws JSONException {
        return new JSONObject().put("keyData", toJson(key.getKeyData())).put(NotificationCompat.CATEGORY_STATUS, key.getStatus().name()).put("keyId", toUnsignedLong(key.getKeyId())).put("outputPrefixType", key.getOutputPrefixType().name());
    }

    private JSONObject toJson(KeyData keyData) throws JSONException {
        return new JSONObject().put("typeUrl", keyData.getTypeUrl()).put("value", Base64.encode(keyData.getValue().toByteArray())).put("keyMaterialType", keyData.getKeyMaterialType().name());
    }

    private JSONObject toJson(EncryptedKeyset keyset) throws JSONException {
        return new JSONObject().put("encryptedKeyset", Base64.encode(keyset.getEncryptedKeyset().toByteArray())).put("keysetInfo", toJson(keyset.getKeysetInfo()));
    }

    private JSONObject toJson(KeysetInfo keysetInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("primaryKeyId", toUnsignedLong(keysetInfo.getPrimaryKeyId()));
        JSONArray jSONArray = new JSONArray();
        Iterator<KeysetInfo.KeyInfo> it = keysetInfo.getKeyInfoList().iterator();
        while (it.hasNext()) {
            jSONArray.put(toJson(it.next()));
        }
        jSONObject.put("keyInfo", jSONArray);
        return jSONObject;
    }

    private JSONObject toJson(KeysetInfo.KeyInfo keyInfo) throws JSONException {
        return new JSONObject().put("typeUrl", keyInfo.getTypeUrl()).put(NotificationCompat.CATEGORY_STATUS, keyInfo.getStatus().name()).put("keyId", keyInfo.getKeyId()).put("outputPrefixType", keyInfo.getOutputPrefixType().name());
    }
}

// ===== FILE: com/google/crypto/tink/KeyManager.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface KeyManager<P> {
    boolean doesSupport(String typeUrl);

    String getKeyType();

    P getPrimitive(ByteString serializedKey) throws GeneralSecurityException;

    P getPrimitive(MessageLite key) throws GeneralSecurityException;

    Class<P> getPrimitiveClass();

    int getVersion();

    MessageLite newKey(ByteString serializedKeyFormat) throws GeneralSecurityException;

    MessageLite newKey(MessageLite keyFormat) throws GeneralSecurityException;

    KeyData newKeyData(ByteString serializedKeyFormat) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/KeyManagerImpl.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {
    private final KeyTypeManager<KeyProtoT> keyTypeManager;
    private final Class<PrimitiveT> primitiveClass;

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager, Class<PrimitiveT> primitiveClass) {
        if (!keyTypeManager.supportedPrimitives().contains(primitiveClass) && !Void.class.equals(primitiveClass)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", keyTypeManager.toString(), primitiveClass.getName()));
        }
        this.keyTypeManager = keyTypeManager;
        this.primitiveClass = primitiveClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <CastedT> CastedT castOrThrowSecurityException(Object objectToCast, String exceptionText, Class<CastedT> classObject) throws GeneralSecurityException {
        if (classObject.isInstance(objectToCast)) {
            return objectToCast;
        }
        throw new GeneralSecurityException(exceptionText);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final PrimitiveT getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return validateKeyAndGetPrimitive(this.keyTypeManager.parseKey(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.getKeyClass().getName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.KeyManager
    public final PrimitiveT getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        return (PrimitiveT) validateKeyAndGetPrimitive((MessageLite) castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyTypeManager.getKeyClass().getName(), this.keyTypeManager.getKeyClass()));
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(ByteString serializedKeyFormat) throws GeneralSecurityException {
        try {
            return keyFactoryHelper().parseValidateCreate(serializedKeyFormat);
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.keyFactory().getKeyFormatClass().getName(), e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(MessageLite keyFormat) throws GeneralSecurityException {
        return keyFactoryHelper().castValidateCreate(keyFormat);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final boolean doesSupport(String typeUrl) {
        return typeUrl.equals(getKeyType());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final String getKeyType() {
        return this.keyTypeManager.getKeyType();
    }

    @Override // com.google.crypto.tink.KeyManager
    public int getVersion() {
        return this.keyTypeManager.getVersion();
    }

    @Override // com.google.crypto.tink.KeyManager
    public final KeyData newKeyData(ByteString serializedKeyFormat) throws GeneralSecurityException {
        try {
            return KeyData.newBuilder().setTypeUrl(getKeyType()).setValue(keyFactoryHelper().parseValidateCreate(serializedKeyFormat).toByteString()).setKeyMaterialType(this.keyTypeManager.keyMaterialType()).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final Class<PrimitiveT> getPrimitiveClass() {
        return this.primitiveClass;
    }

    private PrimitiveT validateKeyAndGetPrimitive(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.primitiveClass)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.keyTypeManager.validateKey(keyprotot);
        return (PrimitiveT) this.keyTypeManager.getPrimitive(keyprotot, this.primitiveClass);
    }

    private static class KeyFactoryHelper<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
        final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory;

        KeyFactoryHelper(KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) {
            this.keyFactory = keyFactory;
        }

        private KeyProtoT validateCreate(KeyFormatProtoT keyFormat) throws GeneralSecurityException {
            this.keyFactory.validateKeyFormat(keyFormat);
            return this.keyFactory.createKey(keyFormat);
        }

        KeyProtoT parseValidateCreate(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
            return validateCreate(this.keyFactory.parseKeyFormat(byteString));
        }

        /* JADX WARN: Multi-variable type inference failed */
        KeyProtoT castValidateCreate(MessageLite messageLite) throws GeneralSecurityException {
            return (KeyProtoT) validateCreate((MessageLite) KeyManagerImpl.castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyFactory.getKeyFormatClass().getName(), this.keyFactory.getKeyFormatClass()));
        }
    }

    private KeyFactoryHelper<?, KeyProtoT> keyFactoryHelper() {
        return new KeyFactoryHelper<>(this.keyTypeManager.keyFactory());
    }
}

// ===== FILE: com/google/crypto/tink/KeyTemplate.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: classes.dex */
public final class KeyTemplate {

    /* renamed from: kt */
    private final com.google.crypto.tink.proto.KeyTemplate f110kt;

    public enum OutputPrefixType {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    private static OutputPrefixType fromProto(com.google.crypto.tink.proto.OutputPrefixType outputPrefixType) {
        int i = C05281.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
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

    /* renamed from: com.google.crypto.tink.KeyTemplate$1 */
    static /* synthetic */ class C05281 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.google.crypto.tink.proto.OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr2;
            try {
                iArr2[com.google.crypto.tink.proto.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static com.google.crypto.tink.proto.OutputPrefixType toProto(OutputPrefixType outputPrefixType) {
        int i = C05281.$SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return com.google.crypto.tink.proto.OutputPrefixType.TINK;
        }
        if (i == 2) {
            return com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return com.google.crypto.tink.proto.OutputPrefixType.RAW;
        }
        if (i == 4) {
            return com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    public static KeyTemplate create(String typeUrl, byte[] value, OutputPrefixType outputPrefixType) {
        return new KeyTemplate(com.google.crypto.tink.proto.KeyTemplate.newBuilder().setTypeUrl(typeUrl).setValue(ByteString.copyFrom(value)).setOutputPrefixType(toProto(outputPrefixType)).build());
    }

    private KeyTemplate(com.google.crypto.tink.proto.KeyTemplate kt) {
        this.f110kt = kt;
    }

    com.google.crypto.tink.proto.KeyTemplate getProto() {
        return this.f110kt;
    }

    public String getTypeUrl() {
        return this.f110kt.getTypeUrl();
    }

    public byte[] getValue() {
        return this.f110kt.getValue().toByteArray();
    }

    public OutputPrefixType getOutputPrefixType() {
        return fromProto(this.f110kt.getOutputPrefixType());
    }
}

// ===== FILE: com/google/crypto/tink/KeyTypeManager.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {
    private final Class<KeyProtoT> clazz;
    private final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> factories;
    private final Class<?> firstPrimitiveClass;

    public abstract String getKeyType();

    public abstract int getVersion();

    public abstract KeyData.KeyMaterialType keyMaterialType();

    public abstract KeyProtoT parseKey(ByteString byteString) throws InvalidProtocolBufferException;

    public abstract void validateKey(KeyProtoT keyProto) throws GeneralSecurityException;

    /* JADX INFO: Access modifiers changed from: protected */
    public static abstract class PrimitiveFactory<PrimitiveT, KeyT> {
        private final Class<PrimitiveT> clazz;

        public abstract PrimitiveT getPrimitive(KeyT key) throws GeneralSecurityException;

        public PrimitiveFactory(Class<PrimitiveT> clazz) {
            this.clazz = clazz;
        }

        final Class<PrimitiveT> getPrimitiveClass() {
            return this.clazz;
        }
    }

    @SafeVarargs
    protected KeyTypeManager(Class<KeyProtoT> clazz, PrimitiveFactory<?, KeyProtoT>... factories) {
        this.clazz = clazz;
        HashMap hashMap = new HashMap();
        for (PrimitiveFactory<?, KeyProtoT> primitiveFactory : factories) {
            if (hashMap.containsKey(primitiveFactory.getPrimitiveClass())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + primitiveFactory.getPrimitiveClass().getCanonicalName());
            }
            hashMap.put(primitiveFactory.getPrimitiveClass(), primitiveFactory);
        }
        if (factories.length > 0) {
            this.firstPrimitiveClass = factories[0].getPrimitiveClass();
        } else {
            this.firstPrimitiveClass = Void.class;
        }
        this.factories = Collections.unmodifiableMap(hashMap);
    }

    public final Class<KeyProtoT> getKeyClass() {
        return this.clazz;
    }

    public final <P> P getPrimitive(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        PrimitiveFactory<?, KeyProtoT> primitiveFactory = this.factories.get(cls);
        if (primitiveFactory == null) {
            throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
        }
        return (P) primitiveFactory.getPrimitive(keyprotot);
    }

    public final Set<Class<?>> supportedPrimitives() {
        return this.factories.keySet();
    }

    final Class<?> firstSupportedPrimitiveClass() {
        return this.firstPrimitiveClass;
    }

    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyT> {
        private final Class<KeyFormatProtoT> clazz;

        public abstract KeyT createKey(KeyFormatProtoT keyFormat) throws GeneralSecurityException;

        public abstract KeyFormatProtoT parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException;

        public abstract void validateKeyFormat(KeyFormatProtoT keyFormatProto) throws GeneralSecurityException;

        public KeyFactory(Class<KeyFormatProtoT> clazz) {
            this.clazz = clazz;
        }

        public final Class<KeyFormatProtoT> getKeyFormatClass() {
            return this.clazz;
        }

        public KeyT deriveKey(KeyFormatProtoT keyFormat, InputStream pseudoRandomness) throws GeneralSecurityException {
            throw new GeneralSecurityException("deriveKey not implemented for key of type " + this.clazz.toString());
        }
    }

    public KeyFactory<?, KeyProtoT> keyFactory() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}

// ===== FILE: com/google/crypto/tink/KeyWrap.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface KeyWrap {
    byte[] unwrap(final byte[] data) throws GeneralSecurityException;

    byte[] wrap(final byte[] data) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/KeysetHandle.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class KeysetHandle {
    private final Keyset keyset;

    private KeysetHandle(Keyset keyset) {
        this.keyset = keyset;
    }

    static final KeysetHandle fromKeyset(Keyset keyset) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(keyset);
    }

    Keyset getKeyset() {
        return this.keyset;
    }

    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(this.keyset);
    }

    @Deprecated
    public static final KeysetHandle generateNew(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        return KeysetManager.withEmptyKeyset().rotate(keyTemplate).getKeysetHandle();
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return KeysetManager.withEmptyKeyset().rotate(keyTemplate.getProto()).getKeysetHandle();
    }

    public static final KeysetHandle read(KeysetReader reader, Aead masterKey) throws GeneralSecurityException, IOException {
        EncryptedKeyset readEncrypted = reader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(readEncrypted);
        return new KeysetHandle(decrypt(readEncrypted, masterKey));
    }

    public static final KeysetHandle readNoSecret(KeysetReader reader) throws GeneralSecurityException, IOException {
        try {
            Keyset read = reader.read();
            assertNoSecretKeyMaterial(read);
            return fromKeyset(read);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle readNoSecret(final byte[] serialized) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(serialized, ExtensionRegistryLite.getEmptyRegistry());
            assertNoSecretKeyMaterial(parseFrom);
            return fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public void write(KeysetWriter keysetWriter, Aead masterKey) throws GeneralSecurityException, IOException {
        keysetWriter.write(encrypt(this.keyset, masterKey));
    }

    public void writeNoSecret(KeysetWriter writer) throws GeneralSecurityException, IOException {
        assertNoSecretKeyMaterial(this.keyset);
        writer.write(this.keyset);
    }

    private static EncryptedKeyset encrypt(Keyset keyset, Aead masterKey) throws GeneralSecurityException {
        byte[] encrypt = masterKey.encrypt(keyset.toByteArray(), new byte[0]);
        try {
            if (!Keyset.parseFrom(masterKey.decrypt(encrypt, new byte[0]), ExtensionRegistryLite.getEmptyRegistry()).equals(keyset)) {
                throw new GeneralSecurityException("cannot encrypt keyset");
            }
            return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(encrypt)).setKeysetInfo(Util.getKeysetInfo(keyset)).build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead masterKey) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(masterKey.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), new byte[0]), ExtensionRegistryLite.getEmptyRegistry());
            assertEnoughKeyMaterial(parseFrom);
            return parseFrom;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        if (this.keyset == null) {
            throw new GeneralSecurityException("cleartext keyset is not available");
        }
        Keyset.Builder newBuilder = Keyset.newBuilder();
        for (Keyset.Key key : this.keyset.getKeyList()) {
            newBuilder.addKey(Keyset.Key.newBuilder().mergeFrom((Keyset.Key.Builder) key).setKeyData(createPublicKeyData(key.getKeyData())).build());
        }
        newBuilder.setPrimaryKeyId(this.keyset.getPrimaryKeyId());
        return new KeysetHandle(newBuilder.build());
    }

    private static KeyData createPublicKeyData(KeyData privateKeyData) throws GeneralSecurityException {
        if (privateKeyData.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            throw new GeneralSecurityException("The keyset contains a non-private key");
        }
        KeyData publicKeyData = Registry.getPublicKeyData(privateKeyData.getTypeUrl(), privateKeyData.getValue());
        validate(publicKeyData);
        return publicKeyData;
    }

    private static void validate(KeyData keyData) throws GeneralSecurityException {
        Registry.getPrimitive(keyData);
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    private static void assertNoSecretKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", key.getKeyData().getKeyMaterialType(), key.getKeyData().getTypeUrl()));
            }
        }
    }

    public static void assertEnoughKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        if (keyset == null || keyset.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset keyset) throws GeneralSecurityException {
        if (keyset == null || keyset.getEncryptedKeyset().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private <B, P> P getPrimitiveWithKnownInputPrimitive(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        return (P) Registry.wrap(Registry.getPrimitives(this, cls2), cls);
    }

    public <P> P getPrimitive(Class<P> cls) throws GeneralSecurityException {
        Class<?> inputPrimitive = Registry.getInputPrimitive(cls);
        if (inputPrimitive == null) {
            throw new GeneralSecurityException("No wrapper found for " + cls.getName());
        }
        return (P) getPrimitiveWithKnownInputPrimitive(cls, inputPrimitive);
    }

    public <P> P getPrimitive(KeyManager<P> keyManager, Class<P> cls) throws GeneralSecurityException {
        if (keyManager == null) {
            throw new IllegalArgumentException("customKeyManager must be non-null.");
        }
        return (P) Registry.wrap(Registry.getPrimitives(this, keyManager, cls));
    }
}

// ===== FILE: com/google/crypto/tink/KeysetManager.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class KeysetManager {
    private final Keyset.Builder keysetBuilder;

    private KeysetManager(Keyset.Builder val) {
        this.keysetBuilder = val;
    }

    public static KeysetManager withKeysetHandle(KeysetHandle val) {
        return new KeysetManager(val.getKeyset().toBuilder());
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return KeysetHandle.fromKeyset(this.keysetBuilder.build());
    }

    @Deprecated
    public synchronized KeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate, true);
        return this;
    }

    @Deprecated
    public synchronized KeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate, false);
        return this;
    }

    public synchronized KeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate.getProto(), false);
        return this;
    }

    @Deprecated
    public synchronized int addNewKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, boolean asPrimary) throws GeneralSecurityException {
        Keyset.Key newKey;
        newKey = newKey(keyTemplate);
        this.keysetBuilder.addKey(newKey);
        if (asPrimary) {
            this.keysetBuilder.setPrimaryKeyId(newKey.getKeyId());
        }
        return newKey.getKeyId();
    }

    public synchronized KeysetManager setPrimary(int keyId) throws GeneralSecurityException {
        for (int i = 0; i < this.keysetBuilder.getKeyCount(); i++) {
            Keyset.Key key = this.keysetBuilder.getKey(i);
            if (key.getKeyId() == keyId) {
                if (!key.getStatus().equals(KeyStatusType.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + keyId);
                }
                this.keysetBuilder.setPrimaryKeyId(keyId);
            }
        }
        throw new GeneralSecurityException("key not found: " + keyId);
        return this;
    }

    @Deprecated
    public synchronized KeysetManager promote(int keyId) throws GeneralSecurityException {
        return setPrimary(keyId);
    }

    public synchronized KeysetManager enable(int keyId) throws GeneralSecurityException {
        for (int i = 0; i < this.keysetBuilder.getKeyCount(); i++) {
            Keyset.Key key = this.keysetBuilder.getKey(i);
            if (key.getKeyId() == keyId) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED) {
                    throw new GeneralSecurityException("cannot enable key with id " + keyId + " and status " + key.getStatus());
                }
                this.keysetBuilder.setKey(i, key.toBuilder().setStatus(KeyStatusType.ENABLED).build());
            }
        }
        throw new GeneralSecurityException("key not found: " + keyId);
        return this;
    }

    public synchronized KeysetManager disable(int keyId) throws GeneralSecurityException {
        if (keyId == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot disable the primary key");
        }
        for (int i = 0; i < this.keysetBuilder.getKeyCount(); i++) {
            Keyset.Key key = this.keysetBuilder.getKey(i);
            if (key.getKeyId() == keyId) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED) {
                    throw new GeneralSecurityException("cannot disable key with id " + keyId + " and status " + key.getStatus());
                }
                this.keysetBuilder.setKey(i, key.toBuilder().setStatus(KeyStatusType.DISABLED).build());
            }
        }
        throw new GeneralSecurityException("key not found: " + keyId);
        return this;
    }

    public synchronized KeysetManager delete(int keyId) throws GeneralSecurityException {
        if (keyId == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot delete the primary key");
        }
        for (int i = 0; i < this.keysetBuilder.getKeyCount(); i++) {
            if (this.keysetBuilder.getKey(i).getKeyId() == keyId) {
                this.keysetBuilder.removeKey(i);
            }
        }
        throw new GeneralSecurityException("key not found: " + keyId);
        return this;
    }

    public synchronized KeysetManager destroy(int keyId) throws GeneralSecurityException {
        if (keyId == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot destroy the primary key");
        }
        for (int i = 0; i < this.keysetBuilder.getKeyCount(); i++) {
            Keyset.Key key = this.keysetBuilder.getKey(i);
            if (key.getKeyId() == keyId) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED && key.getStatus() != KeyStatusType.DESTROYED) {
                    throw new GeneralSecurityException("cannot destroy key with id " + keyId + " and status " + key.getStatus());
                }
                this.keysetBuilder.setKey(i, key.toBuilder().setStatus(KeyStatusType.DESTROYED).clearKeyData().build());
            }
        }
        throw new GeneralSecurityException("key not found: " + keyId);
        return this;
    }

    private synchronized Keyset.Key newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        int newKeyId;
        OutputPrefixType outputPrefixType;
        newKeyData = Registry.newKeyData(keyTemplate);
        newKeyId = newKeyId();
        outputPrefixType = keyTemplate.getOutputPrefixType();
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
            outputPrefixType = OutputPrefixType.TINK;
        }
        return Keyset.Key.newBuilder().setKeyData(newKeyData).setKeyId(newKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();
    }

    private synchronized boolean keyIdExists(int keyId) {
        Iterator<Keyset.Key> it = this.keysetBuilder.getKeyList().iterator();
        while (it.hasNext()) {
            if (it.next().getKeyId() == keyId) {
                return true;
            }
        }
        return false;
    }

    private synchronized int newKeyId() {
        int randPositiveInt;
        randPositiveInt = randPositiveInt();
        while (keyIdExists(randPositiveInt)) {
            randPositiveInt = randPositiveInt();
        }
        return randPositiveInt;
    }

    private static int randPositiveInt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & ByteCompanionObject.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE);
        }
        return i;
    }
}

// ===== FILE: com/google/crypto/tink/KeysetReader.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;

/* loaded from: classes.dex */
public interface KeysetReader {
    Keyset read() throws IOException;

    EncryptedKeyset readEncrypted() throws IOException;
}

// ===== FILE: com/google/crypto/tink/KeysetWriter.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;

/* loaded from: classes.dex */
public interface KeysetWriter {
    void write(EncryptedKeyset keyset) throws IOException;

    void write(Keyset keyset) throws IOException;
}

// ===== FILE: com/google/crypto/tink/KmsClient.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface KmsClient {
    boolean doesSupport(String keyUri);

    Aead getAead(String keyUri) throws GeneralSecurityException;

    KmsClient withCredentials(String credentialPath) throws GeneralSecurityException;

    KmsClient withDefaultCredentials() throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/KmsClients.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class KmsClients {
    private static List<KmsClient> autoClients;
    private static final CopyOnWriteArrayList<KmsClient> clients = new CopyOnWriteArrayList<>();

    public static void add(KmsClient client) {
        clients.add(client);
    }

    public static KmsClient get(String keyUri) throws GeneralSecurityException {
        Iterator<KmsClient> it = clients.iterator();
        while (it.hasNext()) {
            KmsClient next = it.next();
            if (next.doesSupport(keyUri)) {
                return next;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + keyUri);
    }

    public static synchronized KmsClient getAutoLoaded(String keyUri) throws GeneralSecurityException {
        KmsClient next;
        synchronized (KmsClients.class) {
            if (autoClients == null) {
                autoClients = loadAutoKmsClients();
            }
            Iterator<KmsClient> it = autoClients.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next.doesSupport(keyUri)) {
                }
            }
            throw new GeneralSecurityException("No KMS client does support: " + keyUri);
        }
        return next;
    }

    private static List<KmsClient> loadAutoKmsClients() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(KmsClient.class).iterator();
        while (it.hasNext()) {
            arrayList.add((KmsClient) it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}

// ===== FILE: com/google/crypto/tink/Mac.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface Mac {
    byte[] computeMac(final byte[] data) throws GeneralSecurityException;

    void verifyMac(final byte[] mac, final byte[] data) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/NoSecretKeysetHandle.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public final class NoSecretKeysetHandle {
    @Deprecated
    public static final KeysetHandle parseFrom(final byte[] serialized) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(serialized, ExtensionRegistryLite.getEmptyRegistry());
            validate(parseFrom);
            return KeysetHandle.fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle read(KeysetReader reader) throws GeneralSecurityException, IOException {
        Keyset read = reader.read();
        validate(read);
        return KeysetHandle.fromKeyset(read);
    }

    private static void validate(Keyset keyset) throws GeneralSecurityException {
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }
}

// ===== FILE: com/google/crypto/tink/PrimitiveSet.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class PrimitiveSet<P> {
    private Entry<P> primary;
    private final Class<P> primitiveClass;
    private final ConcurrentMap<Prefix, List<Entry<P>>> primitives = new ConcurrentHashMap();

    public static final class Entry<P> {
        private final byte[] identifier;
        private final int keyId;
        private final OutputPrefixType outputPrefixType;
        private final P primitive;
        private final KeyStatusType status;

        Entry(P primitive, final byte[] identifier, KeyStatusType status, OutputPrefixType outputPrefixType, int keyId) {
            this.primitive = primitive;
            this.identifier = Arrays.copyOf(identifier, identifier.length);
            this.status = status;
            this.outputPrefixType = outputPrefixType;
            this.keyId = keyId;
        }

        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public int getKeyId() {
            return this.keyId;
        }
    }

    public Entry<P> getPrimary() {
        return this.primary;
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public List<Entry<P>> getPrimitive(final byte[] identifier) {
        List<Entry<P>> list = this.primitives.get(new Prefix(identifier));
        return list != null ? list : Collections.emptyList();
    }

    protected List<Entry<P>> getPrimitive(Keyset.Key key) throws GeneralSecurityException {
        return getPrimitive(CryptoFormat.getOutputPrefix(key));
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.primitives.values();
    }

    private PrimitiveSet(Class<P> primitiveClass) {
        this.primitiveClass = primitiveClass;
    }

    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> primitiveClass) {
        return new PrimitiveSet<>(primitiveClass);
    }

    public void setPrimary(final Entry<P> primary) {
        if (primary == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (primary.getStatus() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        if (getPrimitive(primary.getIdentifier()).isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.primary = primary;
    }

    public Entry<P> addPrimitive(final P primitive, Keyset.Key key) throws GeneralSecurityException {
        if (key.getStatus() != KeyStatusType.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        Entry<P> entry = new Entry<>(primitive, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId());
        ArrayList arrayList = new ArrayList();
        arrayList.add(entry);
        Prefix prefix = new Prefix(entry.getIdentifier());
        List<Entry<P>> put = this.primitives.put(prefix, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(entry);
            this.primitives.put(prefix, Collections.unmodifiableList(arrayList2));
        }
        return entry;
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    private static class Prefix implements Comparable<Prefix> {
        private final byte[] prefix;

        private Prefix(byte[] prefix) {
            this.prefix = Arrays.copyOf(prefix, prefix.length);
        }

        public int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public boolean equals(Object o) {
            if (o instanceof Prefix) {
                return Arrays.equals(this.prefix, ((Prefix) o).prefix);
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Prefix o) {
            byte[] bArr = this.prefix;
            int length = bArr.length;
            byte[] bArr2 = o.prefix;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i = 0;
            while (true) {
                byte[] bArr3 = this.prefix;
                if (i >= bArr3.length) {
                    return 0;
                }
                byte b = bArr3[i];
                byte b2 = o.prefix[i];
                if (b != b2) {
                    return b - b2;
                }
                i++;
            }
        }

        public String toString() {
            return Hex.encode(this.prefix);
        }
    }
}

// ===== FILE: com/google/crypto/tink/PrimitiveWrapper.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface PrimitiveWrapper<B, P> {
    Class<B> getInputPrimitiveClass();

    Class<P> getPrimitiveClass();

    P wrap(PrimitiveSet<B> set) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/PrivateKeyManager.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface PrivateKeyManager<P> extends KeyManager<P> {
    KeyData getPublicKeyData(ByteString serializedKey) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/PrivateKeyManagerImpl.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class PrivateKeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyManagerImpl<PrimitiveT, KeyProtoT> implements PrivateKeyManager<PrimitiveT> {
    private final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyManager;
    private final KeyTypeManager<PublicKeyProtoT> publicKeyManager;

    public PrivateKeyManagerImpl(PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyManager, KeyTypeManager<PublicKeyProtoT> publicKeyManager, Class<PrimitiveT> primitiveClass) {
        super(privateKeyManager, primitiveClass);
        this.privateKeyManager = privateKeyManager;
        this.publicKeyManager = publicKeyManager;
    }

    @Override // com.google.crypto.tink.PrivateKeyManager
    public KeyData getPublicKeyData(ByteString serializedKey) throws GeneralSecurityException {
        try {
            KeyProtoT parseKey = this.privateKeyManager.parseKey(serializedKey);
            this.privateKeyManager.validateKey(parseKey);
            PublicKeyProtoT publicKey = this.privateKeyManager.getPublicKey(parseKey);
            this.publicKeyManager.validateKey(publicKey);
            return KeyData.newBuilder().setTypeUrl(this.publicKeyManager.getKeyType()).setValue(publicKey.toByteString()).setKeyMaterialType(this.publicKeyManager.keyMaterialType()).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }
}

// ===== FILE: com/google/crypto/tink/PrivateKeyTypeManager.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class PrivateKeyTypeManager<KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyTypeManager<KeyProtoT> {
    private final Class<PublicKeyProtoT> publicKeyClazz;

    public abstract PublicKeyProtoT getPublicKey(KeyProtoT keyProto) throws GeneralSecurityException;

    @SafeVarargs
    protected PrivateKeyTypeManager(Class<KeyProtoT> clazz, Class<PublicKeyProtoT> publicKeyClazz, KeyTypeManager.PrimitiveFactory<?, KeyProtoT>... factories) {
        super(clazz, factories);
        this.publicKeyClazz = publicKeyClazz;
    }

    public final Class<PublicKeyProtoT> getPublicKeyClass() {
        return this.publicKeyClazz;
    }
}

// ===== FILE: com/google/crypto/tink/PublicKeySign.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface PublicKeySign {
    byte[] sign(final byte[] data) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/PublicKeyVerify.java =====
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface PublicKeyVerify {
    void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/Registry.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class Registry {
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final ConcurrentMap<String, KeyManagerContainer> keyManagerMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyDeriverContainer> keyDeriverMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap = new ConcurrentHashMap();

    private interface KeyDeriverContainer {
        KeyData deriveKey(ByteString serializedKeyFormat, InputStream stream) throws GeneralSecurityException;
    }

    private interface KeyManagerContainer {
        Class<?> getImplementingClass();

        <P> KeyManager<P> getKeyManager(Class<P> primitiveClass) throws GeneralSecurityException;

        KeyManager<?> getUntypedKeyManager();

        MessageLite parseKey(ByteString serializedKey) throws GeneralSecurityException, InvalidProtocolBufferException;

        Class<?> publicKeyManagerClassOrNull();

        Set<Class<?>> supportedPrimitives();
    }

    private static <P> KeyManagerContainer createContainerFor(final KeyManager<P> keyManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.Registry.1
            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public MessageLite parseKey(ByteString serializedKey) throws GeneralSecurityException, InvalidProtocolBufferException {
                return null;
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> primitiveClass) throws GeneralSecurityException {
                if (!KeyManager.this.getPrimitiveClass().equals(primitiveClass)) {
                    throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
                }
                return KeyManager.this;
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                return KeyManager.this;
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return KeyManager.this.getClass();
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return Collections.singleton(KeyManager.this.getPrimitiveClass());
            }
        };
    }

    private static <KeyProtoT extends MessageLite> KeyManagerContainer createContainerFor(final KeyTypeManager<KeyProtoT> keyManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.Registry.2
            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> primitiveClass) throws GeneralSecurityException {
                try {
                    return new KeyManagerImpl(KeyTypeManager.this, primitiveClass);
                } catch (IllegalArgumentException e) {
                    throw new GeneralSecurityException("Primitive type not supported", e);
                }
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                KeyTypeManager keyTypeManager = KeyTypeManager.this;
                return new KeyManagerImpl(keyTypeManager, keyTypeManager.firstSupportedPrimitiveClass());
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return KeyTypeManager.this.getClass();
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return KeyTypeManager.this.supportedPrimitives();
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public MessageLite parseKey(ByteString serializedKey) throws GeneralSecurityException, InvalidProtocolBufferException {
                MessageLite parseKey = KeyTypeManager.this.parseKey(serializedKey);
                KeyTypeManager.this.validateKey(parseKey);
                return parseKey;
            }
        };
    }

    private static <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> KeyManagerContainer createPrivateKeyContainerFor(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> publicKeyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.Registry.3
            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> primitiveClass) throws GeneralSecurityException {
                try {
                    return new PrivateKeyManagerImpl(PrivateKeyTypeManager.this, publicKeyTypeManager, primitiveClass);
                } catch (IllegalArgumentException e) {
                    throw new GeneralSecurityException("Primitive type not supported", e);
                }
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                PrivateKeyTypeManager privateKeyTypeManager2 = PrivateKeyTypeManager.this;
                return new PrivateKeyManagerImpl(privateKeyTypeManager2, publicKeyTypeManager, privateKeyTypeManager2.firstSupportedPrimitiveClass());
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return PrivateKeyTypeManager.this.getClass();
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return PrivateKeyTypeManager.this.supportedPrimitives();
            }

            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return publicKeyTypeManager.getClass();
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [com.google.crypto.tink.shaded.protobuf.MessageLite] */
            @Override // com.google.crypto.tink.Registry.KeyManagerContainer
            public MessageLite parseKey(ByteString serializedKey) throws GeneralSecurityException, InvalidProtocolBufferException {
                ?? parseKey = PrivateKeyTypeManager.this.parseKey(serializedKey);
                PrivateKeyTypeManager.this.validateKey(parseKey);
                return parseKey;
            }
        };
    }

    private static <KeyProtoT extends MessageLite> KeyDeriverContainer createDeriverFor(final KeyTypeManager<KeyProtoT> keyManager) {
        return new KeyDeriverContainer() { // from class: com.google.crypto.tink.Registry.4
            /* JADX WARN: Unknown type variable: KeyProtoT in type: com.google.crypto.tink.KeyTypeManager$KeyFactory<KeyFormatProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite, KeyProtoT> */
            private <KeyFormatProtoT extends MessageLite> MessageLite deriveKeyWithFactory(ByteString serializedKeyFormat, InputStream stream, KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) throws GeneralSecurityException {
                try {
                    KeyFormatProtoT parseKeyFormat = keyFactory.parseKeyFormat(serializedKeyFormat);
                    keyFactory.validateKeyFormat(parseKeyFormat);
                    return (MessageLite) keyFactory.deriveKey(parseKeyFormat, stream);
                } catch (InvalidProtocolBufferException e) {
                    throw new GeneralSecurityException("parsing key format failed in deriveKey", e);
                }
            }

            @Override // com.google.crypto.tink.Registry.KeyDeriverContainer
            public KeyData deriveKey(ByteString serializedKeyFormat, InputStream stream) throws GeneralSecurityException {
                return KeyData.newBuilder().setTypeUrl(KeyTypeManager.this.getKeyType()).setValue(deriveKeyWithFactory(serializedKeyFormat, stream, KeyTypeManager.this.keyFactory()).toByteString()).setKeyMaterialType(KeyTypeManager.this.keyMaterialType()).build();
            }
        };
    }

    private static synchronized KeyManagerContainer getKeyManagerContainerOrThrow(String typeUrl) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainer;
        synchronized (Registry.class) {
            ConcurrentMap<String, KeyManagerContainer> concurrentMap = keyManagerMap;
            if (!concurrentMap.containsKey(typeUrl)) {
                throw new GeneralSecurityException("No key manager found for key type " + typeUrl);
            }
            keyManagerContainer = concurrentMap.get(typeUrl);
        }
        return keyManagerContainer;
    }

    static synchronized void reset() {
        synchronized (Registry.class) {
            keyManagerMap.clear();
            keyDeriverMap.clear();
            newKeyAllowedMap.clear();
            catalogueMap.clear();
            primitiveWrapperMap.clear();
        }
    }

    @Deprecated
    public static synchronized void addCatalogue(String catalogueName, Catalogue<?> catalogue) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (catalogueName == null) {
                throw new IllegalArgumentException("catalogueName must be non-null.");
            }
            if (catalogue == null) {
                throw new IllegalArgumentException("catalogue must be non-null.");
            }
            ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
            if (concurrentMap.containsKey(catalogueName.toLowerCase(Locale.US))) {
                if (!catalogue.getClass().equals(concurrentMap.get(catalogueName.toLowerCase(Locale.US)).getClass())) {
                    logger.warning("Attempted overwrite of a catalogueName catalogue for name " + catalogueName);
                    throw new GeneralSecurityException("catalogue for name " + catalogueName + " has been already registered");
                }
            }
            concurrentMap.put(catalogueName.toLowerCase(Locale.US), catalogue);
        }
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String catalogueName) throws GeneralSecurityException {
        if (catalogueName == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        Catalogue<?> catalogue = catalogueMap.get(catalogueName.toLowerCase(Locale.US));
        if (catalogue != null) {
            return catalogue;
        }
        String format = String.format("no catalogue found for %s. ", catalogueName);
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkaead")) {
            format = format + "Maybe call AeadConfig.register().";
        }
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
            format = format + "Maybe call DeterministicAeadConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
            format = format + "Maybe call StreamingAeadConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || catalogueName.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
            format = format + "Maybe call HybridConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkmac")) {
            format = format + "Maybe call MacConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
            format = format + "Maybe call SignatureConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tink")) {
            format = format + "Maybe call TinkConfig.register().";
        }
        throw new GeneralSecurityException(format);
    }

    private static <T> T checkNotNull(T reference) {
        reference.getClass();
        return reference;
    }

    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager((KeyManager) manager, true);
        }
    }

    private static synchronized void ensureKeyManagerInsertable(String typeUrl, Class<?> implementingClass, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            ConcurrentMap<String, KeyManagerContainer> concurrentMap = keyManagerMap;
            if (concurrentMap.containsKey(typeUrl)) {
                KeyManagerContainer keyManagerContainer = concurrentMap.get(typeUrl);
                if (!keyManagerContainer.getImplementingClass().equals(implementingClass)) {
                    logger.warning("Attempted overwrite of a registered key manager for key type " + typeUrl);
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", typeUrl, keyManagerContainer.getImplementingClass().getName(), implementingClass.getName()));
                }
                if (newKeyAllowed && !newKeyAllowedMap.get(typeUrl).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + typeUrl);
                }
            }
        }
    }

    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (manager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String keyType = manager.getKeyType();
            ensureKeyManagerInsertable(keyType, manager.getClass(), newKeyAllowed);
            keyManagerMap.putIfAbsent(keyType, createContainerFor(manager));
            newKeyAllowedMap.put(keyType, Boolean.valueOf(newKeyAllowed));
        }
    }

    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(final KeyTypeManager<KeyProtoT> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (manager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String keyType = manager.getKeyType();
            ensureKeyManagerInsertable(keyType, manager.getClass(), newKeyAllowed);
            ConcurrentMap<String, KeyManagerContainer> concurrentMap = keyManagerMap;
            if (!concurrentMap.containsKey(keyType)) {
                concurrentMap.put(keyType, createContainerFor(manager));
                keyDeriverMap.put(keyType, createDeriverFor(manager));
            }
            newKeyAllowedMap.put(keyType, Boolean.valueOf(newKeyAllowed));
        }
    }

    public static synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> publicKeyTypeManager, boolean newKeyAllowed) throws GeneralSecurityException {
        Class<?> publicKeyManagerClassOrNull;
        synchronized (Registry.class) {
            if (privateKeyTypeManager == null || publicKeyTypeManager == null) {
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            String keyType = privateKeyTypeManager.getKeyType();
            String keyType2 = publicKeyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, privateKeyTypeManager.getClass(), newKeyAllowed);
            ensureKeyManagerInsertable(keyType2, publicKeyTypeManager.getClass(), false);
            if (keyType.equals(keyType2)) {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
            ConcurrentMap<String, KeyManagerContainer> concurrentMap = keyManagerMap;
            if (concurrentMap.containsKey(keyType) && (publicKeyManagerClassOrNull = concurrentMap.get(keyType).publicKeyManagerClassOrNull()) != null && !publicKeyManagerClassOrNull.equals(publicKeyTypeManager.getClass())) {
                logger.warning("Attempted overwrite of a registered key manager for key type " + keyType + " with inconsistent public key type " + keyType2);
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", privateKeyTypeManager.getClass().getName(), publicKeyManagerClassOrNull.getName(), publicKeyTypeManager.getClass().getName()));
            }
            if (!concurrentMap.containsKey(keyType) || concurrentMap.get(keyType).publicKeyManagerClassOrNull() == null) {
                concurrentMap.put(keyType, createPrivateKeyContainerFor(privateKeyTypeManager, publicKeyTypeManager));
                keyDeriverMap.put(keyType, createDeriverFor(privateKeyTypeManager));
            }
            ConcurrentMap<String, Boolean> concurrentMap2 = newKeyAllowedMap;
            concurrentMap2.put(keyType, Boolean.valueOf(newKeyAllowed));
            if (!concurrentMap.containsKey(keyType2)) {
                concurrentMap.put(keyType2, createContainerFor(publicKeyTypeManager));
            }
            concurrentMap2.put(keyType2, false);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(typeUrl, manager, true);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        synchronized (Registry.class) {
            try {
                if (manager == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                if (!typeUrl.equals(manager.getKeyType())) {
                    throw new GeneralSecurityException("Manager does not support key type " + typeUrl + ".");
                }
                registerKeyManager(manager, newKeyAllowed);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized <B, P> void registerPrimitiveWrapper(final PrimitiveWrapper<B, P> wrapper) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (wrapper == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class<P> primitiveClass = wrapper.getPrimitiveClass();
            ConcurrentMap<Class<?>, PrimitiveWrapper<?, ?>> concurrentMap = primitiveWrapperMap;
            if (concurrentMap.containsKey(primitiveClass)) {
                PrimitiveWrapper<?, ?> primitiveWrapper = concurrentMap.get(primitiveClass);
                if (!wrapper.getClass().equals(primitiveWrapper.getClass())) {
                    logger.warning("Attempted overwrite of a registered SetWrapper for type " + primitiveClass);
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", primitiveClass.getName(), primitiveWrapper.getClass().getName(), wrapper.getClass().getName()));
                }
            }
            concurrentMap.put(primitiveClass, wrapper);
        }
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String typeUrl) throws GeneralSecurityException {
        return getKeyManagerInternal(typeUrl, null);
    }

    public static KeyManager<?> getUntypedKeyManager(String typeUrl) throws GeneralSecurityException {
        return getKeyManagerContainerOrThrow(typeUrl).getUntypedKeyManager();
    }

    public static <P> KeyManager<P> getKeyManager(String typeUrl, Class<P> primitiveClass) throws GeneralSecurityException {
        return getKeyManagerInternal(typeUrl, (Class) checkNotNull(primitiveClass));
    }

    private static String toCommaSeparatedString(Set<Class<?>> setOfClasses) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls : setOfClasses) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls.getCanonicalName());
            z = false;
        }
        return sb.toString();
    }

    private static <P> KeyManager<P> getKeyManagerInternal(String str, Class<P> cls) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainerOrThrow = getKeyManagerContainerOrThrow(str);
        if (cls == null) {
            return (KeyManager<P>) keyManagerContainerOrThrow.getUntypedKeyManager();
        }
        if (keyManagerContainerOrThrow.supportedPrimitives().contains(cls)) {
            return keyManagerContainerOrThrow.getKeyManager(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + keyManagerContainerOrThrow.getImplementingClass() + ", supported primitives: " + toCommaSeparatedString(keyManagerContainerOrThrow.supportedPrimitives()));
    }

    public static synchronized KeyData newKeyData(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
                newKeyData = untypedKeyManager.newKeyData(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKeyData;
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            newKeyData = newKeyData(keyTemplate.getProto());
        }
        return newKeyData;
    }

    public static synchronized MessageLite newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
                newKey = untypedKeyManager.newKey(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKey;
    }

    public static synchronized MessageLite newKey(String typeUrl, MessageLite format) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(typeUrl);
            if (newKeyAllowedMap.get(typeUrl).booleanValue()) {
                newKey = keyManager.newKey(format);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + typeUrl);
            }
        }
        return newKey;
    }

    static synchronized KeyData deriveKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, InputStream randomStream) throws GeneralSecurityException {
        KeyData deriveKey;
        synchronized (Registry.class) {
            String typeUrl = keyTemplate.getTypeUrl();
            ConcurrentMap<String, KeyDeriverContainer> concurrentMap = keyDeriverMap;
            if (!concurrentMap.containsKey(typeUrl)) {
                throw new GeneralSecurityException("No keymanager registered or key manager cannot derive keys for " + typeUrl);
            }
            deriveKey = concurrentMap.get(typeUrl).deriveKey(keyTemplate.getValue(), randomStream);
        }
        return deriveKey;
    }

    public static KeyData getPublicKeyData(String typeUrl, ByteString serializedPrivateKey) throws GeneralSecurityException {
        KeyManager keyManager = getKeyManager(typeUrl);
        if (!(keyManager instanceof PrivateKeyManager)) {
            throw new GeneralSecurityException("manager for key type " + typeUrl + " is not a PrivateKeyManager");
        }
        return ((PrivateKeyManager) keyManager).getPublicKeyData(serializedPrivateKey);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, MessageLite messageLite) throws GeneralSecurityException {
        return (P) getPrimitiveInternal(str, messageLite, (Class) null);
    }

    public static <P> P getPrimitive(String str, MessageLite messageLite, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitiveInternal(str, messageLite, (Class) checkNotNull(cls));
    }

    private static <P> P getPrimitiveInternal(String str, MessageLite messageLite, Class<P> cls) throws GeneralSecurityException {
        return (P) getKeyManagerInternal(str, cls).getPrimitive(messageLite);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, ByteString byteString) throws GeneralSecurityException {
        return (P) getPrimitiveInternal(str, byteString, (Class) null);
    }

    public static <P> P getPrimitive(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitiveInternal(str, byteString, (Class) checkNotNull(cls));
    }

    private static <P> P getPrimitiveInternal(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return (P) getKeyManagerInternal(str, cls).getPrimitive(byteString);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, byte[] bArr) throws GeneralSecurityException {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr));
    }

    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr), cls);
    }

    @Deprecated
    public static <P> P getPrimitive(KeyData keyData) throws GeneralSecurityException {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue());
    }

    public static <P> P getPrimitive(KeyData keyData, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue(), cls);
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, Class<P> primitiveClass) throws GeneralSecurityException {
        return getPrimitives(keysetHandle, null, primitiveClass);
    }

    public static <P> PrimitiveSet<P> getPrimitives(KeysetHandle keysetHandle, final KeyManager<P> customManager, Class<P> primitiveClass) throws GeneralSecurityException {
        return getPrimitivesInternal(keysetHandle, customManager, (Class) checkNotNull(primitiveClass));
    }

    private static <P> PrimitiveSet<P> getPrimitivesInternal(KeysetHandle keysetHandle, KeyManager<P> keyManager, Class<P> cls) throws GeneralSecurityException {
        P p;
        Util.validateKeyset(keysetHandle.getKeyset());
        PrimitiveSet<P> newPrimitiveSet = PrimitiveSet.newPrimitiveSet(cls);
        for (Keyset.Key key : keysetHandle.getKeyset().getKeyList()) {
            if (key.getStatus() == KeyStatusType.ENABLED) {
                if (keyManager != null && keyManager.doesSupport(key.getKeyData().getTypeUrl())) {
                    p = keyManager.getPrimitive(key.getKeyData().getValue());
                } else {
                    p = (P) getPrimitiveInternal(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), cls);
                }
                PrimitiveSet.Entry<P> addPrimitive = newPrimitiveSet.addPrimitive(p, key);
                if (key.getKeyId() == keysetHandle.getKeyset().getPrimaryKeyId()) {
                    newPrimitiveSet.setPrimary(addPrimitive);
                }
            }
        }
        return newPrimitiveSet;
    }

    public static <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> cls) throws GeneralSecurityException {
        PrimitiveWrapper<?, ?> primitiveWrapper = primitiveWrapperMap.get(cls);
        if (primitiveWrapper == null) {
            throw new GeneralSecurityException("No wrapper found for " + primitiveSet.getPrimitiveClass().getName());
        }
        if (!primitiveWrapper.getInputPrimitiveClass().equals(primitiveSet.getPrimitiveClass())) {
            throw new GeneralSecurityException("Wrong input primitive class, expected " + primitiveWrapper.getInputPrimitiveClass() + ", got " + primitiveSet.getPrimitiveClass());
        }
        return (P) primitiveWrapper.wrap(primitiveSet);
    }

    public static <P> P wrap(PrimitiveSet<P> primitiveSet) throws GeneralSecurityException {
        return (P) wrap(primitiveSet, primitiveSet.getPrimitiveClass());
    }

    public static Class<?> getInputPrimitive(Class<?> wrappedPrimitive) {
        PrimitiveWrapper<?, ?> primitiveWrapper = primitiveWrapperMap.get(wrappedPrimitive);
        if (primitiveWrapper == null) {
            return null;
        }
        return primitiveWrapper.getInputPrimitiveClass();
    }

    static MessageLite parseKeyData(KeyData keyData) throws GeneralSecurityException, InvalidProtocolBufferException {
        return getKeyManagerContainerOrThrow(keyData.getTypeUrl()).parseKey(keyData.getValue());
    }

    private Registry() {
    }
}

// ===== FILE: com/google/crypto/tink/StreamingAead.java =====
package com.google.crypto.tink;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface StreamingAead {
    ReadableByteChannel newDecryptingChannel(ReadableByteChannel ciphertextSource, byte[] associatedData) throws GeneralSecurityException, IOException;

    InputStream newDecryptingStream(InputStream ciphertextSource, byte[] associatedData) throws GeneralSecurityException, IOException;

    WritableByteChannel newEncryptingChannel(WritableByteChannel ciphertextDestination, byte[] associatedData) throws GeneralSecurityException, IOException;

    OutputStream newEncryptingStream(OutputStream ciphertextDestination, byte[] associatedData) throws GeneralSecurityException, IOException;

    SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel ciphertextSource, byte[] associatedData) throws GeneralSecurityException, IOException;
}

// ===== FILE: com/google/crypto/tink/Util.java =====
package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: classes.dex */
class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    Util() {
    }

    public static KeysetInfo getKeysetInfo(Keyset keyset) {
        KeysetInfo.Builder primaryKeyId = KeysetInfo.newBuilder().setPrimaryKeyId(keyset.getPrimaryKeyId());
        Iterator<Keyset.Key> it = keyset.getKeyList().iterator();
        while (it.hasNext()) {
            primaryKeyId.addKeyInfo(getKeyInfo(it.next()));
        }
        return primaryKeyId.build();
    }

    public static KeysetInfo.KeyInfo getKeyInfo(Keyset.Key key) {
        return KeysetInfo.KeyInfo.newBuilder().setTypeUrl(key.getKeyData().getTypeUrl()).setStatus(key.getStatus()).setOutputPrefixType(key.getOutputPrefixType()).setKeyId(key.getKeyId()).build();
    }

    public static void validateKey(Keyset.Key key) throws GeneralSecurityException {
        if (!key.hasKeyData()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(key.getKeyId())));
        }
        if (key.getOutputPrefixType() == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(key.getKeyId())));
        }
        if (key.getStatus() == KeyStatusType.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(key.getKeyId())));
        }
    }

    public static void validateKeyset(Keyset keyset) throws GeneralSecurityException {
        int primaryKeyId = keyset.getPrimaryKeyId();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getStatus() == KeyStatusType.ENABLED) {
                validateKey(key);
                if (key.getKeyId() == primaryKeyId) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (key.getKeyData().getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }

    public static byte[] readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}

// ===== FILE: com/google/crypto/tink/Version.java =====
package com.google.crypto.tink;

/* loaded from: classes.dex */
public final class Version {
    public static final String TINK_VERSION = "1.5.0";
}
