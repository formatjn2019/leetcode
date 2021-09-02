package leetcode._47_全排列II;

import java.util.*;

public class PerMuteII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new LinkedList<>();
        appentItem(nums,new boolean[nums.length],0,new ArrayDeque<>(),result);
//        result.forEach(System.out::println);
//        System.out.println(result.size());
        return result;
    }

    public void appentItem(int []nums, boolean []judgeArray,int depth, ArrayDeque<Integer> tempArray,List<List<Integer>> result){
        if (depth==nums.length){
            result.add(new ArrayList<>(tempArray));
            return;
        }
        for (int i=0;i<judgeArray.length;i++){
//            if (!judgeArray[i]&&(i==0 || nums[i-1]!=nums[i] || !judgeArray[i-1])){
            if (!judgeArray[i]&&(i==0 || nums[i-1]!=nums[i] || !judgeArray[i-1])){
                judgeArray[i]=true;
                tempArray.push(nums[i]);
                appentItem(nums,judgeArray,depth+1,tempArray,result);
                tempArray.pop();
                judgeArray[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        PerMuteII perMuteII = new PerMuteII();
        perMuteII.permuteUnique(new int[]{1,1,2,3});
    }
}
