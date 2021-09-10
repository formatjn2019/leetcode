package leetcode._85_最大矩形;

import leetcode.MatrixTool;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayDeque;
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int result=0;
        //矩阵变为纵向统计矩阵
        for (int i=1;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]!='0'){
                    matrix[i][j]= (char) (matrix[i-1][j]+1);
                }
            }
        }
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        //哨兵节点
        stack.push(-1);
        //单调栈
        for (int i=matrix.length-1;i>=0;i--){
            //剪枝
            if ((i+1)*matrix[i].length<result){
                break;
            }

            for (int j=0;j<=matrix[i].length;j++){
                while (stack.getFirst()!=-1 && (j==matrix[i].length || matrix[i][stack.getFirst()] > matrix[i][j])){
                    Integer index = stack.pop();
                    //面积
                    result=Math.max((matrix[i][index]-'0')*(j-stack.getFirst()-1),result);
                }
                if (j!=matrix[i].length){
                    stack.push(j);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        String[][] strings = {{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}};
        char[][] chars = MatrixTool.StringToChar(strings);
        MatrixTool.PrintMatrix(chars);
        int i = maximalRectangle.maximalRectangle(chars);
        System.out.println(i);
        MatrixTool.PrintMatrix(chars);
    }
}
