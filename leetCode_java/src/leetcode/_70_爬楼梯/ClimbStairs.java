package leetcode._70_爬楼梯;

import java.util.stream.IntStream;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] judgeArray = new int[]{1, 2, 0};
        for (int i = 2; i < n; i++) {
            judgeArray[i % 3] = judgeArray[(i + 1) % 3] + judgeArray[(i + 2) % 3];
        }
        return judgeArray[(n - 1) % 3];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        IntStream.range(1, 10)
                .map(climbStairs::climbStairs)
                .forEach(System.out::println);
    }
}
