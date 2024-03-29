package sp.co.soe.emp.domain.service.impl;

import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.CloseStatusBean;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.CloseStatus;
import sp.co.soe.emp.domain.repository.CloseStatusMapper;
import sp.co.soe.emp.domain.service.StatusTypeService;
import sp.co.soe.emp.domain.service.transformer.StatusTypeTransformer;

import java.util.Date;

@Service
public class StatusTypeServiceImpl implements StatusTypeService {
    private final StatusTypeTransformer statusTypeTransformer;
    private final CloseStatusMapper closeStatusMapper;
    private final Mapper dozerMapper;

    public StatusTypeServiceImpl(StatusTypeTransformer statusTypeTransformer, CloseStatusMapper closeStatusMapper, Mapper dozerMapper) {
        this.statusTypeTransformer = statusTypeTransformer;
        this.closeStatusMapper = closeStatusMapper;
        this.dozerMapper = dozerMapper;
    }

    @Override
    public CloseStatusBean getStatus(Date closeDate) {
        CloseStatusBean closeStatusBean = null;
        CloseStatus closeStatus = closeStatusMapper.selectByPrimaryKey(closeDate);
        if (null != closeStatus) {
            closeStatusBean = new CloseStatusBean();
            dozerMapper.map(closeStatus, closeStatusBean);
        }
        return closeStatusBean;
    }

    @Override
    public int insertStatus(CloseStatusBean closeStatusBean) {
        CloseStatus closeStatus = statusTypeTransformer.transform(closeStatusBean);
        return closeStatusMapper.insert(closeStatus);
    }

    @Override
    public int deleteStatus(Date closeDate) {
        return closeStatusMapper.deleteByPrimaryKey(closeDate);
    }

    @Override
    public int updateStatus(CloseStatusBean closeStatusBean) {
        CloseStatus closeStatus = statusTypeTransformer.transformForUpdate(closeStatusBean);
        return closeStatusMapper.updateByPrimaryKey(closeStatus);
    }

    @Override
    public int getLatestStatus(Date currentMonth) {
        CloseStatus closeStatus = closeStatusMapper.selectByPrimaryKey(currentMonth);
        return closeStatus != null ? closeStatus.getCloseFlag() : Const.ZERO;
    }
}
