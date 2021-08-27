package leetcode._26_删除有序数组中的重复项;

import java.util.Arrays;

public class RemoveDuplicates_doublePoint {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int slow=0,fast=1;
        for (;fast<nums.length;fast++){
            if (nums[fast]!=nums[slow]){
                slow++;
            }
                nums[slow]=nums[fast];

        }
        return slow+1;
    }
    public boolean test(int []nums,String expect){
        int result = removeDuplicates(nums);
        boolean passed =expect.equals(Arrays.toString(Arrays.copyOf(nums,result)));
        System.out.println(Arrays.toString(Arrays.copyOf(nums,result)));
        if (!passed){
            System.out.println("失败");
            System.out.println(Arrays.toString(nums));
            System.out.println("结果:"+result+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }
    public static void main(String[] args) {
        RemoveDuplicates_doublePoint removeDuplicates_doublePoint = new RemoveDuplicates_doublePoint();
        removeDuplicates_doublePoint.test(new int[]{1,1,2},"[1, 2]");
        removeDuplicates_doublePoint.test(new int[]{0,0,1,1,1,2,2,3,3,4},"[0, 1, 2, 3, 4]");
    }
}
