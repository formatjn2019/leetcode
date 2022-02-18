package leetcode._1791_找出星型图的中心节点;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindCenter_stream {
    public int findCenter(int[][] edges) {
        Map<Integer, Long> numCount = Arrays.stream(edges)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return numCount.entrySet().stream()
                .max((e1, e2) -> (int) (e1.getValue() - e2.getValue()))
                .get().getKey();
    }
}
