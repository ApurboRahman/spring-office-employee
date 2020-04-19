package sp.co.soe.emp.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.common.enums.MenuType;
import sp.co.soe.emp.common.enums.Role;
import sp.co.soe.emp.domain.entity.EmployeesM;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.EmployeesMMapper;
import sp.co.soe.emp.domain.service.InformationService;
import sp.co.soe.emp.domain.service.MessageService;
import sp.co.soe.emp.domain.service.StatusTypeService;
import sp.co.soe.emp.domain.service.cache.UserCacheService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InformationServiceImpl implements InformationService {

    private final UserCacheService userCacheService;
    private final StatusTypeService statusTypeService;
    private final MessageService messageService;
    private final EmployeesMMapper employeesMMapper;
    private final DateMapper dateMapper;

    public InformationServiceImpl(UserCacheService userCacheService, StatusTypeService statusTypeService,
                                  MessageService messageService, EmployeesMMapper employeesMMapper, DateMapper dateMapper) {
        this.userCacheService = userCacheService;
        this.statusTypeService = statusTypeService;
        this.messageService = messageService;
        this.employeesMMapper = employeesMMapper;
        this.dateMapper = dateMapper;
    }

    @Override
    public void getInformationDetails(Model model, HttpSession session) {
        Set<MenuType> menus = getMenusFromRoles();
        session.setAttribute("menus", menus);
        session.setAttribute("roles", getUserRoles());
        session.setAttribute("user", getUserDetails());
        if (menus.contains(MenuType.ADMINISTRATION)) {
            model.addAttribute("messageShow", true);
            model.addAttribute("message", getMessage());
        }
        //user roles
        //user menu permission
        //user message

    }

    @Override
    public EmployeesM getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return employeesMMapper.selectByPrimaryKey(authentication.getName());
    }

    private Set<MenuType> getMenusFromRoles() {

        return userCacheService.getMenusFromRoles(getUserRoles());
    }

    private List<Integer> getUserRoles() {
        return SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().stream().map(
                        authority -> Role.valueOf(authority.getAuthority()
                                .replace("ROLE_", "")).getValue()).collect(Collectors.toList());
    }

    private String getMessage(){
        Integer closeStatus = statusTypeService.getLatestStatus(dateMapper.selectFirstDayOfMonth());
        return messageService.getMessage(closeStatus);
    }
}
