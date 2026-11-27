
// ===== FILE: org/fmod/FMODAudioDevice.java =====
package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class FMODAudioDevice implements Runnable {

    /* renamed from: a */
    private volatile Thread f769a = null;

    /* renamed from: b */
    private volatile boolean f770b = false;

    /* renamed from: c */
    private AudioTrack f771c = null;

    /* renamed from: d */
    private boolean f772d = false;

    /* renamed from: e */
    private ByteBuffer f773e = null;

    /* renamed from: f */
    private byte[] f774f = null;

    /* renamed from: g */
    private volatile RunnableC1490a f775g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.f771c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.f771c.stop();
            }
            this.f771c.release();
            this.f771c = null;
        }
        this.f773e = null;
        this.f774f = null;
        this.f772d = false;
    }

    public synchronized void close() {
        stop();
    }

    native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f769a != null && this.f769a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 3;
        while (this.f770b) {
            if (!this.f772d && i > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(0);
                int i2 = fmodGetInfo(4) == 1 ? 4 : 12;
                int minBufferSize = AudioTrack.getMinBufferSize(fmodGetInfo, i2, 2);
                int fmodGetInfo2 = fmodGetInfo(4) * 2;
                int round = Math.round(minBufferSize * 1.1f) & (~(fmodGetInfo2 - 1));
                int fmodGetInfo3 = fmodGetInfo(1);
                int fmodGetInfo4 = fmodGetInfo(2) * fmodGetInfo3 * fmodGetInfo2;
                AudioTrack audioTrack = new AudioTrack(3, fmodGetInfo, i2, 2, fmodGetInfo4 > round ? fmodGetInfo4 : round, 1);
                this.f771c = audioTrack;
                boolean z = audioTrack.getState() == 1;
                this.f772d = z;
                if (z) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fmodGetInfo3 * fmodGetInfo2);
                    this.f773e = allocateDirect;
                    this.f774f = new byte[allocateDirect.capacity()];
                    this.f771c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f771c.getState() + ")");
                    releaseAudioTrack();
                    i += -1;
                }
            }
            if (this.f772d) {
                if (fmodGetInfo(3) == 1) {
                    fmodProcess(this.f773e);
                    ByteBuffer byteBuffer = this.f773e;
                    byteBuffer.get(this.f774f, 0, byteBuffer.capacity());
                    this.f771c.write(this.f774f, 0, this.f773e.capacity());
                    this.f773e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f769a != null) {
            stop();
        }
        this.f769a = new Thread(this, "FMODAudioDevice");
        this.f769a.setPriority(10);
        this.f770b = true;
        this.f769a.start();
        if (this.f775g != null) {
            this.f775g.m485c();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f775g == null) {
            this.f775g = new RunnableC1490a(this, i, i2);
            this.f775g.m485c();
        }
        return this.f775g.m484a();
    }

    public synchronized void stop() {
        while (this.f769a != null) {
            this.f770b = false;
            try {
                this.f769a.join();
                this.f769a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.f775g != null) {
            this.f775g.m486d();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f775g != null) {
            this.f775g.m486d();
            this.f775g = null;
        }
    }
}

// ===== FILE: org/fmod/RunnableC1490a.java =====
package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* renamed from: org.fmod.a */
/* loaded from: classes2.dex */
final class RunnableC1490a implements Runnable {

    /* renamed from: a */
    private final FMODAudioDevice f776a;

    /* renamed from: b */
    private final ByteBuffer f777b;

    /* renamed from: c */
    private final int f778c;

    /* renamed from: d */
    private final int f779d;

    /* renamed from: e */
    private volatile Thread f780e;

    /* renamed from: f */
    private volatile boolean f781f;

    /* renamed from: g */
    private AudioRecord f782g;

    /* renamed from: h */
    private boolean f783h;

    RunnableC1490a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f776a = fMODAudioDevice;
        this.f778c = i;
        this.f779d = i2;
        this.f777b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* renamed from: b */
    private void m483b() {
        AudioRecord audioRecord = this.f782g;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.f782g.stop();
            }
            this.f782g.release();
            this.f782g = null;
        }
        this.f777b.position(0);
        this.f783h = false;
    }

    /* renamed from: a */
    public final int m484a() {
        return this.f777b.capacity();
    }

    /* renamed from: c */
    public final void m485c() {
        if (this.f780e != null) {
            m486d();
        }
        this.f781f = true;
        this.f780e = new Thread(this);
        this.f780e.start();
    }

    /* renamed from: d */
    public final void m486d() {
        while (this.f780e != null) {
            this.f781f = false;
            try {
                this.f780e.join();
                this.f780e = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 3;
        while (this.f781f) {
            if (!this.f783h && i > 0) {
                m483b();
                AudioRecord audioRecord = new AudioRecord(1, this.f778c, this.f779d, 2, this.f777b.capacity());
                this.f782g = audioRecord;
                boolean z = audioRecord.getState() == 1;
                this.f783h = z;
                if (z) {
                    this.f777b.position(0);
                    this.f782g.startRecording();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.f782g.getState() + ")");
                    i += -1;
                    m483b();
                }
            }
            if (this.f783h && this.f782g.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.f782g;
                ByteBuffer byteBuffer = this.f777b;
                this.f776a.fmodProcessMicData(this.f777b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.f777b.position(0);
            }
        }
        m483b();
    }
}
