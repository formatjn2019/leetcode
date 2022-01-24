package leetcode._1345_跳跃游戏IV;

import java.util.*;

public class MinJumps_outofMemory {

    public int minJumps(int[] arr) {
        Map<Integer,List<Integer>> indexMap=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            indexMap.computeIfAbsent(arr[i],_k->new ArrayList<>()).add(i);
        }
        return BFSSearch(List.of(0),indexMap,new HashSet<>(Set.of(0)),arr,0);
    }

    private int BFSSearch(List<Integer> indexs, Map<Integer,List<Integer>> indexMap,Set<Integer>used,int []arr,int depth){
        if (indexs.contains(arr.length-1)){
            return depth;
        }
        ArrayList<Integer> nextLevel=new ArrayList<>();
        for (Integer index : indexs) {
            if (index>0){
                nextLevel.add(index-1);
            }
            nextLevel.add(index+1);
            nextLevel.addAll(indexMap.getOrDefault(arr[index],List.of()));
        }
        nextLevel.removeAll(used);
        used.addAll(nextLevel);
        return BFSSearch(nextLevel,indexMap,used,arr,depth+1);
    }

    public static void main(String[] args) {
        MinJumps_outofMemory minJumps = new MinJumps_outofMemory();
        minJumps.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404});
        minJumps.minJumps(new int[]{7});
        minJumps.minJumps(new int[]{7,6,9,6,9,6,9,7});
        minJumps.minJumps(new int[]{6,1,9});
        minJumps.minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13});
    }
}
