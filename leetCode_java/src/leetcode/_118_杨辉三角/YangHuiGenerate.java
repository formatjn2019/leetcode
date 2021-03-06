package leetcode._118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class YangHuiGenerate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) {
            return result;
        }
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> item = new ArrayList<>(i + 1);
            result.add(item);
            item.add(1);
            for (int j = 1; j < i; j++) {
                item.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            item.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        YangHuiGenerate yangHuiGenerate = new YangHuiGenerate();
        yangHuiGenerate.generate(10);
    }
}
