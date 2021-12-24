package leetcode._1705_吃苹果的最大数目;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class EatenApples_timeout {
    public int eatenApples(int[] apples, int[] days) {
        int length = days.length;
        int result = 0;
        PriorityQueue<Integer> pickedApples = new PriorityQueue<>();
        for (int i = 0; i < length || pickedApples.size() > 0; i++) {
            if (i < length) {
                //每天采苹果放入采集的采好的苹果中
                int apple = i + days[i];
                IntStream.generate(() -> apple)
                        .limit(apples[i])
                        .forEach(pickedApples::add);
            }
            //每天吃一个苹果
            while (pickedApples.size() > 0) {
                int willEat = pickedApples.poll();
                //苹果还能吃,就吃掉，不能吃就继续找下一个
                if (i < willEat) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EatenApples_timeout eatenApples = new EatenApples_timeout();
        System.out.println(eatenApples.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println(eatenApples.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));

    }
}
