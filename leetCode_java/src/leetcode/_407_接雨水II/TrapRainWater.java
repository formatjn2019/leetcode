package leetcode._407_接雨水II;

import leetcode.Tools;

import java.util.*;

public class TrapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int height = heightMap.length, width = heightMap[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = 0;
        //链表表示，手动操作
        LinkedList<List<Integer>> extendArray = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //边界点
                if (i == 0 || j == 0 || i == heightMap.length - 1 || j == heightMap[i].length - 1) {
                    insertNumToStack(extendArray, heightMap[i][j], i, j);
                }
            }
        }
        HashSet<List<Integer>> completePoint = new HashSet<>(height * width);
        completePoint.addAll(extendArray);
        while (extendArray.size() > 0) {
            List<Integer> extendNode = extendArray.removeFirst();
            completePoint.add(extendNode);
            for (int[] dir : dirs) {
                int i = dir[0] + extendNode.get(1);
                int j = dir[1] + extendNode.get(2);
                //点符合要求和未被使用
                if (i >= 0 && i < height && j >= 0 && j < width && !completePoint.contains(List.of(heightMap[i][j], i, j))) {
                    System.out.println(i+"\t\t"+j);
                    Tools.showArray(heightMap);
                    //更新节点大小
                    if (heightMap[i][j]<extendNode.get(0)){
                        result+=extendNode.get(0)-heightMap[i][j];
                        heightMap[i][j]=extendNode.get(0);
                    }
                    //将新的点数增加到要扩展的位置
                    insertNumToStack(extendArray,heightMap[i][j],i,j);
                }
            }
        }
        return result;
    }

    public void insertNumToStack(LinkedList<List<Integer>> list, int num, int x, int y) {
        List<Integer> item = List.of(num, x, y);
        int index = 0;
        while (index < list.size() && list.get(index).get(0) < num) {
            index++;
        }
        list.add(index, item);

    }

    public static void main(String[] args) {
        TrapRainWater trapRainWater = new TrapRainWater();
        int i = trapRainWater.trapRainWater(Tools.parseArray("[[12,13,1,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]"));
        System.out.println(i);
    }
}
