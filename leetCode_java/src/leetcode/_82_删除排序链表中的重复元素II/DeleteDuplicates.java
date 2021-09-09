package leetcode._82_删除排序链表中的重复元素II;

import leetcode.ListNode;

import java.util.List;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(),result=newHead;
        for (ListNode willDelete = null, temp = head; temp != null; ) {
            if (temp.next != null && temp.val == temp.next.val) {
                willDelete = temp.next;
            }
            if (willDelete == null || willDelete.val != temp.val) {
                result.next = temp;
                result = result.next;
            }
            temp = temp.next;
            result.next = null;

        }
        return newHead.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(ListNode.listNode(1, 2, 3, 3, 4, 4, 5)));
    }
}
