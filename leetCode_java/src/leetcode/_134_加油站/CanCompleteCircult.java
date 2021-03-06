package leetcode._134_加油站;

import java.util.Arrays;

public class CanCompleteCircult {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //剪枝，去除不可能的情况
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        //找到能开始的节点
        //从第一个负数的加油站的下一个开始判定
        int[] remaining = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            remaining[i] = gas[i] - cost[i];
        }
        int start = -1;
        while (++start < gas.length && remaining[start] >= 0) {
        }
        int result = start % gas.length;
        for (int i = 0, remain = 0; i < cost.length; i++, start++) {
            remain += remaining[start % cost.length];
            if (remain < 0) {
                result = (start + 1) % cost.length;
                remain = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CanCompleteCircult canCompleteCircult = new CanCompleteCircult();
        int i = canCompleteCircult.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1});
        System.out.println(i);
    }
}
