package leetcode._496_下一个更大的元素;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []results=new int[nums1.length];
        Arrays.fill(results,-1);
        //单减栈
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.getFirst()<num){
                int pop=stack.pop();
                //nums1中搜索
                for (int i=0;i<nums1.length;i++){
                    if (nums1[i]==pop){
                        results[i]=num;
                    }
                }
            }
            stack.push(num);
        }
        return results;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] ints = nextGreaterElement.nextGreaterElement(new int[]{}, new int[]{1,3,4,2});
        System.out.println(Arrays.toString(ints));
    }
}
