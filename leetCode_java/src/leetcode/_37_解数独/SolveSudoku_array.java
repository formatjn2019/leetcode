package leetcode._37_解数独;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SolveSudoku_array {
    public void solveSudoku(char[][] board) {
        Set[] lineSets = {new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>()};
        Set[] rowSets = {new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>()};
        Set[] blockdSets = {new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>(), new TreeSet<>()};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int blockIndex = i / 3 * 3 + j / 3;
                int number = board[i][j] - '1';
                if (board[i][j] != '.') {
                    blockdSets[blockIndex].add(number);
                    lineSets[i].add(number);
                    rowSets[j].add(number);
                }
            }
        }
        boolean b = fillBlock(board, 0, lineSets, rowSets, blockdSets);
        if (b) {
            Arrays.stream(board)
                    .map(Arrays::toString)
                    .forEach(System.out::println);
        } else {
            System.out.println("算错了");
        }
        IntStream.range(0, 9)
                .mapToObj(i -> isAvailAble(board, i / 3 * 3, i % 3 * 3, 0))
                .forEach(System.out::println);
    }


    public boolean fillBlock(char[][] board, int index, Set[] lineSets, Set[] rowSets, Set[] blockSets) {
        if (index == 81) {
            return true;
        }
        int i = index / 9;
        int j = index % 9;
        int blockIndex = i / 3 * 3 + j / 3;
        if (board[index / 9][index % 9] == '.') {
            for (int t = 0; t < 9; t++) {
                if (!lineSets[i].contains(t) && !rowSets[j].contains(t) && !blockSets[blockIndex].contains(t)) {
                    board[i][j] = (char) ('1' + t);
                    lineSets[i].add(t);
                    rowSets[j].add(t);
                    blockSets[blockIndex].add(t);
                    //没有通过，继续尝试
                    if (fillBlock(board, index + 1, lineSets, rowSets, blockSets)) {
                        return true;
                    }
                    lineSets[i].remove(t);
                    rowSets[j].remove(t);
                    blockSets[blockIndex].remove(t);
                    board[i][j] = '.';
                }
            }
        }
        return board[i][j] != '.' && fillBlock(board, index + 1, lineSets, rowSets, blockSets);
    }

    //i,j 为起始坐标
    //dir为 0 横向右
    //dir为 1 纵向下
    //dir为 2 九宫格
    public boolean isAvailAble(char[][] board, int i, int j, int dir) {
        boolean[] numCount = new boolean[9];
        switch (dir) {
            case 0 -> {
                for (int k = 0; k < 9; k++) {
                    if (!numCount[board[i][k] - '1']) {
                        numCount[board[i][k] - '1'] = true;
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 1 -> {
                for (int k = 0; k < 9; k++) {
                    if (!numCount[board[k][j] - '1']) {
                        numCount[board[k][j] - '1'] = true;
                    } else {
                        return false;
                    }
                }
                return true;
            }
            default -> {
                for (int k = 0; k < 9; k++) {
                    if (!numCount[board[i + k / 3][j + k % 3] - '1']) {
                        numCount[board[i + k / 3][j + k % 3] - '1'] = true;
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(i * 9 + j + 1 + ",");
            }
            System.out.println();
        }
//        String [][] strings=new String[][]
//                {{"5","3","4","6","7","8","9","1","2"},
//                {"6","7","2","1","9","5","3","4","8"},
//                {"1","9","8","3","4","2","5","6","7"},
//                {"8","5","9","7","6","1","4","2","3"},
//                {"4","2","6","8","5","3","7","9","1"},
//                {"7","1","3","9","2","4","8","5","6"},
//                {"9","6","1","5","3","7","2","8","4"},
//                {"2","8","7","4","1","9","6","3","5"},
//                {"3","4","5","2","8","6","1","7","9"}};
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
        SolveSudoku_array solveSudoku = new SolveSudoku_array();
//        System.out.println(solveSudoku.isAvailAble(chars, 0, 0, 0));
//        System.out.println(solveSudoku.isAvailAble(chars, 0, 0, 1));
//        System.out.println(solveSudoku.isAvailAble(chars, 0, 0, 2));
        solveSudoku.solveSudoku(chars);
    }
}
