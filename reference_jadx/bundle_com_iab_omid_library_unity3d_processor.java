
// ===== FILE: com/iab/omid/library/unity3d/processor/C0820b.java =====
package com.iab.omid.library.unity3d.processor;

/* renamed from: com.iab.omid.library.unity3d.processor.b */
/* loaded from: classes.dex */
public class C0820b {

    /* renamed from: a */
    private final C0822d f300a;

    /* renamed from: b */
    private final C0821c f301b;

    public C0820b() {
        C0822d c0822d = new C0822d();
        this.f300a = c0822d;
        this.f301b = new C0821c(c0822d);
    }

    /* renamed from: a */
    public InterfaceC0819a m193a() {
        return this.f301b;
    }

    /* renamed from: b */
    public InterfaceC0819a m194b() {
        return this.f300a;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/processor/C0821c.java =====
package com.iab.omid.library.unity3d.processor;

import android.view.View;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.internal.C0813c;
import com.iab.omid.library.unity3d.processor.InterfaceC0819a;
import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0830e;
import com.iab.omid.library.unity3d.utils.C0833h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.processor.c */
/* loaded from: classes.dex */
public class C0821c implements InterfaceC0819a {

    /* renamed from: a */
    private final InterfaceC0819a f302a;

    public C0821c(InterfaceC0819a interfaceC0819a) {
        this.f302a = interfaceC0819a;
    }

    /* renamed from: a */
    ArrayList<View> m195a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C0813c m145c = C0813c.m145c();
        if (m145c != null) {
            Collection<C0803a> m146a = m145c.m146a();
            IdentityHashMap identityHashMap = new IdentityHashMap((m146a.size() * 2) + 3);
            Iterator<C0803a> it = m146a.iterator();
            while (it.hasNext()) {
                View m104c = it.next().m104c();
                if (m104c != null && C0833h.m275e(m104c) && (rootView = m104c.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float m273c = C0833h.m273c(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C0833h.m273c(arrayList.get(size - 1)) > m273c) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    @Override // com.iab.omid.library.unity3d.processor.InterfaceC0819a
    /* renamed from: a */
    public JSONObject mo190a(View view) {
        JSONObject m232a = C0828c.m232a(0, 0, 0, 0);
        C0828c.m234a(m232a, C0830e.m253a());
        return m232a;
    }

    @Override // com.iab.omid.library.unity3d.processor.InterfaceC0819a
    /* renamed from: a */
    public void mo191a(View view, JSONObject jSONObject, InterfaceC0819a.a aVar, boolean z, boolean z2) {
        Iterator<View> it = m195a().iterator();
        while (it.hasNext()) {
            aVar.mo192a(it.next(), this.f302a, jSONObject, z2);
        }
    }
}

// ===== FILE: com/iab/omid/library/unity3d/processor/C0822d.java =====
package com.iab.omid.library.unity3d.processor;

import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.unity3d.processor.InterfaceC0819a;
import com.iab.omid.library.unity3d.utils.C0828c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.processor.d */
/* loaded from: classes.dex */
public class C0822d implements InterfaceC0819a {

    /* renamed from: a */
    private final int[] f303a = new int[2];

    /* renamed from: a */
    private void m196a(ViewGroup viewGroup, JSONObject jSONObject, InterfaceC0819a.a aVar, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo192a(viewGroup.getChildAt(i), this, jSONObject, z);
        }
    }

    /* renamed from: b */
    private void m197b(ViewGroup viewGroup, JSONObject jSONObject, InterfaceC0819a.a aVar, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.mo192a((View) it2.next(), this, jSONObject, z);
            }
        }
    }

    @Override // com.iab.omid.library.unity3d.processor.InterfaceC0819a
    /* renamed from: a */
    public JSONObject mo190a(View view) {
        if (view == null) {
            return C0828c.m232a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f303a);
        int[] iArr = this.f303a;
        return C0828c.m232a(iArr[0], iArr[1], width, height);
    }

    @Override // com.iab.omid.library.unity3d.processor.InterfaceC0819a
    /* renamed from: a */
    public void mo191a(View view, JSONObject jSONObject, InterfaceC0819a.a aVar, boolean z, boolean z2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z) {
                m197b(viewGroup, jSONObject, aVar, z2);
            } else {
                m196a(viewGroup, jSONObject, aVar, z2);
            }
        }
    }
}

// ===== FILE: com/iab/omid/library/unity3d/processor/InterfaceC0819a.java =====
package com.iab.omid.library.unity3d.processor;

import android.view.View;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.processor.a */
/* loaded from: classes.dex */
public interface InterfaceC0819a {

    /* renamed from: com.iab.omid.library.unity3d.processor.a$a */
    public interface a {
        /* renamed from: a */
        void mo192a(View view, InterfaceC0819a interfaceC0819a, JSONObject jSONObject, boolean z);
    }

    /* renamed from: a */
    JSONObject mo190a(View view);

    /* renamed from: a */
    void mo191a(View view, JSONObject jSONObject, a aVar, boolean z, boolean z2);
}
