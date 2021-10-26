package leetcode._38_外观数列;

import java.util.stream.IntStream;

public class CountAndSay {
    public String countAndSay(int n) {
        //卫语句
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String preStr = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = preStr.toCharArray();
        int count = 0;
        char preChar = '\0';
        for (char aChar : chars) {
            if (count == 0) {
                count++;
                preChar = aChar;
            } else if (preChar == aChar) {
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(preChar);
                count = 1;
                preChar = aChar;
            }
        }
        if (count > 0) {
            stringBuilder.append(count);
            stringBuilder.append(preChar);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        IntStream.range(1, 10)
                .mapToObj(countAndSay::countAndSay)
                .forEach(System.out::println);
    }
}
