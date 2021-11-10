
package leetcode._488_祖玛游戏;

import java.util.HashSet;
import java.util.Set;


public class FindMinStep {
    public int findMinStep(String board, String hand) {

        if (board.length() == 0) {
            return 0;
        }
        //分类
        Set<Character> types = new HashSet<>();
        for (int i = 0; i < hand.length(); i++) {
            types.add(hand.charAt(i));
        }
        int result = 10;
        //如果有加入一个能消除的，进行消除
        char[] chars = board.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (Character type : types) {
                String nextBoard = board.substring(0, i) + type + board.substring(i);
                //判定是否能清楚结束
                while (true) {
                    String newStr = nextBoard.replaceAll("R{3,}|Y{3,}|B{3,}|G{3,}|W{3,}", "");
                    if (newStr.length() == nextBoard.length()) {
                        break;
                    } else {
                        nextBoard = newStr;
                    }
                }
                int minStep = findMinStep(nextBoard, hand.replaceFirst("" + type, ""));
                if (minStep != -1) {
                    result = Math.min(result, minStep);
                }
            }


            while (i + 1 < chars.length) {
                if (chars[i + 1] == chars[i]) {
                    i++;
                } else {
                    break;
                }
            }
        }
        return result > 5 ? -1 : result + 1;
    }


    public static void main(String[] args) {
        String testStr = "AABBAABBAA";
        FindMinStep findMinStep = new FindMinStep();
        System.out.println(findMinStep.findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(findMinStep.findMinStep("WRRBBW", "RB"));
        System.out.println(findMinStep.findMinStep("G", "GGGGG"));
        System.out.println(findMinStep.findMinStep("RBYYBBRRB", "YRBGB"));
        System.out.println(findMinStep.findMinStep("WWGWGW", "GWBWR"));
    }
}
