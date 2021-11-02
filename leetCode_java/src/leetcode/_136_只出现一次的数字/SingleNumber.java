package leetcode._136_只出现一次的数字;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        ArrayList<Integer>[] tempNum = new ArrayList[nums.length];
        boolean zeroFlag = false;
        for (int num : nums) {
            int index = Math.abs(num) % nums.length;
            if (tempNum[index] == null) {
                tempNum[index] = new ArrayList<>();
            }
            boolean contains = false;
            for (int i = 0; i < tempNum[index].size(); i++) {
                if (tempNum[index].get(i) == num) {
                    tempNum[index].remove(i);
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                tempNum[index].add(num);
            }
        }
        for (ArrayList<Integer> integers : tempNum) {
            if (integers != null && integers.size() > 0) {
                return integers.get(0);
            }
        }
        return 0;
    }
}
