package leetcode._35_搜索插入位置;

import java.util.stream.IntStream;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int result=-1;
        for (int start=0,end=nums.length;start<end;){
            //等于的情况
            result=(start+end)/2;
            if (nums[result]==target)
                return result;
            else if (nums[result]<target){
                start=result+1;
            }else {
                end=result;
            }
        }
        //不等情况，三种
        //没搜索到
        if (nums.length == 0) {
            return 0;
        }
        if (nums[result]>target){
            return result;
        }else {
            return result+1;
        }

//        return nums.length>0?(nums[nums.length-1]<target?nums.length:result):0;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        IntStream.range(0,10)
                .map(i->searchInsert.searchInsert(new int[]{1,3,5,6},i))
                .forEach(System.out::println);
        System.out.println(searchInsert.searchInsert(new int[]{}, 2));
    }
}
