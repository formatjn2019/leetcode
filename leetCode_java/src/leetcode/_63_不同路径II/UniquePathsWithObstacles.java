package leetcode._63_不同路径II;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height=obstacleGrid.length,width=obstacleGrid[0].length;
        int [][]judgeArray=new int[height+1][width+1];
        judgeArray[0][1]=1;
        for (int i =1;i<=height;i++){
            for (int j=1;j<=width;j++){
                if (obstacleGrid[i-1][j-1]==0){
                    judgeArray[i][j]=judgeArray[i-1][j]+judgeArray[i][j-1];
                }
            }
        }
        return judgeArray[height][width];
    }
    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int i = uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0,0}});
        System.out.println(i);
    }
}
