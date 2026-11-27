
// ===== FILE: com/iab/omid/library/unity3d/adsession/AdEvents.java =====
package com.iab.omid.library.unity3d.adsession;

import com.iab.omid.library.unity3d.adsession.media.VastProperties;
import com.iab.omid.library.unity3d.utils.C0832g;

/* loaded from: classes.dex */
public final class AdEvents {
    private final C0803a adSession;

    private AdEvents(C0803a c0803a) {
        this.adSession = c0803a;
    }

    public static AdEvents createAdEvents(AdSession adSession) {
        C0803a c0803a = (C0803a) adSession;
        C0832g.m261a(adSession, "AdSession is null");
        C0832g.m269g(c0803a);
        C0832g.m264b(c0803a);
        AdEvents adEvents = new AdEvents(c0803a);
        c0803a.getAdSessionStatePublisher().m201a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        C0832g.m264b(this.adSession);
        C0832g.m267e(this.adSession);
        if (!this.adSession.m107f()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.m107f()) {
            this.adSession.m112k();
        }
    }

    public void loaded() {
        C0832g.m260a(this.adSession);
        C0832g.m267e(this.adSession);
        this.adSession.m113l();
    }

    public void loaded(VastProperties vastProperties) {
        C0832g.m261a(vastProperties, "VastProperties is null");
        C0832g.m260a(this.adSession);
        C0832g.m267e(this.adSession);
        this.adSession.m103a(vastProperties.m114a());
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/AdSession.java =====
package com.iab.omid.library.unity3d.adsession;

import android.view.View;
import com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher;
import com.iab.omid.library.unity3d.utils.C0832g;

/* loaded from: classes.dex */
public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        C0832g.m258a();
        C0832g.m261a(adSessionConfiguration, "AdSessionConfiguration is null");
        C0832g.m261a(adSessionContext, "AdSessionContext is null");
        return new C0803a(adSessionConfiguration, adSessionContext);
    }

    public abstract void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str);

    public abstract void error(ErrorType errorType, String str);

    public abstract void finish();

    public abstract String getAdSessionId();

    public abstract AdSessionStatePublisher getAdSessionStatePublisher();

    public abstract void registerAdView(View view);

    public abstract void removeAllFriendlyObstructions();

    public abstract void removeFriendlyObstruction(View view);

    public abstract void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener);

    public abstract void start();
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/AdSessionConfiguration.java =====
package com.iab.omid.library.unity3d.adsession;

import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0832g;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdSessionConfiguration {
    private final CreativeType creativeType;
    private final Owner impressionOwner;
    private final ImpressionType impressionType;
    private final boolean isolateVerificationScripts;
    private final Owner mediaEventsOwner;

    private AdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        this.creativeType = creativeType;
        this.impressionType = impressionType;
        this.impressionOwner = owner;
        if (owner2 == null) {
            this.mediaEventsOwner = Owner.NONE;
        } else {
            this.mediaEventsOwner = owner2;
        }
        this.isolateVerificationScripts = z;
    }

    public static AdSessionConfiguration createAdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        C0832g.m261a(creativeType, "CreativeType is null");
        C0832g.m261a(impressionType, "ImpressionType is null");
        C0832g.m261a(owner, "Impression owner is null");
        C0832g.m259a(owner, creativeType, impressionType);
        return new AdSessionConfiguration(creativeType, impressionType, owner, owner2, z);
    }

    public boolean isNativeImpressionOwner() {
        return Owner.NATIVE == this.impressionOwner;
    }

    public boolean isNativeMediaEventsOwner() {
        return Owner.NATIVE == this.mediaEventsOwner;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, "impressionOwner", this.impressionOwner);
        C0828c.m238a(jSONObject, "mediaEventsOwner", this.mediaEventsOwner);
        C0828c.m238a(jSONObject, "creativeType", this.creativeType);
        C0828c.m238a(jSONObject, "impressionType", this.impressionType);
        C0828c.m238a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.isolateVerificationScripts));
        return jSONObject;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/AdSessionContext.java =====
package com.iab.omid.library.unity3d.adsession;

