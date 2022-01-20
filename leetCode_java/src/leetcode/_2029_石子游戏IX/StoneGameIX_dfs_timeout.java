
package leetcode._2029_石子游戏IX;

public class StoneGameIX_dfs_timeout {
    public boolean stoneGameIX(int[] stones) {
        return DFSSearch(true, new boolean[stones.length], stones, 0, 0);
    }

    private boolean DFSSearch(boolean player, boolean[] used, int[] stones, int sums, int depth) {
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
                //未计算，开始计算
                result=DFSSearch(!player, used, stones, sums + stones[i], depth + 1);
                used[i] = false;
                if (result == player) {
                    break;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        StoneGameIX_dfs_timeout stoneGameIX = new StoneGameIX_dfs_timeout();
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2, 1}));
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2}));
        System.out.println(stoneGameIX.stoneGameIX(new int[]{5, 1, 2, 4, 3}));
    }
}
