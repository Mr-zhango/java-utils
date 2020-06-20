package cn.myfreecloud.javautils.date;

import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtils {

    private DateUtils(){

    }

    /**
     * 例如:2018-12-28
     */
    public static final String DATE_WITHOUT_TIME = "yyyy-MM-dd";
    /**
     * 例如:2018-12-28 10:00:00
     */
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    /**
     * 例如:10:00:00
     */
    public static final String TIME_WITHOUT_DATE = "HH:mm:ss";
    /**
     * 例如:10:00
     */
    public static final String TIME_WITHOUT_SECOND = "HH:mm";

    /**
     * 例如:2018-12-28 10:00
     */
    public static final String DATE_TIME_WITHOUT_SECONDS = "yyyy-MM-dd HH:mm";


    /**
     * 获取年
     *
     * @return 年
     */
    public static int getYear() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.YEAR);
    }

    /**
     * 获取月份
     *
     * @return 月份
     */
    public static int getMonth() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.MONTH_OF_YEAR);
    }

    /**
     * 格式化日期为字符串
     *
     * @param date    date
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {

        if(date==null){
            return "";
        }
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 解析字符串日期为Date
     *
     * @param dateStr 日期字符串
     * @param pattern 格式 yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date parseString2Date(String dateStr, String pattern) {

        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 解析字符串日期为Date(得到当天的开始时间)
     *
     * @param dateStr 日期字符串
     * @param pattern 格式 yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date parseString2DateStart(String dateStr, String pattern) {
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }


    /**
     * 解析字符串日期为Date(传入当天之后一天的开始时间)
     *
     * @param dateStr 日期字符串
     * @param pattern 格式 yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date parseString2DateEnd(String dateStr, String pattern) {
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.plusDays(1).atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }


    /**
     * 为Date增加分钟,减的话 传 负数
     *
     * @param date        日期
     * @param plusMinutes 要增加的分钟数
     * @return 新的日期
     */
    public static Date addMinutes(Date date, Long plusMinutes) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime newDateTime = dateTime.plusMinutes(plusMinutes);
        return Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 增加时间
     *
     * @param date date
     * @param hour 要增加的小时数
     * @return new date
     */
    public static Date addHour(Date date, Long hour) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime = dateTime.plusHours(hour);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * @return 返回当天的起始时间
     */
    public static Date getStartTime() {
        LocalDateTime now = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return localDateTime2Date(now);
    }


    /**
     * @return 返回当天的结束时间
     */
    public static Date getEndTime() {
        LocalDateTime now = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999);
        return localDateTime2Date(now);
    }


    /**
     * 减月份
     *
     * @param monthsToSubtract 月份
     * @return Date
     */
    public static Date minusMonths(long monthsToSubtract) {
        LocalDate localDate = LocalDate.now().minusMonths(monthsToSubtract);
        return localDate2Date(localDate);
    }


    /**
     * LocalDate类型转为Date
     *
     * @param localDate LocalDate object
     * @return Date object
     */
    public static Date localDate2Date(LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime类型转为Date
     *
     * @param localDateTime LocalDateTime object
     * @return Date object
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 查询当前年的第一天
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getFirstDayOfCurrentYear(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().withMonth(1).withDayOfMonth(1);

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }

        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 查询(l)年第一月第一天
     * 默认格式yyyy-MM-dd
     * @param l 0 当年, 1明年 2后年
     * @return 例如:2019-01-01
     */
    public static String getFirstDayOfYear(Long l) {
        LocalDateTime localDateTime = LocalDateTime.now().plusYears(l).withMonth(1).withDayOfMonth(1);
        return format(localDateTime2Date(localDateTime), DATE_WITHOUT_TIME);
    }

    /**
     * 查询前一年最后一个月第一天
     *
     * @param pattern 格式，默认格式yyyy-MM-dd
     * @return 20190101
     */
    public static String getLastMonthFirstDayOfPreviousYear(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().minusYears(1L).withMonth(12).withDayOfMonth(1);

        if (StringUtils.isEmpty(pattern)) {
            pattern = DATE_WITHOUT_TIME;
        }

        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 查询前一年最后一个月最后一天
     *
     * 默认格式yyyy-MM-dd
     * @return 2019-12-31
     */
    public static String getLastMonthLastDayOfPreviousYear(Long l) {
        LocalDateTime localDateTime = LocalDateTime.now()
                .minusYears(l)
                .with(TemporalAdjusters.lastDayOfYear());

        return format(localDateTime2Date(localDateTime), DATE_TIME);
    }

    /**
     * 获取当前日期
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getCurrentDay(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }

        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * String转LocalDate
     */
    public static LocalDateTime stringDate2LocalDate(String stringDate) {

        return LocalDateTime.parse(stringDate, DateTimeFormatter.ofPattern(DATE_TIME));
    }

    /**
     * 根据输入过去当前时间所属季度的开始时间和结束时间
     * @param phase
     */
    public static void getPhaseByInput(String phase) {
        LocalDate date = LocalDate.now();
        int year = date.getYear();

        if(StringUtils.isEmpty(phase)){
            phase = "第二季度";
        }

        String startDate = "";
        String endDate = "";
        if(phase.equals("第一季度")){
            startDate = year + "-01";
            endDate = year + "-03";
        }else if(phase.equals("第二季度")){
            startDate = year + "-04";
            endDate = year + "-06";
        }else if(phase.equals("第三季度")){
            startDate = year + "-07";
            endDate = year + "-09";
        }else if(phase.equals("第四季度")){
            startDate = year + "-10";
            endDate = year + "-12";
        }
        System.out.println("开始时间:"+startDate);
        System.out.println("结束时间:"+endDate);
    }

    /**
     *  获取当前时间所属季度
     */
    public static String getCurrentPhasr() {
        LocalDate date = LocalDate.now();
        int month = date.getMonth().getValue();
        if(month == 1 || month ==2 || month ==3){
            return "第一季度";
        }
        else if(month == 4 || month ==5 || month ==6){
            return "第二季度";
        }
        else if(month == 7 || month ==8 || month ==9){
            return "第三季度";
        }
        else if(month == 10 || month ==11 || month ==12){
            return "第四季度";
        }else {
            return "转换异常";
        }
    }
}
