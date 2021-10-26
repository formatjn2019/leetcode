package leetcode._40_组合总和_不重复元素;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum_timeLimitExceded {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, List<List<Integer>>> addItem = new TreeMap<>();
        addItem.put(0, List.of(List.of()));
        appendItem(candidates, result, addItem, target, 0);
        return new ArrayList<>(result);
    }

    public void appendItem(int[] candidates, Set<List<Integer>> result, Map<Integer, List<List<Integer>>> current, int target, int index) {
        if (index == candidates.length) {
//            current.entrySet().forEach(System.out::println);
            return;
        }
        //为下层递归生成数据
        Map<Integer, List<List<Integer>>> newItemMap = current.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new ArrayList<>(entry.getValue())));
        for (Integer integer : current.keySet()) {
            if (target > integer) {
                if (target == integer + candidates[index]) {
                    result.addAll(current.get(integer).stream()
                            .map(ArrayList::new)
                            .peek(list -> list.add(candidates[index]))
                            .collect(Collectors.toList()));
                } else {
                    int newKey = integer + candidates[index];
                    List<List<Integer>> lists = newItemMap.computeIfAbsent(newKey, k -> new LinkedList<>());
                    lists.addAll(current.get(integer).stream()
                            .map(ArrayList::new)
                            .peek(list -> list.add(candidates[index]))
                            .collect(Collectors.toList()));
                }
            }
        }
        appendItem(candidates, result, newItemMap, target, index + 1);
    }

    public static void main(String[] args) {
        CombinationSum_timeLimitExceded combinationSum = new CombinationSum_timeLimitExceded();

        List<List<Integer>> lists = combinationSum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        lists.stream()
                .forEach(System.out::println);
        System.out.println(lists.size());
    }
}
