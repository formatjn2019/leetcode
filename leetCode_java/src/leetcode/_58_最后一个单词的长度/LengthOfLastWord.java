package leetcode._58_最后一个单词的长度;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int end=s.length()-1;
        for(;chars[end]==' '&&end>0;end--){}
        int start=end;
        for (;start>=0&&chars[start]!=' ';start--){}
        System.out.println(end-start);
        return end-start;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        lengthOfLastWord.lengthOfLastWord("Hello World");
        lengthOfLastWord.lengthOfLastWord("fly me to the moon");
        lengthOfLastWord.lengthOfLastWord("luffy is still joyboy");
    }
}
