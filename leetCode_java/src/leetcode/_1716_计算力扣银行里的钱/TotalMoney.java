package leetcode._1716_计算力扣银行里的钱;

import java.util.stream.IntStream;

public class TotalMoney {
    public int totalMoney(int n) {
        //已经度过的整周的天数
        int spendedweek=n/7;
        //28=(1+7)*7/2;
        int result=(28+28+(spendedweek-1)*7)*spendedweek/2;
        //第几天
        int day=n%7;
        result+=(1+day)*day/2+day*spendedweek;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 8)
                .sum());
        System.out.println((1+7)*7/2);
        TotalMoney totalMoney = new TotalMoney();
        IntStream.range(1,25)
                .peek(_i-> System.out.print(_i+"\t"))
                .map(totalMoney::totalMoney)
                .forEach(System.out::println);
    }
}
