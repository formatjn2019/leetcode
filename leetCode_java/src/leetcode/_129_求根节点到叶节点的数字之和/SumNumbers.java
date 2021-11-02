package leetcode._129_求根节点到叶节点的数字之和;

import leetcode.TreeNode;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        int[] result = {0};
        sumNumbers(root, result, 0);
        return result[0];
    }

    public void sumNumbers(TreeNode root, int[] sum, int pre) {
        pre = pre * 10 + root.val;
        //叶节点求和
        if (root.left == null && root.right == null) {
            sum[0] += pre;
        } else {
            if (root.left != null) {
                sumNumbers(root.left, sum, pre);
            }
            if (root.right != null) {
                sumNumbers(root.right, sum, pre);
            }
        }
    }
}
