package leetcode._1719_重构一棵树的方案;

import leetcode.Tools;

import java.util.*;
import java.util.stream.Collectors;

public class CheckWays {
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> sideCount = new HashMap<>();
        for (int[] pair : pairs) {
            sideCount.computeIfAbsent(pair[0],_t->new HashSet<>()).add(pair[1]);
            sideCount.computeIfAbsent(pair[1],_t->new HashSet<>()).add(pair[0]);
        }
        System.out.println(sideCount);
        long count = sideCount.entrySet().stream()
                .filter(entry -> entry.getValue().size() == sideCount.size() - 1)
                .count();
        if (count!=1){
            return count>1?2:0;
        }else {
            List<Set<Integer>> collect = sideCount.entrySet().stream()
                    .peek(entry -> entry.getValue().add(entry.getKey()))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
            System.out.println(collect);
            return  collect.size()==new HashSet<>(collect).size()?1:2;
        }
    }

    public static void main(String[] args) {
        CheckWays checkWays = new CheckWays();
        System.out.println(checkWays.checkWays(Tools.parseArray("[[1,2],[2,3]]")));
        System.out.println(checkWays.checkWays(Tools.parseArray("[[1,2],[2,3],[1,3]]")));
        System.out.println(checkWays.checkWays(Tools.parseArray("[[1,2],[2,3],[2,4],[1,5]]")));
        System.out.println(checkWays.checkWays(Tools.parseArray("[[1,5],[1,3],[2,3],[2,4],[3,5],[3,4]]")));
        System.out.println(checkWays.checkWays(Tools.parseArray("[[1,3],[2,3],[2,4],[3,5],[3,4]]")));
        System.out.println(checkWays.checkWays(Tools.parseArray("[[1,3],[2,3],[3,5],[3,4]]")));
    }
}
