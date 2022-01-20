package leetcode._2029_石子游戏IX;

import java.util.HashMap;
import java.util.Map;

public class StoneGameIX {
    public boolean stoneGameIX(int[] stones) {
        int []numcount=new int[3];
        for (int stone : stones) {
            numcount[stone%3]++;
        }
        return numcount[0]%2==0? Math.min(numcount[1], numcount[2]) != 0 : Math.abs(numcount[1] - numcount[2]) > 2;
    }
    public static void main(String[] args) {
        StoneGameIX stoneGameIX = new StoneGameIX();
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2, 1}));
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2}));
        System.out.println(stoneGameIX.stoneGameIX(new int[]{5, 1, 2, 4, 3}));
    }
}
