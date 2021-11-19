package leetcode._397_整数替换;

public class IntegerReplacement_recursion_stackover {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else if (n > 3 && (n + 1) % 4 == 0) {
            return integerReplacement(n + 1) + 1;
        } else {
            return integerReplacement(n - 1) + 1;
        }
    }

    public static void main(String[] args) {
        IntegerReplacement_recursion_stackover integerReplacement = new IntegerReplacement_recursion_stackover();
//        IntStream.range(1,100)
//                .peek(i-> System.out.print(i+"\t"))
//                .map(integerReplacement::integerReplacement)
//                .forEach(System.out::println);

        System.out.println(integerReplacement.integerReplacement(11));
    }
}
