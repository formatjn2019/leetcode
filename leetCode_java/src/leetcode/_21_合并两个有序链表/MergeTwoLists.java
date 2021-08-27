package leetcode._21_合并两个有序链表;

import leetcode.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode result;
        //pr 主线指针，pt为副线指针
        if (l1.val<l2.val){
            result=l1;
            l1=l1.next;
        }else {
            result=l2;
            l2=l2.next;
        }
        for (ListNode temp=result;;temp=temp.next){
            if (l1==null || l2==null){
                temp.next=l1==null?l2:l1;
                break;
            }
            if (l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else {
                temp.next=l2;
                l2=l2.next;;
            }
        }
        return result;
    }

    public boolean test(ListNode l1,ListNode l2, String expect){
        String s = ""+l1+ l2;
        ListNode result = mergeTwoLists(l1,l2);
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
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.test(ListNode.listNode(new int[]{1,2,4}),ListNode.listNode(new int[]{1,3,4}),"[1,1,2,3,4,4]");
        mergeTwoLists.test(ListNode.listNode(new int[]{}),ListNode.listNode(new int[]{1}),"[1]");
        mergeTwoLists.test(ListNode.listNode(new int[]{}),ListNode.listNode(new int[]{}),"null");
        mergeTwoLists.test(ListNode.listNode(new int[]{1,1,1}),ListNode.listNode(new int[]{1,1,1,1}),"[1,1,1,1,1,1,1]");
        mergeTwoLists.test(ListNode.listNode(new int[]{2}),ListNode.listNode(new int[]{1}),"[1,2]");
    }
}
