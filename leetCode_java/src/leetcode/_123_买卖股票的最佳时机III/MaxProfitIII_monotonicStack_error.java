package leetcode._123_买卖股票的最佳时机III;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxProfitIII_monotonicStack_error {
    public int maxProfit(int[] prices) {
        //单增栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int resultItem = 0;
        ArrayList<Integer> results = new ArrayList<>();
        int[] ints = Arrays.copyOf(prices, prices.length + 1);
        ints[prices.length] = -1;
        for (int price : ints) {
            while (!stack.isEmpty() && stack.getFirst() > price) {
                resultItem = Math.max(resultItem, -stack.getLast() + stack.pop());
            }
            if (resultItem != 0 && stack.isEmpty()) {
                results.add(resultItem);
                resultItem = 0;
            }
            stack.push(price);
        }
        return results.stream()
                .sorted()
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        MaxProfitIII_monotonicStack_error maxProfitIII = new MaxProfitIII_monotonicStack_error();
        int i = maxProfitIII.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
    }
}
