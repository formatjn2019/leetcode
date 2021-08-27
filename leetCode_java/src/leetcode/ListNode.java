package leetcode;

public class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//        public static ListNode listNode(int []nums){
//                ListNode pre=null,result=null;
//                for (int num:nums){
//                        if (result==null){
//                                result=new ListNode(num);
//                                pre=result;
//                        }else {
//                                pre.next=new ListNode(num);
//                                pre=pre.next;
//                        }
//                }
//                return result;
//        }

        public static ListNode listNode(int  ... nums){
                ListNode pre=null,result=null;
                for (int num:nums){
                        if (result==null){
                                result=new ListNode(num);
                                pre=result;
                        }else {
                                pre.next=new ListNode(num);
                                pre=pre.next;
                        }
                }
                return result;
        }
        @Override
        public String toString() {
                StringBuilder sb=new StringBuilder();
                sb.append('[');
                sb.append(val);
                ListNode temp = this;
                while(temp.next!=null){
                        sb.append(',');
                        sb.append(temp.next.val);
                        temp=temp.next;
                }
                sb.append(']');
                return sb.toString();
        }

        public static void main(String[] args) {
                System.out.println(listNode(new int[]{1,2,3,4,5}));
                System.out.println(listNode(new int[]{}));
        }
}
