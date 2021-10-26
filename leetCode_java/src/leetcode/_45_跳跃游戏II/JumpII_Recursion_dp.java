package leetcode._45_跳跃游戏II;

import java.util.Arrays;

public class JumpII_Recursion_dp {
    public int jump(int[] nums) {
//        5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5
        int[] judgeArray = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (i <= j + nums[j]) {
                    min = Math.min(min, judgeArray[j] + 1);
                }
            }
            judgeArray[i] = min;
        }
        System.out.println(Arrays.toString(judgeArray));
        return judgeArray[judgeArray.length - 1];
    }

    public static void main(String[] args) {
        int jump = new JumpII_Recursion_dp().jump(new int[]{2, 3, 0, 1, 4});
        int jump2 = new JumpII_Recursion_dp().jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5});
//        System.out.println(jump);
//        System.out.println(jump2);
        System.out.println(new JumpII_Recursion_timeout().jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));
    }
}
