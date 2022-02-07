package leetcode._1763_最长的美好字符串;

public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        String result="";
        for (int len=2;len<=s.length();len++){
            for (int start=0;start<=s.length()-len;start++){
                if (isNiceString(s.substring(start,start+len))){
                    result=s.substring(start,start+len);
                    break;
                }
            }
        }

        return result;
    }
    private boolean isNiceString(String s){
        boolean []cl=new boolean[26],cu=new boolean[26];
        for (char c : s.toCharArray()) {
            if (c>='a'){
                cl[c-'a']=true;
            }else {
                cu[c-'A']=true;
            }
        }
        for (int i=0;i<26;i++){
            if (cl[i]^cu[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        System.out.println(longestNiceSubstring.longestNiceSubstring("YazaAay"));
    }
}
