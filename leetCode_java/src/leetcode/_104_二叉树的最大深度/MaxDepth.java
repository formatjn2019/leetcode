package leetcode._104_二叉树的最大深度;

import leetcode.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNode(3, 9, 20, -1, -1, 15, 7);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(treeNode));
    }
}
