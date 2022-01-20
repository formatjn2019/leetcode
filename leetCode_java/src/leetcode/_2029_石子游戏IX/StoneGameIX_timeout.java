package leetcode._2029_石子游戏IX;

import java.util.HashMap;
import java.util.Map;

public class StoneGameIX_timeout {
    public boolean stoneGameIX(int[] stones) {
        return DFSSearch(true, new boolean[stones.length], stones, 0, 0, new HashMap<>());
    }

    private boolean DFSSearch(boolean player, boolean[] used, int[] stones, int sums, int depth, Map<String, Boolean> memory) {
        if (sums != 0 && sums % 3 == 0) {
            return player;
        } else if (depth == used.length) {
            return false;
        }
        boolean result = !player;
        for (int i = 0; i < stones.length; i++) {
            //石子没有使用过
            if (!used[i]) {
                used[i] = true;
                String str = arrToString(used);
                //未计算，开始计算
                memory.putIfAbsent(str, DFSSearch(!player, used, stones, sums + stones[i], depth + 1, memory));

                result = memory.get(str);
                used[i] = false;
                if (result == player) {
                    break;
                }

            }
        }
        return result;
    }

    private String arrToString(boolean[] arr) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : arr) {
            sb.append(b ? 1 : 0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StoneGameIX_timeout stoneGameIX = new StoneGameIX_timeout();
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2, 1}));
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2}));
        System.out.println(stoneGameIX.stoneGameIX(new int[]{5, 1, 2, 4, 3}));
    }
}
