package sp.co.soe.emp.core.aspect;

import org.aspectj.lang.annotation.Aspect;
import sp.co.soe.emp.common.enums.MenuType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Aspect
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
public @interface AccessControl {
    MenuType[] value();
}
