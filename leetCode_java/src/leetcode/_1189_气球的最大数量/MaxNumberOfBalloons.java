package leetcode._1189_气球的最大数量;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] charCount = new int[26];
        for (char c : text.toCharArray()) {
            charCount[c - 'a']++;
        }
        //a
        int result = charCount[0];
        //b l n o
        result = Math.min(result,charCount['b' - 'a']);
        result = Math.min(result,charCount['l' - 'a']/2);
        result = Math.min(result,charCount['n' - 'a']);
        result = Math.min(result,charCount['o' - 'a']/2);
        return result;
    }
}
