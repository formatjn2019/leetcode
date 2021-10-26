package leetcode._31_下一个排列;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int j = nums.length - 1; j > 0; j--) {
            //找到不符合升序排列的第一个数
            if (nums[j - 1] < nums[j]) {
                int minIndex = j;
                for (int k = j; k < nums.length; k++) {
                    if (nums[minIndex] > nums[k] && nums[k] > nums[j - 1]) {
                        minIndex = k;
                    }
                }
                int min = nums[minIndex];
                //排序
                System.out.println(min);
                Arrays.sort(nums, j - 1, nums.length);
                for (int l = nums.length - 1; l >= j; l--) {
                    if (nums[l] <= min) {
                        nums[l] = nums[l - 1];
                    }
                }
                nums[j - 1] = min;
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] ints = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
//        4,2,0,3,0,2,2
        ints = new int[]{3, 1, 2};
        nextPermutation.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{2, 3, 1};
        nextPermutation.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
