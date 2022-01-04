package leetcode._2022_将一维数组转变成二维数组;

public class construct2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        } else {
            int[][] result = new int[m][n];
            for (int i = 0; i < original.length; i++) {
                result[i / n][i % n] = original[i];
            }
            return result;
        }
    }
}
