package leetcode._16_最接近的三数之和;

import java.util.Arrays;

public class ThreeNumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minClose=1000000000;
        for (int firstIndex=0;firstIndex<nums.length-2;firstIndex++){
            for (int lp=firstIndex+1,rp=nums.length-1;lp<rp;){
                int sum = nums[firstIndex] + nums[lp] + nums[rp];
                int currentClose=sum-target;
                minClose=Math.abs(minClose)>Math.abs(currentClose)?currentClose:minClose;
                if (currentClose>0){
                    rp--;
                }else {
                    lp++;
                }
            }
        }
        return target+minClose;
    }
    public boolean test(int []nums, int target,int expect){
        int result = threeSumClosest(nums,target);
        boolean passed =result==expect;
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
        ThreeNumClosest threeNumClosest = new ThreeNumClosest();
        threeNumClosest.test(new int[]{-1,2,1,-4},1,2);
        threeNumClosest.test(new int[]{0,2,1,-3},1,0);
        threeNumClosest.test(new int[]{-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33},0,0);
    }
}
