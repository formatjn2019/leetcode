package leetcode._99_恢复搜索二叉树;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecoverTree {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        traverseTree(root,nums);
        nums.sort(Integer::compareTo);
        resetTree(root,nums.iterator());
    }

    public void traverseTree(TreeNode root, List<Integer> vals){
        if (root.left!=null){
            traverseTree(root.left,vals);
        }
        vals.add(root.val);
        if (root.right!=null){
            traverseTree(root.right,vals);
        }
    }
    public void resetTree(TreeNode root,Iterator<Integer> iterator){
        if (root.left!=null){
            resetTree(root.left,iterator);
        }
        root.val=iterator.next();
        if (root.right!=null){
            resetTree(root.right,iterator);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNode(3,1,-1,-1,2);
        RecoverTree recoverTree = new RecoverTree();
        recoverTree.recoverTree(treeNode);
    }
}
