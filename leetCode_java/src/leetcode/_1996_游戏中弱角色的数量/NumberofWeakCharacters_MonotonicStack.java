package leetcode._1996_游戏中弱角色的数量;

import leetcode.Tools;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class NumberofWeakCharacters_MonotonicStack {
    public int numberOfWeakCharacters(int[][] properties) {
        //排序
        Arrays.sort(properties,(arr1,arr2)->{
            if (arr1[0]-arr2[0]!=0){
                return arr1[0]-arr2[0];
            }else {
                return arr2[1]-arr1[1];
            }
        });
        int result=0;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int[] property : properties) {
            while (!stack.isEmpty() && property[1]>stack.peek()){
                stack.pop();
                result++;
            }
            System.out.println(stack);
            stack.push(property[1]);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        NumberofWeakCharacters_MonotonicStack numberofWeakCharacters = new NumberofWeakCharacters_MonotonicStack();
//        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[1,5],[10,4],[4,3],[2,2],[3,3],[1,5],[10,4],[4,3]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[1,3],[2,5],[4,7],[3,9],[5,6],[6,6],[6,2],[9,1]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[5,5],[6,3],[3,6]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[2,2],[3,3]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[1,5],[10,4],[4,3]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[1,5],[10,4],[4,3]]"));
    }
}
