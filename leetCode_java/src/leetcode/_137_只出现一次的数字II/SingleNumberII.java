package leetcode._137_只出现一次的数字II;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numCount = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(k -> k, k -> 1, Integer::sum));
        return numCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }
}
