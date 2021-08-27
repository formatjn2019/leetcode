package leetcode._24_两两交换链表中节点;

import leetcode.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode second= head.next;
        head.next=swapPairs(second.next);
        second.next= head;
        return second;
    }

    public boolean test(ListNode head, String expect){
        String s = ""+head;
        ListNode result = swapPairs(head);
        boolean passed=result==null?(""+result).equals("null"):result.toString().equals(expect);

        if (!passed){
            System.out.println("失败");
            System.out.println(s);
            System.out.println("结果:"+result+"\t期望\t："+expect);
        }else {
            System.out.println("成功");
        }
        return passed;
    }
    public static void main(String[] args) {
        SwapPairs swapPairs=new SwapPairs();
        swapPairs.test(ListNode.listNode(1,2,3,4),"[2,1,4,3]");
        swapPairs.test(ListNode.listNode(1,2,3,4,5,6),"[2,1,4,3,6,5]");
        swapPairs.test(ListNode.listNode(1),"[1]");
        swapPairs.test(ListNode.listNode(1,3,2),"[3,1,2]");
    }
}
