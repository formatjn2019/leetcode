package leetcode._1296_划分数组为连续数字的集合;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IsPossibleDivide {
    public boolean isPossibleDivide(int[] nums, int k) {
        //卫语句
        if (nums.length % k != 0) {
            return false;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> i - j);
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            queue.add(num);
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        while (queue.size() > 0) {
            int start = queue.poll();
            if (numCount.get(start) == 0) {
                continue;
            }
            for (int t = k; t > 0; t--, start++) {
                if (numCount.getOrDefault(start, 0) > 0) {
                    numCount.put(start, numCount.get(start) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
