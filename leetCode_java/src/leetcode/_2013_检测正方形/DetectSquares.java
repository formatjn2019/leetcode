package leetcode._2013_检测正方形;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class DetectSquares {
    HashMap<Integer, Set<Integer>> lines;
    HashMap<Integer, Set<Integer>> rows;
    HashMap<Integer, AtomicInteger> pointCount;
    public DetectSquares() {
        lines=new HashMap<>();
        rows=new HashMap<>();
        pointCount=new HashMap<>();
    }

    public void add(int[] point) {
        lines.computeIfAbsent(point[1],_k->new HashSet<>()).add(point[0]);
        rows.computeIfAbsent(point[0],_k->new HashSet<>()).add(point[1]);
        pointCount.computeIfAbsent(getEigen(point[0],point[1]),_e->new AtomicInteger()).incrementAndGet();
    }

    public int count(int[] point) {
        int result=0;
        //根据行来找列
        for (Integer x : lines.getOrDefault(point[1],Set.of())) {
            for (int y :List.of(point[1]+(point[0]-x),point[1]-(point[0]-x))){
                if (x==point[0] &&y ==point[1]){
                    break;
                }
                if (rows.getOrDefault(point[0],Set.of()).contains(y) && pointCount.containsKey(getEigen(x,y))){
                    result+=pointCount.get(getEigen(x,y)).get()*pointCount.get(getEigen(point[0],y)).get()*pointCount.get(getEigen(x,point[1])).get();
                }
            }
        }


        return result;
    }
    private int getEigen(int x,int y){
        return (x<<10)+y;
    }


    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{0,0});
        detectSquares.add(new int[]{0,1});
        detectSquares.add(new int[]{1,0});
        System.out.println(detectSquares.count(new int[]{1, 1}));
    }
}
