package leetcode._1044_最长重复子串;

import leetcode.Tools;

import java.util.HashSet;
import java.util.Set;

public class LongestDupSubstring {
    static int P=1313131;
    //顶部作用域
    long []pri,hash;
    public String longestDupSubstring(String s) {
        char[] chars = s.toCharArray();
        //预先计算
        //P的n次方
        pri=new long[s.length()+1];
        //哈希
        hash=new long[s.length()+1];
        pri[0]=1;
        for (int i=0;i<chars.length;i++){
            pri[i+1]=pri[i]*P;
            hash[i+1]=hash[i]*P+chars[i]+chars[i];
        }
        String result="";
        int l=0,r=chars.length;
        while (l<r){
            int mid = l +r +1>>1;
            String t = hasResult(s,mid);
            if (t.length() !=0){
                l=mid;
            }else {
                r=mid-1;
            }
            result=t.length()>result.length()?t:result;
        }
        return result;
    }

    String hasResult(String s,int len){
        int n =s.length();
        Set<Long> set = new HashSet<>();
        for(int i=1;i+len-1<=n;i++){
            //尾部
            int j = i + len -1;
            long cur = hash[j]-hash[i-1]*pri[ len];
            if (set.contains(cur)){
                return s.substring(i-1,j);
            }
            set.add(cur);
        }
        return "";
    }


    public static void main(String[] args) {
        LongestDupSubstring longestDupSubstring = new LongestDupSubstring();
        longestDupSubstring.longestDupSubstring("abcabcdeabcd");
        longestDupSubstring.longestDupSubstring("banana");
        longestDupSubstring.longestDupSubstring("abcd");
        longestDupSubstring.longestDupSubstring("ababacaba");
    }
}
