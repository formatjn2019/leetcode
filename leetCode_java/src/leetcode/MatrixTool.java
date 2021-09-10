package leetcode;

import java.util.Arrays;

public class MatrixTool {
    public static char[][] StringToChar(String[][] strings) {
        char result[][] = new char[strings.length][strings[0].length];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                result[i][j] = strings[i][j].charAt(0);
            }
        }
        return result;
    }

    public static void PrintMatrix(Object[][] strings) {
        System.out.println("***************************");
        Arrays.stream(strings)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("***************************");

    }

    public static void PrintMatrix(int[][] strings) {
        System.out.println("***************************");

        Arrays.stream(strings)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("***************************");

    }

    public static void PrintMatrix(char[][] strings) {
        System.out.println("***************************");

        Arrays.stream(strings)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("***************************");

    }
}
