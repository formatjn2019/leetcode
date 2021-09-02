package leetcode._45_跳跃游戏II;

public class JumpII_Recursion_Greedy {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int result = 1, max = nums[0], start = 1;
        for (int newMax = max; max < nums.length-1; result++) {
            for (; start <= max; start++) {
                newMax = Math.max(newMax, start + nums[start]);
            }
            max=newMax;
        }
        return result;
    }

    public static void main(String[] args) {
        int jump = new JumpII_Recursion_Greedy().jump(new int[]{2, 3, 0, 1, 4});
        int jump2 = new JumpII_Recursion_Greedy().jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5});
        System.out.println(jump);
        System.out.println(jump2);
//        System.out.println(jump);
//        System.out.println(jump2);
//        System.out.println(new JumpII_Recursion_timeout().jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
