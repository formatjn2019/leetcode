package leetcode._60_排列序列;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GetPermutation_generate {
    public String getPermutation(int n, int k) {
        int[] ints = IntStream.range(1, n + 1)
                .toArray();
        AtomicInteger atomicInteger = new AtomicInteger(k);
        return generateItems(ints, new boolean[ints.length], 0, atomicInteger);
    }

    public String generateItems(int[] items, boolean[] judgeArray, int depth, AtomicInteger search) {
        if (depth == items.length) {
            int i = search.decrementAndGet();
            //已经到达所需的搜索的层数
            if (i == 0) {
                //仅标记作用
                return "*";
            } else {
                return "";
            }
        }
        for (int i = 0; i < items.length; i++) {
            if (!judgeArray[i]) {
                judgeArray[i] = true;
                String s = generateItems(items, judgeArray, depth + 1, search);
                if (!"".equals(s)) {
                    return "*".equals(s) ? (i + 1) + "" : (i + 1) + s;
                }
                judgeArray[i] = false;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        GetPermutation_generate getPermutation = new GetPermutation_generate();
        IntStream.range(1, 4)
                .mapToObj(i -> getPermutation.getPermutation(i, 1))
                .forEach(System.out::println);
    }
}
