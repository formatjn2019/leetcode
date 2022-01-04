package leetcode._390_消除游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LastRemaining_timeout {
    public int lastRemaining(int n) {
        //模拟
        List<Integer> integers = IntStream.range(1, n + 1).boxed().collect(Collectors.toCollection(ArrayList::new));

        while (integers.size()>1){
            //正向,移除奇数位
            for (int index=0;index<integers.size();index++){
                integers.remove(index);
            }
            System.out.println(integers);
            //反向，移除奇数或偶数位置
            for (int index=integers.size()%2==0?1:0;index<integers.size()&&integers.size()>1;index++){
                integers.remove(index);
            }
            System.out.println(integers);
        }
//        System.out.println(integers.get(0));
        return integers.get(0);
    }

    public static void main(String[] args) {
        LastRemaining_timeout lastRemaining = new LastRemaining_timeout();
        lastRemaining.lastRemaining(20);
        lastRemaining.lastRemaining(21);
//        IntStream.range(1,100)
//                .peek(i-> System.out.print(i+"\t"))
//                .forEach(lastRemaining::lastRemaining);
    }
}
