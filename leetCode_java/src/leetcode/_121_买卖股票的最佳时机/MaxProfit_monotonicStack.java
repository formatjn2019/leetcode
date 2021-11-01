package leetcode._121_买卖股票的最佳时机;


import java.util.ArrayDeque;

public class MaxProfit_monotonicStack {
    public int maxProfit(int[] prices) {
        //单减栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int price : prices) {
            while (!stack.isEmpty() && stack.getFirst() > price) {
                result = Math.max(result, -stack.getLast() + stack.pop());
            }
            stack.push(price);
        }
        if (!stack.isEmpty()) {
            result = Math.max(result, -stack.getLast() + stack.getFirst());
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        MaxProfit_monotonicStack maxProfit = new MaxProfit_monotonicStack();
        maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
