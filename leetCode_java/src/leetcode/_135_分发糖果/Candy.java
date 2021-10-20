package leetcode._135_分发糖果;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length < 2) {
            return 1;
        }
        int[] clone = Arrays.copyOf(ratings, ratings.length);
        Arrays.sort(clone);
        int []indexs=new int[ratings.length];
        boolean []used=new boolean[ratings.length];
        for (int i=0;i<ratings.length;i++) {
            int index=0;
            for (;index<ratings.length;index++){
                if (used[index]){
                    continue;
                }
                if (ratings[index]==clone[i]){
                    break;
                }
            }
            indexs[i]=index;
            used[index]=true;
        }

        int[] judgeArray = new int[ratings.length];
        Arrays.fill(judgeArray, 1);
        for (int index : indexs) {
            if (index>0 && ratings[index]>ratings[index-1]){
                judgeArray[index]=Math.max(judgeArray[index],judgeArray[index-1]+1);
            }
            if (index< judgeArray.length-1 && ratings[index]>ratings[index+1]){
                judgeArray[index]=Math.max(judgeArray[index],judgeArray[index+1]+1);
            }
        }
        System.out.println(Arrays.toString(judgeArray));
        return Arrays.stream(judgeArray).sum();
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        candy.candy(new int[]{1, 0, 2});
        candy.candy(new int[]{1, 2, 3});
        candy.candy(new int[]{5, 4, 3, 2, 1});
        candy.candy(new int[]{1, 2, 2});
    }
}
