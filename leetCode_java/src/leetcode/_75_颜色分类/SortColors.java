package leetcode._75_颜色分类;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] colorCount = new int[3];
        for (int num : nums) {
            colorCount[num]++;
        }
        Arrays.fill(nums,0,colorCount[0],0);
        Arrays.fill(nums,colorCount[0],colorCount[0]+colorCount[1],1);
        Arrays.fill(nums,colorCount[0]+colorCount[1],nums.length,2);
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int []array=new int[]{2,0,2,1,1,1,0,1,0};
        sortColors.sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
