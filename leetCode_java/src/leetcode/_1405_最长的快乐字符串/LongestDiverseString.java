package leetcode._1405_最长的快乐字符串;

import java.util.ArrayList;

public class LongestDiverseString {
    public String longestDiverseString(int a, int b, int c) {
        String[] result = new String[]{""};
        dfsSearch(result, new StringBuilder(), a, b, c);
        return result[0];
    }

    private void dfsSearch(String[] result, StringBuilder sb, int a, int b, int c) {
        if (sb.length() > result[0].length()) {
            result[0] = sb.toString();
        }
        if (a > 0 && ((sb.length() < 2) || sb.charAt(sb.length() - 1) != sb.charAt(sb.length() - 2) || sb.charAt(sb.length() - 1) != 'a')) {
            sb.append('a');
            dfsSearch(result, sb, a - 1, b, c);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (b > 0 && ((sb.length() < 2) || sb.charAt(sb.length() - 1) != sb.charAt(sb.length() - 2) || sb.charAt(sb.length() - 1) != 'b')) {
            sb.append('b');
            dfsSearch(result, sb, a, b - 1, c);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (c > 0 && ((sb.length() < 2) || sb.charAt(sb.length() - 1) != sb.charAt(sb.length() - 2) || sb.charAt(sb.length() - 1) != 'c')) {
            sb.append('c');
            dfsSearch(result, sb, a, b, c - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LongestDiverseString longestDiverseString = new LongestDiverseString();
        String s = longestDiverseString.longestDiverseString(15, 2, 9);
        System.out.println(s.length());
        System.out.println(s);
    }
}
