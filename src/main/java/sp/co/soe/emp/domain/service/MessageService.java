package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    String getMessage(Integer messageId);
}
