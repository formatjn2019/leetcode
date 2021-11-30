package leetcode._786_第K个最小的素数分数;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Stream;

public class KthSmallestPrimeFraction_BinarySearch {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //优先队列法
        ArrayDeque<Integer>[] lines = Stream.generate(ArrayDeque::new).limit(arr.length-1).toArray(ArrayDeque[]::new);
        //分子
        for (int i=0;i<arr.length-1;i++){
            //分母
            for (int j=arr.length-1;j>i;j--){
                lines[j-1].add(arr[i]);
            }
        }
        int []result=null;
        for (;k>0;k--){
            //min
            result=new int[]{100000,lines.length-1};
            for (int i=0;i<lines.length;i++){
                if (!lines[i].isEmpty() && result[0]*arr[i+1] > arr[result[1]+1] * lines[i].getFirst()){
                    result[0]=lines[i].getFirst();
                    result[1]=i;
                }
            }
            //分母替换
            lines[result[1]].pop();
            result[1]=arr[result[1]+1];
            System.out.println(Arrays.toString(result));

        }
        return result;
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction_BinarySearch kthSmallestPrimeFraction = new KthSmallestPrimeFraction_BinarySearch();
        kthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1,13,17,59},6);
    }
}
