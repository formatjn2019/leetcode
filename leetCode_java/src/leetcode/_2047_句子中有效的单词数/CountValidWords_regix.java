package leetcode._2047_句子中有效的单词数;


import java.util.Arrays;
import java.util.regex.Pattern;

public class CountValidWords_regix {
    static Pattern rule=Pattern.compile("^[a-z]*?([a-z]-[a-z])?[a-z]*?[!.,]?$");
    public int countValidWords(String sentence) {
        return (int) Arrays.stream(sentence.split(" "))
                .filter(_word->_word.length()>0)
                .filter(word->rule.matcher(word).find())
                .count();
    }


    public static void main(String[] args) {
        CountValidWords_regix countValidWords = new CountValidWords_regix();
        System.out.println(countValidWords.countValidWords("cat and  dog"));
        System.out.println(countValidWords.countValidWords("!this  1-s b8d!"));
        System.out.println(countValidWords.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
        System.out.println(countValidWords.countValidWords("alice and  bob are playing stone-game10"));
    }
}
