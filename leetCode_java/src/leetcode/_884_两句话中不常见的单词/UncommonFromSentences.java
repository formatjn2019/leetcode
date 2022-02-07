package leetcode._884_两句话中不常见的单词;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        return Stream.concat(Arrays.stream(s1.split(" ")), Arrays.stream(s2.split(" ")))
                .filter(str -> str.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
