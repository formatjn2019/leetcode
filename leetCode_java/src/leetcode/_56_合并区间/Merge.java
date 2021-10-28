package leetcode._56_合并区间;

import java.util.Arrays;
import java.util.Comparator;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        boolean[] merged = new boolean[intervals.length];
        int newSize = intervals.length;
        for (int i = 0; i < intervals.length; ) {
            int j = i + 1;
            for (; j < intervals.length; j++) {
                //i,j合并
                if (intervals[i][1] >= intervals[j][0] && !merged[j]) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    merged[j] = true;
                    newSize--;
                } else {
                    break;
                }
            }
            i = j;
        }
        int[][] result = new int[newSize][];
        for (int i = 0, index = 0; i < intervals.length; i++) {
            if (!merged[i]) {
                result[index++] = intervals[i];
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[][]{{1, 4}, {0, 4}});
        merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
