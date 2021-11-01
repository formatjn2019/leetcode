package leetcode._82_删除排序链表中的重复元素II;

import leetcode.ListNode;

import java.util.List;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //哨兵节点
        ListNode newHead = new ListNode(), result = newHead;
        //循环遍历
        for (ListNode willDelete = null, temp = head; temp != null; ) {
            //记录重复节点的值
            if (temp.next != null && temp.val == temp.next.val) {
                willDelete = temp.next;
            }
            //不重复的值进行复制
            if (willDelete == null || willDelete.val != temp.val) {
                result.next = temp;
                result = result.next;
            }
            temp = temp.next;
            //断链
            result.next = null;

        }
        return newHead.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(ListNode.listNode(1, 2, 3, 3, 4, 4, 5)));
    }
}
