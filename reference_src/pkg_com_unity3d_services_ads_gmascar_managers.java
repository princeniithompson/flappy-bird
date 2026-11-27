// Package bundle: com.unity3d.services.ads.gmascar.managers (9 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

public abstract class BiddingBaseManager {
    private final boolean _isAsyncTokenCall;
    private final boolean _isBannerEnabled;
    private final ScarRequestHandler _scarRequestHandler;
    protected final AtomicBoolean isUploadPermitted;
    private final AtomicReference signals;
    private final String tokenIdentifier;
    private final IUnityAdsTokenListener unityAdsTokenListener;

    public BiddingBaseManager(boolean p0, IUnityAdsTokenListener p1) {
        new ScarRequestHandler();
        new BiddingBaseManager(p0, p1, new ScarRequestHandler(..));
        return;
    }

    public BiddingBaseManager(boolean p0, IUnityAdsTokenListener p1, ScarRequestHandler p2) {
        new Object();
        new AtomicBoolean(0);
        isUploadPermitted = new AtomicBoolean(..);
        new AtomicReference();
        signals = new AtomicReference(..);
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        tokenIdentifier = UUID.toString(..);
        _isBannerEnabled = p0;
        unityAdsTokenListener = p1;
        if (if-eqz(p1)) goto L_23;
      L_23:
        _isAsyncTokenCall = 1;
        _scarRequestHandler = p2;
        return;
    }

    private void attemptUpload() {
        signals.get();
        if (if-eqz(AtomicReference.get(..))) goto L_16;
        isUploadPermitted.compareAndSet(1, 0);
        if (if-eqz(AtomicBoolean.compareAndSet(..))) goto L_16;
        BiddingBaseManager.uploadSignals();
      L_16:
        return;
        throw AtomicBoolean.compareAndSet(..);
    }

    public void fetchSignals() {
        BiddingBaseManager.getMetricSender();
        ScarMetric.hbSignalsFetchStart(_isAsyncTokenCall);
        SDKMetricsSender.sendMetric(ScarMetric.hbSignalsFetchStart(..));
        new BiddingBaseManager$$ExternalSyntheticLambda0(this);
        new Thread(new BiddingBaseManager$$ExternalSyntheticLambda0(..));
        new Thread(..).start();
        return;
    }

    public String getFormattedToken(String p0) {
        if (if-eqz(p0)) goto L_26;
        p0.isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_9;
      L_9:
        BiddingBaseManager.getTokenIdentifier();
        if (if-eqz(BiddingBaseManager.getTokenIdentifier(..))) goto L_25;
        String.isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_16;
      L_16:
        String.format("%s:%s", 2);
      L_25:
        return String.format(..);
      L_26:
        return 0;
    }

    public SDKMetricsSender getMetricSender() {
        Utilities.getService(SDKMetricsSender.class);
        return Utilities.getService(..);
    }

    public String getTokenIdentifier() {
        return tokenIdentifier;
    }

    void lambda$fetchSignals$1$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager() {
        GMA.getInstance();
        new BiddingBaseManager$1(this);
        GMA.getInstance(..).getSCARBiddingSignals(_isBannerEnabled, new BiddingBaseManager$1(..));
        return;
    }

    void lambda$onUnityAdsTokenReady$0$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager(String p0) {
        unityAdsTokenListener.onUnityAdsTokenReady(p0);
        return;
    }

    void lambda$uploadSignals$2$com-unity3d-services-ads-gmascar-managers-BiddingBaseManager(BiddingSignals p0) {
        new ConfigurationReader();
        new ConfigurationReader(..).getCurrentConfiguration();
        Configuration.getScarBiddingUrl();
        _scarRequestHandler.makeUploadRequest(tokenIdentifier, p0, Configuration.getScarBiddingUrl(..));
        BiddingBaseManager.getMetricSender();
        ScarMetric.hbSignalsUploadSuccess(_isAsyncTokenCall);
        SDKMetricsSender.sendMetric(ScarMetric.hbSignalsUploadSuccess(..));
        BiddingBaseManager.getMetricSender();
        Exception.getLocalizedMessage();
        ScarMetric.hbSignalsUploadFailure(_isAsyncTokenCall, Exception.getLocalizedMessage(..));
        SDKMetricsSender.sendMetric(ScarMetric.hbSignalsUploadFailure(..));
      L_34:
        return;
    }

