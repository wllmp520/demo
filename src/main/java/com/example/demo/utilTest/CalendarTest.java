package com.example.demo.utilTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: Calendar测试类 实现获取周几
 * @author: wllmp520
 * @create: 2019-07-02 16:34
 */
public class CalendarTest {
    public static void main(String[] args) {
        getWeekDate();
    }

    /**
     * 当前时间所在一周的周一和周日时间
     * @param time 当前时间
     * @return
     */
    public static Map<String,String> getWeekDate() {
        Map<String,String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if(dayWeek==1){
            dayWeek = 8;
        }
        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
        System.out.println("所在周星期一的日期：" + weekBegin);


        cal.add(Calendar.DATE, 4 +cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);
        System.out.println("所在周星期日的日期：" + weekEnd);


        Calendar c = Calendar.getInstance();//当前日期
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;//Calendar日历默认 周末==一周的开始 所以-1
        int interval = 0;
        if (day_of_week == 0){//今天是周日
            interval = 8;//一周7天+1
        }else{
            interval = 14-day_of_week + 1;
        }

        c.add(Calendar.DATE, interval);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nextStr = format.format(c.getTime());
        System.out.println("一周之后的周一应该是:"+nextStr);
        map.put("mondayDate", weekBegin);
        map.put("sundayDate", weekEnd);
        map.put("nextStr", nextStr);
        return map;
    }

}