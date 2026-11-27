// Package bundle: com.unity3d.services.ads.gmascar (2 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.GMA
// ============================================================
package com.unity3d.services.ads.gmascar;

public class GMA {
    private static GMAScarAdapterBridge _gmaScarAdapterBridge;
    private static GMA instance;

    static <clinit>() {
        new MobileAdsBridgeFactory();
        new MobileAdsBridgeFactory(..).createMobileAdsBridge();
        new InitializeListenerBridge();
        new InitializationStatusBridge();
        new AdapterStatusBridge();
        new WebViewErrorHandler();
        new ScarAdapterFactory();
        new GMAEventSender();
        new GMAScarAdapterBridge(MobileAdsBridgeFactory.createMobileAdsBridge(..), new InitializeListenerBridge(..), new InitializationStatusBridge(..), new AdapterStatusBridge(..), new WebViewErrorHandler(..), new ScarAdapterFactory(..), new GMAEventSender(..));
        _gmaScarAdapterBridge = new GMAScarAdapterBridge;
        return;
    }

    private GMA() {
        new Object();
        return;
    }

    public static GMA getInstance() {
        if (if-nez(GMA.instance)) goto L_b;
        new GMA();
        instance = new GMA(..);
      L_b:
        return GMA.instance;
    }

    public GMAScarAdapterBridge getBridge() {
        return GMA._gmaScarAdapterBridge;
    }

    public void getSCARBiddingSignals(boolean p0, IBiddingSignalsListener p1) {
        new BiddingSignalsHandler(p0, p1);
        GMA._gmaScarAdapterBridge.getSCARBiddingSignals(p0, new BiddingSignalsHandler(..));
        return;
    }

