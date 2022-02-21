package leetcode._4_寻找两个正序数组的中位数;

public class FindMediumNum {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //求两个数组的总长度
        int length = nums1.length + nums2.length;
        //已经排除数的数量
        int count = 0;
        int l1 = 0, r1 = nums1.length, l2 = 0, r2 = nums2.length;
        int expect = length % 2 == 1 ? length / 2 : length / 2 - 1;
        while (count < expect) {
            //数组1用完了
            if (l1 == r1) {
                l2 += expect - count;
                break;
            } else if (l2 == r2) {
                l1 += expect - count;
                break;
            }
            int step = Math.max(1,(expect - count) / 2);
            int t1 = Math.min(l1 + step-1, r1 - 1), t2 = Math.min(l2 + step-1, r2 - 1);
            if (nums1[t1] < nums2[t2]) {
                count += t1 - l1 + 1;
                l1 = t1 + 1;
            } else {
                count += t2 - l2 + 1;
                l2 = t2 + 1;
            }
        }

        double result=0;
        if (l1<r1){
            result=l2<r2?nums1[l1]<nums2[l2]?nums1[l1++]:nums2[l2++]:nums1[l1++];
        }else {
            result=nums2[l2++];
        }
        //根据总长判定返回平均值还是中位数
        if (length%2==0){
            if (l1<r1){
                result+=l2<r2? Math.min(nums1[l1], nums2[l2]) :nums1[l1];
            }else {
                result+=nums2[l2];
            }
            result/=2;
        }
        return result;
    }

    public static void main(String[] args) {
        FindMediumNum findMediumNum = new FindMediumNum();
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{4}, new int[]{1, 2, 3, 5}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{1, 3, 4, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{1,4,4,5}, new int[]{1,5,5,6,8}));
        System.out.println(findMediumNum.findMedianSortedArrays(new int[]{1,2}, new int[]{1,2,3}));

    }
}
