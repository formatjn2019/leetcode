package leetcode._87_扰乱字符串;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IsScramble_error {
    public boolean isScramble(String s1, String s2) {
        HashMap<Character, AtomicInteger> charCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charCount.computeIfAbsent(c,k->new AtomicInteger()).incrementAndGet();
        }
        for (char c:s2.toCharArray()){
            int i = charCount.computeIfAbsent(c, k -> new AtomicInteger()).decrementAndGet();
            if (i<0){
                return false;
            }
        }
        for (AtomicInteger value : charCount.values()) {
            if (value.get()!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        IsScramble_error isScramble = new IsScramble_error();
        System.out.println(isScramble.isScramble("abcdefgh", "hgfedcba"));
    }
}
