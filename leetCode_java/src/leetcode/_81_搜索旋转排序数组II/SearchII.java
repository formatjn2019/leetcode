package leetcode._81_搜索旋转排序数组II;

import javax.xml.stream.XMLInputFactory;
import java.util.Arrays;
import java.util.Random;

public class SearchII {
    public boolean search(int[] nums, int target) {
        //标准二分搜索
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public boolean binarySearch(int[] nums, int target, int start, int end) {
        //删掉头尾相同的
        while (end > start && nums[end] == nums[start]) {
            end--;
        }
        if (start == end) {
            return nums[start] == target;
        }
        //正常情况，二分
        if (nums[start] < nums[end]) {
            int l = start, r = end;
            while (l <= r) {
                int medium = (l + r) / 2;
                if (nums[medium] == target) {
                    return true;
                } else if (nums[medium] < target) {
                    l = medium + 1;
                } else {
                    r = medium - 1;
                }
            }
            return false;
        }
        //不正常情况
        return binarySearch(nums, target, start, (start + end) / 2) || binarySearch(nums, target, (start + end) / 2 + 1, end);
    }

    public static void main(String[] args) {
        SearchII searchII = new SearchII();
        int[] ints = {2, 2, 2, 3, 2, 2, 2};
        System.out.println(searchII.search(ints, 3));
    }
}
