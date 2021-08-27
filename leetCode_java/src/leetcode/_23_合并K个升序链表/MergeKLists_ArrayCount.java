package leetcode._23_合并K个升序链表;

import leetcode.ListNode;

import java.util.Arrays;

public class MergeKLists_ArrayCount {
    public ListNode mergeKLists(ListNode[] lists) {
//        哨兵节点
        ListNode preResult=new ListNode(),temp=preResult;
        int numCount[]=new int[20001];
        for (ListNode list : lists) {
            while (list!=null){
                numCount[10000+list.val]++;
                list=list.next;
            }
        }
        for (int i=0;i<numCount.length;i++){
            while (numCount[i]>0){
                temp.next=new ListNode(i-10000);
                temp=temp.next;
                numCount[i]--;
            }
        }
        return preResult.next;
    }
    public boolean test(ListNode[] lists, String expect){
        String s = Arrays.stream(lists)
                .map(Object::toString)
                .reduce((l, r) -> l + "\t\t" + r).orElseGet(()->"");
        ListNode result = mergeKLists(lists);
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
        MergeKLists_ArrayCount mergeKLists = new MergeKLists_ArrayCount();
        mergeKLists.test(new ListNode[]{ListNode.listNode(new int[]{1, 4, 5}),
                ListNode.listNode(new int[]{1, 3,4}),
                ListNode.listNode(new int[]{2,6})},"[1,1,2,3,4,4,5,6]");
        mergeKLists.test(new ListNode[]{},"[]");
        System.out.println();
    }
}
