package leetcode._11_盛水最多的容器;

import java.util.Arrays;

public class MaxArea_doublePoint {
    public int maxArea(int[] height) {
        //初始化结果为两端的值
        int result=Math.min(height[0],height[height.length-1])*(height.length-1);
        //依次移动两段指针，每次移动指向最低的容器壁的指针，更新结果
        for (int l=0,r=height.length-1;l<r;) {
            if (height[l] > height[r]){
                r--;
            }else{
                l++;
            }
            result=Math.max(Math.min(height[l],height[r])*(r-l),result);
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
        MaxArea_doublePoint maxArea_exhaustive= new MaxArea_doublePoint();
        maxArea_exhaustive.test(new int[]{1,8,6,2,5,4,8,3,7},49);
        maxArea_exhaustive.test(new int[]{1,1},1);
        maxArea_exhaustive.test(new int[]{4,3,2,1,4},16);
        maxArea_exhaustive.test(new int[]{1,2,1},2);
        maxArea_exhaustive.test(new int[]{2,3,10,5,7,8,9},36);
        maxArea_exhaustive.test(new int[]{2,3,10,5,7,8,9},36);
        maxArea_exhaustive.test(new int[]{2,3,4,5,18,17,6},17);
    }
}
