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
        System.out.println(Arrays.toString(sums));
        //排序
        List<Integer> collect = Arrays.stream(sums)
                .limit(sums.length - k + 1)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);

        //索引排序
        List<Integer> indexs = IntStream.range(0, sums.length - k + 1).boxed().collect(Collectors.toList());
        indexs.sort(Comparator.comparingInt(i -> sums[i]));
        System.out.println(indexs);

        ArrayList<Integer> tempList=new ArrayList<>(collect);
        indexs.removeAll(IntStream.range(0,k-1).boxed().toList());
        System.out.println(indexs);
        int max=Integer.MIN_VALUE;
        //左指针后移
        for (int lp=0;lp<sums.length-2*k-1;lp++) {
            //去除无用的
            indexs.remove(Integer.valueOf(lp+k-1));
            //取后k+1个循环求最大值
//            indexs.subList(,)
            System.out.println(indexs);
            List<Integer> subList = indexs.subList(indexs.size() - k-1, indexs.size());
//            for (int i=0;i<subList.size();i++){
//                for (int j=i+1;j<subList)
//            }
            System.out.println(subList);
        }


//        //先暴力试试吧
//        //三指针
//        int lp=0,mp,rp=nums.length-k;
//        //头指针后移
//        for (lp=0;lp<sums.length-2*k;lp++){
//            //尾指针后
//            for (rp=lp+2*k;rp<=sums.length-k;rp++){
//                //中指针后移
//                for (mp=lp+k;mp<=rp-k;mp++){
//                    int tSum=sums[lp]+sums[mp]+sums[rp];
//                    //更大，更新最大值
//                    if (max<tSum){
//                        max=tSum;
//                        result[0]=lp;
//                        result[1]=mp;
//                        result[2]=rp;
//                    }
//                }
//            }
//        }

//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        MaxSumOfThreeSubarrays maxSumOfThreeSubarrays =new MaxSumOfThreeSubarrays();
        maxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2);
    }
}
