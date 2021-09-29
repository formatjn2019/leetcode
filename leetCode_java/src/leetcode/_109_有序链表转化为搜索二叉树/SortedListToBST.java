package leetcode._109_有序链表转化为搜索二叉树;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.ArrayList;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        if (nums.size() == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.size());
    }

    public TreeNode sortedArrayToBST(ArrayList<Integer> nums, int start, int end) {
        if (start == end) {
            return null;
        }
        TreeNode root = new TreeNode(nums.get((start + end) / 2));
        root.left = sortedArrayToBST(nums, start, (start + end) / 2);
        root.right = sortedArrayToBST(nums, (start + end) / 2 + 1, end);
        return root;
    }
}
