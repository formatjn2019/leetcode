package leetcode._1995_统计特殊四元组;

public class CountQuadruplets_hash1 {
    public int countQuadruplets(int[] nums) {
        //一维哈希
        int []sums=new int[101];
        int result = 0;
        for (int i = nums.length-2; i >1; i--) {
            sums[nums[i+1]]++;
            for (int j = i -1; j >0; j--) {
                for (int k = j -1 ; k >=0; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    result+=sum>100?0:sums[sum];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountQuadruplets_hash1 countQuadruplets = new CountQuadruplets_hash1();
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{9, 6, 8, 23, 39, 23}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{28,8,49,85,37,90,20,8}));
    }
}
