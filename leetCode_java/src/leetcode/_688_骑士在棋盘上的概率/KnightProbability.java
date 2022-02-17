package leetcode._688_骑士在棋盘上的概率;

import java.math.BigDecimal;
import java.util.*;

public class KnightProbability {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dirs = new int[][]{{-2, -1}, {-2, 1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}};
        double[][][] judge = new double[k + 1][n][n];
        judge[0][row][column] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    for (int[] dir : dirs) {
                        int x = dir[0] + j, y = dir[1] + l;
                        if (x >= 0 && y >= 0 && x < n && y < n) {
                            judge[i + 1][x][y] += judge[i][j][l] / 8;
                        }
                    }
                }
            }
        }

        return Arrays.stream(judge[k]).flatMapToDouble(Arrays::stream).sum();
    }


    public static void main(String[] args) {
        KnightProbability knightProbability = new KnightProbability();
        System.out.println(knightProbability.knightProbability(8, 30, 6, 4));

    }

}
