package leetcode._1447_最简分数;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SimplifiedFractions_test {
    Set<Double> calculated = new HashSet<>();

    public int simplifiedFractions(int n) {
        int result = 0;
        int deno = n;
        result++;
        for (int mol = 2; mol < deno; mol++) {
            if (gcd(deno, mol) != 1) {
                continue;
            }
            result++;
        }

        return result;
    }

    private int gcd(int n1, int n2) {
        return n1 % n2 == 0 ? n2 : gcd(n2, n1 % n2);
    }

    public int simplifiedFractions_hash(int n) {
        int result = 0;
        int deno = n;
        calculated.add(1.0 / deno);
        result++;
        for (int mol = 2; mol < deno; mol++) {
            if (calculated.contains((double) mol / deno)) {
                continue;
            }
            result++;
            calculated.add((double) mol / deno);
        }
        return result;
    }

    private void test() {
        for (int i = 1; i < 1000000; i++) {
            if (simplifiedFractions(i) != simplifiedFractions_hash(i) || i%1000==0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SimplifiedFractions_test simplifiedFractions = new SimplifiedFractions_test();
        simplifiedFractions.test();
    }
}
