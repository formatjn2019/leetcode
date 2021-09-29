package leetcode._107_二叉树的层序遍历II;

import leetcode.TreeNode;
import leetcode._102_二叉树的层序遍历.LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> levelNodes = List.of(root);
        List<TreeNode> nextLevel;
        do {
            nextLevel = new LinkedList<>();
            List<Integer> tempList = new LinkedList<>();
            result.add(0,tempList);
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
        LevelOrderBottom levelOrder = new LevelOrderBottom();
        TreeNode treeNode = TreeNode.createTreeNode(3, 9, 20, -1, -1, 15, 7);
        List<List<Integer>> lists = levelOrder.levelOrderBottom(treeNode);
        System.out.println(lists);
    }
}
