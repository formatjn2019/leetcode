package leetcode._453_最小的操作次数使数组元素相等;

import java.util.Arrays;

public class MinMoves_update {
    public int minMoves(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        System.out.println(Arrays.toString(nums));
        for (int temp,maxIndex=nums.length-1;(temp = nums[maxIndex]-nums[(maxIndex+1)%nums.length]) != 0;maxIndex=(maxIndex+nums.length-1)%nums.length) {
            sum += temp;
            for (int i=0;i<nums.length-1;i++){
                nums[(maxIndex+1+i)%nums.length]+=temp;
            }
            System.out.println(Arrays.toString(nums));
        }
        return sum;
    }



    public static void main(String[] args) {
        MinMoves_update minMoves = new MinMoves_update();
        MinMoves minMoves1=new MinMoves();
        System.out.println(minMoves.minMoves(new int[]{0, 9, 9, 9, 9, 8}));
        System.out.println(minMoves1.minMoves(new int[]{0, 9, 9, 9, 9, 8}));
        System.out.println(minMoves.minMoves(new int[]{0, 2, 3, 4, 5, 9, 8}));
        System.out.println(minMoves1.minMoves(new int[]{0, 2, 3, 4, 5, 9, 8}));
//        System.out.println(minMoves.minMoves(new int[]{1,1,1}));
//        System.out.println(minMoves.minMoves(new int[]{-100,0,100}));
    }
}
