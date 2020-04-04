package sp.co.soe.emp.common.validation.validator;

import sp.co.soe.emp.common.validation.annotation.UserName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class UserNameValidator implements ConstraintValidator<UserName,Object> {
    private String message;
    @Override
    public void initialize(UserName constraintAnnotation) {
        this.message=constraintAnnotation.message();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(Objects.isNull(value)||value.toString().isEmpty()){
            return true;
        }

        return true;
    }
}
