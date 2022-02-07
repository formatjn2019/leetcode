package leetcode._1219_黄金矿工;

import leetcode.Tools;

public class GetMaximumGold {
    public int getMaximumGold(int[][] grid) {
        boolean[][] used = new boolean[grid.length][grid[0].length];
        int[] result = new int[1];
        //确定起始点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                    search(grid, used, i, j, 0, result);
            }
        }
        return result[0];
    }

    public void search(int[][] grid, boolean[][] used, int x, int y, int current, int[] maxSum) {
        maxSum[0] = Math.max(maxSum[0], current + grid[x][y]);
        used[x][y] = true;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if ((nx >= 0 && nx < used.length && ny >= 0 && ny < used[nx].length) && !used[nx][ny] && grid[nx][ny] > 0) {
                search(grid, used, nx, ny, current + grid[x][y], maxSum);
            }
        }
        used[x][y] = false;
    }

    public static void main(String[] args) {
        GetMaximumGold getMaximumGold = new GetMaximumGold();
        System.out.println(getMaximumGold.getMaximumGold(Tools.parseArray("[[0,6,0],[5,8,7],[0,9,0]]")));
        System.out.println(getMaximumGold.getMaximumGold(Tools.parseArray("[[1,6,1],[5,8,7],[1,9,1]]")));
        System.out.println(getMaximumGold.getMaximumGold(Tools.parseArray("[[0,0,0,3,0,0,17,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,8,5,15,0,0],[0,0,0,0,0,17,0,17,0,0,12,0],[0,0,0,4,0,0,20,0,0,0,0,0],[0,0,0,0,0,7,13,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,16,20],[2,0,0,4,0,0,0,16,0,4,0,0],[0,0,11,0,0,10,0,0,5,0,0,18],[2,0,12,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,3,0],[0,0,0,0,0,0,0,0,0,0,0,0]]")));

    }
}
