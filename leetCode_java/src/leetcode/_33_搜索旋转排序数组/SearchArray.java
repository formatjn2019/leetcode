package leetcode._33_搜索旋转排序数组;

import java.util.Arrays;

public class SearchArray {
    public int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        return Math.max(reverseSearch(nums, target, 0, nums.length - 1), -1);
    }

    int reverseSearch(int[] nums, int target, int start, int end) {
        int medium = (start + end) / 2;
        if (end == start) {
            return nums[medium] == target ? start : -1;
        } else if (end == start + 1) {
            return nums[start] == target ? start : nums[end] == target ? end : -1;
        }
        //左有序
        if (nums[start] < nums[medium]) {
            return Math.max(Arrays.binarySearch(nums, start, medium + 1, target), reverseSearch(nums, target, medium + 1, end));
        }
        //右有序
        else {

            return Math.max(Arrays.binarySearch(nums, medium + 1, end + 1, target), reverseSearch(nums, target, start, medium));
        }
    }

    public static void main(String[] args) {
        SearchArray searchArray = new SearchArray();
//        searchArray.search(new int[]{1},0);
//        searchArray.search(new int[]{3,0,1,2},0);
//        searchArray.search(new int[]{0},0);
//        searchArray.search(new int[]{1},0);
//        searchArray.search(new int[]{1,2},0);
        searchArray.search(new int[]{1, 3}, 3);
        for (int i = 0; i < 7; i++) {
            searchArray.search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, i);
        }
    }
}
