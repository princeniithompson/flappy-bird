// Package bundle: com.unity3d.services.ads.gmascar.adapters (2 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory
// ============================================================
package com.unity3d.services.ads.gmascar.adapters;

public class ScarAdapterFactory {
    public ScarAdapterFactory() {
        new Object();
        return;
    }

    private void reportAdapterFailure(ScarAdapterVersion p0, IAdsErrorHandler p1) {
        p0.name();
        String.format("SCAR version %s is not supported.", 1);
        GMAAdsError.AdapterCreationError(String.format(..));
        p1.handleError(GMAAdsError.AdapterCreationError(..));
        DeviceLog.debug(String.format(..));
        return;
    }

    public IScarAdapter createScarAdapter(ScarAdapterVersion p0, IAdsErrorHandler p1) {
        p0.ordinal();
        if (if-eq(ScarAdapterFactory$1.$SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion, 1)) goto L_2a;
        if (if-eq(ScarAdapterFactory$1.$SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion, 2)) goto L_20;
        if (if-eq(ScarAdapterFactory$1.$SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion, 3)) goto L_16;
        ScarAdapterFactory.reportAdapterFailure(p0, p1);
      L_16:
        SdkProperties.getVersionName();
        new ScarAdapter(p1, SdkProperties.getVersionName(..));
      L_20:
        SdkProperties.getVersionName();
        new ScarAdapter(p1, SdkProperties.getVersionName(..));
      L_2a:
        new ScarAdapter(p1);
      L_2f:
        return new ScarAdapter(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory$1
// ============================================================
package com.unity3d.services.ads.gmascar.adapters;

class ScarAdapterFactory$1 {
    static final int[] $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion;

    static <clinit>() {
        ScarAdapterVersion.values();
        $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion = ScarAdapterVersion.values(..);
        ScarAdapterVersion.V20.ordinal();
        ScarAdapterVersion.V21.ordinal();
        ScarAdapterVersion.V23.ordinal();
        ScarAdapterVersion.NA.ordinal();
        return;
    }

}

