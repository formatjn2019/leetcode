package leetcode._506_相对名次;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        List<String> translate= List.of("Gold Medal","Silver Medal","Bronze Medal");
        //直接插入排序
        ArrayList<Integer> numIndexs=new ArrayList<>();
        for (int i=0;i<score.length;i++){
            int insertIndex=0;
            for (;insertIndex<numIndexs.size();insertIndex++){
                if (score[numIndexs.get(insertIndex)]<score[i]){
                    break;
                }
            }
            numIndexs.add(insertIndex,i);
        }
//        System.out.println(numIndexs);
        String []result=new String[score.length];
        for (int i=0;i<score.length;i++){
            result[numIndexs.get(i)]=i < 3 ? translate.get(i) : "" + (i + 1);
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        FindRelativeRanks findRelativeRanks = new FindRelativeRanks();
        findRelativeRanks.findRelativeRanks(new int[]{10,3,8,9,4});
    }
}
