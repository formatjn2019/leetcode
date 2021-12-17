package leetcode._1518_换酒问题;

public class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        // 以前喝过的 以前兑换过剩余的酒瓶
        int drinked = 0, remain = 0;
        //还有可能进行兑换酒的情况下，对酒进行兑换
        for (int emptyBottle=numBottles; emptyBottle >= numExchange;emptyBottle=numBottles+remain){
            //喝光
            drinked += numBottles;
            //兑换
            numBottles = emptyBottle / numExchange;
            //兑换后剩余的酒瓶
            remain = emptyBottle % numExchange;
        }
        //以前喝的加上最后一次兑换后的酒
        return drinked+numBottles;
    }

    public static void main(String[] args) {
        NumWaterBottles numWaterBottles = new NumWaterBottles();
        System.out.println(numWaterBottles.numWaterBottles(9, 3));
        System.out.println(numWaterBottles.numWaterBottles(15, 4));
        System.out.println(numWaterBottles.numWaterBottles(5, 5));
        System.out.println(numWaterBottles.numWaterBottles(2, 3));
    }
}
