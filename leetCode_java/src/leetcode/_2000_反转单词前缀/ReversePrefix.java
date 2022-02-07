package leetcode._2000_反转单词前缀;

public class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int lp=0,rp=0;
        for (int i=0;i<word.length();i++){
            if (chars[i]==ch){
                rp=i;
                break;
            }
        }
        while (lp<rp){
            char t=chars[lp];
            chars[lp++]=chars[rp];
            chars[rp--]=t;
        }
        return new String(chars);
    }
}
