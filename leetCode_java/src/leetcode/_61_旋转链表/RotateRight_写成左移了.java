package leetcode._61_旋转链表;

import leetcode.ListNode;

public class RotateRight_写成左移了 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        ListNode fast = head, slow = head;
        boolean concat = false;
        //快指针先跑k个单位
        for (; k > 0; fast = fast.next, k--) {
            if (fast.next == null) {
                fast.next = head;
                concat = true;
            }
        }
        //慢指针追赶快指针
        while (slow.next != fast) {
            slow = slow.next;
        }
        //慢指针断开
        slow.next = null;
        //快慢指针同步
        slow = fast;
        //快指针连接两段的链表
        while (!concat) {
            if (fast.next == null) {
                fast.next = head;
                concat = true;
            }
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
