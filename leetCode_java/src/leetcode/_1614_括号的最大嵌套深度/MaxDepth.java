package leetcode._1614_括号的最大嵌套深度;

import java.util.ArrayDeque;

public class MaxDepth {
    public int maxDepth(String s) {
        int result = 0;
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                result = Math.max(result, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return result;
    }
}
