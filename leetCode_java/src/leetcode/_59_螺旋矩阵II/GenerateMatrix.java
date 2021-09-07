package leetcode._59_螺旋矩阵II;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] result = new int[n][n];
        fillMatrix(result, 0, 0, 1, 0, 0);
        return result;
    }

    public void fillMatrix(int[][] matrix, int startX, int startY, int current, int dir, int depth) {
        if (current > matrix.length * matrix.length) {
            return;
        }
        if (current == matrix.length * matrix.length) {
            matrix[startX][startY] = current;
            return;
        }
        switch (dir) {
            //右
            case 0 -> {
                for (; startY < matrix[startX].length - 1 - depth; startY++) {
                    matrix[startX][startY] = current++;
                }
                fillMatrix(matrix, startX, startY, current, (dir + 1) % 4, depth);
            }
            //下
            case 1 -> {
                for (; startX < matrix.length - 1 - depth; startX++) {
                    matrix[startX][startY] = current++;
                }
                fillMatrix(matrix, startX, startY, current, (dir + 1) % 4, depth);
            }
            //左
            case 2 -> {
                for (; startY > depth; startY--) {
                    matrix[startX][startY] = current++;
                }
                fillMatrix(matrix, startX, startY, current, (dir + 1) % 4, depth);
            }
            //上
            default -> {
                for (; startX > depth; startX--) {
                    matrix[startX][startY] = current++;
                }
                fillMatrix(matrix, startX+1, startY+1, current, (dir + 1) % 4, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        IntStream.range(1, 10)
                .mapToObj(generateMatrix::generateMatrix)
                .map(arr -> Arrays.stream(arr)
                        .map(Arrays::toString)
                        .reduce((i, j) -> i + "\n" + j))
                .peek(i -> System.out.println("\n" + "-----------------"))
                .map(Optional::get)
                .forEach(System.out::println);
    }

}
