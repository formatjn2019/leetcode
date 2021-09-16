package leetcode._92_反转链表II;

import leetcode.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right){
            return head;
        }
        ListNode newHead=new ListNode(0,head);
        ListNode fp=head,lp=newHead;
        //移动到翻转开始的节点
        for (int i=1;i<left;i++){
            fp=fp.next;
            lp=lp.next;
        }
        ListNode lastHead=null,mediumHead=null;
        //翻转
        for (ListNode tpl=lp.next,tpr=fp.next;right!=left;right--){
            //下一个
            lastHead=tpr.next;
            //当前
            mediumHead=tpr;
            //前一个
            tpr.next=tpl;
            tpl=tpr;
            tpr=lastHead;
        }
        fp.next=lastHead;
        lp.next=mediumHead;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.listNode(1, 2, 3, 4, 5);
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode listNode1 = reverseBetween.reverseBetween(listNode, 1, 2);
        System.out.println(listNode1);
    }
}
