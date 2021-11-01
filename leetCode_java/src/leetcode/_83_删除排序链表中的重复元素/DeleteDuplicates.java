package leetcode._83_删除排序链表中的重复元素;

import leetcode.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode temp = head; temp != null; ) {
            if (temp.next != null && temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(ListNode.listNode(1, 1, 1));
    }
}
