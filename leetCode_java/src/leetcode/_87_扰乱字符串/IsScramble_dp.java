package leetcode._87_扰乱字符串;

import leetcode._46_全排列.Permute;

import java.util.ArrayDeque;
import java.util.List;

public class IsScramble_dp {
    public boolean isScramble(String s1, String s2) {
        //卫语句
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        if (!charCount(chars1,0,chars1.length,chars2,0,chars2.length)){
            return false;
        }
        if (s1.length()<4 || s1.equals(s2)){
            return true;
        }

        boolean result=false;
        for (int split=1;!result &&split<s1.length();split++){
            result=(isScramble(s1.substring(0,split),s2.substring(0,split)) && isScramble(s1.substring(split),s2.substring(split)))
                    ||(isScramble(s1.substring(0,split),s2.substring(s2.length()-split)) && isScramble(s1.substring(split),s2.substring(0,s2.length()-split)));
        }
        return result;
    }


    public boolean charCount(char[] s1,int start1,int end1, char[] s2,int start2,int end2) {
        int[] judgeArray = new int[26];
        for(int i=start1;i<end1;i++){
            judgeArray[s1[i]-'a']++;
        }
        for(int i=start2;i<end2;i++){
            judgeArray[s2[i]-'a']--;
        }
        for (int i : judgeArray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsScramble_dp isScramble = new IsScramble_dp();
//        System.out.println(isScramble.isScramble("abcdefgh", "hgfedcba"));
//        System.out.println(isScramble.isScramble("abcde","caebd"));
//        System.out.println(isScramble.isScramble("abb","bab"));
//        System.out.println(isScramble.isScramble("great","rgeat"));
        Permute permute = new Permute();
        String s1="abc";
        List<List<Integer>> permute1 = permute.permute(new int[]{0,1,2});
        permute1.stream()
                .map(list->{
                    String result="";
                    for (Integer integer : list) {
                        result+=s1.charAt(integer);
//                        System.out.println("_______________________");
                    }
                    return result;
                })
//                .forEach(System.out::println)
                .filter(s -> !isScramble.isScramble(s1,s))
                .forEach(System.out::println);
    }
}
