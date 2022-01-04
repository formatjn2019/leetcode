package leetcode._1185_一周中的第几天;

import java.util.Arrays;

public class DayOfTheWeek {
    static int[] mountSum = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    static String[] translate = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        //相较于1971年的日数
        //年
        int dify = year - 1971;
        //闰年数量，因为不会包含被100整除，不被400整除的情况
        int days = dify * 365 + (dify + 2) / 4;
        //月份
        days += mountSum[month-1];
        if (month > 2 && ((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0))) {
            days += 1;
        }
        //日
        days += day;
        return translate[(days + 4) % 7];
    }

    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek(3, 1, 2022));
        System.out.println(dayOfTheWeek.dayOfTheWeek(29, 2, 2016));
        System.out.println(dayOfTheWeek.dayOfTheWeek(1, 1, 2010));
        System.out.println(dayOfTheWeek.dayOfTheWeek(4, 10, 2008));
        System.out.println(dayOfTheWeek.dayOfTheWeek(1, 4, 2015));
        System.out.println(dayOfTheWeek.dayOfTheWeek(1, 10, 2100));
    }
}