    public void onSignalsReady(BiddingSignals p0) {
        signals.set(p0);
        BiddingBaseManager.attemptUpload();
        return;
    }

    public final void onUnityAdsTokenReady(String p0) {
        if (if-eqz(unityAdsTokenListener)) goto L_c;
        new BiddingBaseManager$$ExternalSyntheticLambda1(this, p0);
        Utilities.wrapCustomerListener(new BiddingBaseManager$$ExternalSyntheticLambda1(..));
      L_c:
        return;
    }

    public void permitSignalsUpload() {
        isUploadPermitted.set(1);
        BiddingBaseManager.attemptUpload();
        return;
    }

    public void permitUpload() {
        isUploadPermitted.set(1);
        return;
    }

    public void sendFetchResult(String p0) {
        if (if-eq(p0, "")) goto L_12;
        BiddingBaseManager.getMetricSender();
        ScarMetric.hbSignalsFetchFailure(_isAsyncTokenCall, p0);
        SDKMetricsSender.sendMetric(ScarMetric.hbSignalsFetchFailure(..));
      L_12:
        BiddingBaseManager.getMetricSender();
        ScarMetric.hbSignalsFetchSuccess(_isAsyncTokenCall);
        SDKMetricsSender.sendMetric(ScarMetric.hbSignalsFetchSuccess(..));
      L_1f:
        return;
    }

    public abstract void start() {
        // native or abstract
    }

