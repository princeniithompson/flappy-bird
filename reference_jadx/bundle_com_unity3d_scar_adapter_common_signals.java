
// ===== FILE: com/unity3d/scar/adapter/common/signals/ISignalCallbackListener.java =====
package com.unity3d.scar.adapter.common.signals;

/* loaded from: classes.dex */
public interface ISignalCallbackListener<T> {
    void onFailure(String str);

    void onSuccess(String str, String str2, T t);
}

// ===== FILE: com/unity3d/scar/adapter/common/signals/ISignalCollectionListener.java =====
package com.unity3d.scar.adapter.common.signals;

/* loaded from: classes.dex */
public interface ISignalCollectionListener {
    void onSignalsCollected(String str);

    void onSignalsCollectionFailed(String str);
}

// ===== FILE: com/unity3d/scar/adapter/common/signals/ISignalsCollector.java =====
package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;

/* loaded from: classes.dex */
public interface ISignalsCollector {
    void getSCARBiddingSignals(Context context, boolean z, ISignalCollectionListener iSignalCollectionListener);

    void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, DispatchGroup dispatchGroup, SignalsResult signalsResult);

    void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, ISignalCollectionListener iSignalCollectionListener);

    void getSCARSignalForHB(Context context, UnityAdFormat unityAdFormat, DispatchGroup dispatchGroup, SignalsResult signalsResult);
}

// ===== FILE: com/unity3d/scar/adapter/common/signals/SignalCallbackListener.java =====
package com.unity3d.scar.adapter.common.signals;

import com.unity3d.scar.adapter.common.DispatchGroup;

/* loaded from: classes.dex */
public class SignalCallbackListener<T> implements ISignalCallbackListener<T> {
    private DispatchGroup _dispatchGroup;
    private SignalsResult _signalsResult;
    private SignalsStorage<T> _signalsStorage;

    public SignalCallbackListener(DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        this(dispatchGroup, null, signalsResult);
    }

    public SignalCallbackListener(DispatchGroup dispatchGroup, SignalsStorage<T> signalsStorage, SignalsResult signalsResult) {
        this._dispatchGroup = dispatchGroup;
        this._signalsStorage = signalsStorage;
        this._signalsResult = signalsResult;
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalCallbackListener
    public void onSuccess(String str, String str2, T t) {
        this._signalsResult.addToSignalsMap(str, str2);
        SignalsStorage<T> signalsStorage = this._signalsStorage;
        if (signalsStorage != null) {
            signalsStorage.put(str, t);
        }
        this._dispatchGroup.leave();
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalCallbackListener
    public void onFailure(String str) {
        this._signalsResult.setErrorMessage(str);
        this._dispatchGroup.leave();
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/signals/SignalsCollectorBase.java =====
package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class SignalsCollectorBase implements ISignalsCollector {
    public static final String SCAR_BAN_SIGNAL = "gmaScarBiddingBannerSignal";
    public static final String SCAR_INT_SIGNAL = "gmaScarBiddingInterstitialSignal";
    public static final String SCAR_RV_SIGNAL = "gmaScarBiddingRewardedSignal";

    @Override // com.unity3d.scar.adapter.common.signals.ISignalsCollector
    public void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        dispatchGroup.enter();
        getSCARSignal(context, str, unityAdFormat, dispatchGroup, signalsResult);
        dispatchGroup.notify(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalsCollector
    public void getSCARBiddingSignals(Context context, boolean z, ISignalCollectionListener iSignalCollectionListener) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        SignalsResult signalsResult = new SignalsResult();
        dispatchGroup.enter();
        getSCARSignalForHB(context, UnityAdFormat.INTERSTITIAL, dispatchGroup, signalsResult);
        dispatchGroup.enter();
        getSCARSignalForHB(context, UnityAdFormat.REWARDED, dispatchGroup, signalsResult);
        if (z) {
            dispatchGroup.enter();
            getSCARSignalForHB(context, UnityAdFormat.BANNER, dispatchGroup, signalsResult);
        }
        dispatchGroup.notify(new GMAScarDispatchCompleted(iSignalCollectionListener, signalsResult));
    }

    public void onOperationNotSupported(String str, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        signalsResult.setErrorMessage(String.format("Operation Not supported: %s.", str));
        dispatchGroup.leave();
    }

    private class GMAScarDispatchCompleted implements Runnable {
        private ISignalCollectionListener _signalListener;
        private SignalsResult _signalsResult;

        public GMAScarDispatchCompleted(ISignalCollectionListener iSignalCollectionListener, SignalsResult signalsResult) {
            this._signalListener = iSignalCollectionListener;
            this._signalsResult = signalsResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> signalsMap = this._signalsResult.getSignalsMap();
            if (signalsMap.size() > 0) {
                this._signalListener.onSignalsCollected(new JSONObject(signalsMap).toString());
            } else if (this._signalsResult.getErrorMessage() == null) {
                this._signalListener.onSignalsCollected("");
            } else {
                this._signalListener.onSignalsCollectionFailed(this._signalsResult.getErrorMessage());
            }
        }
    }

    /* renamed from: com.unity3d.scar.adapter.common.signals.SignalsCollectorBase$1 */
    static /* synthetic */ class C10061 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat;

        static {
            int[] iArr = new int[UnityAdFormat.values().length];
            $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat = iArr;
            try {
                iArr[UnityAdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat[UnityAdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat[UnityAdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String getAdKey(UnityAdFormat unityAdFormat) {
        int i = C10061.$SwitchMap$com$unity3d$scar$adapter$common$scarads$UnityAdFormat[unityAdFormat.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "" : SCAR_RV_SIGNAL : SCAR_INT_SIGNAL : SCAR_BAN_SIGNAL;
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/signals/SignalsResult.java =====
package com.unity3d.scar.adapter.common.signals;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SignalsResult {
    private Map<String, String> _signalsMap = new HashMap();
    private String _errorMessage = null;

    public void addToSignalsMap(String str, String str2) {
        this._signalsMap.put(str, str2);
    }

    public Map<String, String> getSignalsMap() {
        return this._signalsMap;
    }

    public void setErrorMessage(String str) {
        this._errorMessage = str;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/signals/SignalsStorage.java =====
package com.unity3d.scar.adapter.common.signals;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class SignalsStorage<T> {
    private final Map<String, T> _queryInfoMap = new ConcurrentHashMap();

    public T getQueryInfo(String str) {
        return this._queryInfoMap.get(str);
    }

    public void put(String str, T t) {
        this._queryInfoMap.put(str, t);
    }
}
