package leetcode._629_k个逆序对数组;

import leetcode.Tools;
import leetcode._46_全排列.Permute;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class KInversePairs {
    public int kInversePairs(int n, int k) {
        //卫语句
        if (k == 0) {
            return 1;
        }
        //前缀和，滑动窗口
        int[][] judgeArray = new int[n + 1][k + 1];
        judgeArray[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            long preSum = 0;
            for (int j = 0; j <= k; j++) {
                preSum += judgeArray[i - 1][j];
                if (j >= i) {
                    preSum -= judgeArray[i - 1][j - i];
                }
                preSum = (preSum + 1000000007) % 1000000007;
                judgeArray[i][j] = (int) preSum;
            }
        }
        Tools.showArray(judgeArray);
        return judgeArray[n][k];
    }


    public static void main(String[] args) {
        KInversePairs kInversePairs = new KInversePairs();
//        IntStream.range(1,11)
//                .forEach(i-> kInversePairs.kInversePairs(i,10));
        System.out.println(kInversePairs.kInversePairs(10, 20));

    }

}
