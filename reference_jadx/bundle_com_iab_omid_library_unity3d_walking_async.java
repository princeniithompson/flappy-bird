
// ===== FILE: com/iab/omid/library/unity3d/walking/async/AbstractAsyncTaskC0838a.java =====
package com.iab.omid.library.unity3d.walking.async;

import com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.walking.async.a */
/* loaded from: classes.dex */
public abstract class AbstractAsyncTaskC0838a extends AbstractAsyncTaskC0839b {

    /* renamed from: c */
    protected final HashSet<String> f354c;

    /* renamed from: d */
    protected final JSONObject f355d;

    /* renamed from: e */
    protected final long f356e;

    public AbstractAsyncTaskC0838a(AbstractAsyncTaskC0839b.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar);
        this.f354c = new HashSet<>(hashSet);
        this.f355d = jSONObject;
        this.f356e = j;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/walking/async/AbstractAsyncTaskC0839b.java =====
package com.iab.omid.library.unity3d.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.walking.async.b */
/* loaded from: classes.dex */
public abstract class AbstractAsyncTaskC0839b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    private a f357a;

    /* renamed from: b */
    protected final b f358b;

    /* renamed from: com.iab.omid.library.unity3d.walking.async.b$a */
    public interface a {
        /* renamed from: a */
        void mo316a(AbstractAsyncTaskC0839b abstractAsyncTaskC0839b);
    }

    /* renamed from: com.iab.omid.library.unity3d.walking.async.b$b */
    public interface b {
        /* renamed from: a */
        JSONObject mo317a();

        /* renamed from: a */
        void mo318a(JSONObject jSONObject);
    }

    public AbstractAsyncTaskC0839b(b bVar) {
        this.f358b = bVar;
    }

    /* renamed from: a */
    public void m313a(a aVar) {
        this.f357a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f357a;
        if (aVar != null) {
            aVar.mo316a(this);
        }
    }

    /* renamed from: a */
    public void m315a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/walking/async/AsyncTaskC0841d.java =====
package com.iab.omid.library.unity3d.walking.async;

import com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b;

/* renamed from: com.iab.omid.library.unity3d.walking.async.d */
/* loaded from: classes.dex */
public class AsyncTaskC0841d extends AbstractAsyncTaskC0839b {
    public AsyncTaskC0841d(AbstractAsyncTaskC0839b.b bVar) {
        super(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        this.f358b.mo318a(null);
        return null;
    }
}

// ===== FILE: com/iab/omid/library/unity3d/walking/async/AsyncTaskC0842e.java =====
package com.iab.omid.library.unity3d.walking.async;

import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.internal.C0813c;
import com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.walking.async.e */
/* loaded from: classes.dex */
public class AsyncTaskC0842e extends AbstractAsyncTaskC0838a {
    public AsyncTaskC0842e(AbstractAsyncTaskC0839b.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m322b(String str) {
        C0813c m145c = C0813c.m145c();
        if (m145c != null) {
            for (C0803a c0803a : m145c.m148b()) {
                if (this.f354c.contains(c0803a.getAdSessionId())) {
                    c0803a.getAdSessionStatePublisher().m208a(str, this.f356e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.f355d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        m322b(str);
        super.onPostExecute(str);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/walking/async/AsyncTaskC0843f.java =====
package com.iab.omid.library.unity3d.walking.async;

import android.text.TextUtils;
import com.iab.omid.library.unity3d.adsession.C0803a;
import com.iab.omid.library.unity3d.internal.C0813c;
import com.iab.omid.library.unity3d.utils.C0828c;
import com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.unity3d.walking.async.f */
/* loaded from: classes.dex */
public class AsyncTaskC0843f extends AbstractAsyncTaskC0838a {
    public AsyncTaskC0843f(AbstractAsyncTaskC0839b.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m324b(String str) {
        C0813c m145c = C0813c.m145c();
        if (m145c != null) {
            for (C0803a c0803a : m145c.m148b()) {
                if (this.f354c.contains(c0803a.getAdSessionId())) {
                    c0803a.getAdSessionStatePublisher().m214b(str, this.f356e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        if (C0828c.m250h(this.f355d, this.f358b.mo317a())) {
            return null;
        }
        this.f358b.mo318a(this.f355d);
        return this.f355d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m324b(str);
        }
        super.onPostExecute(str);
    }
}

// ===== FILE: com/iab/omid/library/unity3d/walking/async/C0840c.java =====
package com.iab.omid.library.unity3d.walking.async;

import com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.unity3d.walking.async.c */
/* loaded from: classes.dex */
public class C0840c implements AbstractAsyncTaskC0839b.a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f359a;

    /* renamed from: b */
    private final ThreadPoolExecutor f360b;

    /* renamed from: c */
    private final ArrayDeque<AbstractAsyncTaskC0839b> f361c = new ArrayDeque<>();

    /* renamed from: d */
    private AbstractAsyncTaskC0839b f362d = null;

    public C0840c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f359a = linkedBlockingQueue;
        this.f360b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    /* renamed from: a */
    private void m319a() {
        AbstractAsyncTaskC0839b poll = this.f361c.poll();
        this.f362d = poll;
        if (poll != null) {
            poll.m315a(this.f360b);
        }
    }

    @Override // com.iab.omid.library.unity3d.walking.async.AbstractAsyncTaskC0839b.a
    /* renamed from: a */
    public void mo316a(AbstractAsyncTaskC0839b abstractAsyncTaskC0839b) {
        this.f362d = null;
        m319a();
    }

    /* renamed from: b */
    public void m320b(AbstractAsyncTaskC0839b abstractAsyncTaskC0839b) {
        abstractAsyncTaskC0839b.m313a(this);
        this.f361c.add(abstractAsyncTaskC0839b);
        if (this.f362d == null) {
            m319a();
        }
    }
}
