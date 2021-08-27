package leetcode._27_移除重复元素;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length==0){
            return 0;
        }
        int start=0;
        for (int end=nums.length-1;start<end;start++){
            if (nums[start]==val){
                nums[start--]=nums[end--];
            }
        }
        return nums[start]==val?start:start+1;
    }
    public boolean test(int []nums,int val,String expect){
        int result = removeElement(nums,val);
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
        RemoveElement removeElement = new RemoveElement();
        removeElement.test(new int[]{}, 1, "[]");
        removeElement.test(new int[]{1}, 1, "[]");
        removeElement.test(new int[]{4,5}, 5, "[4]");
        removeElement.test(new int[]{3, 2, 2, 3}, 3, "[2, 2]");
        removeElement.test(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, "[0, 1, 4, 0, 3]");
    }
}
