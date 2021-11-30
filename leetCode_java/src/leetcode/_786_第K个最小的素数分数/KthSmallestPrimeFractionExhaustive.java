package leetcode._786_第K个最小的素数分数;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestPrimeFractionExhaustive {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        ArrayList<List<Integer>> results=new ArrayList<>();
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                results.add(List.of(arr[i],arr[j]));
            }
        }
        // api调用，穷举法
        results.sort((l1,l2)->l1.get(0)*l2.get(1)-l1.get(1)*l2.get(0));
        return results.get(k).stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        KthSmallestPrimeFractionExhaustive kthSmallestPrimeFraction = new KthSmallestPrimeFractionExhaustive();
        kthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1,2,3,5,7,9},3);
    }
}
