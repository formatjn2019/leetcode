package leetcode._5_最长回文子串;


public class LongestPalindrome_memoryArray {

    public String longestPalindrome(String s) {
        String result ="";
        char[] chars = s.toCharArray();
        //记忆数组
        int[] memoryArray =new int[s.length()*2-1];
        //外层从0开始，层从s.length()-1开始
        for (int start=0;start<s.length();start++){
            for (int end=s.length()-1;end-start+1>result.length() ;end--){
                if (isPalindrome(memoryArray,chars,start,end)){
                    result = s.substring(start,end+1);
                }
            }
        }

        return result;
    }
    public boolean isPalindrome(int []memoryArr,char[] arr,int start,int end){
        //判定中心点
        int ts=start+(end-start)/2,te=(end-start)%2==1?ts+1:ts;
        //记忆数组已经判定过成功的位置不再进行判定计算
        for (ts-=memoryArr[start+end],te+=memoryArr[start+end];ts>=start;memoryArr[start+end]+=1){
            if (arr[ts--] != arr[te++]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LongestPalindrome_memoryArray longestPalindrome = new LongestPalindrome_memoryArray();
        System.out.println(longestPalindrome.longestPalindrome("babad")+"==aba");
        System.out.println(longestPalindrome.longestPalindrome("cbbd")+"==bb");
        System.out.println(longestPalindrome.longestPalindrome("a")+"==a");
        System.out.println(longestPalindrome.longestPalindrome("ac")+"==a");
        System.out.println(longestPalindrome.longestPalindrome("cabacdadca")+"==acdadca");
    }
}
