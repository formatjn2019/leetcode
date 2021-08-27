package leetcode._11_盛水最多的容器;

import java.util.Arrays;

public class MaxArea_Exhaustive_timeout {
    public int maxArea(int[] height) {
        int result=0;
        for (int l=0;l<height.length;l++){
            for (int r=height.length-1;r>l;r--){
                result=Math.max((r-l)*Math.min(height[l],height[r]),result);
            }
        }
        return result;
    }
    public boolean test(int []height,int expect){
        int result = maxArea(height);
        boolean passed = expect == result;
        if (!passed){
            System.out.println("失败");
            System.out.println(Arrays.toString(height));
            System.out.println("结果:"+result+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        MaxArea_Exhaustive_timeout maxArea_exhaustive= new MaxArea_Exhaustive_timeout();
        maxArea_exhaustive.test(new int[]{1,8,6,2,5,4,8,3,7},49);
        maxArea_exhaustive.test(new int[]{1,1},1);
        maxArea_exhaustive.test(new int[]{4,3,2,1,4},16);
        maxArea_exhaustive.test(new int[]{1,2,1},2);
    }
}
