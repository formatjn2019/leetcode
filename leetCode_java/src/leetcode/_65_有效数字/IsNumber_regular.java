package leetcode._65_有效数字;

import java.util.Arrays;

public class IsNumber_regular {
    public boolean isNumber(String s) {
        return s.replaceAll("^(?:(?:(?:[+-]?(?:(?:\\d+\\.\\d*)|(?:\\d*\\.\\d+))|[+-]?\\d+)))(?:[eE][+-]?\\d{1,})?", "").length() == 0;
    }

    public static void main(String[] args) {
        IsNumber_regular isNumber = new IsNumber_regular();
        String[] validNum = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] unvalid = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        System.out.println("有效判定错误");
        Arrays.stream(validNum)
                .filter(s->!(isNumber.isNumber(s)))
                .forEach(System.out::println);
        System.out.println("无效判定错误");
        Arrays.stream(unvalid)
                .filter(isNumber::isNumber)
                .forEach(System.out::println);
    }
}
