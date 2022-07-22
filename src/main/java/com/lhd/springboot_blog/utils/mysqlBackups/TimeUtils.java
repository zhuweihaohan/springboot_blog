package com.lhd.springboot_blog.utils.mysqlBackups;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/22 9:59
 * @company bonc
 * @project springboot_blog
 */
public class TimeUtils {
    public static String getLast7Day() {

        //日期格式2020-06-02
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -7);
            Date dateTime = calendar.getTime();
            String day = sdf.format(dateTime);
           return  day ;

    }
    public static String getDay() {

        //日期格式2020-06-02
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date dateTime = calendar.getTime();
        String day = sdf.format(dateTime);
        return  day ;

    }

}
