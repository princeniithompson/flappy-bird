// Package bundle: com.unity3d.services.ads.measurements (5 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.measurements.MeasurementsErrors
// ============================================================
package com.unity3d.services.ads.measurements;

public final class MeasurementsErrors extends Enum {
    private static final MeasurementsErrors[] $VALUES;
    public static final MeasurementsErrors ERROR_AD_SERVICES_DISABLED;
    public static final MeasurementsErrors ERROR_AD_UNIT_NULL;
    public static final MeasurementsErrors ERROR_API_BELOW_33;
    public static final MeasurementsErrors ERROR_EXCEPTION;
    public static final MeasurementsErrors ERROR_EXTENSION_BELOW_4;
    public static final MeasurementsErrors ERROR_LAST_INPUT_EVENT_NULL;
    public static final MeasurementsErrors ERROR_LAYOUT_NULL;
    public static final MeasurementsErrors ERROR_MANAGER_NULL;

    private static final MeasurementsErrors[] $values() {
        return 8;
    }

    static <clinit>() {
        new MeasurementsErrors("ERROR_AD_SERVICES_DISABLED", 0);
        ERROR_AD_SERVICES_DISABLED = new MeasurementsErrors(..);
        new MeasurementsErrors("ERROR_EXTENSION_BELOW_4", 1);
        ERROR_EXTENSION_BELOW_4 = new MeasurementsErrors(..);
        new MeasurementsErrors("ERROR_API_BELOW_33", 2);
        ERROR_API_BELOW_33 = new MeasurementsErrors(..);
        new MeasurementsErrors("ERROR_MANAGER_NULL", 3);
        ERROR_MANAGER_NULL = new MeasurementsErrors(..);
        new MeasurementsErrors("ERROR_EXCEPTION", 4);
        ERROR_EXCEPTION = new MeasurementsErrors(..);
        new MeasurementsErrors("ERROR_AD_UNIT_NULL", 5);
        ERROR_AD_UNIT_NULL = new MeasurementsErrors(..);
        new MeasurementsErrors("ERROR_LAYOUT_NULL", 6);
        ERROR_LAYOUT_NULL = new MeasurementsErrors(..);
        new MeasurementsErrors("ERROR_LAST_INPUT_EVENT_NULL", 7);
        ERROR_LAST_INPUT_EVENT_NULL = new MeasurementsErrors(..);
        MeasurementsErrors.$values();
        $VALUES = MeasurementsErrors.$values(..);
        return;
    }

