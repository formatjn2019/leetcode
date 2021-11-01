package leetcode._84_柱状图中最大的矩形;

public class LangestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        return binarySearch(heights, 0, heights.length, 0);
    }

    //在指定范围内求面积的最大值
    public int binarySearch(int[] heights, int start, int end, int pre) {
        //当范围溢出数组时，返回
        if (start == heights.length) {
            return pre;
        }
        //当查找范围为1个元素的数组时，判定其和当前最大面积，返回最大值
        if (start == end) {
            return Math.max(heights[start], pre);
        }
        //最小值索引，最小值，最大值
        int index = start, min = heights[start], max = heights[start];
        //顺序查找整个数组，找到最小值和最大值，以及最小值的索引
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < min) {
                min = heights[i];
                index = i;
            } else if (heights[i] > max) {
                max = heights[i];
            }
        }

        //更新最大值
        //当前搜索到的最大面积就是，最小值乘数组长度与原先面积的最大值
        pre = Math.max(pre, (end - start) * min);
        //剪枝
        //当区间内的元素都相同，即最大值和最小值相同时，不再向下搜索
        if (max != min) {
            //否则将数组从最小值处分为两半，再次搜索
            //剪枝
            //当最大值与分开数组范围的乘积小于当前最优值时，不再向下搜索
            if (pre < (index - start) * max) {
                pre = binarySearch(heights, start, index, pre);
            }
            if (pre < (end - index - 1) * max) {
                pre = binarySearch(heights, index + 1, end, pre);
            }
        }
        return pre;
    }


    public static void main(String[] args) {
        LangestRectangleArea langestRectangleArea = new LangestRectangleArea();
        int i = langestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
//        int i = langestRectangleArea.largestRectangleArea(new int[]{2,4});
        System.out.println(i);
    }
}
