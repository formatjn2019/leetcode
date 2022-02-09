package leetcode._2006_差的绝对值为K的数对数目;

public class CountKDifference {
    public int countKDifference(int[] nums, int k) {
        int []cnums=new int[101];
        for (int num : nums) {
            cnums[num]++;
        }
        int result=0;
        for (int i=k+1;i<cnums.length;i++){
            result+=cnums[i]*cnums[i-k];
        }
        return result;
    }
}
