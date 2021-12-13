package leetcode._807_保持城市天际线;

import leetcode.Tools;
import leetcode._318_最大单词长度乘积.MaxProduct;

public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result=0;
        //记录下行列的最大值
        int []lineMaxHeight=new int[grid.length],rowMaxHeight=new int[grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                lineMaxHeight[i]=Math.max(lineMaxHeight[i],grid[i][j]);
                rowMaxHeight[j]=Math.max(rowMaxHeight[j],grid[i][j]);
            }
        }
        //根据行列的最大值更新结果
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                result+=Math.min(lineMaxHeight[i],rowMaxHeight[j])-grid[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxIncreaseKeepingSkyline maxIncreaseKeepingSkyline = new MaxIncreaseKeepingSkyline();
        int[][] ints = Tools.parseArray("[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]");
        maxIncreaseKeepingSkyline.maxIncreaseKeepingSkyline(ints);
    }
}
