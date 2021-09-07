package leetcode._57_插入区间;

import java.util.ArrayList;
import java.util.Arrays;

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> results = new ArrayList<>();
        boolean merged=false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                results.add(intervals[i]);
            } else {
                //判定合并
                merged=true;
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

                while (i < intervals.length && intervals[i][0]<=newInterval[1]) {
                    newInterval[1]=Math.max(newInterval[1],intervals[i++][1]);
                }
                results.add(newInterval);
                while (i<intervals.length){
                    results.add(intervals[i++]);
                }
                break;
            }
        }
        if (!merged){
            results.add(newInterval);
        }
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] insert1 = insert.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        System.out.println(Arrays.deepToString(insert1));
    }
}
