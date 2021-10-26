package leetcode._240_搜索二维矩阵II;

import leetcode.Tools;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchMatrix {
    static AtomicInteger count = new AtomicInteger();
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, 0, matrix[0].length, matrix.length, target);
    }

    public boolean searchMatrix(int[][] matrix, int start, int width, int height, int target) {
        //找不到
        if (start >= width || start >= height) {
            return false;
        }
        //横向搜索
        for (int lp = start; lp < width; ) {
            int medium = (lp + width) / 2;
            if (matrix[start][medium] == target) {
                return true;
            } else if (matrix[start][medium] < target) {
                lp = medium + 1;
            } else {
                width = medium;
            }
        }
        //纵向搜索
        for (int lp = start; lp < height; ) {
            int medium = (lp + height) / 2;
            if (matrix[medium][start] == target) {
                return true;
            } else if (matrix[medium][start] < target) {
                lp = medium + 1;
            } else {
                height = medium;
            }
        }
        return searchMatrix(matrix, start + 1, width, height, target);
    }

    public static void main(String[] args) {
        int[][] ints = Tools.parseArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        SearchMatrix searchMatrix = new SearchMatrix();
        long count = Arrays.stream(ints)
                .flatMapToInt(Arrays::stream)
                .filter(i -> searchMatrix.searchMatrix(ints, i))
                .count();
        System.out.println(count);
        System.out.println(SearchMatrix.count);

    }

}
