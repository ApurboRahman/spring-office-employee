package sp.co.soe.emp.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

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
    public static String dtToStr(Date dt) {

        String str = null;
        if (dt != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            str = sdf.format(dt);
        }
        return str;
    }

    public static Date strToDt(String str, String pattern) {

        Date dt = null;
        try {
            if (!StringUtils.isEmpty(str)) {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                dt = sdf.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }
}
