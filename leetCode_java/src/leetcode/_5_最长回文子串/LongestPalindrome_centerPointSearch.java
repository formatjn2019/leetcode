package leetcode._5_最长回文子串;


public class LongestPalindrome_centerPointSearch {

    public String longestPalindrome(String s) {
        //卫语句
        if (s.length() == 0) {
            return "";
        }
        String result = s.substring(0, 1);
        char[] chars = s.toCharArray();
        for (double center = (s.length() - 1) / 2.0, step = 0; center - step >= 0; step += 0.5) {
            //结果长度比可能步骤长度大，防止指针越界
            if ((Math.max(s.length() - center - step, center - step) * 2 + 1) <= result.length()) {
                break;
            }
            result = getMax(chars, center + step, s, result);
            if (step != 0) {
                result = getMax(chars, center - step, s, result);
            }
        }

        return result;
    }

    //若current取得的最大长度大于current的长度，则返回新的子串
    public String getMax(char[] chars, double center, String origin, String current) {
        //根据中心的数字决定lp,rp头尾两指针的位置。
        int lp = (int) center, rp = (int) (2 * center % 2 == 0 ? center : center + 1);
        for (; lp >= 0 && rp < chars.length; lp--, rp++) {
            if (chars[lp] != chars[rp]) {
//                System.out.println(lp+"__"+rp);
                break;
            }
        }

        return rp - lp - 1 > current.length() ? origin.substring(++lp, rp) : current;
    }

    public static void main(String[] args) {
        LongestPalindrome_centerPointSearch longestPalindrome = new LongestPalindrome_centerPointSearch();
        System.out.println(longestPalindrome.longestPalindrome("babad") + "==aba");
        System.out.println(longestPalindrome.longestPalindrome("abb") + "==bb");
        System.out.println(longestPalindrome.longestPalindrome("aaa") + "==aaa");
        System.out.println(longestPalindrome.longestPalindrome("aa") + "==aa");
        System.out.println(longestPalindrome.longestPalindrome("cabacdadca") + "==acdadca");
    }
}
