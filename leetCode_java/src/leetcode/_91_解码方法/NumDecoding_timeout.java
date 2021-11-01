package leetcode._91_解码方法;

import java.util.Map;

public class NumDecoding_timeout {
    public int numDecodings(String s) {
        //        System.out.println(avaliable);
        return isAvaliable(s.toCharArray(), 0, s.length());
    }

    public int isAvaliable(char[] chars, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }
        int result = 0;
        //当前值
        if (chars[end - 1] != '0') {
            result += isAvaliable(chars, start, end - 1);
        }
        if (end - 2 >= 0 && (chars[end - 2] == '1' || (chars[end - 2] == '2' && (chars[end - 1] < '7')))) {
            result += isAvaliable(chars, start, end - 2);
        }
        return result;
    }


    public static void main(String[] args) {
        Map<String, Integer> testMap = Map.of(
                "1", 1
                , "11", 2
                , "111", 3
                , "1111", 5
                , "11111", 8
                , "301", 0
                , "226", 3
        );

        NumDecoding_timeout numDecoding = new NumDecoding_timeout();
        testMap.keySet().stream()
                .map(key -> Map.entry(key, numDecoding.numDecodings(key)))
                .filter(entry -> !entry.getValue().equals(testMap.get(entry.getKey())))
                .forEach(System.out::println);
    }
}
