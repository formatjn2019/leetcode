package leetcode._9_回文数;

public class IsPalindrome_Array {
    public boolean isPalindrome(int x) {
        //卫语句 负数直接返回
        if (x < 0) {
            return false;
        }
        //int最大值就10位
        int[] numArr = new int[10];
        int length = 0;
        while (x > 0) {
            numArr[length++] = x % 10;
            x /= 10;
        }
        for (int i = 0; i < length / 2; i++) {
            if (numArr[i] != numArr[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean test(int num, boolean expect) {
        boolean result = isPalindrome(num);
        System.out.println(num + "->" + result);
        return expect == result;
    }

    public static void main(String[] args) {
        IsPalindrome_Array isPalindrome = new IsPalindrome_Array();
        System.out.println("结果：" + isPalindrome.test(121, true));
        System.out.println("结果：" + isPalindrome.test(0, true));
        System.out.println("结果：" + isPalindrome.test(10, false));
        System.out.println("结果：" + isPalindrome.test(-121, false));
        System.out.println("结果：" + isPalindrome.test(1111111111, true));
        System.out.println("结果：" + isPalindrome.test(1112111, true));
    }
}
