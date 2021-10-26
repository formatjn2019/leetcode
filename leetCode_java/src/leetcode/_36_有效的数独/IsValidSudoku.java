package leetcode._36_有效的数独;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //横向 i 为横坐标，j为纵坐标
        //纵向 i 为纵坐标，j为横坐标
        //方格 i为偏移度，j为坐标
        for (int i = 0; i < board.length; i++) {
            int[] judgeArray = new int[9];
            int[] judgeArray2 = new int[9];
            int[] judgeArray3 = new int[9];
            for (int j = 0; j < board[i].length; j++) {
                //横向扫描
                if (board[i][j] != '.') {
                    if (judgeArray[board[i][j] - '1']++ == 1) {
                        return false;
                    }
                }
                //纵向扫描
                if (board[j][i] != '.') {
                    if (judgeArray2[board[j][i] - '1']++ == 1) {
                        return false;
                    }
                }
                //九宫格扫描
                if (board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] != '.') {
                    if (judgeArray3[board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] - '1']++ == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        String[][] strings = new String[][]{{"5", "3", ".", ".", "7", ".", ".", ".", "."}
                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        char[][] chars = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                chars[i][j] = strings[i][j].charAt(0);
            }
        }
        System.out.println(isValidSudoku.isValidSudoku(chars));
        chars[0][0] = '8';
        System.out.println(isValidSudoku.isValidSudoku(chars));


    }
}
