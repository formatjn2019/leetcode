package leetcode._84_柱状图中最大的矩形;

public class LangestRectangleArea_timeout {
    public int largestRectangleArea(int[] heights) {
        int result=0;
        for (int i=0,lp,rp;i<heights.length;i++){
            int height=heights[i];
            lp=rp=i;

            if (height==0 || result/height>heights.length){
                continue;
            }
            while (lp>0 && heights[lp-1]>=heights[i]){
                lp--;
            }
            while (rp<heights.length-1 && heights[rp+1]>=heights[i]){
                rp++;
            }
            result=Math.max(result,(rp-lp+1)*heights[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        LangestRectangleArea_timeout langestRectangleArea = new LangestRectangleArea_timeout();
//        int i = langestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        int i = langestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }
}
