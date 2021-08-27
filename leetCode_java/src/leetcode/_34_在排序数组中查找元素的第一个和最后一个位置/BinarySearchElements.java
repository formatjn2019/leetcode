package leetcode._34_在排序数组中查找元素的第一个和最后一个位置;

import java.util.stream.IntStream;

public class BinarySearchElements {
    public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int from=-1,to=-1;
        while (start<=end){
            int medium=(start+end)/2;
            if(nums[medium]==target){
                from=medium;
                break;
            }else if (nums[medium]>target){
                end=medium-1;
            }else {
                start=medium+1;
            }
        }
        if (from!=-1){
            for (to=from;to<nums.length-1&&nums[to]==nums[to+1];to++){}
            while (from>0&&nums[from-1]==nums[from]){
                from--;
            }
        }
        System.out.println("++++++++++++++++++");
        System.out.println(target);
        System.out.println(from);
        System.out.println(to);
        System.out.println("__________________");
        return new int[]{from,to};
    }
    public static void main(String[] args) {
        BinarySearchElements binarySearchElements = new BinarySearchElements();
        IntStream.range(0,6).forEach(i->binarySearchElements.searchRange(new int[]{1,2,3,3,4,4,5,5,5},i));
    }
}
