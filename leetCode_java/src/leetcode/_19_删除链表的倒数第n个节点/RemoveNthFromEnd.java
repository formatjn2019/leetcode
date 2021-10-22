package leetcode._19_删除链表的倒数第n个节点;

import leetcode.ListNode;

import java.util.List;

public class RemoveNthFromEnd {
    /**
     * Definition for singly-linked list.
     */
    //快慢指针方法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        //快慢指针
        ListNode quick = head, slow = head;
        for (; quick != null; quick = quick.next, n--) {
            if (n < 0) {
                slow = slow.next;
            }
        }
        //当n>0时，慢指针不会进行移动
        if (n < 0) {
            slow.next = slow.next.next;
        } else if (n == 0) {
            return slow.next;
        }
        return head;
    }

    public boolean test(ListNode listNode, int removeIndex, List<List<Integer>> expect) {
        ListNode result = removeNthFromEnd(listNode, removeIndex);
        boolean passed = true;
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        return passed;
    }

    public static void main(String[] aremoveNthFromEndrgs) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.test(ListNode.listNode(new int[]{5, 4, 3, 2, 1}), 2, null);
        removeNthFromEnd.test(ListNode.listNode(new int[]{1}), 1, null);
        removeNthFromEnd.test(ListNode.listNode(new int[]{2, 1}), 1, null);

    }
}
