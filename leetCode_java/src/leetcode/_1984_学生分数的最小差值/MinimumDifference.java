package leetcode._1984_学生分数的最小差值;

import java.util.Arrays;

public class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result=Integer.MAX_VALUE;
        for (int i=k-1;i<nums.length;i++){
            result=Math.min(result,nums[i]-nums[i-k+1]);
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumDifference minimumDifference = new MinimumDifference();
        System.out.println(minimumDifference.minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }
}
