package sp.co.soe.emp.common.util;

import java.util.Arrays;
import java.util.List;

public class Const {

	//common url
	public static final String LANDING_URL ="/";
	public static final String LOGIN_URL ="/login";
	public static final String LOGOUT_URL ="/logout";
	public static final String INFORMATION_URL ="/information";
	public static final String LOGIN_ERROR ="/login-error";
	public static final String ERROR_URL ="/error";

	//static folders location
	public static final String CSS = "/css/**";
	public static final String FONTS = "/fonts/**";
	public static final String JS = "/js/**";
	public static final String IMG = "/img/**";
	public static final String BOOTSTRAP = "/bootstrap/**";
	public static final String FAVICON = "/**/favicon.ico";

	//for JSESSIONID
	public static final String JSESSIONID = "JSESSIONID";

	//for username and password
	public static final String USER_NAME ="username";
	public static final String PASSWORD ="password";

	//HTML page names
	public static final String LOGIN = "login";
	public static final String LOGOUT = "logout";
	public static final String INFORMATION = "information";
	public static final String LAYOUT = "layout";

	//System params variables name
	public static String securityCommittee = "1";
	public static String businessPlannerCD1 = "050000";
	public static String businessPlannerParamNm1 = "事業企画";
	public static String sectionManagerParamCD1 = "050100";
	public static String sectionManagerParamNm1 = "課長以上";
	public static enum EnumEnrollmentType{

		INCUMBENT("在職"),
		ABSENCE("休職"),
		RETIRE("退職");

		private String enrollmentType;

		EnumEnrollmentType(String enrollmentType) {
			this.enrollmentType = enrollmentType;
		}

		public String getValue() {
			return enrollmentType;
		}
	}

	public static final List<String> SEX = Arrays.asList("M", "男性", "F", "女性");

	public static final String ENROLLMENT_TYPE_INCUMBENT = "0";
	public static final String ENROLLMENT_TYPE_ABSENCE = "1";
	public static final String ENROLLMENT_TYPE_RETIRE = "9";

	public static final String CREATE_SUCCESS = "登録しました！";
	public static final String CREATE_ERROR = "登録に失敗しました。入力内容を確認してください";

	public static final String VIEW_EMPLOYEE_LIST = "社員情報一覧";
	public static final String VIEW_EMPLOYEE_DATA_CREATE = "社員情報登録";
	public static final String TITLE = "title";
}
