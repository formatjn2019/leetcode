package leetcode._122_买卖股票的最佳时机II;

public class MaxProfitII {
    public int maxProfit(int[] prices) {
        int result = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (pre <= prices[i]) {
                result += prices[i] - pre;
            }
            pre = prices[i];
        }
        return Math.max(result, 0);
    }
}
