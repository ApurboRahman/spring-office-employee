package sp.co.soe.emp.domain.service.transformer;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.MessageBean;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.util.Transformer;
import sp.co.soe.emp.domain.entity.MessageM;
import sp.co.soe.emp.domain.repository.DateMapper;

@Component
public class MessageTransformer implements Transformer<MessageBean, MessageM> {
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public MessageTransformer(DateMapper dateMapper, Mapper dozerMapper) {
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
    public MessageM transform(MessageBean source) {
        MessageM message = new MessageM();
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        source.setCreateUser(loginUser);
        source.setCreateDate(dateMapper.selectTimestamp());
        source.setUpdateUser(loginUser);
        source.setUpdateDate(dateMapper.selectTimestamp());
        dozerMapper.map(source,message);
        return message;
    }

    /**
     * transform back from S type to T type
     *
     * @param target
     * @return
     */
    @Override
    public MessageBean transformBack(MessageM target) {
        return null;
    }

    @Override
    public MessageM transformForUpdate(MessageBean source) {
        return null;
    }
}
