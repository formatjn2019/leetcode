package leetcode._22_括号生成;

import java.util.*;

public class BracketGeneration {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        if (n == 1) {
            return List.of("()");
        }
        HashMap<Integer, Set<String>> preMap = new HashMap<>(Map.of(0, Set.of("")));
        for (int i = 1; i < n; i++) {
            preMap.put(i, generateItemSet(preMap, i));
        }
        return new ArrayList<>(generateItemSet(preMap, n));
    }
    //生成 num对括号
    public Set<String> generateItemSet(Map<Integer, Set<String>> preGenerate, int num) {
        Set<String> result = new HashSet<>();
        //根据已知的生成完成的括号进行重新组合
        for (int i = 1; i < num; i++) {
            for (String sp : preGenerate.get(i)) {
                for (String se : preGenerate.get(num - i)) {
                    result.add(sp + se);
                }
            }
        }
        //组合中是不会包含用()将n-1包括的，所以手动增加
        preGenerate.get(num - 1).stream()
                .map(s -> "(" + s + ")")
                .forEach(result::add);
        return result;
    }

    public boolean test(int nums, String[] expect) {
        List<String> result = generateParenthesis(nums);
        Arrays.sort(expect);
        System.out.println(result);
        Object[] resultArr = result.toArray();
        Arrays.sort(resultArr);
        System.out.println(Arrays.toString(resultArr));
        System.out.println(Arrays.toString(expect));
        System.out.println(result.size() + "--->" + expect.length);
        boolean passed = Arrays.toString(resultArr).equals(Arrays.toString(expect));

        if (!passed) {
            System.out.println("失败");
            System.out.println(nums);
            System.out.println("结果:" + Arrays.toString(resultArr) + "\t期望\t：" + Arrays.toString(expect));
        } else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        BracketGeneration bracketGeneration = new BracketGeneration();
//        System.out.println(bracketGeneration.generateParenthesis(2));
        bracketGeneration.test(1, new String[]{"()"});
        bracketGeneration.test(2, new String[]{"(())", "()()"});
        bracketGeneration.test(3, new String[]{"((()))", "(()())", "(())()", "()()()", "()(())"});
        bracketGeneration.test(4, new String[]{"(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"});

    }

}