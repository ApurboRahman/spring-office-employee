package sp.co.soe.emp.domain.service.cache;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.common.enums.MenuType;

import java.util.List;
import java.util.Set;

@Service
public interface UserCacheService {
    Set<MenuType> getMenusFromRoles(List<Integer> userRoles);
}
