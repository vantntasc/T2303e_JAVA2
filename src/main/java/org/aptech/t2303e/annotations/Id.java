package org.aptech.t2303e.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    String columnName();
    boolean autoIncrement() default true;
    // not null
}
