package leetcode._1332_删除回文字符串;

public class RemovePalindromeSub_error {
    public int removePalindromeSub(String s) {
        int result=0;
        while (s.length()>0){
            result++;
            s=subLin(s);
        }
        System.out.println(result);
        return result;
    }
    private String subLin(String s){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int lenth=0;
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb2.insert(0,c);
            if (sb.toString().equals(sb2.toString())){
                lenth=sb.length();
            }
        }
        return s.substring(lenth);
    }

    public static void main(String[] args) {
        RemovePalindromeSub_error removePalindromeSub = new RemovePalindromeSub_error();
        removePalindromeSub.removePalindromeSub("ababa");
        removePalindromeSub.removePalindromeSub("abb");
        removePalindromeSub.removePalindromeSub("baabb");
    }
}
