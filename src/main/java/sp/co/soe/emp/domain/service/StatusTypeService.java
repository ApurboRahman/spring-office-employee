package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.CloseStatusBean;

import java.util.Date;

@Service
public interface StatusTypeService {
    CloseStatusBean getStatus(Date date);

    int insertStatus(CloseStatusBean closeStatusBean);

    int deleteStatus(Date selectFirstDayOfMonth);

    int updateStatus(CloseStatusBean closeStatus);
}
