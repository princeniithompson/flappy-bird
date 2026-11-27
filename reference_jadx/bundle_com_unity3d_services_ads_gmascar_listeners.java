
// ===== FILE: com/unity3d/services/ads/gmascar/listeners/IBiddingSignalsListener.java =====
package com.unity3d.services.ads.gmascar.listeners;

import com.unity3d.services.ads.gmascar.models.BiddingSignals;

/* loaded from: classes.dex */
public interface IBiddingSignalsListener {
    void onSignalsFailure(String str);

    void onSignalsReady(BiddingSignals biddingSignals);
}

// ===== FILE: com/unity3d/services/ads/gmascar/listeners/IInitializationStatusListener.java =====
package com.unity3d.services.ads.gmascar.listeners;

/* loaded from: classes.dex */
public interface IInitializationStatusListener {
    void onInitializationComplete(Object obj);
}
