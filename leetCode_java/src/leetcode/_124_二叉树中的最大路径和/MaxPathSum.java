package leetcode._124_二叉树中的最大路径和;

import leetcode.TreeNode;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = {-1001}, singleMax = {-1001};
        max[0] = Math.max(maxPathSum(root, max, singleMax), max[0]);
        //防止所有数字都为负数，返回0
        return singleMax[0] < 0 ? singleMax[0] : max[0];
    }

    public int maxPathSum(TreeNode root, int[] currentMax, int[] currentSingleMax) {
        if (root == null) {
            return -1001;
        } else {
            currentSingleMax[0] = Math.max(currentSingleMax[0], root.val);
        }
        int left = maxPathSum(root.left, currentMax, currentSingleMax);
        int right = maxPathSum(root.right, currentMax, currentSingleMax);
        //左边和右边当前最大值
        currentMax[0] = Math.max(Math.max(left, right), currentMax[0]);
        //左中右连通最大值
        currentMax[0] = Math.max(left + right + root.val, currentMax[0]);
        //和为正数，则返回左和右
        return Math.max(0, Math.max(left, right)) + root.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNode(-2);
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(treeNode));
    }
}
