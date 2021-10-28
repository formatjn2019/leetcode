package leetcode._71_简化路径;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Stream;

public class SimplifyPath {
    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
//        System.out.println(Arrays.toString(split));
        for (String s : split) {
            switch (s) {
                case "" -> {
                }
                case "." -> {
                }
                case ".." -> {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                }
                default -> {
                    stack.push(s);
                }
            }
        }
//        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.insert(0, s);
            sb.insert(0, '/');
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        Stream.of("/../")
                .map(simplifyPath::simplifyPath)
                .forEach(System.out::println);

    }
}
