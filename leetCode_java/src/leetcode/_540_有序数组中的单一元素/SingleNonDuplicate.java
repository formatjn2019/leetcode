package leetcode._540_有序数组中的单一元素;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int lp = 0, rp = nums.length;
        while (true) {
            int med = (lp + rp) / 2;
            if ((med > 0 && nums[med] == nums[med - 1])) {
                //前面为奇数
                if (med % 2 == 0) {
                    rp = med - 1;
                } else {
                    lp = med + 1;
                }
            } else if (med < nums.length - 1 && nums[med] == nums[med + 1]) {
                //前面为奇数
                if (med % 2 == 1) {
                    rp = med;
                } else {
                    lp = med + 2;
                }
            } else {
                return nums[med];
            }
        }
    }

    public static void main(String[] args) {
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(singleNonDuplicate.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleNonDuplicate.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
