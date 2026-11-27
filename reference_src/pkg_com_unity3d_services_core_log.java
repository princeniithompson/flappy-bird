// Package bundle: com.unity3d.services.core.log (5 classes)

// ============================================================
// CLASS: com.unity3d.services.core.log.DeviceLog
// ============================================================
package com.unity3d.services.core.log;

public class DeviceLog {
    private static boolean FORCE_DEBUG_LOG = false;
    public static final int LOGLEVEL_DEBUG = 8;
    private static final int LOGLEVEL_ERROR = 1;
    public static final int LOGLEVEL_INFO = 4;
    private static final int LOGLEVEL_WARNING = 2;
    private static boolean LOG_DEBUG = true;
    private static boolean LOG_ERROR = true;
    private static boolean LOG_INFO = true;
    private static boolean LOG_WARNING = true;
    private static final int MAX_DEBUG_MSG_LENGTH = 3072;
    private static final HashMap _deviceLogLevel;

    static <clinit>() {
        new HashMap();
        _deviceLogLevel = new HashMap(..);
        new HashMap(..).size();
        if (if-nez(HashMap.size(..))) goto L_3d;
        new DeviceLogLevel("i");
        new HashMap(..).put(DeviceLog$UnityAdsLogLevel.INFO, new DeviceLogLevel(..));
        new DeviceLogLevel("d");
        new HashMap(..).put(DeviceLog$UnityAdsLogLevel.DEBUG, new DeviceLogLevel(..));
        new DeviceLogLevel("w");
        new HashMap(..).put(DeviceLog$UnityAdsLogLevel.WARNING, new DeviceLogLevel(..));
        new DeviceLogLevel("e");
        new HashMap(..).put(DeviceLog$UnityAdsLogLevel.ERROR, new DeviceLogLevel(..));
      L_3d:
        new File("/data/local/tmp/UnityAdsForceDebugMode");
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_4d;
        FORCE_DEBUG_LOG = 1;
      L_4d:
        return;
    }

    public DeviceLog() {
        new Object();
        return;
    }

    private static String checkMessage(String p0) {
        if (if-eqz(p0)) goto L_8;
        p0.length();
        if (if-nez(String.length(..))) goto L_a;
      L_8:
      L_a:
        return "DO NOT USE EMPTY MESSAGES, use DeviceLog.entered() instead";
    }

    private static DeviceLogEntry createLogEntry(DeviceLog$UnityAdsLogLevel p0, String p1) {
        Thread.currentThread();
        Thread.currentThread(..).getStackTrace();
        DeviceLog.getLogLevel(p0);
        if (if-eqz(DeviceLog.getLogLevel(..))) goto L_49;
      L_11:
        if (if-ge(0, v4)) goto L_3b;
        StackTraceElement.getClassName();
        DeviceLog.class.getName();
        StackTraceElement.getClassName(..).equals(Class.getName(..));
        if (if-eqz(String.equals(..))) goto L_27;
      L_27:
        StackTraceElement.getClassName();
        DeviceLog.class.getName();
        StackTraceElement.getClassName(..).equals(Class.getName(..));
        if (if-nez(String.equals(..))) goto L_38;
        if (if-eqz(1)) goto L_38;
      L_38:
      L_3b:
        if (if-ge(0, 1)) goto L_41;
      L_41:
      L_42:
        if (if-eqz(0)) goto L_49;
        new DeviceLogEntry(DeviceLog.getLogLevel(..), p1, 0);
      L_49:
        return new DeviceLogEntry(..);
    }

    public static void debug(String p0) {
        DeviceLog.isDebugEnabled();
        if (if-nez(DeviceLog.isDebugEnabled(..))) goto L_7;
        return;
      L_7:
        p0.length();
        if (if-le(String.length(..), 3072)) goto L_27;
        p0.substring(0, 3072);
        DeviceLog.debug(String.substring(..));
        p0.length();
        if (if-ge(String.length(..), 30720)) goto L_26;
        p0.substring(3072);
        DeviceLog.debug(String.substring(..));
      L_26:
        return;
      L_27:
        DeviceLog.checkMessage(String.substring(..));
        DeviceLog.write(DeviceLog$UnityAdsLogLevel.DEBUG, DeviceLog.checkMessage(..));
        return;
    }

    public static void debug(String p0, Object[] p1) {
        DeviceLog.isDebugEnabled();
        if (if-nez(DeviceLog.isDebugEnabled(..))) goto L_7;
        return;
      L_7:
        String.format(p0, p1);
        DeviceLog.debug(String.format(..));
        return;
    }

    public static void entered() {
        DeviceLog.debug("ENTERED METHOD");
        return;
    }

    public static void error(String p0) {
        DeviceLog.checkMessage(p0);
        DeviceLog.write(DeviceLog$UnityAdsLogLevel.ERROR, DeviceLog.checkMessage(..));
        return;
    }

