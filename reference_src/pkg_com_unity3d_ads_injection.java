// Package bundle: com.unity3d.ads.injection (3 classes)

// ============================================================
// CLASS: com.unity3d.ads.injection.EntryKey
// ============================================================
package com.unity3d.ads.injection;

public final class EntryKey {
    private final KClass instanceClass;
    private final String named;

    public EntryKey(String p0, KClass p1) {
        new Object();
        named = p0;
        instanceClass = p1;
        return;
    }

    public EntryKey(String p0, KClass p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        new EntryKey("", p1);
        return;
    }

    public static EntryKey copy$default(EntryKey p0, String p1, KClass p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(named, instanceClass);
        return EntryKey.copy(..);
    }

    public final String component1() {
        return named;
    }

    public final KClass component2() {
        return instanceClass;
    }

    public final EntryKey copy(String p0, KClass p1) {
        new EntryKey(p0, p1);
        return new EntryKey(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(named, named);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(instanceClass, instanceClass);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        return 1;
    }

    public final KClass getInstanceClass() {
        return instanceClass;
    }

    public final String getNamed() {
        return named;
    }

    public int hashCode() {
        named.hashCode();
        instanceClass.hashCode();
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("EntryKey(named=");
        new StringBuilder(..).append(named);
        new StringBuilder(..).append(", instanceClass=");
        new StringBuilder(..).append(instanceClass);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.injection.Factory
// ============================================================
package com.unity3d.ads.injection;

public final class Factory {
    private final Function0 initializer;

    public Factory(Function0 p0) {
        new Object();
        initializer = p0;
        return;
    }

    public Object getValue() {
        initializer.invoke();
        return Function0.invoke(..);
    }

    public boolean isInitialized() {
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.injection.Registry
// ============================================================
package com.unity3d.ads.injection;

public final class Registry {
    private final MutableStateFlow _services;

    public Registry() {
        new Object();
        MapsKt.emptyMap();
        StateFlowKt.MutableStateFlow(MapsKt.emptyMap(..));
        _services = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public static EntryKey factory$default(Registry p0, String p1, Function0 p2, int p3, Object p4) {
        if (if-eqz(p3)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey("", Reflection.getOrCreateKotlinClass(..));
        new Factory(p2);
        p0.add(new EntryKey(..), new Factory(..));
        return new EntryKey(..);
    }

    public static Object get$default(Registry p0, String p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey("", Reflection.getOrCreateKotlinClass(..));
        p0.getServices();
        Registry.getServices(..).get(new EntryKey(..));
        if (if-eqz(Map.get(..))) goto L_33;
        Map.get(..).getValue();
        Intrinsics.reifiedOperationMarker(1, "T");
        return Lazy.getValue(..);
      L_33:
        new StringBuilder("No entry found for ");
        new StringBuilder(..).append(new EntryKey(..));
        new StringBuilder(..).toString();
        new IllegalStateException(StringBuilder.toString(..));
        throw new IllegalStateException(..);
    }

    public static Object getOrNull$default(Registry p0, String p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey("", Reflection.getOrCreateKotlinClass(..));
        p0.getServices();
        Registry.getServices(..).get(new EntryKey(..));
        if (if-nez(Map.get(..))) goto L_2a;
        return 0;
      L_2a:
        0.getValue();
        Intrinsics.reifiedOperationMarker(1, "T");
        return Lazy.getValue(..);
    }

    public static EntryKey single$default(Registry p0, String p1, Function0 p2, int p3, Object p4) {
        if (if-eqz(p3)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(p2);
        p0.add(new EntryKey(..), LazyKt.lazy(..));
        return new EntryKey(..);
    }

    public final void add(EntryKey p0, Lazy p1) {
        Registry.getServices();
        Registry.getServices(..).containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_32;
      L_18:
        _services.getValue();
        TuplesKt.to(p0, p1);
        MapsKt.mapOf(TuplesKt.to(..));
        MapsKt.plus(MutableStateFlow.getValue(..), MapsKt.mapOf(..));
        _services.compareAndSet(MutableStateFlow.getValue(..), MapsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_18;
        return;
      L_32:
        "Cannot have identical entries.".toString();
        new IllegalStateException(Object.toString(..));
        throw new IllegalStateException(..);
    }

    public final EntryKey factory(String p0, Function0 p1) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey(p0, Reflection.getOrCreateKotlinClass(..));
        new Factory(p1);
        Registry.add(new EntryKey(..), new Factory(..));
        return new EntryKey(..);
    }

    public final Object get(String p0) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey(p0, Reflection.getOrCreateKotlinClass(..));
        Registry.getServices();
        Registry.getServices(..).get(new EntryKey(..));
        if (if-eqz(Map.get(..))) goto L_2e;
        Map.get(..).getValue();
        Intrinsics.reifiedOperationMarker(1, "T");
        return Lazy.getValue(..);
      L_2e:
        new StringBuilder("No entry found for ");
        new StringBuilder(..).append(Lazy.getValue(..));
        new StringBuilder(..).toString();
        new IllegalStateException(StringBuilder.toString(..));
        throw new IllegalStateException(..);
    }

    public final Object getOrNull(String p0) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey(p0, Reflection.getOrCreateKotlinClass(..));
        Registry.getServices();
        Registry.getServices(..).get(new EntryKey(..));
        if (if-nez(Map.get(..))) goto L_24;
        return 0;
      L_24:
        0.getValue();
        Intrinsics.reifiedOperationMarker(1, "T");
        return Lazy.getValue(..);
    }

    public final Map getServices() {
        _services.getValue();
        return MutableStateFlow.getValue(..);
    }

    public final EntryKey single(String p0, Function0 p1) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new EntryKey(p0, Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(p1);
        Registry.add(new EntryKey(..), LazyKt.lazy(..));
        return new EntryKey(..);
    }

}

