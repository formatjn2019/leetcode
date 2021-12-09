package leetcode._794_有效的井字游戏;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        Map<String, Long> chessCount = Arrays.stream(board)
                .flatMap(line -> Arrays.stream(line.split("")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //存入不存在的数值
        chessCount.putIfAbsent("X", 0L);
        chessCount.putIfAbsent("O", 0L);
        //棋子数量问题导致错误
        if (chessCount.get("X") < chessCount.get("O") || chessCount.get("X") - chessCount.get("O") > 1) {
            return false;
        }
        int xWin = 0, oWin = 0;
        //同时存在两个不同的胜利结果
        if (chessCount.get("O") > 2) {
            //横向
            for (String s : board) {
                if (s.equals("XXX")) {
                    xWin++;
                } else if (s.equals("OOO")) {
                    oWin++;
                }
            }
            //由于横向纵向互斥，斜方向必定与纵横互斥,统一进行判定
            //纵向
            for (int i = 0; i < 3; i++) {
                int xCount = 0, oCount = 0;
                for (int j = 0; j < 3; j++) {
                    if (board[j].charAt(i) == 'X') {
                        xCount++;
                    } else if (board[j].charAt(i) == 'O') {
                        oCount++;
                    }
                }
                xWin += xCount > 2 ? 1 : 0;
                oWin += oCount > 2 ? 1 : 0;
            }
            //斜向
            if (board[1].charAt(1) != ' ' && ((board[0].charAt(0) == board[2].charAt(2) && board[0].charAt(0) == board[1].charAt(1)
                    || (board[2].charAt(0) == board[0].charAt(2) && board[2].charAt(0) == board[1].charAt(1))))) {
                if (board[1].charAt(1) == 'X') {
                    xWin++;
                } else {
                    oWin++;
                }
            }
        }
        //存在获胜者，但存在获胜后依旧下棋的，返回false
        return (xWin <= 0 || oWin <= 0) && (xWin <= 0 || !chessCount.get("X").equals(chessCount.get("O"))) && (oWin <= 0 || Objects.equals(chessCount.get("X"), chessCount.get("O")));
    }

    public static void main(String[] args) {
        ValidTicTacToe validTicTacToe = new ValidTicTacToe();
        System.out.println(validTicTacToe.validTicTacToe(new String[]{"O  ", "   ", "   "}));
        System.out.println(validTicTacToe.validTicTacToe(new String[]{"XOX", " X ", "   "}));
        System.out.println(validTicTacToe.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        System.out.println(validTicTacToe.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
        System.out.println(validTicTacToe.validTicTacToe(new String[]{"XXX","XOO","OO "}));
    }
}
