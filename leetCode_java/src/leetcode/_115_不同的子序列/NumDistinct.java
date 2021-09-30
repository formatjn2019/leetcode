package leetcode._115_不同的子序列;

import java.util.Arrays;

public class NumDistinct {
    public int numDistinct(String s, String t) {
        if (s.length()<t.length()){
            return 0;
        }
        if (s.length()==t.length()){
            return s.equals(t)?1:0;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int [][]judgeArray=new int[t.length()+1][s.length()+1];
        judgeArray[0][0]=1;
        for (int i=1;i<judgeArray.length;i++){
            int sum=0;
            for (int j=1;j<judgeArray[i].length;j++){
                sum+=judgeArray[i-1][j-1];
                if (tChars[i-1]==sChars[j-1]){
                    judgeArray[i][j]=sum;
                }
            }
        }
        int result=0;
        for (int i=1;i<judgeArray[judgeArray.length-1].length;i++){
            result+=judgeArray[judgeArray.length-1][i];
        }
        return result;
    }

    public static void main(String[] args) {
        NumDistinct numDistinct = new NumDistinct();
        numDistinct.numDistinct("babgbag","bag");
    }
}
