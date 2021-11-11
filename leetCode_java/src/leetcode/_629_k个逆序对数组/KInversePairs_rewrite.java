package leetcode._629_k个逆序对数组;

import leetcode.Tools;

public class KInversePairs_rewrite {
    public int kInversePairs(int n, int k) {
        //卫语句
        if (k == 0) {
            return 1;
        }
        //前缀和，滑动窗口优化
        int[][] judgeArray = new int[2][k + 1];
        judgeArray[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            long preSum = 0;
            for (int j = 0; j <= k; j++) {
                //只累加当前行长度的数量
                preSum += j >= i ? judgeArray[(i + 1)%2][j] - judgeArray[(i + 1)%2][j - i] : judgeArray[(i + 1)%2][j];
                //防止负数出现导致计算结果出错
                preSum = (preSum + 1000000007) % 1000000007;
                judgeArray[i%2][j] = (int) preSum;
            }
        }
//        Tools.showArray(judgeArray);
        return judgeArray[n%2][k];
    }


    public static void main(String[] args) {
        KInversePairs_rewrite kInversePairs = new KInversePairs_rewrite();
//        IntStream.range(1,11)
//                .forEach(i-> kInversePairs.kInversePairs(i,10));
        System.out.println(kInversePairs.kInversePairs(1000, 1000));
        System.out.println(kInversePairs.kInversePairs(10, 10));

    }

}
