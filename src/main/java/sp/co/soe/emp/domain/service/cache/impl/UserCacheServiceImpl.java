package sp.co.soe.emp.domain.service.cache.impl;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.common.enums.MenuType;
import sp.co.soe.emp.common.enums.Role;
import sp.co.soe.emp.domain.entity.RoleMenuPermissionsExample;
import sp.co.soe.emp.domain.repository.RoleMenuPermissionsMapper;
import sp.co.soe.emp.domain.service.cache.UserCacheService;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UserCacheServiceImpl implements UserCacheService {
    private final RoleMenuPermissionsMapper roleMenuPermissionsMapper;
    private final RoleMenuPermissionsExample roleMenuPermissionsExample;
    private static Map<Integer, List<MenuType>> permissionMap = new ConcurrentHashMap<Integer, List<MenuType>>();
    private static Map<Integer, Long> intervalMap = new ConcurrentHashMap<Integer, Long>();
    private long RELOAD_INTERVAL = 60 * 1000;

    public UserCacheServiceImpl(RoleMenuPermissionsMapper roleMenuPermissionsMapper, RoleMenuPermissionsExample roleMenuPermissionsExample) {
        this.roleMenuPermissionsMapper = roleMenuPermissionsMapper;
        this.roleMenuPermissionsExample = roleMenuPermissionsExample;
    }


    @Override
    public Set<MenuType> getMenusFromRoles(List<Integer> roles) {
        Set<MenuType> menus = new LinkedHashSet<MenuType>();

        checkForReload(roles);
        for (Integer roleId : roles) {
            List<MenuType> roleMenus = permissionMap.get(roleId);
            if (null != roleMenus) {
                menus.addAll(roleMenus);
            }
        }
        return menus;
    }

    private synchronized void checkForReload(List<Integer> roles) {
        for (Integer roleId : roles) {
            long previousLoadTime = intervalMap.getOrDefault(roleId, 0L);
            if (System.currentTimeMillis() - previousLoadTime > RELOAD_INTERVAL) {
                reloadMenuByRoleId(roleId);
                intervalMap.put(roleId, System.currentTimeMillis());
            }
        }
    }

    private void reloadMenuByRoleId(Integer roleId) {
        roleMenuPermissionsExample.clear();
        roleMenuPermissionsExample.createCriteria().andRoleIdEqualTo(roleId);
        List<MenuType> menuTypeList = roleMenuPermissionsMapper.selectByExample(roleMenuPermissionsExample)
                .stream().map(menuType -> MenuType.byValue(menuType.getMenuId())).collect(Collectors.toList());
        permissionMap.put(roleId, menuTypeList);
    }
}
