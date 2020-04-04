package sp.co.soe.emp.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sp.co.soe.emp.app.bean.EmployeeInfoBean;

@Service
public interface EmployeeInfoService {

	/* 社員一覧検索 */
	public List<EmployeeInfoBean> getEmployeeInfoList();

	/* 新規登録 */
	public String createEmployeeInfo(EmployeeInfoBean bean);

}
