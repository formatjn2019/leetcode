package leetcode._1688_比赛中的匹配次数;

public class NumberOfMatches {
    public int numberOfMatches(int n) {
        if (n==1){
            return 0;
        }
        return (n%2==0?numberOfMatches(n/2):numberOfMatches(n/2+1))+n/2;
    }
}
