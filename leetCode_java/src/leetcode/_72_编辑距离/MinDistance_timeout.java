package leetcode._72_编辑距离;

import java.util.Map;

public class MinDistance_timeout {

    public int minDistance(String w1, String w2) {
        if (w1.equals(w2)) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int minLenth = Math.min(w1.length(), w2.length());
        int lSame = 0, rSame = 0;
        while (lSame < minLenth && w1.charAt(lSame) == w2.charAt(lSame)) {
            lSame++;
        }
        while (rSame < minLenth - lSame && w1.charAt(w1.length() - 1 - rSame) == w2.charAt(w2.length() - 1 - rSame)) {
            rSame++;
        }
        w1 = w1.substring(lSame, w1.length() - rSame);
        w2 = w2.substring(lSame, w2.length() - rSame);
        int nMin = Math.min(w1.length(), w2.length());
        //左右都不为空时，判定改字符
        if (nMin != 0) {
            String nw1 = changeLOrR(w1, w2, nMin) ? w2.charAt(0) + w1.substring(1) : w1.substring(0, w1.length() - 1) + w2.charAt(w2.length() - 1);
            int res = minDistance(nw1, w2);
            result = Math.min(result, res);
        }
        //左不为空时，判定减字符
        if (w1.length() != 0) {
            String nw1 = subLOrR(w1, w2) ? w1.substring(1) : w1.substring(0, w1.length() - 1);
            int res = minDistance(nw1, w2);
            result = Math.min(result, res);
        }
        //右边不为空时，判定加字符
        if (w2.length() != 0) {
            String nw1 = addLOrR(w1, w2) ? w2.charAt(0) + w1 : w1 + w2.charAt(w2.length() - 1);
            int res = minDistance(nw1, w2);
            result = Math.min(result, res);
        }
        return result + 1;
    }

    public boolean changeLOrR(String w1, String w2, int nMin) {
        int lChange, rChange;
        //左右改字符
        //左->右
        lChange = 1;
        while (lChange < nMin && w1.charAt(lChange) == w2.charAt(lChange)) {
            lChange++;
        }
        //右->左
        rChange = 1;
        while (rChange < nMin && w1.charAt(w1.length() - 1 - rChange) == w2.charAt(w2.length() - 1 - rChange)) {
            rChange++;
        }
        return lChange >= rChange;
    }

    public boolean addLOrR(String w1, String w2) {
        int nMin = Math.min(w1.length() + 1, w2.length());
        int lAdd = 1, rAdd = 1;
        while (lAdd < nMin && w1.charAt(lAdd - 1) == w2.charAt(lAdd)) {
            lAdd++;
        }
        while (rAdd < nMin && w1.charAt(w1.length() - rAdd) == w2.charAt(w2.length() - rAdd - 1)) {
            rAdd++;
        }
        return lAdd >= rAdd;
    }

    public boolean subLOrR(String w1, String w2) {
        int nMin = Math.min(w1.length(), w2.length() + 1);
        int lSub = 1, rSub = 1;
        while (lSub < nMin && w1.charAt(lSub) == w2.charAt(lSub - 1)) {
            lSub++;
        }
        while (rSub < nMin && w1.charAt(w1.length() - rSub - 1) == w2.charAt(w2.length() - rSub)) {
            rSub++;
        }
        return lSub >= rSub;
    }

    public static void main(String[] args) {
        MinDistance_timeout minDistance = new MinDistance_timeout();
        Map<String, String> testDatas = Map.of(
                "aaabbccc", "aaaabcccc",
                "a", "b",
                "ab", "a",
                "horse", "ros",
                "intention", "execution"
        );
        testDatas.entrySet().stream()
                .peek(System.out::println)
                .mapToInt((entry) -> minDistance.minDistance(entry.getKey(), entry.getValue()))
                .forEach(System.out::println);

    }
}
