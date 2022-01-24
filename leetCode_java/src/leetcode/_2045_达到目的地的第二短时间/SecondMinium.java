package leetcode._2045_达到目的地的第二短时间;

import leetcode.Tools;

import java.util.*;

public class SecondMinium {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> nodesMap = new HashMap<>();
        for (int[] edge : edges) {
            nodesMap.computeIfAbsent(edge[0], _t -> new ArrayList<>()).add(edge[1]);
            nodesMap.computeIfAbsent(edge[1], _t -> new ArrayList<>()).add(edge[0]);
        }
        return bfsSearch(change, time, n, 0, new int[1], nodesMap, Set.of(1), new HashMap<>());
    }

    private int bfsSearch(int change, int lineTime, int target, int time, int[] count, Map<Integer, List<Integer>> nodesMap, Set<Integer> node, Map<Integer, Integer> nodeCount) {
        if (node.contains(target)) {
            if (count[0] < 0) {
                return time;
            }
            count[0] -= 1;
        }
        HashSet<Integer> nextLevel = new HashSet<>();
        //计算通过该节点所耗费的时间
        if (time % (2 * change) >= change) {
            time = (time / (2 * change) + 1) * 2 * change;
        }
        for (Integer integer : node) {
            nodesMap.get(integer).stream()
                    .filter(key -> nodeCount.getOrDefault(key,0) < 2)
                    .forEach(nextLevel::add);
        }
        nextLevel.forEach(item->nodeCount.put(item,nodeCount.getOrDefault(item,0)+1));
        return bfsSearch(change, lineTime, target, time + lineTime, count, nodesMap, nextLevel, nodeCount);
    }

    public static void main(String[] args) {
        SecondMinium secondMinium = new SecondMinium();
//        System.out.println(secondMinium.secondMinimum(5, Tools.parseArray("[[1,2],[1,3],[1,4],[3,4],[4,5]]"), 3, 5));
        System.out.println(secondMinium.secondMinimum(2, Tools.parseArray("[[1,2]]"), 1, 2));
    }
}
