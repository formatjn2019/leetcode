package leetcode._1629_按键持续时间最长的键;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] chars = keysPressed.toCharArray();
        char result=chars[0];
        for (int i=1,maxtime=releaseTimes[0];i<keysPressed.length();i++){
            int newTime=releaseTimes[i]-releaseTimes[i-1];
            if (newTime>maxtime) {
                maxtime = newTime;
                result = chars[i];
            }else if (newTime==maxtime){
                result=result>chars[i]?result:chars[i];
            }
        }
        return result;
    }
}
