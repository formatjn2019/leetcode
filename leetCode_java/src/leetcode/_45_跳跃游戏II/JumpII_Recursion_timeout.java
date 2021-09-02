package leetcode._45_跳跃游戏II;

public class JumpII_Recursion_timeout {
    public int jump(int[] nums) {

        return jump_one(nums,0);
    }

    public int jump_one(int []nums,int index){
        if (index>=nums.length-1||index<0){
            return 0;
        }
        int min=10000;
        for (int i=nums[index];i>0;i--){
            min=Math.min(min,jump_one(nums,index+i));
        }
        return min+1;
    }


    public static void main(String[] args) {
        int jump = new JumpII_Recursion_timeout().jump(new int[]{2,3,0,1,4});
        System.out.println(jump);
    }
}
