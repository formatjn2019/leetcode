package leetcode._917_仅仅反转字母;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        for (int lp = 0, rp = chars.length - 1; lp < rp; lp++,rp--) {
            while (lp < rp && !Character.isLetter(chars[lp])){
                lp++;
            }
            while (lp < rp && !Character.isLetter(chars[rp])){
                rp--;
            }
            char t=chars[lp];
            chars[lp]=chars[rp];
            chars[rp]=t;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("---T"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
