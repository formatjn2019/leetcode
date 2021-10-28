package leetcode._73_矩阵置零;

import java.util.Arrays;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        boolean[] zoneFlag = new boolean[width + height];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zoneFlag[j] = true;
                    zoneFlag[width + i] = true;
                }
            }
        }
        //行置零
        for (int i = 0; i < height; i++) {
            if (zoneFlag[width + i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        //列置零
        for (int j = 0; j < width; j++) {
            if (zoneFlag[j]) {
                for (int i = 0; i < height; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int[][] matrix = new int[][]{{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};
        Arrays.stream(matrix)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("_____________________");
        setZeroes.setZeroes(matrix);
        Arrays.stream(matrix)
                .map(Arrays::toString)
                .forEach(System.out::println);

    }
}
