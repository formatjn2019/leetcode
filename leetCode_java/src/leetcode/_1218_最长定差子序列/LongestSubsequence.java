package leetcode._1218_最长定差子序列;

import leetcode.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.OptionalInt;

public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int []tempArr=new int[40001];
        int result = 1;
        //数值，出现的次数
        for (int num : arr) {
            tempArr[num+20000]=Math.max(tempArr[num+20000],tempArr[num-difference+20000]+1);
            result = Math.max(result, tempArr[num+20000]);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        int[] ints = new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println(longestSubsequence.longestSubsequence(ints, -2));
    }
}
