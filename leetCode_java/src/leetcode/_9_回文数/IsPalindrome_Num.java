package leetcode._9_回文数;

public class IsPalindrome_Num {
    public boolean isPalindrome(int x) {
        if (x <0){
            return false;
        }
        int rev=0;
        for (int temp=x;temp>0;temp/=10){
            rev=rev*10+temp%10;
        }
//        System.out.println(rev);
        return rev==x;
    }

    public boolean test(int num,boolean expect){
        boolean result = isPalindrome(num);
        System.out.println(num+"->"+result);
        return expect==result;
    }
    public static void main(String[] args) {
        IsPalindrome_Num isPalindrome = new IsPalindrome_Num();
        System.out.println("结果："+isPalindrome.test(121,true));
        System.out.println("结果："+isPalindrome.test(0,true));
        System.out.println("结果："+isPalindrome.test(10,false));
        System.out.println("结果："+isPalindrome.test(-121,false));
        System.out.println("结果："+isPalindrome.test(1111111111,true));
        System.out.println("结果："+isPalindrome.test(1112111,true));
    }
}
