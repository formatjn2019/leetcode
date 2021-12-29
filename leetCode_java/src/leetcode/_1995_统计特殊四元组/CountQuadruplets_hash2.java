package leetcode._1995_统计特殊四元组;

public class CountQuadruplets_hash2 {
    public int countQuadruplets(int[] nums) {
        //二维哈希
        //a+b=c-d
        int []sums=new int[201];
        int result = 0;
        for (int b=nums.length-3;b>0;b--){
            for (int d=b+2;d<nums.length;d++){
                sums[100+nums[d]-nums[b+1]]++;
            }
            for (int a=0;a<b;a++){
                int sum=nums[a]+nums[b];
                if (sum<=100){
                    result+=sums[sum+100];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountQuadruplets_hash2 countQuadruplets = new CountQuadruplets_hash2();
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{9, 6, 8, 23, 39, 23}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{28,8,49,85,37,90,20,8}));
    }
}
