
// ===== FILE: com/iab/omid/library/unity3d/internal/C0811a.java =====
package com.iab.omid.library.unity3d.internal;

import android.content.Context;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.internal.C0814d;
import com.iab.omid.library.unity3d.utils.C0831f;
import java.util.Date;
import java.util.Iterator;

/* renamed from: com.iab.omid.library.unity3d.internal.a */
/* loaded from: classes.dex */
public class C0811a implements C0814d.a {

    /* renamed from: f */
    private static C0811a f271f = new C0811a(new C0814d());

    /* renamed from: a */
    protected C0831f f272a = new C0831f();

    /* renamed from: b */
    private Date f273b;

    /* renamed from: c */
    private boolean f274c;

    /* renamed from: d */
    private C0814d f275d;

    /* renamed from: e */
    private boolean f276e;

    private C0811a(C0814d c0814d) {
        this.f275d = c0814d;
    }

    /* renamed from: a */
    public static C0811a m136a() {
        return f271f;
    }

    /* renamed from: c */
    private void m137c() {
        if (!this.f274c || this.f273b == null) {
            return;
        }
        Iterator<C0803a> it = C0813c.m145c().m146a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().m210a(m140b());
        }
    }

    /* renamed from: a */
    public void m138a(Context context) {
        if (this.f274c) {
            return;
        }
        this.f275d.m154a(context);
        this.f275d.m155a(this);
        this.f275d.m158e();
        this.f276e = this.f275d.m157c();
        this.f274c = true;
    }

    @Override // com.iab.omid.library.unity3d.internal.C0814d.a
    /* renamed from: a */
    public void mo139a(boolean z) {
        if (!this.f276e && z) {
            m141d();
        }
        this.f276e = z;
    }

    /* renamed from: b */
    public Date m140b() {
        Date date = this.f273b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    /* renamed from: d */
    public void m141d() {
        Date m257a = this.f272a.m257a();
        Date date = this.f273b;
        if (date == null || m257a.after(date)) {
            this.f273b = m257a;
            m137c();
        }
    }
}

// ===== FILE: com/iab/omid/library/unity3d/internal/C0812b.java =====
package com.iab.omid.library.unity3d.internal;

import android.view.View;
import com.iab.omid.library.unity3d.adsession.C0803a;
import java.util.Iterator;

/* renamed from: com.iab.omid.library.unity3d.internal.b */
/* loaded from: classes.dex */
public class C0812b extends C0814d {

    /* renamed from: d */
    private static C0812b f277d = new C0812b();

    private C0812b() {
    }

    /* renamed from: g */
    public static C0812b m142g() {
        return f277d;
    }

