package leetcode._1154_一年中的第几天;

import java.util.Arrays;

public class DayOfYear {
    static int[] moonDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        int[] dateArr = Arrays.stream(date.split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int carry = dateArr[1] > 2 && (dateArr[0] % 400 == 0 || (dateArr[0] % 100 != 0 && dateArr[0] % 4 == 0)) ? 1 : 0;
        return Arrays.stream(moonDays).limit(dateArr[1] - 1).sum() + dateArr[2] + carry;
    }

    public static void main(String[] args) {
        DayOfYear dayOfYear = new DayOfYear();
        System.out.println(dayOfYear.dayOfYear("2008-3-1"));
    }
}
