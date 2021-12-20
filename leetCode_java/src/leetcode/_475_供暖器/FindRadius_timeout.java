package leetcode._475_供暖器;

import java.util.Arrays;

public class FindRadius_timeout {
    public int findRadius(int[] houses, int[] heaters) {
        int []minClose=new int[houses.length];
        Arrays.fill(minClose,Integer.MAX_VALUE);
        for (int i=0;i<houses.length;i++){
            for (int heater : heaters) {
                minClose[i]=Math.min(minClose[i],Math.abs(heater-houses[i]));
            }
        }
        return Arrays.stream(minClose).max().getAsInt();
    }

    public static void main(String[] args) {
        FindRadius_timeout findRadius = new FindRadius_timeout();
//        findRadius.findRadius(new int[]{1,2,3},new int []{2});
//        findRadius.findRadius(new int[]{1,2,3,4},new int []{1,4});
//        findRadius.findRadius(new int[]{1,5},new int []{2});

        findRadius.findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}
                ,new int []{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612});
    }
}
