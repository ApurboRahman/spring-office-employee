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
public class CardLedgerTransformer implements Transformer<CardsChkBean, CardsChk> {
    private final CardsChkMapper cardsChkMapper;
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public CardLedgerTransformer(CardsChkMapper cardsChkMapper, DateMapper dateMapper, Mapper dozerMapper) {
        this.cardsChkMapper = cardsChkMapper;
        this.dateMapper = dateMapper;
        this.dozerMapper = dozerMapper;
    }

    @Override
    public CardsChk transform(CardsChkBean source) {
        CardsChk cardsChk = new CardsChk();

        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        CardsChk getPreviousMonthInfo = cardsChkMapper.selectByPrimaryKey(dateMapper.selectFirstDayOfPreviousMonth(),source.getEmployeeId());
        source.setPeriodMonth(dateMapper.selectFirstDayOfMonth());
        source.setCard1Flg(Const.EMPTY_STRING);
        source.setCard2Flg(Const.EMPTY_STRING);
        source.setCard3Flg(Const.EMPTY_STRING);
        source.setCard4Flg(Const.EMPTY_STRING);
        source.setCard5Flg(Const.EMPTY_STRING);
        source.setCard6Flg(Const.EMPTY_STRING);
        source.setCard7Flg(Const.EMPTY_STRING);
        source.setChkDate(Const.EMPTY_DATE);
        source.setChkFlg(Const.EMPTY_STRING);
        source.setApprovalDate(Const.EMPTY_DATE);
        source.setApprovalFlg(Const.EMPTY_STRING);
        source.setApprovalUser(Const.EMPTY_STRING);
        source.setEmpcardFlg(Const.EMPTY_STRING);
        source.setEditFlg(Const.EMPTY_STRING);
        source.setNotes(Const.EMPTY_STRING);
        source.setCreateDate(dateMapper.selectTimestamp());
        source.setCreateUser(loginUser);
        source.setUpdateUser(loginUser);
        source.setUpdateDate(dateMapper.selectTimestamp());
        if (getPreviousMonthInfo != null) {
            source.setWorkNm(getPreviousMonthInfo.getWorkNm());
            source.setPlaceNm(getPreviousMonthInfo.getPlaceNm());
        } else {
            source.setWorkNm(Const.EMPTY_STRING);
            source.setPlaceNm(Const.EMPTY_STRING);
        }
        dozerMapper.map(source, cardsChk);
        return cardsChk;
    }

    @Override
    public CardsChkBean transformBack(CardsChk target) {
        return null;
    }

    @Override
    public CardsChk transformForUpdate(CardsChkBean source) {
        CardsChk cardsChk = new CardsChk();
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        source.setApprovalDate(dateMapper.selectTimestamp());
        source.setApprovalUser(loginUser);
        source.setUpdateUser(loginUser);
        source.setUpdateDate(dateMapper.selectTimestamp());
        dozerMapper.map(source, cardsChk);
        return cardsChk;
    }
}
