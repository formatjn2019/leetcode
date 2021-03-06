package leetcode._114_二叉树展开为链表;

import leetcode.TreeNode;

import java.util.Optional;

public class Flatten {
    public void flatten(TreeNode root) {
        //卫语句
        if (root == null) {
            return;
        }
        flatten(root, new TreeNode[]{new TreeNode()});
    }
    //先序遍历，用数组传递下一个复制的元素的指针
    public void flatten(TreeNode root, TreeNode[] pre) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        pre[0].right = root;
        pre[0] = root;
        flatten(root.left, pre);
        flatten(right, pre);
        root.left = null;

    }
}
