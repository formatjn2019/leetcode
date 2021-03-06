package leetcode._39_组合总和;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> addItem = new TreeMap<>();
        //预先生成的数据
        addItem.put(0, List.of(List.of()));
        appendItem(candidates, result, addItem, target, 0);
//        System.out.println(result);
        return result;
    }

    public void appendItem(int[] candidates, List<List<Integer>> result, Map<Integer, List<List<Integer>>> current, int target, int index) {
        if (index == candidates.length) {
            current.entrySet().forEach(System.out::println);
            return;
        }
        for (Integer integer : current.keySet()) {
            //成功，添加进结果集
            if (target > integer && (target - integer) % candidates[index] == 0) {
                for (List<Integer> integers : current.get(integer)) {
                    ArrayList<Integer> resultItem = new ArrayList<>(integers);
                    Stream.generate(() -> candidates[index])
                            .limit((target - integer) / candidates[index])
                            .forEach(resultItem::add);
                    result.add(resultItem);
                }
            }
        }
        //为下层递归生成数据
        Map<Integer, List<List<Integer>>> newItemMap = current.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new ArrayList<>(entry.getValue())));
        for (Integer integer : current.keySet()) {
            if (target > integer) {
                //根据当前数据生成所有可能的值的组合
                int loop = (target - integer) % candidates[index] == 0 ? (target - integer) / candidates[index] - 1 : (target - integer) / candidates[index];
                for (; loop > 0; loop--) {
                    int newKey = integer + loop * candidates[index];
                    List<List<Integer>> orDefault = newItemMap.computeIfAbsent(newKey, k -> new LinkedList<>());
                    List<Integer> collect = Stream.generate(() -> candidates[index])
                            .limit(loop)
                            .collect(Collectors.toList());
                    for (List<Integer> integers : current.get(integer)) {
                        ArrayList<Integer> newItem = new ArrayList<>(collect);
                        newItem.addAll(integers);
                        orDefault.add(newItem);
                    }
//                    System.out.println(integer);
                }
            }
        }
//        newItemMap.keySet().forEach(System.out::println);
        appendItem(candidates, result, newItemMap, target, index + 1);
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();

        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9);
        lists.stream()
                .forEach(System.out::println);
        System.out.println(lists.size());
//        Random random = new Random();
//        Map<Integer, Integer> collect = Stream.generate(random::nextInt)
//                .limit(100)
//                .collect(Collectors.toMap(i -> i, i -> i));


    }
}
