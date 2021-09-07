package leetcode._61_旋转链表;

import leetcode.ListNode;

public class RotateRight_timeout {
    public ListNode rotateRight(ListNode head, int k) {
        if (k==0 || head==null){
            return head;
        }
        ListNode fast=head,slow=head;
        //快指针先跑k个单位
        //然后快慢指针同步跑
        for (;fast.next!=head || k>0;fast=fast.next,k--){
            if (fast.next==null){
                fast.next=head;
            }
            if (k<=0){
                slow=slow.next;
            }
        }
        head=slow.next;
        slow.next=null;
        return head;
    }
    public static void main(String[] args) {
        RotateRight_timeout rotateRight = new RotateRight_timeout();
        ListNode listNode = ListNode.listNode(new int[]{1, 2, 3, 4, 5});


        ListNode listNode1 = rotateRight.rotateRight(listNode, 2);
        System.out.println(listNode1);
    }
}
