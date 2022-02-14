package leetcode._1020_飞地的数量;

import leetcode.Tools;

import javax.tools.Tool;
import java.util.*;

public class NumEnclaves {
    public int numEnclaves(int[][] grid) {
        int heigth = grid.length, width = grid[0].length;
        int[][] judge = new int[heigth][width];
        Set<Integer> bounds = new HashSet<>();
        //初始化
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] != 0) {
                    judge[i][j] = i * width + j;
                } else {
                    judge[i][j] = 0;
                }

            }
        }
//        Tools.showArray(grid);
        //连接
        for (int i = 1; i < heigth; i++) {
            for (int j = 1; j < width; j++) {
                if (judge[i][j] != 0) {
                    //自身和左上，取最小值
                    TreeSet<Integer> indexs = new TreeSet<>();
                    if (judge[i - 1][j] != 0) {
                        indexs.add(getHead(judge, i - 1, j));
                    }
                    if (judge[i][j - 1] != 0) {
                        indexs.add(getHead(judge, i, j - 1));
                    }
                    indexs.add(judge[i][j]);
                    Integer first = indexs.first();
                    for (Integer index : indexs) {
                        judge[index / width][index % width] = first;
                    }
                }
            }
        }
        //求值
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                judge[i][j] = getHead(judge, i, j);
                numCount.put(judge[i][j], numCount.getOrDefault(judge[i][j], 0) + 1);
                if (j == 0 || i == 0 || i == heigth - 1 || j == width - 1) {
                    bounds.add(judge[i][j]);
                }
            }
        }
        bounds.add(0);
//        Tools.showArray(judge);
//        System.out.println(bounds);
//        System.out.println(numCount);
//        System.out.println(numCount.entrySet().stream().filter(entry->bounds.contains(entry.getKey())).mapToInt(Map.Entry::getValue).sum());
        return width*heigth-numCount.entrySet().stream().filter(entry->bounds.contains(entry.getKey())).mapToInt(Map.Entry::getValue).sum();
    }

    private int getHead(int[][] judge, int x, int y) {
        int nx = judge[x][y] / judge[0].length, ny = judge[x][y] % judge[0].length;
        return nx == x && ny == y ? judge[x][y] : getHead(judge, nx, ny);
    }

    public static void main(String[] args) {
        NumEnclaves numEnclaves = new NumEnclaves();
        System.out.println(numEnclaves.numEnclaves(Tools.parseArray("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]")));
        System.out.println(numEnclaves.numEnclaves(Tools.parseArray("[[0,0,0,1,1,1,0,1,0,0],[1,1,0,0,0,1,0,1,1,1],[0,0,0,1,1,1,0,1,0,0],[0,1,1,0,0,0,1,0,1,0],[0,1,1,1,1,1,0,0,1,0],[0,0,1,0,1,1,1,1,0,1],[0,1,1,0,0,0,1,1,1,1],[0,0,1,0,0,1,0,1,0,1],[1,0,1,0,1,1,0,0,0,0],[0,0,0,0,1,1,0,0,0,1]]")));
        System.out.println(numEnclaves.numEnclaves(Tools.parseArray("[[0,0,1,1,1,0,1,1,1,0,1],[1,1,1,1,0,1,0,1,1,0,0],[0,1,0,1,1,0,0,0,0,1,0],[1,0,1,1,1,1,1,0,0,0,1],[0,0,1,0,1,1,0,0,1,0,0],[1,0,0,1,1,1,0,0,0,1,1],[0,1,0,1,1,0,0,0,1,0,0],[0,1,1,0,1,0,1,1,1,0,0],[1,1,0,1,1,1,0,0,0,0,0],[1,0,1,1,0,0,0,1,0,0,1]]")));
    }
}
