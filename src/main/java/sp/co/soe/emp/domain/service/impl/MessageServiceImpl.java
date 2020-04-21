package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.MessageBean;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.MessageM;
import sp.co.soe.emp.domain.repository.MessageMMapper;
import sp.co.soe.emp.domain.service.MessageService;
import sp.co.soe.emp.domain.service.transformer.MessageTransformer;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageMMapper messageMMapper;
    private final MessageTransformer messageTransformer;

    public MessageServiceImpl(MessageMMapper messageMMapper, MessageTransformer messageTransformer) {
        this.messageMMapper = messageMMapper;
        this.messageTransformer = messageTransformer;
    }

    @Override
    public int insertOrUpdate(MessageBean messageBean) {
        MessageM message = messageTransformer.transform(messageBean);
        return messageMMapper.insertOrUpdate(message);
    }

    @Override
    public String getMessage(Integer messageId) {
        MessageM message = messageMMapper.selectByPrimaryKey(messageId);
        return message != null ? message.getMessageNm() : Const.EMPTY_STRING;
    }
}
