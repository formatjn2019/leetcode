package leetcode._453_最小的操作次数使数组元素相等;

import java.util.Arrays;

public class MinMoves {
    public int minMoves(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        int temp;
        while ((temp = insertSort(nums)) != 0) {
            sum += temp;
            for (int i=0;i<nums.length-1;i++){
                nums[i]+=temp;
            }
        }
        return sum;
    }

    public int insertSort(int[] nums) {
        int index = nums.length - 2;
        int tempNum = nums[nums.length - 1];
        for (; index >= 0; index--) {
            //元素后移
            nums[index + 1] = nums[index];
            if (nums[index] <= tempNum) {
                break;
            }
        }
        nums[index+1]=tempNum;
        return nums[nums.length - 1] - nums[0];
    }

    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
//        System.out.println(minMoves.minMoves(new int[]{0, 9, 9, 9, 9, 8}));
        System.out.println(minMoves.minMoves(new int[]{0, 2, 3, 4, 5, 9, 8}));
//        System.out.println(minMoves.minMoves(new int[]{1,1,1}));
//        System.out.println(minMoves.minMoves(new int[]{-100,0,100}));
    }
}
