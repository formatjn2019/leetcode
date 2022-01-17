package leetcode._1220_统计元音字母的数目;

import java.util.stream.IntStream;

public class CountVowelPermutation_DFS {
    public int countVowelPermutation(int n) {
        System.out.print(n+":\t");
        long sum=0;
        for (char c : new char[]{'a','e','i','o','u'}){
            System.out.print(c+"\t");
            long temp=countCharactor(c, n);
            System.out.print(temp+"\t");
            sum+=temp;
        }
        System.out.println(sum);
        System.out.println(sum%1000000007);
        return 0;
    }


    public long countCharactor(char cur,int depth){
        if (depth ==1){
            return 1;
        }
        return switch (cur){
            case 'a'->countCharactor('e',depth-1);
            case 'e'-> countCharactor('a', depth - 1)+countCharactor('i', depth - 1);
            case 'i'->countCharactor('a',depth-1)+countCharactor('e',depth-1)+countCharactor('o',depth-1)+countCharactor('u',depth-1);
            case 'o'->countCharactor('i',depth-1)+countCharactor('u',depth-1);
            default ->countCharactor('a',depth-1);
        };
    }

    public static void main(String[] args) {
        CountVowelPermutation_DFS countVowelPermutation = new CountVowelPermutation_DFS();
        IntStream.range(1,100)
                .forEach(countVowelPermutation::countVowelPermutation);
    }

}
