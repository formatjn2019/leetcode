package leetcode._94_二叉树的中序遍历;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        traverse(root,result);
        return result;
    }
    public void traverse(TreeNode root,List<Integer> result){
        if (root==null){
            return;
        }
        traverse(root.left,result);
        result.add(root.val);
        traverse(root.right,result);
    }

    public static void main(String[] args) {
    }
}
