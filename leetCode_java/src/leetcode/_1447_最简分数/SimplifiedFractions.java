package leetcode._1447_最简分数;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int deno = 2; deno <= n; deno++) {
            result.add(String.format("1/%d", deno));
            for (int mol = 2; mol < deno; mol++) {
                if (gcd(deno,mol)!=1) {
                    continue;
                }
                result.add(String.format("%d/%d", mol, deno));
            }
        }
        return result;
    }
    private int gcd(int n1,int n2){
        return n1%n2==0?n2:gcd(n2,n1%n2);
    }

    private void test(SimplifiedFractions_hash ha, SimplifiedFractions si,int n) {
        List<String> strings = ha.simplifiedFractions(n);
        List<String> strings2 = si.simplifiedFractions(n);
        boolean b = strings.size()==strings2.size();
        if (!b|| n%1000==0){
            System.out.println(n);
        }
    }

    public static void main(String[] args) throws Exception {
        SimplifiedFractions simplifiedFractions = new SimplifiedFractions();
        SimplifiedFractions_hash simplifiedFractions_hash =new SimplifiedFractions_hash();
        System.out.println(2.0 / 3);
        System.out.println(6.0 / 9);
        IntStream.range(100,10000)
                .forEach(n->simplifiedFractions.test(simplifiedFractions_hash,simplifiedFractions,n));

        simplifiedFractions.gcd(15,10);
    }
}
