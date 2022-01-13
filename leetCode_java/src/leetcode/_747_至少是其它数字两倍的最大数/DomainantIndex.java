package leetcode._747_至少是其它数字两倍的最大数;

public class DomainantIndex {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        boolean hasResult = true;
        for (int i = 1; i < nums.length; i++) {
            hasResult = nums[maxIndex] >= 2 * nums[i] && hasResult;
            if (nums[i] > nums[maxIndex]) {
                //若有最大值，则更新最大值，并同步更新结果
                hasResult = nums[i] >= 2 * nums[maxIndex];
                maxIndex = i;
            }
        }
        return hasResult ? maxIndex : -1;
    }
}
