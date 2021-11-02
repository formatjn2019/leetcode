package leetcode._145_二叉树的后序遍历;

import leetcode.ListNode;
import leetcode.TreeNode;
import leetcode._144_二叉树的前序遍历.PreorderTraversal;
import leetcode._144_二叉树的前序遍历.PreorderTraversal_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal_stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        for (TreeNode tempNode = root; stack.size() > 0 || tempNode != null; ) {
            while (tempNode != null) {
                result.add(0, tempNode.val);
                stack.push(tempNode);
                tempNode = tempNode.right;
            }
            tempNode = stack.pop().left;
        }
        return result;
    }

    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        PostorderTraversal_stack postorderTraversal_stack = new PostorderTraversal_stack();
        TreeNode treeNode = TreeNode.createTreeNode(5, 3, 4, 1, 2);
        System.out.println(postorderTraversal_stack.postorderTraversal(treeNode));
        System.out.println(postorderTraversal.postorderTraversal(treeNode));
    }
}
