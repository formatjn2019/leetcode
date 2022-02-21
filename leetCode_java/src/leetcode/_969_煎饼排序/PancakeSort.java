package leetcode._969_煎饼排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        int[] clone = new int[arr.length];
        System.arraycopy(arr, 0, clone, 0, clone.length);
        Arrays.sort(clone);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            result.addAll(pancakeSort(arr, i, clone[i]));
        }

        System.out.println(Arrays.toString(arr));
        return result;
    }

    private List<Integer> pancakeSort(int[] arr, int index, int num) {
        if (arr[index] == num) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        if (arr[0] != num) {
            for (int i = 0; i < index; i++) {
                if (arr[i] == num) {
                    result.add(i + 1);
                    reverse(arr, i + 1);
                    break;
                }
            }
        }
        reverse(arr, index + 1);
        result.add(index + 1);
        return result;
    }

    private void reverse(int[] arr, int end) {
        for (int lp = 0, rp = end - 1; lp < rp; lp++, rp--) {
            int t = arr[lp];
            arr[lp] = arr[rp];
            arr[rp] = t;
        }
    }

    public static void main(String[] args) {
        PancakeSort pancakeSort = new PancakeSort();
        pancakeSort.pancakeSort(new int[]{4, 4, 1, 3, 2});
        pancakeSort.pancakeSort(new int[]{3,2,4,1});
    }
}
