package leetcode._54_螺旋矩阵;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix[0].length==1){
            return Arrays.stream(matrix)
                    .mapToInt(arr->arr[0])
                    .boxed()
                    .collect(Collectors.toList());
        }
        ArrayList<Integer> result=new ArrayList<>(matrix.length*matrix[0].length);
        traverse(matrix,0,0,result,0,0);
        return result;
    }
    public void traverse(int [][]matrix,int startx,int starty,List<Integer> result,int dir,int depth){
        if (result.size()==matrix.length*matrix[0].length){
            return;
        }if (result.size()==matrix.length*matrix[0].length-1){
            result.add(matrix[startx][starty]);
            return;
        }
        switch (dir){
            //右
            case 0->{
                for (;starty<matrix[startx].length-1-depth;starty++){
                    result.add(matrix[startx][starty]);
                }
                traverse(matrix,startx,starty,result,(dir+1)%4,depth);
            }
            //下
            case 1->{
                for (;startx<matrix.length-1-depth;startx++){
                    result.add(matrix[startx][starty]);
                }
                traverse(matrix,startx,starty,result,(dir+1)%4,depth);
            }
            //左
            case 2->{
                for (;starty>depth;starty--){
                    result.add(matrix[startx][starty]);
                }
                traverse(matrix,startx,starty,result,(dir+1)%4,depth);
            }
            //上
            default -> {
                for (;startx>depth;startx--){
                    result.add(matrix[startx][starty]);
                }
                traverse(matrix,startx+1,starty+1,result,(dir+1)%4,depth+1);
            }
        }
    }

    public void test(int [][]arrays){
        Arrays.stream(arrays)
                .map(Arrays::toString)
                .forEach(System.out::println);
        List<Integer> integers = spiralOrder(arrays);
        System.out.println(integers);
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        spiralOrder.test(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        spiralOrder.test(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        spiralOrder.test(new int[][]{{7},{9},{6}});
        spiralOrder.test(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        spiralOrder.test(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}});
//        for (int i=1;i<5;i++){
//            for (int j=1;j<=5;j++){
//                int[][] ints = new int[i][j];
//                int num=1;
//                for (int ti=0;ti<i;ti++){
//                    for (int tj=0;tj<j;tj++){
//                        ints[ti][tj]=num++;
//                    }
//                }
//                System.out.println(i+"\t\t"+j);
//                spiralOrder.spiralOrder(ints);
//            }
//        }
    }
}
