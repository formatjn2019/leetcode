package leetcode._113_路径总和II;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        pathSum(root, targetSum, result, new ArrayList<>(), 0);
        return result;
    }

    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> results, ArrayList<Integer> memory, int index) {
        if (root == null) {
            return;
        }
        if (index == memory.size()) {
            memory.add(root.val);
        } else {
            memory.set(index, root.val);
        }
        if (root.val == targetSum && root.left == root.right) {
            results.add(memory.subList(0, index + 1));
            return;
        }
        pathSum(root.left, targetSum - root.val, results, memory, index + 1);
        pathSum(root.right, targetSum - root.val, results, memory, index + 1);
    }

    public static void main(String[] args) {

    }
}
