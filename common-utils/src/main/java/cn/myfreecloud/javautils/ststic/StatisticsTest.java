package cn.myfreecloud.javautils.ststic;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsTest {

    public static void main(String[] args) {
        // 适用于统计报表 时间对比数据填充
    }



    private List<EsDb> mergeDayList(List<EsDb> daysInDb, Date startDate, Date endDate) {
        List<EsDb> dayList = this.expandDateList(startDate, endDate);
        for (int i = 0; i < dayList.size(); i++) {
            final int idx = i;
            EsDb oneDay = dayList.get(i);
            daysInDb.stream().filter(d -> d.getReportDate().equals(oneDay.getReportDate())).findFirst().ifPresent(d -> {
                dayList.set(idx, d);
            });
        }
        return dayList;
    }

    private List<EsDb> expandDateList(Date startDate, Date endDate){
        List<EsDb> dayList = new ArrayList<>();
        Date currentDate = startDate;
        while(currentDate.getTime()<=endDate.getTime()){
            EsDb oneDay = new EsDb();
            oneDay.setReportDate(currentDate);
            oneDay.setCost(0d);
            oneDay.setUserRegisterNum(0d);
            oneDay.setUserCompleteResumeNum(0d);
            oneDay.setChatUserNum(0d);
            oneDay.setChatInstanceNum(0d);
            dayList.add(oneDay);
            currentDate = new Date(currentDate.toInstant().plus(1, ChronoUnit.DAYS).toEpochMilli());
        }
        return dayList;
    }

}
