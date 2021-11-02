package leetcode._144_二叉树的前序遍历;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_stack {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        for (TreeNode tempNode = root; stack.size() > 0 || tempNode != null; ) {
            //入栈
            while (tempNode != null) {
                result.add(tempNode.val);
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            //出栈
            tempNode = stack.pop().right;
        }
        return result;
    }

}
