package leetcode._138_复制带随机指针的链表;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> newNodes = new HashMap<>();
        //新节点生成
        for (Node temp = head; temp != null; temp = temp.next) {
            newNodes.put(temp, new Node(temp.val));
        }
        //新节点互联
        for (Node temp = head; temp != null; temp = temp.next) {
            Node node = newNodes.get(temp);
            node.next = newNodes.getOrDefault(temp.next, null);
            node.random = newNodes.getOrDefault(temp.random, null);
        }
        return newNodes.get(head);
    }
}
