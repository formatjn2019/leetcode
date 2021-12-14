package leetcode._630_课程表III;

import leetcode.Tools;

import java.util.*;
import java.util.stream.Collectors;

public class ScheduleCourse {
    public int scheduleCourse(int[][] courses) {
        int spendTime = 0;
        //数组排序
        List<int[]> collect = Arrays.stream(courses)
                .sorted(Comparator.comparingInt(arr -> arr[1]))
                .collect(Collectors.toList());
        PriorityQueue<Integer> items=new PriorityQueue<>((i1,i2)->i2-i1);
        for (int[] course : collect) {
            spendTime+=course[0];
            items.add(course[0]);
            if (spendTime>course[1]){
                spendTime-=items.poll();
            }
        }
        System.out.println(items);
        return items.size();
    }

    public static void main(String[] args) {
        ScheduleCourse scheduleCourse = new ScheduleCourse();
        scheduleCourse.scheduleCourse(Tools.parseArray("[[7,11],[1,11],[1,3],[2,6],[5,6],[7,7],[4,8],[2,20],[1,17],[8,11]]"));
        scheduleCourse.scheduleCourse(Tools.parseArray("[[5,8],[1,2],[1,3],[2,4],[9,100]]")); //5
        scheduleCourse.scheduleCourse(Tools.parseArray("[[5,15],[3,19],[6,7],[2,10],[5,16],[8,14],[10,11],[2,19]]")); //5
    }
}
