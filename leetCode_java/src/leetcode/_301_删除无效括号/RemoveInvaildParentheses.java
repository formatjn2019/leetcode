package leetcode._301_删除无效括号;
import java.util.*;

public class RemoveInvaildParentheses {
    public List<String> removeInvalidParentheses(String s) {
        //转数组
        char[] chars = s.toCharArray();
        ArrayList<Boolean> deleteds = new ArrayList<>(s.length());
        //非()的字符进行标记
        for (int i = 0; i < s.length(); i++) {
            deleteds.add(chars[i] != '(' && chars[i] != ')');
        }
        return new ArrayList<>(removeInvalidParentheses(chars, Set.of(deleteds)));
    }

    public Set<String> removeInvalidParentheses(char[] chars, Set<ArrayList<Boolean>> deleteds) {
        Set<ArrayList<Boolean>> nextLevel = new HashSet<>();
        for (ArrayList<Boolean> deleted : deleteds) {
            //BFS搜索，从最左边的左括号开始匹配右括号，同时更新最大深度
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' && !deleted.get(i)) {
                    for (int j = i + 1; j < chars.length; j++) {
                        if (chars[j] == ')' && !deleted.get(j)) {
                            deleted.set(i, true);
                            deleted.set(j, true);
                            nextLevel.add(new ArrayList<>(deleted));
                            deleted.set(i, false);
                            deleted.set(j, false);
                        }
                    }
                }
            }
        }

        //当匹配与最大深度相同的字符串，将结果加入集合
        if (nextLevel.size() == 0) {
            Set<String> result = new HashSet<>();
            for (ArrayList<Boolean> deleted : deleteds) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < chars.length; i++) {
                    if (deleted.get(i)) {
                        sb.append(chars[i]);
                    }
                }
                result.add(sb.toString());
            }
            return result;
        } else {
            return removeInvalidParentheses(chars, nextLevel);
        }
    }
}
