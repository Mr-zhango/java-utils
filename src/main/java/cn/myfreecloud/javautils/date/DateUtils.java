package cn.myfreecloud.javautils.date;

import java.time.LocalDate;

public class DateUtils {
    public static void main(String[] args) throws Exception {

    }

    /**
     *
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
