package leetcode._148_排序链表;

import leetcode.ListNode;

public class SortList_insertSort {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode lastSorted = head;
        while (lastSorted.next != null) {
            //不用移动的情况
            if (lastSorted.val <= lastSorted.next.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode moveNode = lastSorted.next;
                lastSorted.next = lastSorted.next.next;
                ListNode temp = sentinel;
                while (temp.next.val < moveNode.val) {
                    temp = temp.next;
                }
                moveNode.next = temp.next;
                temp.next = moveNode;
            }
        }
        return sentinel.next;
    }

}
