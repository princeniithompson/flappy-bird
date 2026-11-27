
// ===== FILE: bitter/jnibridge/C0512a.java =====
package bitter.jnibridge;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: bitter.jnibridge.a */
/* loaded from: classes.dex */
final class C0512a implements InvocationHandler {

    /* renamed from: a */
    private Object[] f100a = new Object[0];

    /* renamed from: b */
    private long f101b;

    /* renamed from: c */
    private Constructor f102c;

    public C0512a(long j) {
        this.f101b = j;
        try {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            this.f102c = declaredConstructor;
            declaredConstructor.setAccessible(true);
        } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            this.f102c = null;
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        synchronized (this.f100a) {
            long j = this.f101b;
            if (j == 0) {
                return null;
            }
            try {
                return JNIBridge.invoke(j, method.getDeclaringClass(), method, objArr);
            } catch (NoSuchMethodError e) {
                if (this.f102c == null) {
                    System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                    throw e;
                }
                if ((method.getModifiers() & 1024) != 0) {
                    throw e;
                }
                if (objArr == null) {
                    objArr = new Object[0];
                }
                Class<?> declaringClass = method.getDeclaringClass();
                return ((MethodHandles.Lookup) this.f102c.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
            }
        }
    }
}

// ===== FILE: bitter/jnibridge/JNIBridge.java =====
package bitter.jnibridge;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class JNIBridge {
    static void disableInterfaceProxy(Object obj) {
        Object[] objArr;
        if (obj != null) {
            C0512a c0512a = (C0512a) Proxy.getInvocationHandler(obj);
            objArr = c0512a.f100a;
            synchronized (objArr) {
                c0512a.f101b = 0L;
            }
        }
    }

    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new C0512a(j));
    }
}
