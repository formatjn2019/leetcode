package leetcode._407_接雨水II;

import leetcode.Tools;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrapRainWater_timeout {
    public int trapRainWater(int[][] heightMap) {

        int sum = Arrays.stream(heightMap)
                .flatMapToInt(Arrays::stream)
                .sum();

        List<Integer> collect = Arrays.stream(heightMap)
                .flatMapToInt(Arrays::stream)
                .distinct()
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        collect.add(0, 0);
        int totalArea = 0;
        for (int i = 1; i < collect.size(); i++) {
            totalArea += countLevel(heightMap, collect.get(i)) * (collect.get(i) - collect.get(i - 1));
        }
//        System.out.println(totalArea);
//        System.out.println(sum);
        return totalArea-sum;
    }

    public int countLevel(int[][] heightMap, int level) {
        boolean[][] judgeArray = new boolean[heightMap.length][heightMap[0].length];
        for (int i = 0; i < judgeArray.length; i++) {
            for (int j = 0; j < judgeArray[i].length; j++) {
                judgeArray[i][j] = heightMap[i][j] >= level;
            }
        }
        return calclulateArea(judgeArray);
    }

    public int calclulateArea(boolean[][] arr) {
        //并查集
        int height = arr.length, width = arr[0].length;
        int[][] judgeArray = new int[height][width];
        for (int i = 0; i < judgeArray.length; i++) {
            judgeArray[i][0] = arr[i][0] ? 0 : i * width + 1;
            judgeArray[i][width - 1] = arr[i][width - 1] ? 0 : (i + 1) * width;
        }
        //设置坐标
        for (int j = 0; j < width; j++) {
            judgeArray[0][j] = arr[0][j] ? 0 : j + 1;
            judgeArray[height - 1][j] = arr[height - 1][j] ? 0 : (height - 1) * width + j + 1;
        }
        //循环搜索
        boolean continueLoop = true;
        while (continueLoop) {
            continueLoop = false;
            for (int i = 1; i < judgeArray.length - 1; i++) {
                for (int j = 1; j < judgeArray[i].length; j++) {
                    if (!arr[i][j] && judgeArray[i][j] == 0) {
                        if (judgeArray[i - 1][j] != 0 || judgeArray[i + 1][j] != 0 || judgeArray[i][j - 1] != 0 || judgeArray[i][j + 1] != 0) {
                            judgeArray[i][j] = i * width + j + 1;
                            continueLoop = true;
                        }
                    }
                }
            }
        }
        return (int) Arrays.stream(judgeArray)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i == 0)
                .count();
    }

    public static void main(String[] args) {
        TrapRainWater_timeout trapRainWater = new TrapRainWater_timeout();
        int i = trapRainWater.trapRainWater(Tools.parseArray("[[12,13,1,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]"));
        System.out.println(i);
    }
}
