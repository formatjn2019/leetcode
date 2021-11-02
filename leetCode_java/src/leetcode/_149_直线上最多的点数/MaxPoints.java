package leetcode._149_直线上最多的点数;

import leetcode.Tools;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class MaxPoints {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        double MAX_KEY = Double.MAX_VALUE;
        Map<List<Double>, Set<int[]>> liners = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                //纵坐标相同
                if (points[i][1] == points[j][1]) {
                    liners.computeIfAbsent(List.of(MAX_KEY, (double) points[i][1]), _t -> new HashSet<>())
                            .addAll(List.of(points[i], points[j]));
                } else if (points[i][0] == points[j][0]) {
                    liners.computeIfAbsent(List.of(0.0, (double) points[i][0]), _t -> new HashSet<>())
                            .addAll(List.of(points[i], points[j]));
                }
                //计算斜线
                else {
                    double k = ((double) (points[i][1] - points[j][1])) / (points[i][0] - points[j][0]);
                    double b = points[i][1] - k * points[i][0];
                    liners.computeIfAbsent(List.of(k, b), _t -> new HashSet<>())
                            .addAll(List.of(points[i], points[j]));
                }
            }
        }
        List<Map.Entry<List<Double>, Set<int[]>>> collect = liners.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 4)
                .collect(Collectors.toList());
        collect.stream()
                .peek(item -> System.out.println(item.getValue().size()))
                .map(item -> item.getKey() + "\n" + item.getValue().stream().map(Arrays::toString).collect(Collectors.toList()))
                .forEach(System.out::println);

        return liners.values().stream()
                .mapToInt(Set::size)
                .max()
                .orElse(2);
    }

    public static void main(String[] args) {
        int[][] testArray = Tools.parseArray("[[7,3],[19,19],[-16,3],[13,17],[-18,1],[-18,-17],[13,-3],[3,7],[-11,12],[7,19],[19,-12],[20,-18],[-16,-15],[-10,-15],[-16,-18],[-14,-1],[18,10],[-13,8],[7,-5],[-4,-9],[-11,2],[-9,-9],[-5,-16],[10,14],[-3,4],[1,-20],[2,16],[0,14],[-14,5],[15,-11],[3,11],[11,-10],[-1,-7],[16,7],[1,-11],[-8,-3],[1,-6],[19,7],[3,6],[-1,-2],[7,-3],[-6,-8],[7,1],[-15,12],[-17,9],[19,-9],[1,0],[9,-10],[6,20],[-12,-4],[-16,-17],[14,3],[0,-1],[-18,9],[-15,15],[-3,-15],[-5,20],[15,-14],[9,-17],[10,-14],[-7,-11],[14,9],[1,-1],[15,12],[-5,-1],[-17,-5],[15,-2],[-12,11],[19,-18],[8,7],[-5,-3],[-17,-1],[-18,13],[15,-3],[4,18],[-14,-15],[15,8],[-18,-12],[-15,19],[-9,16],[-9,14],[-12,-14],[-2,-20],[-3,-13],[10,-7],[-2,-10],[9,10],[-1,7],[-17,-6],[-15,20],[5,-17],[6,-6],[-11,-8]]");
        MaxPoints maxPoints = new MaxPoints();
        System.out.println(maxPoints.maxPoints(testArray));

    }
}
