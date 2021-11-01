package leetcode._110_平衡二叉树;

import leetcode.TreeNode;

import java.util.concurrent.atomic.AtomicBoolean;

public class IsBalance {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root, new AtomicBoolean(true));
    }

    public boolean isBalanced(TreeNode root, AtomicBoolean atomicBoolean) {
        if (root == null) {
            return true;
        }
        if (atomicBoolean.get()) {
            atomicBoolean.set(Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2);
            return atomicBoolean.get() && isBalanced(root.left, atomicBoolean) && isBalanced(root.right, atomicBoolean);
        } else {
            return false;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
