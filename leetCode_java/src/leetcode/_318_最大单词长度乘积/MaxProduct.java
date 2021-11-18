package leetcode._318_最大单词长度乘积;

import java.util.*;
import java.util.stream.Stream;

public class MaxProduct {
    public int maxProduct(String[] words) {
        //长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        Map<String, Integer> eigenMap = new HashMap<>();
        //计算特征值
        for (String word : words) {
            int eigen = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                    eigen = eigen | 1 << (chars[i]-'a');
            }
            eigenMap.put(word, eigen);
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length && words[i].length() * words[j].length() > result; j++) {
                if ((eigenMap.get(words[i]) & eigenMap.get(words[j])) == 0) {
                    result=words[i].length()*words[j].length();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(3&12);
        System.out.println(maxProduct.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(maxProduct.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
