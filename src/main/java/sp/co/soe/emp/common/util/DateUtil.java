package sp.co.soe.emp.common.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Slf4j
public class DateUtil {
    /**
     * Return current month with first date as string
     *
     * @return current month
     */
    public static String getCurrentMonth() {
        log.info("1st day of current month as string");
        LocalDate localDate = LocalDate.now();
        return localDate.with(TemporalAdjusters.firstDayOfMonth()).toString();
    }
}
