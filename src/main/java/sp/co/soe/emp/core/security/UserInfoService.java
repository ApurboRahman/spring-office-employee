package sp.co.soe.emp.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sp.co.soe.emp.common.enums.Role;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.EmployeesM;
import sp.co.soe.emp.domain.entity.SystemParamsExample;
import sp.co.soe.emp.domain.entity.UsersAccount;
import sp.co.soe.emp.domain.entity.UsersAccountExample;
import sp.co.soe.emp.domain.repository.EmployeesMMapper;
import sp.co.soe.emp.domain.repository.SystemParamsMapper;
import sp.co.soe.emp.domain.repository.UsersAccountMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UsersAccountMapper usersAccountMapper;
    @Autowired
    private EmployeesMMapper employeesMMapper;
    @Autowired
    private SystemParamsMapper systemParamsMapper;

    @Autowired
    private UsersAccountExample accountExample;
    @Autowired
    private SystemParamsExample systemParamsExample;

    @Override
    public UserDetails loadUserByUsername(String username){
        accountExample.clear();
        accountExample.createCriteria().andUserNameEqualTo(username)
                .andActiveEqualTo(true).andDeleteEqualTo(false)
                .andValidateStartDateLessThanOrEqualTo(new Date())
                .andValidateEndDateGreaterThanOrEqualTo(new Date());

        UsersAccount account = new UsersAccount();

        List<UsersAccount> accountList =  usersAccountMapper.selectByExample(accountExample);
        if (accountList.size() != 0) {
           account= accountList.get(0);
        }
        Collection<GrantedAuthority> authorities;
        List<String> roleList = new ArrayList<>();

        roleList.add(Role.EMPLOYEE.name());

        EmployeesM employee = employeesMMapper.selectByPrimaryKey(username);
        if(employee==null){
            throw new UsernameNotFoundException("User not found: " + username);
        }
        if(employee.getCommCode()){
            roleList.add(Role.SECURITY_COMMITTEE.name());
        }
        systemParamsExample.clear();
        systemParamsExample.createCriteria().andParamCd1EqualTo(Const.businessPlannerCD1)
                .andParamNm1EqualTo(Const.businessPlannerParamNm1).andParamCd2EqualTo(employee.getDeptCode());
        long systemParams = systemParamsMapper.countByExample(systemParamsExample);

        if (systemParams != 0) {
            roleList.add(Role.BUSINESS_PLANNER.name());
        }

        systemParamsExample.clear();
        systemParamsExample.createCriteria().andParamCd1EqualTo(Const.sectionManagerParamCD1)
                .andParamNm1EqualTo(Const.sectionManagerParamNm1).andParamCd2EqualTo(employee.getPostCode());
        systemParams = systemParamsMapper.countByExample(systemParamsExample);

        if (systemParams != 0) {
            roleList.add(Role.SECTION_MANAGER_AND_ABOVE.name());
        }

        String[] roles = roleList.toArray(new String[roleList.size()]);
        authorities = AuthorityUtils.createAuthorityList(roles);
        return new UserInfoEntity(account,authorities,true);
    }
}