    @Override // com.iab.omid.library.unity3d.internal.C0814d
    /* renamed from: b */
    public void mo143b(boolean z) {
        Iterator<C0803a> it = C0813c.m145c().m148b().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().m212a(z);
        }
    }

    @Override // com.iab.omid.library.unity3d.internal.C0814d
    /* renamed from: d */
    public boolean mo144d() {
        Iterator<C0803a> it = C0813c.m145c().m146a().iterator();
        while (it.hasNext()) {
            View m104c = it.next().m104c();
            if (m104c != null && m104c.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/internal/C0813c.java =====
package com.iab.omid.library.unity3d.internal;

import com.iab.omid.library.unity3d.adsession.C0803a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.unity3d.internal.c */
/* loaded from: classes.dex */
public class C0813c {

    /* renamed from: c */
    private static C0813c f278c = new C0813c();

    /* renamed from: a */
    private final ArrayList<C0803a> f279a = new ArrayList<>();

    /* renamed from: b */
    private final ArrayList<C0803a> f280b = new ArrayList<>();

    private C0813c() {
    }

    /* renamed from: c */
    public static C0813c m145c() {
        return f278c;
    }

    /* renamed from: a */
    public Collection<C0803a> m146a() {
        return Collections.unmodifiableCollection(this.f280b);
    }

    /* renamed from: a */
    public void m147a(C0803a c0803a) {
        this.f279a.add(c0803a);
    }

    /* renamed from: b */
    public Collection<C0803a> m148b() {
        return Collections.unmodifiableCollection(this.f279a);
    }

    /* renamed from: b */
    public void m149b(C0803a c0803a) {
        boolean m151d = m151d();
        this.f279a.remove(c0803a);
        this.f280b.remove(c0803a);
        if (!m151d || m151d()) {
            return;
        }
        C0818h.m185c().m189e();
    }

    /* renamed from: c */
    public void m150c(C0803a c0803a) {
        boolean m151d = m151d();
        this.f280b.add(c0803a);
        if (m151d) {
            return;
        }
        C0818h.m185c().m188d();
    }

    /* renamed from: d */
    public boolean m151d() {
        return this.f280b.size() > 0;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/internal/C0814d.java =====
package com.iab.omid.library.unity3d.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* renamed from: com.iab.omid.library.unity3d.internal.d */
/* loaded from: classes.dex */
public class C0814d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private boolean f281a;

    /* renamed from: b */
    protected boolean f282b;

    /* renamed from: c */
    private a f283c;

    /* renamed from: com.iab.omid.library.unity3d.internal.d$a */
    public interface a {
        /* renamed from: a */
        void mo139a(boolean z);
    }

    /* renamed from: a */
    private void m152a(boolean z) {
        if (this.f282b != z) {
            this.f282b = z;
            if (this.f281a) {
                mo143b(z);
                a aVar = this.f283c;
                if (aVar != null) {
                    aVar.mo139a(z);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m153a() {
        return (m156b().importance == 100) || mo144d();
    }

    /* renamed from: a */
    public void m154a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    /* renamed from: a */
    public void m155a(a aVar) {
        this.f283c = aVar;
    }

    /* renamed from: b */
    ActivityManager.RunningAppProcessInfo m156b() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    /* renamed from: b */
    protected void mo143b(boolean z) {
    }

    /* renamed from: c */
    public boolean m157c() {
        return this.f282b;
    }

    /* renamed from: d */
    protected boolean mo144d() {
        return false;
    }

    /* renamed from: e */
    public void m158e() {
        this.f281a = true;
        boolean m153a = m153a();
        this.f282b = m153a;
        mo143b(m153a);
    }

    /* renamed from: f */
    public void m159f() {
        this.f281a = false;
        this.f283c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        m152a(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        m152a(m153a());
    }
}

// ===== FILE: com/iab/omid/library/unity3d/internal/C0815e.java =====
package com.iab.omid.library.unity3d.internal;

import android.view.View;
import com.iab.omid.library.unity3d.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.unity3d.weakreference.C0846a;

/* renamed from: com.iab.omid.library.unity3d.internal.e */
/* loaded from: classes.dex */
public class C0815e {

    /* renamed from: a */
    private final C0846a f284a;

    /* renamed from: b */
    private final String f285b;

    /* renamed from: c */
    private final FriendlyObstructionPurpose f286c;

    /* renamed from: d */
    private final String f287d;

    public C0815e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f284a = new C0846a(view);
        this.f285b = view.getClass().getCanonicalName();
        this.f286c = friendlyObstructionPurpose;
        this.f287d = str;
    }

    /* renamed from: a */
    public String m160a() {
        return this.f287d;
    }

    /* renamed from: b */
    public FriendlyObstructionPurpose m161b() {
        return this.f286c;
    }

    /* renamed from: c */
    public C0846a m162c() {
        return this.f284a;
    }

    /* renamed from: d */
    public String m163d() {
        return this.f285b;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/internal/C0816f.java =====
package com.iab.omid.library.unity3d.internal;

import android.content.Context;

/* renamed from: com.iab.omid.library.unity3d.internal.f */
/* loaded from: classes.dex */
public class C0816f {

    /* renamed from: b */
    private static C0816f f288b = new C0816f();

    /* renamed from: a */
    private Context f289a;

    private C0816f() {
    }

    /* renamed from: b */
    public static C0816f m164b() {
        return f288b;
    }

    /* renamed from: a */
    public Context m165a() {
        return this.f289a;
    }

    /* renamed from: a */
    public void m166a(Context context) {
        this.f289a = context != null ? context.getApplicationContext() : null;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/internal/C0817g.java =====
package com.iab.omid.library.unity3d.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.unity3d.adsession.ErrorType;
import com.iab.omid.library.unity3d.utils.C0829d;
import kotlin.text.Typography;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.internal.g */
/* loaded from: classes.dex */
public class C0817g {

    /* renamed from: a */
    private static C0817g f290a = new C0817g();

    /* renamed from: com.iab.omid.library.unity3d.internal.g$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ WebView f291a;

        /* renamed from: b */
        final /* synthetic */ String f292b;

        a(WebView webView, String str) {
            this.f291a = webView;
            this.f292b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0817g.this.m183c(this.f291a, this.f292b);
        }
    }

    private C0817g() {
    }

    /* renamed from: a */
    public static final C0817g m167a() {
        return f290a;
    }

    /* renamed from: a */
    public void m168a(WebView webView, String str) {
        m175a(webView, "finishSession", str);
    }

    /* renamed from: a */
    public void m169a(WebView webView, String str, float f) {
        m175a(webView, "setDeviceVolume", Float.valueOf(f), str);
    }

    /* renamed from: a */
    public void m170a(WebView webView, String str, ErrorType errorType, String str2) {
        m175a(webView, "error", errorType.toString(), str2, str);
    }

    /* renamed from: a */
    public void m171a(WebView webView, String str, String str2) {
        m175a(webView, "setNativeViewHierarchy", str2, str);
    }

    /* renamed from: a */
    public void m172a(WebView webView, String str, String str2, JSONObject jSONObject) {
        m175a(webView, "publishMediaEvent", str2, jSONObject, str);
    }

    /* renamed from: a */
    public void m173a(WebView webView, String str, JSONObject jSONObject) {
        m175a(webView, "init", jSONObject, str);
    }

    /* renamed from: a */
    public void m174a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        m175a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* renamed from: a */
    void m175a(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            C0829d.m251a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("if(window.omidBridge!==undefined){omidBridge.");
        sb.append(str);
        sb.append("(");
        m178a(sb, objArr);
        sb.append(")}");
        m176a(webView, sb);
    }

    /* renamed from: a */
    void m176a(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            m183c(webView, sb2);
        } else {
            handler.post(new a(webView, sb2));
        }
    }

    /* renamed from: a */
    public void m177a(WebView webView, JSONObject jSONObject) {
        m175a(webView, "setLastActivity", jSONObject);
    }

    /* renamed from: a */
    void m178a(StringBuilder sb, Object[] objArr) {
        String obj;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj2 : objArr) {
            if (obj2 == null) {
                obj = "null";
            } else {
                if (obj2 instanceof String) {
                    obj = obj2.toString();
                    if (!obj.startsWith("{")) {
                        sb.append(Typography.quote);
                        sb.append(obj);
                        sb.append(Typography.quote);
                    }
                } else {
                    sb.append(obj2);
                }
                sb.append(",");
            }
            sb.append(obj);
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
    }

    /* renamed from: b */
    public void m179b(WebView webView, String str) {
        m175a(webView, "publishImpressionEvent", str);
    }

    /* renamed from: b */
    public void m180b(WebView webView, String str, String str2) {
        m175a(webView, "setState", str2, str);
    }

    /* renamed from: b */
    public void m181b(WebView webView, String str, JSONObject jSONObject) {
        m175a(webView, "publishLoadedEvent", jSONObject, str);
    }

    /* renamed from: c */
    public void m182c(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        m183c(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }

    /* renamed from: c */
    public boolean m183c(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            webView.evaluateJavascript(str, null);
            return true;
        } catch (IllegalStateException unused) {
            webView.loadUrl("javascript: " + str);
            return true;
        }
    }
}

// ===== FILE: com/iab/omid/library/unity3d/internal/C0818h.java =====
package com.iab.omid.library.unity3d.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.devicevolume.C0807b;
import com.iab.omid.library.unity3d.devicevolume.C0809d;
import com.iab.omid.library.unity3d.devicevolume.C0810e;
import com.iab.omid.library.unity3d.devicevolume.InterfaceC0808c;
import com.iab.omid.library.unity3d.internal.C0814d;
import com.iab.omid.library.unity3d.walking.TreeWalker;
import java.util.Iterator;

/* renamed from: com.iab.omid.library.unity3d.internal.h */
/* loaded from: classes.dex */
public class C0818h implements C0814d.a, InterfaceC0808c {

    /* renamed from: f */
    private static C0818h f294f;

    /* renamed from: a */
    private float f295a = 0.0f;

    /* renamed from: b */
    private final C0810e f296b;

    /* renamed from: c */
    private final C0807b f297c;

    /* renamed from: d */
    private C0809d f298d;

    /* renamed from: e */
    private C0813c f299e;

    public C0818h(C0810e c0810e, C0807b c0807b) {
        this.f296b = c0810e;
        this.f297c = c0807b;
    }

    /* renamed from: a */
    private C0813c m184a() {
        if (this.f299e == null) {
            this.f299e = C0813c.m145c();
        }
        return this.f299e;
    }

    /* renamed from: c */
    public static C0818h m185c() {
        if (f294f == null) {
            f294f = new C0818h(new C0810e(), new C0807b());
        }
        return f294f;
    }

    @Override // com.iab.omid.library.unity3d.devicevolume.InterfaceC0808c
    /* renamed from: a */
    public void mo129a(float f) {
        this.f295a = f;
        Iterator<C0803a> it = m184a().m146a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().m199a(f);
        }
    }

    /* renamed from: a */
    public void m186a(Context context) {
        this.f298d = this.f296b.m135a(new Handler(), context, this.f297c.m128a(), this);
    }

    @Override // com.iab.omid.library.unity3d.internal.C0814d.a
    /* renamed from: a */
    public void mo139a(boolean z) {
        if (z) {
            TreeWalker.getInstance().m293h();
        } else {
            TreeWalker.getInstance().m292g();
        }
    }

    /* renamed from: b */
    public float m187b() {
        return this.f295a;
    }

    /* renamed from: d */
    public void m188d() {
        C0812b.m142g().m155a(this);
        C0812b.m142g().m158e();
        TreeWalker.getInstance().m293h();
        this.f298d.m133c();
    }

    /* renamed from: e */
    public void m189e() {
        TreeWalker.getInstance().m294j();
        C0812b.m142g().m159f();
        this.f298d.m134d();
    }
}
