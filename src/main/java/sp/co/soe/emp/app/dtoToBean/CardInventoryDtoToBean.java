package sp.co.soe.emp.app.dtoToBean;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.CardInformationBean;
import sp.co.soe.emp.app.bean.CardsChkBean;
import sp.co.soe.emp.app.dto.CardInventoryDTO;
import sp.co.soe.emp.app.form.CardInventoryForm;

@Component
public class CardInventoryDtoToBean {
    private final Mapper dozerMapper;

    public CardInventoryDtoToBean(Mapper dozerMapper) {
        this.dozerMapper = dozerMapper;
    }

    public CardInformationBean cardDtoToCardRetainBean(CardInventoryDTO dto) {
        CardInformationBean bean = new CardInformationBean();
        dozerMapper.map(dto, bean);
        return bean;
    }

    public CardsChkBean cardDtoToCardChkBean(CardInventoryDTO dto) {
        CardsChkBean bean = new CardsChkBean();
        dozerMapper.map(dto,bean);
        return bean;
    }
}
