package leetcode._492_构造矩形;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        //能整除的排除
        int target = (int) Math.sqrt(area);
        if (target * target == area) {
//            System.out.println("____"+target+"_____");
            return new int[]{target, target};
        }
        List<Integer> splited = new ArrayList<>();
        //分解质因数
        for (int temp = area; temp > 1; ) {
            for (int i = 2; i <= temp; i++) {
                if (temp % i == 0) {
                    temp /= i;
                    splited.add(i);
                    break;
                }
            }
        }
        int[] result = new int[]{area, 1};
        combine(splited, new boolean[splited.size()], 0, result);
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public void combine(List<Integer> splited, boolean[] judgeArray, int depth, int[] results) {
        if (depth == splited.size()) {
            int num1 = 1;
            for (int i = 0; i < judgeArray.length; i++) {
                if (judgeArray[i]) {
                    num1 *= splited.get(i);
                }
            }
            int num2 = results[0] * results[1] / num1;
            //更符合条件
            if ((results[0] - results[1]) > Math.abs(num1 - num2)) {
                results[0] = Math.max(num1, num2);
                results[1] = Math.min(num1, num2);
            }
            return;
        }
        judgeArray[depth] = true;
        combine(splited, judgeArray, depth + 1, results);
        judgeArray[depth] = false;
        combine(splited, judgeArray, depth + 1, results);
    }


    public static void main(String[] args) {
        ConstructRectangle constructRectangle = new ConstructRectangle();
        IntStream.range(1, 100)
                .peek(System.out::println)
                .forEach(constructRectangle::constructRectangle);

    }
}
