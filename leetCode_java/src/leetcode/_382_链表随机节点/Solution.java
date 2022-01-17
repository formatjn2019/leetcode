package leetcode._382_链表随机节点;

import leetcode.ListNode;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Solution {
    private Random rand = null;
    private ArrayList<ListNode> nodes=null;
    public Solution(ListNode head) {
        rand=new Random(head.hashCode()+ System.currentTimeMillis());
        nodes=new ArrayList<>();
        while (head!=null){
            nodes.add(head);
            head=head.next;
        }
    }

    public int getRandom() {
        return nodes.get(rand.nextInt(nodes.size())).val;
    }
}
