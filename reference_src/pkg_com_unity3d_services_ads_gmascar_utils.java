// Package bundle: com.unity3d.services.ads.gmascar.utils (3 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.utils.GMAEventSender
// ============================================================
package com.unity3d.services.ads.gmascar.utils;

public class GMAEventSender {
    private final IEventSender _eventSender;

    public GMAEventSender() {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new GMAEventSender(SharedInstances.getWebViewEventSender(..));
        return;
    }

    public GMAEventSender(IEventSender p0) {
        new Object();
        _eventSender = p0;
        return;
    }

    public void send(GMAEvent p0, Object[] p1) {
        _eventSender.sendEvent(WebViewEventCategory.GMA, p0, p1);
        return;
    }

    public void sendVersion(String p0) {
        _eventSender.sendEvent(WebViewEventCategory.INIT_GMA, GMAEvent.VERSION, 1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.utils.ScarConstants
// ============================================================
package com.unity3d.services.ads.gmascar.utils;

public class ScarConstants {
    public static final String BN_SIGNAL_KEY = "bn";
    public static final String IDFI_KEY = "idfi";
    public static final String IN_SIGNAL_KEY = "in";
    public static final String RV_SIGNAL_KEY = "rv";
    public static final String SCAR_PRD_BIDDING_ENDPOINT = "https://scar.unityads.unity3d.com/v1/capture-scar-signals";
    public static final String SCAR_TOKEN_IDENTIFIER_KEY = "scarId";
    public static final String TOKEN_ID_KEY = "tid";
    public static final String TOKEN_WITH_SCAR_FORMAT = "%s:%s";

    public ScarConstants() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.utils.ScarRequestHandler
// ============================================================
package com.unity3d.services.ads.gmascar.utils;

public class ScarRequestHandler {
    private final HttpClient httpClient;

    public ScarRequestHandler() {
        new Object();
        Utilities.getService(HttpClient.class);
        httpClient = Utilities.getService(..);
        return;
    }

    public void makeUploadRequest(String p0, BiddingSignals p1, String p2) {
        new HashMap();
        Collections.singletonList("application/json");
        new HashMap(..).put("Content-Type", Collections.singletonList(..));
        new HashMap();
        Device.getIdfi();
        new HashMap(..).put("idfi", Device.getIdfi(..));
        new HashMap(..).put("tid", p0);
        p1.getMap();
        new HashMap(..).putAll(BiddingSignals.getMap(..));
        new JSONObject(new HashMap(..));
        new JSONObject(..).toString();
        JSONObject.toString(..).getBytes(StandardCharsets.UTF_8);
        new HttpRequest(p2, "", RequestType.POST, String.getBytes(..), new HashMap(..));
        httpClient.executeBlocking(new HttpRequest);
        return;
    }

}

