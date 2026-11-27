// Package bundle: com.unity3d.services.ads.gmascar.models (1 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.models.BiddingSignals
// ============================================================
package com.unity3d.services.ads.gmascar.models;

public class BiddingSignals {
    private final String bannerSignal;
    private final String interstitialSignal;
    private final String rvSignal;

    public BiddingSignals(String p0, String p1) {
        new Object();
        rvSignal = p0;
        interstitialSignal = p1;
        bannerSignal = "";
        return;
    }

    public BiddingSignals(String p0, String p1, String p2) {
        new Object();
        rvSignal = p0;
        interstitialSignal = p1;
        bannerSignal = p2;
        return;
    }

    public String getBannerSignal() {
        return bannerSignal;
    }

    public String getInterstitialSignal() {
        return interstitialSignal;
    }

    public Map getMap() {
        new HashMap();
        BiddingSignals.getRvSignal();
        TextUtils.isEmpty(BiddingSignals.getRvSignal(..));
        if (if-nez(TextUtils.isEmpty(..))) goto L_18;
        BiddingSignals.getRvSignal();
        new HashMap(..).put("rv", BiddingSignals.getRvSignal(..));
      L_18:
        BiddingSignals.getInterstitialSignal();
        TextUtils.isEmpty(BiddingSignals.getInterstitialSignal(..));
        if (if-nez(TextUtils.isEmpty(..))) goto L_2b;
        BiddingSignals.getInterstitialSignal();
        new HashMap(..).put("in", BiddingSignals.getInterstitialSignal(..));
      L_2b:
        BiddingSignals.getBannerSignal();
        TextUtils.isEmpty(BiddingSignals.getBannerSignal(..));
        if (if-nez(TextUtils.isEmpty(..))) goto L_3e;
        BiddingSignals.getBannerSignal();
        new HashMap(..).put("bn", BiddingSignals.getBannerSignal(..));
      L_3e:
        return new HashMap(..);
    }

    public String getRvSignal() {
        return rvSignal;
    }

    public boolean isEmpty() {
        BiddingSignals.getRvSignal();
        TextUtils.isEmpty(BiddingSignals.getRvSignal(..));
        if (if-eqz(TextUtils.isEmpty(..))) goto L_20;
        BiddingSignals.getInterstitialSignal();
        TextUtils.isEmpty(BiddingSignals.getInterstitialSignal(..));
        if (if-eqz(TextUtils.isEmpty(..))) goto L_20;
        BiddingSignals.getBannerSignal();
        TextUtils.isEmpty(BiddingSignals.getBannerSignal(..));
        if (if-eqz(TextUtils.isEmpty(..))) goto L_20;
      L_20:
      L_21:
        return 0;
    }

}

