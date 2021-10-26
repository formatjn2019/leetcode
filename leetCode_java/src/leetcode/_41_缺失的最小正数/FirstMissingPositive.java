package leetcode._41_缺失的最小正数;

import java.util.Arrays;
import java.util.BitSet;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //辅助判断数组
        boolean[] judgeArray = new boolean[nums.length];
        //填充数组
        Arrays.stream(nums)
                .parallel()
                .filter(i -> i > 0 && i <= nums.length)
                .forEach(num -> judgeArray[num - 1] = true);
        int result = 0;
        while (judgeArray[result]) {
            result++;
        }
        return result + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        firstMissingPositive.firstMissingPositive(new int[]{4, 2, 0, 3, 2, 5});
    }
}
