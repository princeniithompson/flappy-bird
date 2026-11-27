
// ===== FILE: com/unity3d/services/ads/gmascar/utils/GMAEventSender.java =====
package com.unity3d.services.ads.gmascar.utils;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;

/* loaded from: classes.dex */
public class GMAEventSender {
    private final IEventSender _eventSender;

    public GMAEventSender() {
        this(SharedInstances.INSTANCE.getWebViewEventSender());
    }

    public GMAEventSender(IEventSender iEventSender) {
        this._eventSender = iEventSender;
    }

    public void send(GMAEvent gMAEvent, Object... objArr) {
        this._eventSender.sendEvent(WebViewEventCategory.GMA, gMAEvent, objArr);
    }

    public void sendVersion(String str) {
        this._eventSender.sendEvent(WebViewEventCategory.INIT_GMA, GMAEvent.VERSION, str);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/utils/ScarConstants.java =====
package com.unity3d.services.ads.gmascar.utils;

/* loaded from: classes.dex */
public class ScarConstants {
    public static final String BN_SIGNAL_KEY = "bn";
    public static final String IDFI_KEY = "idfi";
    public static final String IN_SIGNAL_KEY = "in";
    public static final String RV_SIGNAL_KEY = "rv";
    public static final String SCAR_PRD_BIDDING_ENDPOINT = "https://scar.unityads.unity3d.com/v1/capture-scar-signals";
    public static final String SCAR_TOKEN_IDENTIFIER_KEY = "scarId";
    public static final String TOKEN_ID_KEY = "tid";
    public static final String TOKEN_WITH_SCAR_FORMAT = "%s:%s";
}

// ===== FILE: com/unity3d/services/ads/gmascar/utils/ScarRequestHandler.java =====
package com.unity3d.services.ads.gmascar.utils;

import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.RequestType;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ScarRequestHandler {
    private final HttpClient httpClient = (HttpClient) Utilities.getService(HttpClient.class);

    public void makeUploadRequest(String str, BiddingSignals biddingSignals, String str2) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put(CommonGatewayClient.HEADER_CONTENT_TYPE, Collections.singletonList("application/json"));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ScarConstants.IDFI_KEY, Device.getIdfi());
        hashMap2.put(ScarConstants.TOKEN_ID_KEY, str);
        hashMap2.putAll(biddingSignals.getMap());
        this.httpClient.executeBlocking(new HttpRequest(str2, "", RequestType.POST, new JSONObject(hashMap2).toString().getBytes(StandardCharsets.UTF_8), hashMap));
    }
}
