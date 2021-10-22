package leetcode._1_两数之和;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = new int[nums.length];
        //复制，排序
        System.arraycopy(nums, 0, sortedNums, 0, nums.length);
        Arrays.sort(sortedNums);
        int lp = 0, rp = nums.length - 1;
        //双指针
        //右指针左移，所有大于target的答案排除
        while (rp > 0 && sortedNums[rp] > target) {
            rp--;
        }
        //查找符合条件的元素，跳出
        outter:
        while (rp > 0 && sortedNums[rp] + sortedNums[rp - 1] >= target) {
            //lp二分查找
            int lpTarget = target - sortedNums[rp];
            for (int start = 0, end = rp; start < end; ) {
                lp = (start + end) / 2;
                if (sortedNums[lp] == lpTarget) {
                    break outter;
                } else if (sortedNums[lp] > lpTarget) {
                    end = lp;
                } else {
                    start = lp + 1;
                }
            }
            rp--;
        }
        //找出原始位置
        if (sortedNums[lp] + sortedNums[rp] == target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == sortedNums[lp]) {
                    lp = i;
                    break;
                }
            }
            for (int j = 0; j < nums.length; j++) {
                //防止两元素相同造成的坐标返回错误问题
                if (nums[j] == sortedNums[rp] && j != lp) {
                    rp = j;
                    break;
                }
            }
        } else {
            return new int[]{-1, -1};
        }
        return lp > rp ? new int[]{rp, lp} : new int[]{lp, rp};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{3, 2, 3}, 6);
        System.out.println(ints[0] + "\t\t" + ints[1]);
    }
}
