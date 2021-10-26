package leetcode._50_Pow;

public class MyPow_timeout {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            return 1 / myPow(x, -n);
        } else {
            return x * myPow(x, n - 1);
        }
    }

    public static void main(String[] args) {
        MyPow_timeout myPow = new MyPow_timeout();
        double v = myPow.myPow(2, -3);
        System.out.println(v);
    }
}
