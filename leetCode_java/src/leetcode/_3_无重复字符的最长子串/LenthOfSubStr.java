package leetcode._3_无重复字符的最长子串;

public class LenthOfSubStr {
    public int lengthOfLongestSubstring(String s) {
        int []searchArr=new int[127];
        int result = 0,start=0;
        for(int i = 0;i<searchArr.length;i++){
            searchArr[i]=-1;
        }
        for (int i= 0;i<s.length();searchArr[s.charAt(i)] = i,i++){
            if (searchArr[s.charAt(i)] ==-1 || (searchArr[s.charAt(i)] < start )){

                result = Math.max(result, i - start+1);
            }else {
                start = searchArr[s.charAt(i)]+1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LenthOfSubStr loss=new LenthOfSubStr();
        System.out.println("0=="+ loss.lengthOfLongestSubstring(""));

        System.out.println("3=="+ loss.lengthOfLongestSubstring("abcabcbb"));

        System.out.println("1=="+ loss.lengthOfLongestSubstring("bbbbb"));

        System.out.println("5=="+ loss.lengthOfLongestSubstring("tmmzuxt"));
    }
}
