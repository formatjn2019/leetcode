package leetcode._229_求众数;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement_map {

    public List<Integer> majorityElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum)).entrySet().stream()
                .filter(entry -> entry.getValue() > nums.length / 3.0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
