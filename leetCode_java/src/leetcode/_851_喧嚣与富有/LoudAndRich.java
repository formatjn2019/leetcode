package leetcode._851_喧嚣与富有;

import leetcode.Tools;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        //在不知道别人的富裕情况的情况下，最安静的是自身
        Map<Integer, Integer> result = IntStream.range(0, quiet.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> i));

        //记录父节点，即比当前节点富裕的值
        Map<Integer, ArrayList<Integer>> nodeParent = IntStream.range(0, quiet.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> new ArrayList<>()));
        //填充父节点
        Arrays.stream(richer)
                .forEach(arr -> nodeParent.get(arr[1]).add(arr[0]));

//        nodeParent.entrySet().forEach(System.out::println);

        while (nodeParent.size()>0){
            List<Integer> removeLater=new ArrayList<>();
            for (Map.Entry<Integer, ArrayList<Integer>> integerArrayListEntry : nodeParent.entrySet()) {
                //有父节点，判定父节点是否已经被移除
                List<Integer> removeParents=new ArrayList<>();
                for (Integer parentId : integerArrayListEntry.getValue()) {
                    //父节点已经消失，开始进行判断
                    if (!nodeParent.containsKey(parentId)){
                        removeParents.add(parentId);
                        //将最小安静值更新为父节点的
                        if (getQuite(quiet,result,parentId)<getQuite(quiet,result,integerArrayListEntry.getKey())){
                            result.put(integerArrayListEntry.getKey(),result.get(parentId));
                        }
                    }
                }
                integerArrayListEntry.getValue().removeAll(removeParents);
                //没有父节点，稍后移除
                if (integerArrayListEntry.getValue().size()==0){
                    removeLater.add(integerArrayListEntry.getKey());
                }
            }
            removeLater.forEach(nodeParent::remove);
        }
//        System.out.println(result);
        return result.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .mapToInt(Map.Entry::getValue)
                .toArray();
    }

    //获取当前用户和比当前用户更加富裕的用户中，最安静的值
    private int getQuite(int[] quite, Map<Integer, Integer> quiter, int people) {
        int index = people;
        //dfs搜索
        while (index != quiter.get(index)) {
            index = quiter.get(index);
        }
        return quite[index];
    }

    public static void main(String[] args) {
        LoudAndRich loudAndRich = new LoudAndRich();
        int[] ints = loudAndRich.loudAndRich(Tools.parseArray(" [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]"), new int[]{3, 2, 5, 4, 6, 1, 7, 0});
        ints = loudAndRich.loudAndRich(Tools.parseArray(" [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]"), new int[]{3, 2, 5, 4, 6, 1, 7, 0});
        ints = loudAndRich.loudAndRich(new int[][]{}, new int[]{ 0});
        System.out.println(Arrays.toString(ints));
    }
}
