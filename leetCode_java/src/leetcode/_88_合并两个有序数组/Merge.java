package leetcode._88_合并两个有序数组;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0){
            return;
        }
        int mp=nums1.length-1,lp=m-1,rp=n-1;
        while ((lp>=0 || rp>=0) && !(lp==mp)){
            if (lp>=0 && nums1[lp]>=nums2[rp]){
                nums1[mp--]=nums1[lp--];
            }else {
                nums1[mp--]=nums2[rp--];
            }
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int []nums1=new int[]{2};
//        merge.merge(nums1,1,new int[]{1},1);
        merge.merge(nums1,0,new int[]{1},1);
        System.out.println(Arrays.toString(nums1));
    }
}
