package leetcode._859_亲密字符串;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        //字符串出错，直接返回
        if (s.length() != goal.length()) {
            return false;
        }
        char c1 = '\0', c2 = '\0';
        int count = 0, max = 0;
        //字符数量计数
        int[] charCount = new int[26];
        char[] sc = s.toCharArray();
        char[] gc = goal.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != gc[i]) {
                count++;
                if (c1 == '\0') {
                    c1 = sc[i];
                    c2 = gc[i];
                } else {
                    if (sc[i] != c2 || gc[i] != c1) {
                        return false;
                    }
                }
            } else {
                charCount[sc[i] - 'a']++;
                max = Math.max(max, charCount[sc[i] - 'a']);
            }
        }
        //当只有两个字母异位或全字母相同，存在两个及以上的相同字母时，结果为真
        return count == 2 || (count == 0 && max > 1);
    }


    public static void main(String[] args) {

    }
}
