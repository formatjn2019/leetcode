package leetcode._1748_唯一元素的和;

import java.util.HashSet;
import java.util.Set;

public class SumOfUnique {
    public int sumOfUnique(int[] nums) {
        int result = 0, notUniteSum = 0;
        Set<Integer> used = new HashSet<>();
        Set<Integer> notUnite = new HashSet<>();
        for (int num : nums) {
            //所有元素
            if (used.add(num)) {
                result += num;
            }
            //非唯一元素
            else if (notUnite.add(num)) {
                notUniteSum+=num;
            }

        }
        return result-notUniteSum;
    }
}
