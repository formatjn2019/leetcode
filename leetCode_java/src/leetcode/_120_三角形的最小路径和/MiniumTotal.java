package leetcode._120_三角形的最小路径和;

import java.util.Arrays;
import java.util.List;

public class MiniumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][]judgeArray=new int[triangle.size()+1][triangle.size()+1];
        for (int i=1;i<=triangle.size();i++){
            Arrays.fill(judgeArray[i],Integer.MAX_VALUE);
            List<Integer> integers = triangle.get(i - 1);
            for (int j=1;j<=integers.size();j++){
                judgeArray[i][j]=Math.min(judgeArray[i-1][j-1],judgeArray[i-1][j])+integers.get(j-1);
            }
        }
        return Arrays.stream(judgeArray[judgeArray.length - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        List<List<Integer>> testList=List.of(List.of(2),List.of(3,4),List.of(6,5,7),List.of(4,1,8,3));
        MiniumTotal miniumTotal = new MiniumTotal();
        miniumTotal.minimumTotal(testList);
    }
}
