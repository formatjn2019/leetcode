package leetcode._1332_删除回文字符串;

public class RemovePalindromeSub {
    public int removePalindromeSub(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.reverse();
        return stringBuffer.toString().equals(s)?1:2;
    }

    public static void main(String[] args) {
        RemovePalindromeSub removePalindromeSub = new RemovePalindromeSub();
        System.out.println(removePalindromeSub.removePalindromeSub("ababa"));
        System.out.println(removePalindromeSub.removePalindromeSub("abb"));
        System.out.println(removePalindromeSub.removePalindromeSub("baabb"));
    }
}
