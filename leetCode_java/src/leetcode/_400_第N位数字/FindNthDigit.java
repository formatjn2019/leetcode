package leetcode._400_第N位数字;

public class FindNthDigit {
    public int findNthDigit(int n) {
        long sum=0;
        int lenth=1;
        //求出所求数字的位数lenth
        while (sum+9*Math.pow(10,lenth-1)*lenth<n){
            sum+=9*Math.pow(10,lenth-1)*lenth;
            lenth++;
        }
        //remainder为数字的序数
        int remainder= (int) (n-sum);
        //数字是多少
        int num= (int) (Math.pow(10,lenth-1)+Math.ceil(remainder/(double)lenth)-1);
        //第几位数 正序
        int th=  (remainder+lenth-1)%lenth+1;
        //第几位数 倒序
        th= (lenth-th);
        //求出对应位的数字
        for (;th>0;th--){
            num/=10;
        }
        return num%10;
    }
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        findNthDigit.findNthDigit(1000);
        findNthDigit.findNthDigit(100);
        findNthDigit.findNthDigit(198);
        findNthDigit.findNthDigit(199);
        findNthDigit.findNthDigit(200);
//        long sum=0;
//        for (int i=0;sum<Integer.MAX_VALUE;i++){
//            sum+=9*Math.pow(10,i);
//            System.out.println(sum);
//            i=900000000;
//        }
    }
}
