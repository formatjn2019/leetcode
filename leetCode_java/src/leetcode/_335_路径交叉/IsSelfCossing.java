package leetcode._335_路径交叉;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsSelfCossing {
    public boolean isSelfCrossing(int[] distance) {
        int currentX = 0, currentY = 0;
        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        boolean increasing = true;
        //行禁止区域
        //纵坐标     横坐标区间
        TreeMap<Integer, List<List<Integer>>> lineProhibit = new TreeMap<>();
        //列禁止区域
        //横坐标     纵坐标区间
        TreeMap<Integer, List<List<Integer>>> rowProhibit = new TreeMap<>();
        for (int i = 0; i < distance.length; i++) {
            int preX = currentX;
            int preY = currentY;
            currentX += dirs[i % 4][0] * distance[i];
            currentY += dirs[i % 4][1] * distance[i];
            if (increasing && i > 0 && distance[i - 1] >= distance[i]) {
                increasing = false;
            }
            //纵向延伸
            if (i % 2 == 0) {
                List<Integer> newLine = List.of(Math.min(preY, currentY), Math.max(preY, currentY));
                //判断是否新线与老线相交
                //横向禁止线判定
                if (!increasing) {
                    //二分搜索
                    for (Integer yPoint : lineProhibit.keySet()) {
                        //老线的延伸是否跟新线相交
                        if (yPoint != preY && yPoint >= newLine.get(0) && yPoint <= newLine.get(1)) {
                            for (List<Integer> integers : lineProhibit.get(yPoint)) {
                                //老线是否与新线相交
                                if (currentX >= integers.get(0) && currentX <= integers.get(1)) {
                                    return true;
                                }
                            }
                        }
                    }
                    //纵向禁止点判定
                    //没有与当前直线重合
                    if (rowProhibit.containsKey(preX)) {
                        for (List<Integer> oldLine : rowProhibit.get(preX)) {
                            if (oldLine.get(0) <= newLine.get(1) && newLine.get(0) <= oldLine.get(1)) {
                                return true;
                            }
                        }
                    }
                }
                rowProhibit.computeIfAbsent(preX, _key -> new ArrayList<>()).add(newLine);

            } //横向延伸
            else {
                List<Integer> newLine = List.of(Math.min(preX, currentX), Math.max(preX, currentX));
                if (!increasing) {
                    //判断是否新线与老线相交
                    for (Integer xPoint : rowProhibit.keySet()) {
                        //老线的延伸是否跟新线相交
                        if (xPoint != preX && xPoint >= newLine.get(0) && xPoint <= newLine.get(1)) {
                            for (List<Integer> integers : rowProhibit.get(xPoint)) {
                                //老线是否与新线相交
                                if (currentY >= integers.get(0) && currentY <= integers.get(1)) {
                                    return true;
                                }
                            }
                        }
                    }
                    //横向向禁止点判定
                    //没有与当前直线重合
                    if (lineProhibit.containsKey(preY)) {
                        for (List<Integer> oldLine : lineProhibit.get(preY)) {
                            if (oldLine.get(0) <= newLine.get(1) && newLine.get(0) <= oldLine.get(1)) {
                                return true;
                            }
                        }
                    }
                }
                lineProhibit.computeIfAbsent(preY, _key -> new ArrayList<>()).add(newLine);

            }
//            System.out.println(currentX + "\t" + currentY);
        }
        System.out.println(lineProhibit);
        System.out.println(rowProhibit);

        return false;
    }


    public static void main(String[] args) {

        IsSelfCossing isSelfCossing = new IsSelfCossing();
        System.out.println(isSelfCossing.isSelfCrossing(new int[]{1, 2, 3, 4}));
        System.out.println(isSelfCossing.isSelfCrossing(new int[]{1, 1, 1, 1}));
        System.out.println(isSelfCossing.isSelfCrossing(new int[]{1, 1, 2, 1, 1}));
        System.out.println(isSelfCossing.isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(isSelfCossing.isSelfCrossing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107}));

    }
}
