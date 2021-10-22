package leetcode._25_K个一组翻转链表;

import leetcode.ListNode;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        //卫语句，防止无用计算
        if (k <2 && head == null){
            return head;
        }
        //翻转用的数组
        ListNode []tempArray=new ListNode[k];
        for (int i=0;i<k;i++){
            if (head==null){
                return tempArray[0];
            }
            tempArray[i]=head;
            head=head.next;
        }
        tempArray[0].next=reverseKGroup(tempArray[k-1].next,k);
        for (int j=k-1;j>0;j--){
            tempArray[j].next=tempArray[j-1];
        }
        return tempArray[k-1];
    }

    public boolean test(ListNode head,int k, String expect){
        String s = ""+head;
        ListNode result = reverseKGroup(head,k);
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
        ReverseKGroup swapPairs=new ReverseKGroup();
        swapPairs.test(ListNode.listNode(1,2,3,4,5),2,"[2,1,4,3,5]");
        swapPairs.test(ListNode.listNode(1,2,3,4,5),3,"[3,2,1,4,5]");
        swapPairs.test(ListNode.listNode(1,2,3,4,5),1,"[1,2,3,4,5]");
        swapPairs.test(ListNode.listNode(1,2,3,4,5,6,7),5,"[5,4,3,2,1,6,7]");
        swapPairs.test(ListNode.listNode(1),1,"[1]");
        swapPairs.test(ListNode.listNode(1),2,"[1]");
    }
}
