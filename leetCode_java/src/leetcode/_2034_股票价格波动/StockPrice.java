package leetcode._2034_股票价格波动;

import java.util.*;

class StockPrice {
    HashMap<Integer,Integer> items;
    TreeMap<Integer,Integer> nc;
    int cur=0;
    public StockPrice() {
        items=new HashMap<>();
        nc=new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (items.containsKey(timestamp)){
            int tv=items.get(timestamp);
            if (nc.get(tv)>1){
                nc.put(tv,nc.get(tv)-1);
            }else {
                nc.remove(tv);
            }
        }
        System.out.println(nc);
        items.put(timestamp,price);
        nc.put(price,nc.getOrDefault(price,0)+1);
        cur=Math.max(cur,timestamp);
    }

    public int current() {
        return items.get(cur);
    }

    public int maximum() {
        return nc.lastKey();
    }

    public int minimum() {
        return nc.firstKey();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
//        stockPrice.update(2, 2); // 时间戳为 [1] ，对应的股票价格为 [10] 。
//        stockPrice.update(3, 3); // 时间戳为 [1] ，对应的股票价格为 [10] 。
//        stockPrice.update(4, 4); // 时间戳为 [1] ，对应的股票价格为 [10] 。
//        stockPrice.update(1, 1); // 时间戳为 [1] ，对应的股票价格为 [10] 。
//
//        stockPrice.update(6, 6); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        System.out.println(stockPrice.maximum());     // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        System.out.println(stockPrice.minimum());    // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }

}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */