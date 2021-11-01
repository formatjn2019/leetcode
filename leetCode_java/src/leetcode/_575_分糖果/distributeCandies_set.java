
package leetcode._575_分糖果;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class distributeCandies_set {
    public int distributeCandies(int[] candyType) {
        return Math.min(candyType.length / 2, (int) Arrays.stream(candyType).distinct().count());
    }

    public static void main(String[] args) {

    }
}
