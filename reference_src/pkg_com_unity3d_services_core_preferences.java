// Package bundle: com.unity3d.services.core.preferences (2 classes)

// ============================================================
// CLASS: com.unity3d.services.core.preferences.AndroidPreferences
// ============================================================
package com.unity3d.services.core.preferences;

public class AndroidPreferences {
    public AndroidPreferences() {
        new Object();
        return;
    }

    public static Boolean getBoolean(String p0, String p1) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_39;
        Context.getSharedPreferences(..).contains(p1);
        if (if-eqz(SharedPreferences.contains(..))) goto L_39;
        Context.getSharedPreferences(..).getBoolean(p1, 0);
        Boolean.valueOf(SharedPreferences.getBoolean(..));
        return Boolean.valueOf(..);
        new StringBuilder("Unity Ads failed to cast ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(": ");
        Boolean.valueOf(..).getMessage();
        new StringBuilder(..).append(ClassCastException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
      L_39:
        return 0;
    }

    public static Float getFloat(String p0, String p1) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_3b;
        Context.getSharedPreferences(..).contains(p1);
        if (if-eqz(SharedPreferences.contains(..))) goto L_3b;
        Context.getSharedPreferences(..).getFloat(p1, 0x7fc00000);
        Float.valueOf(SharedPreferences.getFloat(..));
        return Float.valueOf(..);
        new StringBuilder("Unity Ads failed to cast ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(": ");
        Float.valueOf(..).getMessage();
        new StringBuilder(..).append(ClassCastException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
      L_3b:
        return 0;
    }

    public static Integer getInteger(String p0, String p1) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_3a;
        Context.getSharedPreferences(..).contains(p1);
        if (if-eqz(SharedPreferences.contains(..))) goto L_3a;
        Context.getSharedPreferences(..).getInt(p1, -1);
        Integer.valueOf(SharedPreferences.getInt(..));
        return Integer.valueOf(..);
        new StringBuilder("Unity Ads failed to cast ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(": ");
        Integer.valueOf(..).getMessage();
        new StringBuilder(..).append(ClassCastException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
      L_3a:
        return 0;
    }

    public static Long getLong(String p0, String p1) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_3b;
        Context.getSharedPreferences(..).contains(p1);
        if (if-eqz(SharedPreferences.contains(..))) goto L_3b;
        Context.getSharedPreferences(..).getLong(p1, -1L, v2);
        Long.valueOf(SharedPreferences.getLong(..), v2);
        return Long.valueOf(..);
        new StringBuilder("Unity Ads failed to cast ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(": ");
        Long.valueOf(..).getMessage();
        new StringBuilder(..).append(ClassCastException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
      L_3b:
        return 0;
    }

    public static String getString(String p0, String p1) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_37;
        Context.getSharedPreferences(..).contains(p1);
        if (if-eqz(SharedPreferences.contains(..))) goto L_37;
        Context.getSharedPreferences(..).getString(p1, "");
        return SharedPreferences.getString(..);
        new StringBuilder("Unity Ads failed to cast ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(": ");
        SharedPreferences.getString(..).getMessage();
        new StringBuilder(..).append(ClassCastException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
      L_37:
        return 0;
    }

    public static boolean hasKey(String p0, String p1) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_13;
        Context.getSharedPreferences(..).contains(p1);
        if (if-eqz(SharedPreferences.contains(..))) goto L_13;
        return 1;
      L_13:
        return 0;
    }

    public static void removeKey(String p0, String p1) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_15;
        Context.getSharedPreferences(..).edit();
        SharedPreferences.edit(..).remove(p1);
        SharedPreferences.edit(..).commit();
      L_15:
        return;
    }

    public static void setBoolean(String p0, String p1, Boolean p2) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_19;
        Context.getSharedPreferences(..).edit();
        p2.booleanValue();
        SharedPreferences.edit(..).putBoolean(p1, Boolean.booleanValue(..));
        SharedPreferences.edit(..).commit();
      L_19:
        return;
    }

    public static void setFloat(String p0, String p1, Double p2) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_19;
        Context.getSharedPreferences(..).edit();
        p2.floatValue();
        SharedPreferences.edit(..).putFloat(p1, Double.floatValue(..));
        SharedPreferences.edit(..).commit();
      L_19:
        return;
    }

    public static void setInteger(String p0, String p1, Integer p2) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_19;
        Context.getSharedPreferences(..).edit();
        p2.intValue();
        SharedPreferences.edit(..).putInt(p1, Integer.intValue(..));
        SharedPreferences.edit(..).commit();
      L_19:
        return;
    }

    public static void setLong(String p0, String p1, Long p2) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_19;
        Context.getSharedPreferences(..).edit();
        p2.longValue();
        SharedPreferences.edit(..).putLong(p1, Long.longValue(..), 0);
        SharedPreferences.edit(..).commit();
      L_19:
        return;
    }

    public static void setString(String p0, String p1, String p2) {
        ClientProperties.getApplicationContext();
        Context.getSharedPreferences(p0, 0);
        if (if-eqz(Context.getSharedPreferences(..))) goto L_15;
        Context.getSharedPreferences(..).edit();
        SharedPreferences.edit(..).putString(p1, p2);
        SharedPreferences.edit(..).commit();
      L_15:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.preferences.PreferencesError
// ============================================================
package com.unity3d.services.core.preferences;

public final class PreferencesError extends Enum {
    private static final PreferencesError[] $VALUES;
    public static final PreferencesError COULDNT_GET_VALUE;

    private static PreferencesError[] $values() {
        return 1;
    }

    static <clinit>() {
        new PreferencesError("COULDNT_GET_VALUE", 0);
        COULDNT_GET_VALUE = new PreferencesError(..);
        PreferencesError.$values();
        $VALUES = PreferencesError.$values(..);
        return;
    }

    private PreferencesError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static PreferencesError valueOf(String p0) {
        Enum.valueOf(PreferencesError.class, p0);
        return Enum.valueOf(..);
    }

    public static PreferencesError[] values() {
        PreferencesError.$VALUES.clone();
        return PreferencesError[].clone(..);
    }

}

