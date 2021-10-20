package leetcode._147_对链表进行插入排序;

import leetcode.ListNode;

import java.util.LinkedHashMap;
import java.util.List;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode sentinel=new ListNode(Integer.MIN_VALUE,head);
        ListNode lastSorted=head;
        while (lastSorted.next!=null){
            //不用移动的情况
            if (lastSorted.val<=lastSorted.next.val){
                lastSorted=lastSorted.next;
            }else {
                ListNode moveNode=lastSorted.next;
                lastSorted.next=lastSorted.next.next;
                ListNode temp=sentinel;
                while (temp.next.val< moveNode.val){
                    temp=temp.next;
                }
                moveNode.next=temp.next;
                temp.next=moveNode;
            }
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode listNode = ListNode.listNode(5, 2, 4, 1, 6, 1, 9);
        System.out.println(insertionSortList.insertionSortList(listNode));
    }
}
