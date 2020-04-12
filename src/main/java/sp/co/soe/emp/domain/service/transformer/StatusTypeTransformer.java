package sp.co.soe.emp.domain.service.transformer;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.CloseStatusBean;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.util.Transformer;
import sp.co.soe.emp.domain.entity.CloseStatus;
import sp.co.soe.emp.domain.repository.DateMapper;

@Component
public class StatusTypeTransformer implements Transformer<CloseStatusBean, CloseStatus> {
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public StatusTypeTransformer(DateMapper dateMapper, Mapper dozerMapper) {
        this.dateMapper = dateMapper;
        this.dozerMapper = dozerMapper;
    }

    @Override
    public CloseStatus transform(CloseStatusBean source) {
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        CloseStatus closeStatus = new CloseStatus();
        source.setCreateUser(loginUser);
        source.setCreateDate(dateMapper.selectTimestamp());
        source.setCreatePgid("SYSTEM");
        source.setUpdateUser(loginUser);
        source.setUpdateDate(dateMapper.selectTimestamp());
        source.setUpdatePgid("SYSTEM");
        dozerMapper.map(source,closeStatus);
        return closeStatus;
    }

    @Override
    public CloseStatusBean transformBack(CloseStatus target) {
        return null;
    }
}
