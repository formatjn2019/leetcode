package leetcode._8_字符串转整数;

public class String2Int {
    public int myAtoi(String s) {
        //字符串转char数组，加速
        char[] chars = s.toCharArray();
        int index = 0;
        //从开头判定，空格去掉,若有多于一个的+-返回0
        for (; index < chars.length && (chars[index] < '0' || chars[index] > '9'); index++) {
            if (chars[index] != ' ' && chars[index] != '\t') {
                if (chars[index] != '-' && chars[index] != '+') {
                    return 0;
                } else {
                    index++;
                    break;
                }
            }
        }
        //指针到串尾部或不符合要求，返回0
        if (index == chars.length || (chars[index] < '0' || chars[index] > '9')) {
            return 0;
        }
        //存储结果
        long result = chars[index++] - '0';
        boolean flag = false;
        //判定符号
        if (index != 1 && chars[index - 2] == '-') {
            flag = true;
        }
        //读入结果
        for (; index < chars.length && 0 <= chars[index] - '0' && chars[index] - '0' < 10; index++) {
            result = result * 10 + chars[index] - '0';
            //针对int越界决定进行判定
            if ((flag && result > (long) Integer.MAX_VALUE + 1) || (!flag && result > Integer.MAX_VALUE)) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return flag ? (int) result * -1 : (int) result;
    }


    public boolean Test(String s, int result) {
        System.out.println(s + "->" + myAtoi(s));
        return myAtoi(s) == result;
    }

    public static void main(String[] args) {
        String2Int string2Int = new String2Int();
        System.out.println(string2Int.Test("" + Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(string2Int.Test("" + Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println(string2Int.Test("48", 48));
        System.out.println(string2Int.Test("   -148", -148));
        System.out.println(string2Int.Test("4193 with words", 4193));
        System.out.println(string2Int.Test("+ 12", 0));


    }
}