    public void uploadSignals() {
        BiddingBaseManager.getMetricSender();
        ScarMetric.hbSignalsUploadStart(_isAsyncTokenCall);
        SDKMetricsSender.sendMetric(ScarMetric.hbSignalsUploadStart(..));
        signals.get();
        if (if-eqz(AtomicReference.get(..))) goto L_2c;
        AtomicReference.get(..).isEmpty();
        if (if-eqz(BiddingSignals.isEmpty(..))) goto L_1e;
      L_1e:
        new BiddingBaseManager$$ExternalSyntheticLambda2(this, AtomicReference.get(..));
        new Thread(new BiddingBaseManager$$ExternalSyntheticLambda2(..));
        new Thread(..).start();
        return;
      L_2c:
        BiddingBaseManager.getMetricSender();
        ScarMetric.hbSignalsUploadFailure(_isAsyncTokenCall, "null or empty signals");
        SDKMetricsSender.sendMetric(ScarMetric.hbSignalsUploadFailure(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.BiddingDisabledManager
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

public class BiddingDisabledManager extends BiddingBaseManager {
    public BiddingDisabledManager(IUnityAdsTokenListener p0) {
        new BiddingBaseManager(0, p0);
        return;
    }

    public String getTokenIdentifier() {
        return 0;
    }

    public void start() {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.BiddingEagerManager
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

public class BiddingEagerManager extends BiddingBaseManager {
    public BiddingEagerManager(boolean p0, IUnityAdsTokenListener p1) {
        new BiddingBaseManager(p0, p1);
        return;
    }

    public void start() {
        BiddingEagerManager.permitSignalsUpload();
        BiddingEagerManager.fetchSignals();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

public class BiddingManagerFactory {
    private static BiddingManagerFactory instance;

    private BiddingManagerFactory() {
        new Object();
        return;
    }

    private BiddingBaseManager getExperiment(IUnityAdsTokenListener p0, IExperiments p1) {
        if (if-eqz(p1)) goto L_2c;
        p1.getScarBiddingManager();
        if (if-nez(IExperiments.getScarBiddingManager(..))) goto L_9;
      L_9:
        p1.getScarBiddingManager();
        ScarBiddingManagerType.fromName(IExperiments.getScarBiddingManager(..));
        ScarBiddingManagerType.fromName(..).ordinal();
        if (if-eq(ScarBiddingManagerType.ordinal(..), 1)) goto L_22;
        new BiddingDisabledManager(p0);
        return new BiddingDisabledManager(..);
      L_22:
        new BiddingDisabledManager(..).isScarBannerHbEnabled();
        new BiddingEagerManager(IExperiments.isScarBannerHbEnabled(..), p0);
        return new BiddingEagerManager(..);
      L_2c:
        new BiddingDisabledManager(p0);
        return new BiddingDisabledManager(..);
    }

    public static BiddingManagerFactory getInstance() {
        if (if-nez(BiddingManagerFactory.instance)) goto L_b;
        new BiddingManagerFactory();
        instance = new BiddingManagerFactory(..);
      L_b:
        return BiddingManagerFactory.instance;
    }

    public BiddingBaseManager createManager(IUnityAdsTokenListener p0, IExperiments p1) {
        GMA.getInstance();
        GMA.getInstance(..).hasSCARBiddingSupport();
        if (if-eqz(GMA.hasSCARBiddingSupport(..))) goto L_f;
        BiddingManagerFactory.getExperiment(p0, p1);
        return BiddingManagerFactory.getExperiment(..);
      L_f:
        new BiddingDisabledManager(BiddingManagerFactory.getExperiment(..));
        return new BiddingDisabledManager(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.IBiddingManager
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

public abstract class IBiddingManager {
    public abstract String getFormattedToken(String p0) {
        // native or abstract
    }

    public abstract String getTokenIdentifier() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

public final class ScarBiddingManagerType extends Enum {
    private static final ScarBiddingManagerType[] $VALUES;
    public static final ScarBiddingManagerType DISABLED;
    public static final ScarBiddingManagerType EAGER;
    private final String name;

    private static ScarBiddingManagerType[] $values() {
        return 2;
    }

    static <clinit>() {
        new ScarBiddingManagerType("DISABLED", 0, "dis");
        DISABLED = new ScarBiddingManagerType(..);
        new ScarBiddingManagerType("EAGER", 1, "eag");
        EAGER = new ScarBiddingManagerType(..);
        ScarBiddingManagerType.$values();
        $VALUES = ScarBiddingManagerType.$values(..);
        return;
    }

    private ScarBiddingManagerType(String p0, int p1, String p2) {
        new Enum(p0, p1);
        name = p2;
        return;
    }

    public static ScarBiddingManagerType fromName(String p0) {
        p0.hashCode();
        if (if-eq(String.hashCode(..), 99470)) goto L_19;
        if (if-eq(String.hashCode(..), 100171)) goto L_f;
      L_f:
        p0.equals("eag");
        if (if-eqz(String.equals(..))) goto L_23;
      L_19:
        0.equals("dis");
        if (if-eqz(String.equals(..))) goto L_23;
      L_23:
      L_24:
        if (if-eqz(-1)) goto L_29;
        return ScarBiddingManagerType.DISABLED;
      L_29:
        return ScarBiddingManagerType.EAGER;
    }

    public static ScarBiddingManagerType valueOf(String p0) {
        Enum.valueOf(ScarBiddingManagerType.class, p0);
        return Enum.valueOf(..);
    }

    public static ScarBiddingManagerType[] values() {
        ScarBiddingManagerType.$VALUES.clone();
        return ScarBiddingManagerType[].clone(..);
    }

    public String getName() {
        return name;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.BiddingBaseManager$1
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

class BiddingBaseManager$1 {
    final BiddingBaseManager this$0;

    BiddingBaseManager$1(BiddingBaseManager p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onSignalsFailure(String p0) {
        this$0.sendFetchResult(p0);
        return;
    }

    public void onSignalsReady(BiddingSignals p0) {
        this$0.onSignalsReady(p0);
        this$0.sendFetchResult("");
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory$1
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

class BiddingManagerFactory$1 {
    static final int[] $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType;

    static <clinit>() {
        ScarBiddingManagerType.values();
        $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType = ScarBiddingManagerType.values(..);
        ScarBiddingManagerType.EAGER.ordinal();
        ScarBiddingManagerType.DISABLED.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.managers.ScarBiddingManagerType$Constants
// ============================================================
package com.unity3d.services.ads.gmascar.managers;

class ScarBiddingManagerType$Constants {
    private static final String DIS = "dis";
    private static final String EAG = "eag";

    private ScarBiddingManagerType$Constants() {
        new Object();
        return;
    }

}

