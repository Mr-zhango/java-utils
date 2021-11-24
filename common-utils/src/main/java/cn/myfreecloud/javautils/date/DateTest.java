package cn.myfreecloud.javautils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateTest {

    public static void main(String[] args) throws ParseException {
        String sParam = "Mon Nov 01 00:00:00 CST 2021";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        Date d = sdf.parse(sParam);
        System.out.println("1." + d);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("2." + sdf1.format(d));


        Date modifyTime = new Date();
        Instant instant = modifyTime.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        LocalDateTime localDateTimeLastYear = localDateTime.minus(1, ChronoUnit.YEARS);


        Date date = Date.from( localDateTimeLastYear.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(localDateTimeLastYear);
        System.out.println(date);
    }
    
}