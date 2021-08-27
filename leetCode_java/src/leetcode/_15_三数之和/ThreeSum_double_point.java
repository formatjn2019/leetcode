package leetcode._15_三数之和;

import java.util.*;

public class ThreeSum_double_point {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3){
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int l0=0,r0=nums.length-1;
        while (l0<nums.length&&nums[l0]<0){
            l0++;
        }
        while (r0>=0&&nums[r0]>0){
            r0--;
        }
        if (l0>r0){
            l0=l0+r0;
            r0=l0-r0;
            l0=l0-r0;
        }

        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result=new LinkedList<>();
        //双指针
        for(int lp=0;lp<r0;lp++){
            for (int rp=nums.length-1,sumIndex;lp<rp;rp--){
                if (nums[lp]+nums[rp]==0){
                    sumIndex=(l0+r0)/2;
                    if (nums[sumIndex]==0&&sumIndex!=lp&&sumIndex!=rp){
                        result.add(List.of(nums[lp],nums[sumIndex],nums[rp]));
                    }
                }else{
                    int thirdNum=-(nums[lp]+nums[rp]);
                    sumIndex=thirdNum>0? r0 :Math.min(rp-1,l0);
                    if (thirdNum>0){
                        while (sumIndex<rp){
                            if (nums[sumIndex]==thirdNum){
                                result.add(List.of(nums[lp],nums[sumIndex],nums[rp]));
                                break;
                            }
                            sumIndex++;
                        }
                    }else {
                        while (sumIndex>lp){
                            if (nums[sumIndex]==thirdNum){
                                result.add(List.of(nums[lp],nums[sumIndex],nums[rp]));
                                break;
                            }
                            sumIndex--;
                        }
                    }

                }
                for (;rp>1&&nums[rp]==nums[rp-1];rp--){}

            }

            for (;lp<nums.length-1&&nums[lp]==nums[lp+1];lp++){}
        }
        return result;
    }
    public boolean test(int []strs, List<List<Integer>> expect){
        List<List<Integer>> result = threeSum(strs);
        Set<Set<Integer>> compare=new HashSet<>();
        for (List<Integer> item:result){
            compare.add(new HashSet<>(item));
        }
        boolean passed =true;
        for (List<Integer> item:expect){
            boolean add = compare.add(new HashSet<>(item));
            if (add){
                passed =false;
                break;
            }
        }
        if (!passed){
            System.out.println("失败");
            System.out.println(Arrays.toString(strs));
            System.out.println("结果:"+result+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }
    public static void main(String[] args) {
        ThreeSum_double_point threeSum = new ThreeSum_double_point();
        List<List<Integer>> temp=new LinkedList<>();
        temp.add(List.of( -1, -1, 2));
        temp.add(List.of(-1, 0, 1));
        threeSum.test(new int[]{-1,0,1,2,-1,-4},temp);
        threeSum.test(new int[]{},new LinkedList<>());
        temp=new LinkedList<>();
        temp.add(List.of(0, 0, 0));
        threeSum.test(new int[]{-5,-3,0,0,0},temp);
        temp=new LinkedList<>();
        temp.add(List.of(0, 0, 0));
        threeSum.test(new int[]{0,0,0,0,0},temp);
        temp=new LinkedList<>();
        temp.add(List.of(1, 1, -2));
        threeSum.test(new int[]{1,1,-2},temp);
        temp=new LinkedList<>();
        temp.add(List.of(-1,0, 1));
        threeSum.test(new int[]{-1,0,1,0},temp);
//        threeSum.test(new int[]{},new LinkedList<>());
//        threeSum.test(new int[]{},new LinkedList<>());
    }
}
