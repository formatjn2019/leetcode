package leetcode._119_杨辉三角II;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class YangHuiRow {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex<2){
            return rowIndex==0?List.of():List.of(1);
        }
        int [][]resultArray=new int[2][rowIndex];
        resultArray[0][0]=1;
        resultArray[1][0]=1;
        for (int i=1;i<=rowIndex;i++){
            for (int j=1;j<i;j++){
                resultArray[i%2][j]=resultArray[(i+1)%2][j-1]+resultArray[(i+1)%2][j];
            }
        }
        System.out.println(Arrays.deepToString(resultArray));
        return Arrays.stream(resultArray[rowIndex%2]).boxed().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        YangHuiRow yangHuiRow = new YangHuiRow();
        yangHuiRow.getRow(5);
    }
}
