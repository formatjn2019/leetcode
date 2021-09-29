package leetcode._112_路径总和;

import leetcode.TreeNode;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.val == targetSum && root.left==root.right){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
    public static void main(String[] args) {

    }
}
