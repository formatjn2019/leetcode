package leetcode._51_n皇后问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new LinkedList<>();
        char [][]chessboard=new char[n][n];
        Arrays.stream(chessboard).forEach(arr->Arrays.fill(arr,'.'));
        appendSolute(0,chessboard,result);
        System.out.println(result.size());
        return result;
    }

    public void appendSolute(int line,char [][]chessboard,List<List<String>> result){
        if (line==chessboard.length){
            result.add(Arrays.stream(chessboard)
                    .map(String::new)
                    .collect(Collectors.toList()));
            return;
        }
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
            appendSolute(line+1,chessboard,result);
            chessboard[line][j]='.';
        }

    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}
