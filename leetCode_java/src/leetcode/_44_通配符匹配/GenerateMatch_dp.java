package leetcode._44_通配符匹配;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class GenerateMatch_dp {
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] rules = p.toCharArray();
//        System.out.println(s);
//        System.out.println(p);
        boolean[][] judgeArray = new boolean[rules.length + 1][chars.length + 1];
        //初始化二维数组
        judgeArray[0][0]=true;
        for (int i=0;i<rules.length;i++){
            if (rules[i]!='*'){
                break;
            }
            judgeArray[i+1][0]=true;
        }

        for (int ruleIndex = 1; ruleIndex < rules.length+1; ruleIndex++) {
            char rule = rules[ruleIndex-1];
            for (int searchIndex = 1; searchIndex < chars.length+1; searchIndex++) {
                switch (rule) {
                    case '?' -> {
                        //前一个节点是否匹配
                        judgeArray[ruleIndex][searchIndex] = judgeArray[ruleIndex - 1][searchIndex - 1];
                    }
                    case '*' -> {
                        //匹配一个
                        //匹配0个
                        //匹配多个
                        judgeArray[ruleIndex][searchIndex] =
                                (judgeArray[ruleIndex - 1][searchIndex - 1]) ||
                                        (judgeArray[ruleIndex - 1][searchIndex]) ||
                                        (judgeArray[ruleIndex][searchIndex - 1]);
                    }
                    default -> {
                        //当前节点，与前一节点是否符合
                        judgeArray[ruleIndex][searchIndex] = judgeArray[ruleIndex - 1][searchIndex - 1] &&
                                rules[ruleIndex - 1] == chars[searchIndex - 1];
                    }
                }
            }
        }
//        System.out.print("\t");
//        for (char c : chars) {
//            System.out.print(c + "\t\t");
//        }
//        System.out.println("\n");
//        AtomicInteger atomicInteger = new AtomicInteger();
//        Arrays.stream(judgeArray)
//                .map(Arrays::toString)
//                .peek(_t -> {
//                    if (atomicInteger.getAndIncrement()>0) {
////                        System.out.print(rules[atomicInteger.get()-2] + "\t");
//                    }else {
////                        System.out.print(" \t");
//                    }
//                })
//                .forEach(System.out::println);
        return judgeArray[judgeArray.length - 1][judgeArray[judgeArray.length - 1].length - 1];
    }

    public boolean test(String s, String p, boolean expect) {
        boolean match = isMatch(s, p);
        System.out.println(s + "\t|\t" + p + "\t|\t" + match);
        boolean passed = expect == match;
        if (!passed) {
            System.out.println("失败");
            System.out.println("结果:" + passed + "\t期望\t：" + expect);
        } else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        GenerateMatch_dp rm = new GenerateMatch_dp();
        rm.test("aa", "a", false);
        rm.test("aa", "a?", true);
        rm.test("ab", "?*", true);
        rm.test("mississippi", "mis*is*p*?", true);
        rm.test("aab", "*ab", true);
        rm.test("", "*", true);
        rm.test("a", "*", true);
        rm.test("aa", "aaa", false);
        rm.test("abcabczzzde", "*abc???de*", true);
        rm.test("abcabczzzde", "*abc???de*", true);
        rm.test("aabaa", "**b**", true);
    }
}
