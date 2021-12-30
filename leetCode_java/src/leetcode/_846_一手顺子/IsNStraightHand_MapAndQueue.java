package leetcode._846_一手顺子;

import java.util.*;
import java.util.stream.Collectors;

public class IsNStraightHand_MapAndQueue {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //卫语句
        if (hand.length%groupSize!=0) {
            return false;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((i,j)->i-j);
        Map<Integer,Integer> numCount=new HashMap<>();
        for (int num : hand) {
            queue.add(num);
            numCount.put(num,numCount.getOrDefault(num,0)+1);
        }
        while (queue.size()>0){
            int start=queue.poll();
            if (numCount.get(start)==0){
                continue;
            }
            for (int t=groupSize;t>0;t--,start++){
                if (numCount.getOrDefault(start,0)>0){
                    numCount.put(start,numCount.get(start)-1);
                }else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        IsNStraightHand_MapAndQueue isNStraightHand = new IsNStraightHand_MapAndQueue();
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,3,4,4,5,6}, 4));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{3,3,2,2,1,1}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,9}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2}, 3));
    }
}
