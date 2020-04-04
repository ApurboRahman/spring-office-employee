package sp.co.soe.emp.domain.service.impl;

import com.github.dozermapper.core.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.EmployeeInfoBean;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.EmployeeInfo;
import sp.co.soe.emp.domain.entity.EmployeeInfoExample;
import sp.co.soe.emp.domain.logic.SampleLogic;
import sp.co.soe.emp.domain.repository.EmployeeInfoMapper;
import sp.co.soe.emp.domain.service.EmployeeInfoService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Autowired
	EmployeeInfoExample employeeInfoExample;

	@Autowired
	EmployeeInfoMapper employeeInfoMapper;

	@Autowired
	SampleLogic sampleLogic;

	/* DozerMapping */
	@Autowired
	Mapper dozerMapper;

	@Override
	public List<EmployeeInfoBean> getEmployeeInfoList(){

		// log
		log.info("getEmployeeInfoList Start!");

		employeeInfoExample.createCriteria().andJoinDateBetween(Date.valueOf("2019-07-01"), Date.valueOf("2020-02-20"));
		employeeInfoExample.setOrderByClause("manno DESC");
		List<EmployeeInfo> employeeInfoList = employeeInfoMapper.selectByExample(employeeInfoExample);

		// 0件の場合は空のリストを返す
		if(Objects.equals(employeeInfoList.size(), 0)) {
			return Collections.emptyList();
		}

		List<EmployeeInfoBean> retList = new ArrayList<>();
		for(EmployeeInfo empInfo : employeeInfoList) {
			/*
			 * DozerMapping
			 */
			EmployeeInfoBean empInfoBean = new EmployeeInfoBean();
			dozerMapper.map(empInfo, empInfoBean);
			retList.add(empInfoBean);
		}

		// Logicクラス呼び出しサンプルコード
		sampleLogic.doSampleLogic(new Object(){}.getClass().getEnclosingClass().getName());

		return retList;

	}

	@Override
	public String createEmployeeInfo(EmployeeInfoBean insertEmpInfoBean) {

		// log
		log.info("createEmployeeInfo start!");


		/*
		 * DozerMapping
		 */
		EmployeeInfo insertEmpInfo = new EmployeeInfo();
		dozerMapper.map(insertEmpInfoBean, insertEmpInfo);

		// TODO エラーハンドリングは仮実装
		try {
			employeeInfoMapper.insertSelective(insertEmpInfo);
		}catch(DataAccessException e) {
			e.printStackTrace();
			return Const.CREATE_ERROR;
		}
		return Const.CREATE_SUCCESS;
	}

}
