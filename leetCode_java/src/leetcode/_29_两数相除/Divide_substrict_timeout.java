package leetcode._29_两数相除;

public class Divide_substrict_timeout {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE ){
            return dividend!=Integer.MIN_VALUE ? 1 : 0;
        }

        double result=0;
        if (dividend == Integer.MIN_VALUE){
            dividend +=Math.abs(divisor);
            result += divisor>0?-1:1;
        }
        boolean resultFlag=false;
        if (divisor<0 ){
            divisor=-divisor;
            resultFlag=!resultFlag;
        }
        if (dividend<0){
            dividend=-dividend;
            resultFlag=!resultFlag;
        }
        while (dividend>=divisor||(dividend<0&&divisor<0)){
            dividend -=divisor;
            if (resultFlag){
                result-=1;
            }else {
                result+=1;
            }
        }

        return (int)result;
    }

    public static void main(String[] args) {
        Divide_substrict_timeout divide = new Divide_substrict_timeout();
        System.out.println(divide.divide(1,1));
        System.out.println(divide.divide(15,3));
        System.out.println(divide.divide(16,3));
        System.out.println(divide.divide(-16,3));
        System.out.println(divide.divide(-15,3));
//        System.out.println(divide.divide(Integer.MAX_VALUE,3));
//        System.out.println(divide.divide(Integer.MIN_VALUE,3));
        System.out.println(divide.divide(-1,-1));
        System.out.println(divide.divide(-2147483648,-1));
    }
}
