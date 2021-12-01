package leetcode._1446_连续字符;

public class MaxPower {
    public int maxPower(String s) {
        int result=1;
        char pre='\0',current=1;
        for (char c : s.toCharArray()) {
            // 累加
            if (c==pre){
                current++;
                result=Math.max(result,current);
            }
            // 新字符，重置
            else {
                current=1;
                pre=c;
            }
        }
        return result;
    }
}
