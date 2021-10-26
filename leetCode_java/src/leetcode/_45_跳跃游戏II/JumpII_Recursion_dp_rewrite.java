package leetcode._45_跳跃游戏II;

import java.util.Arrays;

public class JumpII_Recursion_dp_rewrite {
    public int jump(int[] nums) {
        int[] achieveArray = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < achieveArray.length && (achieveArray[i + j] == 0 || achieveArray[i + j] > achieveArray[i] + 1)) {
                    achieveArray[i + j] = achieveArray[i] + 1;
                }
            }
        }
        return achieveArray[achieveArray.length - 1];
    }

    public static void main(String[] args) {
        int jump = new JumpII_Recursion_dp_rewrite().jump(new int[]{2, 3, 0, 1, 4});
        int jump2 = new JumpII_Recursion_dp_rewrite().jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5});
        System.out.println(jump);
        System.out.println(jump2);
//        System.out.println(jump);
//        System.out.println(jump2);
//        System.out.println(new JumpII_Recursion_timeout().jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
