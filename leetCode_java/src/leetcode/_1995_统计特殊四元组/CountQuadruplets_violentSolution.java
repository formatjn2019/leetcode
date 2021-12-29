package leetcode._1995_统计特殊四元组;

public class CountQuadruplets_violentSolution {
    public int countQuadruplets(int[] nums) {
        //暴力
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountQuadruplets_violentSolution countQuadruplets = new CountQuadruplets_violentSolution();
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
    }
}
