package leetcode._108_将有序数组转换为二叉搜索树;

import leetcode.TreeNode;
import leetcode._104_二叉树的最大深度.MaxDepth;

import java.util.stream.IntStream;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        TreeNode root = new TreeNode(nums[(start + end) / 2]);
        root.left = sortedArrayToBST(nums, start, (start + end) / 2);
        root.right = sortedArrayToBST(nums, (start + end) / 2 + 1, end);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        MaxDepth maxDepth = new MaxDepth();
        for (int i = 0; i < 120; i++) {
            int[] ints = IntStream.range(0, i)
                    .toArray();
            TreeNode x = sortedArrayToBST.sortedArrayToBST(ints);
            if (x != null) {
                System.out.println(maxDepth.maxDepth(x.left) + "\t\t" + maxDepth.maxDepth(x.right));
            }
        }
    }
}
