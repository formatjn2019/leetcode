package leetcode._1034_边界着色;

import leetcode.Tools;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ColorBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        //可扩展节点集合
        ArrayDeque<List<Integer>> extendPoints = new ArrayDeque<>();
        extendPoints.add(List.of(row,col));
        HashSet<List<Integer>> usedPoint = new HashSet<>();
        usedPoint.add(List.of(row, col));
        //拓展方向
        //上下左右
        int[][] extendDirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<List<Integer>> boundList=new ArrayList<>();
        while (extendPoints.size() > 0) {
            List<Integer> node = extendPoints.pop();
            int extendNum = 0;
            for (int[] extendDir : extendDirs) {
                int x = node.get(0) + extendDir[0];
                int y = node.get(1) + extendDir[1];
                //符合条件
                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == grid[row][col]) {
                    extendNum++;
                    //是新节点,则进行扩展
                    if (usedPoint.add(List.of(x, y))) {
                        extendPoints.add(List.of(x, y));
                    }
                }
            }
            if (extendNum!=4){
                boundList.add(node);
            }
        }
//        System.out.println(usedPoint);
        for (List<Integer> integers : boundList) {
            grid[integers.get(0)][integers.get(1)]=color;
        }
        return grid;
    }

    public static void main(String[] args) {
        ColorBorder colorBorder= new ColorBorder();
        int[][] ints = colorBorder.colorBorder(new int[][]{{1, 1,1},{1, 1,1},{1, 1,1}}, 0, 0, 2);
        Tools.showArray(ints);
    }
}
