package leetcode._50_Pow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MyPow {
    public double myPow(double x, int n) {
        if (x==0){
            return 0;
        }
        if (n<0){
            return 1/myPow(x,-n);
        }else if (n==1){
            return x;
        }
        List<Double> memory=new ArrayList<>();
        memory.add(x);
        for (int t=1;1<<t<=n;t++){
            memory.add(memory.get(memory.size()-1)*memory.get(memory.size()-1));
        }
        double result=1;
        for (int index=0;n>0;index++){
            result*=n%2==1?memory.get(index):1;
            n/=2;
        }
        return result;
    }

    public void test(int x,int n){
        System.out.println(x+"\t"+n);
        if (myPow(x,n)!=Math.pow(x,n)){
            System.out.println("错误");
            System.out.println("x="+x+",n="+n);
        }
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2, -2);
//        Random random = new Random();
//        IntStream.range(0,200)
//                .limit(100)
//                .forEach((x)->myPow.test(x,random.nextInt()));
    }
}
