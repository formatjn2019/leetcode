package leetcode._390_消除游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LastRemaining {
    public int lastRemaining(int n) {
        //数学模拟
        int start=1,lenth=n,step=1;
        while (lenth>1){
            //左->右
            start+=step;
            step*=2;
            lenth/=2;
            //右->左
            if (lenth>1 && lenth%2==1){
                start+=step;
            }
            lenth/=2;
            step*=2;
        }
//        System.out.println(start);
        return start;
    }

    public void test(int n){
        LastRemaining_timeout lastRemaining_timeout = new LastRemaining_timeout();
        LastRemaining lastRemaining = new LastRemaining();
        if (lastRemaining.lastRemaining(n)!=lastRemaining_timeout.lastRemaining(n)){
            System.out.println("算错了");
        }
    }
    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        lastRemaining.lastRemaining(20);
        lastRemaining.lastRemaining(21);
        IntStream.range(1,100)
                .peek(i-> System.out.print(i+"\t"))
                .forEach(lastRemaining::test);
    }
}
