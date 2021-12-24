package leetcode._1705_吃苹果的最大数目;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        int length = days.length;
        int result = 0;
        //存储日期和数量
        PriorityQueue<List<Integer>> pickedApples = new PriorityQueue<>((l1, l2) -> l1.get(0) - l2.get(0));
//        pickedApples.add(List.of(1,2));
        for (int i = 0; i < length || pickedApples.size() > 0; i++) {
            if (i < length) {
                //每天采苹果放入采集的采好的苹果中
//                System.out.println(List.of(i + days[i],apples[i]));
                pickedApples.add(List.of(i + days[i], apples[i]));
            }
            //每天吃一个苹果
            while (pickedApples.size() > 0) {
                List<Integer> willEat = pickedApples.poll();
                //苹果还能吃,就吃掉，不能吃就继续找下一个
                if (i < willEat.get(0) && willEat.get(1) > 0) {
                    result++;
                    //没吃完再放回去
                    if (willEat.get(1) > 1) {
                        pickedApples.add(List.of(willEat.get(0), willEat.get(1) - 1));
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EatenApples eatenApples = new EatenApples();
        System.out.println(eatenApples.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println(eatenApples.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));

    }
}
