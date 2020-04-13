package sp.co.soe.emp.domain.service.transformer;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.util.Transformer;
import sp.co.soe.emp.domain.entity.EmployeesM;
import sp.co.soe.emp.domain.repository.DateMapper;

@Component
public class EmployeeTransformer implements Transformer<EmployeeInformationBean, EmployeesM> {

    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public EmployeeTransformer(DateMapper dateMapper, Mapper dozerMapper) {
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
    public EmployeesM transform(EmployeeInformationBean source) {
        EmployeesM employeesM = new EmployeesM();
        String loginUser = UserInfoHelper.getLoginUserInfo().getUserName();
        source.setEmployeeId(UserInfoHelper.generateEmployeeId(source.getEmployeeId()));
        source.setCommCode(false);
        source.setCreateUser(loginUser);
        source.setCreateDate(dateMapper.selectTimestamp());
        source.setUpdateUser(loginUser);
        source.setUpdateDate(dateMapper.selectTimestamp());
        dozerMapper.map(source, employeesM);
        return employeesM;
    }

    /**
     * transform back from S type to T type
     *
     * @param target
     * @return
     */
    @Override
    public EmployeeInformationBean transformBack(EmployeesM target) {
        return null;
    }

    @Override
    public EmployeesM transformForUpdate(EmployeeInformationBean source) {
        return null;
    }
}
