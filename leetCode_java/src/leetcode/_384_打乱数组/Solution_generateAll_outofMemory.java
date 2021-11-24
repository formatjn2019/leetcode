package leetcode._384_打乱数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Solution_generateAll_outofMemory {

    private static ArrayList<int[]> shuffles = new ArrayList<>();
    private Random rand = new Random();

    public Solution_generateAll_outofMemory(int[] nums) {
        createShuffle(nums, new boolean[nums.length], new int[nums.length], 0);

    }

    private void createShuffle(int[] nums, boolean[] used, int[] tempArr, int level) {
        if (level == nums.length) {
            int[] item = new int[tempArr.length];
            System.arraycopy(tempArr, 0, item, 0, tempArr.length);
            shuffles.add(item);
        } else {
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    tempArr[level] = nums[i];
                    createShuffle(nums, used, tempArr, level + 1);
                    used[i] = false;
                }
            }
        }
    }


    public int[] reset() {
        return shuffles.get(0);
    }

    public int[] shuffle() {
        return shuffles.get(rand.nextInt(shuffles.size() - 1) + 1);
    }

    public static void main(String[] args) {
        Solution_generateAll_outofMemory solution = new Solution_generateAll_outofMemory(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        IntStream.range(1, 100)
                .mapToObj(i -> solution.shuffle())
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
