package sp.co.soe.emp.domain.service.transformer;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.CardsChkBean;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.util.Transformer;
import sp.co.soe.emp.domain.entity.CardsChk;
import sp.co.soe.emp.domain.repository.CardsChkMapper;
import sp.co.soe.emp.domain.repository.DateMapper;

@Component
public class CardLedgerTransformer implements Transformer<String, CardsChk> {
    private final CardsChkMapper cardsChkMapper;
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public CardLedgerTransformer(CardsChkMapper cardsChkMapper, DateMapper dateMapper, Mapper dozerMapper) {
        this.cardsChkMapper = cardsChkMapper;
        this.dateMapper = dateMapper;
        this.dozerMapper = dozerMapper;
    }

    @Override
    public CardsChk transform(String employeeId) {
        CardsChk cardsChk = new CardsChk();
        CardsChkBean cardBean = new CardsChkBean();
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        CardsChk getPreviousMonthInfo = cardsChkMapper.selectByPrimaryKey(dateMapper.selectFirstDayOfPreviousMonth(),employeeId);
        cardBean.setEmployeeId(employeeId);
        cardBean.setPeriodMonth(dateMapper.selectFirstDayOfMonth());
        cardBean.setCard1Flg(Const.EMPTY_STRING);
        cardBean.setCard2Flg(Const.EMPTY_STRING);
        cardBean.setCard3Flg(Const.EMPTY_STRING);
        cardBean.setCard4Flg(Const.EMPTY_STRING);
        cardBean.setCard5Flg(Const.EMPTY_STRING);
        cardBean.setCard6Flg(Const.EMPTY_STRING);
        cardBean.setCard7Flg(Const.EMPTY_STRING);
        cardBean.setChkDate(Const.EMPTY_DATE);
        cardBean.setChkFlg(Const.EMPTY_STRING);
        cardBean.setApprovalDate(Const.EMPTY_DATE);
        cardBean.setApprovalFlg(Const.EMPTY_STRING);
        cardBean.setApprovalUser(Const.EMPTY_STRING);
        cardBean.setEmpcardFlg(Const.EMPTY_STRING);
        cardBean.setEditFlg(Const.EMPTY_STRING);
        cardBean.setNotes(Const.EMPTY_STRING);
        cardBean.setCreateDate(dateMapper.selectTimestamp());
        cardBean.setCreateUser(loginUser);
        cardBean.setUpdateUser(loginUser);
        cardBean.setUpdateDate(dateMapper.selectTimestamp());
        cardBean.setCreatePgid("SYSTEM");
        cardBean.setUpdatePgid("SYSTEM");
        if (getPreviousMonthInfo != null) {
            cardBean.setWorkNm(getPreviousMonthInfo.getWorkNm());
            cardBean.setPlaceNm(getPreviousMonthInfo.getPlaceNm());
        } else {
            cardBean.setWorkNm(Const.EMPTY_STRING);
            cardBean.setPlaceNm(Const.EMPTY_STRING);
        }
        dozerMapper.map(cardBean, cardsChk);
        return cardsChk;
    }

    @Override
    public String transformBack(CardsChk target) {
        return null;
    }
}
