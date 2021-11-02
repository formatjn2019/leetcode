package leetcode._145_二叉树的后序遍历;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal(root, new ArrayList<>());
    }

    public List<Integer> postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return List.of();
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
        return result;
    }

    public static void main(String[] args) {

    }
}
