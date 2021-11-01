package leetcode._95_不同的二叉搜索树II;

import leetcode.TreeNode;
import leetcode._94_二叉树的中序遍历.InorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new LinkedList<>();

        boolean[] memoryArray = new boolean[n];
        for (int i = 0; i < memoryArray.length; i++) {
            memoryArray[i] = true;
            TreeNode root = new TreeNode(i + 1);
            generateTree(memoryArray, root, result, 1);
            memoryArray[i] = false;
        }
        Map<String, TreeNode> resultDistinct = result.stream()
                .collect(Collectors.toMap(treeNode -> {
                    StringBuilder sb = new StringBuilder();
                    gemerateTreeNodeId(treeNode, sb);
                    return sb.toString();
                }, i -> i, (i, j) -> i));
        return new ArrayList<>(resultDistinct.values());
    }

    public void generateTree(boolean[] memory, TreeNode root, List<TreeNode> results, int level) {
        if (level == memory.length) {
            results.add(cloneTree(root));
            return;
        }
        for (int i = 0; i < memory.length; i++) {
            if (!memory[i]) {
                int num = i + 1;
                TreeNode temp = root;
                boolean leftOrRight = false;
                //插入二叉树
                while (true) {
                    //左边
                    if (num < temp.val) {
                        if (temp.left == null) {
                            temp.left = new TreeNode(num);
                            break;
                        }
                        temp = temp.left;
                    }//右边
                    else {
                        if (temp.right == null) {
                            temp.right = new TreeNode(num);
                            leftOrRight = true;
                            break;
                        }
                        temp = temp.right;
                    }
                }
                memory[i] = true;
                generateTree(memory, root, results, level + 1);
                //销掉
                if (leftOrRight) {
                    temp.right = null;
                } else {
                    temp.left = null;
                }
                memory[i] = false;
            }
        }


    }

    public void gemerateTreeNodeId(TreeNode treeNode, StringBuilder sb) {
        if (treeNode == null) {
            sb.append("null");
        } else {
            sb.append(treeNode.val);
            gemerateTreeNodeId(treeNode.left, sb);
            gemerateTreeNodeId(treeNode.right, sb);
        }
    }


    public TreeNode cloneTree(TreeNode origin) {
        TreeNode result = new TreeNode(origin.val);
        if (origin.left != null) {
            result.left = cloneTree(origin.left);
        }
        if (origin.right != null) {
            result.right = cloneTree(origin.right);
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
//        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        InorderTraversal inorderTraversal = new InorderTraversal();
//        System.out.println(inorderTraversal.inorderTraversal(root));
//        System.out.println(root);
//        TreeNode newRoot=generateTrees.cloneTree(root);
//        System.out.println(inorderTraversal.inorderTraversal(newRoot));
//        System.out.println(newRoot);
        List<TreeNode> treeNodes = generateTrees.generateTrees(3);
        treeNodes.stream()
//                .map(inorderTraversal::inorderTraversal)
                .forEach(System.out::println);

    }
}
