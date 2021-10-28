package leetcode._61_旋转链表;

import leetcode.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        int lenth = 1;
        //快指针先跑k个单位
        //然后快慢指针同步跑
        for (; fast.next != head || k > 0; fast = fast.next, k--, lenth++) {
            if (fast.next == null) {
                //首尾相接
                fast.next = head;
                k %= lenth;
            }
            if (k <= 0) {
                slow = slow.next;
            }
        }
        System.out.println(lenth);
        //断链
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode listNode = ListNode.listNode(new int[]{1, 2, 3, 4, 5});


        ListNode listNode1 = rotateRight.rotateRight(listNode, 203);
        System.out.println(listNode1);
    }
}
