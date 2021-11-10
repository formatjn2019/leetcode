package leetcode._495_提莫攻击;

public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int endTime = 0;
        for (int timeSery : timeSeries) {
            //根据效果是否持续进行累加
            result += endTime <= timeSery ? duration : timeSery + duration - endTime;
            endTime = timeSery + duration;
        }
        return result;
    }

    public static void main(String[] args) {
        FindPoisonedDuration findPoisonedDuration = new FindPoisonedDuration();
        System.out.println(findPoisonedDuration.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(findPoisonedDuration.findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
