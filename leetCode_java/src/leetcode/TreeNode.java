package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//     * Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTreeNode(int... nums) {
        List<TreeNode> list=new ArrayList<>();
        list.add(new TreeNode());
        for (int i = 1; i <= nums.length; i++) {
            TreeNode node=new TreeNode(nums[i-1]);
            list.add(node);
            if (node.val!=-1){
                if (i%2==1){
                    list.get(i/2).right=node;
                }else {
                    list.get(i/2).left=node;
                }
            }

        }
        return list.get(1);
    }

    @Override
    public String toString() {
        return "" + val + ",\t" + left + ",\t" + right;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.createTreeNode(2147483647));
    }
}

