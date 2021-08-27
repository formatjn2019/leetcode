package leetcode._7_整数翻转;

public class ReverseNum {
    public int reverse(int x) {
        boolean flag=x>0;
        int temp=Math.abs(x);
        if (temp <0){
            return 0;
        }
        int result = 0;
        for (long tp=0;temp!=0;temp/=10){
            tp*=10;
            tp+=temp%10;
            result= (int) tp;
            if (tp!=result){
                return 0;
            }
        }
//        System.out.println(x+"--->"+result);
        return (Math.max(result, 0)*(flag?1:-1));
    }



    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        i+=1;
        System.out.println(i);
        ReverseNum reverseNum = new ReverseNum();
        System.out.println(123==reverseNum.reverse(321));
        System.out.println(-123==reverseNum.reverse(-321));
        System.out.println(21==reverseNum.reverse(120));
        System.out.println(0==reverseNum.reverse(1111111119));
        System.out.println(0==reverseNum.reverse(-1111111119));

    }
}
