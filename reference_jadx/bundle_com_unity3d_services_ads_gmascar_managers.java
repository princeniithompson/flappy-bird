
// ===== FILE: com/unity3d/services/ads/gmascar/managers/BiddingBaseManager.java =====
package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.ads.gmascar.utils.ScarRequestHandler;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.ScarMetric;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class BiddingBaseManager implements IBiddingManager {
    private final boolean _isAsyncTokenCall;
    private final boolean _isBannerEnabled;
    private final ScarRequestHandler _scarRequestHandler;
    protected final AtomicBoolean isUploadPermitted;
    private final AtomicReference<BiddingSignals> signals;
    private final String tokenIdentifier;
    private final IUnityAdsTokenListener unityAdsTokenListener;

    public abstract void start();

    public BiddingBaseManager(boolean z, IUnityAdsTokenListener iUnityAdsTokenListener) {
        this(z, iUnityAdsTokenListener, new ScarRequestHandler());
    }

    public BiddingBaseManager(boolean z, IUnityAdsTokenListener iUnityAdsTokenListener, ScarRequestHandler scarRequestHandler) {
        this.isUploadPermitted = new AtomicBoolean(false);
        this.signals = new AtomicReference<>();
        this.tokenIdentifier = UUID.randomUUID().toString();
        this._isBannerEnabled = z;
        this.unityAdsTokenListener = iUnityAdsTokenListener;
        this._isAsyncTokenCall = iUnityAdsTokenListener != null;
        this._scarRequestHandler = scarRequestHandler;
    }

    @Override // com.unity3d.services.ads.gmascar.managers.IBiddingManager
    public String getTokenIdentifier() {
        return this.tokenIdentifier;
    }

    @Override // com.unity3d.services.ads.gmascar.managers.IBiddingManager
    public String getFormattedToken(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String tokenIdentifier = getTokenIdentifier();
        return (tokenIdentifier == null || tokenIdentifier.isEmpty()) ? str : String.format(ScarConstants.TOKEN_WITH_SCAR_FORMAT, tokenIdentifier, str);
    }

    @Override // com.unity3d.ads.IUnityAdsTokenListener
    public final void onUnityAdsTokenReady(final String str) {
        if (this.unityAdsTokenListener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.gmascar.managers.BiddingBaseManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BiddingBaseManager.this.m433x87509455(str);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsTokenReady$0$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager */
    /* synthetic */ void m433x87509455(String str) {
        this.unityAdsTokenListener.onUnityAdsTokenReady(str);
    }

    public void permitUpload() {
        this.isUploadPermitted.set(true);
    }

    public void permitSignalsUpload() {
        this.isUploadPermitted.set(true);
        attemptUpload();
    }

    public void fetchSignals() {
        getMetricSender().sendMetric(ScarMetric.hbSignalsFetchStart(this._isAsyncTokenCall));
        new Thread(new Runnable() { // from class: com.unity3d.services.ads.gmascar.managers.BiddingBaseManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiddingBaseManager.this.m432xbd500567();
            }
        }).start();
    }

    /* renamed from: lambda$fetchSignals$1$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager */
    /* synthetic */ void m432xbd500567() {
        GMA.getInstance().getSCARBiddingSignals(this._isBannerEnabled, new IBiddingSignalsListener() { // from class: com.unity3d.services.ads.gmascar.managers.BiddingBaseManager.1
            @Override // com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener
            public void onSignalsReady(BiddingSignals biddingSignals) {
                BiddingBaseManager.this.onSignalsReady(biddingSignals);
                BiddingBaseManager.this.sendFetchResult("");
            }

            @Override // com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener
            public void onSignalsFailure(String str) {
                BiddingBaseManager.this.sendFetchResult(str);
            }
        });
    }

    public void sendFetchResult(String str) {
        if (str != "") {
            getMetricSender().sendMetric(ScarMetric.hbSignalsFetchFailure(this._isAsyncTokenCall, str));
        } else {
            getMetricSender().sendMetric(ScarMetric.hbSignalsFetchSuccess(this._isAsyncTokenCall));
        }
    }

    public void onSignalsReady(BiddingSignals biddingSignals) {
        this.signals.set(biddingSignals);
        attemptUpload();
    }

    private synchronized void attemptUpload() {
        if (this.signals.get() != null && this.isUploadPermitted.compareAndSet(true, false)) {
            uploadSignals();
        }
    }

    public void uploadSignals() {
        getMetricSender().sendMetric(ScarMetric.hbSignalsUploadStart(this._isAsyncTokenCall));
        final BiddingSignals biddingSignals = this.signals.get();
        if (biddingSignals == null || biddingSignals.isEmpty()) {
            getMetricSender().sendMetric(ScarMetric.hbSignalsUploadFailure(this._isAsyncTokenCall, "null or empty signals"));
        } else {
            new Thread(new Runnable() { // from class: com.unity3d.services.ads.gmascar.managers.BiddingBaseManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BiddingBaseManager.this.m434xb93d3227(biddingSignals);
                }
            }).start();
        }
    }

    /* renamed from: lambda$uploadSignals$2$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager */
    /* synthetic */ void m434xb93d3227(BiddingSignals biddingSignals) {
        try {
            this._scarRequestHandler.makeUploadRequest(this.tokenIdentifier, biddingSignals, new ConfigurationReader().getCurrentConfiguration().getScarBiddingUrl());
            getMetricSender().sendMetric(ScarMetric.hbSignalsUploadSuccess(this._isAsyncTokenCall));
        } catch (Exception e) {
            getMetricSender().sendMetric(ScarMetric.hbSignalsUploadFailure(this._isAsyncTokenCall, e.getLocalizedMessage()));
        }
    }

    public SDKMetricsSender getMetricSender() {
        return (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/managers/BiddingDisabledManager.java =====
package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* loaded from: classes.dex */
public class BiddingDisabledManager extends BiddingBaseManager {
    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager, com.unity3d.services.ads.gmascar.managers.IBiddingManager
    public String getTokenIdentifier() {
        return null;
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void start() {
    }

    public BiddingDisabledManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(false, iUnityAdsTokenListener);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/managers/BiddingEagerManager.java =====
package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* loaded from: classes.dex */
public class BiddingEagerManager extends BiddingBaseManager {
    public BiddingEagerManager(boolean z, IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(z, iUnityAdsTokenListener);
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void start() {
        permitSignalsUpload();
        fetchSignals();
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/managers/BiddingManagerFactory.java =====
package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.core.configuration.IExperiments;

/* loaded from: classes.dex */
public class BiddingManagerFactory {
    private static BiddingManagerFactory instance;

    private BiddingManagerFactory() {
    }

    public static BiddingManagerFactory getInstance() {
        if (instance == null) {
            instance = new BiddingManagerFactory();
        }
        return instance;
    }

    public BiddingBaseManager createManager(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        if (GMA.getInstance().hasSCARBiddingSupport()) {
            return getExperiment(iUnityAdsTokenListener, iExperiments);
        }
        return new BiddingDisabledManager(iUnityAdsTokenListener);
    }

    private BiddingBaseManager getExperiment(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        if (iExperiments == null || iExperiments.getScarBiddingManager() == null) {
            return new BiddingDisabledManager(iUnityAdsTokenListener);
        }
        if (C10691.f690xea4e2c2a[ScarBiddingManagerType.fromName(iExperiments.getScarBiddingManager()).ordinal()] == 1) {
            return new BiddingEagerManager(iExperiments.isScarBannerHbEnabled(), iUnityAdsTokenListener);
        }
        return new BiddingDisabledManager(iUnityAdsTokenListener);
    }

    /* renamed from: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory$1 */
    static /* synthetic */ class C10691 {

        /* renamed from: $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType */
        static final /* synthetic */ int[] f690xea4e2c2a;

        static {
            int[] iArr = new int[ScarBiddingManagerType.values().length];
            f690xea4e2c2a = iArr;
            try {
                iArr[ScarBiddingManagerType.EAGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f690xea4e2c2a[ScarBiddingManagerType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/managers/IBiddingManager.java =====
package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* loaded from: classes.dex */
public interface IBiddingManager extends IUnityAdsTokenListener {
    String getFormattedToken(String str);

    String getTokenIdentifier();
}

// ===== FILE: com/unity3d/services/ads/gmascar/managers/ScarBiddingManagerType.java =====
package com.unity3d.services.ads.gmascar.managers;

/* loaded from: classes.dex */
public enum ScarBiddingManagerType {
    DISABLED("dis"),
    EAGER("eag");

    private final String name;

    ScarBiddingManagerType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public static ScarBiddingManagerType fromName(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 99470) {
            if (hashCode == 100171 && str.equals("eag")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("dis")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            return EAGER;
        }
        return DISABLED;
    }

    private static class Constants {
        private static final String DIS = "dis";
        private static final String EAG = "eag";

        private Constants() {
        }
    }
}
