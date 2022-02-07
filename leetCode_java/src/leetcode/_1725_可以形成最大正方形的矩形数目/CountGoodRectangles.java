package leetcode._1725_可以形成最大正方形的矩形数目;

public class CountGoodRectangles {
    public int countGoodRectangles(int[][] rectangles) {
        int result=0,max=-1;
        for (int[] rectangle : rectangles) {
            int newRectLen=Math.min(rectangle[0],rectangle[1]);
            if (newRectLen==max){
                result++;
            }else if (newRectLen>max){
                result=1;
                max=newRectLen;
            }
        }
        return result;
    }
}
