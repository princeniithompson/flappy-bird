
// ===== FILE: org/intellij/lang/annotations/Flow.java =====
package org.intellij.lang.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface Flow {
    public static final String DEFAULT_SOURCE = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";
    public static final String DEFAULT_TARGET = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";
    public static final String RETURN_METHOD_TARGET = "The return value of this method";
    public static final String THIS_SOURCE = "this";
    public static final String THIS_TARGET = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}

// ===== FILE: org/intellij/lang/annotations/Identifier.java =====
package org.intellij.lang.annotations;

/* loaded from: classes2.dex */
public @interface Identifier {
}

// ===== FILE: org/intellij/lang/annotations/JdkConstants.java =====
package org.intellij.lang.annotations;

/* loaded from: classes2.dex */
public class JdkConstants {

    public @interface AdjustableOrientation {
    }

    public @interface BoxLayoutAxis {
    }

    public @interface CalendarMonth {
    }

    public @interface CursorType {
    }

    public @interface FlowLayoutAlignment {
    }

    public @interface FontStyle {
    }

    public @interface HorizontalAlignment {
    }

    public @interface InputEventMask {
    }

    public @interface ListSelectionMode {
    }

    public @interface PatternFlags {
    }

    public @interface TabLayoutPolicy {
    }

    public @interface TabPlacement {
    }

    public @interface TitledBorderJustification {
    }

    public @interface TitledBorderTitlePosition {
    }

    public @interface TreeSelectionMode {
    }
}

// ===== FILE: org/intellij/lang/annotations/Language.java =====
package org.intellij.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface Language {
    String prefix() default "";

    String suffix() default "";

    String value();
}

// ===== FILE: org/intellij/lang/annotations/MagicConstant.java =====
package org.intellij.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface MagicConstant {
    long[] flags() default {};

    Class flagsFromClass() default void.class;

    long[] intValues() default {};

    String[] stringValues() default {};

    Class valuesFromClass() default void.class;
}

// ===== FILE: org/intellij/lang/annotations/Pattern.java =====
package org.intellij.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface Pattern {
    String value();
}

// ===== FILE: org/intellij/lang/annotations/PrintFormat.java =====
package org.intellij.lang.annotations;

/* loaded from: classes2.dex */
public @interface PrintFormat {
}

// ===== FILE: org/intellij/lang/annotations/PrintFormatPattern.java =====
package org.intellij.lang.annotations;

/* compiled from: PrintFormat.java */
/* loaded from: classes2.dex */
class PrintFormatPattern {
    private static final String ARG_INDEX = "(?:\\d+\\$)?";
    private static final String CONVERSION = "(?:[tT])?(?:[a-zA-Z%])";
    private static final String FLAGS = "(?:[-#+ 0,(<]*)?";
    private static final String PRECISION = "(?:\\.\\d+)?";
    static final String PRINT_FORMAT = "(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*";
    private static final String TEXT = "[^%]|%%";
    private static final String WIDTH = "(?:\\d+)?";

    PrintFormatPattern() {
    }
}

// ===== FILE: org/intellij/lang/annotations/RegExp.java =====
package org.intellij.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface RegExp {
    String prefix() default "";

    String suffix() default "";
}

// ===== FILE: org/intellij/lang/annotations/Subst.java =====
package org.intellij.lang.annotations;

/* loaded from: classes2.dex */
public @interface Subst {
    String value();
}
