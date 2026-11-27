
// ===== FILE: com/unity3d/services/core/device/reader/pii/NonBehavioralFlag.java =====
package com.unity3d.services.core.device.reader.pii;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NonBehavioralFlag.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, m444d2 = {"Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlag;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "TRUE", "FALSE", "Companion", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public enum NonBehavioralFlag {
    UNKNOWN,
    TRUE,
    FALSE;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: NonBehavioralFlag.kt */
    @Metadata(m443d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m444d2 = {"Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlag$Companion;", "", "()V", "fromString", "Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlag;", "value", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NonBehavioralFlag fromString(String value) {
            Object m745constructorimpl;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                String upperCase = value.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                m745constructorimpl = Result.m745constructorimpl(NonBehavioralFlag.valueOf(upperCase));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
            }
            NonBehavioralFlag nonBehavioralFlag = NonBehavioralFlag.UNKNOWN;
            if (Result.m751isFailureimpl(m745constructorimpl)) {
                m745constructorimpl = nonBehavioralFlag;
            }
            return (NonBehavioralFlag) m745constructorimpl;
        }
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/pii/NonBehavioralFlagReader.java =====
package com.unity3d.services.core.device.reader.pii;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.misc.IJsonStorageReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NonBehavioralFlagReader.kt */
@Metadata(m443d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m444d2 = {"Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlagReader;", "", "jsonStorageReader", "Lcom/unity3d/services/core/misc/IJsonStorageReader;", "(Lcom/unity3d/services/core/misc/IJsonStorageReader;)V", "getUserNonBehavioralFlag", "Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlag;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public class NonBehavioralFlagReader {
    private final IJsonStorageReader jsonStorageReader;

    public NonBehavioralFlagReader(IJsonStorageReader jsonStorageReader) {
        Intrinsics.checkNotNullParameter(jsonStorageReader, "jsonStorageReader");
        this.jsonStorageReader = jsonStorageReader;
    }

    public NonBehavioralFlag getUserNonBehavioralFlag() {
        Object obj = this.jsonStorageReader.get(JsonStorageKeyNames.USER_NON_BEHAVIORAL_VALUE_KEY);
        if (obj == null) {
            obj = this.jsonStorageReader.get(JsonStorageKeyNames.USER_NON_BEHAVIORAL_VALUE_ALT_KEY);
        }
        return NonBehavioralFlag.INSTANCE.fromString(String.valueOf(obj));
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/pii/PiiDataProvider.java =====
package com.unity3d.services.core.device.reader.pii;

import com.unity3d.services.core.device.Device;

/* loaded from: classes.dex */
public class PiiDataProvider {
    public String getAdvertisingTrackingId() {
        return Device.getAdvertisingTrackingId();
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/pii/PiiPrivacyMode.java =====
package com.unity3d.services.core.device.reader.pii;

import java.util.Locale;

/* loaded from: classes.dex */
public enum PiiPrivacyMode {
    APP,
    NONE,
    MIXED,
    UNDEFINED,
    NULL;

    public static PiiPrivacyMode getPiiPrivacyMode(String str) {
        if (str == null) {
            return NULL;
        }
        PiiPrivacyMode piiPrivacyMode = UNDEFINED;
        try {
            return valueOf(str.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException unused) {
            return piiPrivacyMode;
        }
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/pii/PiiTrackingStatusReader.java =====
package com.unity3d.services.core.device.reader.pii;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.misc.IJsonStorageReader;

/* loaded from: classes.dex */
public class PiiTrackingStatusReader {
    private final IJsonStorageReader _jsonStorageReader;
    private final NonBehavioralFlagReader _nonBehavioralFlagReader;

    public PiiTrackingStatusReader(IJsonStorageReader iJsonStorageReader) {
        this._jsonStorageReader = iJsonStorageReader;
        this._nonBehavioralFlagReader = new NonBehavioralFlagReader(iJsonStorageReader);
    }

    public PiiPrivacyMode getPrivacyMode() {
        if (getUserPrivacyMode() == PiiPrivacyMode.NULL && getSpmPrivacyMode() == PiiPrivacyMode.NULL) {
            return PiiPrivacyMode.NULL;
        }
        if (getUserPrivacyMode() == PiiPrivacyMode.APP || getSpmPrivacyMode() == PiiPrivacyMode.APP) {
            return PiiPrivacyMode.APP;
        }
        if (getUserPrivacyMode() == PiiPrivacyMode.MIXED || getSpmPrivacyMode() == PiiPrivacyMode.MIXED) {
            return PiiPrivacyMode.MIXED;
        }
        if (getUserPrivacyMode() == PiiPrivacyMode.NONE || getSpmPrivacyMode() == PiiPrivacyMode.NONE) {
            return PiiPrivacyMode.NONE;
        }
        return PiiPrivacyMode.UNDEFINED;
    }

    public boolean getUserNonBehavioralFlag() {
        return this._nonBehavioralFlagReader.getUserNonBehavioralFlag() == NonBehavioralFlag.TRUE;
    }

    private PiiPrivacyMode getUserPrivacyMode() {
        return getPrivacyMode(JsonStorageKeyNames.PRIVACY_MODE_KEY);
    }

    private PiiPrivacyMode getSpmPrivacyMode() {
        return getPrivacyMode(JsonStorageKeyNames.PRIVACY_SPM_KEY);
    }

    private PiiPrivacyMode getPrivacyMode(String str) {
        String str2;
        IJsonStorageReader iJsonStorageReader = this._jsonStorageReader;
        if (iJsonStorageReader != null) {
            Object obj = iJsonStorageReader.get(str);
            if (obj instanceof String) {
                str2 = (String) obj;
                return PiiPrivacyMode.getPiiPrivacyMode(str2);
            }
        }
        str2 = null;
        return PiiPrivacyMode.getPiiPrivacyMode(str2);
    }
}
