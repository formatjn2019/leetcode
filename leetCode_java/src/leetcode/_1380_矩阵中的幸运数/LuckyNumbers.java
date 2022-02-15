package leetcode._1380_矩阵中的幸运数;

import leetcode.Tools;

import java.util.*;

public class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int []lineMin=new int[matrix.length],rowMax=new int[matrix[0].length];
        Arrays.fill(lineMin,Integer.MAX_VALUE);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                lineMin[i]=Math.min(lineMin[i],matrix[i][j]);
                rowMax[j]=Math.max(rowMax[j],matrix[i][j]);
            }
        }
        Set<Integer> mins=new HashSet<>();
        for (int result : lineMin) {
            mins.add(result);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int max : rowMax) {
            if (mins.contains(max)){
                result.add(max);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        System.out.println(luckyNumbers.luckyNumbers(Tools.parseArray("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]")));
    }
}
