package leetcode._64_最小路径和;

import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int height=grid.length,width=grid[0].length;
        int [][]judgeArray=new int[height+1][width+1];
        Arrays.fill(judgeArray[0],Integer.MAX_VALUE);
        for (int i=0;i<=grid.length;i++){
            judgeArray[i][0]=Integer.MAX_VALUE;
        }

        for (int i=1;i<=height;i++){
            for (int j=1;j<=width;j++){
                if (i==1 && j==1){
                    judgeArray[1][1]=grid[0][0];
                    continue;
                }
                judgeArray[i][j]=Math.min(judgeArray[i-1][j],judgeArray[i][j-1])+grid[i-1][j-1];
            }
        }
        return judgeArray[height][width];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        minPathSum.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
}
