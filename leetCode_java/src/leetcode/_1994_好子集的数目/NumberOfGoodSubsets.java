package leetcode._1994_好子集的数目;


import java.util.*;

public class NumberOfGoodSubsets {
    static long MOD = 1000000007L;
    static Map<Integer, Set<Integer>> numSplit1 = Map.of(
            2, Set.of(2),
            3, Set.of(3),
            5, Set.of(5),
            7, Set.of(7),
            11, Set.of(11),
            13, Set.of(13),
            17, Set.of(17),
            19, Set.of(19),
            23, Set.of(23),
            29, Set.of(29)
            );
    static Map<Integer, Set<Integer>> numSplit2 = Map.of(
            6, Set.of(2, 3),
            10, Set.of(2, 5),
            14,Set.of(2,7),
            15, Set.of(3, 5),
            21, Set.of(3, 7),
            22, Set.of(2, 11),
            26, Set.of(2, 13),
            30, Set.of(2, 3, 5)
    );

    static Map<Integer, Set<Integer>> numSplit = new HashMap<>(numSplit1);
    //由于Map的方法限制，这里分成两个Map来写
    //此方法用于初始化
    static void Init() {
        if (numSplit.size() < 17) {
            numSplit.putAll(numSplit2);
        }
    }

    //求解
    public int numberOfGoodSubsets(int[] nums) {
        Init();
        //统计1的数量
        int oneCount = 0;
        //统计其它数字的数量
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            if (num == 1) {
                oneCount++;
            } else if (numSplit.containsKey(num)) {
                numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }
        }
        //结果
        long[] result = new long[1];
        //dfs搜索，求出所有的组合
        dfsSearch(result, new boolean[numCount.size()], numCount.keySet().stream().mapToInt(Integer::intValue).toArray(), 0, new HashSet<>(), numCount);
        for (int i=0;i<oneCount;i++){
            result[0]=result[0]*2%MOD;
        }
        return (int) result[0];
    }

    private void dfsSearch(long[] result, boolean[] used, int[] nums, int index, Set<Integer> current, Map<Integer, Integer> numCount) {
        //递归结束
        if (index == nums.length) {
            return;
        }

        //还没有使用，则尝试使用
        outter:
        if (!used[index]) {
            //如果要添加的数中有已经存在的质因数，跳过添加这个数的步骤
            for (Integer integer : numSplit.get(nums[index])) {
                if (current.contains(integer)) {
                    break outter;
                }
            }
            current.addAll(numSplit.get(nums[index]));
            used[index] = true;
            //使用，则增加一种情况
            //使用当前的数的组合
            long count = 0;
            for (int i = 0; i < index+1; i++) {
                if (used[i]) {
                    count = Math.max(count, 1);
                    count = count*numCount.get(nums[i])%MOD;
                }
            }
            result[0] = (result[0] + count) % MOD;
            //添加这个数后，尝试添加下一个数
            dfsSearch(result, used, nums, index + 1, current, numCount);
            used[index] = false;
            current.removeAll(numSplit.get(nums[index]));
        }
        //不添加这个数，直接进入下一层
        dfsSearch(result, used, nums, index + 1, current, numCount);
    }


    public static void main(String[] args) {
        NumberOfGoodSubsets numberOfGoodSubsets = new NumberOfGoodSubsets();
        System.out.println(numberOfGoodSubsets.numberOfGoodSubsets(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfGoodSubsets.numberOfGoodSubsets(new int[]{2, 3, 5}));
        System.out.println(numberOfGoodSubsets.numberOfGoodSubsets(new int[]{4, 2, 3, 15}));
        System.out.println(numberOfGoodSubsets.numberOfGoodSubsets(new int[]{2,2,2,3,3,1,15,22,30,9,8}));
        System.out.println(numberOfGoodSubsets.numberOfGoodSubsets(new int[]{9,3,14,12,14,3,23,23,30,9,2,6,26,17,5,8,23,6,8,9,2,4,30,21,19,8,23,22,26,17,20,5,15,18,20,22,2,15,8,21,9,20}));
    }
}
