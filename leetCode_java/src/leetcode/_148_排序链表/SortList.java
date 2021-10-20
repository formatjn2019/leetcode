package leetcode._148_排序链表;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> integers=new ArrayList<>();
        for (ListNode temp=head;temp!=null;temp=temp.next){
            integers.add(temp.val);
        }
        integers.sort(Integer::compare);
        ListNode temp=head;
        for (Integer integer : integers) {
            temp.val=integer;
            temp=temp.next;
        }
        return head;
    }


}
