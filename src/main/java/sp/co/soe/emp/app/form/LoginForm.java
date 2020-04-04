package sp.co.soe.emp.app.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.common.validation.annotation.UserName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Component
public class LoginForm {
    @NotNull
    @UserName
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String password;
}
