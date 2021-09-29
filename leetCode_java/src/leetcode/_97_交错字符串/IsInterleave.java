package leetcode._97_交错字符串;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean judgeArray[][] = new boolean[s1.length() + 1][s2.length() + 1];
        judgeArray[0][0] = true;
        for (int i=1;i<judgeArray.length;i++){
            judgeArray[i][0]=judgeArray[i-1][0] && s3.charAt(i-1)==s1.charAt(i-1);
        }
        for (int j=1;j<judgeArray[0].length;j++){
            judgeArray[0][j]=judgeArray[0][j-1] && s3.charAt(j-1)==s2.charAt(j-1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                judgeArray[i][j] = (judgeArray[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (judgeArray[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }


        System.out.println("\t\t" + String.join("\t\t", s2.split("")));
        AtomicInteger atomicInteger = new AtomicInteger();
        String temp = " " + s1;
        Arrays.stream(judgeArray)
                .peek(_t -> System.out.print(temp.charAt(atomicInteger.getAndIncrement())))
                .map(Arrays::toString)
                .forEach(System.out::println);

        return judgeArray[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        boolean interleave = isInterleave.isInterleave("", "ae", "ad");
        System.out.println(interleave);
    }
}
