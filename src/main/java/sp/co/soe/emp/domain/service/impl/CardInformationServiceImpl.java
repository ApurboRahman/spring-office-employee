package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.CardInformationBean;
import sp.co.soe.emp.app.bean.CardsChkBean;
import sp.co.soe.emp.domain.entity.CardsChk;
import sp.co.soe.emp.domain.entity.CardsRetain;
import sp.co.soe.emp.domain.repository.CardsChkMapper;
import sp.co.soe.emp.domain.repository.CardsRetainMapper;
import sp.co.soe.emp.domain.service.CardInformationService;
import sp.co.soe.emp.domain.service.transformer.CardLedgerTransformer;
import sp.co.soe.emp.domain.service.transformer.CardMasterTransformer;

@Service
public class CardInformationServiceImpl implements CardInformationService {
    private final CardsRetainMapper cardsRetainMapper;
    private final CardMasterTransformer cardMasterTransformer;
    private final CardLedgerTransformer cardLedgerTransformer;
    private final CardsChkMapper cardsChkMapper;

    public CardInformationServiceImpl(CardsRetainMapper cardsRetainMapper,
                                      CardMasterTransformer cardMasterTransformer,
                                      CardLedgerTransformer cardLedgerTransformer,
                                      CardsChkMapper cardsChkMapper) {
        this.cardsRetainMapper = cardsRetainMapper;
        this.cardMasterTransformer = cardMasterTransformer;
        this.cardLedgerTransformer = cardLedgerTransformer;
        this.cardsChkMapper = cardsChkMapper;
    }

    @Override
    public void updateCardChkInfo(CardsChkBean bean, String screenId) {
        bean.setUpdatePgid(screenId);
        CardsChk cardsChk = cardLedgerTransformer.transform(bean);
        cardsChkMapper.updateByPrimaryKeySelective(cardsChk);
    }

    @Override
    public void updateCardRetainInfo(CardInformationBean cardRetainBean, String screenId) {
        cardRetainBean.setUpdatePgid(screenId);
        CardsRetain cardsRetain = cardMasterTransformer.transformForUpdate(cardRetainBean);
        cardsRetainMapper.updateByPrimaryKeySelective(cardsRetain);
    }
}
