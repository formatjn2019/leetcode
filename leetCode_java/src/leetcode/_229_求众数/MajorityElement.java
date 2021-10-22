package leetcode._229_求众数;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
    //摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
        //二维数组，记录数量最多的两个值
        int[][] results = new int[][]{{1000000000, 0}, {1000000000, 0}};
        //初始化
        for (int num : nums) {
            //num不在数组中，且其中一个计数为0，添加
            if (results[0][1] == 0 && num != results[1][0]) {
                results[0][0] = num;
                results[0][1] = 1;
            } else if (results[1][1] == 0 && num != results[0][0]) {
                results[1][0] = num;
                results[1][1] = 1;
            }
            //num在数组中，次数加一
            else if (results[0][0] == num) {
                results[0][1]++;
            } else if (results[1][0] == num) {
                results[1][1]++;
            }
            //遇到第三个数，三个数都抵消1
            else {
                results[0][1]--;
                results[1][1]--;
            }
        }
        //初始化计数
        results[0][1] = results[1][1] = 0;
        //重新计数
        for (int num : nums) {
            if (num == results[0][0]) {
                results[0][1]++;
            } else if (results[1][0] == num) {
                results[1][1]++;
            }
        }
        double bound = nums.length / 3.0;
        //判定是否超过边界值
        if (results[0][1] > bound) {
            if (results[1][1] > bound) {
                return List.of(results[0][0], results[1][0]);
            }
            return List.of(results[0][0]);
        } else {
            if (results[1][1] > bound) {
                return List.of(results[1][0]);
            }
            return List.of();
        }
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{1,1,2,3,4,1,1,5,6,7,1,1,8,9,10,1,11,12,13,14}));
    }
}
