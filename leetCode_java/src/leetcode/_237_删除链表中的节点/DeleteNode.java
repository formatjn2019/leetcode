package leetcode._237_删除链表中的节点;

import leetcode.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
