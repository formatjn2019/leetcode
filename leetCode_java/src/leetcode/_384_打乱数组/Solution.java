package leetcode._384_打乱数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Solution {

    private int [] origin =null;
    private Random rand = new Random();

    public Solution(int[] nums) {
        origin=nums;
    }


    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int []result=Arrays.copyOf(origin,origin.length);
        for (int i=1;i<origin.length;i++){
            //随机数范围修正
            int swapIndex= rand.nextInt(origin.length-i+1);
            int temp=result[swapIndex];
            result[swapIndex]=result[origin.length-i];
            result[origin.length-i]=temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        IntStream.range(1, 100)
                .mapToObj(i -> solution.shuffle())
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
