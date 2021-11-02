package leetcode._144_二叉树的前序遍历;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<>());
    }

    public List<Integer> preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return List.of();
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
        return result;
    }
}
