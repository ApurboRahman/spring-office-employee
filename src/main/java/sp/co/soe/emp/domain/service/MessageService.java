package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.MessageBean;

@Service
public interface MessageService {
    int insertOrUpdate(MessageBean messageBean);

    String getMessage(Integer messageId);
}
