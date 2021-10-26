package leetcode._42_接雨水;

import java.util.Arrays;

public class Trap {
    public int trap(int[] height) {
        //双指针
        int lp = 0, rp = height.length - 1, prelevel = 0, area = 0, max = 0;
        while (lp < rp) {
            //面积计算
            if (height[lp] > prelevel && height[rp] > prelevel) {
                int newLevel = Math.min(height[lp], height[rp]);
                area += (newLevel - prelevel) * (rp - lp + 1);
                prelevel = newLevel;
            }
            if (height[lp] > height[rp]) {
                max = Math.max(height[lp], max);
                rp--;
            } else {
                max = Math.max(height[rp], max);
                lp++;
            }
        }
        int sum = 0;
        for (int j : height) {
            sum += j;
        }
        //漏出的不算
        return Math.max(0, area - (sum - (max - prelevel)));
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int trap1 = trap.trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(trap1);
    }
}
