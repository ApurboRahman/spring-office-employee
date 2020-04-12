package sp.co.soe.emp.domain.service.transformer;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.CardInformationBean;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.util.Transformer;
import sp.co.soe.emp.domain.entity.CardsRetain;
import sp.co.soe.emp.domain.repository.DateMapper;

@Component
public class CardMasterTransformer implements Transformer<CardInformationBean, CardsRetain> {
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public CardMasterTransformer(DateMapper dateMapper, Mapper dozerMapper) {
        this.dateMapper = dateMapper;
        this.dozerMapper = dozerMapper;
    }

    @Override
    public CardsRetain transform(CardInformationBean source) {
        CardsRetain cardsRetain = new CardsRetain();
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        source.setPeriodMonth(dateMapper.selectFirstDayOfMonth());
        source.setCreateUser(loginUser);
        source.setCreateDate(dateMapper.selectTimestamp());
        source.setCreatePgid("SYSTEM");
        source.setUpdateUser(loginUser);
        source.setUpdateDate(dateMapper.selectTimestamp());
        source.setUpdatePgid("SYSTEM");
        dozerMapper.map(source, cardsRetain);
        return cardsRetain;
    }

    @Override
    public CardInformationBean transformBack(CardsRetain target) {
        return null;
    }
}
