package leetcode._32_最长有效括号;

public class LongestValidParentheses_outLimitMemory {
    public int longestValidParentheses(String s) {
        if (s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[][] currectArray = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            int leftCount = 0, rightCount = 0;
            for (int j = i; j < chars.length; j++) {
                if (rightCount > leftCount) {
                    currectArray[i][j] = i > 0 ? Math.max(currectArray[i][j - 1], currectArray[i - 1][j]) : currectArray[i][j - 1];
                    continue;
                }
                if (chars[j] == '(') {
                    leftCount++;
                } else {
                    rightCount++;
                }
                if (leftCount == rightCount) {
                    currectArray[i][j] = i > 0 ? Math.max(currectArray[i - 1][j], leftCount) : leftCount;
                } else {
                    currectArray[i][j] = i > 0 ? Math.max(currectArray[i - 1][j], currectArray[i][j - 1]) : (j > 0 ? currectArray[i][j - 1] : 0);
                }
            }
        }
//        for (int[] ints : currectArray) {
//            System.out.println(Arrays.toString(ints));
//        }
        return currectArray[chars.length - 1][chars.length - 1] * 2;
    }

    public static void main(String[] args) {
        LongestValidParentheses_outLimitMemory longestValidParentheses = new LongestValidParentheses_outLimitMemory();
        longestValidParentheses.longestValidParentheses(")()((())))(()((())(()(())");
    }
}
