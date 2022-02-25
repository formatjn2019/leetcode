package leetcode._1706_球会落在何处;

import leetcode.Tools;

import java.util.Arrays;

public class FindBall {
    public int[] findBall(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int[] result = new int[width];
        //初始化
        for (int j=0;j<width;j++){
            result[j]=j;
        }
        //球的索引
        for (int j=0;j<width;j++){
            //行索引
            for (int i = 0; i < height; i++) {
                int x=i,y=result[j];
                if (grid[x][y]==1 && y<width-1 && grid[x][y+1]==1){
                    result[j]++;
                }else if(grid[x][y]==-1 && y>0 && grid[x][y-1]==-1) {
                    result[j]--;
                }else {
                    result[j]=-1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindBall findBall = new FindBall();
        findBall.findBall(Tools.parseArray("[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]"));
        findBall.findBall(Tools.parseArray("[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]"));
        findBall.findBall(Tools.parseArray("[[-1]]"));
    }
}
