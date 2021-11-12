package leetcode._375_猜数字大小;

import leetcode.Tools;

import javax.tools.Tool;

public class GetMoneyAmount {
    public int getMoneyAmount(int n) {
        int[][] judgeArray = new int[n + 1][n + 1];
        for (int i = n; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i < 3) {
                    judgeArray[i][j] = j == i ? 0 : (i + j) / 2;
                }
                else {
                    int minSum = Integer.MAX_VALUE;
                    for (int split = i+1;split<j;split++){
                        minSum=Math.min(minSum,split+Math.max(judgeArray[i][split-1],judgeArray[split+1][j]));
                    }
                    judgeArray[i][j]=minSum;
                }
            }
        }
//        Tools.showArrayWithIndex(judgeArray);
        return judgeArray[1][n];
    }

    public static void main(String[] args) {
        GetMoneyAmount getMoneyAmount = new GetMoneyAmount();
        System.out.println(getMoneyAmount.getMoneyAmount(16));
    }
}
