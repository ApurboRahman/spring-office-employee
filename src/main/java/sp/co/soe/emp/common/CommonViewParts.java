package sp.co.soe.emp.common;

import sp.co.soe.emp.common.util.Const;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommonViewParts {

	// 在籍区分入力プルダウン用Map生成
	public static Map<String, String> getEnrollmentTypeMap(){
		return  Collections.unmodifiableMap(
			new LinkedHashMap<String, String>(){
				{
					put(Const.ENROLLMENT_TYPE_INCUMBENT, Const.EnumEnrollmentType.INCUMBENT.getValue());
					put(Const.ENROLLMENT_TYPE_ABSENCE, Const.EnumEnrollmentType.ABSENCE.getValue());
					put(Const.ENROLLMENT_TYPE_RETIRE, Const.EnumEnrollmentType.RETIRE.getValue());
				}
			}
		);
	}

	// 性別入力ラジオボタン用Map生成
	public static Map<String, String> getGenderMap(){
		return  Collections.unmodifiableMap(
			new LinkedHashMap<String, String>(){
				{
					put(Const.SEX.get(0), Const.SEX.get(1));
					put(Const.SEX.get(2), Const.SEX.get(3));
				}
			}
		);
	}
}
