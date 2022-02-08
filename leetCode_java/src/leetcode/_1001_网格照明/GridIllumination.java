package leetcode._1001_网格照明;

import leetcode.Tools;

import java.util.*;

public class GridIllumination {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> lineLight = new HashMap<>();
        Map<Integer, Integer> rowLight = new HashMap<>();
        Map<Integer, Integer> diagonal1 = new HashMap<>();
        Map<Integer, Integer> diagonal2 = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            if (lampSet.add((((long) x) << 32) + y)) {
                //x
                rowLight.put(x, rowLight.getOrDefault(x, 0) + 1);
                //y
                lineLight.put(y, lineLight.getOrDefault(y, 0) + 1);
                //b1=y-x
                diagonal1.put(y - x, diagonal1.getOrDefault(y - x, 0) + 1);
                //b2=y+x
                diagonal2.put(y + x, diagonal2.getOrDefault(y + x, 0) + 1);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            //在明亮的线上
            if (lineLight.containsKey(y) || rowLight.containsKey(x) || diagonal1.containsKey(y - x) || diagonal2.containsKey(y + x)) {
                //明亮
                result[i] = 1;
            }
            //关灯
            for (int ti = 0; ti < 3; ti++) {
                for (int tj = 0; tj < 3; tj++) {
                    int tx = ti + x - 1, ty = tj - 1 + y;
                    long key = (((long) tx) << 32) + ty;
                    if (lampSet.contains(key)) {
//                        System.out.println(tx + "--" + ty);
                        if (lineLight.get(ty) == 1) {
                            lineLight.remove(ty);
                        } else {
                            lineLight.put(ty, lineLight.get(ty) - 1);
                        }
                        if (rowLight.get(tx) == 1) {
                            rowLight.remove(tx);
                        } else {
                            rowLight.put(tx, rowLight.get(tx) - 1);
                        }
                        if (diagonal1.get(ty - tx) == 1) {
                            diagonal1.remove(ty - tx);
                        } else {
                            diagonal1.put(ty - tx, diagonal1.get(ty - tx) - 1);
                        }
                        if (diagonal2.get(ty + tx) == 1) {
                            diagonal2.remove((ty + tx));
                        } else {
                            diagonal2.put((ty + tx), diagonal2.get((ty + tx)) - 1);
                        }
                        //关掉的灯从灯的集合中移除
                        lampSet.remove(key);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GridIllumination gridIllumination = new GridIllumination();
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(5, Tools.parseArray("[[0,0],[4,4]]"), Tools.parseArray("[[1,1],[1,0]]"))));
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(5, Tools.parseArray("[[0,0],[4,4]]"), Tools.parseArray("[[1,1],[1,1]]"))));
//        System.out.println(Arrays.toString(gridIllumination.gridIllumination(5, Tools.parseArray("[[0,0],[4,4]]"), Tools.parseArray("[[0,4],[0,1],[1,4]]"))));
        System.out.println(Arrays.toString(gridIllumination.gridIllumination(6, Tools.parseArray("[[2,5],[4,2],[0,3],[0,5],[1,4],[4,2],[3,3],[1,0]]"), Tools.parseArray("[[4,3],[3,1],[5,3],[0,5],[4,4],[3,3]]"))));
    }
}
