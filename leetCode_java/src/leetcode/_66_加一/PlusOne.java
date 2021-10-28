package leetcode._66_加一;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            digits[0] = 1;
            return digits;
        }
        //进位标志
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0 && carry; i--) {
            digits[i] = (digits[i] + 1) % 10;
            carry = digits[i] == 0;
        }
        //原数组容量无法承载
        if (carry) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            System.arraycopy(digits, 0, ints, 1, digits.length);
            digits = ints;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(ints));
    }
}
