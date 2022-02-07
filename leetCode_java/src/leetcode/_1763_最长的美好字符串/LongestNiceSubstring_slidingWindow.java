package leetcode._1763_最长的美好字符串;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring_slidingWindow {
    public String longestNiceSubstring(String s) {
        int []cl=new int[26],cu=new int[26];
        String result="";
        char[] chars = s.toCharArray();
        for (int len=2;len<=s.length();len++){
            //初始化
            Arrays.fill(cl,0);
            Arrays.fill(cu,0);
            for (int i=0;i<len;i++){
                char c=chars[i];
                if (c>='a'){
                    cl[c-'a']++;
                }else {
                    cu[c-'A']++;
                }
            }
            Set<Character> uncomplete=new HashSet<>(),complete=new HashSet<>();
            for (int i=0;i<26;i++){
                if ((cl[i]==0 && cu[i]==0)|| (cl[i]>0 && cu[i]>0)){
                    complete.add((char) (cl[i]+'a'));
                }else {
                    uncomplete.add((char)(cl[i]+'a'));
                }
            }
            int newIndex=len;
            for (;newIndex<s.length() && complete.size()!=26;newIndex++){
                if (chars[newIndex-len]>='a'){

                }

            }
            if (complete.size()==26){
                result=s.substring(newIndex-len,newIndex);
            }
        }

        return result;
    }



    public static void main(String[] args) {
        LongestNiceSubstring_slidingWindow longestNiceSubstring = new LongestNiceSubstring_slidingWindow();
        System.out.println(longestNiceSubstring.longestNiceSubstring("YazaAay"));
    }
}
