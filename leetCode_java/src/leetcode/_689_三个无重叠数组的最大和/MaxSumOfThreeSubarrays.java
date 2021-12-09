package leetcode._689_三个无重叠数组的最大和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //滑动窗口
        //数组和
        int maxSum1, maxSum12, maxResult,sum1Index=0,sum2Index=k,maxIndex1=0;
        int[] sums = new int[3];
        //初始数据
        for (int i = 0; i < 3 * k; i++) {
            sums[i / k] += nums[i];
        }
        maxSum1 = sums[0];
        maxSum12 = sums[0] + sums[1];
        maxResult = maxSum12 + sums[2];
        int[] result = new int[]{0,k,2*k};
        //范围
        for (int i = 0; i < nums.length - 3 * k; i++) {
            System.out.println(i+"\t"+(i+k)+"\t"+"\t"+(i+2*k)+"\t"+(i+3*k));
            sums[0]=sums[0]-nums[i]+nums[i+k];
            //更新第一个数组和的最大值
            if (sums[0]>maxSum1){
                maxSum1=sums[0];
                maxIndex1=i+1;
            }
            sums[1]=sums[1]-nums[i+k]+nums[i+2*k];
            //更新前两个数组和的最大值
            if (maxSum1+sums[1]>maxSum12){
                maxSum12=maxSum1+sums[1];
                sum1Index=maxIndex1;
                sum2Index=i+k+1;
            }
            sums[2]=sums[2]-nums[i+2*k]+nums[i+3*k];
            //更新前两个数组和的最大值
            if (maxSum12+sums[2]>maxResult){
                maxResult=maxSum12+sums[2];
                result[2]=i+2*k+1;
                result[1]=sum2Index;
                result[0]=sum1Index;
            }
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        MaxSumOfThreeSubarrays maxSumOfThreeSubarrays = new MaxSumOfThreeSubarrays();
//        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2);
//        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2}, 2);
        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{2,2,9,8,2,2,7,6,5,2,2},2);
//        int[] ints = maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{17, 7, 19, 11, 1, 19, 17, 6, 13, 18, 2, 7, 12, 16, 16, 18, 9, 3, 19, 5}, 6);
//        System.out.println(Arrays.toString(ints));
    }
}
