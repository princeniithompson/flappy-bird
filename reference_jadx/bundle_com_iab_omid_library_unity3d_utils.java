
// ===== FILE: com/iab/omid/library/unity3d/utils/C0826a.java =====
package com.iab.omid.library.unity3d.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.iab.omid.library.unity3d.adsession.DeviceCategory;

/* renamed from: com.iab.omid.library.unity3d.utils.a */
/* loaded from: classes.dex */
public final class C0826a {

    /* renamed from: a */
    private static UiModeManager f321a;

    /* renamed from: a */
    public static DeviceCategory m224a() {
        UiModeManager uiModeManager = f321a;
        if (uiModeManager == null) {
            return DeviceCategory.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? DeviceCategory.OTHER : DeviceCategory.CTV : DeviceCategory.MOBILE;
    }

    /* renamed from: a */
    public static void m225a(Context context) {
        if (context != null) {
            f321a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}

// ===== FILE: com/iab/omid/library/unity3d/utils/C0827b.java =====
package com.iab.omid.library.unity3d.utils;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.utils.b */
/* loaded from: classes.dex */
public final class C0827b {
    /* renamed from: a */
    public static String m226a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    /* renamed from: b */
    public static String m227b() {
        return "Android";
    }

    /* renamed from: c */
    public static String m228c() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: d */
    public static JSONObject m229d() {
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, "deviceType", m226a());
        C0828c.m238a(jSONObject, "osVersion", m228c());
        C0828c.m238a(jSONObject, "os", m227b());
        return jSONObject;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/utils/C0828c.java =====
package com.iab.omid.library.unity3d.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.iab.omid.library.unity3d.adsession.OutputDeviceStatus;
import com.iab.omid.library.unity3d.internal.C0815e;
import com.iab.omid.library.unity3d.walking.C0837a;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.utils.c */
/* loaded from: classes.dex */
public class C0828c {

    /* renamed from: a */
    private static WindowManager f322a;

    /* renamed from: b */
    private static String[] f323b = {"x", "y", "width", "height"};

    /* renamed from: c */
    static float f324c = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: com.iab.omid.library.unity3d.utils.c$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f325a;

        static {
            int[] iArr = new int[OutputDeviceStatus.values().length];
            f325a = iArr;
            try {
                iArr[OutputDeviceStatus.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.iab.omid.library.unity3d.utils.c$b */
    private static class b {

        /* renamed from: a */
        final float f326a;

        /* renamed from: b */
        final float f327b;

        b(float f, float f2) {
            this.f326a = f;
            this.f327b = f2;
        }
    }

    /* renamed from: a */
    static float m230a(int i) {
        return i / f324c;
    }

    /* renamed from: a */
    private static b m231a(JSONObject jSONObject) {
        float f;
        float f2;
        if (f322a != null) {
            Point point = new Point(0, 0);
            f322a.getDefaultDisplay().getRealSize(point);
            f = m230a(point.x);
            f2 = m230a(point.y);
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        return new b(f, f2);
    }

    /* renamed from: a */
    public static JSONObject m232a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", m230a(i));
            jSONObject.put("y", m230a(i2));
            jSONObject.put("width", m230a(i3));
            jSONObject.put("height", m230a(i4));
        } catch (JSONException e) {
            C0829d.m252a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m233a(Context context) {
        if (context != null) {
            f324c = context.getResources().getDisplayMetrics().density;
            f322a = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m234a(JSONObject jSONObject, OutputDeviceStatus outputDeviceStatus) {
        try {
            jSONObject.put("noOutputDevice", m240a(outputDeviceStatus));
        } catch (JSONException e) {
            C0829d.m252a("Error with setting output device status", e);
        }
    }

    /* renamed from: a */
    public static void m235a(JSONObject jSONObject, C0837a.a aVar) {
        C0815e m310a = aVar.m310a();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = aVar.m312b().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", m310a.m163d());
            jSONObject.put("friendlyObstructionPurpose", m310a.m161b());
            jSONObject.put("friendlyObstructionReason", m310a.m160a());
        } catch (JSONException e) {
            C0829d.m252a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m236a(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e) {
            C0829d.m252a("Error with setting has window focus", e);
        }
    }

    /* renamed from: a */
    public static void m237a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C0829d.m252a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m238a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e) {
            C0829d.m252a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m239a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m240a(OutputDeviceStatus outputDeviceStatus) {
        return a.f325a[outputDeviceStatus.ordinal()] == 1;
    }

    /* renamed from: a */
    private static boolean m241a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    public static void m242b(JSONObject jSONObject) {
        b m231a = m231a(jSONObject);
        try {
            jSONObject.put("width", m231a.f326a);
            jSONObject.put("height", m231a.f327b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m243b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C0829d.m252a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: b */
    private static boolean m244b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m241a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m250h(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m245c(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m241a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!optJSONArray.optString(i, "").equals(optJSONArray2.optString(i, ""))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m246d(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    /* renamed from: e */
    private static boolean m247e(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    /* renamed from: f */
    private static boolean m248f(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f323b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    private static boolean m249g(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: h */
    public static boolean m250h(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        return m248f(jSONObject, jSONObject2) && m249g(jSONObject, jSONObject2) && m247e(jSONObject, jSONObject2) && m246d(jSONObject, jSONObject2) && m245c(jSONObject, jSONObject2) && m244b(jSONObject, jSONObject2);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/utils/C0829d.java =====
package com.iab.omid.library.unity3d.utils;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.unity3d.C0802a;

/* renamed from: com.iab.omid.library.unity3d.utils.d */
/* loaded from: classes.dex */
public final class C0829d {
    /* renamed from: a */
    public static void m251a(String str) {
        if (!C0802a.f241a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    /* renamed from: a */
    public static void m252a(String str, Exception exc) {
        if ((!C0802a.f241a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/utils/C0830e.java =====
package com.iab.omid.library.unity3d.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.iab.omid.library.unity3d.adsession.DeviceCategory;
import com.iab.omid.library.unity3d.adsession.OutputDeviceStatus;

/* renamed from: com.iab.omid.library.unity3d.utils.e */
/* loaded from: classes.dex */
public class C0830e {

    /* renamed from: a */
    private static OutputDeviceStatus f328a = OutputDeviceStatus.UNKNOWN;

    /* renamed from: com.iab.omid.library.unity3d.utils.e$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            OutputDeviceStatus outputDeviceStatus;
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    outputDeviceStatus = OutputDeviceStatus.NOT_DETECTED;
                } else if (intExtra != 1) {
                    return;
                } else {
                    outputDeviceStatus = OutputDeviceStatus.UNKNOWN;
                }
                OutputDeviceStatus unused = C0830e.f328a = outputDeviceStatus;
            }
        }
    }

    /* renamed from: a */
    public static OutputDeviceStatus m253a() {
        return C0826a.m224a() != DeviceCategory.CTV ? OutputDeviceStatus.UNKNOWN : f328a;
    }

    /* renamed from: a */
    public static void m255a(Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}

// ===== FILE: com/iab/omid/library/unity3d/utils/C0831f.java =====
package com.iab.omid.library.unity3d.utils;

import java.util.Date;

/* renamed from: com.iab.omid.library.unity3d.utils.f */
/* loaded from: classes.dex */
public class C0831f {
    /* renamed from: b */
    public static long m256b() {
        return System.nanoTime();
    }

    /* renamed from: a */
    public Date m257a() {
        return new Date();
    }
}

// ===== FILE: com/iab/omid/library/unity3d/utils/C0832g.java =====
package com.iab.omid.library.unity3d.utils;

import android.text.TextUtils;
import com.iab.omid.library.unity3d.Omid;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;

/* renamed from: com.iab.omid.library.unity3d.utils.g */
/* loaded from: classes.dex */
public class C0832g {
    /* renamed from: a */
    public static void m258a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m259a(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    /* renamed from: a */
    public static void m260a(C0803a c0803a) {
        m266d(c0803a);
        m264b(c0803a);
    }

    /* renamed from: a */
    public static void m261a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m262a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m263a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m264b(C0803a c0803a) {
        if (c0803a.m108g()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m265c(C0803a c0803a) {
        if (c0803a.m111j()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: d */
    private static void m266d(C0803a c0803a) {
        if (!c0803a.m111j()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }

    /* renamed from: e */
    public static void m267e(C0803a c0803a) {
        if (!c0803a.m109h()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: f */
    public static void m268f(C0803a c0803a) {
        if (!c0803a.m110i()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    /* renamed from: g */
    public static void m269g(C0803a c0803a) {
        if (c0803a.getAdSessionStatePublisher().m215c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: h */
    public static void m270h(C0803a c0803a) {
        if (c0803a.getAdSessionStatePublisher().m216d() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }
}

// ===== FILE: com/iab/omid/library/unity3d/utils/C0833h.java =====
package com.iab.omid.library.unity3d.utils;

import android.view.View;

/* renamed from: com.iab.omid.library.unity3d.utils.h */
/* loaded from: classes.dex */
public final class C0833h {
    /* renamed from: a */
    public static String m271a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        int visibility = view.getVisibility();
        if (visibility == 8) {
            return "viewGone";
        }
        if (visibility == 4) {
            return "viewInvisible";
        }
        if (visibility != 0) {
            return "viewNotVisible";
        }
        if (view.getAlpha() == 0.0f) {
            return "viewAlphaZero";
        }
        return null;
    }

    /* renamed from: b */
    public static View m272b(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* renamed from: c */
    public static float m273c(View view) {
        return view.getZ();
    }

    /* renamed from: d */
    public static boolean m274d(View view) {
        return m271a(view) == null;
    }

    /* renamed from: e */
    public static boolean m275e(View view) {
        if (!view.isAttachedToWindow() || !view.isShown()) {
            return false;
        }
        while (view != null) {
            if (view.getAlpha() == 0.0f) {
                return false;
            }
            view = m272b(view);
        }
        return true;
    }
}
