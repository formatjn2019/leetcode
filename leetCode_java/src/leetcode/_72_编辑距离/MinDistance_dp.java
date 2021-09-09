package leetcode._72_编辑距离;

import java.util.Map;

public class MinDistance_dp {

    public int minDistance(String w1, String w2) {
        int [][]judgeArray= new int[w1.length()+1][w2.length()+1];
        for (int i=0;i<judgeArray.length;i++){
            judgeArray[i][0]=i;
        }
        for (int j=0;j<judgeArray[0].length;j++){
            judgeArray[0][j]=j;
        }
        for (int i=1;i<judgeArray.length;i++){
            for (int j=1;j<judgeArray[0].length;j++){
                judgeArray[i][j]=w1.charAt(i-1)==w2.charAt(j-1)?Math.min(judgeArray[i-1][j-1],1+Math.min(judgeArray[i-1][j],judgeArray[i][j-1])):Math.min(judgeArray[i-1][j-1]+1,Math.min(judgeArray[i-1][j],judgeArray[i][j-1])+1);
            }
        }
        return judgeArray[judgeArray.length-1][judgeArray[0].length-1];
    }

    public static void main(String[] args) {
        MinDistance_dp minDistance = new MinDistance_dp();
        Map<String, String> testDatas = Map.of(
                "aaabbccc", "aaaabcccc",
                "a","b",
                "ab","a",
                "horse","ros",
                "intention", "execution"
        );
        testDatas.entrySet().stream()
                .peek(System.out::println)
                .mapToInt((entry) -> minDistance.minDistance(entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

    }
}
