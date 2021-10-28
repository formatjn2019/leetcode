package leetcode._77_组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new LinkedList<>();

        appendAllResult(n, k, 1, new ArrayList<>(), result);

        System.out.println(result);
        return result;
    }

    //上界 个数 当前数字 以前数字 结果
    public void appendAllResult(int n, int k, int current, List<Integer> pre, List<List<Integer>> result) {
        if (k == 0) {
            result.add(pre);
            return;
        }
        if (current > n) {
            return;
        }
        while (current <= n - k + 1) {
            ArrayList<Integer> newPre = new ArrayList<>(pre);
            newPre.add(current);
            appendAllResult(n, k - 1, ++current, newPre, result);
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 2);
    }
}
