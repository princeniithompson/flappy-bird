// Package bundle: com.unity3d.ads.core.domain.attribution (5 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.domain.attribution.AndroidAttribution
// ============================================================
package com.unity3d.ads.core.domain.attribution;

public final class AndroidAttribution {
    private final ISDKDispatchers dispatchers;
    private final Lazy measurementManager$delegate;
    private final SessionRepository sessionRepository;

    public AndroidAttribution(Context p0, ISDKDispatchers p1, SessionRepository p2) {
        new Object();
        dispatchers = p1;
        sessionRepository = p2;
        new AndroidAttribution$measurementManager$2(new Object(..), p0);
        LazyKt.lazy(new AndroidAttribution$measurementManager$2(..));
        measurementManager$delegate = LazyKt.lazy(..);
        return;
    }

    public static final MeasurementManager access$getMeasurementManager(AndroidAttribution p0, Context p1) {
        p0.getMeasurementManager(p1);
        return AndroidAttribution.getMeasurementManager(..);
    }

    private final MeasurementManager getMeasurementManager() {
        measurementManager$delegate.getValue();
        return Lazy.getValue(..);
    }

    private final MeasurementManager getMeasurementManager(Context p0) {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 33)) goto L_a;
        return 0;
      L_a:
        SdkExtensions.getExtensionVersion(1000000);
        if (if-ge(SdkExtensions.getExtensionVersion(..), 4)) goto L_15;
        return 0;
      L_15:
        p0.getSystemService(MeasurementManager.class);
        return Context.getSystemService(..);
    }

    private final Uri getUri(String p0, AdObject p1) {
        Uri.parse(p0);
        Uri.parse(..).buildUpon();
        sessionRepository.getSessionToken();
        ProtobufExtensionsKt.toBase64$default(SessionRepository.getSessionToken(..), 0, 1, 0);
        Uri.buildUpon(..).appendQueryParameter("sessionToken", ProtobufExtensionsKt.toBase64$default(..));
        p1.getTrackingToken();
        ProtobufExtensionsKt.toBase64$default(AdObject.getTrackingToken(..), 0, 1, 0);
        Uri$Builder.appendQueryParameter(..).appendQueryParameter("trackingToken", ProtobufExtensionsKt.toBase64$default(..));
        Uri$Builder.appendQueryParameter(..).build();
        return Uri$Builder.build(..);
    }

    public final Object isAvailable(Continuation p0) {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 33)) goto L_e;
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
      L_e:
        SdkExtensions.getExtensionVersion(1000000);
        if (if-ge(SdkExtensions.getExtensionVersion(..), 4)) goto L_1d;
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
      L_1d:
        AndroidAttribution.getMeasurementManager();
        if (if-nez(AndroidAttribution.getMeasurementManager(..))) goto L_28;
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
      L_28:
        AdServicesState.isAdServicesStateEnabled();
        if (if-nez(AdServicesState.isAdServicesStateEnabled(..))) goto L_33;
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
      L_33:
        IntrinsicsKt.intercepted(Boxing.boxBoolean(..));
        new SafeContinuation(IntrinsicsKt.intercepted(..));
        AndroidAttribution.getMeasurementManager();
        if (if-eqz(AndroidAttribution.getMeasurementManager(..))) goto L_5c;
        dispatchers.getDefault();
        ExecutorsKt.asExecutor(ISDKDispatchers.getDefault(..));
        new AndroidAttribution$isAvailable$2$1(new SafeContinuation(..));
        MeasurementManager.getMeasurementApiStatus(ExecutorsKt.asExecutor(..), new AndroidAttribution$isAvailable$2$1(..));
      L_5c:
      L_5d:
        if (if-nez(0)) goto L_6c;
        Boxing.boxBoolean(0);
        Result.constructor-impl(Boxing.boxBoolean(..));
        new SafeContinuation(..).resumeWith(Result.constructor-impl(..));
      L_6c:
        new SafeContinuation(..).getOrThrow();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(SafeContinuation.getOrThrow(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_79;
        DebugProbesKt.probeCoroutineSuspended(Boxing.boxBoolean(..));
      L_79:
        return SafeContinuation.getOrThrow(..);
    }

    public final Object registerClick(String p0, AdObject p1, Continuation p2) {
        AndroidAttribution.getMeasurementManager();
        if (if-nez(AndroidAttribution.getMeasurementManager(..))) goto L_c;
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
      L_c:
        p1.getAdPlayer();
        if (if-eqz(AdObject.getAdPlayer(..))) goto L_72;
        AdObject.getAdPlayer(..).getWebViewContainer();
        if (if-eqz(AdPlayer.getWebViewContainer(..))) goto L_72;
        AdPlayer.getWebViewContainer(..).getLastInputEvent();
        if (if-eqz(WebViewContainer.getLastInputEvent(..))) goto L_72;
        StateFlow.getValue();
        if (if-nez(StateFlow.getValue(..))) goto L_27;
      L_27:
        IntrinsicsKt.intercepted(p2);
        new SafeContinuation(IntrinsicsKt.intercepted(..));
        AndroidAttribution.getMeasurementManager();
        if (if-eqz(AndroidAttribution.getMeasurementManager(..))) goto L_54;
        AndroidAttribution.getUri(Boxing.boxBoolean(..), p1);
        dispatchers.getDefault();
        ExecutorsKt.asExecutor(ISDKDispatchers.getDefault(..));
        new AndroidAttribution$registerClick$2$1(new SafeContinuation(..));
        MeasurementManager.registerSource(AndroidAttribution.getUri(..), StateFlow.getValue(..), ExecutorsKt.asExecutor(..), new AndroidAttribution$registerClick$2$1(..));
      L_54:
      L_55:
        if (if-nez(0)) goto L_64;
        Boxing.boxBoolean(0);
        Result.constructor-impl(Boxing.boxBoolean(..));
        new SafeContinuation(..).resumeWith(Result.constructor-impl(..));
      L_64:
        new SafeContinuation(..).getOrThrow();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(SafeContinuation.getOrThrow(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_71;
        DebugProbesKt.probeCoroutineSuspended(p2);
      L_71:
        return SafeContinuation.getOrThrow(..);
      L_72:
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
    }

    public final Object registerView(String p0, AdObject p1, Continuation p2) {
        AndroidAttribution.getMeasurementManager();
        if (if-nez(AndroidAttribution.getMeasurementManager(..))) goto L_c;
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
      L_c:
        IntrinsicsKt.intercepted(p2);
        new SafeContinuation(IntrinsicsKt.intercepted(..));
        AndroidAttribution.getMeasurementManager();
        if (if-eqz(AndroidAttribution.getMeasurementManager(..))) goto L_39;
        AndroidAttribution.getUri(Boxing.boxBoolean(..), p1);
        dispatchers.getDefault();
        ExecutorsKt.asExecutor(ISDKDispatchers.getDefault(..));
        new AndroidAttribution$registerView$2$1(new SafeContinuation(..));
        MeasurementManager.registerSource(AndroidAttribution.getUri(..), 0, ExecutorsKt.asExecutor(..), new AndroidAttribution$registerView$2$1(..));
      L_39:
        if (if-nez(Unit.INSTANCE)) goto L_48;
        Boxing.boxBoolean(0);
        Result.constructor-impl(Boxing.boxBoolean(..));
        new SafeContinuation(..).resumeWith(Result.constructor-impl(..));
      L_48:
        new SafeContinuation(..).getOrThrow();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(SafeContinuation.getOrThrow(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_55;
        DebugProbesKt.probeCoroutineSuspended(p2);
      L_55:
        return SafeContinuation.getOrThrow(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.attribution.AndroidAttribution$isAvailable$2$1
// ============================================================
package com.unity3d.ads.core.domain.attribution;

public final class AndroidAttribution$isAvailable$2$1 {
    final Continuation $continuation;

    AndroidAttribution$isAvailable$2$1(Continuation p0) {
        $continuation = p0;
        new Object();
        return;
    }

    public void onError(Exception p0) {
        Boolean.valueOf(0);
        Result.constructor-impl(Boolean.valueOf(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onError(Throwable p0) {
        AndroidAttribution$isAvailable$2$1.onError(p0);
        return;
    }

    public void onResult(int p0) {
        if (if-ne(p0, 1)) goto L_8;
      L_8:
      L_9:
        Boolean.valueOf(0);
        Result.constructor-impl(Boolean.valueOf(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onResult(Object p0) {
        p0.intValue();
        AndroidAttribution$isAvailable$2$1.onResult(Number.intValue(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.attribution.AndroidAttribution$measurementManager$2
// ============================================================
package com.unity3d.ads.core.domain.attribution;

final class AndroidAttribution$measurementManager$2 extends Lambda {
    final Context $context;
    final AndroidAttribution this$0;

    AndroidAttribution$measurementManager$2(AndroidAttribution p0, Context p1) {
        this$0 = p0;
        $context = p1;
        new Lambda(0);
        return;
    }

    public final MeasurementManager invoke() {
        AndroidAttribution.access$getMeasurementManager(this$0, $context);
        return AndroidAttribution.access$getMeasurementManager(..);
    }

    public Object invoke() {
        AndroidAttribution$measurementManager$2.invoke();
        return AndroidAttribution$measurementManager$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.attribution.AndroidAttribution$registerClick$2$1
// ============================================================
package com.unity3d.ads.core.domain.attribution;

public final class AndroidAttribution$registerClick$2$1 {
    final Continuation $continuation;

    AndroidAttribution$registerClick$2$1(Continuation p0) {
        $continuation = p0;
        new Object();
        return;
    }

    public void onError(Exception p0) {
        Boolean.valueOf(0);
        Result.constructor-impl(Boolean.valueOf(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onError(Throwable p0) {
        AndroidAttribution$registerClick$2$1.onError(p0);
        return;
    }

    public void onResult(Object p0) {
        Boolean.valueOf(1);
        Result.constructor-impl(Boolean.valueOf(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.attribution.AndroidAttribution$registerView$2$1
// ============================================================
package com.unity3d.ads.core.domain.attribution;

public final class AndroidAttribution$registerView$2$1 {
    final Continuation $continuation;

    AndroidAttribution$registerView$2$1(Continuation p0) {
        $continuation = p0;
        new Object();
        return;
    }

    public void onError(Exception p0) {
        Boolean.valueOf(0);
        Result.constructor-impl(Boolean.valueOf(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onError(Throwable p0) {
        AndroidAttribution$registerView$2$1.onError(p0);
        return;
    }

    public void onResult(Object p0) {
        Boolean.valueOf(1);
        Result.constructor-impl(Boolean.valueOf(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

}

