
// ===== FILE: com/iab/omid/library/unity3d/C0802a.java =====
package com.iab.omid.library.unity3d;

/* renamed from: com.iab.omid.library.unity3d.a */
/* loaded from: classes.dex */
public final class C0802a {

    /* renamed from: a */
    public static final Boolean f241a = Boolean.FALSE;
}

// ===== FILE: com/iab/omid/library/unity3d/C0804b.java =====
package com.iab.omid.library.unity3d;

import android.content.Context;
import com.iab.omid.library.unity3d.internal.C0811a;
import com.iab.omid.library.unity3d.internal.C0812b;
import com.iab.omid.library.unity3d.internal.C0816f;
import com.iab.omid.library.unity3d.internal.C0818h;
import com.iab.omid.library.unity3d.utils.C0826a;
import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0830e;
import com.iab.omid.library.unity3d.utils.C0832g;

/* renamed from: com.iab.omid.library.unity3d.b */
/* loaded from: classes.dex */
public class C0804b {

    /* renamed from: a */
    private boolean f258a;

    /* renamed from: b */
    private void m115b(Context context) {
        C0832g.m261a(context, "Application Context cannot be null");
    }

    /* renamed from: a */
    String m116a() {
        return "1.4.9-Unity3d";
    }

    /* renamed from: a */
    void m117a(Context context) {
        m115b(context);
        if (m119b()) {
            return;
        }
        m118a(true);
        C0818h.m185c().m186a(context);
        C0812b.m142g().m154a(context);
        C0826a.m225a(context);
        C0828c.m233a(context);
        C0830e.m255a(context);
        C0816f.m164b().m166a(context);
        C0811a.m136a().m138a(context);
    }

    /* renamed from: a */
    void m118a(boolean z) {
        this.f258a = z;
    }

    /* renamed from: b */
    boolean m119b() {
        return this.f258a;
    }

    /* renamed from: c */
    void m120c() {
        C0832g.m258a();
        C0811a.m136a().m141d();
    }
}

// ===== FILE: com/iab/omid/library/unity3d/C0805c.java =====
package com.iab.omid.library.unity3d;

import com.iab.omid.library.unity3d.utils.C0832g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.iab.omid.library.unity3d.c */
/* loaded from: classes.dex */
class C0805c {

    /* renamed from: a */
    private static final Pattern f259a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b */
    private static final Pattern f260b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c */
    private static final Pattern f261c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d */
    private static final Pattern f262d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e */
    private static final Pattern f263e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f */
    private static final Pattern f264f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g */
    private static final Pattern f265g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    /* renamed from: a */
    static String m121a(String str, String str2) {
        C0832g.m263a(str, "HTML is null or empty");
        int[][] m124a = m124a(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (!m126b(str, sb, f260b, str2, m124a) && !m123a(str, sb, f259a, str2, m124a) && !m126b(str, sb, f262d, str2, m124a) && !m123a(str, sb, f261c, str2, m124a) && !m126b(str, sb, f264f, str2, m124a) && !m123a(str, sb, f263e, str2, m124a) && !m123a(str, sb, f265g, str2, m124a)) {
            return str2 + str;
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m122a(int i, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m123a(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m122a(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }

    /* renamed from: a */
    private static int[][] m124a(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int indexOf = str.indexOf("<!--", i);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance((Class<?>) Integer.TYPE, 0, 2));
    }

    /* renamed from: b */
    static String m125b(String str, String str2) {
        return m121a(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    /* renamed from: b */
    private static boolean m126b(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m122a(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/Omid.java =====
package com.iab.omid.library.unity3d;

import android.content.Context;

/* loaded from: classes.dex */
public final class Omid {
    private static C0804b INSTANCE = new C0804b();

    private Omid() {
    }

    public static void activate(Context context) {
        INSTANCE.m117a(context.getApplicationContext());
    }

    public static String getVersion() {
        return INSTANCE.m116a();
    }

    public static boolean isActive() {
        return INSTANCE.m119b();
    }

    public static void updateLastActivity() {
        INSTANCE.m120c();
    }
}

// ===== FILE: com/iab/omid/library/unity3d/ScriptInjector.java =====
package com.iab.omid.library.unity3d;

/* loaded from: classes.dex */
public final class ScriptInjector {
    private ScriptInjector() {
    }

    public static String injectScriptContentIntoHtml(String str, String str2) {
        return C0805c.m125b(str, str2);
    }
}
