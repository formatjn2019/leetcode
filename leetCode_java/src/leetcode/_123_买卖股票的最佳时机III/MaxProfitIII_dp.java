package leetcode._123_买卖股票的最佳时机III;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxProfitIII_dp {
    public int maxProfit(int[] prices) {
        int[][][] judgeArray = new int[prices.length][2][3];
        judgeArray[0][1][0] = -prices[0];
        judgeArray[0][0][1] = judgeArray[0][1][1] = -10000;//不可能
        judgeArray[0][0][2] = judgeArray[0][1][2] = -10000;//不可能
        for (int i = 1; i < judgeArray.length; i++) {
            // 未持有
            // 0 0 没买入
            // 0 1 卖出1
            judgeArray[i][0][1] = Math.max(judgeArray[i - 1][1][0] + prices[i], judgeArray[i - 1][0][1]);
            // 0 2 卖出2
            judgeArray[i][0][2] = Math.max(judgeArray[i - 1][1][1] + prices[i], judgeArray[i - 1][0][2]);
            // 持有
            // 1 0 买入1
            judgeArray[i][1][0] = Math.max(judgeArray[i - 1][1][0], -prices[i]);
            // 1 1 买入2
            judgeArray[i][1][1] = Math.max(judgeArray[i - 1][1][1], judgeArray[i - 1][0][1] - prices[i]);
            // 1 2
        }
        Arrays.stream(judgeArray)
                .map(Arrays::deepToString)
                .forEach(System.out::println);
        return Math.max(0, Math.max(judgeArray[judgeArray.length - 1][0][1], judgeArray[judgeArray.length - 1][0][2]));
    }

    public int maxProfitDP(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[][][] dp = new int[prices.length][2][3];
        int MIN_VALUE = Integer.MIN_VALUE / 2;//因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
        //初始化
        dp[0][0][0] = 0;//第一天休息
        dp[0][0][1] = dp[0][1][1] = MIN_VALUE;//不可能
        dp[0][0][2] = dp[0][1][2] = MIN_VALUE;//不可能
        dp[0][1][0] = -prices[0];//买股票
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][1][2] = MIN_VALUE;
        }
        Arrays.stream(dp)
                .map(Arrays::deepToString)
                .forEach(System.out::println);
        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
    }

    public static void main(String[] args) {
        MaxProfitIII_dp maxProfitIII = new MaxProfitIII_dp();
        int i = maxProfitIII.maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7});
        int i2 = maxProfitIII.maxProfitDP(new int[]{2, 1, 4, 5, 2, 9, 7});
        System.out.println(i);
        System.out.println(i2);
    }
}
