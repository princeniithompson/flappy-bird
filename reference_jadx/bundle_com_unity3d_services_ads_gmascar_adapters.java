
// ===== FILE: com/unity3d/services/ads/gmascar/adapters/ScarAdapterFactory.java =====
package com.unity3d.services.ads.gmascar.adapters;

import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarAdapter;
import com.unity3d.scar.adapter.common.WebViewAdsError;
import com.unity3d.scar.adapter.v2000.ScarAdapter;
import com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;

/* loaded from: classes.dex */
public class ScarAdapterFactory {

    /* renamed from: com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory$1 */
    static /* synthetic */ class C10601 {

        /* renamed from: $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion */
        static final /* synthetic */ int[] f688x776ad9a7;

        static {
            int[] iArr = new int[ScarAdapterVersion.values().length];
            f688x776ad9a7 = iArr;
            try {
                iArr[ScarAdapterVersion.V20.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f688x776ad9a7[ScarAdapterVersion.V21.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f688x776ad9a7[ScarAdapterVersion.V23.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f688x776ad9a7[ScarAdapterVersion.NA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public IScarAdapter createScarAdapter(ScarAdapterVersion scarAdapterVersion, IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        int i = C10601.f688x776ad9a7[scarAdapterVersion.ordinal()];
        if (i == 1) {
            return new ScarAdapter(iAdsErrorHandler);
        }
        if (i == 2) {
            return new com.unity3d.scar.adapter.v2100.ScarAdapter(iAdsErrorHandler, SdkProperties.getVersionName());
        }
        if (i == 3) {
            return new com.unity3d.scar.adapter.v2300.ScarAdapter(iAdsErrorHandler, SdkProperties.getVersionName());
        }
        reportAdapterFailure(scarAdapterVersion, iAdsErrorHandler);
        return null;
    }

    private void reportAdapterFailure(ScarAdapterVersion scarAdapterVersion, IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        String format = String.format("SCAR version %s is not supported.", scarAdapterVersion.name());
        iAdsErrorHandler.handleError(GMAAdsError.AdapterCreationError(format));
        DeviceLog.debug(format);
    }
}
