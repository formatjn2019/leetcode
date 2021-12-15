package leetcode._851_喧嚣与富有;

import leetcode.Tools;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LoudAndRich_array {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        //在不知道别人的富裕情况的情况下，最安静的是自身
        int []result=new int[quiet.length];
        for (int i = 0;i<result.length;i++){
            result[i]=i;
        }
        //它贫穷的节点的值
        ArrayList<Integer>[] richers = Stream.generate(ArrayList::new)
                .limit(result.length)
                .toArray(ArrayList[]::new);
        for (int[] richerThen : richer) {
            richers[richerThen[0]].add(richerThen[1]);
        }
        //更新子节点
        IntStream.range(0,quiet.length)
                .forEach(i->updateNode(i,i,richers,quiet,result));

        return result;
    }
    //更新子节点的值
    private void updateNode(int parent,int sub,List<Integer>[]richers,int []quiet,int[] result){
        for (Integer updateNode : richers[sub]) {
            //它比它的子节点安静
            if (quiet[result[parent]]<quiet[result[updateNode]]){
                result[updateNode]=parent;
                updateNode(parent,updateNode,richers,quiet,result);
            }
        }
    }

    public static void main(String[] args) {
        LoudAndRich_array loudAndRich = new LoudAndRich_array();
        int[] ints = loudAndRich.loudAndRich(Tools.parseArray(" [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]"), new int[]{3, 2, 5, 4, 6, 1, 7, 0});
        ints = loudAndRich.loudAndRich(Tools.parseArray(" [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]"), new int[]{3, 2, 5, 4, 6, 1, 7, 0});
//        ints = loudAndRich.loudAndRich(new int[][]{}, new int[]{ 0});
        System.out.println(Arrays.toString(ints));
    }
}
