package sp.co.soe.emp.domain.logic;

import org.springframework.stereotype.Component;

@Component
public class SampleLogic {

	public String doSampleLogic(String serviceName) {

		StringBuilder sb = new StringBuilder();
		sb.append(serviceName);
		sb.append(" do Logic★");
		return sb.toString();
	}

}
