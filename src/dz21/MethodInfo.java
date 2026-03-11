package dz21;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MethodInfo {
    String name();
    String returnType();
    String description();
}