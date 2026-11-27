// Package bundle: com.unity3d.services.core.sensorinfo (2 classes)

// ============================================================
// CLASS: com.unity3d.services.core.sensorinfo.SensorInfoError
// ============================================================
package com.unity3d.services.core.sensorinfo;

public final class SensorInfoError extends Enum {
    private static final SensorInfoError[] $VALUES;
    public static final SensorInfoError ACCELEROMETER_DATA_NOT_AVAILABLE;

    private static SensorInfoError[] $values() {
        return 1;
    }

    static <clinit>() {
        new SensorInfoError("ACCELEROMETER_DATA_NOT_AVAILABLE", 0);
        ACCELEROMETER_DATA_NOT_AVAILABLE = new SensorInfoError(..);
        SensorInfoError.$values();
        $VALUES = SensorInfoError.$values(..);
        return;
    }

    private SensorInfoError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static SensorInfoError valueOf(String p0) {
        Enum.valueOf(SensorInfoError.class, p0);
        return Enum.valueOf(..);
    }

    public static SensorInfoError[] values() {
        SensorInfoError.$VALUES.clone();
        return SensorInfoError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.sensorinfo.SensorInfoListener
// ============================================================
package com.unity3d.services.core.sensorinfo;

public class SensorInfoListener {
    private static SensorInfoListener _accelerometerListener;
    private static Sensor _accelerometerSensor;
    private static SensorEvent _latestAccelerometerEvent;

    static <clinit>() {
        return;
    }

    public SensorInfoListener() {
        new Object();
        return;
    }

    public static JSONObject getAccelerometerData() {
        if (if-eqz(SensorInfoListener._latestAccelerometerEvent)) goto L_38;
        new JSONObject();
        new JSONObject(..).put("x", values, 0);
        new JSONObject(..).put("y", values, 1);
        new JSONObject(..).put("z", values, 2);
        DeviceLog.exception("JSON error while constructing accelerometer data", "z");
      L_38:
      L_39:
        return 0;
    }

    public static boolean isAccelerometerListenerActive() {
        if (if-eqz(SensorInfoListener._accelerometerListener)) goto L_6;
      L_6:
      L_7:
        return 0;
    }

    public static boolean startAccelerometerListener(int p0) {
        if (if-nez(SensorInfoListener._accelerometerListener)) goto L_b;
        new SensorInfoListener();
        _accelerometerListener = new SensorInfoListener(..);
      L_b:
        ClientProperties.getApplicationContext();
        Context.getSystemService("sensor");
        Context.getSystemService(..).getDefaultSensor(1);
        _accelerometerSensor = SensorManager.getDefaultSensor(..);
        Context.getSystemService(..).registerListener(SensorInfoListener._accelerometerListener, SensorManager.getDefaultSensor(..), p0);
        return SensorManager.registerListener(..);
    }

    public static void stopAccelerometerListener() {
        if (if-eqz(SensorInfoListener._accelerometerListener)) goto L_18;
        ClientProperties.getApplicationContext();
        Context.getSystemService("sensor");
        Context.getSystemService(..).unregisterListener(SensorInfoListener._accelerometerListener);
        _accelerometerListener = 0;
      L_18:
        return;
    }

    public void onAccuracyChanged(Sensor p0, int p1) {
        return;
    }

    public void onSensorChanged(SensorEvent p0) {
        sensor.getType();
        if (if-ne(Sensor.getType(..), 1)) goto L_b;
        _latestAccelerometerEvent = p0;
      L_b:
        return;
    }

}

