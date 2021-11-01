package leetcode._96_不同的二叉搜索树;

import java.util.stream.IntStream;

public class numTrees {
    public int numTrees(int n) {
        if (n < 3) {
            return n;
        }
        int[] memory = new int[n + 1];
        memory[0] = 1;
        memory[1] = 1;
        memory[2] = 2;
        return getNums(n, memory);
    }

    public int getNums(int range, int[] memory) {
        if (memory[range] != 0) {
            return memory[range];
        }
        int result = 0;
        for (int i = 0; i < range; i++) {
            result = result + getNums(i, memory) * getNums(range - i - 1, memory);
        }
        memory[range] = result;
        return result;
    }

    public static void main(String[] args) {
        numTrees numTrees = new numTrees();
        IntStream.range(1, 5)
                .peek(System.out::print)
                .map(numTrees::numTrees)
                .forEach(System.out::println);
    }
}
