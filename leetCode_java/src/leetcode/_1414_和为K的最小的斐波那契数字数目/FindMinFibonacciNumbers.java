package leetcode._1414_和为K的最小的斐波那契数字数目;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindMinFibonacciNumbers {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> getfibonaccics = getfibonaccics(k);
        int result=0;
        for (int index=getfibonaccics.size()-1;index>=0&&k>0;index--){
            if (getfibonaccics.get(index)<=k){
                k-=getfibonaccics.get(index);
                result++;
            }
        }
        return result;
    }

    public List<Integer> getfibonaccics(int num){
        List<Integer> result=new ArrayList<>(List.of(1,2));
        while (num>result.get(result.size()-1)){
            result.add(result.get(result.size()-1)+result.get(result.size()-2));
        }
        return result;
    }

    public static void main(String[] args) {
        FindMinFibonacciNumbers findMinFibonacciNumbers = new FindMinFibonacciNumbers();
        IntStream.range(1,100)
                .peek(System.out::println)
                .map(findMinFibonacciNumbers::findMinFibonacciNumbers)
                .forEach(System.out::println);
    }
}
