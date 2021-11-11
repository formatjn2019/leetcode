package leetcode._629_k个逆序对数组;

import leetcode._46_全排列.Permute;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KInversePairs_map_Timeout {
    public int kInversePairs(int n, int k) {
        //卫语句
        if (k == 0) {
            return 1;
        }
        Map<Integer, Long> result = Map.of(0,1L);
        //层数
        for (int i = 2; i <= n; i++) {
            HashMap<Integer, Long> nextLevel = new HashMap<>();
            for (int j = 0; j < i; j++) {
                for (Map.Entry<Integer, Long> entry : result.entrySet()) {
                    Integer newKey=entry.getKey()+j;
                    //剪枝语句，若无则是推导所有可能性，若有则是值推导k前的，因为k的值只和小于等于k的前层有关
                    if (newKey>k){
                        continue;
                    }
                    Long newValue=entry.getValue()+nextLevel.getOrDefault(newKey,0L);
                    if (newValue>1000000007){
                        newValue=newValue%1000000007;
                    }
                    nextLevel.put(newKey,newValue);
                }
            }
            result=nextLevel;
        }
//        System.out.println(result);
        return (int) (result.getOrDefault(k,0L)+0);
    }

    public int countPairs(List<Integer> judge) {
        int result = 0;
        for (int i = 0; i < judge.size(); i++) {
            for (int j = i + 1; j < judge.size(); j++) {
                if (judge.get(i) > judge.get(j)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        extracted();
        KInversePairs_map_Timeout kInversePairs = new KInversePairs_map_Timeout();
//        IntStream.range(1,5)
//                .forEach(i-> kInversePairs.kInversePairs(i,1));
        System.out.println(kInversePairs.kInversePairs(40,6));

    }


    private static void extracted() {
        KInversePairs_map_Timeout kInversePairs = new KInversePairs_map_Timeout();
        Permute permute = new Permute();
        List<List<Integer>> permute1 = permute.permute(new int[]{1, 2, 3, 4});
        permute1.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (!o1.get(i).equals(o2.get(i))) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 0;
            }
        });
        permute1.stream()
                .peek(item -> System.out.print(item + "\t\t"))
                .map(kInversePairs::countPairs)
                .forEach(System.out::println);
    }
}
