package leetcode._141_环形链表;

import leetcode.ListNode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        //快慢指针
        for (ListNode slow = head, fast = head; slow != null; slow = slow.next) {
            fast = fast == null ? fast : fast.next;
            fast = fast == null ? fast : fast.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
