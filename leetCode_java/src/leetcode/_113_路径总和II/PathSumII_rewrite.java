package leetcode._113_路径总和II;

import leetcode.TreeNode;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_rewrite {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return List.of();
        }
        //有效结果
        if (root.val == targetSum && root.left == root.right) {
            LinkedList<Integer> item = new LinkedList<>();
            item.add(root.val);
            return List.of(item);
        }
        List<List<Integer>> result = new LinkedList<>();
        result.addAll(pathSum(root.left, targetSum - root.val));
        result.addAll(pathSum(root.right, targetSum - root.val));
        result.forEach(item->item.add(0,root.val));
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNode(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1);
        PathSumII_rewrite pathSumII_rewrite = new PathSumII_rewrite();
        pathSumII_rewrite.pathSum(treeNode, 22);
    }
}
