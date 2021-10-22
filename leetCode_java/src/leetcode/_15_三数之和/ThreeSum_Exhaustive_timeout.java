package leetcode._15_三数之和;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum_Exhaustive_timeout {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        //        result.forEach((item)-> System.out.println(item+""+item.hashCode()));
        return result.stream().map(ArrayList::new).collect(Collectors.toList());
    }

    public boolean test(int[] strs, List<List<Integer>> expect) {
        List<List<Integer>> result = threeSum(strs);
        Set<Set<Integer>> compare = new HashSet<>();
        for (List<Integer> item : expect) {
            compare.add(new HashSet<>(item));
        }
        boolean passed = true;
        for (List<Integer> item : result) {
            boolean add = compare.add(new HashSet<>(item));
            if (add) {
                passed = false;
                break;
            }
        }
        if (!passed) {
            System.out.println("失败");
            System.out.println(Arrays.toString(strs));
            System.out.println("结果:" + result + "\t期望\t：" + expect);
        } else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        ThreeSum_Exhaustive_timeout threeSum = new ThreeSum_Exhaustive_timeout();
        List<List<Integer>> temp = new LinkedList<>();
        temp.add(List.of(-1, -1, 2));
        temp.add(List.of(-1, 0, 1));
        threeSum.test(new int[]{-1, 0, 1, 2, -1, -4}, temp);
        threeSum.test(new int[]{}, new LinkedList<>());
        temp.clear();
        temp.add(List.of(-1, -1, 2));
        temp.add(List.of(-1, 0, 1));
        threeSum.test(new int[]{-1, 0, 1, 2, -1, -4}, temp);
//        threeSum.test(new int[]{},new LinkedList<>());
    }
}
