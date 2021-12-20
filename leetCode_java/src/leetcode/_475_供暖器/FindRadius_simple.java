package leetcode._475_供暖器;

import java.util.Arrays;

public class FindRadius_simple {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int []results=new int [houses.length];
        //房子右边第一个供暖器
        for(int i=0,index=0;i<results.length;i++){
            while (index<heaters.length && (houses[i]>heaters[index] )){
                index++;
            }
            results[i]=index==heaters.length?Integer.MAX_VALUE:heaters[index]-houses[i];
        }
        int result=Integer.MIN_VALUE;
        //房子左边第一个供暖器
        for(int i=results.length-1,index=heaters.length-1;i>=0;i--){
            while (index>=0 && houses[i]<heaters[index]){
                index--;
            }
            results[i]=index<0?results[i]:Math.min(results[i],houses[i]-heaters[index]);
            //更新结果
            result=Math.max(result,results[i]);
        }
        return result;
    }
    public void test(int []data1,int []data2){
        FindRadius_timeout findRadius_timeout = new FindRadius_timeout();
        FindRadius_simple findRadius = new FindRadius_simple();

        if (findRadius_timeout.findRadius(data1,data2)!=findRadius.findRadius(data1,data2)){
            System.out.println("算错了");
        }else {
            System.out.println("没算错");
        }
    }

    public static void main(String[] args) {
        FindRadius_simple findRadius = new FindRadius_simple();
//        findRadius.findRadius(new int[]{1,2,3},new int []{2});
//        findRadius.findRadius(new int[]{1,2,3,4},new int []{1,4});
//        findRadius.findRadius(new int[]{1,5},new int []{2});

//        findRadius.test(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}
//                ,new int []{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612});
        findRadius.test(new int[]{3,8,9},new int[]{1,2,3,4,5,6,7,8,9});
    }
}
