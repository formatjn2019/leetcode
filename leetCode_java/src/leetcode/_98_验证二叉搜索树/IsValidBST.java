package leetcode._98_验证二叉搜索树;

import leetcode.TreeNode;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return   validTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean validTree(TreeNode root,long bound_min,long bound_max){
        if (root==null){
            return true;
        }
        if (root.val >=bound_max || root.val<= bound_min){
            return false;
        }
                //左子树
        return  validTree(root.left,bound_min, root.val)
                //右子树
                && validTree(root.right,Math.max(bound_min,root.val),bound_max);
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        TreeNode root=TreeNode.createTreeNode(2147483647);
//        TreeNode root=TreeNode.createTreeNode(5, 4,6,-1,-1,3,7);
        System.out.println(isValidBST.isValidBST(root));
    }
}
