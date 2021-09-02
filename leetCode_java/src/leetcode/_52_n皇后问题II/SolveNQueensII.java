package leetcode._52_n皇后问题II;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueensII {
    public int totalNQueens(int n){
        List<List<String>> result=new LinkedList<>();
        char [][]chessboard=new char[n][n];
        Arrays.stream(chessboard).forEach(arr-> Arrays.fill(arr,'.'));
//        appendSolute(0,chessboard,result);
//        System.out.println(result.size());
        return appendSolute(0,chessboard);
    }

    public int appendSolute(int line,char [][]chessboard){
        if (line==chessboard.length){
//            result.add(Arrays.stream(chessboard)
//                    .map(String::new)
//                    .collect(Collectors.toList()));
            return 1;
        }
        int count=0;
        outter:
        for (int j=0;j<chessboard.length;j++){
            //纵向
            for (int ti=line;ti>=0;ti--){
                if (chessboard[ti][j]!='.'){
                    continue outter;
                }
            }
            //左上
            for (int ti=line,tj=j;ti>=0&&tj>=0;ti--,tj--){
                if (chessboard[ti][tj]!='.'){
                    continue outter;
                }
            }
            //左下
            for (int ti=line,tj=j;ti>=0&&tj<chessboard.length;ti--,tj++){
                if (chessboard[ti][tj]!='.'){
                    continue outter;
                }
            }
            //判定成功，填充，进入下一层
            chessboard[line][j]='Q';
            count+=appendSolute(line+1,chessboard);
            chessboard[line][j]='.';
        }
        return count;
    }

    public static void main(String[] args) {
        SolveNQueensII solveNQueens = new SolveNQueensII();
        System.out.println(solveNQueens.totalNQueens(4));
        System.out.println(solveNQueens.totalNQueens(1));
        System.out.println(solveNQueens.totalNQueens(2));
    }
}
