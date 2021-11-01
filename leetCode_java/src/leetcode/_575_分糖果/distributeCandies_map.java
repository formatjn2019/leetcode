package leetcode._575_分糖果;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class distributeCandies_map {
    public int distributeCandies(int[] candyType) {
        Map<Integer, Long> typesCount = Arrays.stream(candyType)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        return Math.min(candyType.length/2,typesCount.keySet().size());
    }

    public static void main(String[] args) {

    }
}
