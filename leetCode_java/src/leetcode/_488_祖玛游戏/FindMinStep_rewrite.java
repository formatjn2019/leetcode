
package leetcode._488_祖玛游戏;

import java.util.HashSet;
import java.util.Set;


public class FindMinStep_rewrite {
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
        //标记二字母替换
        boolean findFlag = false;
        //如果有加入一个能消除的，进行消除
        for (Character type : types) {
            String searchStr = "" + type + type;
            if (board.contains(searchStr)) {
                //找出索引
                for (int start = 0; ; start = start + 1) {
                    start = board.indexOf(searchStr, start);
                    if (start != -1) {
                        findFlag = true;

                        StringBuilder sb = new StringBuilder(board);
                        sb.delete(start, start + 2);
                        //删除因此引起的其它可消除字符串
                        String newBoard = sb.toString();
                        while (true) {
                            String newStr = newBoard.replaceAll("R{3,}|Y{3,}|B{3,}|G{3,}|W{3,}", "");
                            if (newStr.length() == newBoard.length()) {
                                break;
                            } else {
                                newBoard = newStr;
                            }
                        }

                        //进行下一层判定
                        String newHand = hand.replaceFirst(type + "", "");
                        int minStep = findMinStep(newBoard, newHand);
                        if (minStep != -1) {
                            result = Math.min(result, minStep);
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        for (Character type : types) {
            String searchStr = "" + type;
            if (board.contains(searchStr)) {
                //找出索引
                for (int start = 0; ; start = start + 1) {
                    start = board.indexOf(searchStr, start);
                    if (start != -1) {
                        StringBuilder sb = new StringBuilder(board);
                        sb.insert(start, type);
                        //进行下一层判定
                        String newHand = hand.replaceFirst(type + "", "");
                        int minStep = findMinStep(sb.toString(), newHand);
                        if (minStep != -1) {
                            result = Math.min(result, minStep);
                        }
                    } else {
                        break;
                    }
                }
            }

        }

        return result > 5 ? -1 : result + 1;
    }


    public static void main(String[] args) {
        String testStr = "AABBAABBAA";
        FindMinStep_rewrite findMinStep = new FindMinStep_rewrite();
//        System.out.println(findMinStep.findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(findMinStep.findMinStep("WRRBBW", "RB"));
//        System.out.println(findMinStep.findMinStep("G", "GGGGG"));
//        System.out.println(findMinStep.findMinStep("RBYYBBRRB", "YRBGB"));
        System.out.println(findMinStep.findMinStep("WWGWGW", "GWBWR"));
    }
}
