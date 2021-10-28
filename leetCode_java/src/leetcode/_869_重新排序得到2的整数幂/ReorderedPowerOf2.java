package leetcode._869_重新排序得到2的整数幂;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class ReorderedPowerOf2 {

    private static HashSet<String> hs = calculateAllConditions();

    private static HashSet<String> calculateAllConditions() {
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            result.add(countNums((int) Math.pow(2, i)));
        }
        return result;
    }

    private static String countNums(int n) {
        int[] numsCount = new int[10];
        while (n>0){
            numsCount[n%10]++;
            n/=10;
        }
        return Arrays.toString(numsCount);
    }

    public boolean reorderedPowerOf2(int n) {
        return hs.contains(countNums(n));
    }


    public static void main(String[] args) {
        ReorderedPowerOf2 reorderedPowerOf2 = new ReorderedPowerOf2();
        IntStream.range(1, 100)
                .filter(reorderedPowerOf2::reorderedPowerOf2)
                .forEach(System.out::println);
    }
}
