package leetcode._143_重排链表;

import leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ReorderList {
    public void reorderList(ListNode head) {
        System.out.println(head);
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            stack.add(temp);
        }
        for (ListNode temp = stack.pollFirst(); stack.size() > 0; ) {
            temp.next = stack.pollLast();
            temp = temp.next;
            if (stack.size() > 0) {
                temp.next = stack.pollFirst();
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(ListNode.listNode(1, 2, 3, 4, 5, 6));
    }
}
