package sp.co.soe.emp.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.SystemParams;
import sp.co.soe.emp.domain.entity.SystemParamsExample;
import sp.co.soe.emp.domain.repository.SystemParamsMapper;
import sp.co.soe.emp.domain.service.SystemParamService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SystemParamServiceImpl implements SystemParamService {
    private final SystemParamsMapper systemParamsMapper;
    private final SystemParamsExample systemParamsExample;

    public SystemParamServiceImpl(SystemParamsMapper systemParamsMapper, SystemParamsExample systemParamsExample) {
        this.systemParamsMapper = systemParamsMapper;
        this.systemParamsExample = systemParamsExample;
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

    @Override
    public List<String> getAllDepartmentCodeForBusinessPlanner() {
        systemParamsExample.clear();
        systemParamsExample.createCriteria().andParamCd1EqualTo(Const.businessPlannerCD1)
                .andParamNm1EqualTo(Const.businessPlannerParamNm1);
        List<SystemParams> systemParams = systemParamsMapper.selectByExample(systemParamsExample);
        return systemParams.stream().map(SystemParams::getParamCd2).collect(Collectors.toList());
    }

    @Override
    public List<String> getPostCodeForSectionManagerOrHigher() {
        systemParamsExample.clear();
        systemParamsExample.createCriteria().andParamCd1EqualTo(Const.sectionManagerParamCD1)
                .andParamNm1EqualTo(Const.sectionManagerParamNm1);
        List<SystemParams> systemParams = systemParamsMapper.selectByExample(systemParamsExample);
        return systemParams.stream().map(SystemParams::getParamCd2).collect(Collectors.toList());
    }
}
