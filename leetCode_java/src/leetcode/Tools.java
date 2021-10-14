package leetcode;

import java.util.Arrays;

public class Tools {
    public static void showArray(int [][]arr){
        Arrays.stream(arr)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
    public static void showArray(char [][]arr){
        Arrays.stream(arr)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
    public static char[][] changeToCharArray(String [][]strings){
        char [][] results=new char[strings.length][strings[0].length];
        for (int i=0;i<strings.length;i++){
            for (int j=0;j<strings[0].length;j++){
                results[i][j]=strings[i][j].charAt(0);
            }
        }
        return results;
    }
}
