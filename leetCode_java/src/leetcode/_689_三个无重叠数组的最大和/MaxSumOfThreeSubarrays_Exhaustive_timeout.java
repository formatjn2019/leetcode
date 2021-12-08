package leetcode._689_三个无重叠数组的最大和;

public class MaxSumOfThreeSubarrays_Exhaustive_timeout {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int []sums=new int[nums.length];
        //数据预处理，求和
        for (int t=nums.length-1,tk=k,sum=0;t>=0;t--,tk--){
            sum+=nums[t];
            if (tk>1){
                sums[t]=Integer.MIN_VALUE;
            }else {
                sum-=t+k>=nums.length?0:nums[t+k];
                sums[t]=sum;
            }
        }
        int []result=new int[3];
//        System.out.println(Arrays.toString(sums));
        //先暴力试试吧
        //三指针
        int lp=0,mp,rp=nums.length-k;
        int max=Integer.MIN_VALUE;
        //头指针后移
        for (lp=0;lp<sums.length-2*k;lp++){
            //尾指针后
            for (rp=lp+2*k;rp<=sums.length-k;rp++){
                //中指针后移
                for (mp=lp+k;mp<=rp-k;mp++){
                    int tSum=sums[lp]+sums[mp]+sums[rp];
                    //更大，更新最大值
                    if (max<tSum){
                        max=tSum;
                        result[0]=lp;
                        result[1]=mp;
                        result[2]=rp;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        MaxSumOfThreeSubarrays_Exhaustive_timeout maxSumOfThreeSubarrays =new MaxSumOfThreeSubarrays_Exhaustive_timeout();
        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2);
    }
}
