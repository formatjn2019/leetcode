package leetcode._1765_地图中的最高点;

import leetcode.Tools;

import java.util.*;

public class HighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int[][] result = new int[isWater.length][isWater[0].length];
        Set<List<Integer>> waterIndexs = new HashSet<>();
        Arrays.stream(result)
                .forEach(arr->Arrays.fill(arr,-1));
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    waterIndexs.add(List.of(i, j));
                    result[i][j]=0;
                }
            }
        }
        fillArray(result, waterIndexs, 1);
        return result;
    }

    public void fillArray(int[][] matrix, Set<List<Integer>> indexs, int depth) {
        if (indexs.isEmpty()) {
            return;
        }
        Set<List<Integer>> nextLevel = new HashSet<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (List<Integer> index : indexs) {
            for (int[] dir : dirs) {
                int x=dir[0]+index.get(0);
                int y=dir[1]+index.get(1);
                //坐标符合
                if (x>=0 && x<matrix.length && y>=0 && y<matrix[x].length && matrix[x][y]<0){
                    nextLevel.add(List.of(x,y));
                }
            }
        }
        for (List<Integer> index : nextLevel) {
            matrix[index.get(0)][index.get(1)] = depth;
        }
        fillArray(matrix, nextLevel, depth + 1);
    }

    public static void main(String[] args) {
        HighestPeak highestPeak = new HighestPeak();
        int[][] ints = highestPeak.highestPeak(Tools.parseArray("[[0,1],[0,0]]"));
        Tools.showArray(ints);
        ints = highestPeak.highestPeak(Tools.parseArray("[[0,0,1],[1,0,0],[0,0,0]]"));
        Tools.showArray(ints);
    }
}
