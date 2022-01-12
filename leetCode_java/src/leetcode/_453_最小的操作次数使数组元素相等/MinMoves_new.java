package leetcode._453_最小的操作次数使数组元素相等;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MinMoves_new {
    public int minMoves(int[] nums) {
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        return Arrays.stream(nums)
                .peek(_n -> min.set(Math.min(min.get(), _n)))
                .sum() - nums.length * min.get();
    }

    public static void main(String[] args) {
        MinMoves_new minMoves = new MinMoves_new();
        System.out.println(minMoves.minMoves(new int[]{1, 2, 3}));
    }
}
