package leetcode._1706_球会落在何处;

import leetcode.Tools;

public class FindBall_grid {
    public int[] findBall(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int[][] judge = new int[height+1][width];

        //底层初始化
        for (int j = 0; j < width; j++) {
            judge[height][j] = j;
        }

        //上层初始化
        for (int i=height-1;i>=0;i--){
            for (int j=0;j<width;j++){
                if (grid[i][j]==1 && j+1<width && grid[i][j+1]==1){
                    judge[i][j]=judge[i+1][j+1];
                }else if (grid[i][j]==-1 && j>0 && grid[i][j-1]==-1) {
                    judge[i][j]=judge[i+1][j-1];
                }else {
                    judge[i][j]=-1;
                }
            }
        }
        return judge[0];
    }

    public static void main(String[] args) {
        FindBall_grid findBall = new FindBall_grid();
        findBall.findBall(Tools.parseArray("[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]"));
        findBall.findBall(Tools.parseArray("[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]"));
        findBall.findBall(Tools.parseArray("[[-1]]"));
    }
}
