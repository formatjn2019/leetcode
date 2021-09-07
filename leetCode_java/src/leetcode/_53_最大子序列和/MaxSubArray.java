package leetcode._53_最大子序列和;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int max=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            int sum=nums[i];
            max=Math.max(max,sum);
            for (int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                max=Math.max(max,sum);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
//        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
