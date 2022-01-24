package leetcode._1345_跳跃游戏IV;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinJumps {

    public int minJumps(int[] arr) {
        Map<Integer,List<Integer>> indexMap=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            indexMap.computeIfAbsent(arr[i],_k->new ArrayList<>()).add(i);
        }
        return BFSSearch(Set.of(0),indexMap, IntStream.range(1,arr.length).boxed().collect(Collectors.toSet()), arr,0);
    }

    private int BFSSearch(Set<Integer> indexs, Map<Integer,List<Integer>> indexMap,Set<Integer>unUsed,int []arr,int depth){
        if (indexs.contains(arr.length-1)){
            return depth;
        }
        Set<Integer> nextLevel=new HashSet<>();
        for (Integer index : indexs) {
            if (index>0 && unUsed.contains(index-1)){
                nextLevel.add(index-1);
                unUsed.remove(index-1);
            }
            if(unUsed.contains(index+1)){
                nextLevel.add(index+1);
                unUsed.remove(index+1);
            }
            indexMap.get(arr[index])
                    .stream()
                    .filter(unUsed::contains)
                    .forEach(nextLevel::add);
            indexMap.put(arr[index],List.of());
            unUsed.removeAll(indexMap.get(arr[index]));
        }
        return BFSSearch(nextLevel,indexMap,unUsed,arr,depth+1);
    }

    public static void main(String[] args) {
        MinJumps minJumps = new MinJumps();
        System.out.println(minJumps.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        System.out.println(minJumps.minJumps(new int[]{7}));
        System.out.println(minJumps.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        System.out.println(minJumps.minJumps(new int[]{6, 1, 9}));
        System.out.println(minJumps.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
    }
}
