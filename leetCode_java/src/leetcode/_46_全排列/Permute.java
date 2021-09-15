package leetcode._46_全排列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new LinkedList<>();
        appentItem(nums,new boolean[nums.length],0,new ArrayDeque<>(),result);
        result.forEach(System.out::println);
        return result;
    }

    public void appentItem(int []nums, boolean []judgeArray,int depth, ArrayDeque<Integer> tempArray,List<List<Integer>> result){
        if (depth==nums.length){
            result.add(new ArrayList<>(tempArray));
            return;
        }
        for (int i=0;i<judgeArray.length;i++){
            if (!judgeArray[i]){
                judgeArray[i]=true;
                tempArray.push(nums[i]);
                appentItem(nums,judgeArray,depth+1,tempArray,result);
                tempArray.pop();
                judgeArray[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        new Permute().permute(new int[]{1,2,3});
    }
}
