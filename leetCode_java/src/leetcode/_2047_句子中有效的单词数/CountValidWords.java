package leetcode._2047_句子中有效的单词数;


import java.util.Arrays;
import java.util.regex.Pattern;

public class CountValidWords {
    public int countValidWords(String sentence) {
        return (int) Arrays.stream(sentence.split(" "))
                .filter(this::IsAvailableWord)
                .count();
    }

    private boolean IsAvailableWord(String word) {
        if (word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        boolean concat = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                return false;
            } else if (c == '-') {
                if (concat || i < 1 || i == chars.length - 1 || chars[i + 1] < 'a' || chars[i + 1] > 'z') {
                    return false;
                } else {
                    concat = true;
                }
            }
            if ((c == '!' || c == '.' || c == ',') && i != chars.length - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountValidWords countValidWords = new CountValidWords();
        System.out.println(countValidWords.countValidWords("cat and  dog"));
        System.out.println(countValidWords.countValidWords("!this  1-s b8d!"));
        System.out.println(countValidWords.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
        System.out.println(countValidWords.countValidWords("alice and  bob are playing stone-game10"));
        System.out.println(countValidWords.countValidWords("-"));
        System.out.println(countValidWords.countValidWords(". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5"));
    }
}
