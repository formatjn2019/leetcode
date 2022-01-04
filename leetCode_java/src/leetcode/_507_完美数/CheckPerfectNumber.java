package leetcode._507_完美数;

import java.util.stream.IntStream;

public class CheckPerfectNumber {
    public boolean checkPerfectNumber(int num) {
        return num >= 2 && getFactorSum(num) == num;
    }

    private int getFactorSum(int num) {
        int result = 1;
        for (int t = 2; t < Math.sqrt(num); t++) {
            if (num % t == 0) {
                result += t;
                if (num / t != t) {
                    result += num / t;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CheckPerfectNumber checkPerfectNumber = new CheckPerfectNumber();
        IntStream.range(1, 10000)
                .filter(checkPerfectNumber::checkPerfectNumber)
                .forEach(System.out::println);
//        System.out.println(checkPerfectNumber.checkPerfectNumber(27 * 32 * 17)); //30672
    }
}
