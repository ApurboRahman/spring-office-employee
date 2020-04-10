package sp.co.soe.emp.domain.service.transformer;

import com.github.dozermapper.core.Mapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.UserAccountBean;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.util.Transformer;
import sp.co.soe.emp.domain.entity.UsersAccount;
import sp.co.soe.emp.domain.repository.DateMapper;

import java.util.Date;

@Component
public class UserAccountTransformer implements Transformer<String, UsersAccount> {

    private final PasswordEncoder passwordEncoder;
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public UserAccountTransformer(PasswordEncoder passwordEncoder, DateMapper dateMapper, Mapper dozerMapper) {
        this.passwordEncoder = passwordEncoder;
        this.dateMapper = dateMapper;
        this.dozerMapper = dozerMapper;
    }


    /**
     * transform from T type to S typ
     *
     * @param source
     * @return
     */
    @Override
    public UsersAccount transform(String source) {
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        String userName = UserInfoHelper.generateEmployeeId(source);
        UserAccountBean bean = new UserAccountBean();
        UsersAccount usersAccount = new UsersAccount();
        bean.setUserName(userName);
        bean.setPassword(getEncryptedPassword(source));
        bean.setValidateStartDate(dateMapper.selectTimestamp());
        bean.setValidateEndDate(getValidExpireDate());
        bean.setActive(true);
        bean.setDelete(false);
        bean.setPwdChangeDate(dateMapper.selectTimestamp());
        bean.setCreateUser(loginUser);
        bean.setCreateDate(dateMapper.selectTimestamp());
        bean.setCreatePgid("SYSTEM");
        bean.setUpdateUser(loginUser);
        bean.setUpdateDate(dateMapper.selectTimestamp());
        bean.setUpdatePgid("SYSTEM");
        dozerMapper.map(bean,usersAccount);
        return usersAccount;
    }

    /**
     * transform back from S type to T type
     *
     * @param target
     * @return
     */
    @Override
    public String transformBack(UsersAccount target) {
        return null;
    }

    private String getEncryptedPassword(String password){
        String digest = Const.EMPTY_STRING;
        if(!StringUtils.isEmpty(password)){
            digest = passwordEncoder.encode(password.trim());
        }
       return digest;
    }

    private Date getValidExpireDate(){
        return dateMapper.selectNinetyDaysFromCurrentDate();
    }
}
