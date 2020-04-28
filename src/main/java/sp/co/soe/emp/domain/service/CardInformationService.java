package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.CardInformationBean;
import sp.co.soe.emp.app.bean.CardsChkBean;

@Service
public interface CardInformationService {

    void updateCardChkInfo(CardsChkBean bean, String screenId);

    void updateCardRetainInfo(CardInformationBean cardRetainBean, String screenId);
}
