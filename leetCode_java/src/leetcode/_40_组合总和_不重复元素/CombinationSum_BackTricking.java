package leetcode._40_组合总和_不重复元素;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CombinationSum_BackTricking {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        appendItem(candidates, new boolean[candidates.length], result, target, 0);
        return new ArrayList<>(result);
    }

    public void appendItem(int[] candidates, boolean[] usedItem, List<List<Integer>> result, int target, int index) {
        if (target == 0) {
            result.add(IntStream.range(0, candidates.length)
                    .filter(i -> usedItem[i])
                    .mapToObj(i -> candidates[i])
                    .collect(Collectors.toList()));
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }
        appendItem(candidates, usedItem, result, target, index + 1);
        if (index == 0 || candidates[index - 1] != candidates[index] || usedItem[index - 1]) {
            usedItem[index] = true;
            appendItem(candidates, usedItem, result, target - candidates[index], index + 1);
            usedItem[index] = false;
        }
    }

    public static void main(String[] args) {
        CombinationSum_BackTricking combinationSum = new CombinationSum_BackTricking();

        List<List<Integer>> lists = combinationSum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        lists.stream()
                .forEach(System.out::println);
        System.out.println(lists.size());
    }
}
