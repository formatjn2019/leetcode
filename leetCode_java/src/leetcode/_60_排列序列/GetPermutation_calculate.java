package leetcode._60_排列序列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GetPermutation_calculate {
    public String getPermutation(int n, int k) {
//        List<String> results=new LinkedList<>();
        int[] ints = IntStream.range(1, n + 1)
                .toArray();
        int numsCount[]=new int[n+1];
        numsCount[n-1]=1;
        for (int i=n-2;i>=0;i--){
            numsCount[i]=numsCount[i+1]*(n-i);
        }
        StringBuilder sb = new StringBuilder();
        boolean []judgeArray=new boolean[n];
        //外围，层数
        for (int i=0;i<n;i++){
            int step=numsCount[i+1];
            //内层，数字
            for (int j=0;j<n;j++){
                if (!judgeArray[j]){
                    if (step==0){
                        sb.append(j+1);
                        break;
                    }
                    if (k>step){
                        k-=step;
                        continue;
                    }
                    judgeArray[j]=true;
                    sb.append(j+1);
                    break;
                }
            }
        }
//        System.out.println(sb);

        return sb.toString();
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
        GetPermutation_calculate getPermutation = new GetPermutation_calculate();
//        IntStream.range(1,4)
//                .forEach(i->getPermutation.getPermutation(i,1));
        getPermutation.getPermutation(9,3);
    }
}
