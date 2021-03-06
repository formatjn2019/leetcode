package leetcode._111_二叉树的最小深度;

import leetcode.TreeNode;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==root.right){
            return 1;
        }
        if (root.left==null || root.right==null){
            return Math.max(minDepth(root.left),minDepth(root.right))+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
