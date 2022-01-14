package leetcode._373_查找和最小的K对数字;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue=new PriorityQueue<>((_l1,_l2)->_l2.get(0)+_l2.get(1)-_l1.get(0)-_l1.get(1));
        for (int i=0;i<Math.min(k,nums1.length);i++){
            for (int j=0;j<Math.min(nums2.length,k/(i+1)+1);j++){
                if (priorityQueue.size()==k){
                    List<Integer> peek = priorityQueue.peek();
                    //如果新的还没老的大，则终止循环
                    if (nums1[i]+nums2[j]>peek.get(0)+peek.get(1)){
                        break;
                    }
                    priorityQueue.poll();
                }
                //队列满了，则取队尾
                List<Integer> newItem = List.of(nums1[i], nums2[j]);
                priorityQueue.add(newItem);
            }
        }
        return priorityQueue.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
//        kSmallestPairs.kSmallestPairs(IntStream.range(1,101).toArray(),IntStream.range(1,101).toArray(),100);
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
}
