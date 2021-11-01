package leetcode._102_二叉树的层序遍历;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> levelNodes = List.of(root);
        List<TreeNode> nextLevel;
        do {
            nextLevel = new LinkedList<>();
            List<Integer> tempList = new LinkedList<>();
            result.add(tempList);
            for (TreeNode levelNode : levelNodes) {
                if (levelNode.left != null) {
                    nextLevel.add(levelNode.left);
                }
                tempList.add(levelNode.val);
                if (levelNode.right != null) {
                    nextLevel.add(levelNode.right);
                }
            }
            levelNodes = nextLevel;
        } while (nextLevel.size() > 0);
        return result;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode treeNode = TreeNode.createTreeNode(3, 9, 20, -1, -1, 15, 7);
        List<List<Integer>> lists = levelOrder.levelOrder(treeNode);
        System.out.println(lists);
    }
}
