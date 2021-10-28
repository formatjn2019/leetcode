package leetcode._55_跳跃游戏;

public class CanJump {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i <= max && i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {

    }
}
