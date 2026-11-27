
// ===== FILE: com/iab/omid/library/unity3d/walking/C0837a.java =====
package com.iab.omid.library.unity3d.walking;

import android.view.View;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.internal.C0813c;
import com.iab.omid.library.unity3d.internal.C0815e;
import com.iab.omid.library.unity3d.utils.C0833h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.iab.omid.library.unity3d.walking.a */
/* loaded from: classes.dex */
public class C0837a {

    /* renamed from: a */
    private final HashMap<View, String> f343a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, a> f344b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, View> f345c = new HashMap<>();

    /* renamed from: d */
    private final HashSet<View> f346d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f347e = new HashSet<>();

    /* renamed from: f */
    private final HashSet<String> f348f = new HashSet<>();

    /* renamed from: g */
    private final HashMap<String, String> f349g = new HashMap<>();

    /* renamed from: h */
    private final Map<View, Boolean> f350h = new WeakHashMap();

    /* renamed from: i */
    private boolean f351i;

    /* renamed from: com.iab.omid.library.unity3d.walking.a$a */
    public static class a {

        /* renamed from: a */
        private final C0815e f352a;

        /* renamed from: b */
        private final ArrayList<String> f353b = new ArrayList<>();

        public a(C0815e c0815e, String str) {
            this.f352a = c0815e;
            m311a(str);
        }

        /* renamed from: a */
        public C0815e m310a() {
            return this.f352a;
        }

        /* renamed from: a */
        public void m311a(String str) {
            this.f353b.add(str);
        }

        /* renamed from: b */
        public ArrayList<String> m312b() {
            return this.f353b;
        }
    }

