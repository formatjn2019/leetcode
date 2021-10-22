package leetcode._3_无重复字符的最长子串;

import java.util.Arrays;

public class LenthOfSubStr {
    public int lengthOfLongestSubstring(String s) {
        //字符数组，用于记录字符串中最后出现该字符的起始位置
        int []searchArr=new int[127];
        //result为结果,start为搜索中子串的起始位置
        int result = 0,start=0;
        Arrays.fill(searchArr, -1);
        //从第一个字符串开始判定
        for (int i= 0;i<s.length();searchArr[s.charAt(i)] = i,i++){
            //若该字符还未在字符串中出现过或者出现的位置小于起始位置子串的起始位置
            if (searchArr[s.charAt(i)] ==-1 || (searchArr[s.charAt(i)] < start )){
                //更新结果，结果取最大值
                result = Math.max(result, i - start+1);
            }else {
                //当出现了重复字符串，起始位置重置为下一个出现起始位置字符串的位置
                start = searchArr[s.charAt(i)]+1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LenthOfSubStr loss=new LenthOfSubStr();
        System.out.println("0=="+ loss.lengthOfLongestSubstring(""));

        System.out.println("3=="+ loss.lengthOfLongestSubstring("abcabcbb"));

        System.out.println("1=="+ loss.lengthOfLongestSubstring("bbbbb"));

        System.out.println("5=="+ loss.lengthOfLongestSubstring("tmmzuxt"));
    }
}
