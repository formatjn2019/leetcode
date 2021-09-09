package leetcode._80_删除有序数组中的重复项;

import java.util.Arrays;
import java.util.Random;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int lp1=0,lp2=2;
        for (int i=2;i<nums.length;i++){
            if (nums[i]!=nums[lp1]){
                nums[lp2++]=nums[i];
                lp1++;
            }
        }
        return lp2;
    }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] ints = new Random().ints(1, 10)
                .limit(30)
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(ints));
        int[] ints1 = Arrays.copyOf(ints, removeDuplicates.removeDuplicates(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
