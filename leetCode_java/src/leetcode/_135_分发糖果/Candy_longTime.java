package leetcode._135_分发糖果;

import java.util.Arrays;

public class Candy_longTime {
    public int candy(int[] ratings) {
        if (ratings.length < 2) {
            return 1;
        }
        int[] judgeArray = new int[ratings.length];
        Arrays.fill(judgeArray, 1);
        //类似于改进后的冒泡
        boolean changedFlag = true;
        for (int i = 0; i < ratings.length && changedFlag; i++) {
            changedFlag = false;
            if (ratings[0] > ratings[1] && judgeArray[0] <= judgeArray[1]) {
                judgeArray[0]++;
                changedFlag = true;
            }
            for (int j = 1; j < ratings.length - 1; j++) {
                //跟左右两边小朋友比较
                int max = 0;
                if (ratings[j] > ratings[j - 1] && judgeArray[j] <= judgeArray[j - 1]) {
                    changedFlag = true;
                    max = judgeArray[j - 1];
                }
                if (ratings[j] > ratings[j + 1] && judgeArray[j] <= judgeArray[j + 1]) {
                    changedFlag = true;
                    max = Math.max(judgeArray[j + 1], max);
                }
                judgeArray[j] = Math.max(max + 1, judgeArray[j]);
            }
            if (ratings[ratings.length - 1] > ratings[ratings.length - 2] && judgeArray[ratings.length - 1] <= judgeArray[ratings.length - 2]) {
                judgeArray[ratings.length - 1]++;
                changedFlag = true;
            }
        }
        System.out.println(Arrays.toString(judgeArray));
        return Arrays.stream(judgeArray).sum();
    }

    public static void main(String[] args) {
        Candy_longTime candy = new Candy_longTime();
        candy.candy(new int[]{1, 0, 2});
        candy.candy(new int[]{1, 2, 3});
        candy.candy(new int[]{5, 4, 3, 2, 1});
        candy.candy(new int[]{1, 2, 2});
    }
}
