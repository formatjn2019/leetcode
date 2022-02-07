package leetcode._1405_最长的快乐字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestDiverseString_greedy {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> charCount = new HashMap<>();
        if (a>0){
            charCount.put('a',a);
        }
        if (b>0){
            charCount.put('b',b);
        }
        if (c>0){
            charCount.put('c',c);
        }
        StringBuilder pre = new StringBuilder();
        append(charCount,pre,0);
        return pre.toString();
    }

    private void append(Map<Character, Integer> charCount, StringBuilder pre,int preMax) {
        if (charCount.size()==0){
            return;
        }
        System.out.println(charCount);
        char max = ' ', min = ' ';
        Character[] chars = Arrays.stream(charCount.keySet().toArray()).sorted((k1,k2)->charCount.get(k2)-charCount.get(k1)).toArray(Character[]::new);
        max=chars[0];
        min=chars[chars.length-1];
        //最多消去两个最大字符
        if ((pre.length() == 0 || pre.charAt(pre.length() - 1) != max) ) {
            if (charCount.get(max) == 1 || charCount.get(max) == 2) {
                pre.append(String.valueOf(max).repeat(Math.max(0, charCount.get(max))));
                charCount.remove(max);
            } else {
                pre.append(String.valueOf(max).repeat(2));
                charCount.put(max, charCount.get(max) - 2);
            }
        }
        //消去一个最小字符
        else if (pre.charAt(pre.length() - 1) != min && charCount.containsKey(min)) {
            pre.append(min);
            if (charCount.get(min) == 1) {
                charCount.remove(min);
            }else {
                charCount.put(min,charCount.get(min)-1);
            }
        }
        if (pre.length()>preMax){
            append(charCount,pre,pre.length());
        }
    }


    public static void main(String[] args) {
        LongestDiverseString_greedy longestDiverseString = new LongestDiverseString_greedy();
        String s = longestDiverseString.longestDiverseString(2, 4, 1);
        System.out.println(s.length());
        System.out.println(s);
    }
}
