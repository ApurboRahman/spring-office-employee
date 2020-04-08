package sp.co.soe.emp.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.SystemParams;
import sp.co.soe.emp.domain.repository.SystemParamsMapper;
import sp.co.soe.emp.domain.service.SystemParamService;

@Service
@Slf4j
public class SystemParamServiceImpl implements SystemParamService {
    private final SystemParamsMapper systemParamsMapper;

    public SystemParamServiceImpl(SystemParamsMapper systemParamsMapper) {
        this.systemParamsMapper = systemParamsMapper;
    }

    @Override
    public String getUploadDirectoryPathFromSystemParam() {
        SystemParams systemParams = systemParamsMapper.selectByPrimaryKey(Const.CSV_UPLOAD_PARAMETER_ID);
        if (null != systemParams) {
            log.info("get directory location from system param");
            return systemParams.getParamNm2();
        }
        log.warn("could not find directory location from system param");
        return null;
    }
}
