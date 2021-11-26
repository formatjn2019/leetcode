package leetcode._700_二叉搜索树中的搜索;

import leetcode.TreeNode;

public class SearchBFS {
    public TreeNode searchBST(TreeNode root, int val) {
        return root == null || root.val == val ? root
                : root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}

