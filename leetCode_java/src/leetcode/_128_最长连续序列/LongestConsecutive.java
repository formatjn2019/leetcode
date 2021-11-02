package leetcode._128_最长连续序列;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        //哈希数组，用于方便寻找散列的元素
        Set<Integer>[] hashArray = new Set[nums.length];
        //添加
        for (int num : nums) {
            //将所有数字转换为正数
            num += 1000000000;
            if (hashArray[num % nums.length] == null) {
                hashArray[num % nums.length] = new HashSet<>();
            }
            //放入到散列的数组中
            hashArray[num % nums.length].add(num);
        }
        int result = 1;
        //循环移除
        for (int i = 0; i < nums.length; i++) {
            if (hashArray[i] != null && hashArray[i].size() != 0) {
                for (Integer start : hashArray[i]) {
                    //计数
                    int count = 1;
                    //正向
                    for (int j = i + 1; j < nums.length; j++) {
                        if (hashArray[j] != null && hashArray[j].remove(start + j - i)) {
                            count++;
                            result = Math.max(result, count);
                        } else {
                            break;
                        }
                    }
                    //反向
                    if (i == 0) {
                        for (int j = hashArray.length - 1; j > 0; j--) {
                            if (hashArray[j] != null && hashArray[j].remove(start + j - hashArray.length)) {
                                count++;
                                result = Math.max(result, count);
                            } else {
                                break;
                            }
                        }
                    }
                }
                hashArray[i].clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int i = longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
}
