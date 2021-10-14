package leetcode._125_验证回文字符串;

import java.util.Arrays;
import java.util.Locale;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().replaceAll("[^a-z0-9]","").toCharArray();
        for (int lp=0,rp=chars.length-1;lp<rp;lp++,rp--){
            if (chars[lp]!=chars[rp]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("ab_a"));
    }
}
