package leetcode._334_自增的三元子序列;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int min = 0, med = 0;
        boolean hasMin = false, hasMed = false;
        for (int num : nums) {
            //最小值记录
            if (!hasMin) {
                min = num;
                hasMin = true;
            }
            //中值记录
            else if (!hasMed) {
                if (num > min) {
                    hasMed = true;
                    med = num;
                } else {
                    min = num;
                }
            } else {
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
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{2, 0, 4, 1, 5}));
    }
}