    /* renamed from: a */
    private String m295a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (m298b(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String m271a = C0833h.m271a(view);
            if (m271a != null) {
                return m271a;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f346d.addAll(hashSet);
        return null;
    }

    /* renamed from: a */
    private void m296a(C0803a c0803a) {
        Iterator<C0815e> it = c0803a.m105d().iterator();
        while (it.hasNext()) {
            m297a(it.next(), c0803a);
        }
    }

    /* renamed from: a */
    private void m297a(C0815e c0815e, C0803a c0803a) {
        View view = c0815e.m162c().get();
        if (view == null) {
            return;
        }
        a aVar = this.f344b.get(view);
        if (aVar != null) {
            aVar.m311a(c0803a.getAdSessionId());
        } else {
            this.f344b.put(view, new a(c0815e, c0803a.getAdSessionId()));
        }
    }

    /* renamed from: b */
    private Boolean m298b(View view) {
        if (view.hasWindowFocus()) {
            this.f350h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f350h.containsKey(view)) {
            return this.f350h.get(view);
        }
        Map<View, Boolean> map = this.f350h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    /* renamed from: a */
    public View m299a(String str) {
        return this.f345c.get(str);
    }

    /* renamed from: a */
    public void m300a() {
        this.f343a.clear();
        this.f344b.clear();
        this.f345c.clear();
        this.f346d.clear();
        this.f347e.clear();
        this.f348f.clear();
        this.f349g.clear();
        this.f351i = false;
    }

    /* renamed from: b */
    public String m301b(String str) {
        return this.f349g.get(str);
    }

    /* renamed from: b */
    public HashSet<String> m302b() {
        return this.f348f;
    }

    /* renamed from: c */
    public a m303c(View view) {
        a aVar = this.f344b.get(view);
        if (aVar != null) {
            this.f344b.remove(view);
        }
        return aVar;
    }

    /* renamed from: c */
    public HashSet<String> m304c() {
        return this.f347e;
    }

    /* renamed from: d */
    public String m305d(View view) {
        if (this.f343a.size() == 0) {
            return null;
        }
        String str = this.f343a.get(view);
        if (str != null) {
            this.f343a.remove(view);
        }
        return str;
    }

    /* renamed from: d */
    public void m306d() {
        this.f351i = true;
    }

    /* renamed from: e */
    public EnumC0845c m307e(View view) {
        return this.f346d.contains(view) ? EnumC0845c.PARENT_VIEW : this.f351i ? EnumC0845c.OBSTRUCTION_VIEW : EnumC0845c.UNDERLYING_VIEW;
    }

    /* renamed from: e */
    public void m308e() {
        C0813c m145c = C0813c.m145c();
        if (m145c != null) {
            for (C0803a c0803a : m145c.m146a()) {
                View m104c = c0803a.m104c();
                if (c0803a.m107f()) {
                    String adSessionId = c0803a.getAdSessionId();
                    if (m104c != null) {
                        String m295a = m295a(m104c);
                        if (m295a == null) {
                            this.f347e.add(adSessionId);
                            this.f343a.put(m104c, adSessionId);
                            m296a(c0803a);
                        } else if (m295a != "noWindowFocus") {
                            this.f348f.add(adSessionId);
                            this.f345c.put(adSessionId, m104c);
                            this.f349g.put(adSessionId, m295a);
                        }
                    } else {
                        this.f348f.add(adSessionId);
                        this.f349g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: f */
    public boolean m309f(View view) {
        if (!this.f350h.containsKey(view)) {
            return true;
        }
        this.f350h.put(view, Boolean.TRUE);
        return false;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/walking/C0844b.java =====
package com.iab.omid.library.unity3d.walking;

import com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b;
import com.iab.omid.library.unity3d.walking.async.AsyncTaskC0841d;
import com.iab.omid.library.unity3d.walking.async.AsyncTaskC0842e;
import com.iab.omid.library.unity3d.walking.async.AsyncTaskC0843f;
import com.iab.omid.library.unity3d.walking.async.C0840c;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.walking.b */
/* loaded from: classes.dex */
public class C0844b implements AbstractAsyncTaskC0839b.b {

    /* renamed from: a */
    private JSONObject f363a;

    /* renamed from: b */
    private final C0840c f364b;

    public C0844b(C0840c c0840c) {
        this.f364b = c0840c;
    }

    @Override // com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b.b
    /* renamed from: a */
    public JSONObject mo317a() {
        return this.f363a;
    }

    @Override // com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b.b
    /* renamed from: a */
    public void mo318a(JSONObject jSONObject) {
        this.f363a = jSONObject;
    }

    /* renamed from: a */
    public void m326a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f364b.m320b(new AsyncTaskC0842e(this, hashSet, jSONObject, j));
    }

    /* renamed from: b */
    public void m327b() {
        this.f364b.m320b(new AsyncTaskC0841d(this));
    }

    /* renamed from: b */
    public void m328b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f364b.m320b(new AsyncTaskC0843f(this, hashSet, jSONObject, j));
    }
}

// ===== FILE: com/iab/omid/library/unity3d/walking/EnumC0845c.java =====
package com.iab.omid.library.unity3d.walking;

/* renamed from: com.iab.omid.library.unity3d.walking.c */
/* loaded from: classes.dex */
public enum EnumC0845c {
    PARENT_VIEW,
    OBSTRUCTION_VIEW,
    UNDERLYING_VIEW
}

// ===== FILE: com/iab/omid/library/unity3d/walking/TreeWalker.java =====
package com.iab.omid.library.unity3d.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.internal.C0813c;
import com.iab.omid.library.unity3d.processor.C0820b;
import com.iab.omid.library.unity3d.processor.InterfaceC0819a;
import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0831f;
import com.iab.omid.library.unity3d.utils.C0833h;
import com.iab.omid.library.unity3d.walking.C0837a;
import com.iab.omid.library.unity3d.walking.async.C0840c;
import com.iab.omid.library.unity3d.weakreference.C0846a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TreeWalker implements InterfaceC0819a.a {

    /* renamed from: i */
    private static TreeWalker f329i = new TreeWalker();

    /* renamed from: j */
    private static Handler f330j = new Handler(Looper.getMainLooper());

    /* renamed from: k */
    private static Handler f331k = null;

    /* renamed from: l */
    private static final Runnable f332l = new RunnableC0835b();

    /* renamed from: m */
    private static final Runnable f333m = new RunnableC0836c();

    /* renamed from: b */
    private int f335b;

    /* renamed from: h */
    private long f341h;

    /* renamed from: a */
    private List<TreeWalkerTimeLogger> f334a = new ArrayList();

    /* renamed from: c */
    private boolean f336c = false;

    /* renamed from: d */
    private final List<C0846a> f337d = new ArrayList();

    /* renamed from: f */
    private C0837a f339f = new C0837a();

    /* renamed from: e */
    private C0820b f338e = new C0820b();

    /* renamed from: g */
    private C0844b f340g = new C0844b(new C0840c());

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    /* renamed from: com.iab.omid.library.unity3d.walking.TreeWalker$a */
    class RunnableC0834a implements Runnable {
        RunnableC0834a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f340g.m327b();
        }
    }

    /* renamed from: com.iab.omid.library.unity3d.walking.TreeWalker$b */
    class RunnableC0835b implements Runnable {
        RunnableC0835b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().m290l();
        }
    }

    /* renamed from: com.iab.omid.library.unity3d.walking.TreeWalker$c */
    class RunnableC0836c implements Runnable {
        RunnableC0836c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f331k != null) {
                TreeWalker.f331k.post(TreeWalker.f332l);
                TreeWalker.f331k.postDelayed(TreeWalker.f333m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m278a(long j) {
        if (this.f334a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f334a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f335b, TimeUnit.NANOSECONDS.toMillis(j));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f335b, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m279a(View view, InterfaceC0819a interfaceC0819a, JSONObject jSONObject, EnumC0845c enumC0845c, boolean z) {
        interfaceC0819a.mo191a(view, jSONObject, this, enumC0845c == EnumC0845c.PARENT_VIEW, z);
    }

    /* renamed from: a */
    private void m280a(String str, View view, JSONObject jSONObject) {
        InterfaceC0819a m194b = this.f338e.m194b();
        String m301b = this.f339f.m301b(str);
        if (m301b != null) {
            JSONObject mo190a = m194b.mo190a(view);
            C0828c.m237a(mo190a, str);
            C0828c.m243b(mo190a, m301b);
            C0828c.m239a(jSONObject, mo190a);
        }
    }

    /* renamed from: a */
    private boolean m281a(View view, JSONObject jSONObject) {
        C0837a.a m303c = this.f339f.m303c(view);
        if (m303c == null) {
            return false;
        }
        C0828c.m235a(jSONObject, m303c);
        return true;
    }

    /* renamed from: b */
    private boolean m284b(View view, JSONObject jSONObject) {
        String m305d = this.f339f.m305d(view);
        if (m305d == null) {
            return false;
        }
        C0828c.m237a(jSONObject, m305d);
        C0828c.m236a(jSONObject, Boolean.valueOf(this.f339f.m309f(view)));
        this.f339f.m306d();
        return true;
    }

    /* renamed from: d */
    private void m286d() {
        m278a(C0831f.m256b() - this.f341h);
    }

    /* renamed from: e */
    private void m287e() {
        this.f335b = 0;
        this.f337d.clear();
        this.f336c = false;
        Iterator<C0803a> it = C0813c.m145c().m146a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().m106e()) {
                this.f336c = true;
                break;
            }
        }
        this.f341h = C0831f.m256b();
    }

    public static TreeWalker getInstance() {
        return f329i;
    }

    /* renamed from: i */
    private void m288i() {
        if (f331k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f331k = handler;
            handler.post(f332l);
            f331k.postDelayed(f333m, 200L);
        }
    }

    /* renamed from: k */
    private void m289k() {
        Handler handler = f331k;
        if (handler != null) {
            handler.removeCallbacks(f333m);
            f331k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m290l() {
        m287e();
        m291f();
        m286d();
    }

    @Override // com.iab.omid.library.unity3d.processor.InterfaceC0819a.a
    /* renamed from: a */
    public void mo192a(View view, InterfaceC0819a interfaceC0819a, JSONObject jSONObject, boolean z) {
        EnumC0845c m307e;
        if (C0833h.m274d(view) && (m307e = this.f339f.m307e(view)) != EnumC0845c.UNDERLYING_VIEW) {
            JSONObject mo190a = interfaceC0819a.mo190a(view);
            C0828c.m239a(jSONObject, mo190a);
            if (!m284b(view, mo190a)) {
                boolean z2 = z || m281a(view, mo190a);
                if (this.f336c && m307e == EnumC0845c.OBSTRUCTION_VIEW && !z2) {
                    this.f337d.add(new C0846a(view));
                }
                m279a(view, interfaceC0819a, mo190a, m307e, z2);
            }
            this.f335b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f334a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f334a.add(treeWalkerTimeLogger);
    }

    /* renamed from: f */
    void m291f() {
        this.f339f.m308e();
        long m256b = C0831f.m256b();
        InterfaceC0819a m193a = this.f338e.m193a();
        if (this.f339f.m302b().size() > 0) {
            Iterator<String> it = this.f339f.m302b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject mo190a = m193a.mo190a(null);
                m280a(next, this.f339f.m299a(next), mo190a);
                C0828c.m242b(mo190a);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(next);
                this.f340g.m326a(mo190a, hashSet, m256b);
            }
        }
        if (this.f339f.m304c().size() > 0) {
            JSONObject mo190a2 = m193a.mo190a(null);
            m279a(null, m193a, mo190a2, EnumC0845c.PARENT_VIEW, false);
            C0828c.m242b(mo190a2);
            this.f340g.m328b(mo190a2, this.f339f.m304c(), m256b);
            if (this.f336c) {
                Iterator<C0803a> it2 = C0813c.m145c().m146a().iterator();
                while (it2.hasNext()) {
                    it2.next().m102a(this.f337d);
                }
            }
        } else {
            this.f340g.m327b();
        }
        this.f339f.m300a();
    }

    /* renamed from: g */
    public void m292g() {
        m289k();
    }

    /* renamed from: h */
    public void m293h() {
        m288i();
    }

    /* renamed from: j */
    public void m294j() {
        m292g();
        this.f334a.clear();
        f330j.post(new RunnableC0834a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f334a.contains(treeWalkerTimeLogger)) {
            this.f334a.remove(treeWalkerTimeLogger);
        }
    }
}
