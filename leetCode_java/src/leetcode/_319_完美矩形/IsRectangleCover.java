package leetcode._319_完美矩形;

import leetcode.Tools;

import java.util.*;

public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        //剪枝，并记录扫描线
        HashSet<List<Integer>> lines = new HashSet<>();
        //面积扫描
        int area = 0, minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE, maxy = Integer.MIN_VALUE, maxx = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            area += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
            //扫描线记录，竖线
            List<Integer> ll = List.of(rectangle[0], rectangle[1], rectangle[3], 0), lr = List.of(rectangle[2], rectangle[1], rectangle[3], 1);
            minx = Math.min(minx, rectangle[0]);
            miny = Math.min(miny, rectangle[1]);
            maxx = Math.max(maxx, rectangle[2]);
            maxy = Math.max(maxy, rectangle[3]);
            //有重合的矩形，删除
            if (lines.contains(ll) || lines.contains(lr)) {
                return false;
            }
            lines.add(ll);
            lines.add(lr);
//            System.out.println(ll);
//            System.out.println(lr);
        }
        //面积不符合要求，返回
        if (area != (maxx - minx) * (maxy - miny)) {
            return false;
        }
        Map<Integer, List<List<Integer>>> listMap = new HashMap<>();
        for (List<Integer> line : lines) {
            //将0和1转换为符号
            int key = line.get(0) * (line.get(3) * 2 - 1);
            int ls = line.get(1), le = line.get(2);
            List<List<Integer>> lists = listMap.computeIfAbsent(key, k -> new ArrayList<>());
            //合并区间
            int indertIndex = 0;
            for (; indertIndex < lists.size(); indertIndex++) {
                if (lists.get(indertIndex).get(0) >= le) {
                    break;
                }
            }
            //顶多和左右合并
            if (indertIndex - 1 >= 0 && lists.get(indertIndex - 1).get(1) == ls) {
                ls = lists.get(indertIndex - 1).get(0);
                lists.remove(--indertIndex);
            }
            if (indertIndex < lists.size() && lists.get(indertIndex).get(0) == le) {
                le = lists.get(indertIndex).get(1);
                lists.remove(indertIndex);
            }
            lists.add(indertIndex, List.of(ls, le));
        }
        for (Map.Entry<Integer, List<List<Integer>>> integerListEntry : listMap.entrySet()) {
            if ((integerListEntry.getValue().size() == 1 && (integerListEntry.getKey() == -1 * minx || integerListEntry.getKey() == maxx))
                            || integerListEntry.getValue().equals(listMap.get(-1 * integerListEntry.getKey()))) {
                continue;
            } else {
//                System.out.println(integerListEntry);
//                System.out.println(listMap.get(integerListEntry.getKey()));
//                System.out.println(listMap.get(-1 * integerListEntry.getKey()));
//                System.out.println(listMap.get(integerListEntry.getKey()).equals(listMap.get(-1 * integerListEntry.getKey())));
//                listMap.entrySet().forEach(System.out::println);

                return false;
            }
        }
//        listMap.entrySet().forEach(System.out::println);
        return true;
    }

    public static void main(String[] args) {
        IsRectangleCover isRectangleCover = new IsRectangleCover();
        int[][] ints = Tools.parseArray("[[0,0,4,1],[7,0,8,2],[6,2,8,3],[5,1,6,3],[4,0,5,1],[6,0,7,2],[4,2,5,3],[2,1,4,3],[0,1,2,2],[0,2,2,3],[4,1,5,2],[5,0,6,1]]");
//        System.out.println(isRectangleCover.isRectangleCover(ints));
        ints = Tools.parseArray("[[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]");
        System.out.println(isRectangleCover.isRectangleCover(ints));
        ints = Tools.parseArray("[[1,2,4,4],[1,0,4,1],[0,2,1,3],[0,1,3,2],[3,1,4,2],[0,3,1,4],[0,0,1,1]]");
        System.out.println(isRectangleCover.isRectangleCover(ints));
//        ints = Tools.parseArray("[[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]");
//        System.out.println(isRectangleCover.isRectangleCover(ints));
//        ints = Tools.parseArray("[[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]");
//        System.out.println(isRectangleCover.isRectangleCover(ints));

    }
}
