package leetcode._1447_最简分数;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SimplifiedFractions_hash {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        Set<Double> calculated = new HashSet<>();
        for (int deno = 2; deno <= n; deno++) {
            result.add(String.format("1/%d", deno));
            calculated.add(1.0 / deno);
            for (int mol = 2; mol < deno; mol++) {
                if (calculated.contains((double)mol/deno)) {
                    continue;
                }
                result.add(String.format("%d/%d", mol, deno));
                calculated.add((double)mol/deno);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SimplifiedFractions_hash simplifiedFractions = new SimplifiedFractions_hash();
        System.out.println(2.0 / 3);
        System.out.println(6.0 / 9);
        IntStream.range(1, 10)
                .mapToObj(simplifiedFractions::simplifiedFractions)
                .forEach(System.out::println);
    }
}
