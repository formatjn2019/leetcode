package leetcode._103_二叉树的锯齿形层序遍历;

import leetcode.TreeNode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> levelNodes = new ArrayDeque<>();
        levelNodes.add(root);
        ArrayDeque<TreeNode> nextLevel;
        boolean dir = true;
        do {
            nextLevel = new ArrayDeque<>();
            List<Integer> tempList = new LinkedList<>();
            result.add(tempList);
            while (levelNodes.size() > 0) {
                if (dir) {
                    TreeNode levelNode = levelNodes.removeFirst();
                    if (levelNode.left != null) {
                        nextLevel.add(levelNode.left);
                    }
                    tempList.add(levelNode.val);
                    if (levelNode.right != null) {
                        nextLevel.add(levelNode.right);
                    }
                } else {
                    TreeNode levelNode = levelNodes.removeLast();
                    if (levelNode.right != null) {
                        nextLevel.addFirst(levelNode.right);
                    }
                    tempList.add(levelNode.val);
                    if (levelNode.left != null) {
                        nextLevel.addFirst(levelNode.left);
                    }
                }
            }
            levelNodes = nextLevel;
            dir = !dir;
        } while (nextLevel.size() > 0);
        return result;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder levelOrder = new ZigzagLevelOrder();
        TreeNode treeNode = TreeNode.createTreeNode(3, 9, 20, -1, -1, 15, 7);
        List<List<Integer>> lists = levelOrder.zigzagLevelOrder(treeNode);
        System.out.println(lists);
    }
}
