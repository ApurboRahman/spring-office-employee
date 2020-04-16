package sp.co.soe.emp.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.common.enums.MenuType;
import sp.co.soe.emp.common.enums.Role;
import sp.co.soe.emp.domain.service.cache.UserCacheService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class AccessControlHandler {
    private final UserCacheService userCacheService;

    public AccessControlHandler(UserCacheService userCacheService) {
        this.userCacheService = userCacheService;
    }

    @Before("execution(* sp.co.soe.emp..*(..)) && @annotation(accessControl)")
    public void checkMenuPermission(AccessControl accessControl) {
        Set<MenuType> permissions = new HashSet<>(Arrays.asList(accessControl.value()));
        Set<MenuType> menus = userCacheService.getMenusFromRoles(getUserRoleIds());
        try {
            permissions.retainAll(menus);
            if (permissions.isEmpty()) {
                throw new NullPointerException();
            }
        } catch (NullPointerException ex) {
            log.error("Unauthorized access!");
            throw new AccessDeniedException("Unauthorized access!");
        }
    }

    @Before("execution(* sp.co.soe.emp..*(..)) && @annotation(masterControl)")
    public void checkUploadAndMasterCreatePermission(MasterControl masterControl) {
        List<Integer> roleList = Arrays.asList(masterControl.value())
                .stream()
                .map(role -> role.getValue())
                .collect(Collectors.toList());
        List<Integer> roleIds = getUserRoleIds();
        try {
            roleList.retainAll(roleIds);
            if (roleIds.isEmpty()) {
                throw new NullPointerException();
            }
        } catch (NullPointerException ex) {
            log.error("Unauthorized access!");
            throw new AccessDeniedException("Unauthorized access!");
        }
    }

    private List<Integer> getUserRoleIds() {
        return (List<Integer>) SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities()
                .stream()
                .map(authority ->
                        Role.valueOf(authority.getAuthority()
                                .replace("ROLE_", ""))
                                .getValue()).collect(Collectors.toList());
    }
}