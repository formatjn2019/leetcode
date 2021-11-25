package leetcode._458_可怜的小猪;

import leetcode.Tools;

import java.util.Arrays;

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int state = minutesToTest / minutesToDie+1;
        return  (int) Math.ceil(Math.log(buckets) / Math.log(state));
    }

    public static void main(String[] args) {
        System.out.println(Math.log(8) / Math.log(2));
        System.out.println(Math.ceil(Math.log(1000) / Math.log(2)));
        PoorPigs poorPigs = new PoorPigs();
        System.out.println(poorPigs.poorPigs(25, 15, 60));
        //        poorPigs.poorPigs(1000,15,80);
    }
}
