package sp.co.soe.emp.common.validation.validator;

import lombok.extern.slf4j.Slf4j;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.validation.annotation.UserName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Slf4j
public class UserNameValidator implements ConstraintValidator<UserName, Object> {
    private String message;
    private String numeric;

    @Override
    public void initialize(UserName constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.numeric = constraintAnnotation.numeric();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.toString().isEmpty()) {
            return true;
        }
        boolean isNumber = value.toString().matches("[0-9]+");
        if (!isNumber) {
            log.error("Employee Id pattern is not matched. Should be numeric only");
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(numeric).addConstraintViolation();
            return false;
        }
        if (!Objects.equals(value.toString().length(), Const.EMPLOYEE_ID_LENGTH)) {
            log.error("Employee Id length is more than six.");
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }
}
