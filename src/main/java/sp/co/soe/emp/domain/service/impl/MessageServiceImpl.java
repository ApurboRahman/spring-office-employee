package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.MessageM;
import sp.co.soe.emp.domain.repository.MessageMMapper;
import sp.co.soe.emp.domain.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageMMapper messageMMapper;

    public MessageServiceImpl(MessageMMapper messageMMapper) {
        this.messageMMapper = messageMMapper;
    }

    @Override
    public String getMessage(Integer messageId) {
        MessageM message = messageMMapper.selectByPrimaryKey(messageId);
        return message != null ? message.getMessageNm() : Const.EMPTY_STRING;
    }
}
