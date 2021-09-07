package leetcode._60_排列序列;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class GetPermutation_timeout {
    public String getPermutation(int n, int k) {
        List<String> results=new LinkedList<>();
        int[] ints = IntStream.range(1, n + 1)
                .toArray();
        generateItems(ints,new boolean[ints.length],0,results,"");
//        results.forEach(System.out::println);
//        System.out.println(results);
        return results.get(k-1);
    }
    public void generateItems(int []items,boolean []judgeArray, int depth, List<String> results,String current){
        if (depth==items.length){
            results.add(current);
            return;
        }
        for (int i=0;i<items.length;i++){
            if (!judgeArray[i]){
                judgeArray[i]=true;
                generateItems(items,judgeArray,depth+1,results,current+(i+1));
                judgeArray[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        GetPermutation_timeout getPermutation = new GetPermutation_timeout();
        IntStream.range(1,4)
                .forEach(i->getPermutation.getPermutation(i,1));
    }
}
