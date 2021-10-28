package leetcode._76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, AtomicInteger> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.computeIfAbsent(c, i -> new AtomicInteger()).incrementAndGet();
        }
//        targetMap.entrySet()
//                .forEach(System.out::println);
        int complete = targetMap.size();
        int min, minIndex = 0;
        int fast = 0, slow = 0;
        for (fast = 0; fast < s.length(); fast++) {
            if (targetMap.containsKey(s.charAt(fast))) {
                int num = targetMap.get(s.charAt(fast)).decrementAndGet();
                if (num == 0) {
                    complete--;
                    if (complete == 0) {
                        break;
                    }
                }
            }
        }
        if (complete == 0) {
            min = fast + 1;
            while (fast < s.length()) {
                //慢指针前移判定
                char ch = s.charAt(slow);
                if (!targetMap.containsKey(ch) || targetMap.get(ch).get() < 0) {
                    slow++;
                    targetMap.getOrDefault(ch, new AtomicInteger()).incrementAndGet();
                    if (fast - slow < min) {
                        min = fast - slow + 1;
                        minIndex = slow;
                    }
                } else {
                    //自增符号判定
                    if (++fast != s.length() && targetMap.containsKey(s.charAt(fast))) {
                        targetMap.get(s.charAt(fast)).decrementAndGet();
                    }
                }
            }
            return s.substring(minIndex, minIndex + min);
        }
        return "";
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        Map<String, String> testData = Map.of(
                "ajfiawjiawojf", "afa"
                , "ADOBECODEBANC", "ABC"
                , "a", "aa"
                , "aa", "a"
        );
        testData.entrySet().stream()
                .peek(System.out::println)
                .map(entry -> minWindow.minWindow(entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
