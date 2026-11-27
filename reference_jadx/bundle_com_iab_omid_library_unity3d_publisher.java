
// ===== FILE: com/iab/omid/library/unity3d/publisher/AdSessionStatePublisher.java =====
package com.iab.omid.library.unity3d.publisher;

import android.webkit.WebView;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.adsession.ErrorType;
import com.iab.omid.library.unity3d.adsession.VerificationScriptResource;
import com.iab.omid.library.unity3d.adsession.media.MediaEvents;
import com.iab.omid.library.unity3d.internal.C0816f;
import com.iab.omid.library.unity3d.internal.C0817g;
import com.iab.omid.library.unity3d.utils.C0826a;
import com.iab.omid.library.unity3d.utils.C0827b;
import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0831f;
import com.iab.omid.library.unity3d.weakreference.C0847b;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private String f304a;

    /* renamed from: b */
    private C0847b f305b;

    /* renamed from: c */
    private AdEvents f306c;

    /* renamed from: d */
    private MediaEvents f307d;

    /* renamed from: e */
    private EnumC0823a f308e;

    /* renamed from: f */
    private long f309f;

    /* renamed from: com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher$a */
    enum EnumC0823a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        m198a();
        this.f304a = str;
        this.f305b = new C0847b(null);
    }

    /* renamed from: a */
    public void m198a() {
        this.f309f = C0831f.m256b();
        this.f308e = EnumC0823a.AD_STATE_IDLE;
    }

    /* renamed from: a */
    public void m199a(float f) {
        C0817g.m167a().m169a(getWebView(), this.f304a, f);
    }

    /* renamed from: a */
    void m200a(WebView webView) {
        this.f305b = new C0847b(webView);
    }

    /* renamed from: a */
    public void m201a(AdEvents adEvents) {
        this.f306c = adEvents;
    }

    /* renamed from: a */
    public void m202a(AdSessionConfiguration adSessionConfiguration) {
        C0817g.m167a().m173a(getWebView(), this.f304a, adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void m203a(ErrorType errorType, String str) {
        C0817g.m167a().m170a(getWebView(), this.f304a, errorType, str);
    }

    /* renamed from: a */
    public void mo204a(C0803a c0803a, AdSessionContext adSessionContext) {
        m205a(c0803a, adSessionContext, null);
    }

    /* renamed from: a */
    protected void m205a(C0803a c0803a, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = c0803a.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        C0828c.m238a(jSONObject2, "environment", "app");
        C0828c.m238a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        C0828c.m238a(jSONObject2, "deviceInfo", C0827b.m229d());
        C0828c.m238a(jSONObject2, "deviceCategory", C0826a.m224a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C0828c.m238a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C0828c.m238a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, adSessionContext.getPartner().getName());
        C0828c.m238a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, adSessionContext.getPartner().getVersion());
        C0828c.m238a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C0828c.m238a(jSONObject4, "libraryVersion", "1.4.9-Unity3d");
        C0828c.m238a(jSONObject4, "appId", C0816f.m164b().m165a().getApplicationContext().getPackageName());
        C0828c.m238a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            C0828c.m238a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            C0828c.m238a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            C0828c.m238a(jSONObject5, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        C0817g.m167a().m174a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    /* renamed from: a */
    public void m206a(MediaEvents mediaEvents) {
        this.f307d = mediaEvents;
    }

    /* renamed from: a */
    public void m207a(String str) {
        m209a(str, (JSONObject) null);
    }

    /* renamed from: a */
    public void m208a(String str, long j) {
        if (j >= this.f309f) {
            EnumC0823a enumC0823a = this.f308e;
            EnumC0823a enumC0823a2 = EnumC0823a.AD_STATE_NOTVISIBLE;
            if (enumC0823a != enumC0823a2) {
                this.f308e = enumC0823a2;
                C0817g.m167a().m171a(getWebView(), this.f304a, str);
            }
        }
    }

    /* renamed from: a */
    public void m209a(String str, JSONObject jSONObject) {
        C0817g.m167a().m172a(getWebView(), this.f304a, str, jSONObject);
    }

    /* renamed from: a */
    public void m210a(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        C0817g.m167a().m177a(getWebView(), jSONObject);
    }

    /* renamed from: a */
    public void m211a(JSONObject jSONObject) {
        C0817g.m167a().m181b(getWebView(), this.f304a, jSONObject);
    }

    /* renamed from: a */
    public void m212a(boolean z) {
        if (m217e()) {
            C0817g.m167a().m180b(getWebView(), this.f304a, z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo213b() {
        this.f305b.clear();
    }

    /* renamed from: b */
    public void m214b(String str, long j) {
        if (j >= this.f309f) {
            this.f308e = EnumC0823a.AD_STATE_VISIBLE;
            C0817g.m167a().m171a(getWebView(), this.f304a, str);
        }
    }

    /* renamed from: c */
    public AdEvents m215c() {
        return this.f306c;
    }

    /* renamed from: d */
    public MediaEvents m216d() {
        return this.f307d;
    }

    /* renamed from: e */
    public boolean m217e() {
        return this.f305b.get() != null;
    }

    /* renamed from: f */
    public void m218f() {
        C0817g.m167a().m168a(getWebView(), this.f304a);
    }

    /* renamed from: g */
    public void m219g() {
        C0817g.m167a().m179b(getWebView(), this.f304a);
    }

    public WebView getWebView() {
        return this.f305b.get();
    }

    /* renamed from: h */
    public void m220h() {
        m211a((JSONObject) null);
    }

    /* renamed from: i */
    public void mo221i() {
    }
}

// ===== FILE: com/iab/omid/library/unity3d/publisher/C0824a.java =====
package com.iab.omid.library.unity3d.publisher;

import android.webkit.WebView;

/* renamed from: com.iab.omid.library.unity3d.publisher.a */
/* loaded from: classes.dex */
public class C0824a extends AdSessionStatePublisher {
    public C0824a(String str, WebView webView) {
        super(str);
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        m200a(webView);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/publisher/C0825b.java =====
package com.iab.omid.library.unity3d.publisher;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.adsession.VerificationScriptResource;
import com.iab.omid.library.unity3d.internal.C0816f;
import com.iab.omid.library.unity3d.internal.C0817g;
import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0831f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.publisher.b */
/* loaded from: classes.dex */
public class C0825b extends AdSessionStatePublisher {

    /* renamed from: g */
    private WebView f314g;

    /* renamed from: h */
    private Long f315h;

    /* renamed from: i */
    private final Map<String, VerificationScriptResource> f316i;

    /* renamed from: j */
    private final String f317j;

    /* renamed from: com.iab.omid.library.unity3d.publisher.b$a */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (C0825b.this.getWebView() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                C0825b.this.m200a((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    /* renamed from: com.iab.omid.library.unity3d.publisher.b$b */
    class b implements Runnable {

        /* renamed from: a */
        private final WebView f319a;

        b() {
            this.f319a = C0825b.this.f314g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f319a.destroy();
        }
    }

    public C0825b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f315h = null;
        this.f316i = map;
        this.f317j = str2;
    }

    @Override // com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher
    /* renamed from: a */
    public void mo204a(C0803a c0803a, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            C0828c.m238a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        m205a(c0803a, adSessionContext, jSONObject);
    }

    @Override // com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher
    /* renamed from: b */
    public void mo213b() {
        super.mo213b();
        new Handler().postDelayed(new b(), Math.max(4000 - (this.f315h == null ? 4000L : TimeUnit.MILLISECONDS.convert(C0831f.m256b() - this.f315h.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f314g = null;
    }

    @Override // com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher
    /* renamed from: i */
    public void mo221i() {
        super.mo221i();
        m223j();
    }

    /* renamed from: j */
    void m223j() {
        WebView webView = new WebView(C0816f.m164b().m165a());
        this.f314g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f314g.getSettings().setAllowContentAccess(false);
        this.f314g.getSettings().setAllowFileAccess(false);
        this.f314g.setWebViewClient(new a());
        m200a(this.f314g);
        C0817g.m167a().m183c(this.f314g, this.f317j);
        for (String str : this.f316i.keySet()) {
            C0817g.m167a().m182c(this.f314g, this.f316i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f315h = Long.valueOf(C0831f.m256b());
    }
}
