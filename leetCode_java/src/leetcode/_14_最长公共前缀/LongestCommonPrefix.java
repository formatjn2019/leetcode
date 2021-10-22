package leetcode._14_最长公共前缀;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //卫语句
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        //纵向比较，一次比较一个字符
        outter:
        for (; index < strs[0].length(); index++) {
            char c = strs[0].charAt(index);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == index || strs[j].charAt(index) != c) {
                    break outter;
                }
            }
        }
        return strs[0].substring(0, index);
    }

    public boolean test(String strs[], String expect) {
        String result = longestCommonPrefix(strs);
        boolean passed = result.equals(expect);
        if (!passed) {
            System.out.println("失败");
            System.out.println(Arrays.toString(strs));
            System.out.println("结果:" + result + "\t期望\t：" + expect);
        } else {
            System.out.println("成功");
        }
        return passed;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.test(new String[]{"flower", "flow", "flight"}, "fl");
        longestCommonPrefix.test(new String[]{"dog", "racecar", "car"}, "");
//        longestCommonPrefix.test(new String[]{"flower","flow","flight"},"fl");
//        longestCommonPrefix.test(new String[]{"flower","flow","flight"},"fl");
    }
}
