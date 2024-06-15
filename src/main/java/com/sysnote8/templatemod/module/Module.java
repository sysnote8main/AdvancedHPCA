package com.sysnote8.templatemod.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Module {
    String moduleID();
    String containerID();
    String name();
    String description() default "";
    String[] modDependencies() default {};
    boolean coreModule() default false;
    ModuleSide side(); // side which want to work this module
}
