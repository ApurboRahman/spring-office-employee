package sp.co.soe.emp.common.validation.annotation;

import sp.co.soe.emp.common.validation.validator.ManNoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ManNoValidator.class})
public @interface ManNo {

	String message() default "{jp.co.nttdmse.common.validation.annotation.ManNo.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target(java.lang.annotation.ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public static @interface List {
    	ManNo[] value();
    }
}