    private MeasurementsErrors(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static MeasurementsErrors valueOf(String p0) {
        Enum.valueOf(MeasurementsErrors.class, p0);
        return Enum.valueOf(..);
    }

    public static MeasurementsErrors[] values() {
        MeasurementsErrors.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.measurements.MeasurementsEvents
// ============================================================
package com.unity3d.services.ads.measurements;

public final class MeasurementsEvents extends Enum {
    private static final MeasurementsEvents[] $VALUES;
    public static final MeasurementsEvents AVAILABLE;
    public static final MeasurementsEvents CLICK_ERROR;
    public static final MeasurementsEvents CLICK_SUCCESSFUL;
    public static final MeasurementsEvents NOT_AVAILABLE;
    public static final MeasurementsEvents VIEW_ERROR;
    public static final MeasurementsEvents VIEW_SUCCESSFUL;

    private static final MeasurementsEvents[] $values() {
        return 6;
    }

    static <clinit>() {
        new MeasurementsEvents("NOT_AVAILABLE", 0);
        NOT_AVAILABLE = new MeasurementsEvents(..);
        new MeasurementsEvents("AVAILABLE", 1);
        AVAILABLE = new MeasurementsEvents(..);
        new MeasurementsEvents("VIEW_SUCCESSFUL", 2);
        VIEW_SUCCESSFUL = new MeasurementsEvents(..);
        new MeasurementsEvents("VIEW_ERROR", 3);
        VIEW_ERROR = new MeasurementsEvents(..);
        new MeasurementsEvents("CLICK_SUCCESSFUL", 4);
        CLICK_SUCCESSFUL = new MeasurementsEvents(..);
        new MeasurementsEvents("CLICK_ERROR", 5);
        CLICK_ERROR = new MeasurementsEvents(..);
        MeasurementsEvents.$values();
        $VALUES = MeasurementsEvents.$values(..);
        return;
    }

    private MeasurementsEvents(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static MeasurementsEvents valueOf(String p0) {
        Enum.valueOf(MeasurementsEvents.class, p0);
        return Enum.valueOf(..);
    }

    public static MeasurementsEvents[] values() {
        MeasurementsEvents.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.measurements.MeasurementsReceiver
// ============================================================
package com.unity3d.services.ads.measurements;

public final class MeasurementsReceiver {
    private final MeasurementsEvents errorEvent;
    private final IEventSender eventSender;
    private final MeasurementsEvents successEvent;

    public MeasurementsReceiver(IEventSender p0, MeasurementsEvents p1, MeasurementsEvents p2) {
        new Object();
        eventSender = p0;
        successEvent = p1;
        errorEvent = p2;
        return;
    }

    public void onError(Exception p0) {
        p0.toString();
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, errorEvent, 1);
        return;
    }

    public void onError(Throwable p0) {
        MeasurementsReceiver.onError(p0);
        return;
    }

    public void onResult(Object p0) {
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, successEvent, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.measurements.MeasurementsService
// ============================================================
package com.unity3d.services.ads.measurements;

public final class MeasurementsService {
    private final ISDKDispatchers dispatchers;
    private final IEventSender eventSender;
    private final MeasurementManager measurementManager;

    public MeasurementsService(Context p0, ISDKDispatchers p1, IEventSender p2) {
        new Object();
        dispatchers = p1;
        eventSender = p2;
        new Object(..).getMeasurementManager(p0);
        measurementManager = MeasurementsService.getMeasurementManager(..);
        return;
    }

    private final MeasurementManager getMeasurementManager(Context p0) {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 33)) goto L_a;
        return 0;
      L_a:
        SdkExtensions.getExtensionVersion(1000000);
        if (if-ge(SdkExtensions.getExtensionVersion(..), 4)) goto L_15;
        return 0;
      L_15:
        p0.getSystemService(MeasurementManager.class);
        return Context.getSystemService(..);
    }

    public final void checkAvailability() {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 33)) goto L_1e;
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.NOT_AVAILABLE, 1);
        return;
      L_1e:
        SdkExtensions.getExtensionVersion(1000000);
        if (if-ge(SdkExtensions.getExtensionVersion(..), 4)) goto L_3c;
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.NOT_AVAILABLE, 1);
        return;
      L_3c:
        if (if-nez(measurementManager)) goto L_54;
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.NOT_AVAILABLE, 1);
        return;
      L_54:
        AdServicesState.isAdServicesStateEnabled();
        if (if-nez(AdServicesState.isAdServicesStateEnabled(..))) goto L_6e;
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.NOT_AVAILABLE, 1);
        return;
      L_6e:
        dispatchers.getDefault();
        ExecutorsKt.asExecutor(ISDKDispatchers.getDefault(..));
        new MeasurementsStatusReceiver(eventSender);
        measurementManager.getMeasurementApiStatus(ExecutorsKt.asExecutor(..), new MeasurementsStatusReceiver(..));
        return;
    }

    public final void registerClick(String p0, InputEvent p1) {
        if (if-eqz(measurementManager)) goto L_2c;
        Uri.parse(p0);
        dispatchers.getDefault();
        ExecutorsKt.asExecutor(ISDKDispatchers.getDefault(..));
        new MeasurementsReceiver(eventSender, MeasurementsEvents.CLICK_SUCCESSFUL, MeasurementsEvents.CLICK_ERROR);
        measurementManager.registerSource(Uri.parse(..), p1, ExecutorsKt.asExecutor(..), new MeasurementsReceiver(..));
      L_2c:
        return;
    }

    public final void registerView(String p0) {
        if (if-eqz(measurementManager)) goto L_28;
        Uri.parse(p0);
        dispatchers.getDefault();
        ExecutorsKt.asExecutor(ISDKDispatchers.getDefault(..));
        new MeasurementsReceiver(eventSender, MeasurementsEvents.VIEW_SUCCESSFUL, MeasurementsEvents.VIEW_ERROR);
        measurementManager.registerSource(Uri.parse(..), 0, ExecutorsKt.asExecutor(..), new MeasurementsReceiver(..));
      L_28:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.measurements.MeasurementsStatusReceiver
// ============================================================
package com.unity3d.services.ads.measurements;

public final class MeasurementsStatusReceiver {
    private final IEventSender eventSender;

    public MeasurementsStatusReceiver(IEventSender p0) {
        new Object();
        eventSender = p0;
        return;
    }

    public void onError(Exception p0) {
        p0.toString();
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.NOT_AVAILABLE, 2);
        return;
    }

    public void onError(Throwable p0) {
        MeasurementsStatusReceiver.onError(p0);
        return;
    }

    public void onResult(int p0) {
        Integer.valueOf(p0);
        eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.AVAILABLE, 1);
        return;
    }

    public void onResult(Object p0) {
        p0.intValue();
        MeasurementsStatusReceiver.onResult(Number.intValue(..));
        return;
    }

}

