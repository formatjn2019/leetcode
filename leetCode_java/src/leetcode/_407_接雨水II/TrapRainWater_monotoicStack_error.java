package leetcode._407_接雨水II;

import leetcode.Tools;

import java.util.ArrayDeque;

public class TrapRainWater_monotoicStack_error {
    public int trapRainWater(int[][] heightMap) {
        int[][] maxHeight = new int[heightMap.length][heightMap[0].length];
        int[][] maxHeight2 = new int[heightMap.length][heightMap[0].length];
        //拷贝数组
        for (int i = 0; i < heightMap.length; i++) {
            System.arraycopy(heightMap[i], 0, maxHeight[i], 0, heightMap[0].length);
            System.arraycopy(heightMap[i], 0, maxHeight2[i], 0, heightMap[0].length);
        }

        for (int i = 0; i < heightMap.length; i++) {
            getMaxWithMonotonicStack(heightMap, maxHeight, i, true);
        }
        for (int j = 0; j < heightMap[0].length; j++) {
            getMaxWithMonotonicStack(heightMap, maxHeight2, j, false);
        }
        int [][]content=new int[heightMap.length][heightMap[0].length];
        int result=0;
        for (int i=0;i<heightMap.length;i++){
            for (int j=0;j<heightMap[i].length;j++){
                content[i][j]=Math.min(maxHeight[i][j],maxHeight2[i][j]);
                result+=Math.min(maxHeight[i][j],maxHeight2[i][j])-heightMap[i][j];
            }
        }
//
        Tools.showArray(heightMap);
        System.out.println("***************");
        Tools.showArray(maxHeight);
        System.out.println("***************");
        Tools.showArray(maxHeight2);
        System.out.println("_______________");
        Tools.showArray(content);
        return result;
    }
    public void getMaxWithMonotonicStack(int[][] origin, int[][] target, int index, boolean dir) {
        //单减栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //横向
        if (dir) {
            for (int j = 0; j < origin[index].length; j++) {
                //判定的新数值
                while (stack.size() > 0 && origin[index][stack.getFirst()] <= origin[index][j]) {
                    stack.pop();
                    if (stack.size()>0){
                        int max=Math.min(origin[index][stack.getLast()],origin[index][j]);
                        //小的向大移动更新
                        for (int k = stack.getLast() + 1; k < j; k++) {
                            target[index][k] = max;
                        }
                    }

                }
                stack.push(j);
            }
//            System.out.println(Arrays.toString(target[index]));
        }
        //纵向
        else {
            for (int i = 0; i < origin.length; i++) {
                //判定的新数值
                while (stack.size() > 0 && origin[stack.getFirst()][index] <= origin[i][index]) {
                    stack.pop();
                    if (stack.size()>0){
                        int max=Math.min(origin[stack.getLast()][index],origin[i][index]);
                        //小的向大移动更新
                        for (int k = stack.getLast() + 1; k < i; k++) {
                            target[k][index] = max;
                        }
                    }
                }
                stack.push(i);
            }
        }

    }


    public static void main(String[] args) {
        TrapRainWater_monotoicStack_error trapRainWater = new TrapRainWater_monotoicStack_error();
        int i = trapRainWater.trapRainWater(Tools.parseArray("[[12,13,1,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]"));
        System.out.println(i);
    }
}
