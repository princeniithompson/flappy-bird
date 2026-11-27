
// ===== FILE: com/iab/omid/library/unity3d/devicevolume/C0806a.java =====
package com.iab.omid.library.unity3d.devicevolume;

/* renamed from: com.iab.omid.library.unity3d.devicevolume.a */
/* loaded from: classes.dex */
public class C0806a {
    /* renamed from: a */
    public float m127a(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            return 0.0f;
        }
        float f = i / i2;
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/devicevolume/C0807b.java =====
package com.iab.omid.library.unity3d.devicevolume;

/* renamed from: com.iab.omid.library.unity3d.devicevolume.b */
/* loaded from: classes.dex */
public class C0807b {
    /* renamed from: a */
    public C0806a m128a() {
        return new C0806a();
    }
}

// ===== FILE: com/iab/omid/library/unity3d/devicevolume/C0809d.java =====
package com.iab.omid.library.unity3d.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

/* renamed from: com.iab.omid.library.unity3d.devicevolume.d */
/* loaded from: classes.dex */
public final class C0809d extends ContentObserver {

    /* renamed from: a */
    private final Context f266a;

    /* renamed from: b */
    private final AudioManager f267b;

    /* renamed from: c */
    private final C0806a f268c;

    /* renamed from: d */
    private final InterfaceC0808c f269d;

    /* renamed from: e */
    private float f270e;

    public C0809d(Handler handler, Context context, C0806a c0806a, InterfaceC0808c interfaceC0808c) {
        super(handler);
        this.f266a = context;
        this.f267b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f268c = c0806a;
        this.f269d = interfaceC0808c;
    }

    /* renamed from: a */
    private float m130a() {
        return this.f268c.m127a(this.f267b.getStreamVolume(3), this.f267b.getStreamMaxVolume(3));
    }

    /* renamed from: a */
    private boolean m131a(float f) {
        return f != this.f270e;
    }

    /* renamed from: b */
    private void m132b() {
        this.f269d.mo129a(this.f270e);
    }

    /* renamed from: c */
    public void m133c() {
        this.f270e = m130a();
        m132b();
        this.f266a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: d */
    public void m134d() {
        this.f266a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        float m130a = m130a();
        if (m131a(m130a)) {
            this.f270e = m130a;
            m132b();
        }
    }
}

// ===== FILE: com/iab/omid/library/unity3d/devicevolume/C0810e.java =====
package com.iab.omid.library.unity3d.devicevolume;

import android.content.Context;
import android.os.Handler;

/* renamed from: com.iab.omid.library.unity3d.devicevolume.e */
/* loaded from: classes.dex */
public class C0810e {
    /* renamed from: a */
    public C0809d m135a(Handler handler, Context context, C0806a c0806a, InterfaceC0808c interfaceC0808c) {
        return new C0809d(handler, context, c0806a, interfaceC0808c);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/devicevolume/InterfaceC0808c.java =====
package com.iab.omid.library.unity3d.devicevolume;

/* renamed from: com.iab.omid.library.unity3d.devicevolume.c */
/* loaded from: classes.dex */
public interface InterfaceC0808c {
    /* renamed from: a */
    void mo129a(float f);
}
