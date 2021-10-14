package leetcode._132_分隔回文串II;

import leetcode.Tools;

import java.util.HashSet;
import java.util.Set;

public class MinCut {
    public int minCut(String s) {
        System.out.println(s.length());
//        System.out.println(s);
        //记忆集合
        Set<String> palindrome = new HashSet<>(), unPalindrome = new HashSet<>();
        if (memoryedIsPartition(s,palindrome,unPalindrome)){
            return 0;
        }else if (s.length()==2){
            return 1;
        }
        char[] chars = s.toCharArray();
        int[][] judgeArray = new int[chars.length+1][chars.length+1];
        judgeArray[0][0]=1;
        for (int i=0;i<judgeArray.length;i++){
            judgeArray[i][i]=i+1;
        }
        //第一次遍历，生成矩阵
        for (int i = 0; i < chars.length; i++) {
            int current=judgeArray[i][i];
            for (int j = i; j < chars.length; j++) {
                if (memoryedIsPartition(s.substring(i, j+1), palindrome, unPalindrome)) {
                    judgeArray[i][j]=current;
                    judgeArray[j+1][j+1]=Math.min(current+1,judgeArray[j+1][j+1]);
                }
            }
        }


        Tools.showArray(judgeArray);
        return judgeArray[judgeArray.length-1][judgeArray.length-1]-2;
    }

    //回文判断，记忆
    public boolean memoryedIsPartition(String s, Set<String> palindrome, Set<String> unPalindrome) {
        if (s.length() == 1) {
            return true;
        } else if (unPalindrome.contains(s)) {
            return false;
        } else if (palindrome.contains(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        for (int lp = 0, rp = s.length() - 1; lp < rp; lp++, rp--) {
            if (chars[lp] != chars[rp]) {
                unPalindrome.add(s);
                return false;
            }
        }
        palindrome.add(s);

        return true;
    }

    public static void main(String[] args) {
        MinCut minCut = new MinCut();
//        minCut.minCut("aaaaaddddc");
//        minCut.minCut("aaaaaddddc");
        minCut.minCut("abaca");
        minCut.minCut("aaacca");
        minCut.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    }
}
