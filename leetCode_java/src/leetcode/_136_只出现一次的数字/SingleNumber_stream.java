package leetcode._136_只出现一次的数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumber_stream {
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
