// Package bundle: com.unity3d.services.core.device.reader.pii (6 classes)

// ============================================================
// CLASS: com.unity3d.services.core.device.reader.pii.NonBehavioralFlag
// ============================================================
package com.unity3d.services.core.device.reader.pii;

public final class NonBehavioralFlag extends Enum {
    private static final NonBehavioralFlag[] $VALUES;
    public static final NonBehavioralFlag$Companion Companion;
    public static final NonBehavioralFlag FALSE;
    public static final NonBehavioralFlag TRUE;
    public static final NonBehavioralFlag UNKNOWN;

    private static final NonBehavioralFlag[] $values() {
        return 3;
    }

    static <clinit>() {
        new NonBehavioralFlag("UNKNOWN", 0);
        UNKNOWN = new NonBehavioralFlag(..);
        new NonBehavioralFlag("TRUE", 1);
        TRUE = new NonBehavioralFlag(..);
        new NonBehavioralFlag("FALSE", 2);
        FALSE = new NonBehavioralFlag(..);
        NonBehavioralFlag.$values();
        $VALUES = NonBehavioralFlag.$values(..);
        new NonBehavioralFlag$Companion(0);
        Companion = new NonBehavioralFlag$Companion(..);
        return;
    }

    private NonBehavioralFlag(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static NonBehavioralFlag valueOf(String p0) {
        Enum.valueOf(NonBehavioralFlag.class, p0);
        return Enum.valueOf(..);
    }

    public static NonBehavioralFlag[] values() {
        NonBehavioralFlag.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.pii.NonBehavioralFlagReader
// ============================================================
package com.unity3d.services.core.device.reader.pii;

public class NonBehavioralFlagReader {
    private final IJsonStorageReader jsonStorageReader;

    public NonBehavioralFlagReader(IJsonStorageReader p0) {
        new Object();
        jsonStorageReader = p0;
        return;
    }

    public NonBehavioralFlag getUserNonBehavioralFlag() {
        jsonStorageReader.get("user.nonbehavioral.value");
        if (if-nez(IJsonStorageReader.get(..))) goto L_12;
        jsonStorageReader.get("user.nonBehavioral.value");
      L_12:
        String.valueOf(IJsonStorageReader.get(..));
        NonBehavioralFlag.Companion.fromString(String.valueOf(..));
        return NonBehavioralFlag$Companion.fromString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.pii.PiiDataProvider
// ============================================================
package com.unity3d.services.core.device.reader.pii;

public class PiiDataProvider {
    public PiiDataProvider() {
        new Object();
        return;
    }

    public String getAdvertisingTrackingId() {
        Device.getAdvertisingTrackingId();
        return Device.getAdvertisingTrackingId(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.pii.PiiPrivacyMode
// ============================================================
package com.unity3d.services.core.device.reader.pii;

public final class PiiPrivacyMode extends Enum {
    private static final PiiPrivacyMode[] $VALUES;
    public static final PiiPrivacyMode APP;
    public static final PiiPrivacyMode MIXED;
    public static final PiiPrivacyMode NONE;
    public static final PiiPrivacyMode NULL;
    public static final PiiPrivacyMode UNDEFINED;

    private static PiiPrivacyMode[] $values() {
        return 5;
    }

    static <clinit>() {
        new PiiPrivacyMode("APP", 0);
        APP = new PiiPrivacyMode(..);
        new PiiPrivacyMode("NONE", 1);
        NONE = new PiiPrivacyMode(..);
        new PiiPrivacyMode("MIXED", 2);
        MIXED = new PiiPrivacyMode(..);
        new PiiPrivacyMode("UNDEFINED", 3);
        UNDEFINED = new PiiPrivacyMode(..);
        new PiiPrivacyMode("NULL", 4);
        NULL = new PiiPrivacyMode(..);
        PiiPrivacyMode.$values();
        $VALUES = PiiPrivacyMode.$values(..);
        return;
    }

    private PiiPrivacyMode(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static PiiPrivacyMode getPiiPrivacyMode(String p0) {
        if (if-nez(p0)) goto L_5;
        return PiiPrivacyMode.NULL;
      L_5:
        PiiPrivacyMode.NULL.toUpperCase(Locale.ROOT);
        PiiPrivacyMode.valueOf(String.toUpperCase(..));
        return PiiPrivacyMode.valueOf(..);
    }

    public static PiiPrivacyMode valueOf(String p0) {
        Enum.valueOf(PiiPrivacyMode.class, p0);
        return Enum.valueOf(..);
    }

    public static PiiPrivacyMode[] values() {
        PiiPrivacyMode.$VALUES.clone();
        return PiiPrivacyMode[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.pii.PiiTrackingStatusReader
// ============================================================
package com.unity3d.services.core.device.reader.pii;

public class PiiTrackingStatusReader {
    private final IJsonStorageReader _jsonStorageReader;
    private final NonBehavioralFlagReader _nonBehavioralFlagReader;

    public PiiTrackingStatusReader(IJsonStorageReader p0) {
        new Object();
        _jsonStorageReader = p0;
        new NonBehavioralFlagReader(p0);
        _nonBehavioralFlagReader = new NonBehavioralFlagReader(..);
        return;
    }

    private PiiPrivacyMode getPrivacyMode(String p0) {
        if (if-eqz(_jsonStorageReader)) goto L_f;
        _jsonStorageReader.get(p0);
        if (if-eqz(_jsonStorageReader)) goto L_f;
      L_f:
      L_10:
        PiiPrivacyMode.getPiiPrivacyMode(0);
        return PiiPrivacyMode.getPiiPrivacyMode(..);
    }

    private PiiPrivacyMode getSpmPrivacyMode() {
        PiiTrackingStatusReader.getPrivacyMode("privacy.spm.value");
        return PiiTrackingStatusReader.getPrivacyMode(..);
    }

    private PiiPrivacyMode getUserPrivacyMode() {
        PiiTrackingStatusReader.getPrivacyMode("privacy.mode.value");
        return PiiTrackingStatusReader.getPrivacyMode(..);
    }

    public PiiPrivacyMode getPrivacyMode() {
        PiiTrackingStatusReader.getUserPrivacyMode();
        if (if-ne(PiiTrackingStatusReader.getUserPrivacyMode(..), PiiPrivacyMode.NULL)) goto L_13;
        PiiTrackingStatusReader.getSpmPrivacyMode();
        if (if-ne(PiiTrackingStatusReader.getSpmPrivacyMode(..), PiiPrivacyMode.NULL)) goto L_13;
        return PiiPrivacyMode.NULL;
      L_13:
        PiiTrackingStatusReader.getUserPrivacyMode();
        if (if-eq(PiiTrackingStatusReader.getUserPrivacyMode(..), PiiPrivacyMode.APP)) goto L_4f;
        PiiTrackingStatusReader.getSpmPrivacyMode();
        if (if-ne(PiiTrackingStatusReader.getSpmPrivacyMode(..), PiiPrivacyMode.APP)) goto L_24;
      L_24:
        PiiTrackingStatusReader.getUserPrivacyMode();
        if (if-eq(PiiTrackingStatusReader.getUserPrivacyMode(..), PiiPrivacyMode.MIXED)) goto L_4c;
        PiiTrackingStatusReader.getSpmPrivacyMode();
        if (if-ne(PiiTrackingStatusReader.getSpmPrivacyMode(..), PiiPrivacyMode.MIXED)) goto L_35;
      L_35:
        PiiTrackingStatusReader.getUserPrivacyMode();
        if (if-eq(PiiTrackingStatusReader.getUserPrivacyMode(..), PiiPrivacyMode.NONE)) goto L_49;
        PiiTrackingStatusReader.getSpmPrivacyMode();
        if (if-ne(PiiTrackingStatusReader.getSpmPrivacyMode(..), PiiPrivacyMode.NONE)) goto L_46;
      L_46:
        return PiiPrivacyMode.UNDEFINED;
      L_49:
        return PiiPrivacyMode.NONE;
      L_4c:
        return PiiPrivacyMode.MIXED;
      L_4f:
        return PiiPrivacyMode.APP;
    }

    public boolean getUserNonBehavioralFlag() {
        _nonBehavioralFlagReader.getUserNonBehavioralFlag();
        if (if-ne(NonBehavioralFlagReader.getUserNonBehavioralFlag(..), NonBehavioralFlag.TRUE)) goto L_c;
      L_c:
      L_d:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.pii.NonBehavioralFlag$Companion
// ============================================================
package com.unity3d.services.core.device.reader.pii;

public final class NonBehavioralFlag$Companion {
    private NonBehavioralFlag$Companion() {
        new Object();
        return;
    }

    public NonBehavioralFlag$Companion(DefaultConstructorMarker p0) {
        new NonBehavioralFlag$Companion();
        return;
    }

    public final NonBehavioralFlag fromString(String p0) {
        p0.toUpperCase(Locale.ROOT);
        NonBehavioralFlag.valueOf(String.toUpperCase(..));
        Result.constructor-impl(NonBehavioralFlag.valueOf(..));
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_29:
        Result.isFailure-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_32;
      L_32:
        return NonBehavioralFlag.UNKNOWN;
    }

}

