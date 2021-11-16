package leetcode._319_灯泡开关;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BulbSwitch {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        BulbSwitch bulbSwitch = new BulbSwitch();
        IntStream.range(1,100)
                .peek(i-> System.out.print(i+"\t"))
                .map(bulbSwitch::bulbSwitch)
                .forEach(System.out::println);
    }
}
