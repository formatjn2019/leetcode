package leetcode._869_重新排序得到2的整数幂;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class ReorderedPowerOf2_str {

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
        char[] chars = (n + "").toCharArray();
        for (char aChar : chars) {
            numsCount[aChar - '0']++;
        }
        return Arrays.toString(numsCount);
    }

    public boolean reorderedPowerOf2(int n) {
        return hs.contains(countNums(n));
    }


    public static void main(String[] args) {
        ReorderedPowerOf2_str reorderedPowerOf2 = new ReorderedPowerOf2_str();
        IntStream.range(1, 100)
                .filter(reorderedPowerOf2::reorderedPowerOf2)
                .forEach(System.out::println);
    }
}
