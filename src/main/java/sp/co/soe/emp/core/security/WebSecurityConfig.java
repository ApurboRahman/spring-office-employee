package sp.co.soe.emp.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import sp.co.soe.emp.common.util.Const;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
private UserInfoService userInfoService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(Const.CSS, Const.FONTS, Const.JS, Const.BOOTSTRAP, Const.FAVICON).permitAll()
                .anyRequest().authenticated().and().formLogin().loginPage(Const.LANDING_URL)
                .loginProcessingUrl(Const.LOGIN_URL).usernameParameter(Const.USER_NAME).passwordParameter(Const.PASSWORD)
                .defaultSuccessUrl(Const.INFORMATION_URL, false)
                .failureUrl(Const.LOGIN_ERROR).permitAll().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(Const.LOGOUT_URL)).logoutSuccessUrl(Const.LANDING_URL)
                .deleteCookies(Const.JSESSIONID).invalidateHttpSession(true).permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userInfoService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
}
