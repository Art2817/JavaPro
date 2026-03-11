package dz21;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String firstName();
    String lastName();
}