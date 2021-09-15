package leetcode._90_子集II;

import java.awt.event.ItemEvent;
import java.util.*;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new LinkedList<>();
        Arrays.sort(nums);
        appendItem(0,nums,new boolean[nums.length],new ArrayDeque<>(),result);
        return result;
    }
    public void appendItem(int level, int []nums, boolean []appended, ArrayDeque<Integer> item, List<List<Integer>> result){
        if (level==nums.length){
            result.add(new ArrayList<>(item));
            return;
        }
        if (level==0 || nums[level-1]!=nums[level] || appended[level - 1]){
            item.push(nums[level]);
            appended[level]=true;
            appendItem(level+1,nums,appended,item,result);
            appended[level]=false;
            item.pop();
        }
        appendItem(level+1,nums,appended,item,result);

    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(new int[]{1, 2, 2, 3, 5});
        System.out.println(lists);
        lists.stream()
                        .forEach(System.out::println);
        System.out.println(lists.size());
        System.out.println(lists.stream()
                .distinct()
                .count());
    }
}
