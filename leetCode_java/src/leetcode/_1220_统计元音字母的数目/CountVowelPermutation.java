package leetcode._1220_统计元音字母的数目;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CountVowelPermutation {
    static long MOD=1000000007;
    public int countVowelPermutation(int n) {
        return  countCharactor(new long[]{1, 1, 1, 1, 1}, n);
    }


    public int countCharactor(long []counts, int depth){
        if (depth ==1){
            return (int) (Arrays.stream(counts).sum()%(1000000007));
        }
        long []nextArr=new long[5];
        //0 a = e + i + u
        nextArr[0]=  (counts[1]+counts[2]+counts[4])%MOD;
        //1 e = a + i
        nextArr[1] = (counts[0]+counts[2])%MOD;
        //2 i = o + e
        nextArr[2] = (counts[1]+counts[3])%MOD;
        //3 o = i
        nextArr[3] = counts[2]%MOD;
        //4 u = i + o
        nextArr[4] = (counts[2]+counts[3])%MOD;

        return countCharactor(nextArr,depth-1);
    }

    public static void main(String[] args) {
        CountVowelPermutation countVowelPermutation = new CountVowelPermutation();
//        IntStream.range(1,100)
//                .peek(i-> System.out.print(i+"\t"))
//                .map(countVowelPermutation::countVowelPermutation)
//                .forEach(System.out::println);
        System.out.println(countVowelPermutation.countVowelPermutation(1000));
    }

}
