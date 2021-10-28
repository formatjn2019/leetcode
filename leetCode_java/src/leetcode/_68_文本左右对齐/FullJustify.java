package leetcode._68_文本左右对齐;

import java.util.LinkedList;
import java.util.List;

public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        List<String> lineWord = new LinkedList<>();
        for (int i = 0, wordSize = 0, release = maxWidth; i < words.length; i++) {
            wordSize += words[i].length();
            release -= words[i].length();
            lineWord.add(words[i]);
            //空格
            release--;
            if (i == words.length - 1) {
                result.add(oneLine(maxWidth, lineWord));
            } else if (release < words[i + 1].length()) {
                if (lineWord.size() == 1) {
                    result.add(oneLine(maxWidth, lineWord));
                } else {
                    result.add(oneLine(maxWidth, lineWord, wordSize));
                }
                wordSize = 0;
                lineWord.clear();
                release = maxWidth;
            }
        }
//        result.forEach(System.out::println);
        return result;
    }

    //普通行
    public String oneLine(int maxWidth, List<String> words, int wordTotalLenth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        int spaces = maxWidth - wordTotalLenth;
        int left = spaces % (words.size() - 1);
        String other = " ".repeat(spaces / (words.size() - 1));
        for (int i = 0; i < words.size() - 1; i++, left--) {
            sb.append(words.get(i));
            sb.append(other);
            if (left > 0) {
                sb.append(" ");
            }
        }
        sb.append(words.get(words.size() - 1));
        return sb.toString();
    }

    //尾部行
    public String oneLine(int maxWidth, List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        while (sb.length() < maxWidth) {
            sb.append(' ');
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        FullJustify fullJustify = new FullJustify();
//        String []strs=new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] strs = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        fullJustify.fullJustify(strs, 16);
    }
}
