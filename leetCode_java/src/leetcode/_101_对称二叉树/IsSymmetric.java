package leetcode._101_对称二叉树;

import leetcode.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode lTree, TreeNode rTree) {
        if (lTree == rTree) {
            return true;
        }
        if (lTree == null || rTree == null || lTree.val != rTree.val) {
            return false;
        }
        return isSymmetric(lTree.left, rTree.right) && isSymmetric(lTree.right, rTree.left);
    }
}
