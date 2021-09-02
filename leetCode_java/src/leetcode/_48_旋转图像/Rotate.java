package leetcode._48_旋转图像;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[][] matrix) {
        int temp;
        //圈数
        for (int i = 0; i < matrix.length / 2; i++) {
            //每行移动列数-1个元素
            for (int j = i; j < matrix.length-i -1; j++) {
//                //左上
//                System.out.println(matrix[i][j]);
//                //左下
//                System.out.println(matrix[matrix.length-1-j][i]);
//                //右下
//                System.out.println(matrix[matrix.length-1-i][matrix.length-1-j]);
//                //右上
//                System.out.println(matrix[j][matrix.length-1-i]);
                //左上
                temp = matrix[i][j];
                //左下->左上
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                //右下->左下
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                //右上->右下
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                //左上->右上
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
//        int[][] testArray = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] testArray = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Arrays.stream(testArray)
                .map(Arrays::toString)
                .forEach(System.out::println);
        rotate.rotate(testArray);
        Arrays.stream(testArray)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
