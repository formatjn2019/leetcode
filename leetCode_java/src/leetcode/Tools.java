package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public static void showArray(boolean [][]arr){
        Arrays.stream(arr)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
    public static int[][] parseArray(String str){
        List<List<String>> collect = Arrays.stream(str.split("\\],\\["))
                .map(item -> item.replaceAll("[\\[\\]]*", ""))
                .map(strItem -> Arrays.stream(strItem.split(",")).collect(Collectors.toList()))
                .collect(Collectors.toList());
        int [][]result=new int[collect.size()][];
        for (int i=0;i<collect.size();i++){
            result[i]=new int[collect.get(i).size()];
            for (int j=0;j<collect.get(i).size();j++) {
                result[i][j]=Integer.parseInt(collect.get(i).get(j));
            }
        }
        return result;
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

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(parseArray("[[1,2],[2,3]]")));
    }
}
