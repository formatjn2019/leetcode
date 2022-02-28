package leetcode._2016_增量元素之间的最大差值;

public class MaximumDifference {
    public int maximumDifference(int[] nums) {
        int result=-1;
        int min=Integer.MAX_VALUE;
        for (int num : nums) {
            if (num<=min){
                min=num;
            }else {
                result=Math.max(num-min,result);
            }
        }
        return result;
    }
}
