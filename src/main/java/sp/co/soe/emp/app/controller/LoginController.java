package sp.co.soe.emp.app.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sp.co.soe.emp.app.form.LoginForm;
import sp.co.soe.emp.common.util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @GetMapping(value = Const.LANDING_URL)
    public String index(LoginForm loginForm){
        return Const.LOGIN;
    }

    @PostMapping(value = Const.LANDING_URL)
    public String login(Model model, @Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return Const.LOGIN;
        }

        try {
            UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authReq));
            HttpSession currentSession = request.getSession(true);
            currentSession.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            return Const.REDIRECT_TO_INFORMATION;
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addAttribute("loginError", true);
            return Const.LOGIN;
        }
    }
}