import android.webkit.WebView;
import com.iab.omid.library.unity3d.utils.C0832g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class AdSessionContext {
    private final AdSessionContextType adSessionContextType;
    private final String contentUrl;
    private final String customReferenceData;
    private final Map<String, VerificationScriptResource> injectedResourcesMap;
    private final String omidJsScriptContent;
    private final Partner partner;
    private final List<VerificationScriptResource> verificationScriptResources;
    private final WebView webView;

    private AdSessionContext(Partner partner, WebView webView, String str, List<VerificationScriptResource> list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.verificationScriptResources = arrayList;
        this.injectedResourcesMap = new HashMap();
        this.partner = partner;
        this.webView = webView;
        this.omidJsScriptContent = str;
        this.adSessionContextType = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (VerificationScriptResource verificationScriptResource : list) {
                this.injectedResourcesMap.put(UUID.randomUUID().toString(), verificationScriptResource);
            }
        }
        this.contentUrl = str2;
        this.customReferenceData = str3;
    }

    public static AdSessionContext createHtmlAdSessionContext(Partner partner, WebView webView, String str, String str2) {
        C0832g.m261a(partner, "Partner is null");
        C0832g.m261a(webView, "WebView is null");
        if (str2 != null) {
            C0832g.m262a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    public static AdSessionContext createJavascriptAdSessionContext(Partner partner, WebView webView, String str, String str2) {
        C0832g.m261a(partner, "Partner is null");
        C0832g.m261a(webView, "WebView is null");
        if (str2 != null) {
            C0832g.m262a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, webView, null, null, str, str2, AdSessionContextType.JAVASCRIPT);
    }

    public static AdSessionContext createNativeAdSessionContext(Partner partner, String str, List<VerificationScriptResource> list, String str2, String str3) {
        C0832g.m261a(partner, "Partner is null");
        C0832g.m261a((Object) str, "OM SDK JS script content is null");
        C0832g.m261a(list, "VerificationScriptResources is null");
        if (str3 != null) {
            C0832g.m262a(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType getAdSessionContextType() {
        return this.adSessionContextType;
    }

    public String getContentUrl() {
        return this.contentUrl;
    }

    public String getCustomReferenceData() {
        return this.customReferenceData;
    }

    public Map<String, VerificationScriptResource> getInjectedResourcesMap() {
        return Collections.unmodifiableMap(this.injectedResourcesMap);
    }

    public String getOmidJsScriptContent() {
        return this.omidJsScriptContent;
    }

    public Partner getPartner() {
        return this.partner;
    }

    public List<VerificationScriptResource> getVerificationScriptResources() {
        return Collections.unmodifiableList(this.verificationScriptResources);
    }

    public WebView getWebView() {
        return this.webView;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/AdSessionContextType.java =====
package com.iab.omid.library.unity3d.adsession;

/* loaded from: classes.dex */
public enum AdSessionContextType {
    HTML("html"),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.typeString;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/C0803a.java =====
package com.iab.omid.library.unity3d.adsession;

import android.view.View;
import com.iab.omid.library.unity3d.internal.C0811a;
import com.iab.omid.library.unity3d.internal.C0813c;
import com.iab.omid.library.unity3d.internal.C0815e;
import com.iab.omid.library.unity3d.internal.C0818h;
import com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher;
import com.iab.omid.library.unity3d.publisher.C0824a;
import com.iab.omid.library.unity3d.publisher.C0825b;
import com.iab.omid.library.unity3d.utils.C0832g;
import com.iab.omid.library.unity3d.weakreference.C0846a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.adsession.a */
/* loaded from: classes.dex */
public class C0803a extends AdSession {

    /* renamed from: l */
    private static final Pattern f242l = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a */
    private final AdSessionContext f243a;

    /* renamed from: b */
    private final AdSessionConfiguration f244b;

    /* renamed from: d */
    private C0846a f246d;

    /* renamed from: e */
    private AdSessionStatePublisher f247e;

    /* renamed from: h */
    private final String f250h;

    /* renamed from: i */
    private boolean f251i;

    /* renamed from: j */
    private boolean f252j;

    /* renamed from: k */
    private PossibleObstructionListener f253k;

    /* renamed from: c */
    private final List<C0815e> f245c = new ArrayList();

    /* renamed from: f */
    private boolean f248f = false;

    /* renamed from: g */
    private boolean f249g = false;

    C0803a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f244b = adSessionConfiguration;
        this.f243a = adSessionContext;
        String uuid = UUID.randomUUID().toString();
        this.f250h = uuid;
        m101d(null);
        this.f247e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new C0824a(uuid, adSessionContext.getWebView()) : new C0825b(uuid, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f247e.mo221i();
        C0813c.m145c().m147a(this);
        this.f247e.m202a(adSessionConfiguration);
    }

    /* renamed from: a */
    private void m95a() {
        if (this.f251i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: a */
    private static void m96a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: a */
    private void m97a(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f242l.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    /* renamed from: b */
    private C0815e m98b(View view) {
        for (C0815e c0815e : this.f245c) {
            if (c0815e.m162c().get() == view) {
                return c0815e;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m99b() {
        if (this.f252j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    /* renamed from: c */
    private void m100c(View view) {
        Collection<C0803a> m148b = C0813c.m145c().m148b();
        if (m148b == null || m148b.isEmpty()) {
            return;
        }
        for (C0803a c0803a : m148b) {
            if (c0803a != this && c0803a.m104c() == view) {
                c0803a.f246d.clear();
            }
        }
    }

    /* renamed from: d */
    private void m101d(View view) {
        this.f246d = new C0846a(view);
    }

    /* renamed from: a */
    public void m102a(List<C0846a> list) {
        if (m106e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<C0846a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f253k.onPossibleObstructionsDetected(this.f250h, arrayList);
        }
    }

    /* renamed from: a */
    void m103a(JSONObject jSONObject) {
        m99b();
        getAdSessionStatePublisher().m211a(jSONObject);
        this.f252j = true;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (this.f249g) {
            return;
        }
        m96a(view);
        m97a(str);
        if (m98b(view) == null) {
            this.f245c.add(new C0815e(view, friendlyObstructionPurpose, str));
        }
    }

    /* renamed from: c */
    public View m104c() {
        return this.f246d.get();
    }

    /* renamed from: d */
    public List<C0815e> m105d() {
        return this.f245c;
    }

    /* renamed from: e */
    public boolean m106e() {
        return this.f253k != null;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f249g) {
            throw new IllegalStateException("AdSession is finished");
        }
        C0832g.m261a(errorType, "Error type is null");
        C0832g.m263a(str, "Message is null");
        getAdSessionStatePublisher().m203a(errorType, str);
    }

    /* renamed from: f */
    public boolean m107f() {
        return this.f248f && !this.f249g;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void finish() {
        if (this.f249g) {
            return;
        }
        this.f246d.clear();
        removeAllFriendlyObstructions();
        this.f249g = true;
        getAdSessionStatePublisher().m218f();
        C0813c.m145c().m149b(this);
        getAdSessionStatePublisher().mo213b();
        this.f247e = null;
        this.f253k = null;
    }

    /* renamed from: g */
    public boolean m108g() {
        return this.f249g;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public String getAdSessionId() {
        return this.f250h;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f247e;
    }

    /* renamed from: h */
    public boolean m109h() {
        return this.f244b.isNativeImpressionOwner();
    }

    /* renamed from: i */
    public boolean m110i() {
        return this.f244b.isNativeMediaEventsOwner();
    }

    /* renamed from: j */
    public boolean m111j() {
        return this.f248f;
    }

    /* renamed from: k */
    void m112k() {
        m95a();
        getAdSessionStatePublisher().m219g();
        this.f251i = true;
    }

    /* renamed from: l */
    void m113l() {
        m99b();
        getAdSessionStatePublisher().m220h();
        this.f252j = true;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void registerAdView(View view) {
        if (this.f249g) {
            return;
        }
        C0832g.m261a(view, "AdView is null");
        if (m104c() == view) {
            return;
        }
        m101d(view);
        getAdSessionStatePublisher().m198a();
        m100c(view);
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f249g) {
            return;
        }
        this.f245c.clear();
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f249g) {
            return;
        }
        m96a(view);
        C0815e m98b = m98b(view);
        if (m98b != null) {
            this.f245c.remove(m98b);
        }
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f253k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void start() {
        if (this.f248f) {
            return;
        }
        this.f248f = true;
        C0813c.m145c().m150c(this);
        this.f247e.m199a(C0818h.m185c().m187b());
        this.f247e.m210a(C0811a.m136a().m140b());
        this.f247e.mo204a(this, this.f243a);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/CreativeType.java =====
package com.iab.omid.library.unity3d.adsession;

import com.unity3d.services.core.device.MimeTypes;

/* loaded from: classes.dex */
public enum CreativeType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);

    private final String creativeType;

    CreativeType(String str) {
        this.creativeType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.creativeType;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/DeviceCategory.java =====
package com.iab.omid.library.unity3d.adsession;

/* loaded from: classes.dex */
public enum DeviceCategory {
    CTV("ctv"),
    MOBILE("mobile"),
    OTHER("other");

    private final String deviceCategory;

    DeviceCategory(String str) {
        this.deviceCategory = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.deviceCategory;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/ErrorType.java =====
package com.iab.omid.library.unity3d.adsession;

import com.unity3d.services.core.device.MimeTypes;

/* loaded from: classes.dex */
public enum ErrorType {
    GENERIC("generic"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO);

    private final String errorType;

    ErrorType(String str) {
        this.errorType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.errorType;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/FriendlyObstructionPurpose.java =====
package com.iab.omid.library.unity3d.adsession;

/* loaded from: classes.dex */
public enum FriendlyObstructionPurpose {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/ImpressionType.java =====
package com.iab.omid.library.unity3d.adsession;

/* loaded from: classes.dex */
public enum ImpressionType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");

    private final String impressionType;

    ImpressionType(String str) {
        this.impressionType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.impressionType;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/OutputDeviceStatus.java =====
package com.iab.omid.library.unity3d.adsession;

/* loaded from: classes.dex */
public enum OutputDeviceStatus {
    NOT_DETECTED,
    UNKNOWN
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/Owner.java =====
package com.iab.omid.library.unity3d.adsession;

/* loaded from: classes.dex */
public enum Owner {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");

    private final String owner;

    Owner(String str) {
        this.owner = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.owner;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/Partner.java =====
package com.iab.omid.library.unity3d.adsession;

import com.iab.omid.library.unity3d.utils.C0832g;

/* loaded from: classes.dex */
public class Partner {
    private final String name;
    private final String version;

    private Partner(String str, String str2) {
        this.name = str;
        this.version = str2;
    }

    public static Partner createPartner(String str, String str2) {
        C0832g.m263a(str, "Name is null or empty");
        C0832g.m263a(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/PossibleObstructionListener.java =====
package com.iab.omid.library.unity3d.adsession;

import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
public interface PossibleObstructionListener {
    void onPossibleObstructionsDetected(String str, List<View> list);
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/VerificationScriptResource.java =====
package com.iab.omid.library.unity3d.adsession;

import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0832g;
import java.net.URL;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class VerificationScriptResource {
    private final URL resourceUrl;
    private final String vendorKey;
    private final String verificationParameters;

    private VerificationScriptResource(String str, URL url, String str2) {
        this.vendorKey = str;
        this.resourceUrl = url;
        this.verificationParameters = str2;
    }

    public static VerificationScriptResource createVerificationScriptResourceWithParameters(String str, URL url, String str2) {
        C0832g.m263a(str, "VendorKey is null or empty");
        C0832g.m261a(url, "ResourceURL is null");
        C0832g.m263a(str2, "VerificationParameters is null or empty");
        return new VerificationScriptResource(str, url, str2);
    }

    public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(URL url) {
        C0832g.m261a(url, "ResourceURL is null");
        return new VerificationScriptResource(null, url, null);
    }

    public URL getResourceUrl() {
        return this.resourceUrl;
    }

    public String getVendorKey() {
        return this.vendorKey;
    }

    public String getVerificationParameters() {
        return this.verificationParameters;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, "vendorKey", this.vendorKey);
        C0828c.m238a(jSONObject, "resourceUrl", this.resourceUrl.toString());
        C0828c.m238a(jSONObject, "verificationParameters", this.verificationParameters);
        return jSONObject;
    }
}
