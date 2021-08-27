package leetcode._4_寻找两个正序数组的中位数;

public class FindMediumNum {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int []result=new int[2];
        for (int n1p=0,n2p=0,count=0;count<length/2+1;count++){
            if (n1p >= nums1.length){
                result[count%2]=nums2[n2p++];
                continue;
            }
            if (n2p >= nums2.length){
                result[count%2]=nums1[n1p++];
                continue;
            }
            result[count%2]= nums1[n1p] < nums2[n2p] ? nums1[n1p++]:nums2[n2p++];
        }

        return length%2 ==0 ? (result[1]+result[0]) / 2.0 :result[(length/2)%2];
    }
    public static void main(String[] args) {
        FindMediumNum findMediumNum= new FindMediumNum();
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{0,0},new int[]{0,0}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{},new int[]{1}));
    }
}
