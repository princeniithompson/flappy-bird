
// ===== FILE: com/iab/omid/library/unity3d/adsession/media/InteractionType.java =====
package com.iab.omid.library.unity3d.adsession.media;

/* loaded from: classes.dex */
public enum InteractionType {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");

    String interactionType;

    InteractionType(String str) {
        this.interactionType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.interactionType;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/media/MediaEvents.java =====
package com.iab.omid.library.unity3d.adsession.media;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.internal.C0818h;
import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.utils.C0832g;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MediaEvents {
    private final C0803a adSession;

    private MediaEvents(C0803a c0803a) {
        this.adSession = c0803a;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession) {
        C0803a c0803a = (C0803a) adSession;
        C0832g.m261a(adSession, "AdSession is null");
        C0832g.m268f(c0803a);
        C0832g.m265c(c0803a);
        C0832g.m264b(c0803a);
        C0832g.m270h(c0803a);
        MediaEvents mediaEvents = new MediaEvents(c0803a);
        c0803a.getAdSessionStatePublisher().m206a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        C0832g.m261a(interactionType, "InteractionType is null");
        C0832g.m260a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().m209a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("bufferFinish");
    }

    public void bufferStart() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("bufferStart");
    }

    public void complete() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("complete");
    }

    public void firstQuartile() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("firstQuartile");
    }

    public void midpoint() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("midpoint");
    }

    public void pause() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        C0832g.m261a(playerState, "PlayerState is null");
        C0832g.m260a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, "state", playerState);
        this.adSession.getAdSessionStatePublisher().m209a("playerStateChange", jSONObject);
    }

    public void resume() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("resume");
    }

    public void skipped() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("skipped");
    }

    public void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        C0832g.m260a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, TypedValues.TransitionType.S_DURATION, Float.valueOf(f));
        C0828c.m238a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        C0828c.m238a(jSONObject, "deviceVolume", Float.valueOf(C0818h.m185c().m187b()));
        this.adSession.getAdSessionStatePublisher().m209a("start", jSONObject);
    }

    public void thirdQuartile() {
        C0832g.m260a(this.adSession);
        this.adSession.getAdSessionStatePublisher().m207a("thirdQuartile");
    }

    public void volumeChange(float f) {
        confirmValidVolume(f);
        C0832g.m260a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C0828c.m238a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        C0828c.m238a(jSONObject, "deviceVolume", Float.valueOf(C0818h.m185c().m187b()));
        this.adSession.getAdSessionStatePublisher().m209a("volumeChange", jSONObject);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/media/PlayerState.java =====
package com.iab.omid.library.unity3d.adsession.media;

/* loaded from: classes.dex */
public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");

    private final String playerState;

    PlayerState(String str) {
        this.playerState = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.playerState;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/media/Position.java =====
package com.iab.omid.library.unity3d.adsession.media;

/* loaded from: classes.dex */
public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private final String position;

    Position(String str) {
        this.position = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.position;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/adsession/media/VastProperties.java =====
package com.iab.omid.library.unity3d.adsession.media;

import com.iab.omid.library.unity3d.utils.C0829d;
import com.iab.omid.library.unity3d.utils.C0832g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class VastProperties {

    /* renamed from: a */
    private final boolean f254a;

    /* renamed from: b */
    private final Float f255b;

    /* renamed from: c */
    private final boolean f256c;

    /* renamed from: d */
    private final Position f257d;

    private VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f254a = z;
        this.f255b = f;
        this.f256c = z2;
        this.f257d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z, Position position) {
        C0832g.m261a(position, "Position is null");
        return new VastProperties(false, null, z, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f, boolean z, Position position) {
        C0832g.m261a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position);
    }

    /* renamed from: a */
    public JSONObject m114a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f254a);
            if (this.f254a) {
                jSONObject.put("skipOffset", this.f255b);
            }
            jSONObject.put("autoPlay", this.f256c);
            jSONObject.put("position", this.f257d);
        } catch (JSONException e) {
            C0829d.m252a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f257d;
    }

    public Float getSkipOffset() {
        return this.f255b;
    }

    public boolean isAutoPlay() {
        return this.f256c;
    }

    public boolean isSkippable() {
        return this.f254a;
    }
}
