package leetcode;

import java.util.Arrays;

public class Tools {
    public static void showArray(int [][]arr){
        Arrays.stream(arr)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
