package leetcode._219_存在重复元素II;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> numIndexMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (i-numIndexMap.getOrDefault(nums[i],-100000)<=k){
                return true;
            }
            numIndexMap.put(nums[i],i);
        }
        return false;
    }
}
