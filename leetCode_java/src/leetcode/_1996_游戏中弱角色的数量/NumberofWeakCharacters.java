package leetcode._1996_游戏中弱角色的数量;

import leetcode.Tools;

import java.util.Arrays;

public class NumberofWeakCharacters {
    public int numberOfWeakCharacters(int[][] properties) {
        //排序
        Arrays.sort(properties,(arr1,arr2)->{
            if (arr1[0]-arr2[0]!=0){
                return arr2[0]-arr1[0];
            }else {
                return arr2[1]-arr1[1];
            }
        });

        int result=0;
        int maxDef=Integer.MIN_VALUE;
        int preAttr=Integer.MIN_VALUE;
        int preDef=Integer.MIN_VALUE;
        for (int[] property : properties) {
            //更新最大值
            if (property[0]!=preAttr){
                maxDef=preDef;
            }
            //记录当前最大值
            if (property[1]>preDef){
                preDef=property[1];
                preAttr=property[0];
            }
            if (maxDef>property[1]){
                result++;
            }

        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        NumberofWeakCharacters numberofWeakCharacters = new NumberofWeakCharacters();
//        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[1,5],[10,4],[4,3],[2,2],[3,3],[1,5],[10,4],[4,3]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[1,3],[2,5],[4,7],[3,9],[5,6],[6,6],[6,2],[9,1]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[5,5],[6,3],[3,6]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[2,2],[3,3]]"));
        numberofWeakCharacters.numberOfWeakCharacters(Tools.parseArray("[[1,5],[10,4],[4,3]]"));
    }
}
