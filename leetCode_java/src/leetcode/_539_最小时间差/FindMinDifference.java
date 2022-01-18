package leetcode._539_最小时间差;

import java.util.List;

public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        //卫语句，剪枝
        if (timePoints.size()>1440){
            return 0;
        }
        int[] minutes = timePoints.stream()
                .mapToInt(this::changeStr2minute)
                .sorted()
                .toArray();
        //初始为首尾数字差
        int result=minutes[0]+24*60-minutes[minutes.length-1];
        for (int i=1;i<minutes.length;i++){
            result=Math.min(result,minutes[i]-minutes[i-1]);
        }
        return result;
    }
    //将时间字符串转换为当天的第多少分钟
    private int changeStr2minute(String str){
        String[] split = str.split(":");
        return Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        FindMinDifference findMinDifference = new FindMinDifference();
        System.out.println(findMinDifference.findMinDifference(List.of("23:59", "00:00")));
        System.out.println(findMinDifference.findMinDifference(List.of("23:59", "00:00", "23:59")));
    }
}
