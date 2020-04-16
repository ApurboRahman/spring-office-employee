package sp.co.soe.emp.common.validation.annotation;

import sp.co.soe.emp.common.validation.validator.UserNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UserNameValidator.class})
public @interface UserName {

    String message() default "{sp.co.soe.emp.common.validation.annotation.EmployeeId.message}";

    String numeric() default "{sp.co.soe.emp.common.validation.annotation.EmployeeId.numericString}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
