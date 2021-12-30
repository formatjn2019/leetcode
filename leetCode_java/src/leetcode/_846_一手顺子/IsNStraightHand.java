package leetcode._846_一手顺子;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //卫语句
        if (hand.length%groupSize!=0) {
            return false;
        }
        ArrayDeque<Integer> collect = Arrays.stream(hand).sorted().boxed().collect(Collectors.toCollection(ArrayDeque::new));
        while (collect.size()>0){
            int start=collect.getFirst();
            for (int t=groupSize;t>0;t--){
                if (collect.contains(start)){
                    collect.remove(start++);
                }else {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        IsNStraightHand isNStraightHand = new IsNStraightHand();
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,3,4,4,5,6}, 4));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{3,3,2,2,1,1}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,9}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2}, 3));
    }
}
