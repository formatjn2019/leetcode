package leetcode._105_从前序遍历和中序遍历序列构造二叉树;

import leetcode.TreeNode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class BuildingTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length ==0){
            return null;
        }
        return buildTree(preorder,new AtomicInteger(),inorder,0,inorder.length);
    }
    public TreeNode buildTree(int[] preorder, AtomicInteger start, int[] inorder, int start2, int end2) {
        if (end2-start2<=0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[start.getAndIncrement()]);
        int endIndex= searchIndex(inorder,start2,end2,root.val);
        root.left=buildTree(preorder,start,inorder,start2,endIndex);
        root.right=buildTree(preorder,start,inorder,endIndex+1,end2);
        return root;
    }

    public int searchIndex(int []arr,int start,int end,int key){
        for (int i=start;i<end;i++){
            if (arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BuildingTree buildingTree = new BuildingTree();
        TreeNode treeNode = buildingTree.buildTree(new int[]{1, 2, 3}, new int[]{2,  3, 1});
        System.out.println(treeNode);

    }
}
