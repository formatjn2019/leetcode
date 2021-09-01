package leetcode._44_通配符匹配;


public class GenerateMatch_timeLimitExceeded {
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] rules = p.toCharArray();
        if (chars.length==0){
            for (char rule : rules) {
                if (rule!='*'){
                    return false;
                }
            }
            return true;
        }
        return matchChars(chars, 0, rules, 0);
    }

    public boolean matchChars(char[] chars, int searchIndex, char[] rules, int ruleIndex) {
        if (ruleIndex == rules.length || searchIndex == chars.length) {
            for (;ruleIndex<rules.length;ruleIndex++){
                if (rules[ruleIndex]!='*'){
                    return false;
                }
            }
            return ruleIndex == rules.length && searchIndex == chars.length;

        }
        switch (rules[ruleIndex]) {
            case '?' -> {
                return matchChars(chars, searchIndex + 1, rules, ruleIndex + 1);
            }
            case '*' -> {
                // 匹配当前后跳转，匹配当前后不跳转，匹配空字符串
                return matchChars(chars, searchIndex + 1, rules, ruleIndex + 1) ||
                        matchChars(chars, searchIndex + 1, rules, ruleIndex) ||
                        matchChars(chars, searchIndex, rules, ruleIndex + 1);
            }
            default -> {
                return chars[searchIndex] == rules[ruleIndex] && matchChars(chars, searchIndex + 1, rules, ruleIndex + 1);
            }
        }
    }
    public boolean test(String s, String p, boolean expect) {
        boolean match = isMatch(s, p);
        System.out.println(s + "\t|\t" + p + "\t|\t" + match);
        boolean passed=expect == match;
        if (!passed){
            System.out.println("失败");
            System.out.println("结果:"+passed+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        GenerateMatch_timeLimitExceeded rm = new GenerateMatch_timeLimitExceeded();
        rm.test("aa", "a", false);
        rm.test("aa", "a?", true);
        rm.test("ab", "?*", true);
        rm.test("mississippi", "mis*is*p*?", true);
        rm.test("aab", "*ab", true);
        rm.test("", "*", true);
        rm.test("a", "*", true);
        rm.test("aa", "aaa", false);
        rm.test("abcabczzzde", "*abc???de*", true);
    }
}
