
// ===== FILE: com/unity3d/services/ads/topics/TopicsErrors.java =====
package com.unity3d.services.ads.topics;

import kotlin.Metadata;

/* compiled from: TopicsErrors.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, m444d2 = {"Lcom/unity3d/services/ads/topics/TopicsErrors;", "", "(Ljava/lang/String;I)V", "ERROR_EXCEPTION", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public enum TopicsErrors {
    ERROR_EXCEPTION
}

// ===== FILE: com/unity3d/services/ads/topics/TopicsEvents.java =====
package com.unity3d.services.ads.topics;

import kotlin.Metadata;

/* compiled from: TopicsEvents.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m444d2 = {"Lcom/unity3d/services/ads/topics/TopicsEvents;", "", "(Ljava/lang/String;I)V", "NOT_AVAILABLE", "TOPICS_AVAILABLE", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public enum TopicsEvents {
    NOT_AVAILABLE,
    TOPICS_AVAILABLE
}

// ===== FILE: com/unity3d/services/ads/topics/TopicsReceiver.java =====
package com.unity3d.services.ads.topics;

import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TopicsReceiver.kt */
@Metadata(m443d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/ads/topics/TopicsReceiver;", "Landroid/os/OutcomeReceiver;", "Landroid/adservices/topics/GetTopicsResponse;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "eventSender", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "(Lcom/unity3d/services/core/webview/bridge/IEventSender;)V", "formatTopic", "Lorg/json/JSONObject;", "topic", "Landroid/adservices/topics/Topic;", "onError", "", "error", "onResult", "result", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class TopicsReceiver implements OutcomeReceiver<GetTopicsResponse, Exception> {
    private final IEventSender eventSender;

    public TopicsReceiver(IEventSender eventSender) {
        Intrinsics.checkNotNullParameter(eventSender, "eventSender");
        this.eventSender = eventSender;
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(GetTopicsResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        JSONArray jSONArray = new JSONArray();
        List<Topic> topics = result.getTopics();
        Intrinsics.checkNotNullExpressionValue(topics, "result.topics");
        for (Topic it : topics) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.put(formatTopic(it));
        }
        IEventSender iEventSender = this.eventSender;
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.TOPICS;
        TopicsEvents topicsEvents = TopicsEvents.TOPICS_AVAILABLE;
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "resultArray.toString()");
        iEventSender.sendEvent(webViewEventCategory, topicsEvents, jSONArray2);
    }

    @Override // android.os.OutcomeReceiver
    public void onError(Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        DeviceLog.debug("GetTopics exception: " + error);
        this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, TopicsErrors.ERROR_EXCEPTION, error.toString());
    }

    public final JSONObject formatTopic(Topic topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taxonomyVersion", topic.getTaxonomyVersion());
        jSONObject.put("modelVersion", topic.getModelVersion());
        jSONObject.put("topicId", topic.getTopicId());
        return jSONObject;
    }
}

// ===== FILE: com/unity3d/services/ads/topics/TopicsService.java =====
package com.unity3d.services.ads.topics;

import android.adservices.AdServicesState;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.os.ext.SdkExtensions;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: TopicsService.kt */
@Metadata(m443d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m444d2 = {"Lcom/unity3d/services/ads/topics/TopicsService;", "", "context", "Landroid/content/Context;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "eventSender", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "(Landroid/content/Context;Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/webview/bridge/IEventSender;)V", "topicsManager", "Landroid/adservices/topics/TopicsManager;", "checkAvailability", "Lcom/unity3d/services/ads/topics/TopicsStatus;", "getTopics", "", "adsSdkName", "", "shouldRecordObservation", "", "getTopicsManager", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class TopicsService {
    private final ISDKDispatchers dispatchers;
    private final IEventSender eventSender;
    private final TopicsManager topicsManager;

    public TopicsService(Context context, ISDKDispatchers dispatchers, IEventSender eventSender) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(eventSender, "eventSender");
        this.dispatchers = dispatchers;
        this.eventSender = eventSender;
        this.topicsManager = getTopicsManager(context);
    }

    public final TopicsStatus checkAvailability() {
        if (Device.getApiLevel() < 33) {
            return TopicsStatus.ERROR_API_BELOW_33;
        }
        if (SdkExtensions.getExtensionVersion(DurationKt.NANOS_IN_MILLIS) < 4) {
            return TopicsStatus.ERROR_EXTENSION_BELOW_4;
        }
        if (this.topicsManager == null) {
            return TopicsStatus.ERROR_TOPICSMANAGER_NULL;
        }
        if (!AdServicesState.isAdServicesStateEnabled()) {
            return TopicsStatus.ERROR_AD_SERVICES_DISABLED;
        }
        return TopicsStatus.TOPICS_AVAILABLE;
    }

    public final void getTopics(String adsSdkName, boolean shouldRecordObservation) {
        Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
        TopicsReceiver topicsReceiver = new TopicsReceiver(this.eventSender);
        GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(adsSdkName).setShouldRecordObservation(shouldRecordObservation).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().setAdsSdkName(…ecordObservation).build()");
        try {
            TopicsManager topicsManager = this.topicsManager;
            if (topicsManager != null) {
                topicsManager.getTopics(build, ExecutorsKt.asExecutor(this.dispatchers.getDefault()), topicsReceiver);
            }
        } catch (Exception e) {
            this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, TopicsErrors.ERROR_EXCEPTION, e.toString());
            DeviceLog.debug("Failed to get topics with error: " + e);
        }
    }

    private final TopicsManager getTopicsManager(Context context) {
        if (Device.getApiLevel() >= 33 && SdkExtensions.getExtensionVersion(DurationKt.NANOS_IN_MILLIS) >= 4) {
            return (TopicsManager) context.getSystemService(TopicsManager.class);
        }
        return null;
    }
}

// ===== FILE: com/unity3d/services/ads/topics/TopicsStatus.java =====
package com.unity3d.services.ads.topics;

import kotlin.Metadata;

/* compiled from: TopicsStatus.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m444d2 = {"Lcom/unity3d/services/ads/topics/TopicsStatus;", "", "(Ljava/lang/String;I)V", "TOPICS_AVAILABLE", "ERROR_TOPICSMANAGER_NULL", "ERROR_API_BELOW_33", "ERROR_EXTENSION_BELOW_4", "ERROR_AD_SERVICES_DISABLED", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public enum TopicsStatus {
    TOPICS_AVAILABLE,
    ERROR_TOPICSMANAGER_NULL,
    ERROR_API_BELOW_33,
    ERROR_EXTENSION_BELOW_4,
    ERROR_AD_SERVICES_DISABLED
}
