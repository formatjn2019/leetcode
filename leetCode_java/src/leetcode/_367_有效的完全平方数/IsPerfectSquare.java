package leetcode._367_有效的完全平方数;

import java.util.stream.IntStream;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int sqr=sqrt(num);
        return sqr*sqr==num;
    }

    public int sqrt(int num) {

        long target = 1;
        for (long left = 1, right = num / 2 + 1; !(target * target <= num && (target + 1) * (target + 1) > num); ) {
            target = (left + right) / 2;
            System.out.println("---"+target);
            if (target * target == num) {
                break;
            }else if (target*target>num){
                right=target;
            }else {
                left=target+1;
            }
        }
        return (int) target;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        isPerfectSquare.isPerfectSquare(2147483647);
//        IntStream.range(1,100)
//                .map(isPerfectSquare::sqrt)
//                .forEach(System.out::println);
    }
}
