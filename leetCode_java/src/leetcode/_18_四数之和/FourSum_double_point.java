package leetcode._18_四数之和;

import java.util.*;

public class FourSum_double_point {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        for (int firstIndex = 0; firstIndex < nums.length - 3; firstIndex++) {
            for (int lastIndex = nums.length - 1; lastIndex - 2 > firstIndex; lastIndex--) {
                for (int leftIndex = firstIndex + 1, rightIndex = lastIndex - 1; leftIndex < rightIndex; ) {
                    int sum = nums[firstIndex] + nums[lastIndex] + nums[leftIndex] + nums[rightIndex];
                    if (sum == target) {
                        result.add(List.of(nums[firstIndex], nums[leftIndex], nums[rightIndex], nums[lastIndex]));
                        while (leftIndex < lastIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                            leftIndex++;
                        }
                        while (rightIndex > firstIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                            rightIndex--;
                        }
                        rightIndex--;
                        leftIndex++;
                    } else if (sum - target > 0) {
                        rightIndex--;
                    } else {
                        leftIndex++;
                    }
                }
                while (lastIndex > 2 && nums[lastIndex] == nums[lastIndex - 1]) {
                    lastIndex--;
                }
            }
            while (firstIndex < nums.length - 3 && nums[firstIndex] == nums[firstIndex + 1]) {
                firstIndex++;
            }
        }
        return result;
    }

    public boolean test(int[] nums, int target, List<List<Integer>> expect) {
        List<List<Integer>> result = fourSum(nums, target);
        Set<Set<Integer>> compare = new HashSet<>();
        for (List<Integer> item : result) {
            compare.add(new HashSet<>(item));
        }
        boolean passed = true;
        for (List<Integer> item : expect) {
            boolean add = compare.add(new HashSet<>(item));
            if (add) {
                passed = false;
                break;
            }
        }
        if (!passed) {
            System.out.println("失败");
            System.out.println(Arrays.toString(nums));
            System.out.println("结果:" + result + "\t期望\t：" + expect);
        } else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        FourSum_double_point threeSum = new FourSum_double_point();
        List<List<Integer>> temp = new LinkedList<>();
        temp.add(List.of(-2, -1, 1, 2));
        temp.add(List.of(-2, 0, 0, 2));
        temp.add(List.of(-1, 0, 0, 1));
        threeSum.test(new int[]{1, 0, -1, 0, -2, 2}, 0, temp);
        threeSum.test(new int[]{}, 0, new LinkedList<>());
        temp = new LinkedList<>();
        temp.add(List.of(2, 2, 2, 2));
        threeSum.test(new int[]{2, 2, 2, 2, 2}, 8, temp);
        temp = new LinkedList<>();
        temp.add(List.of(-5, 2, 2, 4));
        temp.add(List.of(-1, 0, 2, 2));
        threeSum.test(new int[]{-1, 2, 2, -5, 0, -1, 4}, 3, temp);
//        temp=new LinkedList<>();
//        temp.add(List.of(1, 1, -2));
//        threeSum.test(new int[]{1,1,-2},0,temp);
//        temp=new LinkedList<>();
//        temp.add(List.of(-1,0, 1));
//        threeSum.test(new int[]{-1,0,1,0},0,temp);
//        threeSum.test(new int[]{},new LinkedList<>());
//        threeSum.test(new int[]{},new LinkedList<>());
    }
}
