package leetcode._106_从中序遍历与后序遍历转换为二叉树;

import leetcode.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class BuildingTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length ==0){
            return null;
        }
        return buildTree(postorder,new AtomicInteger(postorder.length-1),inorder,0,inorder.length);

    }
    public TreeNode buildTree(int[] postorder, AtomicInteger start, int[] inorder, int start2, int end2) {
        if (end2-start2<=0){
            return null;
        }
        TreeNode root=new TreeNode(postorder[start.getAndDecrement()]);
        int endIndex= searchIndex(inorder,start2,end2,root.val);
        root.right=buildTree(postorder,start,inorder,endIndex+1,end2);
        root.left=buildTree(postorder,start,inorder,start2,endIndex);
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
