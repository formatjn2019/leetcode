package leetcode._913_猫和老鼠;

import leetcode.Tools;

import java.util.*;
import java.util.stream.Collectors;

public class CatMouseGame_outOfMemory {
    public int catMouseGame(int[][] graph) {
        int tomIndex = 2, jerryIndex = 1, nums = 1;
        Map<Integer, List<List<Integer>>> results = new HashMap<>();
        for (int i = 1; i < graph.length; i++) {
            dfsSearch(i, i, graph, results, new ArrayList<>());
        }
        System.out.println(results);
        //步数计算
        for (int[] tomPre = new int[]{2, -1}, jerryPre = new int[]{1, -1}; nums < 10000; nums++) {
            System.out.println(jerryIndex + "\t" + tomIndex);
            jerryIndex = jerryMove(jerryIndex, results, graph, tomIndex, jerryPre[nums % 2]);
            if (jerryIndex == jerryPre[nums % 2]) {
                //记录走过的路
                jerryPre[(nums + 1) % 2] = jerryIndex;
                return 0;
            }
            //逃脱
            else if (jerryIndex == 0) {
                return 1;
            }
            tomIndex = tomMove(tomIndex, results, graph, jerryIndex, tomPre[nums % 2]);
            //抓到老鼠
            if (tomIndex == jerryIndex) {
                return 2;
            } else if (tomIndex == tomPre[nums % 2]) {
                //记录走过的路
                tomPre[(nums + 1) % 2] = tomIndex;
                return 0;
            }
        }
        return 0;
    }

    private int tomMove(int index, Map<Integer, List<List<Integer>>> results, int[][] grapth, int jerryIndex, int pre) {
        List<Integer> nextStep = Arrays.stream(grapth[index]).boxed()
                .filter(_i -> _i != 0)
                .collect(Collectors.toList());
        //能抓到老鼠就直接抓
        if (nextStep.contains(jerryIndex)) {
            return jerryIndex;
        }
        //堵住老鼠能走到洞的格子
        List<Integer> integers = results.get(jerryIndex).get(0);
        ArrayList<Integer> integers1 = new ArrayList<>(integers);
        integers1.remove(0);
        integers1.remove(integers1.size()-1);
        int result = -1, curLenth = Integer.MAX_VALUE;
        for (Integer step : nextStep) {
            //距离老鼠洞的距离
            int distance = lfsSearch(0,List.of(step),grapth,integers1);
            if (distance < curLenth) {
                curLenth = distance;
                result = step;
            }
        }
        return result;
    }

    private int lfsSearch(int depth, List<Integer> startIndexs, int[][] grapth, List<Integer> targets) {
        List<Integer> next = new ArrayList<>();
        for (Integer startIndex : startIndexs) {
            if (targets.contains(startIndex)) {
                return depth;
            }
            Arrays.stream(grapth[startIndex]).forEach(next::add);
        }
        return lfsSearch(depth+1,next,grapth,targets);
    }

    private int jerryMove(int index, Map<Integer, List<List<Integer>>> results, int[][] grapth, int tomInex, int pre) {
        //如果有洞，直接钻洞
        ArrayList<Integer> nextSteps = Arrays.stream(grapth[index]).boxed().collect(Collectors.toCollection(ArrayList::new));
        if (nextSteps.contains(0)) {
            return 0;
        }
        //躲避猫及猫能走到的格子
        ArrayList<Integer> disables = new ArrayList<>();
        disables.add(tomInex);
        Arrays.stream(grapth[tomInex]).forEach(disables::add);
        List<Integer> canStep = nextSteps.stream()
                .filter(step -> !disables.contains(step))
                .collect(Collectors.toList());
        //如果躲不掉，就去送死
        if (canStep.size() == 0) {
            return nextSteps.get(0);
        }
        //尽量不走上一格
        //但是不得不走
        if (canStep.size() == 1 && canStep.get(0) == pre) {
            return pre;
        }
        //走最优解
        int[] ints = results.get(index).stream()
                .mapToInt(ls -> ls.get(1))
                .filter(i -> i != pre)
                .filter(canStep::contains)
                .limit(1)
                .toArray();
        return ints[0];
    }

    //开始索引， 当前索引， 图 ， 结果， 位置记录
    private void dfsSearch(int startIndex, int index, int[][] grapth, Map<Integer, List<List<Integer>>> results, List<Integer> pre) {
        pre.add(index);
        if (index == 0) {
            results.computeIfAbsent(startIndex, ArrayList::new).add(pre);
        }
        for (int next : grapth[index]) {
            if (!pre.contains(next)) {
                dfsSearch(startIndex, next, grapth, results, new ArrayList<>(pre));
            }
        }
        if (index == startIndex) {
            results.get(startIndex).sort((l1, l2) -> l1.size() - l2.size());
        }
    }

    public static void main(String[] args) {
        CatMouseGame_outOfMemory catMouseGame = new CatMouseGame_outOfMemory();
        int[][] grap = Tools.parseArray("[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]");
        System.out.println(catMouseGame.catMouseGame(grap));

        Tools.parseArray("[[2,3],[3,4],[0,4],[0,1],[1,2]]");
        System.out.println(catMouseGame.catMouseGame(grap));
        grap=Tools.parseArray("[[1,3],[0],[3],[0,2]]");
        System.out.println(catMouseGame.catMouseGame(grap));
        grap = Tools.parseArray("[[3,4],[3,5],[3,6],[0,1,2],[0,5,6],[1,4],[2,4]]");
        System.out.println(catMouseGame.catMouseGame(grap));
    }
}
