package sp.co.soe.emp.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Mapper
public interface DateMapper {

	/**
	 * current date in time stamp
	 *
	 * @return
	 */
	Date selectTimestamp();

	/**
	 * First day of current month YYYY-MM-DD format
	 *
	 * @return  current month
	 */
	Date selectFirstDayOfMonth();

	/**
	 * First day of previous month YYYY-MM-DD format
	 *
	 * @return previous month
	 */
	Date selectFirstDayOfPreviousMonth();

}
