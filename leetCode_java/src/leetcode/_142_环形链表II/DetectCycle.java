package leetcode._142_环形链表II;

import leetcode.ListNode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode result = null;
        //快慢指针
        for (ListNode slow = head, fast = head; fast != null; ) {
            fast = fast == null ? fast : fast.next;
            fast = fast == null ? fast : fast.next;
            slow = slow.next;
            if (slow != null && fast == slow) {
                result = fast;
                break;
            }
        }
        if (result != null) {
            while (head != result) {
                head = head.next;
                result = result.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
