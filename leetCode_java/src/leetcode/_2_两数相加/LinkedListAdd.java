package leetcode._2_两数相加;

public class LinkedListAdd {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result =new ListNode(),temp=result;
            int carry = 0;
            for (int v1,v2,sum;l1!=null || l2!=null; temp=temp.next){
                v1=v2=0;
                if (l1 != null){
                    v1=l1.val;
                    l1=l1.next;
                }
                if (l2 != null){
                    v2=l2.val;
                    l2=l2.next;
                }
                sum = carry + v1 + v2;
                carry = sum >=10 ? 1 : 0;
                temp.val=sum%10;

                if(l1!=null || l2!=null) {
                    temp.next = new ListNode();
                }else {
                    if (carry !=0){
                        temp.next=new ListNode(1);
                    }
                }

            }
            return result;
        }


    }

    static ListNode changeNumToListNode(long num){
        String str = num + "";
        int bound = str.length();
        ListNode result=null;
        for (int index = 0; index < bound; index++) {
            int i = str.charAt(index) - '0';
            result = new ListNode(i,result);
//            System.out.println(listNode.val);
        }

        return result;
    }

    static void printListNode(ListNode listNode){
        for (;listNode!=null;listNode=listNode.next){
            System.out.println(listNode.val);
        }
    }


    public static void main(String[] args) {
        Solution st = new Solution();
        ListNode l1 = changeNumToListNode(9999);

        ListNode l2 = changeNumToListNode(9999999);
        ListNode result = st.addTwoNumbers(l1,l2);
        printListNode(result);
    }
}
