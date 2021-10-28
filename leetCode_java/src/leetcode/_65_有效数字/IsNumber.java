package leetcode._65_有效数字;

import java.util.Arrays;

public class IsNumber {
    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean numValid = false, indexValid = true;
        //符号判定
        if (result < chars.length && (chars[result] == '-' || chars[result] == '+')) {
            result++;
        }
        //小数点前数字判定
        while (result < chars.length && chars[result] >= '0' && chars[result] <= '9') {
            result++;
            numValid = true;
        }
        //小数点判定
        if (result < chars.length && chars[result] == '.') {
            result++;
        }
        //小数点后数字判定
        while (result < chars.length && chars[result] >= '0' && chars[result] <= '9') {
            result++;
            numValid = true;
        }
        //指数判定
        if (result < chars.length && (chars[result] == 'e' || chars[result] == 'E')) {
            result++;
            indexValid = false;
            //符号判定
            if (result < chars.length && (chars[result] == '-' || chars[result] == '+')) {
                result++;
            }
            //数字判定
            while (result < chars.length && chars[result] >= '0' && chars[result] <= '9') {
                result++;
                indexValid = true;
            }
        }
        return result == chars.length && numValid && indexValid;
    }

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        String[] validNum = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] unvalid = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        System.out.println("有效判定错误");
        Arrays.stream(validNum)
                .filter(s -> !(isNumber.isNumber(s)))
                .forEach(System.out::println);
        System.out.println("无效判定错误");
        Arrays.stream(unvalid)
                .filter(isNumber::isNumber)
                .forEach(System.out::println);
    }
}
