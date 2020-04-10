package sp.co.soe.emp.core.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sp.co.soe.emp.domain.entity.UsersAccount;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

public class UserInfoEntity implements UserDetails {
    private final UsersAccount userAccount;
    private final Collection<GrantedAuthority>authorities;
    private Boolean isAccountNonLocked;

    public UserInfoEntity(UsersAccount userAccount, Collection<GrantedAuthority> authorities, Boolean isAccountNonLocked) {
        this.userAccount = userAccount;
        this.authorities = authorities;
        this.isAccountNonLocked = isAccountNonLocked;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return userAccount.getValidateEndDate()>=new DateF("YYYY-MM-DD").format(new Date());
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userAccount.getActive();
    }

    public UsersAccount getUserAccount(){
        return userAccount;
    }
}
