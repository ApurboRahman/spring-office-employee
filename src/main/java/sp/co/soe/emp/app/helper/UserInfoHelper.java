package sp.co.soe.emp.app.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.core.security.UserInfoEntity;
import sp.co.soe.emp.domain.entity.UsersAccount;

@Slf4j
public class UserInfoHelper {

    public static UsersAccount getLoginUserInfo(){
        log.info("login user details");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoEntity userInfoEntity = (UserInfoEntity) authentication.getPrincipal();
        return userInfoEntity.getUserAccount();
    }

    public static String generateEmployeeId(String employeeId){
        if(employeeId.length()!= Const.EMPLOYEE_ID_LENGTH){
            log.info("create employeeId size 6");
            employeeId = org.apache.commons.lang3.StringUtils.leftPad(employeeId,Const.EMPLOYEE_ID_LENGTH,Const.LEADING_ZERO);
        }
        return employeeId;
    }
}
