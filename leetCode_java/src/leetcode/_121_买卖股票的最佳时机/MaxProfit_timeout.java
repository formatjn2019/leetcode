package leetcode._121_买卖股票的最佳时机;

public class MaxProfit_timeout {
    public int maxProfit(int[] prices) {
        int result=0;
        int [][]judgeArray=new int[prices.length+1][prices.length+1];
        for (int i=1;i<=prices.length;i++){
            for (int j=1;j<i;j++){
                judgeArray[i][j]=prices[i-1]-judgeArray[j][j];
                result=Math.max(result,judgeArray[i][j]);
            }
            judgeArray[i][i]=prices[i-1];
        }
//        Tools.showArray(judgeArray);
//        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        MaxProfit_timeout maxProfit = new MaxProfit_timeout();
        maxProfit.maxProfit(new int[]{7,6,4,3,1});
    }
}
