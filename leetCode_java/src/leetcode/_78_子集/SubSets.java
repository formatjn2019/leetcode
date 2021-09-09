package leetcode._78_子集;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new LinkedList<>();
        for (int i=0;i<Math.pow(2,nums.length);i++){
            LinkedList<Integer> item = new LinkedList<>();
            for (int t=i,index=0;t > 0;index++,t/=2) {
                if (t%2==1){
                    item.add(nums[index]);
                }
            }
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] ints = new Random().ints(1,100)
                .distinct()
                .limit(3)
                .toArray();
        subSets.subsets(ints)
                .forEach(System.out::println);
//                .count();
//        System.out.println(count);

    }
}
