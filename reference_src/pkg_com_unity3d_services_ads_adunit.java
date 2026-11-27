// Package bundle: com.unity3d.services.ads.adunit (19 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitActivity
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitActivity extends Activity {
    public static final String EXTRA_ACTIVITY_ID = "activityId";
    public static final String EXTRA_DISPLAY_CUTOUT_MODE = "displayCutoutMode";
    public static final String EXTRA_KEEP_SCREEN_ON = "keepScreenOn";
    public static final String EXTRA_KEY_EVENT_LIST = "keyEvents";
    public static final String EXTRA_ORIENTATION = "orientation";
    public static final String EXTRA_SYSTEM_UI_VISIBILITY = "systemUiVisibility";
    public static final String EXTRA_VIEWS = "views";
    protected AdUnitActivityController _controller;

    public AdUnitActivity() {
        new Activity();
        return;
    }

    protected AdUnitActivityController createController() {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new AdUnitViewHandlerFactory();
        new AdUnitActivityController(this, SharedInstances.getWebViewEventSender(..), new AdUnitViewHandlerFactory(..));
        return new AdUnitActivityController(..);
    }

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    public AdUnitRelativeLayout getLayout() {
        _controller.getLayout();
        return AdUnitActivityController.getLayout(..);
    }

    public Map getViewFrame(String p0) {
        _controller.getViewFrame(p0);
        return AdUnitActivityController.getViewFrame(..);
    }

    public IAdUnitViewHandler getViewHandler(String p0) {
        _controller.getViewHandler(p0);
        return AdUnitActivityController.getViewHandler(..);
    }

    public String[] getViews() {
        _controller.getViews();
        return AdUnitActivityController.getViews(..);
    }

    protected void onCreate(Bundle p0) {
        Activity.onCreate(p0);
        AdUnitActivity.createController();
        _controller = AdUnitActivity.createController(..);
        AdUnitActivity.createController(..).onCreate(p0);
        return;
    }

    protected void onDestroy() {
        if (if-eqz(_controller)) goto L_7;
        _controller.onDestroy();
      L_7:
        Activity.onDestroy();
        return;
    }

    public boolean onKeyDown(int p0, KeyEvent p1) {
        _controller.onKeyDown(p0, p1);
        return AdUnitActivityController.onKeyDown(..);
    }

    protected void onPause() {
        Activity.onPause();
        _controller.onPause();
        return;
    }

    public void onRequestPermissionsResult(int p0, String[] p1, int[] p2) {
        _controller.onRequestPermissionsResult(p0, p1, p2);
        return;
    }

    protected void onResume() {
        Activity.onResume();
        _controller.onResume();
        return;
    }

    public void onSaveInstanceState(Bundle p0) {
        Activity.onSaveInstanceState(p0);
        _controller.onSaveInstanceState(p0);
        return;
    }

    protected void onStart() {
        Activity.onStart();
        _controller.onStart();
        return;
    }

    protected void onStop() {
        Activity.onStop();
        _controller.onStop();
        return;
    }

    public void onWindowFocusChanged(boolean p0) {
        _controller.onWindowFocusChanged(p0);
        Activity.onWindowFocusChanged(p0);
        return;
    }

    public boolean setKeepScreenOn(boolean p0) {
        _controller.setKeepScreenOn(p0);
        return AdUnitActivityController.setKeepScreenOn(..);
    }

    public void setKeyEventList(ArrayList p0) {
        _controller.setKeyEventList(p0);
        return;
    }

    public void setLayoutInDisplayCutoutMode(int p0) {
        _controller.setLayoutInDisplayCutoutMode(p0);
        return;
    }

    public void setOrientation(int p0) {
        _controller.setOrientation(p0);
        return;
    }

    public boolean setSystemUiVisibility(int p0) {
        _controller.setSystemUiVisibility(p0);
        return AdUnitActivityController.setSystemUiVisibility(..);
    }

    public void setViewFrame(String p0, int p1, int p2, int p3, int p4) {
        _controller.setViewFrame(p0, p1, p2, p3, p4);
        return;
    }

    public void setViews(String[] p0) {
        _controller.setViews(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitActivityController
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitActivityController {
    private int _activityId;
    private final IAdUnitActivity _adUnitActivity;
    private final IAdUnitViewHandlerFactory _adUnitViewHandlerFactory;
    private int _displayCutoutMode;
    private final IEventSender _eventSender;
    boolean _keepScreenOn;
    private ArrayList _keyEventList;
    protected AdUnitRelativeLayout _layout;
    private int _orientation;
    private int _systemUiVisibility;
    private Map _viewHandlers;
    private String[] _views;

    public AdUnitActivityController(IAdUnitActivity p0, IEventSender p1, IAdUnitViewHandlerFactory p2) {
        new Object();
        _orientation = -1;
        _adUnitActivity = p0;
        _eventSender = p1;
        _adUnitViewHandlerFactory = p2;
        return;
    }

    private IAdUnitViewHandler createViewHandler(String p0) {
        _adUnitViewHandlerFactory.createViewHandler(p0);
        return IAdUnitViewHandlerFactory.createViewHandler(..);
    }

    private boolean handleViewPlacement(View p0) {
        if (if-nez(p0)) goto L_e;
        _adUnitActivity.finish();
        DeviceLog.error("Could not place view because it is null, finishing activity");
        return 0;
      L_e:
        View.getParent();
        if (if-eqz(View.getParent(..))) goto L_26;
        View.getParent();
        View.getParent(..).equals(_layout);
        if (if-eqz(Object.equals(..))) goto L_26;
        _layout.bringChildToFront("Could not place view because it is null, finishing activity");
      L_26:
        ViewUtilities.removeViewFromParent("Could not place view because it is null, finishing activity");
        new RelativeLayout$LayoutParams(-1, -1);
        new RelativeLayout$LayoutParams(..).addRule(13);
        new RelativeLayout$LayoutParams(..).setMargins(_layout, _layout, _layout, _layout);
        View.setPadding(_layout, _layout, _layout, _layout);
        _layout.addView("Could not place view because it is null, finishing activity", new RelativeLayout$LayoutParams(..));
      L_3f:
        return 1;
    }

    protected void createLayout() {
        if (if-eqz(_layout)) goto L_5;
        return;
      L_5:
        _adUnitActivity.getContext();
        new AdUnitRelativeLayout(IAdUnitActivity.getContext(..));
        _layout = new AdUnitRelativeLayout(..);
        new RelativeLayout$LayoutParams(-1, -1);
        new AdUnitRelativeLayout(..).setLayoutParams(new RelativeLayout$LayoutParams(..));
        new ColorDrawable(0xff000000);
        ViewUtilities.setBackground(_layout, new ColorDrawable(..));
        return;
    }

    public AdUnitRelativeLayout getLayout() {
        return _layout;
    }

    public Map getViewFrame(String p0) {
        AdUnitActivityController.getViewHandler(p0);
        p0.equals("adunit");
        if (if-eqz(String.equals(..))) goto L_4e;
        _layout.getLayoutParams();
        new HashMap();
        Integer.valueOf(leftMargin);
        new HashMap(..).put("x", Integer.valueOf(..));
        Integer.valueOf(topMargin);
        new HashMap(..).put("y", Integer.valueOf(..));
        _layout.getWidth();
        Integer.valueOf(AdUnitRelativeLayout.getWidth(..));
        new HashMap(..).put("width", Integer.valueOf(..));
        _layout.getHeight();
        Integer.valueOf(AdUnitRelativeLayout.getHeight(..));
        new HashMap(..).put("height", Integer.valueOf(..));
        return new HashMap(..);
      L_4e:
        if (if-eqz(new HashMap(..))) goto L_56;
        new HashMap(..).getView();
      L_56:
      L_57:
        if (if-eqz(0)) goto L_8d;
        0.getLayoutParams();
        new HashMap();
        Integer.valueOf(leftMargin);
        new HashMap(..).put("x", Integer.valueOf(..));
        Integer.valueOf(topMargin);
        new HashMap(..).put("y", Integer.valueOf(..));
        0.getWidth();
        Integer.valueOf(View.getWidth(..));
        new HashMap(..).put("width", Integer.valueOf(..));
        0.getHeight();
        Integer.valueOf(View.getHeight(..));
        new HashMap(..).put("height", Integer.valueOf(..));
        return new HashMap(..);
      L_8d:
        return Integer.valueOf(..);
    }

    public IAdUnitViewHandler getViewHandler(String p0) {
        if (if-eqz(_viewHandlers)) goto L_13;
        _viewHandlers.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_13;
        _viewHandlers.get(p0);
      L_13:
        AdUnitActivityController.createViewHandler(Map.get(..));
        if (if-eqz(AdUnitActivityController.createViewHandler(..))) goto L_29;
        if (if-nez(_viewHandlers)) goto L_24;
        new HashMap();
        _viewHandlers = new HashMap(..);
      L_24:
        _viewHandlers.put(Map.get(..), AdUnitActivityController.createViewHandler(..));
      L_29:
      L_2a:
        return AdUnitActivityController.createViewHandler(..);
    }

    public String[] getViews() {
        return _views;
    }

    public void onCreate(Bundle p0) {
        _eventSender.canSend();
        if (if-nez(IEventSender.canSend(..))) goto L_13;
        DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onCreate");
        _adUnitActivity.finish();
        return;
      L_13:
        AdUnit.setAdUnitActivity(_adUnitActivity);
        _adUnitActivity.getActivity();
        Intent.setActiveActivity(IAdUnitActivity.getActivity(..));
        AdUnitActivityController.createLayout();
        ViewUtilities.removeViewFromParent(_layout);
        _layout.getLayoutParams();
        _adUnitActivity.addContentView(_layout, AdUnitRelativeLayout.getLayoutParams(..));
        if (if-nez(_adUnitActivity)) goto L_bf;
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).getStringArrayExtra("views");
        _views = Intent.getStringArrayExtra(..);
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).getIntegerArrayListExtra("keyEvents");
        _keyEventList = Intent.getIntegerArrayListExtra(..);
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).hasExtra("orientation");
        if (if-eqz(Intent.hasExtra(..))) goto L_74;
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).getIntExtra("orientation", -1);
        _orientation = Intent.getIntExtra(..);
      L_74:
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).hasExtra("systemUiVisibility");
        if (if-eqz(Intent.hasExtra(..))) goto L_8c;
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).getIntExtra("systemUiVisibility", 0);
        _systemUiVisibility = Intent.getIntExtra(..);
      L_8c:
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).hasExtra("activityId");
        if (if-eqz(Intent.hasExtra(..))) goto L_a4;
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).getIntExtra("activityId", -1);
        _activityId = Intent.getIntExtra(..);
      L_a4:
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).hasExtra("displayCutoutMode");
        if (if-eqz(Intent.hasExtra(..))) goto L_bc;
        _adUnitActivity.getIntent();
        IAdUnitActivity.getIntent(..).getIntExtra("displayCutoutMode", 0);
        _displayCutoutMode = Intent.getIntExtra(..);
      L_bc:
      L_bf:
        _adUnitActivity.getStringArray(IAdUnitActivity.getIntent(..));
        _views = Bundle.getStringArray(..);
        _adUnitActivity.getInt("orientation", -1);
        _orientation = Bundle.getInt(..);
        _adUnitActivity.getInt("systemUiVisibility", 0);
        _systemUiVisibility = Bundle.getInt(..);
        _adUnitActivity.getIntegerArrayList(AdUnitEvent.ON_CREATE);
        _keyEventList = Bundle.getIntegerArrayList(..);
        _adUnitActivity.getBoolean("keepScreenOn");
        _keepScreenOn = Bundle.getBoolean(..);
        _adUnitActivity.getInt("activityId", -1);
        _activityId = Bundle.getInt(..);
        _adUnitActivity.getInt("displayCutoutMode", 0);
        _displayCutoutMode = Bundle.getInt(..);
        AdUnitActivityController.setKeepScreenOn(_keepScreenOn);
      L_f2:
        AdUnitActivityController.setOrientation(_orientation);
        AdUnitActivityController.setSystemUiVisibility(_systemUiVisibility);
        AdUnitActivityController.setLayoutInDisplayCutoutMode(_displayCutoutMode);
        if (if-eqz(_views)) goto L_119;
      L_107:
        if (if-ge(0, "displayCutoutMode")) goto L_119;
        AdUnitActivityController.getViewHandler("systemUiVisibility");
        if (if-eqz(AdUnitActivityController.getViewHandler(..))) goto L_116;
        IAdUnitViewHandler.onCreate(_adUnitActivity, _adUnitActivity);
      L_116:
      L_119:
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_RESTORE, 1);
        return;
    }

    public void onDestroy() {
        _eventSender.canSend();
        if (if-nez(IEventSender.canSend(..))) goto L_1b;
        _adUnitActivity.isFinishing();
        if (if-nez(IAdUnitActivity.isFinishing(..))) goto L_1a;
        DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onDestroy");
        _adUnitActivity.finish();
      L_1a:
        return;
      L_1b:
        _adUnitActivity.isFinishing();
        Boolean.valueOf(IAdUnitActivity.isFinishing(..));
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_DESTROY, 2);
        if (if-eqz(_viewHandlers)) goto L_67;
        _viewHandlers.entrySet();
        Map.entrySet(..).iterator();
      L_49:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_67;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        if (if-eqz(Map$Entry.getValue(..))) goto L_49;
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).onDestroy(_adUnitActivity);
      L_67:
        AdUnit.getCurrentAdUnitActivityId();
        if (if-ne(AdUnit.getCurrentAdUnitActivityId(..), _activityId)) goto L_73;
        AdUnit.setAdUnitActivity(0);
      L_73:
        _adUnitActivity.getActivity();
        Intent.removeActiveActivity(IAdUnitActivity.getActivity(..));
        return;
    }

    public boolean onKeyDown(int p0, KeyEvent p1) {
        if (if-eqz(_keyEventList)) goto L_4b;
        Integer.valueOf(p0);
        _keyEventList.contains(Integer.valueOf(..));
        if (if-eqz(ArrayList.contains(..))) goto L_4b;
        Integer.valueOf(p0);
        p1.getEventTime();
        Long.valueOf(KeyEvent.getEventTime(..), v6);
        p1.getDownTime();
        Long.valueOf(KeyEvent.getDownTime(..), v6);
        p1.getRepeatCount();
        Integer.valueOf(KeyEvent.getRepeatCount(..));
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.KEY_DOWN, 5);
      L_4b:
        return 1;
    }

    public void onPause() {
        _eventSender.canSend();
        if (if-nez(IEventSender.canSend(..))) goto L_1b;
        _adUnitActivity.isFinishing();
        if (if-nez(IAdUnitActivity.isFinishing(..))) goto L_1a;
        DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onPause");
        _adUnitActivity.finish();
      L_1a:
        return;
      L_1b:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebView();
        if (if-nez(WebViewApp.getWebView(..))) goto L_2b;
        DeviceLog.warning("Unity Ads web view is null, from onPause");
      L_2b:
        _adUnitActivity.isFinishing();
        if (if-eqz(IAdUnitActivity.isFinishing(..))) goto L_3e;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebView();
        ViewUtilities.removeViewFromParent(WebViewApp.getWebView(..));
      L_3e:
        if (if-eqz(_viewHandlers)) goto L_68;
        _viewHandlers.entrySet();
        Map.entrySet(..).iterator();
      L_4a:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_68;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        if (if-eqz(Map$Entry.getValue(..))) goto L_4a;
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).onPause(_adUnitActivity);
      L_68:
        _adUnitActivity.isFinishing();
        Boolean.valueOf(IAdUnitActivity.isFinishing(..));
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_PAUSE, 2);
        return;
    }

    public void onRequestPermissionsResult(int p0, String[] p1, int[] p2) {
        new JSONArray();
        new JSONArray();
      L_e:
        if (if-ge(0, v4)) goto L_18;
        new JSONArray(..).put(v6);
      L_18:
      L_1a:
        if (if-ge(0, p1)) goto L_24;
        new JSONArray(..).put(0);
      L_24:
        Integer.valueOf(p0);
        _eventSender.sendEvent(WebViewEventCategory.PERMISSIONS, PermissionsEvent.PERMISSIONS_RESULT, 3);
        2.getMessage();
        _eventSender.sendEvent(WebViewEventCategory.PERMISSIONS, PermissionsEvent.PERMISSIONS_ERROR, 1);
      L_4e:
        return;
    }

    public void onResume() {
        _eventSender.canSend();
        if (if-nez(IEventSender.canSend(..))) goto L_1b;
        _adUnitActivity.isFinishing();
        if (if-nez(IAdUnitActivity.isFinishing(..))) goto L_1a;
        DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onResume");
        _adUnitActivity.finish();
      L_1a:
        return;
      L_1b:
        AdUnitActivityController.setViews(_views);
        if (if-eqz(_viewHandlers)) goto L_4a;
        _viewHandlers.entrySet();
        Map.entrySet(..).iterator();
      L_2c:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_4a;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        if (if-eqz(Map$Entry.getValue(..))) goto L_2c;
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).onResume(_adUnitActivity);
      L_4a:
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_RESUME, 1);
        return;
    }

    public void onSaveInstanceState(Bundle p0) {
        p0.putInt("orientation", _orientation);
        p0.putInt("systemUiVisibility", _systemUiVisibility);
        p0.putIntegerArrayList("keyEvents", _keyEventList);
        p0.putBoolean("keepScreenOn", _keepScreenOn);
        p0.putStringArray("views", _views);
        p0.putInt("activityId", _activityId);
        return;
    }

    public void onStart() {
        _eventSender.canSend();
        if (if-nez(IEventSender.canSend(..))) goto L_1b;
        _adUnitActivity.isFinishing();
        if (if-nez(IAdUnitActivity.isFinishing(..))) goto L_1a;
        DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onStart");
        _adUnitActivity.finish();
      L_1a:
        return;
      L_1b:
        if (if-eqz(_viewHandlers)) goto L_45;
        _viewHandlers.entrySet();
        Map.entrySet(..).iterator();
      L_27:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_45;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        if (if-eqz(Map$Entry.getValue(..))) goto L_27;
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).onStart(_adUnitActivity);
      L_45:
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_START, 1);
        return;
    }

    public void onStop() {
        _eventSender.canSend();
        if (if-nez(IEventSender.canSend(..))) goto L_1b;
        _adUnitActivity.isFinishing();
        if (if-nez(IAdUnitActivity.isFinishing(..))) goto L_1a;
        DeviceLog.error("Unity Ads web app is null, closing Unity Ads activity from onStop");
        _adUnitActivity.finish();
      L_1a:
        return;
      L_1b:
        if (if-eqz(_viewHandlers)) goto L_45;
        _viewHandlers.entrySet();
        Map.entrySet(..).iterator();
      L_27:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_45;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        if (if-eqz(Map$Entry.getValue(..))) goto L_27;
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).onStop(_adUnitActivity);
      L_45:
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_STOP, 1);
        return;
    }

    public void onWindowFocusChanged(boolean p0) {
        if (if-eqz(p0)) goto L_18;
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_FOCUS_GAINED, 1);
      L_18:
        Integer.valueOf(_activityId);
        _eventSender.sendEvent(WebViewEventCategory.ADUNIT, AdUnitEvent.ON_FOCUS_LOST, 1);
      L_2b:
        return;
    }

    public boolean setKeepScreenOn(boolean p0) {
        _keepScreenOn = p0;
        _adUnitActivity.getWindow();
        if (if-nez(IAdUnitActivity.getWindow(..))) goto L_c;
        return 0;
      L_c:
        if (if-eqz(0)) goto L_1a;
        _adUnitActivity.getWindow();
        IAdUnitActivity.getWindow(..).addFlags(128);
      L_1a:
        _adUnitActivity.getWindow();
        IAdUnitActivity.getWindow(..).clearFlags(128);
      L_23:
        return 1;
    }

    public void setKeyEventList(ArrayList p0) {
        _keyEventList = p0;
        return;
    }

    public void setLayoutInDisplayCutoutMode(int p0) {
        _displayCutoutMode = p0;
        if (if-lt(Build$VERSION.SDK_INT, 28)) goto L_3f;
        _adUnitActivity.getWindow();
        if (if-eqz(IAdUnitActivity.getWindow(..))) goto L_3f;
        _adUnitActivity.getWindow();
        IAdUnitActivity.getWindow(..).getAttributes();
        Window.getAttributes(..).getClass();
        Object.getClass(..).getField("layoutInDisplayCutoutMode");
        Class.getField(..).setInt(Window.getAttributes(..), p0);
        DeviceLog.debug("Error getting layoutInDisplayCutoutMode", Window.getAttributes(..));
        DeviceLog.debug("Error setting layoutInDisplayCutoutMode", Window.getAttributes(..));
      L_3f:
        return;
    }

    public void setOrientation(int p0) {
        _orientation = p0;
        _adUnitActivity.setRequestedOrientation(p0);
        return;
    }

    public boolean setSystemUiVisibility(int p0) {
        _systemUiVisibility = p0;
        _adUnitActivity.getWindow();
        IAdUnitActivity.getWindow(..).getDecorView();
        Window.getDecorView(..).setSystemUiVisibility(p0);
        return 1;
        DeviceLog.exception("Error while setting SystemUIVisibility", 1);
        return 0;
    }

    public void setViewFrame(String p0, int p1, int p2, int p3, int p4) {
        AdUnitActivityController.getViewHandler(p0);
        p0.equals("adunit");
        if (if-eqz(String.equals(..))) goto L_1b;
        new FrameLayout$LayoutParams(p3, p4);
        new FrameLayout$LayoutParams(..).setMargins(p1, p2, 0, 0);
        _layout.setLayoutParams(new FrameLayout$LayoutParams(..));
      L_1b:
        if (if-eqz(_layout)) goto L_22;
        _layout.getView();
      L_22:
      L_23:
        if (if-eqz(0)) goto L_30;
        new RelativeLayout$LayoutParams(p3, p4);
        new RelativeLayout$LayoutParams(..).setMargins(p1, p2, 0, 0);
        0.setLayoutParams(new RelativeLayout$LayoutParams(..));
      L_30:
        return;
    }

    public void setViews(String[] p0) {
        if (if-nez(p0)) goto L_5;
      L_5:
        Arrays.asList(p0);
        new ArrayList(Arrays.asList(..));
        if (if-nez(_views)) goto L_16;
        _views = _views;
      L_16:
        Arrays.asList(_views);
        new ArrayList(Arrays.asList(..));
        new ArrayList(..).removeAll(new ArrayList(..));
        new ArrayList(..).iterator();
      L_28:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_3c;
        ArrayList.iterator(..).next();
        AdUnitActivityController.getViewHandler(Iterator.next(..));
        IAdUnitViewHandler.destroy();
      L_3c:
        _views = p0;
      L_3f:
        if (if-ge(0, ArrayList.iterator(..))) goto L_5d;
        if (if-nez(AdUnitActivityController.getViewHandler(..))) goto L_46;
      L_46:
        AdUnitActivityController.getViewHandler(AdUnitActivityController.getViewHandler(..));
        IAdUnitViewHandler.create(_adUnitActivity);
        IAdUnitViewHandler.getView();
        AdUnitActivityController.handleViewPlacement(IAdUnitViewHandler.getView(..));
        if (if-nez(AdUnitActivityController.handleViewPlacement(..))) goto L_5a;
        return;
      L_5a:
      L_5d:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitError
// ============================================================
package com.unity3d.services.ads.adunit;

public final class AdUnitError extends Enum {
    private static final AdUnitError[] $VALUES;
    public static final AdUnitError ACTIVITY_ID;
    public static final AdUnitError ADUNIT_NULL;
    public static final AdUnitError API_LEVEL_ERROR;
    public static final AdUnitError CORRUPTED_KEYEVENTLIST;
    public static final AdUnitError CORRUPTED_VIEWLIST;
    public static final AdUnitError DISPLAY_CUTOUT_INVOKE_FAILED;
    public static final AdUnitError DISPLAY_CUTOUT_JSON_ERROR;
    public static final AdUnitError DISPLAY_CUTOUT_METHOD_NOT_AVAILABLE;
    public static final AdUnitError GENERIC;
    public static final AdUnitError LAYOUT_NULL;
    public static final AdUnitError MAX_MOTION_EVENT_COUNT_REACHED;
    public static final AdUnitError NO_DISPLAY_CUTOUT_AVAILABLE;
    public static final AdUnitError ORIENTATION;
    public static final AdUnitError SCREENVISIBILITY;
    public static final AdUnitError SYSTEM_UI_VISIBILITY;
    public static final AdUnitError UNKNOWN_VIEW;

    private static AdUnitError[] $values() {
        return 16;
    }

    static <clinit>() {
        new AdUnitError("ADUNIT_NULL", 0);
        ADUNIT_NULL = new AdUnitError(..);
        new AdUnitError("ACTIVITY_ID", 1);
        ACTIVITY_ID = new AdUnitError(..);
        new AdUnitError("GENERIC", 2);
        GENERIC = new AdUnitError(..);
        new AdUnitError("ORIENTATION", 3);
        ORIENTATION = new AdUnitError(..);
        new AdUnitError("SCREENVISIBILITY", 4);
        SCREENVISIBILITY = new AdUnitError(..);
        new AdUnitError("CORRUPTED_VIEWLIST", 5);
        CORRUPTED_VIEWLIST = new AdUnitError(..);
        new AdUnitError("CORRUPTED_KEYEVENTLIST", 6);
        CORRUPTED_KEYEVENTLIST = new AdUnitError(..);
        new AdUnitError("SYSTEM_UI_VISIBILITY", 7);
        SYSTEM_UI_VISIBILITY = new AdUnitError(..);
        new AdUnitError("UNKNOWN_VIEW", 8);
        UNKNOWN_VIEW = new AdUnitError(..);
        new AdUnitError("LAYOUT_NULL", 9);
        LAYOUT_NULL = new AdUnitError(..);
        new AdUnitError("MAX_MOTION_EVENT_COUNT_REACHED", 10);
        MAX_MOTION_EVENT_COUNT_REACHED = new AdUnitError(..);
        new AdUnitError("API_LEVEL_ERROR", 11);
        API_LEVEL_ERROR = new AdUnitError(..);
        new AdUnitError("NO_DISPLAY_CUTOUT_AVAILABLE", 12);
        NO_DISPLAY_CUTOUT_AVAILABLE = new AdUnitError(..);
        new AdUnitError("DISPLAY_CUTOUT_METHOD_NOT_AVAILABLE", 13);
        DISPLAY_CUTOUT_METHOD_NOT_AVAILABLE = new AdUnitError(..);
        new AdUnitError("DISPLAY_CUTOUT_JSON_ERROR", 14);
        DISPLAY_CUTOUT_JSON_ERROR = new AdUnitError(..);
        new AdUnitError("DISPLAY_CUTOUT_INVOKE_FAILED", 15);
        DISPLAY_CUTOUT_INVOKE_FAILED = new AdUnitError(..);
        AdUnitError.$values();
        $VALUES = AdUnitError.$values(..);
        return;
    }

    private AdUnitError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static AdUnitError valueOf(String p0) {
        Enum.valueOf(AdUnitError.class, p0);
        return Enum.valueOf(..);
    }

    public static AdUnitError[] values() {
        AdUnitError.$VALUES.clone();
        return AdUnitError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitEvent
// ============================================================
package com.unity3d.services.ads.adunit;

public final class AdUnitEvent extends Enum {
    private static final AdUnitEvent[] $VALUES;
    public static final AdUnitEvent KEY_DOWN;
    public static final AdUnitEvent ON_CREATE;
    public static final AdUnitEvent ON_DESTROY;
    public static final AdUnitEvent ON_FOCUS_GAINED;
    public static final AdUnitEvent ON_FOCUS_LOST;
    public static final AdUnitEvent ON_PAUSE;
    public static final AdUnitEvent ON_RESTORE;
    public static final AdUnitEvent ON_RESUME;
    public static final AdUnitEvent ON_START;
    public static final AdUnitEvent ON_STOP;

    private static AdUnitEvent[] $values() {
        return 10;
    }

    static <clinit>() {
        new AdUnitEvent("ON_START", 0);
        ON_START = new AdUnitEvent(..);
        new AdUnitEvent("ON_CREATE", 1);
        ON_CREATE = new AdUnitEvent(..);
        new AdUnitEvent("ON_RESUME", 2);
        ON_RESUME = new AdUnitEvent(..);
        new AdUnitEvent("ON_DESTROY", 3);
        ON_DESTROY = new AdUnitEvent(..);
        new AdUnitEvent("ON_PAUSE", 4);
        ON_PAUSE = new AdUnitEvent(..);
        new AdUnitEvent("KEY_DOWN", 5);
        KEY_DOWN = new AdUnitEvent(..);
        new AdUnitEvent("ON_RESTORE", 6);
        ON_RESTORE = new AdUnitEvent(..);
        new AdUnitEvent("ON_STOP", 7);
        ON_STOP = new AdUnitEvent(..);
        new AdUnitEvent("ON_FOCUS_GAINED", 8);
        ON_FOCUS_GAINED = new AdUnitEvent(..);
        new AdUnitEvent("ON_FOCUS_LOST", 9);
        ON_FOCUS_LOST = new AdUnitEvent(..);
        AdUnitEvent.$values();
        $VALUES = AdUnitEvent.$values(..);
        return;
    }

    private AdUnitEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static AdUnitEvent valueOf(String p0) {
        Enum.valueOf(AdUnitEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static AdUnitEvent[] values() {
        AdUnitEvent.$VALUES.clone();
        return AdUnitEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitMotionEvent
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitMotionEvent {
    private int _action;
    private int _deviceId;
    private long _eventTime;
    private boolean _isObscured;
    private float _pressure;
    private float _size;
    private int _source;
    private int _toolType;
    private float _x;
    private float _y;

    public AdUnitMotionEvent(int p0, boolean p1, int p2, int p3, int p4, float p5, float p6, long p7, float p8, float p9) {
        new Object();
        _action = p0;
        _isObscured = p1;
        _toolType = p2;
        _source = p3;
        _deviceId = p4;
        _x = p5;
        _y = p6;
        _eventTime = p7;
        _pressure = p8;
        _size = p9;
        return;
    }

    public int getAction() {
        return _action;
    }

    public int getDeviceId() {
        return _deviceId;
    }

    public long getEventTime() {
        return _eventTime;
    }

    public float getPressure() {
        return _pressure;
    }

    public float getSize() {
        return _size;
    }

    public int getSource() {
        return _source;
    }

    public int getToolType() {
        return _toolType;
    }

    public float getX() {
        return _x;
    }

    public float getY() {
        return _y;
    }

    public boolean isObscured() {
        return _isObscured;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitOpen
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitOpen {
    private static Configuration _configuration;
    private static final SDKMetricsSender _sdkMetricsSender;
    private static ConditionVariable _waitShowStatus;

    static <clinit>() {
        Utilities.getService(SDKMetricsSender.class);
        _sdkMetricsSender = Utilities.getService(..);
        return;
    }

    public AdUnitOpen() {
        new Object();
        return;
    }

    public static boolean open(String p0, JSONObject p1) {
        AdUnitOpen.class.getMethod("showCallback", v4);
        new ConditionVariable();
        _waitShowStatus = new ConditionVariable(..);
        if (if-nez(AdUnitOpen._configuration)) goto L_25;
        new Configuration();
        _configuration = new Configuration(..);
      L_25:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).invokeMethod("webview", "show", Class.getMethod(..), 2);
        AdUnitOpen._configuration.getShowTimeout();
        AdUnitOpen._waitShowStatus.block(Class.getMethod(..), WebViewApp.getCurrentApp(..));
        _waitShowStatus = 0;
        if (if-nez(ConditionVariable.block(..))) goto L_5f;
        AdUnitOpen._configuration.getShowTimeout();
        Long.valueOf(Configuration.getShowTimeout(..), 1);
        AdOperationMetric.newAdShowFailure(AdOperationError.timeout, Long.valueOf(..));
        AdUnitOpen._sdkMetricsSender.sendMetric(AdOperationMetric.newAdShowFailure(..));
      L_5f:
        return ConditionVariable.block(..);
        throw ConditionVariable.block(..);
    }

    public static void setConfiguration(Configuration p0) {
        _configuration = p0;
        return;
    }

    public static void showCallback(CallbackStatus p0) {
        if (if-eqz(AdUnitOpen._waitShowStatus)) goto L_11;
        p0.equals(CallbackStatus.OK);
        if (if-eqz(CallbackStatus.equals(..))) goto L_11;
        AdUnitOpen._waitShowStatus.open();
      L_11:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitRelativeLayout
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitRelativeLayout extends RelativeLayout {
    private InputEvent _lastInputEvent;
    private int _maxEvents;
    private final ArrayList _motionEvents;
    private boolean _shouldCapture;

    public AdUnitRelativeLayout(Context p0) {
        new RelativeLayout(p0);
        new ArrayList();
        _motionEvents = new ArrayList(..);
        _maxEvents = 10000;
        _shouldCapture = 0;
        return;
    }

    public void clearCapture() {
        _motionEvents.clear();
        return;
        throw _motionEvents;
    }

    public void endCapture() {
        _shouldCapture = 0;
        return;
    }

    public int getCurrentEventCount() {
        _motionEvents.size();
        return ArrayList.size(..);
        throw ArrayList.size(..);
    }

    public SparseIntArray getEventCount(ArrayList p0) {
        new SparseIntArray();
        _motionEvents.iterator();
      L_e:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_47;
        ArrayList.iterator(..).next();
        p0.iterator();
      L_1e:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_e;
        ArrayList.iterator(..).next();
        Iterator.next(..).getAction();
        Iterator.next(..).intValue();
        if (if-ne(AdUnitMotionEvent.getAction(..), Integer.intValue(..))) goto L_1e;
        Iterator.next(..).intValue();
        Iterator.next(..).intValue();
        new SparseIntArray(..).get(Integer.intValue(..), 0);
        new SparseIntArray(..).put(Integer.intValue(..), SparseIntArray.get(..));
      L_47:
        return new SparseIntArray(..);
        throw p0;
    }

    public SparseArray getEvents(SparseArray p0) {
        new SparseIntArray();
        new SparseArray();
        _motionEvents.iterator();
      L_13:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_78;
        ArrayList.iterator(..).next();
        Iterator.next(..).getAction();
        p0.get(AdUnitMotionEvent.getAction(..));
        if (if-eqz(SparseArray.get(..))) goto L_13;
        SparseArray.get(..).get(0);
        ArrayList.get(..).intValue();
        Iterator.next(..).getAction();
        new SparseIntArray(..).get(AdUnitMotionEvent.getAction(..), 0);
        if (if-ne(SparseIntArray.get(..), Integer.intValue(..))) goto L_66;
        Iterator.next(..).getAction();
        new SparseArray(..).get(AdUnitMotionEvent.getAction(..));
        if (if-nez(SparseArray.get(..))) goto L_56;
        Iterator.next(..).getAction();
        new SparseArray();
        new SparseArray(..).put(AdUnitMotionEvent.getAction(..), new SparseArray(..));
      L_56:
        Iterator.next(..).getAction();
        new SparseArray(..).get(AdUnitMotionEvent.getAction(..));
        SparseArray.get(..).put(Integer.intValue(..), Iterator.next(..));
        SparseArray.get(..).remove(0);
      L_66:
        Iterator.next(..).getAction();
        Iterator.next(..).getAction();
        new SparseIntArray(..).get(AdUnitMotionEvent.getAction(..));
        new SparseIntArray(..).put(AdUnitMotionEvent.getAction(..), SparseIntArray.get(..));
      L_78:
        return new SparseArray(..);
        throw p0;
    }

    public InputEvent getLastInputEvent() {
        return _lastInputEvent;
    }

    public int getMaxEventCount() {
        return _maxEvents;
    }

    public boolean onInterceptTouchEvent(MotionEvent p0) {
        RelativeLayout.onInterceptTouchEvent(p0);
        p0.getActionMasked();
        if (if-eq(MotionEvent.getActionMasked(..), 1)) goto L_22;
        p0.getActionMasked();
        if (if-eqz(MotionEvent.getActionMasked(..))) goto L_22;
        p0.getActionMasked();
        if (if-eq(MotionEvent.getActionMasked(..), 6)) goto L_22;
        p0.getActionMasked();
        if (if-ne(MotionEvent.getActionMasked(..), 5)) goto L_24;
      L_22:
        _lastInputEvent = p0;
      L_24:
        if (if-eqz(_shouldCapture)) goto L_7a;
        _motionEvents.size();
        if (if-ge(ArrayList.size(..), _maxEvents)) goto L_7a;
        p0.getFlags();
        if (if-eqz(MotionEvent.getFlags(..))) goto L_3c;
      L_3c:
      L_3d:
        p0.getActionMasked();
        p0.getToolType(0);
        p0.getSource();
        p0.getDeviceId();
        p0.getX(0);
        p0.getY(0);
        p0.getEventTime();
        p0.getPressure(0);
        p0.getSize(0);
        new AdUnitMotionEvent(MotionEvent.getActionMasked(..), 0, MotionEvent.getToolType(..), MotionEvent.getSource(..), MotionEvent.getDeviceId(..), MotionEvent.getX(..), MotionEvent.getY(..), MotionEvent.getEventTime(..), v14, MotionEvent.getPressure(..), MotionEvent.getSize(..));
        _motionEvents.add(new AdUnitMotionEvent);
        throw 0;
      L_7a:
      L_7b:
        return new AdUnitMotionEvent;
    }

    public void startCapture(int p0) {
        _maxEvents = p0;
        _shouldCapture = 1;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitSoftwareActivity
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitSoftwareActivity extends AdUnitActivity {
    public AdUnitSoftwareActivity() {
        new AdUnitActivity();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitTransparentActivity
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitTransparentActivity extends AdUnitActivity {
    public AdUnitTransparentActivity() {
        new AdUnitActivity();
        return;
    }

    protected AdUnitActivityController createController() {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new AdUnitViewHandlerFactory();
        new AdUnitTransparentActivityController(this, SharedInstances.getWebViewEventSender(..), new AdUnitViewHandlerFactory(..));
        return new AdUnitTransparentActivityController(..);
    }

    protected void onCreate(Bundle p0) {
        AdUnitActivity.onCreate(p0);
        new ColorDrawable(0);
        ViewUtilities.setBackground(_layout, new ColorDrawable(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitTransparentActivityController
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitTransparentActivityController extends AdUnitActivityController {
    public AdUnitTransparentActivityController(IAdUnitActivity p0, IEventSender p1, IAdUnitViewHandlerFactory p2) {
        new AdUnitActivityController(p0, p1, p2);
        return;
    }

    protected void createLayout() {
        AdUnitActivityController.createLayout();
        new ColorDrawable(0);
        ViewUtilities.setBackground(_layout, new ColorDrawable(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitTransparentSoftwareActivity
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitTransparentSoftwareActivity extends AdUnitTransparentActivity {
    public AdUnitTransparentSoftwareActivity() {
        new AdUnitTransparentActivity();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.AdUnitViewHandlerFactory
// ============================================================
package com.unity3d.services.ads.adunit;

public class AdUnitViewHandlerFactory {
    public AdUnitViewHandlerFactory() {
        new Object();
        return;
    }

    public IAdUnitViewHandler createViewHandler(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_52;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        WebViewApp.getConfiguration(..).getModuleConfigurationList();
      L_15:
        if (if-ge(0, v3)) goto L_52;
        WebViewApp.getConfiguration(..).getModuleConfiguration(v5);
        if (if-eqz(v6)) goto L_4f;
        IAdsModuleConfiguration.getAdUnitViewHandlers();
        if (if-eqz(IAdsModuleConfiguration.getAdUnitViewHandlers(..))) goto L_4f;
        Map.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_4f;
        Map.get(p0);
        Map.get(..).newInstance();
        new StringBuilder("Error creating view: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_4e:
        return Class.newInstance(..);
      L_4f:
      L_52:
        return Class.newInstance(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.IAdUnitActivity
// ============================================================
package com.unity3d.services.ads.adunit;

public abstract class IAdUnitActivity {
    public abstract void addContentView(View p0, ViewGroup$LayoutParams p1) {
        // native or abstract
    }

    public abstract void finish() {
        // native or abstract
    }

    public abstract Activity getActivity() {
        // native or abstract
    }

    public abstract Context getContext() {
        // native or abstract
    }

    public abstract Intent getIntent() {
        // native or abstract
    }

    public abstract AdUnitRelativeLayout getLayout() {
        // native or abstract
    }

    public abstract int getRequestedOrientation() {
        // native or abstract
    }

    public abstract Map getViewFrame(String p0) {
        // native or abstract
    }

    public abstract String[] getViews() {
        // native or abstract
    }

    public abstract Window getWindow() {
        // native or abstract
    }

    public abstract boolean isFinishing() {
        // native or abstract
    }

    public abstract void requestPermissions(String[] p0, int p1) {
        // native or abstract
    }

    public abstract boolean setKeepScreenOn(boolean p0) {
        // native or abstract
    }

    public abstract void setKeyEventList(ArrayList p0) {
        // native or abstract
    }

    public abstract void setLayoutInDisplayCutoutMode(int p0) {
        // native or abstract
    }

    public abstract void setOrientation(int p0) {
        // native or abstract
    }

    public abstract void setRequestedOrientation(int p0) {
        // native or abstract
    }

    public abstract boolean setSystemUiVisibility(int p0) {
        // native or abstract
    }

    public abstract void setViewFrame(String p0, int p1, int p2, int p3, int p4) {
        // native or abstract
    }

    public abstract void setViews(String[] p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.IAdUnitViewHandler
// ============================================================
package com.unity3d.services.ads.adunit;

public abstract class IAdUnitViewHandler {
    public abstract boolean create(IAdUnitActivity p0) {
        // native or abstract
    }

    public abstract boolean destroy() {
        // native or abstract
    }

    public abstract View getView() {
        // native or abstract
    }

    public abstract void onCreate(IAdUnitActivity p0, Bundle p1) {
        // native or abstract
    }

    public abstract void onDestroy(IAdUnitActivity p0) {
        // native or abstract
    }

    public abstract void onPause(IAdUnitActivity p0) {
        // native or abstract
    }

    public abstract void onResume(IAdUnitActivity p0) {
        // native or abstract
    }

    public abstract void onStart(IAdUnitActivity p0) {
        // native or abstract
    }

    public abstract void onStop(IAdUnitActivity p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.IAdUnitViewHandlerFactory
// ============================================================
package com.unity3d.services.ads.adunit;

public abstract class IAdUnitViewHandlerFactory {
    public abstract IAdUnitViewHandler createViewHandler(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.PermissionsEvent
// ============================================================
package com.unity3d.services.ads.adunit;

public final class PermissionsEvent extends Enum {
    private static final PermissionsEvent[] $VALUES;
    public static final PermissionsEvent PERMISSIONS_ERROR;
    public static final PermissionsEvent PERMISSIONS_RESULT;

    private static PermissionsEvent[] $values() {
        return 2;
    }

    static <clinit>() {
        new PermissionsEvent("PERMISSIONS_RESULT", 0);
        PERMISSIONS_RESULT = new PermissionsEvent(..);
        new PermissionsEvent("PERMISSIONS_ERROR", 1);
        PERMISSIONS_ERROR = new PermissionsEvent(..);
        PermissionsEvent.$values();
        $VALUES = PermissionsEvent.$values(..);
        return;
    }

    private PermissionsEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static PermissionsEvent valueOf(String p0) {
        Enum.valueOf(PermissionsEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static PermissionsEvent[] values() {
        PermissionsEvent.$VALUES.clone();
        return PermissionsEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.VideoPlayerHandler
// ============================================================
package com.unity3d.services.ads.adunit;

public class VideoPlayerHandler {
    private RelativeLayout _videoContainer;
    private VideoPlayerView _videoView;

    public VideoPlayerHandler() {
        new Object();
        return;
    }

    public boolean create(IAdUnitActivity p0) {
        DeviceLog.entered();
        if (if-nez(_videoContainer)) goto L_12;
        p0.getContext();
        new RelativeLayout(IAdUnitActivity.getContext(..));
        _videoContainer = new RelativeLayout(..);
      L_12:
        if (if-nez(_videoView)) goto L_3d;
        p0.getContext();
        new VideoPlayerView(IAdUnitActivity.getContext(..));
        _videoView = new VideoPlayerView(..);
        new RelativeLayout$LayoutParams(-1, -1);
        new RelativeLayout$LayoutParams(..).addRule(13);
        _videoView.setLayoutParams(new RelativeLayout$LayoutParams(..));
        _videoContainer.addView(_videoView);
        VideoPlayer.setVideoPlayerView(_videoView);
      L_3d:
        return 1;
    }

    public boolean destroy() {
        DeviceLog.entered();
        if (if-eqz(_videoView)) goto L_26;
        _videoView.stopVideoProgressTimer();
        _videoView.stopPlayback();
        ViewUtilities.removeViewFromParent(_videoView);
        VideoPlayer.getVideoPlayerView();
        _videoView.equals(VideoPlayer.getVideoPlayerView(..));
        if (if-eqz(Object.equals(..))) goto L_24;
        VideoPlayer.setVideoPlayerView(0);
      L_24:
        _videoView = 0;
      L_26:
        if (if-eqz(_videoContainer)) goto L_2f;
        ViewUtilities.removeViewFromParent(_videoContainer);
        _videoContainer = 0;
      L_2f:
        return 1;
    }

    public View getView() {
        return _videoContainer;
    }

    public void onCreate(IAdUnitActivity p0, Bundle p1) {
        VideoPlayerHandler.create(p0);
        return;
    }

    public void onDestroy(IAdUnitActivity p0) {
        return;
    }

    public void onPause(IAdUnitActivity p0) {
        VideoPlayerHandler.destroy();
        return;
    }

    public void onResume(IAdUnitActivity p0) {
        return;
    }

    public void onStart(IAdUnitActivity p0) {
        return;
    }

    public void onStop(IAdUnitActivity p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.WebPlayerHandler
// ============================================================
package com.unity3d.services.ads.adunit;

public class WebPlayerHandler {
    private static String webPlayerViewId = "webplayer";
    private WebPlayerView _webPlayerView;

    static <clinit>() {
        return;
    }

    public WebPlayerHandler() {
        new Object();
        return;
    }

    public boolean create(IAdUnitActivity p0) {
        if (if-nez(_webPlayerView)) goto L_33;
        WebPlayerSettingsCache.getInstance();
        p0.getContext();
        WebPlayerSettingsCache.getWebSettings(WebPlayerHandler.webPlayerViewId);
        WebPlayerSettingsCache.getWebPlayerSettings(WebPlayerHandler.webPlayerViewId);
        new WebPlayerView(IAdUnitActivity.getContext(..), WebPlayerHandler.webPlayerViewId, WebPlayerSettingsCache.getWebSettings(..), WebPlayerSettingsCache.getWebPlayerSettings(..));
        _webPlayerView = new WebPlayerView(..);
        WebPlayerSettingsCache.getWebPlayerEventSettings(WebPlayerHandler.webPlayerViewId);
        new WebPlayerView(..).setEventSettings(WebPlayerSettingsCache.getWebPlayerEventSettings(..));
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).addWebPlayer(WebPlayerHandler.webPlayerViewId, _webPlayerView);
      L_33:
        return 1;
    }

    public boolean destroy() {
        if (if-eqz(_webPlayerView)) goto L_c;
        ViewUtilities.removeViewFromParent(_webPlayerView);
        _webPlayerView.destroy();
      L_c:
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).removeWebPlayer(WebPlayerHandler.webPlayerViewId);
        _webPlayerView = 0;
        return 1;
    }

    public View getView() {
        return _webPlayerView;
    }

    public void onCreate(IAdUnitActivity p0, Bundle p1) {
        WebPlayerHandler.create(p0);
        return;
    }

    public void onDestroy(IAdUnitActivity p0) {
        p0.isFinishing();
        if (if-eqz(IAdUnitActivity.isFinishing(..))) goto L_9;
        WebPlayerHandler.destroy();
      L_9:
        return;
    }

    public void onPause(IAdUnitActivity p0) {
        return;
    }

    public void onResume(IAdUnitActivity p0) {
        return;
    }

    public void onStart(IAdUnitActivity p0) {
        return;
    }

    public void onStop(IAdUnitActivity p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.adunit.WebViewHandler
// ============================================================
package com.unity3d.services.ads.adunit;

public class WebViewHandler {
    public WebViewHandler() {
        new Object();
        return;
    }

    public boolean create(IAdUnitActivity p0) {
        return 1;
    }

    public boolean destroy() {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_1b;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebView();
        if (if-eqz(WebViewApp.getWebView(..))) goto L_1b;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebView();
        ViewUtilities.removeViewFromParent(WebViewApp.getWebView(..));
      L_1b:
        return 1;
    }

    public View getView() {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_f;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebView();
        return WebViewApp.getWebView(..);
      L_f:
        return 0;
    }

    public void onCreate(IAdUnitActivity p0, Bundle p1) {
        return;
    }

    public void onDestroy(IAdUnitActivity p0) {
        WebViewHandler.destroy();
        return;
    }

    public void onPause(IAdUnitActivity p0) {
        return;
    }

    public void onResume(IAdUnitActivity p0) {
        return;
    }

    public void onStart(IAdUnitActivity p0) {
        return;
    }

    public void onStop(IAdUnitActivity p0) {
        return;
    }

}

