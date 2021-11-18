package leetcode._563_二叉树的坡度;

import leetcode.TreeNode;

public class FindTilt {
    public int findTilt(TreeNode root) {
        int []result=new int[1];
        findTilt(root,result);
        return result[0];
    }

    public int findTilt(TreeNode root,int []sum){
        if (root==null){
            return 0;
        }
        int left = findTilt(root.left,sum);
        int right = findTilt(root.right,sum);
        sum[0]+=Math.abs(left-right);
        return left+right+root.val;
    }
}
