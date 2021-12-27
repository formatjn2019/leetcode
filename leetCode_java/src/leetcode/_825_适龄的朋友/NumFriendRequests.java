package leetcode._825_适龄的朋友;

import leetcode.Tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        Map<Integer,Integer> memory=new HashMap<>();
        int result=0;
        for (int i = 0; i < ages.length; i++) {
            if (!memory.containsKey(ages[i])){
                //目标下界
                double target= 0.5*ages[i]+7;
                //不成立，直接放入0
                if (target>=ages[i]){
                    memory.put(ages[i],0);
                }else {
                    //开始
                    int start=0;
                    int lp=0,rp=ages.length;
                    //二分查找，求下界
                    while (lp<rp){
                        int med=(lp+rp)>>1;
//                        System.out.println(lp+"\t"+rp);
                        if (ages[med]> target){
                            start=med;
                            rp=med;
                        }else {
                            lp=med+1;
                        }
                    }
//                    System.out.print("search"+"\t"+ages[i]+"\t");
//                    System.out.println("start->"+start);
                    start=Math.min(start,i);
                    int end=i;
                    //顺序查找，求上界
                    while (end<ages.length && ages[end]==ages[i]){
                        end++;
                    }
                    //该年龄对应的应发送的好友请求数量
                    memory.put(ages[i],end-start-1);
                }

            }
            result+=memory.get(ages[i]);
        }
//        System.out.println(memory);
        return result;
    }

    private boolean test(int [] testData) {
        NumFriendRequests_timeout numFriendRequests_timeout = new NumFriendRequests_timeout();
        NumFriendRequests numFriendRequests = new NumFriendRequests();
        if (numFriendRequests.numFriendRequests(testData) == numFriendRequests_timeout.numFriendRequests(testData)) {
            System.out.println("成功");
            return true;
        }else {
            System.out.println(Arrays.toString(testData));


            System.out.println();
        }
        return false;
    }

    public static void main(String[] args) {
        Random random =new Random();
        NumFriendRequests numFriendRequests = new NumFriendRequests();
        System.out.println(numFriendRequests.numFriendRequests(new int[]{16, 16}));
        System.out.println(numFriendRequests.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(numFriendRequests.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
//        System.out.println(numFriendRequests.test(new int[]{7, 11, 13, 14, 14, 26, 29, 31, 41, 43, 44, 45, 51, 62, 66, 71, 74}));
//        for(int i=0;i<100;i++){
//            if (!numFriendRequests.test(random.ints(1,120).limit(200).toArray())){
//                break;
//            }
//        }
        System.out.println();
    }
}
