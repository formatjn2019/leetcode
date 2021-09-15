package leetcode._87_扰乱字符串;

public class IsScramble_timeout {
    public boolean isScramble(String s1, String s2) {
        //卫语句
        if (!charCount(s1,s2)){
            return false;
        }
        if (s1.length()<3){
            return true;
        }
        boolean result=false;
        for (int split=1;!result &&split<s1.length();split++){
            result=(isScramble(s1.substring(0,split),s2.substring(0,split)) && isScramble(s1.substring(split),s2.substring(split)))
                    ||(isScramble(s1.substring(0,split),s2.substring(s2.length()-split)) && isScramble(s1.substring(split),s2.substring(0,s2.length()-split)));
        }
        return result;
    }


    public boolean charCount(String s1, String s2) {
        int[] judgeArray = new int[26];
        for (char c : s1.toCharArray()) {
            judgeArray[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            judgeArray[c - 'a']--;
        }
        for (int i : judgeArray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsScramble_timeout isScramble = new IsScramble_timeout();
//        System.out.println(isScramble.isScramble("abcdefgh", "hgfedcba"));
//        System.out.println(isScramble.isScramble("abcde","caebd"));
        System.out.println(isScramble.isScramble("abb","bab"));
    }
}
