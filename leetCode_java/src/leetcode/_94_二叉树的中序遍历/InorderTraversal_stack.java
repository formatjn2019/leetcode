package leetcode._94_二叉树的中序遍历;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal_stack {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;
//        stack.push(temp);
        while (temp != null || stack.size() != 0) {
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                temp=pop.right;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(root));
        InorderTraversal_stack inorderTraversal_stack = new InorderTraversal_stack();
        System.out.println(inorderTraversal_stack.inorderTraversal(root));

    }

}
