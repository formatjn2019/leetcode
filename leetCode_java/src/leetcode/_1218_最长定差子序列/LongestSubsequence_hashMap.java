package leetcode._1218_最长定差子序列;

import java.util.HashMap;

public class LongestSubsequence_hashMap {
    public int longestSubsequence(int[] arr, int difference) {
        int result = 1;
        //数值，出现的次数
        HashMap<Integer, Integer> memory = new HashMap<>();
        for (int num : arr) {
            //若存在与当前位置相差difference的数字，则更新最大值，并消除原先数值
            int max = Math.max(memory.getOrDefault(num, 0), memory.getOrDefault(num - difference, 0) + 1);
            result = Math.max(result, max);
            memory.put(num, max);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubsequence_hashMap longestSubsequence = new LongestSubsequence_hashMap();
        int[] ints = new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println(longestSubsequence.longestSubsequence(ints, -2));
    }
}
