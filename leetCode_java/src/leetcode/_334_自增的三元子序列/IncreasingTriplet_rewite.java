package leetcode._334_自增的三元子序列;

public class IncreasingTriplet_rewite {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, med = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > med) {
                return true;
            }
            //更新中间值和最小值
            else if (num > min) {
                med = num;
            } else {
                min = num;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet_rewite increasingTriplet = new IncreasingTriplet_rewite();
        System.out.println(increasingTriplet.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{2, 0, 4, 1, 5}));
    }
}
