// Package bundle: com.unity3d.ads.core.domain.om (18 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidInitializeOMSDK
// ============================================================
package com.unity3d.ads.core.domain.om;

public final class AndroidInitializeOMSDK {
    private final Context context;
    private final OpenMeasurementRepository omRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public AndroidInitializeOMSDK(Context p0, SendDiagnosticEvent p1, SessionRepository p2, OpenMeasurementRepository p3) {
        new Object();
        context = p0;
        sendDiagnosticEvent = p1;
        sessionRepository = p2;
        omRepository = p3;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidInitializeOMSDK$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_38;
        if (if-ne(label, 1)) goto L_30;
        ResultKt.throwOnFailure(result);
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        sessionRepository.isOmEnabled();
        if (if-eqz(SessionRepository.isOmEnabled(..))) goto L_ca;
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_activate_started", 0, 0, 0, 0, 30, 0);
        L$0 = this;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 1;
        omRepository.activateOM(context, "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(OpenMeasurementRepository.activateOM(..), J$0)) goto L_68;
        return J$0;
      L_68:
      L_6a:
        if (if-eqz(1)) goto L_8a;
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), context);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_activate_success_time", Boxing.boxDouble(..), 0, 0, 0, 28, 0);
      L_8a:
        if (if-eqz(1)) goto L_ca;
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), context);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        MapsKt.createMapBuilder();
        OMResult$Failure.getReason();
        MapsKt.createMapBuilder(..).put("reason", OMResult$Failure.getReason(..));
        OMResult$Failure.getReasonDebug();
        if (if-eqz(OMResult$Failure.getReasonDebug(..))) goto L_bc;
        OMResult$Failure.getReasonDebug();
        MapsKt.createMapBuilder(..).put("reason_debug", OMResult$Failure.getReasonDebug(..));
      L_bc:
        MapsKt.build(MapsKt.createMapBuilder(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_activate_failure_time", Boxing.boxDouble(..), MapsKt.build(..), 0, 0, 24, 0);
      L_ca:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidOmFinishSession
// ============================================================
package com.unity3d.ads.core.domain.om;

public final class AndroidOmFinishSession {
    private final OpenMeasurementRepository openMeasurementRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidOmFinishSession(OpenMeasurementRepository p0, SendDiagnosticEvent p1) {
        new Object();
        openMeasurementRepository = p0;
        sendDiagnosticEvent = p1;
        return;
    }

    public Object invoke(AdObject p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidOmFinishSession$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3a;
        if (if-ne(label, 1)) goto L_32;
        ResultKt.throwOnFailure(result);
      L_32:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3a:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        new IllegalStateException(..).getOpportunityId();
        L$0 = this;
        L$1 = new IllegalStateException(..);
        label = 1;
        openMeasurementRepository.finishSession(AdObject.getOpportunityId(..), L$0);
        if (if-ne(OpenMeasurementRepository.finishSession(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_50;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_50:
      L_51:
        if (if-eqz(new IllegalStateException(..))) goto L_66;
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_session_finish_success", 0, 0, 0, new IllegalStateException(..), 14, 0);
      L_66:
        if (if-eqz(new IllegalStateException(..))) goto L_9a;
        MapsKt.createMapBuilder();
        OMResult$Failure.getReason();
        MapsKt.createMapBuilder(..).put("reason", OMResult$Failure.getReason(..));
        OMResult$Failure.getReasonDebug();
        if (if-eqz(OMResult$Failure.getReasonDebug(..))) goto L_8d;
        OMResult$Failure.getReasonDebug();
        MapsKt.createMapBuilder(..).put("reason_debug", OMResult$Failure.getReasonDebug(..));
      L_8d:
        MapsKt.build(MapsKt.createMapBuilder(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_session_finish_failure", 0, MapsKt.build(..), 0, new IllegalStateException(..), 10, 0);
      L_9a:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidOmImpressionOccurred
// ============================================================
package com.unity3d.ads.core.domain.om;

public final class AndroidOmImpressionOccurred {
    private final OpenMeasurementRepository openMeasurementRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidOmImpressionOccurred(OpenMeasurementRepository p0, SendDiagnosticEvent p1) {
        new Object();
        openMeasurementRepository = p0;
        sendDiagnosticEvent = p1;
        return;
    }

    public Object invoke(AdObject p0, boolean p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidOmImpressionOccurred$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3b;
        if (if-ne(label, 1)) goto L_33;
        ResultKt.throwOnFailure(result);
      L_31:
      L_33:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3b:
        ResultKt.throwOnFailure(result);
        new IllegalStateException(..).getOpportunityId();
        L$0 = this;
        L$1 = new IllegalStateException(..);
        label = 1;
        openMeasurementRepository.impressionOccurred(AdObject.getOpportunityId(..), "call to 'resume' before 'invoke' with coroutine", new AndroidOmImpressionOccurred$invoke$1(..));
        if (if-ne(OpenMeasurementRepository.impressionOccurred(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_51;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_51:
      L_53:
        if (if-eqz(new IllegalStateException(..))) goto L_67;
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_impression_occurred_success", 0, 0, 0, L$1, 14, 0);
      L_67:
        if (if-eqz(new IllegalStateException(..))) goto L_9b;
        MapsKt.createMapBuilder();
        OMResult$Failure.getReason();
        MapsKt.createMapBuilder(..).put("reason", OMResult$Failure.getReason(..));
        OMResult$Failure.getReasonDebug();
        if (if-eqz(OMResult$Failure.getReasonDebug(..))) goto L_8e;
        OMResult$Failure.getReasonDebug();
        MapsKt.createMapBuilder(..).put("reason_debug", OMResult$Failure.getReasonDebug(..));
      L_8e:
        MapsKt.build(MapsKt.createMapBuilder(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_impression_occurred_failure", 0, MapsKt.build(..), 0, L$1, 10, 0);
      L_9b:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidOmInteraction
// ============================================================
package com.unity3d.ads.core.domain.om;

public abstract class AndroidOmInteraction {
    public AndroidOmInteraction() {
        new Object();
        return;
    }

    private final CreativeType getCreativeType(JSONObject p0) {
        p0.optInt("creativeType");
        if (if-eq(JSONObject.optInt(..), 1)) goto L_29;
        if (if-eq(JSONObject.optInt(..), 2)) goto L_26;
        if (if-eq(JSONObject.optInt(..), 3)) goto L_23;
        if (if-eq(JSONObject.optInt(..), 4)) goto L_20;
        if (if-ne(JSONObject.optInt(..), 5)) goto L_18;
      L_18:
        new IllegalArgumentException("Invalid creativeType");
        throw new IllegalArgumentException(..);
      L_20:
      L_23:
      L_26:
      L_29:
      L_2b:
        return CreativeType.DEFINED_BY_JAVASCRIPT;
    }

    private final ImpressionType getImpressionType(JSONObject p0) {
        p0.optInt("impressionType");
        new IllegalArgumentException("Invalid impressionType");
        throw new IllegalArgumentException(..);
      L_28:
        return ImpressionType.DEFINED_BY_JAVASCRIPT;
    }

    private final Owner getImpressionsOwner(JSONObject p0) {
        p0.optInt("impressionOwner");
        if (if-eq(JSONObject.optInt(..), 1)) goto L_1d;
        if (if-eq(JSONObject.optInt(..), 2)) goto L_1a;
        if (if-ne(JSONObject.optInt(..), 3)) goto L_12;
      L_12:
        new IllegalArgumentException("Invalid impressionOwner");
        throw new IllegalArgumentException(..);
      L_1a:
      L_1d:
      L_22:
        return Owner.NONE;
    }

    private final Owner getMediaEventsOwner(JSONObject p0) {
        p0.optInt("mediaEventsOwner");
        if (if-eq(JSONObject.optInt(..), 1)) goto L_1d;
        if (if-eq(JSONObject.optInt(..), 2)) goto L_1a;
        if (if-ne(JSONObject.optInt(..), 3)) goto L_12;
      L_12:
        new IllegalArgumentException("Invalid mediaEventsOwner");
        throw new IllegalArgumentException(..);
      L_1a:
      L_1d:
      L_22:
        return Owner.NONE;
    }

    private final Owner getVideoEventsOwner(JSONObject p0) {
        p0.optInt("videoEventsOwner");
        if (if-eq(JSONObject.optInt(..), 1)) goto L_1d;
        if (if-eq(JSONObject.optInt(..), 2)) goto L_1a;
        if (if-ne(JSONObject.optInt(..), 3)) goto L_12;
      L_12:
        new IllegalArgumentException("Invalid videoEventsOwner");
        throw new IllegalArgumentException(..);
      L_1a:
      L_1d:
      L_22:
        return Owner.NONE;
    }

    public OmidOptions getOMidOptions(JSONObject p0) {
        p0.optBoolean("isolateVerificationScripts");
        AndroidOmInteraction.getImpressionsOwner(p0);
        AndroidOmInteraction.getVideoEventsOwner(p0);
        p0.optString("customReferenceData");
        AndroidOmInteraction.getImpressionType(p0);
        AndroidOmInteraction.getCreativeType(p0);
        AndroidOmInteraction.getMediaEventsOwner(p0);
        new OmidOptions(JSONObject.optBoolean(..), AndroidOmInteraction.getImpressionsOwner(..), AndroidOmInteraction.getVideoEventsOwner(..), JSONObject.optString(..), AndroidOmInteraction.getImpressionType(..), AndroidOmInteraction.getCreativeType(..), AndroidOmInteraction.getMediaEventsOwner(..));
        return new OmidOptions;
    }

    public WebView getWebview(AdObject p0) {
        p0.getAdPlayer();
        if (if-eqz("adObject")) goto L_18;
        AdObject.getAdPlayer(..).getWebViewContainer();
        AndroidWebViewContainer.getWebView();
      L_18:
        if (if-eqz("adObject")) goto L_27;
        AndroidEmbeddableWebViewAdPlayer.getWebViewContainer();
        AndroidWebViewContainer.getWebView();
      L_27:
      L_28:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidOmStartSession
// ============================================================
package com.unity3d.ads.core.domain.om;

public final class AndroidOmStartSession extends AndroidOmInteraction {
    private final OpenMeasurementRepository openMeasurementRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidOmStartSession(OpenMeasurementRepository p0, SendDiagnosticEvent p1) {
        new AndroidOmInteraction();
        openMeasurementRepository = p0;
        sendDiagnosticEvent = p1;
        return;
    }

    public Object invoke(AdObject p0, JSONObject p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidOmStartSession$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3a;
        if (if-ne(label, 1)) goto L_32;
        ResultKt.throwOnFailure(result);
      L_32:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3a:
        ResultKt.throwOnFailure(result);
        new IllegalStateException(..).getOpportunityId();
        AndroidOmStartSession.getWebview(new IllegalStateException(..));
        AndroidOmStartSession.getOMidOptions("call to 'resume' before 'invoke' with coroutine");
        L$0 = this;
        L$1 = new IllegalStateException(..);
        label = 1;
        openMeasurementRepository.startSession(AdObject.getOpportunityId(..), AndroidOmStartSession.getWebview(..), AndroidOmStartSession.getOMidOptions(..), new AndroidOmStartSession$invoke$1(..));
        if (if-ne(OpenMeasurementRepository.startSession(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_58;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_58:
      L_59:
        if (if-eqz(new IllegalStateException(..))) goto L_6e;
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_session_start_success", 0, 0, 0, new IllegalStateException(..), 14, 0);
      L_6e:
        if (if-eqz(new IllegalStateException(..))) goto L_a2;
        MapsKt.createMapBuilder();
        OMResult$Failure.getReason();
        MapsKt.createMapBuilder(..).put("reason", OMResult$Failure.getReason(..));
        OMResult$Failure.getReasonDebug();
        if (if-eqz(OMResult$Failure.getReasonDebug(..))) goto L_95;
        OMResult$Failure.getReasonDebug();
        MapsKt.createMapBuilder(..).put("reason_debug", OMResult$Failure.getReasonDebug(..));
      L_95:
        MapsKt.build(MapsKt.createMapBuilder(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "om_session_start_failure", 0, MapsKt.build(..), 0, new IllegalStateException(..), 10, 0);
      L_a2:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.CommonGetOmData
// ============================================================
package com.unity3d.ads.core.domain.om;

public final class CommonGetOmData {
    private final OpenMeasurementRepository openMeasurementRepository;

    public CommonGetOmData(OpenMeasurementRepository p0) {
        new Object();
        openMeasurementRepository = p0;
        return;
    }

    public Object invoke(Continuation p0) {
        openMeasurementRepository.getOmData();
        return OpenMeasurementRepository.getOmData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.CommonIsOMActivated
// ============================================================
package com.unity3d.ads.core.domain.om;

public final class CommonIsOMActivated {
    private final OpenMeasurementRepository openMeasurementRepository;

    public CommonIsOMActivated(OpenMeasurementRepository p0) {
        new Object();
        openMeasurementRepository = p0;
        return;
    }

    public boolean invoke() {
        openMeasurementRepository.isOMActive();
        return OpenMeasurementRepository.isOMActive(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.GetOmData
// ============================================================
package com.unity3d.ads.core.domain.om;

public abstract class GetOmData {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.InitializeOMSDK
// ============================================================
package com.unity3d.ads.core.domain.om;

public abstract class InitializeOMSDK {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.IsOMActivated
// ============================================================
package com.unity3d.ads.core.domain.om;

public abstract class IsOMActivated {
    public abstract boolean invoke() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.OmFinishSession
// ============================================================
package com.unity3d.ads.core.domain.om;

public abstract class OmFinishSession {
    public abstract Object invoke(AdObject p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.OmImpressionOccurred
// ============================================================
package com.unity3d.ads.core.domain.om;

public abstract class OmImpressionOccurred {
    public abstract Object invoke(AdObject p0, boolean p1, Continuation p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.OmInteraction
// ============================================================
package com.unity3d.ads.core.domain.om;

public abstract class OmInteraction {
    public static final OmInteraction$Companion Companion = null;
    public static final String OMID_CREATIVE_TYPE = "creativeType";
    public static final String OMID_CUSTOM_REFERENCE_DATA = "customReferenceData";
    public static final String OMID_IMPRESSION_OWNER = "impressionOwner";
    public static final String OMID_IMPRESSION_TYPE = "impressionType";
    public static final String OMID_ISOLATE_VERIFICATION_SCRIPTS = "isolateVerificationScripts";
    public static final String OMID_MEDIA_EVENTS_OWNER = "mediaEventsOwner";
    public static final String OMID_VIDEO_EVENTS_OWNER = "videoEventsOwner";

    static <clinit>() {
        Companion = OmInteraction$Companion.$$INSTANCE;
        return;
    }

    public abstract OmidOptions getOMidOptions(JSONObject p0) {
        // native or abstract
    }

    public abstract WebView getWebview(AdObject p0) {
        // native or abstract
    }

    public abstract Object invoke(AdObject p0, JSONObject p1, Continuation p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidInitializeOMSDK$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.om;

final class AndroidInitializeOMSDK$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    Object result;
    final AndroidInitializeOMSDK this$0;

    AndroidInitializeOMSDK$invoke$1(AndroidInitializeOMSDK p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidInitializeOMSDK.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidOmFinishSession$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.om;

final class AndroidOmFinishSession$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidOmFinishSession this$0;

    AndroidOmFinishSession$invoke$1(AndroidOmFinishSession p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, this);
        return AndroidOmFinishSession.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidOmImpressionOccurred$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.om;

final class AndroidOmImpressionOccurred$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidOmImpressionOccurred this$0;

    AndroidOmImpressionOccurred$invoke$1(AndroidOmImpressionOccurred p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, this);
        return AndroidOmImpressionOccurred.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.om;

final class AndroidOmStartSession$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidOmStartSession this$0;

    AndroidOmStartSession$invoke$1(AndroidOmStartSession p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, this);
        return AndroidOmStartSession.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.om.OmInteraction$Companion
// ============================================================
package com.unity3d.ads.core.domain.om;

public final class OmInteraction$Companion {
    static final OmInteraction$Companion $$INSTANCE = null;
    public static final String OMID_CREATIVE_TYPE = "creativeType";
    public static final String OMID_CUSTOM_REFERENCE_DATA = "customReferenceData";
    public static final String OMID_IMPRESSION_OWNER = "impressionOwner";
    public static final String OMID_IMPRESSION_TYPE = "impressionType";
    public static final String OMID_ISOLATE_VERIFICATION_SCRIPTS = "isolateVerificationScripts";
    public static final String OMID_MEDIA_EVENTS_OWNER = "mediaEventsOwner";
    public static final String OMID_VIDEO_EVENTS_OWNER = "videoEventsOwner";

    static <clinit>() {
        new OmInteraction$Companion();
        $$INSTANCE = new OmInteraction$Companion(..);
        return;
    }

    private OmInteraction$Companion() {
        new Object();
        return;
    }

}

