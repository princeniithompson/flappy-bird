// Package bundle: com.unity3d.services.ads.topics (5 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.topics.TopicsErrors
// ============================================================
package com.unity3d.services.ads.topics;

public final class TopicsErrors extends Enum {
    private static final TopicsErrors[] $VALUES;
    public static final TopicsErrors ERROR_EXCEPTION;

    private static final TopicsErrors[] $values() {
        return 1;
    }

    static <clinit>() {
        new TopicsErrors("ERROR_EXCEPTION", 0);
        ERROR_EXCEPTION = new TopicsErrors(..);
        TopicsErrors.$values();
        $VALUES = TopicsErrors.$values(..);
        return;
    }

    private TopicsErrors(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static TopicsErrors valueOf(String p0) {
        Enum.valueOf(TopicsErrors.class, p0);
        return Enum.valueOf(..);
    }

    public static TopicsErrors[] values() {
        TopicsErrors.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.topics.TopicsEvents
// ============================================================
package com.unity3d.services.ads.topics;

public final class TopicsEvents extends Enum {
    private static final TopicsEvents[] $VALUES;
    public static final TopicsEvents NOT_AVAILABLE;
    public static final TopicsEvents TOPICS_AVAILABLE;

    private static final TopicsEvents[] $values() {
        return 2;
    }

    static <clinit>() {
        new TopicsEvents("NOT_AVAILABLE", 0);
        NOT_AVAILABLE = new TopicsEvents(..);
        new TopicsEvents("TOPICS_AVAILABLE", 1);
        TOPICS_AVAILABLE = new TopicsEvents(..);
        TopicsEvents.$values();
        $VALUES = TopicsEvents.$values(..);
        return;
    }

    private TopicsEvents(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static TopicsEvents valueOf(String p0) {
        Enum.valueOf(TopicsEvents.class, p0);
        return Enum.valueOf(..);
    }

    public static TopicsEvents[] values() {
        TopicsEvents.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.topics.TopicsReceiver
// ============================================================
package com.unity3d.services.ads.topics;

public final class TopicsReceiver {
    private final IEventSender eventSender;

    public TopicsReceiver(IEventSender p0) {
        new Object();
        eventSender = p0;
        return;
    }

    public final JSONObject formatTopic(Topic p0) {
        new JSONObject();
        p0.getTaxonomyVersion();
        new JSONObject(..).put("taxonomyVersion", Topic.getTaxonomyVersion(..), v3);
        p0.getModelVersion();
        new JSONObject(..).put("modelVersion", Topic.getModelVersion(..), v3);
        p0.getTopicId();
        new JSONObject(..).put("topicId", Topic.getTopicId(..));
        return new JSONObject(..);
    }

    public void onError(Exception p0) {
        new StringBuilder("GetTopics exception: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        p0.toString();
        eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, 2);
        return;
    }

    public void onError(Throwable p0) {
        TopicsReceiver.onError(p0);
        return;
    }

    public void onResult(GetTopicsResponse p0) {
        new JSONArray();
        p0.getTopics();
        GetTopicsResponse.getTopics(..).iterator();
      L_19:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_32;
        Iterable.iterator(..).next();
        TopicsReceiver.formatTopic(Iterator.next(..));
        new JSONArray(..).put(TopicsReceiver.formatTopic(..));
      L_32:
        new JSONArray(..).toString();
        eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.TOPICS_AVAILABLE, 1);
        return;
    }

    public void onResult(Object p0) {
        TopicsReceiver.onResult(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.topics.TopicsService
// ============================================================
package com.unity3d.services.ads.topics;

public final class TopicsService {
    private final ISDKDispatchers dispatchers;
    private final IEventSender eventSender;
    private final TopicsManager topicsManager;

    public TopicsService(Context p0, ISDKDispatchers p1, IEventSender p2) {
        new Object();
        dispatchers = p1;
        eventSender = p2;
        new Object(..).getTopicsManager(p0);
        topicsManager = TopicsService.getTopicsManager(..);
        return;
    }

    private final TopicsManager getTopicsManager(Context p0) {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 33)) goto L_a;
        return 0;
      L_a:
        SdkExtensions.getExtensionVersion(1000000);
        if (if-ge(SdkExtensions.getExtensionVersion(..), 4)) goto L_15;
        return 0;
      L_15:
        p0.getSystemService(TopicsManager.class);
        return Context.getSystemService(..);
    }

    public final TopicsStatus checkAvailability() {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 33)) goto L_b;
        return TopicsStatus.ERROR_API_BELOW_33;
      L_b:
        SdkExtensions.getExtensionVersion(1000000);
        if (if-ge(SdkExtensions.getExtensionVersion(..), 4)) goto L_18;
        return TopicsStatus.ERROR_EXTENSION_BELOW_4;
      L_18:
        if (if-nez(topicsManager)) goto L_1f;
        return TopicsStatus.ERROR_TOPICSMANAGER_NULL;
      L_1f:
        AdServicesState.isAdServicesStateEnabled();
        if (if-nez(AdServicesState.isAdServicesStateEnabled(..))) goto L_28;
        return TopicsStatus.ERROR_AD_SERVICES_DISABLED;
      L_28:
        return TopicsStatus.TOPICS_AVAILABLE;
    }

    public final void getTopics(String p0, boolean p1) {
        new TopicsReceiver(eventSender);
        new GetTopicsRequest$Builder();
        new GetTopicsRequest$Builder(..).setAdsSdkName(p0);
        GetTopicsRequest$Builder.setShouldRecordObservation(p1);
        GetTopicsRequest$Builder.build();
        if (if-eqz(topicsManager)) goto L_64;
        dispatchers.getDefault();
        ExecutorsKt.asExecutor(ISDKDispatchers.getDefault(..));
        topicsManager.getTopics(GetTopicsRequest$Builder.build(..), ExecutorsKt.asExecutor(..), new TopicsReceiver(..));
        GetTopicsRequest$Builder.build(..).toString();
        eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, 2);
        new StringBuilder("Failed to get topics with error: ");
        new StringBuilder(..).append(GetTopicsRequest$Builder.build(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_64:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.topics.TopicsStatus
// ============================================================
package com.unity3d.services.ads.topics;

public final class TopicsStatus extends Enum {
    private static final TopicsStatus[] $VALUES;
    public static final TopicsStatus ERROR_AD_SERVICES_DISABLED;
    public static final TopicsStatus ERROR_API_BELOW_33;
    public static final TopicsStatus ERROR_EXTENSION_BELOW_4;
    public static final TopicsStatus ERROR_TOPICSMANAGER_NULL;
    public static final TopicsStatus TOPICS_AVAILABLE;

    private static final TopicsStatus[] $values() {
        return 5;
    }

    static <clinit>() {
        new TopicsStatus("TOPICS_AVAILABLE", 0);
        TOPICS_AVAILABLE = new TopicsStatus(..);
        new TopicsStatus("ERROR_TOPICSMANAGER_NULL", 1);
        ERROR_TOPICSMANAGER_NULL = new TopicsStatus(..);
        new TopicsStatus("ERROR_API_BELOW_33", 2);
        ERROR_API_BELOW_33 = new TopicsStatus(..);
        new TopicsStatus("ERROR_EXTENSION_BELOW_4", 3);
        ERROR_EXTENSION_BELOW_4 = new TopicsStatus(..);
        new TopicsStatus("ERROR_AD_SERVICES_DISABLED", 4);
        ERROR_AD_SERVICES_DISABLED = new TopicsStatus(..);
        TopicsStatus.$values();
        $VALUES = TopicsStatus.$values(..);
        return;
    }

    private TopicsStatus(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static TopicsStatus valueOf(String p0) {
        Enum.valueOf(TopicsStatus.class, p0);
        return Enum.valueOf(..);
    }

    public static TopicsStatus[] values() {
        TopicsStatus.$VALUES.clone();
        return Object[].clone(..);
    }

}