    public static void error(String p0, Object[] p1) {
        String.format(p0, p1);
        DeviceLog.error(String.format(..));
        return;
    }

    public static void exception(String p0, Exception p1) {
        if (if-eqz(p0)) goto L_10;
        new StringBuilder("");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
      L_10:
        if (if-eqz(p1)) goto L_2a;
        new StringBuilder();
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).append(": ");
        p1.getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
      L_2a:
        if (if-eqz(p1)) goto L_4c;
        p1.getCause();
        if (if-eqz(Exception.getCause(..))) goto L_4c;
        new StringBuilder();
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).append(": ");
        p1.getCause();
        Exception.getCause(..).getMessage();
        new StringBuilder(..).append(Throwable.getMessage(..));
        new StringBuilder(..).toString();
      L_4c:
        DeviceLog.write(DeviceLog$UnityAdsLogLevel.ERROR, StringBuilder.toString(..));
        return;
    }

    private static DeviceLogLevel getLogLevel(DeviceLog$UnityAdsLogLevel p0) {
        DeviceLog._deviceLogLevel.get(p0);
        return HashMap.get(..);
    }

    public static void info(String p0) {
        DeviceLog.checkMessage(p0);
        DeviceLog.write(DeviceLog$UnityAdsLogLevel.INFO, DeviceLog.checkMessage(..));
        return;
    }

    public static void info(String p0, Object[] p1) {
        String.format(p0, p1);
        DeviceLog.info(String.format(..));
        return;
    }

    private static boolean isDebugEnabled() {
        if (if-nez(DeviceLog.LOG_DEBUG)) goto L_b;
        if (if-eqz(DeviceLog.FORCE_DEBUG_LOG)) goto L_9;
      L_9:
      L_b:
      L_c:
        return 1;
    }

    public static void setLogLevel(int p0) {
        if (if-lt(p0, 8)) goto L_e;
        LOG_ERROR = 1;
        LOG_WARNING = 1;
        LOG_INFO = 1;
        LOG_DEBUG = 1;
      L_e:
        if (if-lt(p0, 4)) goto L_1b;
        LOG_ERROR = 1;
        LOG_WARNING = 1;
        LOG_INFO = 1;
        LOG_DEBUG = 0;
      L_1b:
        if (if-lt(p0, 2)) goto L_27;
        LOG_ERROR = 1;
        LOG_WARNING = 1;
        LOG_INFO = 0;
        LOG_DEBUG = 0;
      L_27:
        if (if-lt(p0, 1)) goto L_32;
        LOG_ERROR = 1;
        LOG_WARNING = 0;
        LOG_INFO = 0;
        LOG_DEBUG = 0;
      L_32:
        LOG_ERROR = 0;
        LOG_WARNING = 0;
        LOG_INFO = 0;
        LOG_DEBUG = 0;
      L_3a:
        return;
    }

    public static void warning(String p0) {
        DeviceLog.checkMessage(p0);
        DeviceLog.write(DeviceLog$UnityAdsLogLevel.WARNING, DeviceLog.checkMessage(..));
        return;
    }

    public static void warning(String p0, Object[] p1) {
        String.format(p0, p1);
        DeviceLog.warning(String.format(..));
        return;
    }

    private static void write(DeviceLog$UnityAdsLogLevel p0, String p1) {
        p0.ordinal();
        if (if-eq(DeviceLog$1.$SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel, 1)) goto L_1f;
        if (if-eq(DeviceLog$1.$SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel, 2)) goto L_1c;
        if (if-eq(DeviceLog$1.$SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel, 3)) goto L_19;
        if (if-eq(DeviceLog$1.$SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel, 4)) goto L_16;
      L_16:
      L_19:
      L_1c:
      L_1f:
      L_21:
        if (if-eqz(DeviceLog.FORCE_DEBUG_LOG)) goto L_26;
      L_26:
      L_27:
        if (if-eqz(DeviceLog.LOG_INFO)) goto L_30;
        DeviceLog.createLogEntry(p0, p1);
        DeviceLog.writeToLog(DeviceLog.createLogEntry(..));
      L_30:
        return;
    }

    private static void writeToLog(DeviceLogEntry p0) {
        if (if-eqz(p0)) goto L_4a;
        p0.getLogLevel();
        if (if-eqz(DeviceLogEntry.getLogLevel(..))) goto L_4a;
        p0.getLogLevel();
        DeviceLogEntry.getLogLevel(..).getReceivingMethodName();
        Log.class.getMethod(DeviceLogLevel.getReceivingMethodName(..), v8);
        Log.e("UnityAds", "Writing to log failed!", Class.getMethod(..));
      L_2e:
        if (if-eqz(0)) goto L_4a;
        p0.getLogLevel();
        DeviceLogEntry.getLogLevel(..).getLogTag();
        p0.getParsedMessage();
        0.invoke(0, 2);
        Log.e("UnityAds", "Writing to log failed!", DeviceLogEntry.getParsedMessage(..));
      L_4a:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.log.DeviceLogEntry
// ============================================================
package com.unity3d.services.core.log;

class DeviceLogEntry {
    private DeviceLogLevel _logLevel;
    private String _originalMessage;
    private StackTraceElement _stackTraceElement;

    public DeviceLogEntry(DeviceLogLevel p0, String p1, StackTraceElement p2) {
        new Object();
        _logLevel = p0;
        _originalMessage = p1;
        _stackTraceElement = p2;
        return;
    }

    public DeviceLogLevel getLogLevel() {
        return _logLevel;
    }

    public String getParsedMessage() {
        if (if-eqz(_stackTraceElement)) goto L_17;
        _stackTraceElement.getClassName();
        _stackTraceElement.getMethodName();
        _stackTraceElement.getLineNumber();
      L_17:
      L_1c:
        if (if-eqz(_originalMessage)) goto L_32;
        _originalMessage.isEmpty();
        if (if-nez(String.isEmpty(..))) goto L_32;
        new StringBuilder(" :: ");
        new StringBuilder(..).append(_originalMessage);
        new StringBuilder(..).toString();
      L_32:
        if (if-nez(StringBuilder.toString(..))) goto L_36;
      L_36:
        new StringBuilder(" (line:");
        new StringBuilder(..).append(-1);
        new StringBuilder(..).append(")");
        new StringBuilder(..).toString();
        new StringBuilder();
        new StringBuilder(..).append("UnknownClass");
        new StringBuilder(..).append(".");
        new StringBuilder(..).append("unknownMethod");
        new StringBuilder(..).append("()");
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).append("");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.log.DeviceLogLevel
// ============================================================
package com.unity3d.services.core.log;

public class DeviceLogLevel {
    private static final String LOG_TAG = "UnityAds";
    private String _receivingMethodName;

    public DeviceLogLevel(String p0) {
        new Object();
        _receivingMethodName = p0;
        return;
    }

    public String getLogTag() {
        return "UnityAds";
    }

    public String getReceivingMethodName() {
        return _receivingMethodName;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.log.DeviceLog$1
// ============================================================
package com.unity3d.services.core.log;

class DeviceLog$1 {
    static final int[] $SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel;

    static <clinit>() {
        DeviceLog$UnityAdsLogLevel.values();
        $SwitchMap$com$unity3d$services$core$log$DeviceLog$UnityAdsLogLevel = DeviceLog$UnityAdsLogLevel.values(..);
        DeviceLog$UnityAdsLogLevel.INFO.ordinal();
        DeviceLog$UnityAdsLogLevel.DEBUG.ordinal();
        DeviceLog$UnityAdsLogLevel.WARNING.ordinal();
        DeviceLog$UnityAdsLogLevel.ERROR.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.log.DeviceLog$UnityAdsLogLevel
// ============================================================
package com.unity3d.services.core.log;

public final class DeviceLog$UnityAdsLogLevel extends Enum {
    private static final DeviceLog$UnityAdsLogLevel[] $VALUES;
    public static final DeviceLog$UnityAdsLogLevel DEBUG;
    public static final DeviceLog$UnityAdsLogLevel ERROR;
    public static final DeviceLog$UnityAdsLogLevel INFO;
    public static final DeviceLog$UnityAdsLogLevel WARNING;

    private static DeviceLog$UnityAdsLogLevel[] $values() {
        return 4;
    }

    static <clinit>() {
        new DeviceLog$UnityAdsLogLevel("INFO", 0);
        INFO = new DeviceLog$UnityAdsLogLevel(..);
        new DeviceLog$UnityAdsLogLevel("DEBUG", 1);
        DEBUG = new DeviceLog$UnityAdsLogLevel(..);
        new DeviceLog$UnityAdsLogLevel("WARNING", 2);
        WARNING = new DeviceLog$UnityAdsLogLevel(..);
        new DeviceLog$UnityAdsLogLevel("ERROR", 3);
        ERROR = new DeviceLog$UnityAdsLogLevel(..);
        DeviceLog$UnityAdsLogLevel.$values();
        $VALUES = DeviceLog$UnityAdsLogLevel.$values(..);
        return;
    }

    private DeviceLog$UnityAdsLogLevel(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static DeviceLog$UnityAdsLogLevel valueOf(String p0) {
        Enum.valueOf(DeviceLog$UnityAdsLogLevel.class, p0);
        return Enum.valueOf(..);
    }

    public static DeviceLog$UnityAdsLogLevel[] values() {
        DeviceLog$UnityAdsLogLevel.$VALUES.clone();
        return DeviceLog$UnityAdsLogLevel[].clone(..);
    }

}

