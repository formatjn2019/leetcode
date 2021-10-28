package leetcode._301_删除无效括号;

import java.util.*;

public class RemoveInvaildParentheses_timeout {
    public List<String> removeInvalidParentheses(String s) {
        //转数组
        char[] chars = s.toCharArray();
        boolean[] deleteds = new boolean[s.length()];
        //非()的字符进行标记
        for (int i=0;i<s.length();i++){
            if (chars[i]!='(' && chars[i]!=')'){
                deleteds[i]=true;
            }
        }
        return new ArrayList<>(removeInvalidParentheses(chars,deleteds , new int[]{0}, 0));
    }

    public Set<String> removeInvalidParentheses(char[] chars, boolean[] deleted, int[] maxLevel, int level) {
        Set<String> result = new HashSet<>();
        boolean hasNext = false;
        //dfs搜索，从最左边的左括号开始匹配右括号，同时更新最大深度
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' && !deleted[i]) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == ')' && !deleted[j]) {
                        hasNext = true;
                        deleted[i] = true;
                        deleted[j] = true;
                        maxLevel[0] = Math.max(maxLevel[0], level + 1);
                        result.addAll(removeInvalidParentheses(chars, deleted, maxLevel, level + 1));
                        deleted[i] = false;
                        deleted[j] = false;
                    }
                }
            }
        }
        //当匹配与最大深度相同的字符串，将结果加入集合
        if (!hasNext && level == maxLevel[0]) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (deleted[i]) {
                    sb.append(chars[i]);
                }
            }
            return Set.of(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveInvaildParentheses_timeout removeInvaildParentheses = new RemoveInvaildParentheses_timeout();
        List<String> res = removeInvaildParentheses.removeInvalidParentheses(")(");
        System.out.println(res);
    }

}
