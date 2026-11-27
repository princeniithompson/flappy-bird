// Package bundle: com.unity3d.ads.core.extensions (19 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.extensions.ContextExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class ContextExtensionsKt {
    public static final File unityAdsDataStoreFile(Context p0, String p1) {
        p0.getApplicationContext();
        Context.getApplicationContext(..).getFilesDir();
        new StringBuilder("unityAdsDatastore/");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        new File(Context.getFilesDir(..), StringBuilder.toString(..));
        return new File(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.ExceptionExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class ExceptionExtensionsKt {
    public static final String retrieveUnityCrashValue(Throwable p0) {
        p0.getStackTrace();
      L_13:
        if (if-ge(0, "this.stackTrace")) goto L_3c;
        if (if-eqz(v4)) goto L_34;
        StackTraceElement.getClassName();
        if (if-eqz(StackTraceElement.getClassName(..))) goto L_34;
        StringsKt.contains$default(StackTraceElement.getClassName(..), "com.unity3d", 0, 2, 0);
      L_34:
      L_35:
        if (if-eqz(0)) goto L_39;
      L_39:
      L_3c:
        if (if-eqz(v4)) goto L_6a;
        StackTraceElement.getFileName();
        if (if-nez(StackTraceElement.getFileName(..))) goto L_4a;
      L_4a:
      L_4f:
        StackTraceElement.getLineNumber();
        new StringBuilder();
        new StringBuilder(..).append("unknown");
        new StringBuilder(..).append(95);
        new StringBuilder(..).append(StackTraceElement.getLineNumber(..));
        new StringBuilder(..).toString();
        if (if-eqz(StringBuilder.toString(..))) goto L_6a;
      L_6a:
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.FileExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class FileExtensionsKt {
    public static final long getDirectorySize(File p0) {
        p0.exists();
        if (if-nez(File.exists(..))) goto L_e;
        return 0L;
      L_e:
        p0.isDirectory();
        if (if-nez(File.isDirectory(..))) goto L_19;
        p0.length();
        return File.length(..);
      L_19:
        new LinkedList();
        new LinkedList(..).add(p0);
      L_23:
        new LinkedList(..).isEmpty();
        if (if-eqz(Collection.isEmpty(..))) goto L_65;
        new LinkedList(..).remove(0);
        List.remove(..).exists();
        if (if-eqz(File.exists(..))) goto L_23;
        List.remove(..).listFiles();
        if (if-eqz(File.listFiles(..))) goto L_23;
        if (if-nez(File.exists(..))) goto L_45;
      L_45:
      L_46:
        if (if-eqz(0)) goto L_49;
      L_49:
      L_4a:
        if (if-ge(0, 0)) goto L_23;
        File.exists(..).isDirectory();
        if (if-eqz(File.isDirectory(..))) goto L_5d;
        new LinkedList(..).add(File.exists(..));
      L_5d:
        File.exists(..).length();
      L_62:
      L_65:
        return 0L;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.FlowExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class FlowExtensionsKt {
    public static final Flow timeoutAfter(Flow p0, long p1, boolean p2, Function2 p3) {
        new FlowExtensionsKt$timeoutAfter$1(p1, v3, p2, p3, p0, 0);
        FlowKt.channelFlow(new FlowExtensionsKt$timeoutAfter$1);
        return FlowKt.channelFlow(..);
    }

    public static Flow timeoutAfter$default(Flow p0, long p1, boolean p2, Function2 p3, int p4, Object p5) {
        if (if-eqz(p4)) goto L_5;
      L_5:
        FlowExtensionsKt.timeoutAfter(p0, p1, v2, 1, p3);
        return FlowExtensionsKt.timeoutAfter(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.IntExtensionKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class IntExtensionKt {
    public static final ErrorReason webResourceToErrorReason(int p0) {
      L_35:
        return ErrorReason.REASON_WEB_ERROR_UNSAFE_RESOURCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.JSONArrayExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class JSONArrayExtensionsKt {
    public static final Map getHeadersMap(JSONArray p0) {
        new LinkedHashMap();
        p0.length();
      L_12:
        if (if-ge(0, JSONArray.length(..))) goto L_4e;
        p0.get(0);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray.get(..).getString(0);
        new LinkedHashMap(..).get(JSONArray.getString(..));
        if (if-nez(Map.get(..))) goto L_32;
        new ArrayList();
      L_32:
        JSONArray.get(..).getString(1);
        new ArrayList(..).add(JSONArray.getString(..));
        JSONArray.get(..).getString(0);
        new LinkedHashMap(..).put(JSONArray.getString(..), new ArrayList(..));
      L_4e:
        return new LinkedHashMap(..);
    }

    public static final Object[] toTypedArray(JSONArray p0) {
        p0.length();
        RangesKt.until(0, JSONArray.length(..));
        CollectionsKt.collectionSizeOrDefault(RangesKt.until(..), 10);
        new ArrayList(CollectionsKt.collectionSizeOrDefault(..));
        RangesKt.until(..).iterator();
      L_21:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_36;
        Iterable.iterator(..).nextInt();
        p0.get(IntIterator.nextInt(..));
        new ArrayList(..).add(JSONArray.get(..));
      L_36:
        new ArrayList(..).toArray(p0);
        return Collection.toArray(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.JSONObjectExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class JSONObjectExtensionsKt {
    public static final Map toBuiltInMap(JSONObject p0) {
        p0.keys();
        SequencesKt.asSequence(JSONObject.keys(..));
        new LinkedHashMap();
        SequencesKt.asSequence(..).iterator();
      L_1b:
        Sequence.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_5a;
        Sequence.iterator(..).next();
        p0.opt(Iterator.next(..));
        if (if-eqz(JSONObject.opt(..))) goto L_55;
        String.valueOf(JSONObject.opt(..));
        Intrinsics.areEqual(String.valueOf(..), "undefined");
        if (if-nez(Intrinsics.areEqual(..))) goto L_51;
        String.valueOf(JSONObject.opt(..));
        Intrinsics.areEqual(String.valueOf(..), "null");
        if (if-nez(Intrinsics.areEqual(..))) goto L_51;
      L_51:
      L_52:
        if (if-eqz(0)) goto L_55;
      L_55:
      L_56:
        new LinkedHashMap(..).put(Iterator.next(..), 0);
      L_5a:
        return new LinkedHashMap(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.JsonSerializableExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class JsonSerializableExtensionsKt {
    public static final JSONArray toJsonArray(List p0) {
        new JSONArray();
        p0.iterator();
      L_e:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_22;
        List.iterator(..).next();
        Iterator.next(..).toJson();
        new JSONArray(..).put(JsonSerializable.toJson(..));
      L_22:
        return new JSONArray(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.ProtobufExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class ProtobufExtensionsKt {
    private static final int URL_SAFE_AND_NO_WRAP = 10;

    public static final ByteString fromBase64(String p0, boolean p1) {
        if (if-eqz(p1)) goto L_a;
      L_a:
      L_b:
        Base64.decode(p0, 2);
        ByteString.copyFrom(Base64.decode(..));
        return ByteString.copyFrom(..);
    }

    public static ByteString fromBase64$default(String p0, boolean p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_5;
      L_5:
        ProtobufExtensionsKt.fromBase64(p0, 0);
        return ProtobufExtensionsKt.fromBase64(..);
    }

    public static final String toBase64(ByteString p0, boolean p1) {
        if (if-eqz(p1)) goto L_a;
      L_a:
      L_b:
        p0.toByteArray();
        Base64.encodeToString(ByteString.toByteArray(..), 2);
        return Base64.encodeToString(..);
    }

    public static String toBase64$default(ByteString p0, boolean p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_5;
      L_5:
        ProtobufExtensionsKt.toBase64(p0, 0);
        return ProtobufExtensionsKt.toBase64(..);
    }

    public static final ByteString toByteString(UUID p0) {
        ByteBuffer.wrap(16);
        ByteBuffer.wrap(..).order(ByteOrder.BIG_ENDIAN);
        p0.getMostSignificantBits();
        ByteBuffer.order(..).putLong(UUID.getMostSignificantBits(..), v2);
        p0.getLeastSignificantBits();
        ByteBuffer.putLong(..).putLong(UUID.getLeastSignificantBits(..), v2);
        ByteBuffer.putLong(..).array();
        ByteString.copyFrom(ByteBuffer.array(..));
        return ByteString.copyFrom(..);
    }

    public static final ByteString toISO8859ByteString(String p0) {
        p0.getBytes(Charsets.ISO_8859_1);
        ByteString.copyFrom(String.getBytes(..));
        return ByteString.copyFrom(..);
    }

    public static final String toISO8859String(ByteString p0) {
        p0.toString(Charsets.ISO_8859_1);
        return ByteString.toString(..);
    }

    public static final UUID toUUID(ByteString p0) {
        p0.asReadOnlyByteBuffer();
        ByteString.asReadOnlyByteBuffer(..).remaining();
        if (if-ne(ByteBuffer.remaining(..), 36)) goto L_24;
        p0.toStringUtf8();
        UUID.fromString(ByteString.toStringUtf8(..));
        return UUID.fromString(..);
      L_24:
        "fromString(uuidString)".remaining();
        if (if-ne(ByteBuffer.remaining(..), 16)) goto L_3a;
        "fromString(uuidString)".getLong();
        "fromString(uuidString)".getLong();
        new UUID(ByteBuffer.getLong(..), 36, ByteBuffer.getLong(..), v4);
        return new UUID(..);
      L_3a:
        new IllegalArgumentException("Expected 16 byte ByteString or UUID string");
        throw new IllegalArgumentException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.ShowStatusExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class ShowStatusExtensionsKt {
    public static final UnityAds$UnityAdsShowCompletionState toUnityAdsShowCompletionState(ShowStatus p0) {
        p0.ordinal();
        if (if-eq(ShowStatusExtensionsKt$WhenMappings.$EnumSwitchMapping$0, 1)) goto L_2a;
        if (if-ne(ShowStatusExtensionsKt$WhenMappings.$EnumSwitchMapping$0, 2)) goto L_16;
      L_16:
        new StringBuilder("Unexpected show status: ");
        new StringBuilder(..).append(UnityAds$UnityAdsShowCompletionState.SKIPPED);
        new StringBuilder(..).toString();
        new IllegalStateException(StringBuilder.toString(..));
        throw new IllegalStateException(..);
      L_2a:
      L_2c:
        return UnityAds$UnityAdsShowCompletionState.COMPLETED;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.StringExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class StringExtensionsKt {
    public static final String getSHA256Hash(String p0) {
        p0.getBytes(Charsets.UTF_8);
        Arrays.copyOf(String.getBytes(..), "this as java.lang.String).getBytes(charset)");
        ByteString.of(Arrays.copyOf(..));
        ByteString.of(..).sha256();
        ByteString.sha256(..).hex();
        return ByteString.hex(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.TimeExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class TimeExtensionsKt {
    public static final double elapsedMillis(TimeMark p0) {
        p0.elapsedNow-UwyO8pc();
        Duration.toDouble-impl(TimeMark.elapsedNow-UwyO8pc(..), v1, DurationUnit.MILLISECONDS);
        return Duration.toDouble-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.TimestampExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class TimestampExtensionsKt {
    public static final long duration(long p0) {
        System.nanoTime();
        return System.nanoTime(..);
    }

    public static final Timestamp fromMillis(long p0) {
        Timestamp.newBuilder();
        Timestamp.newBuilder(..).setSeconds(v3, v4);
        Timestamp$Builder.setSeconds(..).setNanos(p0);
        Timestamp$Builder.setNanos(..).build();
        return Timestamp$Builder.build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.TransactionStateExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class TransactionStateExtensionsKt {
    public static final TransactionEventRequestOuterClass$TransactionState fromPurchaseState(int p0) {
        if (if-eqz(p0)) goto L_11;
        if (if-eq(p0, 1)) goto L_e;
        if (if-eq(p0, 2)) goto L_b;
      L_b:
      L_e:
      L_11:
      L_13:
        return TransactionEventRequestOuterClass$TransactionState.TRANSACTION_STATE_PURCHASED;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.ViewExtensionsKt
// ============================================================
package com.unity3d.ads.core.extensions;

public final class ViewExtensionsKt {
    public static final void removeViewFromParent(View p0) {
        if (if-eqz(p0)) goto L_8;
        p0.getParent();
      L_8:
      L_9:
        if (if-eqz(v2)) goto L_10;
      L_10:
        if (if-eqz(0)) goto L_15;
        0.removeView(p0);
      L_15:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1
// ============================================================
package com.unity3d.ads.core.extensions;

final class FlowExtensionsKt$timeoutAfter$1 extends SuspendLambda {
    final boolean $active;
    final Function2 $block;
    final Flow $this_timeoutAfter;
    final long $timeoutMillis;
    private Object L$0;
    int label;

    FlowExtensionsKt$timeoutAfter$1(long p0, boolean p1, Function2 p2, Flow p3, Continuation p4) {
        $timeoutMillis = p0;
        $active = p1;
        $block = p2;
        $this_timeoutAfter = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FlowExtensionsKt$timeoutAfter$1($timeoutMillis, v2, $active, $block, $this_timeoutAfter, p1);
        L$0 = p0;
        return new FlowExtensionsKt$timeoutAfter$1;
    }

    public Object invoke(Object p0, Object p1) {
        FlowExtensionsKt$timeoutAfter$1.invoke(p0, p1);
        return FlowExtensionsKt$timeoutAfter$1.invoke(..);
    }

    public final Object invoke(ProducerScope p0, Continuation p1) {
        FlowExtensionsKt$timeoutAfter$1.create(p0, p1);
        FlowExtensionsKt$timeoutAfter$1.invokeSuspend(Unit.INSTANCE);
        return FlowExtensionsKt$timeoutAfter$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_23;
        if (if-eq(label, 1)) goto L_1b;
        if (if-ne(label, 2)) goto L_13;
        ResultKt.throwOnFailure(p0);
      L_13:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_23:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new FlowExtensionsKt$timeoutAfter$1$1($this_timeoutAfter, L$0, 0);
        BuildersKt.launch$default(L$0, 0, 0, new FlowExtensionsKt$timeoutAfter$1$1(..), 3, 0);
        L$0 = L$0;
        label = 1;
        DelayKt.delay($timeoutMillis, 0, this);
        if (if-ne(DelayKt.delay(..), "call to 'resume' before 'invoke' with coroutine")) goto L_4f;
        return "call to 'resume' before 'invoke' with coroutine";
      L_4f:
        if (if-eqz($active)) goto L_65;
        new FlowExtensionsKt$timeoutAfter$1$2(L$0);
        L$0 = 0;
        label = 2;
        $block.invoke(new FlowExtensionsKt$timeoutAfter$1$2(..), this);
        if (if-ne(Function2.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_65;
        return "call to 'resume' before 'invoke' with coroutine";
      L_65:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1
// ============================================================
package com.unity3d.ads.core.extensions;

final class FlowExtensionsKt$timeoutAfter$1$1 extends SuspendLambda {
    final ProducerScope $$this$channelFlow;
    final Flow $this_timeoutAfter;
    int label;

    FlowExtensionsKt$timeoutAfter$1$1(Flow p0, ProducerScope p1, Continuation p2) {
        $this_timeoutAfter = p0;
        $$this$channelFlow = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FlowExtensionsKt$timeoutAfter$1$1($this_timeoutAfter, $$this$channelFlow, p1);
        return new FlowExtensionsKt$timeoutAfter$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        FlowExtensionsKt$timeoutAfter$1$1.invoke(p0, p1);
        return FlowExtensionsKt$timeoutAfter$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FlowExtensionsKt$timeoutAfter$1$1.create(p0, p1);
        FlowExtensionsKt$timeoutAfter$1$1.invokeSuspend(Unit.INSTANCE);
        return FlowExtensionsKt$timeoutAfter$1$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new FlowExtensionsKt$timeoutAfter$1$1$1($$this$channelFlow);
        label = 1;
        $this_timeoutAfter.collect(new FlowExtensionsKt$timeoutAfter$1$1$1(..), this);
        if (if-ne(Flow.collect(..), "call to 'resume' before 'invoke' with coroutine")) goto L_31;
        return "call to 'resume' before 'invoke' with coroutine";
      L_31:
        SendChannel$DefaultImpls.close$default($$this$channelFlow, 0, 1, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1$1
// ============================================================
package com.unity3d.ads.core.extensions;

final class FlowExtensionsKt$timeoutAfter$1$1$1 {
    final ProducerScope $$this$channelFlow;

    FlowExtensionsKt$timeoutAfter$1$1$1(ProducerScope p0) {
        $$this$channelFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        $$this$channelFlow.send(p0, p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(ProducerScope.send(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d;
        return ProducerScope.send(..);
      L_d:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$2
// ============================================================
package com.unity3d.ads.core.extensions;

final class FlowExtensionsKt$timeoutAfter$1$2 extends AdaptedFunctionReference {
    FlowExtensionsKt$timeoutAfter$1$2(Object p0) {
        new AdaptedFunctionReference(0, p0, ProducerScope.class, "close", "close(Ljava/lang/Throwable;)Z", 8);
        return;
    }

    public static final Object access$getReceiver$p(FlowExtensionsKt$timeoutAfter$1$2 p0) {
        return receiver;
    }

    public Object invoke() {
        FlowExtensionsKt$timeoutAfter$1$2.invoke();
        return Unit.INSTANCE;
    }

    public final void invoke() {
        FlowExtensionsKt$timeoutAfter$1$2.access$getReceiver$p(this);
        SendChannel$DefaultImpls.close$default(FlowExtensionsKt$timeoutAfter$1$2.access$getReceiver$p(..), 0, 1, 0);
        return;
    }

}

