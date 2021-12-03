package leetcode._1005_N次取反后最大的数组和;

import java.util.Arrays;

public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        int result=0;
        //转换求和，并求最小值
        int min=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            int num=nums[i];
            if (k>0 && num<0){
                num=-num;
                k--;
            }
            min=Math.min(min,Math.abs(num));
            result+=num;
        }
        //k未将所有负数转换并无法通过往复转换正数来增加最大值
        if (k % 2 == 1){
            //转换最小的数字
            result-=2*min;
        }
        return result;
    }

    public static void main(String[] args) {
        LargestSumAfterKNegations largestSumAfterKNegations = new LargestSumAfterKNegations();
        System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(new int[]{8,-7,-3,-9,1,9,-6,-9,3}, 8));
    }
}
