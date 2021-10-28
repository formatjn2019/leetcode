package leetcode._74_搜索二维矩阵;

import java.util.Arrays;
import java.util.stream.Stream;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //二分搜索行首
        int start = 0, end = matrix.length;
        int medium = 0;
        while (start < end) {
            medium = (start + end) / 2;
            //等于
            if (matrix[medium][0] == target) {
                return true;
            }
            //大了
            if (matrix[medium][0] > target) {
                end = medium;
            }//可能在当前行
            else if (medium + 1 == matrix.length || matrix[medium + 1][0] > target) {
                break;
            } else {
                start = medium + 1;
            }
        }
        if (medium < matrix.length) {
            start = 1;
            end = matrix[medium].length;
            while (start < end) {
                int row = (start + end) / 2;
                if (matrix[medium][row] == target) {
                    return true;
                } else if (matrix[medium][row] < target) {
                    start = row + 1;
                } else {
                    end = row;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] ints = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};


        long count = Arrays.stream(ints)
                .flatMapToInt(Arrays::stream)
                .map(i -> i * 3)
                .filter(i -> searchMatrix.searchMatrix(ints, i))
                .count();
        System.out.println(count);

//                .forEach(System.out::println);
    }
}
