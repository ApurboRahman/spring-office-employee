package sp.co.soe.emp.domain.service.transformer;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.DonglesChkBean;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.util.Transformer;
import sp.co.soe.emp.domain.entity.DonglesChk;
import sp.co.soe.emp.domain.repository.DateMapper;

import java.util.Date;

@Component
public class DongleChkTransformer implements Transformer<DonglesChkBean, DonglesChk> {
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public DongleChkTransformer(DateMapper dateMapper, Mapper dozerMapper) {
        this.dateMapper = dateMapper;
        this.dozerMapper = dozerMapper;
    }

    @Override
    public DonglesChk transform(DonglesChkBean source) {
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        DonglesChk donglesChk = new DonglesChk();
        source.setEmployeeId(getEmployeeId(source.getEmployeeId()));
        source.setPeriodMonth(getDatePeriod());
        source.setChkFlg(Const.EMPTY_STRING);
        source.setChkUser(Const.EMPTY_STRING);
        source.setChkDate(Const.EMPTY_DATE);
        source.setCreateUser(loginUser);
        source.setCreateDate(dateMapper.selectTimestamp());
        source.setCreatePgid("SYSTEM");
        source.setUpdateUser(loginUser);
        source.setUpdateDate(dateMapper.selectTimestamp());
        source.setUpdatePgid("SYSTEM");
        dozerMapper.map(source,donglesChk);
        return donglesChk;
    }

    @Override
    public DonglesChkBean transformBack(DonglesChk target) {
        return null;
    }

    private Date getDatePeriod() {
        return dateMapper.selectFirstDayOfMonth();
    }

    private String getEmployeeId(String employeeId){
        return UserInfoHelper.generateEmployeeId(employeeId);
    }
}
