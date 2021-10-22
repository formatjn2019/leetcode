package leetcode._17_电话号码的字母组合;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }
        int arraySize = 1;
        //用二维数组提前写出所有按键对应的字母
        char[][] numChars = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        for (int i = 0; i < digits.length(); i++) {
            arraySize *= numChars[(digits.charAt(i) - '2')].length;
        }
        char[][] results = new char[arraySize][digits.length()];
        //i 为数字坐标 j 为结果坐标
        for (int i = 0, step = arraySize; i < digits.length(); i++) {
            step /= numChars[(digits.charAt(i) - '2')].length;
            for (int j = 0; j < arraySize; j++) {
                results[j][i] = numChars[digits.charAt(i) - '2'][(j / step) % numChars[(digits.charAt(i) - '2')].length];
            }
        }
//        Arrays.stream(results).forEach(arr-> System.out.println(Arrays.toString(arr)));
//        System.out.println(Arrays.toString(numArr));
//        System.out.println(arraySize);
        return Arrays.stream(results).map(String::new).collect(Collectors.toList());
    }

    public boolean test(String digits, List<String> expect) {
        List<String> result = letterCombinations(digits);
        boolean passed = true;
        if (expect.size() != result.size()) {
            passed = false;
        }
        HashSet<String> strings = new HashSet<>(expect);
        List<String> collect = result.stream().filter(strings::add).collect(Collectors.toList());
        if (collect.size() > 0) {
            passed = false;
        }
        if (!passed) {
            System.out.println("失败");
            System.out.println(digits);
            System.out.println("结果:" + result + "\t期望\t：" + expect);
        } else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        letterCombinations.test("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        letterCombinations.test("", List.of());
        letterCombinations.test("2", List.of("a", "b", "c"));
        letterCombinations.test("7", List.of("p", "q", "r", "s"));
    }
}
