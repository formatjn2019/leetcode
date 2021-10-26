package leetcode._32_最长有效括号;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int leftCount = 0, rightCount = 0;
            for (int j = i; j < chars.length && rightCount <= leftCount; j++) {
                if (chars[j] == '(') {
                    leftCount++;
                } else {
                    rightCount++;
                }
                if (leftCount == rightCount && leftCount > max) {
                    max = leftCount;
                }
            }
        }
        return max * 2;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        longestValidParentheses.longestValidParentheses(")()((())))(()((())(()(())");
    }
}
