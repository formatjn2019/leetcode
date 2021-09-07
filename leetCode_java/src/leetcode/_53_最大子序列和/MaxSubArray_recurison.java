package leetcode._53_最大子序列和;

public class MaxSubArray_recurison {
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int []sums=new int[nums.length];
        sums[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            sums[i]=Math.max(nums[i],sums[i-1]+nums[i]);
        }
        int result=sums[0];
        for (int sum : sums) {
            result=Math.max(sum,result);
        }
        return result;
    }



    public static void main(String[] args) {
        MaxSubArray_recurison maxSubArray = new MaxSubArray_recurison();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
