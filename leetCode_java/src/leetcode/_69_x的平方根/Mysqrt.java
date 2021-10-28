package leetcode._69_x的平方根;

import java.util.stream.IntStream;

public class Mysqrt {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int result = x / 2;
        while (!(result * result <= x && ((result + 1) * (result + 1) > x))) {
            result = result * result > x ? result / 2 : result + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Mysqrt mysqrt = new Mysqrt();
        IntStream.range(0, 1000)
                .map(mysqrt::mySqrt)
                .forEach(System.out::println);
    }
}