    public boolean hasSCARBiddingSupport() {
        GMA._gmaScarAdapterBridge.hasSCARBiddingSupport();
        return GMAScarAdapterBridge.hasSCARBiddingSupport(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.GMAScarAdapterBridge
// ============================================================
package com.unity3d.services.ads.gmascar;

public class GMAScarAdapterBridge {
    private final AdapterStatusBridge _adapterStatusBridge;
    private final GMAEventSender _gmaEventSender;
    private final GMAInitializer _gmaInitializer;
    private final InitializeListenerBridge _initializationListenerBridge;
    private final InitializationStatusBridge _initializationStatusBridge;
    private final MobileAdsBridgeBase _mobileAdsBridge;
    private final PresenceDetector _presenceDetector;
    private IScarAdapter _scarAdapter;
    private final ScarAdapterFactory _scarAdapterFactory;
    private final ScarVersionFinder _scarVersionFinder;
    private final WebViewErrorHandler _webViewErrorHandler;

    public GMAScarAdapterBridge(MobileAdsBridgeBase p0, InitializeListenerBridge p1, InitializationStatusBridge p2, AdapterStatusBridge p3, WebViewErrorHandler p4, ScarAdapterFactory p5, GMAEventSender p6) {
        new Object();
        _initializationStatusBridge = p2;
        _initializationListenerBridge = p1;
        _adapterStatusBridge = p3;
        _webViewErrorHandler = p4;
        _scarAdapterFactory = p5;
        _mobileAdsBridge = p0;
        _gmaEventSender = p6;
        new PresenceDetector(p0, p1, p2, p3);
        _presenceDetector = new PresenceDetector(..);
        new GMAInitializer(p0, p1, p2, p3, p6);
        _gmaInitializer = new GMAInitializer;
        new ScarVersionFinder(p0, new PresenceDetector(..), new GMAInitializer, p6);
        _scarVersionFinder = new ScarVersionFinder(..);
        return;
    }

    private IScarAdapter getScarAdapterObject() {
        if (if-nez(_scarAdapter)) goto L_1c;
        if (if-eqz(_mobileAdsBridge)) goto L_1c;
        _scarVersionFinder.getVersionCode();
        _mobileAdsBridge.getAdapterVersion(ScarVersionFinder.getVersionCode(..));
        _scarAdapterFactory.createScarAdapter(MobileAdsBridgeBase.getAdapterVersion(..), _webViewErrorHandler);
        _scarAdapter = ScarAdapterFactory.createScarAdapter(..);
      L_1c:
        return _scarAdapter;
    }

    private EventSubject getScarEventSubject(Integer p0) {
        Arrays.asList(4);
        new ArrayDeque(Arrays.asList(..));
        new DefaultIntervalTimerFactory();
        new EventSubject(new ArrayDeque(..), p0, new DefaultIntervalTimerFactory(..));
        return new EventSubject(..);
    }

    private void loadInterstitialAd(ScarAdMetadata p0) {
        p0.getVideoLengthMs();
        GMAScarAdapterBridge.getScarEventSubject(ScarAdMetadata.getVideoLengthMs(..));
        new ScarInterstitialAdHandler(p0, GMAScarAdapterBridge.getScarEventSubject(..), _gmaEventSender);
        ClientProperties.getApplicationContext();
        _scarAdapter.loadInterstitialAd(ClientProperties.getApplicationContext(..), p0, new ScarInterstitialAdHandler(..));
        return;
    }

    private void loadRewardedAd(ScarAdMetadata p0) {
        p0.getVideoLengthMs();
        GMAScarAdapterBridge.getScarEventSubject(ScarAdMetadata.getVideoLengthMs(..));
        new ScarRewardedAdHandler(p0, GMAScarAdapterBridge.getScarEventSubject(..), _gmaEventSender);
        ClientProperties.getApplicationContext();
        _scarAdapter.loadRewardedAd(ClientProperties.getApplicationContext(..), p0, new ScarRewardedAdHandler(..));
        return;
    }

    public void getSCARBiddingSignals(boolean p0, BiddingSignalsHandler p1) {
        if (if-eqz(_mobileAdsBridge)) goto L_20;
        _mobileAdsBridge.hasSCARBiddingSupport();
        if (if-eqz(MobileAdsBridgeBase.hasSCARBiddingSupport(..))) goto L_20;
        GMAScarAdapterBridge.getScarAdapterObject();
        _scarAdapter = GMAScarAdapterBridge.getScarAdapterObject(..);
        if (if-eqz(GMAScarAdapterBridge.getScarAdapterObject(..))) goto L_1a;
        ClientProperties.getApplicationContext();
        IScarAdapter.getSCARBiddingSignals(ClientProperties.getApplicationContext(..), p0, p1);
      L_1a:
        p1.onSignalsCollectionFailed("Could not create SCAR adapter object.");
      L_20:
        p1.onSignalsCollectionFailed("SCAR bidding unsupported.");
      L_25:
        return;
    }

    public void getSCARSignal(String p0, UnityAdFormat p1) {
        GMAScarAdapterBridge.getScarAdapterObject();
        _scarAdapter = GMAScarAdapterBridge.getScarAdapterObject(..);
        new SignalsHandler(_gmaEventSender);
        if (if-eqz(_scarAdapter)) goto L_19;
        ClientProperties.getApplicationContext();
        _scarAdapter.getSCARSignal(ClientProperties.getApplicationContext(..), p0, p1, new SignalsHandler(..));
      L_19:
        GMAAdsError.InternalSignalsError("Could not create SCAR adapter object");
        _webViewErrorHandler.handleError(GMAAdsError.InternalSignalsError(..));
      L_24:
        return;
    }

    public void getVersion() {
        _scarVersionFinder.getVersion();
        return;
    }

    public boolean hasSCARBiddingSupport() {
        if (if-eqz(_mobileAdsBridge)) goto L_14;
        _mobileAdsBridge.hasSCARBiddingSupport();
        if (if-eqz(MobileAdsBridgeBase.hasSCARBiddingSupport(..))) goto L_14;
        GMAScarAdapterBridge.getScarAdapterObject();
        _scarAdapter = GMAScarAdapterBridge.getScarAdapterObject(..);
        if (if-eqz(GMAScarAdapterBridge.getScarAdapterObject(..))) goto L_14;
      L_14:
        return 1;
    }

    public void initializeScar() {
        _presenceDetector.areGMAClassesPresent();
        if (if-eqz(PresenceDetector.areGMAClassesPresent(..))) goto L_18;
        _gmaEventSender.send(GMAEvent.SCAR_PRESENT, 0);
        _gmaInitializer.initializeGMA();
      L_18:
        new GMAAdsError(GMAEvent.SCAR_NOT_PRESENT, 0);
        _webViewErrorHandler.handleError(new GMAAdsError(..));
      L_26:
        return;
    }

    public boolean isInitialized() {
        _gmaInitializer.isInitialized();
        return GMAInitializer.isInitialized(..);
    }

    public void load(boolean p0, String p1, String p2, String p3, String p4, int p5) {
        Integer.valueOf(p5);
        new ScarAdMetadata(p1, p2, p4, p3, Integer.valueOf(..));
        GMAScarAdapterBridge.getScarAdapterObject();
        _scarAdapter = GMAScarAdapterBridge.getScarAdapterObject(..);
        if (if-eqz(GMAScarAdapterBridge.getScarAdapterObject(..))) goto L_20;
        if (if-eqz(p0)) goto L_1c;
        GMAScarAdapterBridge.loadInterstitialAd(new ScarAdMetadata);
      L_1c:
        GMAScarAdapterBridge.loadRewardedAd(new ScarAdMetadata);
      L_20:
        GMAAdsError.InternalLoadError(new ScarAdMetadata, "Scar Adapter object is null");
        _webViewErrorHandler.handleError(GMAAdsError.InternalLoadError(..));
      L_2b:
        return;
    }

    public void loadBanner(Context p0, BannerView p1, String p2, ScarAdMetadata p3, UnityBannerSize p4) {
        GMAScarAdapterBridge.getScarAdapterObject();
        _scarAdapter = GMAScarAdapterBridge.getScarAdapterObject(..);
        new ScarBannerAdHandler(p2);
        if (if-eqz(_scarAdapter)) goto L_1e;
        p4.getWidth();
        p4.getHeight();
        _scarAdapter.loadBannerAd(p0, p1, p3, UnityBannerSize.getWidth(..), UnityBannerSize.getHeight(..), new ScarBannerAdHandler(..));
      L_1e:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_LOAD_FAILED, 1);
      L_2f:
        return;
    }

    public void show(String p0, String p1, boolean p2) {
        new ScarAdMetadata(p0, p1);
        GMAScarAdapterBridge.getScarAdapterObject();
        _scarAdapter = GMAScarAdapterBridge.getScarAdapterObject(..);
        if (if-eqz(GMAScarAdapterBridge.getScarAdapterObject(..))) goto L_15;
        ClientProperties.getActivity();
        IScarAdapter.show(ClientProperties.getActivity(..), p1, p0);
      L_15:
        GMAAdsError.InternalShowError(ClientProperties.getActivity(..), "Scar Adapter object is null");
        _webViewErrorHandler.handleError(GMAAdsError.InternalShowError(..));
      L_20:
        return;
    }

}

