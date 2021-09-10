package leetcode._84_柱状图中最大的矩形;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class LangestRectangleArea_monotonicStack {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i <= heights.length; i++) {
            //比该元素大的出栈
            while (stack.getFirst() != -1  && (i==heights.length || heights[stack.getFirst()] > heights[i])) {
                Integer index = stack.pop();
                result = Math.max(heights[index] * (i - stack.getFirst()-1), result);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LangestRectangleArea_monotonicStack langestRectangleArea = new LangestRectangleArea_monotonicStack();
//        int i = langestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        int i = langestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }
}
