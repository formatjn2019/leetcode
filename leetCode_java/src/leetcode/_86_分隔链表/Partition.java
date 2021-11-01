package leetcode._86_分隔链表;

import leetcode.ListNode;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        //哨兵节点
        ListNode newHead = new ListNode(), newNext = new ListNode();
        ListNode tp1 = newHead, tp2 = newNext;
        for (; head != null; head = head.next) {
            if (head.val < x) {
                tp1.next = head;
                tp1 = tp1.next;
            } else {
                tp2.next = head;
                tp2 = tp2.next;
            }
        }
        tp1.next = newNext.next;
        tp2.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.listNode(1);
        Partition partition = new Partition();
        System.out.println(partition.partition(listNode, 2));
    }
}
