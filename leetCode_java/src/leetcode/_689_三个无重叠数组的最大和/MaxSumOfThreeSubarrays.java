package leetcode._689_三个无重叠数组的最大和;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSumOfThreeSubarrays {
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

        //索引排序
        List<Integer> indexs = IntStream.range(0, sums.length - k + 1).boxed().sorted(Comparator.comparingInt(i -> sums[i])).collect(Collectors.toList());
//        indexs.removeAll(IntStream.range(0,k-1).boxed().toList());
        for(int i=0;i<k;i++){
            indexs.remove(Integer.valueOf(i));
        }
        int max=Integer.MIN_VALUE;
        //左指针后移
        for (int lp=0;lp<sums.length-2*k-1;lp++) {
            //去除无用的
            indexs.remove(Integer.valueOf(lp + k - 1));
            for (int i = indexs.size() - 1; i >= 0; i--) {
                if (max!=Integer.MIN_VALUE && max-sums[lp]>2*sums[indexs.get(i)]){
                    break;
                }
                for (int j = i - 1; j >= 0; j--) {
                    //两数相互隔距离足够
                    if (Math.abs(indexs.get(i) - indexs.get(j)) >= k) {
                        int tSum = sums[lp] + sums[indexs.get(i)] + sums[indexs.get(j)];
                        //更大，更新最大值
                        if (max < tSum) {
                            max = tSum;
                            result[0] = lp;
                            result[1] = Math.min(indexs.get(i),indexs.get(j));
                            result[2] = Math.max(indexs.get(i),indexs.get(j));
                        }
                    }
                }
            }
        }
        //第二第三个数字向左移动
        for (int index=result[0]+k;index<result[1];index++){
            if (sums[index]==sums[result[1]]){
                result[1]=index;
            }
        }
        for (int index=result[1]+k;index<result[2];index++){
            if (sums[index]==sums[result[2]]){
                result[2]=index;
            }
        }

//        System.out.println(max);
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        MaxSumOfThreeSubarrays maxSumOfThreeSubarrays =new MaxSumOfThreeSubarrays();
//        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2);
//        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{1,2,1,2,1,2,1,2,1,2},2);
//        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{9,8,7,6,2,2,2,2},2);
        int[] ints = maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{17,7,19,11,1,19,17,6,13,18,2,7,12,16,16,18,9,3,19,5}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
